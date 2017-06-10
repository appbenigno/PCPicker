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
import java.util.ArrayList;
import javax.jws.Oneway;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import pcpicker.Branch;
import pcpicker.Customer;
import pcpicker.Delivery;
import pcpicker.Inventory;
import pcpicker.Order;
import pcpicker.Order_component;

/**
 *
 * @author admin
 */
@WebService(serviceName = "Pcpicker_webserviceForDesktop")
public class Pcpicker_webserviceForDesktop {

    String user="root"; // meron rin sa Pcpicker_webservice
    String pass="1825";
    
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
    
      @WebMethod(operationName = "getOrderList")
    public ArrayList<Order> getOrderList() {
        ArrayList<Order> a = new ArrayList(); ///////////////////////////////
        int i = 0;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pcpicker", user, pass);

            String sql = "{call get_Order_list()}"; ////////////////////////////////
            CallableStatement callableStatement = conn.prepareCall(sql);
            ResultSet rs = callableStatement.executeQuery();

            while (rs.next()) {
                int last = a.size();
                a.add(new Order()); ////////////////////////////////////////////

                a.get(last).setOrder_id(rs.getInt(1));/////////////////////////////
                a.get(last).setCust_id(rs.getInt(2));//////////////////
                a.get(last).setDate_created(rs.getString(3));////////////////
                a.get(last).setPayment_type(rs.getString(4));///////////////
            }
            callableStatement.close();
            conn.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return a;
    }

    @WebMethod(operationName = "getOrder_componentList")
    public ArrayList<Order_component> getOrder_componentList() {
        ArrayList<Order_component> a = new ArrayList(); ///////////////////////////////
        int i = 0;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pcpicker", user, pass);

            String sql = "{call get_Order_component_list()}"; ////////////////////////////////
            CallableStatement callableStatement = conn.prepareCall(sql);
            ResultSet rs = callableStatement.executeQuery();

            while (rs.next()) {
                int last = a.size();
                a.add(new Order_component()); ////////////////////////////////////////////

                a.get(last).setOrder_id(rs.getInt(1));/////////////////////////////
                a.get(last).setComp_id(rs.getString(2));//////////////////
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
                a.get(last).setPassword(rs.getString(3));////////////////
                a.get(last).setAddress(rs.getString(4));///////////////
                a.get(last).setCity(rs.getString(5));////////////////
                a.get(last).setZip_code(rs.getInt(6));/////////////////
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
            }
            callableStatement.close();
            conn.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return a;
    }

    @WebMethod(operationName = "getInventoryList")
    public ArrayList<Inventory> getInventoryList() {
        ArrayList<Inventory> a = new ArrayList(); ///////////////////////////////
        int i = 0;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pcpicker", user, pass);

            String sql = "{call get_Inventory_list()}"; ////////////////////////////////
            CallableStatement callableStatement = conn.prepareCall(sql);
            ResultSet rs = callableStatement.executeQuery();

            while (rs.next()) {
                int last = a.size();
                a.add(new Inventory()); ////////////////////////////////////////////

                a.get(last).setComp_id(rs.getInt(1));/////////////////////////////
                a.get(last).setDate_acquired(rs.getString(2));//////////////////
                a.get(last).setBranch_id(rs.getInt(3));////////////////
                a.get(last).setQuantity(rs.getInt(4));///////////////
            
                a.get(last).setComp_name(rs.getString(6));
                a.get(last).setComp_price(rs.getDouble(7));
                a.get(last).setComp_manufacturer(rs.getString(8));
                a.get(last).setComp_type(rs.getString(9));
            }
            callableStatement.close();
            conn.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return a;
    }

}
