/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
public class PropertySearch extends HttpServlet {

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
        Map m = request.getParameterMap();
            
        PrintWriter out = response.getWriter();
        try {
            String address="";

                if(m.isEmpty()) 
                {
                
                }
                if(m.containsKey("propertySearch")) 
                {  
                        String Location = request.getParameter("location");
                        Double minPrice = Double.parseDouble(request.getParameter("minPrice"));
                        Double maxPrice = Double.parseDouble(request.getParameter("maxPrice"));
                        Integer minSquareFeet=-1;
                        Integer maxSquareFeet=-1;
                        Integer Bedrooms=-1;
                        if(request.getParameter("minSquareFeet")!=null)
                        {
                         minSquareFeet = Integer.parseInt(request.getParameter("minSquareFeet"));
                         maxSquareFeet = Integer.parseInt(request.getParameter("maxSquareFeet"));
                         Bedrooms = Integer.parseInt(request.getParameter("bedrooms"));
                        }
                        List<String> Locations = new ArrayList<String>();
                        Locations = PropertiesDB.getAllLocations();

                        request.setAttribute("Locations", Locations);

                        List<Integer> RoomCount = new ArrayList<Integer>();
                        RoomCount = PropertiesDB.getRoomCount();

                        request.setAttribute("RoomCount", RoomCount);
                        //already set
                        request.setAttribute("Location", Location);
                        request.setAttribute("minPrice", minPrice);
                        request.setAttribute("maxPrice", maxPrice);

                        request.setAttribute("minSquareFeet", minSquareFeet);
                        request.setAttribute("maxSquareFeet", maxSquareFeet);
                        request.setAttribute("bedrooms", Bedrooms);

                        try {
                        List<Properties> allPropertiesList  = PropertiesDB.getAllPropertyBySearch(Location, minPrice, maxPrice, minSquareFeet, maxSquareFeet, Bedrooms);

                          if (allPropertiesList == null) {
                                address = "/propertySearch.jsp";
                                request.setAttribute("NoProperties", null);
                            } else {

                                address = "/propertySearch.jsp";
                                request.setAttribute("list", allPropertiesList);
                                //request.setAttribute("WishList", ids);
                            }

                        }//end try
                        catch (Exception ex) {
                            address = "/Error.jsp";
                        }//end catch
                        RequestDispatcher dispatcher = request.getRequestDispatcher(address);
                        dispatcher.forward(request, response);
                }
                
                if(m.containsKey("propID")) 
                { 
                    String StyleType="";
                    String PropType="";
                    String GarageType="";
                    Agents agent = null;

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
                            try {
                                agent = AgentsDB.getByAgentId(propertyDetails.getAgentId());
                                }//end try
                                    catch (Exception ex) {
                                    address = "/Error.jsp";
                                }//end catch
                            String favourite=null;
                                Cookie[] cookies = request.getCookies();
                                if (cookies != null) 
                                {
                                    for (Cookie cookie : cookies) {
                                        if(cookie.getName().equals("PropertyID"))
                                        {
                                            String cookieString = cookie.getValue();
                                            String[] PropArray = cookieString.split( ", "); 
                                            for (String PropId : PropArray) {
                                                
                                                if(PropId.equals(propertyDetails.getId().toString()))
                                                {
                                                    favourite="1";
                                                }
                                            }
                                        }
                                    }
                                }
                            
                                request.setAttribute("favourite", favourite);
                                request.setAttribute("anAgent", agent);
                                request.setAttribute("propertyDetails", propertyDetails);
                                request.setAttribute("PropType", PropType);
                                request.setAttribute("StyleType", StyleType);
                                request.setAttribute("GarageType", GarageType);
                                address = "/propertyDetails.jsp";
                            

                        }

                     }//end try
                     catch (Exception ex) {
                        address = "/Error.jsp";
                     }//end catch
                    RequestDispatcher dispatcher = request.getRequestDispatcher(address);
                    dispatcher.forward(request, response);
                }
                
                
                if (m.containsKey("allAgents"))
                {
                }
        }
        finally {
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

}
