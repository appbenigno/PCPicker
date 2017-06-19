/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pcpicker_webserviceForDesktop;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import javax.jws.Oneway;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import pcpicker.Coordinates;
import pcpicker.Customer;
import pcpicker.Delivery;
import pcpicker.Order;
import pcpicker.Order_Parts;
import pcpicker.Part;
import shared.DistanceCalculator;

/**
 *
 * @author admin
 */
@WebService(serviceName = "Pcpicker_webserviceForDesktop")
public class Pcpicker_webserviceForDesktop {

    String user="root"; // meron rin sa Pcpicker_webservice
    String pass="1825";
    
    
     @WebMethod(operationName = "getAcceptedOrders")
    public ArrayList<Order> getAcceptedOrders() {
        ArrayList<Order> a = new ArrayList(); ///////////////////////////////
        int i = 0;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pcpicker", user, pass);

            String sql = "{call getAcceptedOrders()}"; ////////////////////////////////
            CallableStatement callableStatement = conn.prepareCall(sql);
            ResultSet rs = callableStatement.executeQuery();

            while (rs.next()) {
                int last = a.size();
                a.add(new Order()); ////////////////////////////////////////////

                a.get(last).setOrder_id(rs.getInt("order_id"));/////////////////////////////
                a.get(last).setCust_id(rs.getInt("cust_id"));//////////////////
                a.get(last).setDate_created(rs.getString("date_created"));////////////////
                a.get(last).setPayment_type(rs.getString("payment_type"));
                a.get(last).setStatus(rs.getInt("status_"));
                a.get(last).setItems(getOrderItems(a.get(last).getOrder_id()));
                a.get(last).setDeliveryDate(rs.getString("deliveryDate"));
                a.get(last).setDeliveryAddress(rs.getString("deliveryAddress"));
                a.get(last).setNearestBranchRequest(rs.getInt("nearestBranchRequest"));
               
            }
            callableStatement.close();
            conn.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return a;
    }
    
    
    @WebMethod(operationName = "getCoordinates")
    public Coordinates getCoordinates(@WebParam(name = "address") String  address) {
        return Coordinates.getCoordinates(address);
    }
    
