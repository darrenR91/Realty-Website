/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.servlets;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.coobird.thumbnailator.Thumbnails;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import src.db.AgentsDB;
import src.db.GaragetypesDB;
import src.db.PropertiesDB;
import src.db.PropertytypeDB;
import src.db.StylesDB;
import src.entities.Agents;
import src.entities.Garagetypes;
import src.entities.Properties;
import src.entities.Propertytypes;
import src.entities.Styles;

/**
 *
 * @author Darren
 */
@ServletSecurity(@HttpConstraint(rolesAllowed={"admin","agent"}))
public class ManagePropertys extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     
     * 
     */
    private static final long serialVersionUID = 1L;
     
    // location to store file uploaded
    private static final String UPLOAD_DIRECTORY = "images\\properties";
 
    // upload settings
    private static final int MEMORY_THRESHOLD   = 1024 * 1024 * 3;  // 3MB
    private static final int MAX_FILE_SIZE      = 1024 * 1024 * 40; // 40MB
    private static final int MAX_REQUEST_SIZE   = 1024 * 1024 * 50; // 50MB
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ManagePropertys</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ManagePropertys at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try(PrintWriter out = response.getWriter()) {
            String address="";
            Map m = request.getParameterMap();
            
            Agents LoggedIn = null;
                    try
                    {
                        LoggedIn = AgentsDB.getByUsername(request.getUserPrincipal().getName()); 
                        //request.setAttribute("agent", agent);

                        }//end try
                    catch (Exception ex) {
                        address = "/Error.jsp";
                    }
            int agentId= 0;
            agentId= LoggedIn.getAgentId();
            
            if (request.getParameterMap().containsKey("del"))
            {
                
                Properties propertyDetails = PropertiesDB.getPropertyByID(Integer.parseInt(request.getParameter("del")));
                if((propertyDetails!=null && propertyDetails.getAgentId().equals(agentId)) || request.isUserInRole("admin"))
                {
                        PropertiesDB.deleteProperty(propertyDetails.getId());
                
                        String uploadPath = getServletContext().getRealPath("")+ File.separator + UPLOAD_DIRECTORY;
                        String filePath = uploadPath + File.separator+"large"+ File.separator+ propertyDetails.getPhoto();
                        String filePathThumbnail = uploadPath + File.separator+"thumbnails"+ File.separator+propertyDetails.getPhoto();
                        
                        File storeFileThumbnail = new File(filePathThumbnail);
                        File storeFile = new File(filePath);
                        
                        storeFile.delete();
                        storeFileThumbnail.delete();
                        
                        address = "ManagePropertys?GetProperties&Status=2"; 
                }
               response.sendRedirect("/RealtyWebsite/"+address);
                processRequest(request, response);
            }
            else
            {
                List<Styles> allStylesList  = StylesDB.getAllStyles();
                List<Propertytypes> allPropertyTypesList  = PropertytypeDB.getAllPropertytypes();
                List<Garagetypes> allGarageTypesList  = GaragetypesDB.getAllGaragetypes();
                
                if (request.getParameterMap().containsKey("AddNewProperty"))//Add new property
                {
                    address = "admin/addNewProperty.jsp"; 
                    String status ="";
                    if(request.isUserInRole("admin"))
                                {
                                    List<Agents> allAgents = null;
                                    try {
                                        allAgents = AgentsDB.getAllAgents();
                                        }//end try
                                            catch (Exception ex) {
                                            address = "/Error.jsp";
                                        }//end catch
                                address = "admin/addNewProperty.jsp"; 
                                request.setAttribute("allAgents", allAgents);
                                }
                                else
                                {
                                address = "agent/addNewProperty.jsp"; 
                                }
                    request.setAttribute("Styles", allStylesList);
                    request.setAttribute("Propertytypes", allPropertyTypesList);
                    request.setAttribute("Garagetypes", allGarageTypesList);    
                }
                else
                {   //View properties by agent
                    if (request.getParameterMap().containsKey("Status"))
                    {
                    int status =Integer.parseInt(request.getParameter("Status"));
                    //String status=request.getParameter("Status");
                        if(status==1)
                        {
                            request.setAttribute("Status","This Property Has Been Saved/Updated successfully!");
                        }
                        if(status==2)
                        {
                            request.setAttribute("Status","The Property Has Been successfully Removed!");
                        }
                    }
                    
                    List<Properties> propertyList = null;
                    if(request.isUserInRole("admin"))
                        {
                        propertyList = PropertiesDB.getAllProperties();
                        address = "admin/managePropertyList.jsp";
                        }
                        else
                        {
                        propertyList = PropertiesDB.getAllPropertiesByAgent(agentId);
                        
                        address = "/agent/managePropertyList.jsp";
                        }
                    request.setAttribute("propertyList", propertyList); 
                }
                if(m.containsKey("propID") && ( m.containsKey("agentId") || (request.isUserInRole("admin")) ) ) 
                { 
                    String StyleType="";
                    String PropType="";
                    String GarageType="";

                  try {
                        Properties propertyDetails = PropertiesDB.getPropertyByID(Integer.parseInt(request.getParameter("propID")));

                        if (propertyDetails == null)
                        {
                            address = "/propertyDetailssss.jsp";
                            request.setAttribute("NoProperties", null);
                        }
                        else 
                        {
                            try {
                                    PropType = PropertiesDB.getPropType(propertyDetails.getTypeId());
                                }//end try
                                    catch (Exception ex) {
                                    address = "/Error.jsp";
                                }//end catch
                            try {
                                    StyleType = PropertiesDB.getStyleType(propertyDetails.getStyleId());
                                }//end try
                                    catch (Exception ex) {
                                    address = "/Error.jsp";
                                }//end catch
                            try {
                                GarageType = PropertiesDB.getGarageType(propertyDetails.getGarageId());
                                }//end try
                                    catch (Exception ex) {
                                    address = "/Error.jsp";
                                }//end catch
                            List<Agents> allAgents = null;
                            try {
                                allAgents = AgentsDB.getAllAgents();
                                }//end try
                                    catch (Exception ex) {
                                    address = "/Error.jsp";
                                }//end catch
                            
//                                List<Styles> allStylesList  = StylesDB.getAllStyles();
//                                List<Propertytypes> allPropertyTypesList  = PropertytypeDB.getAllPropertytypes();
//                                List<Garagetypes> allGarageTypesList  = GaragetypesDB.getAllGaragetypes();
                                request.setAttribute("propertyDetails", propertyDetails);
                                request.setAttribute("Styles", allStylesList);
                                request.setAttribute("Propertytypes", allPropertyTypesList);
                                request.setAttribute("Garagetypes", allGarageTypesList);
                                
                                if(request.isUserInRole("admin"))
                                {
                                address = "admin/managePropertyDetails.jsp"; 
                                request.setAttribute("allAgents", allAgents);
                                }
                                else
                                {
                                address = "agent/managePropertyDetails.jsp"; 
                                }
                                
                        }

                     }//end try
                     catch (Exception ex) {
                        address = "/Error.jsp";
                     }//end catch
                    
                }
               RequestDispatcher dispatcher = request.getRequestDispatcher(address);
                    dispatcher.forward(request, response); 
            }
//            RequestDispatcher dispatcher = request.getRequestDispatcher(address);
//                dispatcher.forward(request, response);
//        response.sendRedirect("/RealtyWebsite/"+address);
////            RequestDispatcher dispatcher = request.getRequestDispatcher(address);
////            dispatcher.forward(request, response);
//         
        processRequest(request, response);
        }
        //processRequest(request, response);
            }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        //set date format
