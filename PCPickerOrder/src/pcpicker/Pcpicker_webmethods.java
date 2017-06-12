/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pcpicker;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author PD
 */
public class Pcpicker_webmethods {

    public ArrayList<Processor> getProcessorList() {
        ArrayList<Processor> a = new ArrayList(); ///////////////////////////////
        int i = 0;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql::localhost:3306/pcpicker", "root", "");

            String sql = "{call get_processor_list()}"; ////////////////////////////////
            CallableStatement callableStatement = conn.prepareCall(sql);
            ResultSet rs = callableStatement.executeQuery();

            while (rs.next()) {
                int last = a.size();
                a.add(new Processor()); ////////////////////////////////////////////

                a.get(last).setPart_id(rs.getString(1));/////////////////////////////
                a.get(last).setPart_type(rs.getString(2));//////////////////
                a.get(last).setPart_manufacturer(rs.getString(3));////////////////
                a.get(last).setPart_name(rs.getString(4));///////////////
                a.get(last).setPart_price(rs.getDouble(5));////////////////
                //*****************************************nadoble comp_id
                a.get(last).setCore_clock(rs.getDouble(7));/////////////////
                a.get(last).setCore_num(rs.getInt(8));/////////////////
                a.get(last).setThread_num(rs.getInt(9));////////////////////
                a.get(last).setSocket_(rs.getString(10));////////////////
                a.get(last).setTdp(rs.getInt(11));/////////////////////
            }
            callableStatement.close();
            conn.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return a;
    }

    public ArrayList<Cooler> getCoolerList() {
        ArrayList<Cooler> a = new ArrayList(); ///////////////////////////////
        int i = 0;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql::localhost:3306/pcpicker", "root", "");

            String sql = "{call get_Cooler_list()}"; ////////////////////////////////
            CallableStatement callableStatement = conn.prepareCall(sql);
            ResultSet rs = callableStatement.executeQuery();

            while (rs.next()) {
                int last = a.size();
                a.add(new Cooler()); ////////////////////////////////////////////

                a.get(last).setPart_id(rs.getString(1));/////////////////////////////
                a.get(last).setPart_type(rs.getString(2));//////////////////
                a.get(last).setPart_manufacturer(rs.getString(3));////////////////
                a.get(last).setPart_name(rs.getString(4));///////////////
                a.get(last).setPart_price(rs.getDouble(5));////////////////
                //*****************************************nadoble comp_id
                a.get(last).setSupported_sockets(rs.getString(7));/////////////////
                a.get(last).setLiquid_cooling(rs.getBoolean(8));/////////////////
                a.get(last).setRated_tdp(rs.getInt(9));////////////////////
            }
            callableStatement.close();
            conn.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return a;
    }

    public ArrayList<GraphicsCard> getGraphicsCardList() {
        ArrayList<GraphicsCard> a = new ArrayList(); ///////////////////////////////
        int i = 0;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql::localhost:3306/pcpicker", "root", "");

            String sql = "{call get_processor_list()}"; ////////////////////////////////
            CallableStatement callableStatement = conn.prepareCall(sql);
            ResultSet rs = callableStatement.executeQuery();

            while (rs.next()) {
                int last = a.size();
                a.add(new GraphicsCard()); ////////////////////////////////////////////

                a.get(last).setPart_id(rs.getString(1));/////////////////////////////
                a.get(last).setPart_type(rs.getString(2));//////////////////
                a.get(last).setPart_manufacturer(rs.getString(3));////////////////
                a.get(last).setPart_name(rs.getString(4));///////////////
                a.get(last).setPart_price(rs.getDouble(5));////////////////
                //*****************************************nadoble comp_id
                a.get(last).setCore_clock(rs.getInt(7));/////////////////
                a.get(last).setMem_ddr(rs.getString(8));/////////////////
                a.get(last).setMem_capacity(rs.getInt(9));////////////////////
                a.get(last).setMem_clock(rs.getInt(11));/////////////////////
            }
            callableStatement.close();
            conn.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return a;
    }

    public ArrayList<Keyboard> getKeyboardList() {
        ArrayList<Keyboard> a = new ArrayList(); ///////////////////////////////
        int i = 0;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql::localhost:3306/pcpicker", "root", "");

            String sql = "{call get_processor_list()}"; ////////////////////////////////
            CallableStatement callableStatement = conn.prepareCall(sql);
            ResultSet rs = callableStatement.executeQuery();

            while (rs.next()) {
                int last = a.size();
                a.add(new Keyboard()); ////////////////////////////////////////////

                a.get(last).setPart_id(rs.getString(1));/////////////////////////////
                a.get(last).setPart_type(rs.getString(2));//////////////////
                a.get(last).setPart_manufacturer(rs.getString(3));////////////////
                a.get(last).setPart_name(rs.getString(4));///////////////
                a.get(last).setPart_price(rs.getDouble(5));////////////////
                //*****************************************nadoble comp_id
                a.get(last).setBacklit(rs.getBoolean(7));/////////////////
                a.get(last).setType_(rs.getString(8));/////////////////
            }
            callableStatement.close();
            conn.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return a;
    }

