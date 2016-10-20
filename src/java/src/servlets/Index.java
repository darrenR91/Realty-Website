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
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import src.db.AgentsDB;
import src.db.PropertiesDB;
import src.entities.Agents;
import src.entities.Properties;

/**
 *
 * @author Darren
 */
public class Index extends HttpServlet {

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

                if(m.isEmpty()) // Setup Index
                {
                    Calendar calendar = Calendar.getInstance();
                    Date todaysDate = calendar.getTime();
                    calendar.add(Calendar.DAY_OF_MONTH, -7);
                    Date startDate = calendar.getTime();
                       
                    try {
                        List<Properties> FiveRecent = PropertiesDB.getfiveRecentlyAdded(startDate, todaysDate);
                        List<Properties> FiveOldest = PropertiesDB.getOldest();
                        request.setAttribute("FiveRecent", FiveRecent);
                        request.setAttribute("FiveOldest", FiveOldest);
                        
                        
                    List<String> Locations = new ArrayList<String>();

                   Locations = PropertiesDB.getAllLocations();

                    address="index.jsp";
                    request.setAttribute("Locations", Locations);
                    }//end try
                    catch (Exception ex) {
                        address = "/Error.jsp";
                    }//end catch
                    
                    
                    RequestDispatcher dispatcher = request.getRequestDispatcher(address);
                    dispatcher.forward(request, response);
                 
                }
                if(m.containsKey("logout")) // Logout
                {  
                    request.getSession().invalidate();
                    response.sendRedirect("Index");
                }
                
                if(m.containsKey("recentlyAdded")) // Retrieve list of Recently Added (Last 7 Days).
                { 
                       Calendar calendar = Calendar.getInstance();
                       Date todaysDate = calendar.getTime();
                       calendar.add(Calendar.DAY_OF_MONTH, -7);
                       Date startDate = calendar.getTime();

                   try {
                        List<Properties> list = PropertiesDB.getRecentlyAdded(startDate, todaysDate);

                        address="recentProperties.jsp";
                        request.setAttribute("list", list);
                        request.setAttribute("Recent", "Recent");
                       }//end try
                       catch (Exception ex) {
                        address = "/Error.jsp";
                       }//end catch
                RequestDispatcher dispatcher = request.getRequestDispatcher(address);
                dispatcher.forward(request, response);
                }
                
                if (m.containsKey("allAgents"))
                {
                try {
                    List<Agents> allAgentsList = AgentsDB.getAllAgents();
                    if (allAgentsList == null) {
                        address = "/NoAccounts.jsp";
                    } else {

                        address = "/agentsList.jsp";
                        request.setAttribute("list", allAgentsList);

                    }
                    RequestDispatcher dispatcher = request.getRequestDispatcher(address);
                    dispatcher.forward(request, response);
                    }//end try
                    catch (Exception ex) {
                        address = "/Error.jsp";
                    }//end catch
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
