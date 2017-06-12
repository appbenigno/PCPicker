package pcpicker;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.*;
import javax.jws.*;

/**
 *
 * @author PD
 */
@WebService(serviceName = "pcpicker_webservice")
public class Pcpicker_webservice
{
    String user="root"; // meron rin sa Pcpicker_webserviceForDesktop
    String pass="1825";
    
   
    
    
        /**
     * Web service operation
     * @param part_id
     * @return 
     */
    
    
    
    @WebMethod(operationName = "getProcessorList")
    public ArrayList<Processor> getProcessorList() {
        ArrayList<Processor> a = new ArrayList(); ///////////////////////////////
        int i = 0;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pcpicker", user, pass);

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

    @WebMethod(operationName = "getCoolerList")
    public ArrayList<Cooler> getCoolerList() {
        ArrayList<Cooler> a = new ArrayList(); ///////////////////////////////
        int i = 0;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pcpicker", user, pass);

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

    @WebMethod(operationName = "getGraphicsCardList")
    public ArrayList<GraphicsCard> getGraphicsCardList() {
        ArrayList<GraphicsCard> a = new ArrayList(); ///////////////////////////////
        int i = 0;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pcpicker", user, pass);

            String sql = "{call get_graphicscard_list()}"; ////////////////////////////////
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
                a.get(last).setMem_clock(rs.getInt(10));/////////////////////
            }
            callableStatement.close();
            conn.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return a;
    }

    @WebMethod(operationName = "getKeyboardList")
    public ArrayList<Keyboard> getKeyboardList() {
        ArrayList<Keyboard> a = new ArrayList(); ///////////////////////////////
        int i = 0;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pcpicker", user, pass);

            String sql = "{call get_keyboard_list()}"; ////////////////////////////////
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

    @WebMethod(operationName = "getMemoryList")
    public ArrayList<Memory> getMemoryList() {
        ArrayList<Memory> a = new ArrayList(); ///////////////////////////////
        int i = 0;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pcpicker", user, pass);

            String sql = "{call get_Memory_list()}"; ////////////////////////////////
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

    @WebMethod(operationName = "getMonitorList")
    public ArrayList<Monitor> getMonitorList() {
        ArrayList<Monitor> a = new ArrayList(); ///////////////////////////////
        int i = 0;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pcpicker", user, pass);

            String sql = "{call get_Memory_list()}"; ////////////////////////////////
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

    @WebMethod(operationName = "getMotherboardList")
    public ArrayList<Motherboard> getMotherboardList() {
        ArrayList<Motherboard> a = new ArrayList(); ///////////////////////////////
        int i = 0;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pcpicker", user, pass);

            String sql = "{call get_Motherboard_list()}"; ////////////////////////////////
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

    @WebMethod(operationName = "getMouseList")
    public ArrayList<Mouse> getMouseList() {
        ArrayList<Mouse> a = new ArrayList(); ///////////////////////////////
        int i = 0;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pcpicker", user, pass);

            String sql = "{call get_Mouse_list()}"; ////////////////////////////////
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

    @WebMethod(operationName = "getStorageList")
    public ArrayList<Storage> getStorageList() {
        ArrayList<Storage> a = new ArrayList(); ///////////////////////////////
        int i = 0;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pcpicker", user, pass);

            String sql = "{call get_storage_list()}"; ////////////////////////////////
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

    @WebMethod(operationName = "getPowerSupplyList")
    public ArrayList<PowerSupply> getPowerSupplyList() {
        ArrayList<PowerSupply> a = new ArrayList(); ///////////////////////////////
        int i = 0;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pcpicker", user, pass);

            String sql = "{call get_PowerSupply_list()}"; ////////////////////////////////
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

  

  


    @WebMethod(operationName = "getImageList")
    public ArrayList<Image> getImageList() {
        ArrayList<Image> a = new ArrayList(); ///////////////////////////////
        int i = 0;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pcpicker", user, pass);

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

    
    /**
     * Web service operation
     */
    @WebMethod(operationName = "getManufacturers")
    public ArrayList<String> getManufacturers(@WebParam(name = "type") String type) {
          ArrayList<String> a = new ArrayList(); ///////////////////////////////
        int i = 0;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pcpicker", user, pass);

            String sql = "{call getManufacturers(?)}"; ////////////////////////////////
            CallableStatement callableStatement = conn.prepareCall(sql);
            callableStatement.setString(1, type);
            ResultSet rs = callableStatement.executeQuery();

            while (rs.next()) {
              
                a.add(rs.getString(1)); ////////////////////////////////////////////

           
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
    @WebMethod(operationName = "getMemoryTypes")
    public ArrayList<String> getMemoryTypes() {
         ArrayList<String> a = new ArrayList(); ///////////////////////////////
        int i = 0;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pcpicker", user, pass);

            String sql = "{call getMemoryTypes()}"; ////////////////////////////////
            CallableStatement callableStatement = conn.prepareCall(sql);
            ResultSet rs = callableStatement.executeQuery();

            while (rs.next()) {
              
                a.add(rs.getString(1)); ////////////////////////////////////////////

           
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
    @WebMethod(operationName = "getGPUMemoryTypes")
    public ArrayList<String> getGPUMemoryTypes() {
         ArrayList<String> a = new ArrayList(); ///////////////////////////////
        int i = 0;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pcpicker", user, pass);

            String sql = "{call getGPUMemoryTypes()}"; ////////////////////////////////
            CallableStatement callableStatement = conn.prepareCall(sql);
            ResultSet rs = callableStatement.executeQuery();

            while (rs.next()) {
              
                a.add(rs.getString(1)); ////////////////////////////////////////////

           
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
    @WebMethod(operationName = "getMaxResolutions")
    public ArrayList<String> getMaxResolutions() {
        ArrayList<String> a = new ArrayList(); ///////////////////////////////
        int i = 0;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pcpicker", user, pass);

            String sql = "{call getMaxResolutions()}"; ////////////////////////////////
            CallableStatement callableStatement = conn.prepareCall(sql);
            ResultSet rs = callableStatement.executeQuery();

            while (rs.next()) {
              
                a.add(rs.getString(1)); ////////////////////////////////////////////

           
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
    @WebMethod(operationName = "addCustomer")
    public String addCustomer(@WebParam(name = "username") String username, @WebParam(name = "password") String password, @WebParam(name = "address") String address, @WebParam(name = "city") String city, @WebParam(name = "zipCode") int zipCode) {
        return "";
    }
 
    

}