    public ArrayList<Memory> getMemoryList() {
        ArrayList<Memory> a = new ArrayList(); ///////////////////////////////
        int i = 0;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql::localhost:3306/pcpicker", "root", "");

            String sql = "{call get_processor_list()}"; ////////////////////////////////
            CallableStatement callableStatement = conn.prepareCall(sql);
            ResultSet rs = callableStatement.executeQuery();

            while (rs.next()) {
                int last = a.size();
                a.add(new Memory()); ////////////////////////////////////////////

                a.get(last).setPart_id(rs.getString(1));/////////////////////////////
                a.get(last).setPart_type(rs.getString(2));//////////////////
                a.get(last).setPart_manufacturer(rs.getString(3));////////////////
                a.get(last).setPart_name(rs.getString(4));///////////////
                a.get(last).setPart_price(rs.getDouble(5));////////////////
                //*****************************************nadoble comp_id
                a.get(last).setMem_capacity(rs.getInt(7));/////////////////
                a.get(last).setMem_ddr(rs.getString(8));/////////////////
                a.get(last).setMem_clock(rs.getInt(9));////////////////////
            }
            callableStatement.close();
            conn.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return a;
    }

    public ArrayList<Monitor> getMonitorList() {
        ArrayList<Monitor> a = new ArrayList(); ///////////////////////////////
        int i = 0;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql::localhost:3306/pcpicker", "root", "");

            String sql = "{call get_processor_list()}"; ////////////////////////////////
            CallableStatement callableStatement = conn.prepareCall(sql);
            ResultSet rs = callableStatement.executeQuery();

            while (rs.next()) {
                int last = a.size();
                a.add(new Monitor()); ////////////////////////////////////////////

                a.get(last).setPart_id(rs.getString(1));/////////////////////////////
                a.get(last).setPart_type(rs.getString(2));//////////////////
                a.get(last).setPart_manufacturer(rs.getString(3));////////////////
                a.get(last).setPart_name(rs.getString(4));///////////////
                a.get(last).setPart_price(rs.getDouble(5));////////////////
                //*****************************************nadoble comp_id
                a.get(last).setAspect_ratio(rs.getString(7));/////////////////
                a.get(last).setScreen_size(rs.getInt(8));/////////////////
                a.get(last).setMax_resolution(rs.getString(9));////////////////////
                a.get(last).setRefresh_rate(rs.getInt(10));////////////////
            }
            callableStatement.close();
            conn.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return a;
    }

    public ArrayList<Motherboard> getMotherboardList() {
        ArrayList<Motherboard> a = new ArrayList(); ///////////////////////////////
        int i = 0;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql::localhost:3306/pcpicker", "root", "");

            String sql = "{call get_processor_list()}"; ////////////////////////////////
            CallableStatement callableStatement = conn.prepareCall(sql);
            ResultSet rs = callableStatement.executeQuery();

            while (rs.next()) {
                int last = a.size();
                a.add(new Motherboard()); ////////////////////////////////////////////

                a.get(last).setPart_id(rs.getString(1));/////////////////////////////
                a.get(last).setPart_type(rs.getString(2));//////////////////
                a.get(last).setPart_manufacturer(rs.getString(3));////////////////
                a.get(last).setPart_name(rs.getString(4));///////////////
                a.get(last).setPart_price(rs.getDouble(5));////////////////
                //*****************************************nadoble comp_id
                a.get(last).setSocket(rs.getString(7));/////////////////
                a.get(last).setMem_slots(rs.getInt(8));/////////////////
                a.get(last).setForm_factor(rs.getString(9));////////////////////
            }
            callableStatement.close();
            conn.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return a;
    }

    public ArrayList<Mouse> getMouseList() {
        ArrayList<Mouse> a = new ArrayList(); ///////////////////////////////
        int i = 0;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql::localhost:3306/pcpicker", "root", "");

            String sql = "{call get_processor_list()}"; ////////////////////////////////
            CallableStatement callableStatement = conn.prepareCall(sql);
            ResultSet rs = callableStatement.executeQuery();

            while (rs.next()) {
                int last = a.size();
                a.add(new Mouse()); ////////////////////////////////////////////

                a.get(last).setPart_id(rs.getString(1));/////////////////////////////
                a.get(last).setPart_type(rs.getString(2));//////////////////
                a.get(last).setPart_manufacturer(rs.getString(3));////////////////
                a.get(last).setPart_name(rs.getString(4));///////////////
                a.get(last).setPart_price(rs.getDouble(5));////////////////
                //*****************************************nadoble comp_id
                a.get(last).setDpi(rs.getInt(7));/////////////////
                a.get(last).setConnection_(rs.getString(8));/////////////////
            }
            callableStatement.close();
            conn.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return a;
    }

