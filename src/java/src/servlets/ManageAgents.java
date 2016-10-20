/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.Principal;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import src.db.AgentsDB;
import src.entities.Agents;

/**
 *
 * @author Darren
 */

@ServletSecurity(@HttpConstraint(rolesAllowed={"admin","agent"}))
public class ManageAgents extends HttpServlet {

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
//        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ManageAgents</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ManageAgents at " + request.getContextPath() + "</h1>");;
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
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        //button setAgentsProfile
        //button getAllAgents
    try {
            Map m = request.getParameterMap();
            if(m.containsKey("GetAgentsProfile"))
            {
                int a=1;
                a+=1;
            }
            String address="";
//            if (m.containsKey("btn2"))
//            {
//            try {
//                List<Agents> allAgentsList = AgentsDB.getAllAgents();
//                if (allAgentsList == null) {
//                    address = "/NoAccounts.jsp";
//                } else {
//
//                    address = "/allAgents.jsp";
//                    request.setAttribute("list", allAgentsList);
//                  
//                }
//
//            }//end try
//            catch (Exception ex) {
//                address = "/Error.jsp";
//            }//end catch
//            }
            if (m.containsKey("GetAgentsProfile"))
            {
                if(request.isUserInRole("admin"))
                    {
                    response.sendRedirect("/RealtyWebsite/admin/admin.jsp");
                    }
                else
                {
                    Principal a=request.getUserPrincipal();
                if(request.getUserPrincipal()!=null)
                {
                    
            try
            {
                Agents agent = AgentsDB.getByUsername(request.getUserPrincipal().getName()); 
                request.setAttribute("agent", agent);
                
                }//end try
            catch (Exception ex) {
                address = "/Error.jsp";
            }//end catch
            }
            address = "/agent/editPersonalDetails.jsp";
            
            
            RequestDispatcher dispatcher = request.getRequestDispatcher(address);
            dispatcher.forward(request, response);
            }
            }
        } finally {
            out.close();
        }

    }
        
        //processRequest(request, response);
    

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
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            String address="";
            String Name= request.getParameter("name");
            String Phone= request.getParameter("phoneNumber");
            String Fax= request.getParameter("faxNumber");
            String Email= request.getParameter("emailAddress");

            try {
                   
                    //if (request.getParameterMap().containsKey("setAgentsProfile"))
                    {
                        Agents LoggedIn = null;
                    try
                    {
                        LoggedIn = AgentsDB.getByUsername(request.getUserPrincipal().getName()); 
                        //request.setAttribute("agent", agent);

                        }//end try
                    catch (Exception ex) {
                        address = "/Error.jsp";
                    }
                        
                        
                        // Agents newAgent = new Agents();
                        //newAgent.setAgentId(agentId);
                        LoggedIn.setName(Name);
                        LoggedIn.setPhone(Phone);
                        LoggedIn.setFax(Fax);
                        LoggedIn.setEmail(Email);
            
                        AgentsDB.updateAgent(LoggedIn);
                        
                    }
                   address = "ManageAgents?GetAgentsProfile=View+Profile"; 
                
               
                

            }//end try
            catch (Exception ex) {
                address = "/Error.jsp";
            }//end catch
            response.sendRedirect("/RealtyWebsite/"+address);
                processRequest(request, response);
//          RequestDispatcher dispatcher = request.getRequestDispatcher(address);
//            dispatcher.forward(request, response);
        } finally {
            out.close();
        }
        
        //processRequest(request, response);
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