     @WebMethod(operationName = "rejectOrder")
    public int rejectOrder(@WebParam(name = "orderId") int orderId ) {
        
        int order_id = 0; 
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pcpicker", user, pass);
          
            String sql = "{call rejectOrder(?,?)}"; 
            CallableStatement callableStatement = conn.prepareCall(sql);    
            callableStatement.setInt(1,orderId);
            int nextbranch = DistanceCalculator.getNextNearestBranch(getOrder(orderId),getBranchesListCOORD());
            callableStatement.setInt(2, nextbranch);
            callableStatement.executeQuery();
           
            callableStatement.close();
            conn.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }   
        return 1;
    }
     
    @WebMethod(operationName = "completeOrder")
    public int completeOrder(@WebParam(name = "orderId") int orderId ) {
        
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pcpicker", user, pass);
          
            String sql = "{call completeOrder(?)}"; 
            CallableStatement callableStatement = conn.prepareCall(sql);    
            callableStatement.setInt(1,orderId);
            callableStatement.executeQuery();
           
            callableStatement.close();
            conn.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }   
        return 1;
    }
    
    
    private  ArrayList<Branch> getBranchesListCOORD() {
        ArrayList<Branch> a = new ArrayList(); ///////////////////////////////
        int i = 0;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pcpicker", user, pass);

            String sql = "{call get_Branch_list()}"; ////////////////////////////////
            CallableStatement callableStatement = conn.prepareCall(sql);
            ResultSet rs = callableStatement.executeQuery();

            while (rs.next()) {
                int last = a.size();
                a.add(new Branch()); ////////////////////////////////////////////

                a.get(last).setBranch_id(rs.getInt(1));/////////////////////////////
                a.get(last).setCity(rs.getString(2));//////////////////
                a.get(last).setAddress(rs.getString(3));////////////////
                a.get(last).setZip_code(rs.getInt(4));///////////////
                a.get(last).setName(rs.getString(5));
                a.get(last).getCoordinatesFromAPI();
            }
            callableStatement.close();
            conn.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return a;
    }
    
    @WebMethod(operationName = "getCustomer")
    public Customer getCustomer(@WebParam(name = "custId") int custId) {
        Customer a = new Customer();///////////////////////////////      

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pcpicker", user, pass);

            String sql = "{call getCustomer(?)}"; ////////////////////////////////
            
            CallableStatement callableStatement = conn.prepareCall(sql);
            callableStatement.setInt(1,custId);
            ResultSet rs = callableStatement.executeQuery();

            while (rs.next()) {
                
                a.setCust_id(rs.getInt(1));/////////////////////////////
                a.setUsername(rs.getString(2));//////////////////
                //a.setPassword(rs.getString(3));////////////////
                a.setFirstname(rs.getString(4));
                a.setLastname(rs.getString(5));
                a.setAddress(rs.getString(6));///////////////
                a.setCity(rs.getString(7));////////////////
                a.setZip_code(rs.getInt(8));///////////////
            }
            callableStatement.close();
            conn.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return a;
    }
   @WebMethod(operationName = "getOrder")
    public Order getOrder(@WebParam(name = "order_id") int order_id) {
        Order a = new Order();///////////////////////////////      

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pcpicker", user, pass);

            String sql = "{call getOrder(?)}"; ////////////////////////////////
            
            CallableStatement callableStatement = conn.prepareCall(sql);
            callableStatement.setInt(1,order_id);
            ResultSet rs = callableStatement.executeQuery();

            while (rs.next()) {
                
               a.setOrder_id(rs.getInt("order_id"));/////////////////////////////
                a.setCust_id(rs.getInt("cust_id"));//////////////////
                a.setDate_created(rs.getString("date_created"));////////////////
                a.setPayment_type(rs.getString("payment_type"));
                a.setStatus(rs.getInt("status_"));
                a.setItems(getOrderItems(a.getOrder_id()));
                a.setDeliveryDate(rs.getString("deliveryDate"));
                a.setDeliveryAddress(rs.getString("deliveryAddress"));
                a.setNearestBranchRequest(rs.getInt("nearestBranchRequest"));
            }
            callableStatement.close();
            conn.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return a;
    }