//        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
//	   //get current date time with Date()
//	   //Date date2 = new Date();
//	   //System.out.println(dateFormat.format(date2));
//           
//           
//           
//           //get current date time with Calendar()
//	   Calendar cal = Calendar.getInstance();
//	   System.out.println(dateFormat.format(cal.getTime()));
           
       // setup values
       Agents LoggedIn = null;
                    try
                    {
                        LoggedIn = AgentsDB.getByUsername(request.getUserPrincipal().getName()); 
                        //request.setAttribute("agent", agent);

                        }//end try
                    catch (Exception ex) {
                        //address = "/Error.jsp";
                    }
            int agentIdfromDB= 0;
            agentIdfromDB= LoggedIn.getAgentId();
            
       
       
       
       
        Integer id=0;
        String street="";
        String city="";
        
        Integer listingNum =0;
        Integer styleId =0;
        Integer typeId =0;
        Integer bedrooms =0;
        Float bathrooms = null;
        Integer squarefeet =0;
        String description ="";
        String lotsize ="";
        Short garageSize =(short)0;
        Integer garageId =0;
        Integer agentId = agentIdfromDB;// Need to get ID from Session when created!
        Date dateAdded = null;
        String photo ;//= request.getParameter("photo");
        Double price=0.0;
        
        List<FileItem> formItems2 = null;
        //////////////////
