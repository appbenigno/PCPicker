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
import pcpicker_webclient.nonservlet.Cart;
import pcpicker_webclient.nonservlet.WebMethods;

/**
 *
 * @author admin
 */
public class Checkout extends HttpServlet {

    

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
        Cart cart = (Cart)request.getSession().getAttribute("cart");
       
        if(cart == null || cart.getList().size() == 0)
        {
            SessionMessage.setMessage(request, "No items in cart");
            response.sendRedirect(request.getContextPath()+"/ShoppingCart");     
        }
        else if (( request.getSession().getAttribute("userid") == null) || ( request.getSession().getAttribute("userid") == "")) 
        {
            //not logged in   
            SessionMessage.setMessage(request, "Please login before Checking out");
            response.sendRedirect(request.getContextPath()+"/ShoppingCart");           
        }
        else
        {
            int userid = Integer.parseInt((String)request.getSession().getAttribute("userid"));  
            int orderId = WebMethods.addOrder(userid, cart.getPartList(), cart.getQuantityList(), "");
            request.getSession().setAttribute("cart", null);           
            SessionMessage.setInt(request,orderId);
            response.sendRedirect(request.getContextPath()+"/OrderPage");
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