//    ------------------------------------------------
//    return lahat ng order na di pa naacept ng branch
//    -----------------------------------------------
    @WebMethod(operationName = "getActivePendingOrderList")
    public ArrayList<Order> getActivePendingOrderList(@WebParam(name = "branch_id") int branch_id) {
        ArrayList<Order> a = new ArrayList(); ///////////////////////////////
        int i = 0;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pcpicker", user, pass);

            String sql = "{call getActivePendingOrders(?)}"; ////////////////////////////////
            CallableStatement callableStatement = conn.prepareCall(sql);
            callableStatement.setInt(1, branch_id);
            ResultSet rs = callableStatement.executeQuery();

            while (rs.next()) {
                int last = a.size();
                a.add(new Order()); ////////////////////////////////////////////

                a.get(last).setOrder_id(rs.getInt("order_id"));/////////////////////////////
                a.get(last).setCust_id(rs.getInt("cust_id"));//////////////////
                a.get(last).setDate_created(rs.getString("date_created"));////////////////
                a.get(last).setPayment_type(rs.getString("payment_type"));
                a.get(last).setStatus(rs.getInt("status_"));
                a.get(last).setItems(getOrderItems(a.get(last).getOrder_id()));
                a.get(last).setDeliveryDate(rs.getString("deliveryDate"));
                a.get(last).setDeliveryAddress(rs.getString("deliveryAddress"));
                a.get(last).setNearestBranchRequest(rs.getInt("nearestBranchRequest"));
               
            }
            callableStatement.close();
            conn.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return a;
    }
    
       @WebMethod(operationName = "getForDeliveryOrders")
    public ArrayList<Order> getForDeliveryOrders(@WebParam(name = "branch_id") int branch_id) {
        ArrayList<Order> a = new ArrayList(); ///////////////////////////////
        int i = 0;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pcpicker", user, pass);

            String sql = "{call getForDeliveryOrders(?)}"; ////////////////////////////////
            CallableStatement callableStatement = conn.prepareCall(sql);
            callableStatement.setInt(1, branch_id);
            ResultSet rs = callableStatement.executeQuery();

            while (rs.next()) {
                int last = a.size();
                a.add(new Order()); ////////////////////////////////////////////

                a.get(last).setOrder_id(rs.getInt("order_id"));/////////////////////////////
                a.get(last).setCust_id(rs.getInt("cust_id"));//////////////////
                a.get(last).setDate_created(rs.getString("date_created"));////////////////
                a.get(last).setPayment_type(rs.getString("payment_type"));
                a.get(last).setStatus(rs.getInt("status_"));
                a.get(last).setItems(getOrderItems(a.get(last).getOrder_id()));
               
                a.get(last).setDeliveryAddress(rs.getString("deliveryAddress"));
                
                System.out.println("asdasdmv,mxcvxcvxcvxvxcvcxvxcvxcv "+a.get(last).getDeliveryAddress());
                a.get(last).setNearestBranchRequest(rs.getInt("nearestBranchRequest"));
                a.get(last).setDeliveryDate(rs.getString("deliveryDate"));
               
            }
            callableStatement.close();
            conn.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return a;
    }
    
    @WebMethod(operationName = "getNumLists")
    public int getNumLists(@WebParam(name = "branchid") int branchid) {
        
        ArrayList<Order> order = getActivePendingOrderList(branchid);
        return order.size();
        
    }
    
    
    @WebMethod(operationName = "setOrderDeliveryDate")
    public void setOrderDeliveryDate(@WebParam(name = "order_id") int order_id, @WebParam(name = "deliveryDate_") String deliveryDate_) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pcpicker", user, pass);
          
            String sql = "{call setOrderDeliveryDate(?,?)}"; 
            CallableStatement callableStatement = conn.prepareCall(sql);
            callableStatement.setInt(1, order_id);
            callableStatement.setString(2,deliveryDate_);
            
            callableStatement.executeUpdate();
            
            callableStatement.close();
            conn.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    @WebMethod(operationName = "acceptOrder")
    public void acceptOrder(@WebParam(name = "order_id") int order_id, @WebParam(name = "branch_id") int branch_id) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pcpicker", user, pass);
          
            String sql = "{call acceptOrder(?,?,?)}"; 
            CallableStatement callableStatement = conn.prepareCall(sql);
            callableStatement.setInt(1, order_id);
            callableStatement.setInt(2,branch_id);
                callableStatement.setNull(3, Types.DATE);
   
            
            callableStatement.executeUpdate();
            
            callableStatement.close();
            conn.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    