//        if (!ServletFileUpload.isMultipartContent(request) && id!=0) {
//            // if not, we stop here
//            PrintWriter writer = response.getWriter();
//            writer.println("Error: Form must has enctype=multipart/form-data.");
//            writer.flush();
//            return;
//        }
        
        // configures upload settings
        DiskFileItemFactory factory = new DiskFileItemFactory();
        // sets memory threshold - beyond which files are stored in disk
        factory.setSizeThreshold(MEMORY_THRESHOLD);
        // sets temporary location to store files
        factory.setRepository(new File(System.getProperty("java.io.tmpdir")));
 
        ServletFileUpload upload = new ServletFileUpload(factory);
         
        // sets maximum size of upload file
        upload.setFileSizeMax(MAX_FILE_SIZE);
         
        // sets maximum size of request (include file + form data)
        upload.setSizeMax(MAX_REQUEST_SIZE);
 
        // constructs the directory path to store upload file
        // this path is relative to application's directory
        String uploadPath = getServletContext().getRealPath("")
                + File.separator + UPLOAD_DIRECTORY;
         
        // creates the directory if it does not exist
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }
        // Check file Extention
        @SuppressWarnings("unchecked")
        List<FileItem> formItems = null;
        String fileNameExt="";
        
        try {
            formItems = upload.parseRequest(request);
            formItems2 =formItems;
            
        } catch (FileUploadException ex) {
            Logger.getLogger(ManagePropertys.class.getName()).log(Level.SEVERE, null, ex);
        }
 
            if (formItems != null && formItems.size() > 0) {
                // iterates over form's fields
                for (FileItem item : formItems) {
                    // processes only fields that are not form fields
                    if (!item.isFormField()) {
                        
                        fileNameExt = new File(item.getName()).getName();
                    }
                    if(item.getFieldName().equals("street"))
                            {
                            street = item.getString();
                            }
                    if(item.getFieldName().equals("city"))
                            {
                            city = item.getString();
                            }
                    if(item.getFieldName().equals("listingNum"))
                            {
                            listingNum = Integer.parseInt(item.getString());
                            }
                    if(item.getFieldName().equals("styleId"))
                            {
                            styleId = Integer.parseInt(item.getString());
                            }
                    if(item.getFieldName().equals("typeId"))
                            {
                            typeId = Integer.parseInt(item.getString());
                            }
                    if(item.getFieldName().equals("bedrooms"))
                            {
                            bedrooms = Integer.parseInt(item.getString());
                            }
                    if(item.getFieldName().equals("bathrooms"))
                            {
                            bathrooms = Float.parseFloat(item.getString());
                            }
                    if(item.getFieldName().equals("squarefeet"))
                            {
                            squarefeet = Integer.parseInt(item.getString());
                            }
                    if(item.getFieldName().equals("description"))
                            {
                            description = item.getString();
                            }
                    if(item.getFieldName().equals("lotsize"))
                            {
                            lotsize = item.getString();
                            }
                    if(item.getFieldName().equals("garageId"))
                            {
                            garageId = Integer.parseInt(item.getString());
                            }
                    if(item.getFieldName().equals("garageSize"))
                            {
                            garageSize = Short.parseShort(item.getString());
                            }
                    if(item.getFieldName().equals("price"))
                            {
                            price = Double.parseDouble(item.getString());
                            }
                    if(item.getFieldName().equals("id"))
                            {
                            id = Integer.parseInt(item.getString());
                            }
//                    if(item.getFieldName().equals("dateAdded"))
//                            {
//                            dateAdded = Date.valueOf(item.getString());
//                            }
                    if(item.getFieldName().equals("photo"))
                            {
                            photo = item.getString();
                            }
                    if(request.isUserInRole("admin"))
                    {
                       if(item.getFieldName().equals("agentId"))
                            {
                            agentId = Integer.parseInt(item.getString());
                            } 
                    }
                    
                }
            }
            if (!ServletFileUpload.isMultipartContent(request) && id==0) {
            // if not, we stop here
            PrintWriter writer = response.getWriter();
            writer.println("Error: Form must has enctype=multipart/form-data.");
            writer.flush();
            return;
        }
        ///////
        String fileNameToLowerCase = fileNameExt.toLowerCase(); 
        String fileExtension;
        if (fileNameToLowerCase.contains("."))
        {
        fileExtension = fileNameToLowerCase.substring(fileNameToLowerCase.indexOf(".")+1,fileNameToLowerCase.length());
        }
        else
        {
            fileExtension="";
        }

        if (!fileExtension.equals("png") && !fileExtension.equals("jpg") && !fileExtension.equals("jpeg") && !fileExtension.equals("gif") && !fileExtension.equals("bmp") && id==0)   
        {
            PrintWriter writer = response.getWriter();
            writer.println("Error: File must be one of the following formats only. (png,jpg,gif,bmp,jpeg)");
            writer.flush();
            return;
        }
        ////////////////
        
        String address="";
        //Setup new property
        Properties newProperty = new Properties();
        newProperty.setStreet(street);
        newProperty.setCity(city);
        newProperty.setListingNum(listingNum);
        newProperty.setStyleId(styleId);
        newProperty.setTypeId(typeId);
        newProperty.setBedrooms(bedrooms);
        newProperty.setBathrooms(bathrooms);
        newProperty.setSquarefeet(squarefeet);
        newProperty.setDescription(description);
        newProperty.setLotsize(lotsize);
        newProperty.setGaragesize(garageSize);
        newProperty.setGarageId(garageId);
        newProperty.setAgentId(agentId);
        newProperty.setPrice(price);
        newProperty.setDateAdded(new java.sql.Date(System.currentTimeMillis()));
        
        if(id != 0)
        {
        if(fileExtension!="")
        {
        newProperty.setPhoto(id+"."+fileExtension);
        }
        newProperty.setListingNum(id);
        newProperty.setId(id);
        PropertiesDB.updateProperty(newProperty);
        }
        else
        {
        id = PropertiesDB.insertProperty(newProperty);
        
        newProperty.setPhoto(id+"."+fileExtension);
        newProperty.setListingNum(id);
        PropertiesDB.updateProperty(newProperty);   
        }
        
        
        try{
            // parses the request's content to extract file data
            
        //@SuppressWarnings("unchecked")
        //List<FileItem> formItems = upload.parseRequest(request);
 
            if (formItems2 != null && formItems2.size() > 0) {
                // iterates over form's fields
                for (FileItem item : formItems2) {
                    // processes only fields that are not form fields
                    if (!item.isFormField()) {
                        
                        if(fileExtension!="")
                        {
                        String fileName = id+"."+fileExtension;
                        String filePath = uploadPath + File.separator+"large"+ File.separator+ fileName;
                        String filePathThumbnail = uploadPath + File.separator+"thumbnails"+ File.separator+fileName;
                        
                        File storeFileThumbnail = new File(filePathThumbnail);
                        File storeFile = new File(filePath);
                        item.write(storeFile);
                        
                        //Thumnail library used for resizing of both images
                        Thumbnails.of(storeFile).size(409,307).toFile(storeFile);//Resize Main Image with current ratio maintained. (Required before using force size on larger images)
                        Thumbnails.of(storeFile).forceSize(409,307).toFile(storeFile);//Resize Main Image forcing size of 409x307
                        Thumbnails.of(storeFile).forceSize(75,56).toFile(storeFileThumbnail);// create thumbnail of 75x56
                        
                        request.setAttribute("Status","This Property Has Been saved successfully!");
                        address = "ManagePropertys?GetProperties&Status=1";
                        }
                        
                        ////THIS IS HOW TO DELETE/////
//                        storeFile.delete();
//                        storeFileThumbnail.delete();
                        ////THIS IS HOW TO DELETE/////
                    }
                    else
                    {
                     request.setAttribute("Status","This Property Has Been Updated successfully!");
                                address = "ManagePropertys?GetProperties&Status=1";   
                    }
                }
            }
            
            }catch (Exception ex) {
            address = "/Error.jsp";
            }//end catch
            response.sendRedirect("/RealtyWebsite/"+address);
//            RequestDispatcher dispatcher = request.getRequestDispatcher(address);
//            dispatcher.forward(request, response);
         
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}


