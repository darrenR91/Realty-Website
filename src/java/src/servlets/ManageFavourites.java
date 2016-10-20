/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import src.db.FavouritesDB;
import src.db.PropertiesDB;
import src.entities.Favourites;
import src.entities.Properties;


/**
 *
 * @author Darren
 */
public class ManageFavourites extends HttpServlet {
    
    private static String USER_NAME = "litrealtyproperty";  // GMail user name (just the part before "@gmail.com")
    private static String PASSWORD = "abbc1234"; // GMail password
    private static String RECIPIENT = "litrealtyproperty@gmail.com";

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
         {
        
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
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        try{
            String address="";
            Map m = request.getParameterMap();
            
                if(m.containsKey("removeFavourites")) // Removes From Favourite List
                      {  
                              try {
                                  //Response.Cookies["CoockieName"].Values["itemIndex"] = String.Empty;
                                  if(request.getParameter("propID")!=null){

                                String favourites="";
                                Cookie[] cookies = request.getCookies();
                                if (cookies != null) 
                                {
                                    for (Cookie cookie : cookies) {
                                        if(cookie.getName().equals("PropertyID"))
                                        {
                                            String cookieString = cookie.getValue();
                                            //String joinedMinusBrackets = cookieString.substring( 1, cookieString.length() - 1);

                                            // String.split()
                                            String[] PropArray = cookieString.split( ", "); 
                                            cookieString="";
                                            String todelete = request.getParameter("propID");
                                            for (String PropId : PropArray) {
                                                
                                                if(!PropId.equals(todelete))
                                                {
                                                    if(cookieString=="")
                                                    {
                                                        cookieString+=PropId;
                                                    }
                                                    else
                                                    {
                                                        cookieString+=", "+PropId;
                                                    }
                                                }
                                            }
                                            if(cookieString=="")
                                            {
                                                cookie.setMaxAge(0);
                                                cookie.setValue(null);
                                                response.addCookie(cookie);
                                            }
                                            
                                            cookie.setValue(cookieString);
                                            response.addCookie(cookie);
                                        }
                                        }
                                    }
                                
                                  }
                                  address = "ManageFavourites";
                              }
                          //end try
                          catch (Exception ex) {
                              address = "/Error.jsp";
                          }//end catch
                          response.sendRedirect("/RealtyWebsite/ManageFavourites");
                          //RequestDispatcher dispatcher = request.getRequestDispatcher(address);
                          //dispatcher.forward(request, response);
                      }
                if(m.isEmpty()) // Retrieves Favourite List
                      {  
                    String[] PropArray=null;
                        try {
                            
                            String favourites="";
                                Cookie[] cookies = request.getCookies();
                                if (cookies != null) 
                                {
                                    for (Cookie cookie : cookies) {
                                        if(cookie.getName().equals("PropertyID"))
                                        {
                                            String cookieString = cookie.getValue();
                                            PropArray = cookieString.split( ", "); 
                                            
                                        }
                                        }
                                    }
                            
                            
                            
            
                                List<Integer> ids = new ArrayList<Integer>();
                           if(PropArray!=null ){
                            for (String cookieToList : PropArray) {
                                    if(cookieToList!="")
                                    {
                                    ids.add(Integer.parseInt(cookieToList));
                                    }
                            }
                           }
                                
                        try {
                                List<Properties> allPropertiesList = PropertiesDB.getAllPropertiesByWishList(ids);

                                if (allPropertiesList == null) {
                                    address = "/favourites.jsp";
                                    request.setAttribute("NoProperties", null);
                                } else {

                                    address = "/favourites.jsp";
                                    request.setAttribute("list", allPropertiesList);
                                }
                                }//end try
                                catch (Exception ex) {
                                    address = "/Error.jsp";
                                }//end catch
                                RequestDispatcher dispatcher = request.getRequestDispatcher(address);
                                dispatcher.forward(request, response);
                            }catch (Exception ex) {
                                    address = "/Error.jsp";
                            }//end catch
                      }
                if(m.containsKey("favourites"))
                      {       
                        try {
                            if(request.getParameter("propID")!=null){

                                String favourites="";
                                Cookie[] cookies = request.getCookies();
                                if (cookies != null) 
                                {
                                    for(int i=0; i<cookies.length; i++) 
                                    {
                                        Cookie cookie = cookies[i];
                                        if(cookie.getName().equals("PropertyID"))
                                        {
                                        favourites = cookie.getValue();
                                        favourites+=", "+request.getParameter("propID");
                                        cookie.setValue(favourites);
                                        response.addCookie(cookie);
                                        }
                                    }
                                }
                                if (favourites=="")
                                {
                                Cookie userCookie = new Cookie("PropertyID", request.getParameter("propID"));
                                userCookie.setMaxAge(60*60*24*365); //Store cookie for 1 year
                                response.addCookie(userCookie);
                                }
                                address="PropertySearch?propID="+request.getParameter("propID");
                            }
                            }//end try
                            catch (Exception ex) {
                            address = "/Error.jsp";
                            }//end catch

                            response.sendRedirect("/RealtyWebsite/"+address);
                            //RequestDispatcher dispatcher = request.getRequestDispatcher(address);
                            //dispatcher.forward(request, response);
                        }
                if(m.containsKey("emailFavourites"))
                      {   
                        Cookie[] cookies = request.getCookies();  
                        String ToEmail = request.getParameter("emailAddress");
                        String Name = request.getParameter("name");
                        String Link = generateFavouritesLink(cookies,Name);
                        
                        String[] to = { ToEmail }; // list of recipient email addresses
                        String subject = "Favourites List";
                        String body = "Dear Sir/Madam, \n\nOur Customer "+Name+" has sent you a link to his favourite propertys on www.litrealty.ie.\n\n"
                                + "This link will be available for 7 days \n\n"+
                                "Link: \n"+Link+
                                "\n\n Regards, \n\n Lit Realty";

                        address = "/ManageFavourites?stautus=1";
                        
                        try {
                            sendFromGMail(USER_NAME, PASSWORD, to, subject, body);
                        } catch (MessagingException ex) {
                             request.setAttribute("Status", "An Error occurred please try again.");
                            Logger.getLogger(ManageFavourites.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        response.sendRedirect("/RealtyWebsite/"+address);
                      }
                if(m.containsKey("generateFavourites"))
                      {   
                        String Name = request.getParameter("name");
                        Cookie[] cookies = request.getCookies(); 
                        String Link = generateFavouritesLink(cookies,Name);
                        
                        address = "ManageFavourites";
                        
                        request.setAttribute("Link", Link);
                        
                        response.sendRedirect("/RealtyWebsite/"+address);
                      }
                if(m.containsKey("favouritesLink"))
                      {   
                          
                          List<Properties> allPropertiesList = null;
                        int favouritesLink = Integer.parseInt(request.getParameter("favouritesLink"));
                        
                        Favourites favouritesString = FavouritesDB.getFavouritesById(favouritesLink);
                        
                        String[] favouritesArray=null;
                        
                        favouritesArray = favouritesString.getFavouritesList().split( ", "); 
                                     
                            
            
                                List<Integer> ids = new ArrayList<Integer>();
                           if(favouritesArray!=null ){
                            for (String cookieToList : favouritesArray) {
                                  
                                    ids.add(Integer.parseInt(cookieToList));
                                    
                            }
                           }
                                
                        try {
                                allPropertiesList = PropertiesDB.getAllPropertiesByWishList(ids);

                                
                            }catch (Exception ex) {
                                    address = "/Error.jsp";
                            }//end catch
                      
                        
                        request.setAttribute("name", favouritesString.getName());
                        request.setAttribute("list", allPropertiesList);
                        
                        address = "/favouritesLink.jsp";
                        RequestDispatcher dispatcher = request.getRequestDispatcher(address);
                        dispatcher.forward(request, response);
                        
                        //address = "favouritesLink.jsp";
                        //response.sendRedirect("/RealtyWebsite/"+address);
                      }
                            
        }finally {
        out.close();
        }
        
        
       processRequest(request, response);
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
    private static void sendFromGMail(String from, String pass, String[] to, String subject, String body) throws AddressException, MessagingException {
        java.util.Properties props = System.getProperties();
        String host = "smtp.gmail.com";
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.user", from);
        props.put("mail.smtp.password", pass);
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");

        Session session = Session.getDefaultInstance(props);
        MimeMessage message = new MimeMessage(session);
        
        try {
            message.setFrom(new InternetAddress(from));
            
            InternetAddress[] toAddress = new InternetAddress[to.length];
            // To get the array of addresses
            for( int i = 0; i < to.length; i++ ) {
                toAddress[i] = new InternetAddress(to[i]);
            }

            for( int i = 0; i < toAddress.length; i++) {
                message.addRecipient(Message.RecipientType.TO, toAddress[i]);
            }

            message.setSubject(subject);
            message.setText(body);
            Transport transport = session.getTransport("smtp");
            transport.connect(host, from, pass);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
            
            } catch (MessagingException ex) {
            Logger.getLogger(ManageFavourites.class.getName()).log(Level.SEVERE, null, ex);
        }
            

            
    }
    public String generateFavouritesLink(Cookie[] cookies,String Name)
    {
       String cookieString="";
       int id = 0;
       try
       {
        if (cookies != null) 
        {
            for (Cookie cookie : cookies) {
                if(cookie.getName().equals("PropertyID"))
                {
                    cookieString = cookie.getValue();

                }
                }
            }
        
        
        Favourites favouritesLink = new Favourites();
        favouritesLink.setName(Name);
        favouritesLink.setFavouritesList(cookieString);
        favouritesLink.setDateCreated(new java.sql.Date(System.currentTimeMillis()));
        
        Favourites favouritesID = FavouritesDB.insertFavouriteList(favouritesLink);
        id =favouritesID.getId();
           }catch (Exception ex) {
                                  String  address = "/Error.jsp";
                            }//end catch   
       
        String link ="https://localhost:8443/RealtyWebsite/ManageFavourites?favouritesLink="+id;
        
        
        return link;
    }
}
