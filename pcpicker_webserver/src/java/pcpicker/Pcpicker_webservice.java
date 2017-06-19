package pcpicker;

import Pcpicker_webserviceForDesktop.Branch;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.*;
import javax.jws.*;
import shared.DistanceCalculator;

/**
 *
 * @author PD
 */
@WebService(serviceName = "pcpicker_webservice")
public class Pcpicker_webservice
{
    String user="root"; // meron rin sa Pcpicker_webserviceForDesktop
    String pass="1825";

    private Boolean filterPart(Part p, String search, String manufacturer, Integer minPrice, Integer maxPrice)
    {
        Boolean remove = false;
        
        
        if(search != null)        
            if( (!p.part_id.toLowerCase().contains(search.toLowerCase()))  &&  (!p.part_name.toLowerCase().contains(search.toLowerCase())))
                remove = true;
        
        if(manufacturer != null)
            if(!p.part_manufacturer.toLowerCase().contains(manufacturer.toLowerCase()))
                remove = true;
        
        if(minPrice != null)
            if(p.part_price < minPrice)
                return true;
        
        if(maxPrice != null)
            if(p.part_price > maxPrice)
                return true;
        
        return remove;
    }
    private String convertComponentType(String compType)
    {
        if(compType.equals("CPU"))
            compType = "Processor";
        else if(compType.equals("GPU"))
            compType = "Graphics Card";
        else if(compType.equals("Cooler"))
            compType = "Heatsink";
        
        return compType;
    }
    
    @WebMethod(operationName = "getMaxPrice")
    public double getMaxPrice(@WebParam(name = "compType") String compType) {
        double max=0.0;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pcpicker", user, pass);

            String sql = "{call getMaxPrice(?)}"; ////////////////////////////////
            compType = convertComponentType(compType);            
            CallableStatement callableStatement = conn.prepareCall(sql);
            callableStatement.setString(1,compType);
            ResultSet rs = callableStatement.executeQuery();

            while (rs.next()) {
                max = rs.getDouble(1);
            }
            callableStatement.close();
            conn.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return max;
    }
    