    public ArrayList<Storage> getStorageList() {
        ArrayList<Storage> a = new ArrayList(); ///////////////////////////////
        int i = 0;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql::localhost:3306/pcpicker", "root", "");

            String sql = "{call get_processor_list()}"; ////////////////////////////////
            CallableStatement callableStatement = conn.prepareCall(sql);
            ResultSet rs = callableStatement.executeQuery();

            while (rs.next()) {
                int last = a.size();
                a.add(new Storage()); ////////////////////////////////////////////

                a.get(last).setPart_id(rs.getString(1));/////////////////////////////
                a.get(last).setPart_type(rs.getString(2));//////////////////
                a.get(last).setPart_manufacturer(rs.getString(3));////////////////
                a.get(last).setPart_name(rs.getString(4));///////////////
                a.get(last).setPart_price(rs.getDouble(5));////////////////
                //*****************************************nadoble comp_id
                a.get(last).setType_(rs.getString(7));/////////////////
                a.get(last).setCapacity(rs.getInt(8));/////////////////
                a.get(last).setInterface_(rs.getString(8));
            }
            callableStatement.close();
            conn.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return a;
    }

    public ArrayList<PowerSupply> getPowerSupplyList() {
        ArrayList<PowerSupply> a = new ArrayList(); ///////////////////////////////
        int i = 0;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql::localhost:3306/pcpicker", "root", "");

            String sql = "{call get_processor_list()}"; ////////////////////////////////
            CallableStatement callableStatement = conn.prepareCall(sql);
            ResultSet rs = callableStatement.executeQuery();

            while (rs.next()) {
                int last = a.size();
                a.add(new PowerSupply()); ////////////////////////////////////////////

                a.get(last).setPart_id(rs.getString(1));/////////////////////////////
                a.get(last).setPart_type(rs.getString(2));//////////////////
                a.get(last).setPart_manufacturer(rs.getString(3));////////////////
                a.get(last).setPart_name(rs.getString(4));///////////////
                a.get(last).setPart_price(rs.getDouble(5));////////////////
                //*****************************************nadoble comp_id
                a.get(last).setWattage(rs.getInt(7));/////////////////
                a.get(last).setRating(rs.getString(8));/////////////////
                a.get(last).setForm_factor(rs.getString(8));
            }
            callableStatement.close();
            conn.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return a;
    }

    public ArrayList<Branch> getBranchesList() {
        ArrayList<Branch> a = new ArrayList(); ///////////////////////////////
        int i = 0;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql::localhost:3306/pcpicker", "root", "");

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

    public ArrayList<Inventory> getInventoryList() {
        ArrayList<Inventory> a = new ArrayList(); ///////////////////////////////
        int i = 0;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql::localhost:3306/pcpicker", "root", "");

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

    public ArrayList<Customer> getCustomerList() {
        ArrayList<Customer> a = new ArrayList(); ///////////////////////////////
        int i = 0;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql::localhost:3306/pcpicker", "root", "");

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

    public ArrayList<Order> getOrderList() {
        ArrayList<Order> a = new ArrayList(); ///////////////////////////////
        int i = 0;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql::localhost:3306/pcpicker", "root", "");

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

    public ArrayList<Order_component> getOrder_componentList() {
        ArrayList<Order_component> a = new ArrayList(); ///////////////////////////////
        int i = 0;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql::localhost:3306/pcpicker", "root", "");

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

    public ArrayList<Delivery> getDeliveryList() {
        ArrayList<Delivery> a = new ArrayList(); ///////////////////////////////
        int i = 0;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql::localhost:3306/pcpicker", "root", "");

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

    public ArrayList<Image> getImageList() {
        ArrayList<Image> a = new ArrayList(); ///////////////////////////////
        int i = 0;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql::localhost:3306/pcpicker", "root", "");

            String sql = "{call get_Image_list()}"; ////////////////////////////////
            CallableStatement callableStatement = conn.prepareCall(sql);
            ResultSet rs = callableStatement.executeQuery();

            while (rs.next()) {
                int last = a.size();
                a.add(new Image()); ////////////////////////////////////////////

                a.get(last).setComp_id(rs.getString(1));/////////////////////////////
                a.get(last).setImageclass(rs.getString(2));//////////////////
                a.get(last).setImagepath(rs.getString(3));////////////////
            }
            callableStatement.close();
            conn.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return a;
    }
}
