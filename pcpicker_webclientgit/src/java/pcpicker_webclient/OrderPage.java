/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pcpicker_webclient;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pcpicker.Order;
import pcpicker.OrderParts;
import pcpicker.Part;
import pcpicker_webclient.nonservlet.Cart;
import pcpicker_webclient.nonservlet.WebMethods;

/**
 *
 * @author admin
 */
public class OrderPage extends HttpServlet {

    final int VIEW = 1;
    final int CANCEL = 2;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ShoppingCart.getCartSummary(request);
        int custid = Integer.parseInt((String)request.getSession().getAttribute("userid"));
        Integer orderid = getOrderId(request);
        Integer submit = getSubmitValue(request);
        if(submit == VIEW)
        {
            List<Order> orders = WebMethods.getOrderList(custid); 
            String deliveryDate = null;
            List<OrderParts> op  = null;
            for(Order o : orders)
            {           
                if(o.getOrderId() == orderid)
                {
                    op = o.getItems();
                    deliveryDate = o.getDeliveryDate();
                    request.setAttribute("datecreated",o.getDateCreated());
                    //System.out.println("adasdasdasdasdqeqweqdzczxdfwewrwesdfsdfsdf");
                    break;
                }
            }

            HashMap opmap = createOrderPartHashMap(op);
            double totalprice = calculateTotalPrice(op);

           
            request.setAttribute("deliveryDate",deliveryDate);
            request.setAttribute("totalprice",totalprice);
            request.setAttribute("orderid",orderid);
            request.setAttribute("orderitems", opmap);
            request.getRequestDispatcher("/orderpage.jsp").forward(request,response);
        }
        else if (submit == CANCEL)
        {
            WebMethods.cancelOrder(orderid);
            response.sendRedirect(request.getContextPath()+"/AccountPage");
        }
    }
    
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
    
    
    private Integer getSubmitValue(HttpServletRequest request)
    {
        if((String)request.getParameter("orderLength") == null || ((String)request.getParameter("orderLength")).equals(""))
            return VIEW;
        Integer numListItems = Integer.parseInt((String)request.getParameter("orderLength"));        
        Integer sv=0;
        
        for(Integer i = 0; i < numListItems; i++)
        {
            String is = Integer.toString(i);            
            String submit = (String) request.getParameter("submit" + is);
            if(submit!=null)
            {                                 
                if(submit.equals("View Order"))                 
                    sv = VIEW;                
                
                else if(submit.equals("Cancel Order"))                                 
                    sv = CANCEL;
                
                break;
            }
        }
        if(sv == null)
            sv = VIEW;
        return sv;
    }
    
    private Integer getSelectedOrder(HttpServletRequest request)
    {
        int numListItems = Integer.parseInt((String)request.getParameter("orderLength"));
        String[] orderIds = request.getParameterValues("orderid");
        Integer orderId = null;
        //System.out.println("********************************");
        //System.out.println("numlistitems " + numListItems);
        for(int i = 0; i < numListItems; i++)
        {
            String is = Integer.toString(i);            
            String submit = (String) request.getParameter("submit" + is);
            if(submit!=null)
            {               
                System.out.println("IS" + is);
                orderId = Integer.parseInt(orderIds[i]);   
                break;
            }
        }
        return orderId;
    }
     
    private Integer getOrderId(HttpServletRequest request)
    {
        Integer orderid = SessionMessage.getInt(request);
        
        if(orderid == null)        
            orderid=  getSelectedOrder(request);
        return orderid;
    }
    
    private HashMap createOrderPartHashMap( List<OrderParts> op)
    {
        HashMap map = new HashMap();
        for(int i = 0; i < op.size(); i++)
        {
            OrderParts o = op.get(i);
            HashMap items = new HashMap();
            
            items.put("1",o.getPartId());
            items.put("3",o.getQuantity());
            Part part = WebMethods.getPart(o.getPartId());
            items.put("2",o.getPartId() + " " + part.getPartName());
            items.put("4",o.getPrice());
            items.put("5",o.getPrice() * o.getQuantity());
          
            
            map.put(Integer.toString(i), items);
        }
        return map;
    }

    private double calculateTotalPrice(List<OrderParts> op) {
        double total=0;
        for(OrderParts o : op)
        {
            total += o.getQuantity() * o.getPrice();
        }
        return total;
    }

}
