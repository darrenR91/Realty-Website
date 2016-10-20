/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.servlets;



import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.ListItem;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Color;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.ServletSecurity;
import src.db.PropertiesDB;
import src.entities.Properties;

/**
 *
 * @author Darren
 */

@ServletSecurity(@HttpConstraint(rolesAllowed={"admin"}))
public class ManageAdmin extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ManagePDF</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ManagePDF at " + request.getContextPath() + "</h1>");
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
        
            Map m = request.getParameterMap();
            if(m.containsKey("GetPDF"))
            {
                try {
            String Report = getServletContext().getRealPath("")
                + "admin\\PDF_Report.pdf";
            
             FileOutputStream file=new FileOutputStream(Report);
            Document document=new Document();
            document.addAuthor("K00140908");
            PdfWriter.getInstance(document, file);
            ///////////////////////ADDING THE FILES TO PDF////////////////////
            //Inserting Image in PDF
            String uploadPath = getServletContext().getRealPath("")
                + "images\\logo.gif";
         
            Image img = Image.getInstance(uploadPath);

            img.scaleAbsolute(120f, 60f);// width,height of image in float

//            Inserting Title in PDF  ORIGINAL
//            Font fontTitle=new Font(Font.FontFamily.HELVETICA, 16, Font.BOLD, BaseColor.WHITE);
//            Chunk title=new Chunk("PDF GENERATION in Java with iText", fontTitle);
//            title.setBackground(new BaseColor(255,102,0), 1f, 1f, 1f, 3f);
//            title.setLineHeight(30f);
//            title.setUnderline(BaseColor.BLACK,5f,0.5f,2f,0.5f,PdfContentByte.LINE_CAP_ROUND);
            Font fontTitle=new Font(Font.FontFamily.HELVETICA, 16, Font.BOLD, BaseColor.BLACK);
            Chunk title=new Chunk("Lit Realty System Report", fontTitle);
            title.setLineHeight(30f);
            

            //Inserting Table in PDF
            PdfPTable table=new PdfPTable(3);
            table.setWidthPercentage(100); // Sets the width percentage that the table will occupy in the page
            table.setSpacingAfter(10f);
            table.setSpacingBefore(15f);
            table.setWidths(new float[]{2f,2f,2f}); // Sets relative width of table

            Font fontHeader=new Font(Font.FontFamily.HELVETICA, 15, Font.BOLD, BaseColor.BLUE);
            PdfPCell headercell=new PdfPCell(new Phrase("Property Photo",fontHeader)); // Creates new cell in table
            headercell.setBackgroundColor(new BaseColor(230,230,243));
            headercell.setPaddingBottom(5f);
            table.addCell(headercell);
            
            headercell=new PdfPCell(new Phrase("Property ID",fontHeader));
            headercell.setBackgroundColor(new BaseColor(233,233,233));
            headercell.setPaddingBottom(5f);
            table.addCell(headercell);

            headercell=new PdfPCell(new Phrase("Price",fontHeader));
            headercell.setBackgroundColor(new BaseColor(233,233,233));
            headercell.setPaddingBottom(5f);
            table.addCell(headercell);
            
          PdfPCell cell1 = new PdfPCell(img, false);

            table.addCell(cell1);
            table.addCell("€134000");
             table.addCell("213445");
            table.addCell("€134000");
            
            //Inserting List
            com.itextpdf.text.List list=new com.itextpdf.text.List(true,30);
            list.add(new ListItem("Example1"));
            list.add(new ListItem("Example2"));
            list.add(new ListItem("Example3"));
  
            //Adding elements into PDF Document
             document.open();

             document.add(img);
             document.add(title);
             
              
               
             document.add(Chunk.NEWLINE);
             document.add(table);

             document.newPage();
             document.add(new Chunk("List of Examples").setUnderline(+1f,-5f));
             document.add(list);
             
             document.newPage();
             document.add(new Chunk("List of Examples").setUnderline(+1f,-5f));
             document.add(list);
             
             
                         
             document.newPage();
             document.add(new Chunk("List of Properts By Agent X").setUnderline(+1f,-5f));
              //////////////////////GET Propertys From Entity///////////////
              List<Properties> allPropertiesList = PropertiesDB.getAllProperties();
              
                PdfPTable propertyTable = new PdfPTable(3);
                PdfPCell propertyHeadingcell1 = new PdfPCell(new Phrase("Photo"));
                PdfPCell propertyHeadingcell2 = new PdfPCell(new Phrase("Property ID"));
                PdfPCell propertyHeadingcell3 = new PdfPCell(new Phrase("Price"));

                propertyHeadingcell1.setBorder(Rectangle.NO_BORDER);
                propertyHeadingcell2.setBorder(Rectangle.NO_BORDER);
                propertyHeadingcell3.setBorder(Rectangle.NO_BORDER);

                propertyTable.addCell(propertyHeadingcell1);
                propertyTable.addCell(propertyHeadingcell2);
                propertyTable.addCell(propertyHeadingcell3);
                
                
            document.add(Chunk.NEWLINE);
            
            String uploadPathforPropertyPhoto = getServletContext().getRealPath("")
                + "images\\properties\\thumbnails\\";
         
            Image propertyThumbnail; 

            img.scaleAbsolute(120f, 60f);// width,height of image in float
            
            for (Properties anProperty: allPropertiesList)
            {
                propertyThumbnail = Image.getInstance(uploadPathforPropertyPhoto+anProperty.getPhoto());
                PdfPCell propertycell1 = new PdfPCell(propertyThumbnail, false);
                propertycell1.setPaddingBottom(20);
                PdfPCell propertycell2 = new PdfPCell(new Phrase(anProperty.getListingNum().toString()));
                PdfPCell propertycell3 = new PdfPCell(new Phrase(anProperty.getPrice().toString()));

                propertycell1.setBorder(Rectangle.NO_BORDER);
                propertycell2.setBorder(Rectangle.NO_BORDER);
                propertycell3.setBorder(Rectangle.NO_BORDER);

                propertyTable.addCell(propertycell1);
                propertyTable.addCell(propertycell2);
                propertyTable.addCell(propertycell3);
                
            
             
            
             }
            document.add(Chunk.NEWLINE);
            document.add(propertyTable); 
            //////////////////////GET Propertys From Entity///////////////
             
             
             
             document.close();
             file.close();

             System.out.println("Pdf created successfully ! :)");

             String filePath = Report;
             File downloadFile = new File(filePath);
             FileInputStream inStream = new FileInputStream(downloadFile);
		
		// if you want to use a relative path to context root:
		String relativePath = getServletContext().getRealPath("");
		System.out.println("relativePath = " + relativePath);
		
		// obtains ServletContext
		ServletContext context = getServletContext();
		
		// gets MIME type of the file
		String mimeType = context.getMimeType(filePath);
		if (mimeType == null) {			
			// set to binary type if MIME mapping not found
			mimeType = "application/octet-stream";
		}
		System.out.println("MIME type: " + mimeType);
		
		// modifies response
		response.setContentType(mimeType);
		response.setContentLength((int) downloadFile.length());
		
		// forces download
		String headerKey = "Content-Disposition";
		String headerValue = String.format("attachment; filename=\"%s\"", downloadFile.getName());
		response.setHeader(headerKey, headerValue);
		
		// obtains response's output stream
		OutputStream outStream = response.getOutputStream();
		
		byte[] buffer = new byte[4096];
		int bytesRead = -1;
		
		while ((bytesRead = inStream.read(buffer)) != -1) {
			outStream.write(buffer, 0, bytesRead);
		}
		
		inStream.close();
		outStream.close();
             /////////////////
            
            
            
            processRequest(request, response);
        } catch (DocumentException ex) {
            Logger.getLogger(ManageAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
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

}
