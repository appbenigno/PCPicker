/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pcpicker_webclient;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pcpicker_webclient.nonservlet.WebMethods;

/**
 *
 * @author admin
 */
public class CreateAccount extends HttpServlet {

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
           
        HashMap cities = new HashMap();
        //todo - get from database
        cities.put("0", "Antipolo");
        cities.put("1", "Makati");    
        request.setAttribute("map", cities);
        ////
        ShoppingCart.getCartSummary(request);
        request.getRequestDispatcher("registerPage.jsp").forward(request,response);
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
        String address =(String) request.getParameter("address");
        String passwordre = (String) request.getParameter("passwordre");
        String city = (String) request.getParameter("city");
        String zipCode = (String) request.getParameter("zipCode");
        String firstname = (String) request.getParameter("firstname");
        String lastname = (String) request.getParameter("lastname");
        int zip = 0;
        Boolean error= false;
        String message = "";
        try
        {
            zip = Integer.parseInt(zipCode);
        }catch(Exception e)
        {
            System.out.println("numformat exception parse int" + e.getMessage());
            error = true;
            message += "Invalid Zip Code";
        }
        if(!password.equals(passwordre))
        {
            error = true;
            message += "Password does not match";
        }
        
        if(!error)
        {
            if(WebMethods.addCustomer(username, password, address, city, Integer.parseInt(zipCode),firstname,lastname))
            {
                message+="Register Success!";
                request.setAttribute("message", message);
                SessionMessage.setMessage(request, message);
                response.sendRedirect(request.getContextPath()+"/Login");
            }
            else
            {
                error = true;
                message+="Duplicate username";
            }
        }
        
        if(error)
        {
            request.setAttribute("message", message);
            request.setAttribute("username", username);
            request.setAttribute("lastname", lastname);
            request.setAttribute("firstname", firstname);
            request.setAttribute("address", address);
            request.setAttribute("city", city);
            request.setAttribute("zipCode", city);
            doGet(request,response);
        }
            
        //todo createaccount
    
      
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