    @WebMethod(operationName = "getProcessorList")
    public ArrayList<Processor> getProcessorList(
            @WebParam(name = "search") String search,
            @WebParam(name = "manufacturer") String manufacturer,
            @WebParam(name = "minPrice") Integer minPrice,
            @WebParam(name = "maxPrice") Integer maxPrice) {
        ArrayList<Processor> a = new ArrayList(); ///////////////////////////////
        int i = 0;
        System.out.println("Server manufacturer " + manufacturer);
        System.out.println("server search " + search);
        System.out.println("server min " + minPrice);
        System.out.println("server max " + maxPrice);
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
                a.get(last).setImagePath(rs.getString(6));////////////////
                //*****************************************nadoble comp_id
                a.get(last).setCore_clock(rs.getDouble(8));/////////////////
                a.get(last).setCore_num(rs.getInt(9));/////////////////
                a.get(last).setThread_num(rs.getInt(10));////////////////////
                a.get(last).setSocket_(rs.getString(11));////////////////
                a.get(last).setTdp(rs.getInt(12));/////////////////////
                
                if(filterPart(a.get(last),search,manufacturer,minPrice,maxPrice))
                    a.remove(last);
                
            }
            callableStatement.close();
            conn.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return a;
    }

    @WebMethod(operationName = "getCoolerList")
    public ArrayList<Cooler> getCoolerList(
            @WebParam(name = "search") String search,
            @WebParam(name = "manufacturer") String manufacturer,
            @WebParam(name = "minPrice") Integer minPrice,
            @WebParam(name = "maxPrice") Integer maxPrice) {
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
                a.get(last).setImagePath(rs.getString(6));////////////////
                //*****************************************nadoble comp_id
                a.get(last).setSupported_sockets(rs.getString(8));/////////////////
                a.get(last).setLiquid_cooling(rs.getBoolean(9));/////////////////
                a.get(last).setRated_tdp(rs.getInt(10));////////////////////
                if(filterPart(a.get(last),search,manufacturer,minPrice,maxPrice))
                    a.remove(last);
            }
            callableStatement.close();
            conn.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return a;
    }

    @WebMethod(operationName = "getGraphicsCardList")
    public ArrayList<GraphicsCard> getGraphicsCardList(
            @WebParam(name = "search") String search,
            @WebParam(name = "manufacturer") String manufacturer,
            @WebParam(name = "minPrice") Integer minPrice,
            @WebParam(name = "maxPrice") Integer maxPrice) {
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
                a.get(last).setImagePath(rs.getString(6));////////////////
                //*****************************************nadoble comp_id
                a.get(last).setCore_clock(rs.getInt(8));/////////////////
                a.get(last).setMem_ddr(rs.getString(9));/////////////////
                a.get(last).setMem_capacity(rs.getInt(10));////////////////////
                a.get(last).setMem_clock(rs.getInt(11));/////////////////////
                if(filterPart(a.get(last),search,manufacturer,minPrice,maxPrice))
                    a.remove(last);
            }
            callableStatement.close();
            conn.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return a;
    }

    @WebMethod(operationName = "getKeyboardList")
    public ArrayList<Keyboard> getKeyboardList(
            @WebParam(name = "search") String search,
            @WebParam(name = "manufacturer") String manufacturer,
            @WebParam(name = "minPrice") Integer minPrice,
            @WebParam(name = "maxPrice") Integer maxPrice) {
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
                a.get(last).setImagePath(rs.getString(6));////////////////
                //*****************************************nadoble comp_id
                a.get(last).setBacklit(rs.getBoolean(8));/////////////////
                a.get(last).setType_(rs.getString(9));/////////////////
                if(filterPart(a.get(last),search,manufacturer,minPrice,maxPrice))
                    a.remove(last);
            }
            callableStatement.close();
            conn.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return a;
    }

    @WebMethod(operationName = "getMemoryList")
    public ArrayList<Memory> getMemoryList(
            @WebParam(name = "search") String search,
            @WebParam(name = "manufacturer") String manufacturer,
            @WebParam(name = "minPrice") Integer minPrice,
            @WebParam(name = "maxPrice") Integer maxPrice) {
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
                a.get(last).setImagePath(rs.getString(6));////////////////
                //*****************************************nadoble comp_id
                a.get(last).setMem_capacity(rs.getInt(8));/////////////////
                a.get(last).setMem_ddr(rs.getString(9));/////////////////
                a.get(last).setMem_clock(rs.getInt(10));////////////////////
                if(filterPart(a.get(last),search,manufacturer,minPrice,maxPrice))
                    a.remove(last);
            }
            callableStatement.close();
            conn.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return a;
    }

    @WebMethod(operationName = "getMonitorList")
    public ArrayList<Monitor> getMonitorList(
            @WebParam(name = "search") String search,
            @WebParam(name = "manufacturer") String manufacturer,
            @WebParam(name = "minPrice") Integer minPrice,
            @WebParam(name = "maxPrice") Integer maxPrice) {
        ArrayList<Monitor> a = new ArrayList(); ///////////////////////////////
        int i = 0;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pcpicker", user, pass);

            String sql = "{call get_Monitor_list()}"; ////////////////////////////////
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
                a.get(last).setImagePath(rs.getString(6));////////////////
                //*****************************************nadoble comp_id
                a.get(last).setAspect_ratio(rs.getString(8));/////////////////
                a.get(last).setScreen_size(rs.getInt(9));/////////////////
                a.get(last).setMax_resolution(rs.getString(10));////////////////////
                a.get(last).setRefresh_rate(rs.getInt(11));////////////////
                if(filterPart(a.get(last),search,manufacturer,minPrice,maxPrice))
                    a.remove(last);
            }
            callableStatement.close();
            conn.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return a;
    }

    @WebMethod(operationName = "getMotherboardList")
    public ArrayList<Motherboard> getMotherboardList(
            @WebParam(name = "search") String search,
            @WebParam(name = "manufacturer") String manufacturer,
            @WebParam(name = "minPrice") Integer minPrice,
            @WebParam(name = "maxPrice") Integer maxPrice) {
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
                a.get(last).setImagePath(rs.getString(6));////////////////
                //*****************************************nadoble comp_id
                a.get(last).setSocket(rs.getString(8));/////////////////
                a.get(last).setMem_slots(rs.getInt(9));/////////////////
                a.get(last).setForm_factor(rs.getString(10));////////////////////
                if(filterPart(a.get(last),search,manufacturer,minPrice,maxPrice))
                    a.remove(last);
            }
            callableStatement.close();
            conn.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return a;
    }

    @WebMethod(operationName = "getMouseList")
    public ArrayList<Mouse> getMouseList(
            @WebParam(name = "search") String search,
            @WebParam(name = "manufacturer") String manufacturer,
            @WebParam(name = "minPrice") Integer minPrice,
            @WebParam(name = "maxPrice") Integer maxPrice) {
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
                a.get(last).setImagePath(rs.getString(6));////////////////
                //*****************************************nadoble comp_id
                a.get(last).setDpi(rs.getInt(8));/////////////////
                a.get(last).setConnection_(rs.getString(9));/////////////////
                if(filterPart(a.get(last),search,manufacturer,minPrice,maxPrice))
                    a.remove(last);
            }
            callableStatement.close();
            conn.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return a;
    }

    @WebMethod(operationName = "getStorageList")
    public ArrayList<Storage> getStorageList(
            @WebParam(name = "search") String search,
            @WebParam(name = "manufacturer") String manufacturer,
            @WebParam(name = "minPrice") Integer minPrice,
            @WebParam(name = "maxPrice") Integer maxPrice) {
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
                a.get(last).setImagePath(rs.getString(6));////////////////
                //*****************************************nadoble comp_id
                a.get(last).setType_(rs.getString(8));/////////////////
                a.get(last).setCapacity(rs.getInt(9));/////////////////
                a.get(last).setInterface_(rs.getString(10));
                if(filterPart(a.get(last),search,manufacturer,minPrice,maxPrice))
                    a.remove(last);
            }
            callableStatement.close();
            conn.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return a;
    }

    @WebMethod(operationName = "getPowerSupplyList")
    public ArrayList<PowerSupply> getPowerSupplyList(
            @WebParam(name = "search") String search,
            @WebParam(name = "manufacturer") String manufacturer,
            @WebParam(name = "minPrice") Integer minPrice,
            @WebParam(name = "maxPrice") Integer maxPrice) {
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
                a.get(last).setImagePath(rs.getString(6));////////////////
                //*****************************************nadoble comp_id
                a.get(last).setWattage(rs.getInt(8));/////////////////
                a.get(last).setRating(rs.getString(9));/////////////////
                a.get(last).setForm_factor(rs.getString(10));
                if(filterPart(a.get(last),search,manufacturer,minPrice,maxPrice))
                    a.remove(last);
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
     * return true success
     * return false fail -- duplicate
     */
    
    @WebMethod(operationName = "login")
    public String login(@WebParam(name = "username") String username, @WebParam(name = "password") String password) {
        
        String custId="";
        
        try {
             
            Class.forName("com.mysql.jdbc.Driver");

            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pcpicker", user, pass);
     
            String sql = "{call loginCustomer(?,?)}"; ////////////////////////////////
            CallableStatement callableStatement = conn.prepareCall(sql);
        
            callableStatement.setString(1, username);
            callableStatement.setString(2, password);
            
            ResultSet rs = callableStatement.executeQuery();
            while (rs.next()) {
               custId = rs.getString(1);
            }
           
            
            callableStatement.executeQuery();

            callableStatement.close();
            conn.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            
        }
        
        return custId;
    }
    
    
    @WebMethod(operationName = "addCustomer")
    public Boolean addCustomer(@WebParam(name = "username") String username, @WebParam(name = "password") String password, @WebParam(name = "address") String address, @WebParam(name = "city") String city, @WebParam(name = "zipCode") int zipCode,@WebParam(name = "firstname") String firstname,@WebParam(name = "lastname") String lastname) {
        
        try {
            
            Class.forName("com.mysql.jdbc.Driver");

            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pcpicker", user, pass);
     
            String sql = "{call addCustomer(?,?,?,?,?,?,?)}"; ////////////////////////////////
            CallableStatement callableStatement = conn.prepareCall(sql);
        
            callableStatement.setString(1, username);
            callableStatement.setString(2, password);
            callableStatement.setString(3, address);
            callableStatement.setString(4, city);
            callableStatement.setInt(5, zipCode);
            callableStatement.setString(6, firstname);
            callableStatement.setString(7, lastname);
           
            
            callableStatement.executeQuery();

            callableStatement.close();
            conn.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        }
        
        return true;
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
    
    public  ArrayList<Branch> getBranchesList() {
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
    
    
    @WebMethod(operationName = "addOrder")
    public int addOrder(
            @WebParam(name = "cust_id") int cust_id, 
            @WebParam(name = "part_ids") ArrayList<String> part_ids,
            @WebParam(name = "quantity") ArrayList<Integer> quantity, 
            @WebParam(name = "paymentType") String paymentType,
            @WebParam(name = "deliveryAddress") String deliveryAddress    
    ) {
        int order_id = 0; 
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pcpicker", user, pass);
          
            String sql = "{call addOrder(?,?,?,?)}"; 
            CallableStatement callableStatement = conn.prepareCall(sql);
            callableStatement.setInt(1, cust_id);
            callableStatement.setString(2,paymentType);
            callableStatement.setString(3,deliveryAddress);
            callableStatement.setInt(4, DistanceCalculator.getNearestBranch(deliveryAddress,getBranchesList()));
            ResultSet rs = callableStatement.executeQuery();
            while (rs.next()) {
                order_id = rs.getInt(1);
                   
            }
            callableStatement.close();
            conn.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pcpicker", user, pass);
          
            String sql = "{call addOrderpart(?,?,?,?)}"; 
            int numItems = part_ids.size();
            for(int i = 0; i <numItems; i++)
            {
                String partId = part_ids.get(i);
                int qty = quantity.get(i);
                Part part = getPart(partId);
                
                CallableStatement callableStatement = conn.prepareCall(sql);
                callableStatement.setInt(1, order_id);
                callableStatement.setString(2,partId);
                callableStatement.setInt(3,qty);
                callableStatement.setDouble(4,part.getPart_price());
                callableStatement.executeUpdate();
                callableStatement.close();
            }
            
            conn.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        
        
        return order_id;
    }
    @WebMethod(operationName = "getOrderList")
    public ArrayList<Order> getOrderList(@WebParam(name = "cust_id") int cust_id) {
        ArrayList<Order> a = new ArrayList(); ///////////////////////////////
        int i = 0;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pcpicker", user, pass);

            String sql = "{call getActiveOrders(?)}"; ////////////////////////////////
            
            CallableStatement callableStatement = conn.prepareCall(sql);
            callableStatement.setInt(1,cust_id);
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
               // System.out.println("adasdasdasdzxczczxc" + a.get(last).getDeliveryAddress());
            }
            callableStatement.close();
            conn.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return a;
    }
     @WebMethod(operationName = "getOrderHistoryList")
    public ArrayList<Order> getOrderHistoryList(@WebParam(name = "cust_id") int cust_id) {
        ArrayList<Order> a = new ArrayList(); ///////////////////////////////
        int i = 0;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pcpicker", user, pass);

            String sql = "{call getHistoryOrders(?)}"; ////////////////////////////////
            
            CallableStatement callableStatement = conn.prepareCall(sql);
            callableStatement.setInt(1,cust_id);
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
            }
            callableStatement.close();
            conn.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return a;
    }
    
    @WebMethod(operationName = "cancelOrder")
    public String cancelOrder(@WebParam(name = "order_id")int order_id) {
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pcpicker", user, pass);

            String sql = "{call cancelOrder(?)}"; ////////////////////////////////
            CallableStatement callableStatement = conn.prepareCall(sql);
            callableStatement.setInt(1, order_id);
            callableStatement.executeUpdate();
           
            callableStatement.close();
            conn.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return "";
    }
    
}
