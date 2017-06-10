/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pcpicker_webclient;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pcpicker.Part;
import pcpicker.Processor;

/**
 *
 * @author admin
 */
public class Cart extends HttpServlet {

    final int ADD = 1;
    final int REMOVE = 2;
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet responseaaa
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
 

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
       
        request.setAttribute("cartList",getCartList(request));
        
        request.getRequestDispatcher("ShoppingCart.jsp").forward(request,response);
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
        
        if(getSubmitValue(request) == ADD)
            addPart(request);
        else if (getSubmitValue(request) == REMOVE)
            removePart(request);
       
        doGet(request,response);
    }
    private HashMap getCartList(HttpServletRequest request)
    {
        ArrayList<Part> parts = getCart(request);
        HashMap map = new HashMap();
        for(int i = 0; i < parts.size();i++)
        {
            HashMap items = new HashMap();

            items.put("1",parts.get(i).getPartId());
            items.put("2",parts.get(i).getPartName());
            items.put("3",Double.toString(parts.get(i).getPartPrice()));

         //  String corethreads = components.ge

          //  items.put("4",components.get(i).g);



            map.put(Integer.toString(i), items);
        }
        System.out.println("parts.size" +parts.size());
        return map;
    }
    
    private int getSubmitValue(HttpServletRequest request)
    {
        int numListItems = Integer.parseInt((String)request.getParameter("numListItems"));
        String[] partIds = request.getParameterValues("partid");
        String partid = "";
        int sv=0;
        for(int i = 0; i < numListItems; i++)
        {
            String is = Integer.toString(i);            
            String submit = (String) request.getParameter("submit" + is);
            if(submit!=null)
            {               
                  
                if(submit.equals("Add to Cart")) 
                    sv = ADD;
                else if(submit.equals("Remove from Cart"))
                    sv = REMOVE;
                break;
            }
        }
        
        return sv;
    }
    
    private Part getSubmitPart(HttpServletRequest request)
    {
        int numListItems = Integer.parseInt((String)request.getParameter("numListItems"));
        String[] partIds = request.getParameterValues("partid");
        String partid = "";
        
        for(int i = 0; i < numListItems; i++)
        {
            String is = Integer.toString(i);            
            String submit = (String) request.getParameter("submit" + is);
            if(submit!=null)
            {               
                partid = partIds[i];               
                System.out.println("partid= "+ partid);    
                break;
            }
        }
        Part a = WebMethods.getPart(partid);
        System.out.println("submitPart"+a.getPartId());
        return WebMethods.getPart(partid);
    }
    
    private ArrayList<Part> getCart(HttpServletRequest request)
    {
        ArrayList<Part> cart = (ArrayList<Part>)request.getSession().getAttribute("cart");
        if(cart == null)
            cart = new ArrayList<Part>();
        return cart;
    }

    private void addPart(HttpServletRequest request)
    {
        ArrayList<Part> cart = getCart(request);
        cart.add(getSubmitPart(request));
        request.getSession().setAttribute("cart", cart);
        
    }
    private void removePart(HttpServletRequest request)
    {
        ArrayList<Part> cart = getCart(request);
        String partid = getSubmitPart(request).getPartId();
        
        for(int i = cart.size()-1; i>=0; i--)
            if(cart.get(i).getPartId().equals(partid))
                cart.remove(i);
        
        
        request.getSession().setAttribute("cart", cart);
        
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
