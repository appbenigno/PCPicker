/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pcpicker_webclient;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pcpicker_webclient.nonservlet.WebMethods;

/**
 *
 * @author admin
 */
public class Login extends HttpServlet {

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
        ShoppingCart.getCartSummary(request);
        if (( request.getSession().getAttribute("userid") == null) || ( request.getSession().getAttribute("userid") == "")) 
        {
            //not logged in - go to login page
            request.getRequestDispatcher("loginpage.jsp").forward(request, response);
        }
        else
        {
            //todo log in - go to account page 
           SessionMessage.getMessage(request);
           response.sendRedirect(request.getContextPath()+"/AccountPage");
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
        
        String username = (String) request.getParameter("username");
        String password = (String) request.getParameter("password");
        
        //todo login
        String custid = WebMethods.login(username, password);
        if(custid == null || custid.equals(""))
        {
            request.setAttribute("message", "Incorrect username or password");
            doGet(request,response);
        }
        else
        {
            request.getSession().setAttribute("username",username);
            request.getSession().setAttribute("userid",custid);
            response.sendRedirect("homepage1.jsp");         
        }
        
       
      
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