//    @WebMethod(operationName = "getActivePendingOrders")
//    public ArrayList<Order> getActivePendingOrders() {
//        ArrayList<Order> a = new ArrayList(); ///////////////////////////////
//        int i = 0;
//
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pcpicker", user, pass);
//
//            String sql = "{call getActivePendingOrders()}"; ////////////////////////////////
//            
//            CallableStatement callableStatement = conn.prepareCall(sql);
//            ResultSet rs = callableStatement.executeQuery();
//
//            while (rs.next()) {
//                int last = a.size();
//                a.add(new Order()); ////////////////////////////////////////////
//
//                a.get(last).setOrder_id(rs.getInt(1));/////////////////////////////
//                a.get(last).setCust_id(rs.getInt(2));//////////////////
//                a.get(last).setDate_created(rs.getString(3));////////////////
//                a.get(last).setPayment_type(rs.getString(4));
//                a.get(last).setActive(rs.getBoolean(5));
//                a.get(last).setItems(getOrderItems(a.get(last).getOrder_id()));
//                a.get(last).setDeliveryDate(rs.getString(7));
//            }
//            callableStatement.close();
//            conn.close();
//        } catch (Exception ex) {
//            System.out.println(ex.getMessage());
//        }
//        return a;
//    }
    
    private ArrayList<Order_Parts> getOrderItems(int order_id) {
        ArrayList<Order_Parts> a = new ArrayList(); ///////////////////////////////
        int i = 0;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pcpicker", user, pass);

            String sql = "{call getOrderItems(?)}"; ////////////////////////////////
            CallableStatement callableStatement = conn.prepareCall(sql);
            callableStatement.setInt(1, order_id);
            ResultSet rs = callableStatement.executeQuery();

            while (rs.next()) {
                int last = a.size();
                a.add(new Order_Parts()); ////////////////////////////////////////////
                a.get(last).setOrder_id(rs.getInt(1));/////////////////////////////t
                String partId = rs.getString(2);
                Part part = getPart(partId);
                a.get(last).setPart_id(partId);//////////////////
                a.get(last).setQuantity(rs.getInt(3));////////////////     
                a.get(last).setPrice(part.getPart_price());
                a.get(last).setPart(part);
            }
            callableStatement.close();
            conn.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return a;
    }
    @WebMethod(operationName = "getPart")
    public Part getPart(@WebParam(name = "part_id") String part_id) {
        //TODO write your implementation code here:
        Part a = new Part(); ///////////////////////////////
        int i = 0;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pcpicker", user, pass);
           
            String sql = "{call getPart('"+part_id+"')}"; ////////////////////////////////
            //String sql = "{call getPart(?)};"; 
            CallableStatement callableStatement = conn.prepareCall(sql);
           // callableStatement.setString("1", part_id);
            
            ResultSet rs = callableStatement.executeQuery();
            while (rs.next()) {
                a.setPart_id(rs.getString(1));/////////////////////////////
                a.setPart_type(rs.getString(2));//////////////////
                a.setPart_manufacturer(rs.getString(3));////////////////
                a.setPart_name(rs.getString(4));///////////////
                a.setPart_price(rs.getDouble(5));////////////////
            //*****************************************nadoble comp_id         
            }
            callableStatement.close();
            conn.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        
        
        return a;
    }
    
    
    
    
    /**
     * Web service operation
     */
    @WebMethod(operationName = "addCPU")    
    public String addCPU(@WebParam(name = "comp_id") String comp_id, @WebParam(name = "comp_manufacturer") String comp_manufacturer, @WebParam(name = "comp_name") String comp_name, @WebParam(name = "core_clock") int core_clock, @WebParam(name = "core_num") int core_num, @WebParam(name = "thread_num") int thread_num, @WebParam(name = "socket_") String socket_, @WebParam(name = "tdp") int tdp, @WebParam(name = "comp_price") double comp_price, @WebParam(name = "comp_type") String comp_type) {
      try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pcpicker", user, pass);

            String sql = "{call add_processor(?,?,?,?,?,?,?,?,?,?)}"; ////////////////////////////////
            CallableStatement callableStatement = conn.prepareCall(sql);
            callableStatement.setString(1, comp_id);
            callableStatement.setString(2, comp_manufacturer);
            callableStatement.setString(3, comp_name);
            callableStatement.setInt(4, core_clock);
            callableStatement.setInt(5, core_num);
            callableStatement.setInt(6, thread_num);
            callableStatement.setString(7, socket_);
            callableStatement.setInt(8, tdp);
            callableStatement.setDouble(9, comp_price);
            callableStatement.setString(10, comp_type);
            
            
            
            callableStatement.executeUpdate();

            callableStatement.close();
            conn.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
      
    
        return "";
    
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "addMemory")
    public String addMemory(@WebParam(name = "comp_id") String comp_id, @WebParam(name = "comp_manufacturer") String comp_manufacturer, @WebParam(name = "comp_name") String comp_name, @WebParam(name = "mem_capacity") int mem_capacity, @WebParam(name = "mem_ddr") String mem_ddr, @WebParam(name = "mem_clock") int mem_clock, @WebParam(name = "comp_price") double comp_price, @WebParam(name = "comp_type") String comp_type) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pcpicker", user, pass);

            String sql = "{call add_memory(?,?,?,?,?,?,?,?,?,?)}"; ////////////////////////////////
            CallableStatement callableStatement = conn.prepareCall(sql);
            callableStatement.setString(1, comp_id);
            callableStatement.setString(2, comp_manufacturer);
            callableStatement.setString(3, comp_name);
            callableStatement.setInt(4, mem_capacity);
            callableStatement.setString(5, mem_ddr);
            callableStatement.setInt(6, mem_clock);
            callableStatement.setDouble(7, comp_price);
            callableStatement.setString(8, comp_type);
            
            
            
            
            callableStatement.executeUpdate();

            callableStatement.close();
            conn.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
          return "";
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "addPowerSupply")
    public String addPowerSupply(@WebParam(name = "comp_id") String comp_id, @WebParam(name = "comp_manufacturer") String comp_manufacturer, @WebParam(name = "comp_name") String comp_name, @WebParam(name = "wattage") int wattage, @WebParam(name = "rating") String rating, @WebParam(name = "form_factor") String form_factor, @WebParam(name = "comp_price") double comp_price, @WebParam(name = "comp_type") String comp_type) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pcpicker", user, pass);

            String sql = "{call add_powersupply(?,?,?,?,?,?,?,?,?,?)}"; ////////////////////////////////
            CallableStatement callableStatement = conn.prepareCall(sql);
            callableStatement.setString(1, comp_id);
            callableStatement.setString(2, comp_manufacturer);
            callableStatement.setString(3, comp_name);
            callableStatement.setInt(4, wattage);
            callableStatement.setString(5, rating);
            callableStatement.setString(6, form_factor);
            callableStatement.setDouble(7, comp_price);
            callableStatement.setString(8, comp_type);
            
            
            
            
            callableStatement.executeUpdate();

            callableStatement.close();
            conn.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
          return "";
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "addGPU")
    public String addGPU(@WebParam(name = "comp_id") String comp_id, @WebParam(name = "comp_manufacturer") String comp_manufacturer, @WebParam(name = "comp_name") String comp_name, @WebParam(name = "core_clock") int core_clock, @WebParam(name = "mem_ddr") String mem_ddr, @WebParam(name = "mem_capacity") String mem_capacity, @WebParam(name = "mem_clock") int mem_clock, @WebParam(name = "comp_price") double comp_price, @WebParam(name = "comp_type") String comp_type) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pcpicker", user, pass);
            String ql2 = "{call add_graphicscard(1,2,3,4,5,6,7,8,9)}";
            String sql = "{call add_graphicscard(?,?,?,?,?,?,?,?,?)}"; ////////////////////////////////
            CallableStatement callableStatement = conn.prepareCall(sql);
            callableStatement.setString(1, comp_id);
            callableStatement.setString(2, comp_manufacturer);
            callableStatement.setString(3, comp_name);
            callableStatement.setInt(4, core_clock);
            callableStatement.setString(5, mem_ddr);
            callableStatement.setString(6, mem_capacity);
            callableStatement.setInt(7, mem_clock);
            callableStatement.setDouble(8, comp_price);
            callableStatement.setString(9, comp_type);

            callableStatement.executeUpdate();

            callableStatement.close();
            conn.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
          return "";
    }
    
    
    @WebMethod(operationName = "getDeliveryList")
    public ArrayList<Delivery> getDeliveryList() {
        ArrayList<Delivery> a = new ArrayList(); ///////////////////////////////
        int i = 0;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pcpicker", user, pass);

            String sql = "{call get_Delivery_list()}"; ////////////////////////////////
            CallableStatement callableStatement = conn.prepareCall(sql);
            ResultSet rs = callableStatement.executeQuery();

            while (rs.next()) {
                int last = a.size();
                a.add(new Delivery()); ////////////////////////////////////////////

                a.get(last).setDelivery_num(rs.getInt(1));/////////////////////////////
                a.get(last).setOrder_id(rs.getInt(2));//////////////////
                a.get(last).setDate_delivery(rs.getString(3));////////////////
                a.get(last).setAccepted_by(rs.getString(4));///////////////
            }
            callableStatement.close();
            conn.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return a;
    }
    @WebMethod(operationName = "getOrder_componentList")
    public ArrayList<Order_Parts> getOrder_componentList() {
        ArrayList<Order_Parts> a = new ArrayList(); ///////////////////////////////
        int i = 0;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pcpicker", user, pass);

            String sql = "{call get_Order_component_list()}"; ////////////////////////////////
            CallableStatement callableStatement = conn.prepareCall(sql);
            ResultSet rs = callableStatement.executeQuery();

            while (rs.next()) {
                int last = a.size();
                a.add(new Order_Parts()); ////////////////////////////////////////////

                a.get(last).setOrder_id(rs.getInt(1));/////////////////////////////
                a.get(last).setPart_id(rs.getString(2));//////////////////
                a.get(last).setQuantity(rs.getInt(3));////////////////
            }
            callableStatement.close();
            conn.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return a;
    }
    
    
    @WebMethod(operationName = "getCustomerList")
    public ArrayList<Customer> getCustomerList() {
        ArrayList<Customer> a = new ArrayList(); ///////////////////////////////
        int i = 0;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pcpicker", user, pass);

            String sql = "{call get_Customer_list()}"; ////////////////////////////////
            CallableStatement callableStatement = conn.prepareCall(sql);
            ResultSet rs = callableStatement.executeQuery();

            while (rs.next()) {
                int last = a.size();
                a.add(new Customer()); ////////////////////////////////////////////

                a.get(last).setCust_id(rs.getInt(1));/////////////////////////////
                a.get(last).setUsername(rs.getString(2));//////////////////
                //a.get(last).setPassword(rs.getString(3));////////////////
                a.get(last).setFirstname(rs.getString(4));
                a.get(last).setLastname(rs.getString(5));
                a.get(last).setAddress(rs.getString(6));///////////////
                a.get(last).setCity(rs.getString(7));////////////////
                a.get(last).setZip_code(rs.getInt(8));/////////////////

            }
            callableStatement.close();
            conn.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return a;
    }

      @WebMethod(operationName = "getBranchesList")
    public ArrayList<Branch> getBranchesList() {
        ArrayList<Branch> a = new ArrayList(); ///////////////////////////////
        int i = 0;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pcpicker", user, pass);

            String sql = "{call get_Branch_list()}"; ////////////////////////////////
            CallableStatement callableStatement = conn.prepareCall(sql);
            ResultSet rs = callableStatement.executeQuery();

            while (rs.next()) {
                int last = a.size();
                a.add(new Branch()); ////////////////////////////////////////////

                a.get(last).setBranch_id(rs.getInt(1));/////////////////////////////
                a.get(last).setCity(rs.getString(2));//////////////////
                a.get(last).setAddress(rs.getString(3));////////////////
                a.get(last).setZip_code(rs.getInt(4));///////////////
                a.get(last).setName(rs.getString(5));
            }
            callableStatement.close();
            conn.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return a;
    }

    @WebMethod(operationName = "getInventoryList")
    public Inventory getInventoryList() {
        ArrayList<InventoryItem> a = new ArrayList(); ///////////////////////////////
        

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pcpicker", user, pass);

            String sql = "{call get_Inventory_list()}"; ////////////////////////////////
            CallableStatement callableStatement = conn.prepareCall(sql);
            ResultSet rs = callableStatement.executeQuery();

            while (rs.next()) {
                int last = a.size();
                a.add(new InventoryItem()); ////////////////////////////////////////////

                a.get(last).setComp_id(rs.getString(1));/////////////////////////////
                a.get(last).setDate_acquired(rs.getString(2));//////////////////
                a.get(last).setBranch_id(rs.getInt(3));////////////////
                a.get(last).setQuantity(rs.getInt(4));///////////////
            
                Part part = getPart(a.get(last).getComp_id());
               
                System.out.println("partid" + part.getPart_id());
                System.out.println(part.getPart_name());
                a.get(last).setPart(part);
            }
            callableStatement.close();
            conn.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        Inventory b = new Inventory();
        b.setItems(a);
        return b;
    }
    
    
    @WebMethod(operationName = "getProcessor")
    public Inventory getProcessor() {
        ArrayList<InventoryItem> a = new ArrayList(); ///////////////////////////////
        

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pcpicker", user, pass);

            String sql = "{call get_Inventory_list()}"; ////////////////////////////////
            CallableStatement callableStatement = conn.prepareCall(sql);
            ResultSet rs = callableStatement.executeQuery();

            while (rs.next()) {
                int last = a.size();
                a.add(new InventoryItem()); ////////////////////////////////////////////

                a.get(last).setComp_id(rs.getString(1));/////////////////////////////
                a.get(last).setDate_acquired(rs.getString(2));//////////////////
                a.get(last).setBranch_id(rs.getInt(3));////////////////
                a.get(last).setQuantity(rs.getInt(4));///////////////
            
                Part part = getPart(a.get(last).getComp_id());
               
                System.out.println("partid" + part.getPart_id());
                System.out.println(part.getPart_name());
                a.get(last).setPart(part);
            }
            callableStatement.close();
            conn.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        Inventory b = new Inventory();
        b.setItems(a);
        return b;
    }
    
    @WebMethod(operationName = "addCooler")    
    public String addCooler(@WebParam(name = "comp_id") String comp_id, @WebParam(name = "comp_manufacturer") String comp_manufacturer, @WebParam(name = "comp_name") String comp_name, @WebParam(name = "supported_sockets") String supported_sockets, @WebParam(name = "liquid_cooling") boolean liquid_cooling, @WebParam(name = "rated_tdp") int rated_tdp, @WebParam(name = "comp_price") double comp_price, @WebParam(name = "comp_type") String comp_type) {
      try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pcpicker", user, pass);

            String sql = "{call add_cooler(?,?,?,?,?,?,?,?)}"; ////////////////////////////////
            CallableStatement callableStatement = conn.prepareCall(sql);
            callableStatement.setString(1, comp_id);
            callableStatement.setString(2, comp_manufacturer);
            callableStatement.setString(3, comp_name);
            callableStatement.setString(4, supported_sockets);
            callableStatement.setBoolean(5, liquid_cooling);
            callableStatement.setInt(6, rated_tdp);
            callableStatement.setDouble(7, comp_price);
            callableStatement.setString(8, comp_type);
            
            callableStatement.executeUpdate();

            callableStatement.close();
            conn.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return "";
    }
    
    @WebMethod(operationName = "addMotherboard")    
    public String addMotherboard(@WebParam(name = "comp_id") String comp_id, @WebParam(name = "comp_manufacturer") String comp_manufacturer, @WebParam(name = "comp_name") String comp_name, @WebParam(name = "socket") String socket, @WebParam(name = "mem_slots") int mem_slots, @WebParam(name = "form_factor") String form_factor, @WebParam(name = "comp_price") double comp_price, @WebParam(name = "comp_type") String comp_type) {
      try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pcpicker", user, pass);

            String sql = "{call add_motherboard(?,?,?,?,?,?,?,?)}"; ////////////////////////////////
            CallableStatement callableStatement = conn.prepareCall(sql);
            callableStatement.setString(1, comp_id);
            callableStatement.setString(2, comp_manufacturer);
            callableStatement.setString(3, comp_name);
            callableStatement.setString(4, socket);
            callableStatement.setInt(5, mem_slots);
            callableStatement.setString(6, form_factor);
            callableStatement.setDouble(7, comp_price);
            callableStatement.setString(8, comp_type);
            
            callableStatement.executeUpdate();

            callableStatement.close();
            conn.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return "";
    }
    
    @WebMethod(operationName = "addStorage")    
    public String addStorage(@WebParam(name = "comp_id") String comp_id, @WebParam(name = "comp_manufacturer") String comp_manufacturer, @WebParam(name = "comp_name") String comp_name, @WebParam(name = "type_") String type_, @WebParam(name = "capacity") int capacity, @WebParam(name = "interface_") String interface_, @WebParam(name = "comp_price") double comp_price, @WebParam(name = "comp_type") String comp_type) {
      try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pcpicker", user, pass);

            String sql = "{call add_storage(?,?,?,?,?,?,?,?)}"; ////////////////////////////////
            CallableStatement callableStatement = conn.prepareCall(sql);
            callableStatement.setString(1, comp_id);
            callableStatement.setString(2, comp_manufacturer);
            callableStatement.setString(3, comp_name);
            callableStatement.setString(4, type_);
            callableStatement.setInt(5, capacity);
            callableStatement.setString(6, interface_);
            callableStatement.setDouble(7, comp_price);
            callableStatement.setString(8, comp_type);
            
            callableStatement.executeUpdate();

            callableStatement.close();
            conn.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return "";
    }
    
    @WebMethod(operationName = "addMouse")    
    public String addMouse(@WebParam(name = "comp_id") String comp_id, @WebParam(name = "comp_manufacturer") String comp_manufacturer, @WebParam(name = "comp_name") String comp_name, @WebParam(name = "dpi") int dpi, @WebParam(name = "connection_") String connection_, @WebParam(name = "comp_price") double comp_price, @WebParam(name = "comp_type") String comp_type) {
      try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pcpicker", user, pass);

            String sql = "{call add_mouse(?,?,?,?,?,?,?)}"; ////////////////////////////////
            CallableStatement callableStatement = conn.prepareCall(sql);
            callableStatement.setString(1, comp_id);
            callableStatement.setString(2, comp_manufacturer);
            callableStatement.setString(3, comp_name);
            callableStatement.setInt(4, dpi);
            callableStatement.setString(5, connection_);
            callableStatement.setDouble(6, comp_price);
            callableStatement.setString(7, comp_type);
            
            callableStatement.executeUpdate();

            callableStatement.close();
            conn.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return "";
    }
    
        @WebMethod(operationName = "addKeyboard")    
    public String addKeyboard(@WebParam(name = "comp_id") String comp_id, @WebParam(name = "comp_manufacturer") String comp_manufacturer, @WebParam(name = "comp_name") String comp_name, @WebParam(name = "backlit") boolean backlit, @WebParam(name = "type_") String type_, @WebParam(name = "comp_price") double comp_price, @WebParam(name = "comp_type") String comp_type) {
      try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pcpicker", user, pass);

            String sql = "{call add_keyboard(?,?,?,?,?,?,?)}"; ////////////////////////////////
            CallableStatement callableStatement = conn.prepareCall(sql);
            callableStatement.setString(1, comp_id);
            callableStatement.setString(2, comp_manufacturer);
            callableStatement.setString(3, comp_name);
            callableStatement.setBoolean(4, backlit);
            callableStatement.setString(5, type_);
            callableStatement.setDouble(6, comp_price);
            callableStatement.setString(7, comp_type);
            
            callableStatement.executeUpdate();

            callableStatement.close();
            conn.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return "";
    }
    
    @WebMethod(operationName = "addMonitor")    
    public String addMonitor(@WebParam(name = "comp_id") String comp_id, @WebParam(name = "comp_manufacturer") String comp_manufacturer, @WebParam(name = "comp_name") String comp_name, @WebParam(name = "aspect_ratio") String aspect_ratio, @WebParam(name = "screen_size") String screen_size, @WebParam(name = "max_resolution") String max_resolution, @WebParam(name = "refresh_rate") int refresh_rate, @WebParam(name = "comp_price") double comp_price, @WebParam(name = "comp_type") String comp_type) {
      try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pcpicker", user, pass);

            String sql = "{call add_monitor(?,?,?,?,?,?,?,?,?)}"; ////////////////////////////////
            CallableStatement callableStatement = conn.prepareCall(sql);
            callableStatement.setString(1, comp_id);
            callableStatement.setString(2, comp_manufacturer);
            callableStatement.setString(3, comp_name);
            callableStatement.setString(4, aspect_ratio);
            callableStatement.setString(5, screen_size);
            callableStatement.setString(6, max_resolution);
            callableStatement.setInt(7, refresh_rate);
            callableStatement.setDouble(8, comp_price);
            callableStatement.setString(9, comp_type);
            
            callableStatement.executeUpdate();

            callableStatement.close();
            conn.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return "";
    }

}
