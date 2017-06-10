/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pcpicker_webclient;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pcpicker.*;

/**
 *
 * @author admin
 */
public class SearchPage extends HttpServlet {

  



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
        String componentType = (String) request.getParameter("test");
        if(componentType==null||componentType.equals(""))
            componentType = (String) request.getParameter("componentType");
        
        
        //todo - on filterget get value max min
        int setMaxPrice = getMaxPrice(componentType);
        int setMinPrice = 0;       
        request.setAttribute("setMaxPrice",setMaxPrice);
        request.setAttribute("setMinPrice", setMinPrice);
        request.setAttribute("maxPrice",getMaxPrice(componentType));
        
        //todo on filterget get value max min
        int setMaxDPI = 2000;
        int setMinDPI = 0;       
        request.setAttribute("setMaxDPI",setMaxDPI);
        request.setAttribute("setMinDPI", setMinDPI);
        request.setAttribute("maxDPI",2000);
        
        //todo on filterget get value max min
        int setMaxgpu_memcap = 2000;
        int setMingpu_memcap = 0;       
        request.setAttribute("setMaxgpu_memcap",setMaxgpu_memcap);
        request.setAttribute("setMingpu_memcap", setMingpu_memcap);
        request.setAttribute("maxgpu_memcap",2000);
        
        //todo on filterget get value max min
        int setMaxwattage = 1500;
        int setMinwattage = 0;       
        request.setAttribute("setMaxwattage",setMaxwattage);
        request.setAttribute("setMinwattage", setMinwattage);
        request.setAttribute("maxwattage",1500);
        
        //todo on filterget get value max min
        int setMaxcore_num = 20;
        int setMincore_num = 0;       
        request.setAttribute("setMaxcore_num",setMaxcore_num);
        request.setAttribute("setMincore_num", setMincore_num);
        request.setAttribute("maxcore_num",20);
        
         //todo on filterget get value max min
        int setMaxtdp =200;
        int setMintdp = 0;       
        request.setAttribute("setMaxtdp",setMaxtdp);
        request.setAttribute("setMintdp", setMintdp);
        request.setAttribute("maxtdp",200);
        
          //todo on filterget get value max min
        int setMaxstoragecapacity = 10;
        int setMinstoragecapacity = 0;       
        request.setAttribute("setMaxstoragecapacity",setMaxstoragecapacity);
        request.setAttribute("setMinstoragecapacity", setMinstoragecapacity);
        request.setAttribute("maxstoragecapacity",10);
        
           //todo on filterget get value max min
        int setMaxscreensize = 50;
        int setMinscreensize = 10;       
        request.setAttribute("setMaxscreensize",setMaxscreensize);
        request.setAttribute("setMinscreensize", setMinscreensize);
        request.setAttribute("maxscreensize",50);
        
           //todo on filterget get value max min
        int setMaxrefreshrate = 200;
        int setMinrefreshrate = 10;       
        request.setAttribute("setMaxrefreshrate",setMaxrefreshrate);
        request.setAttribute("setMinrefreshrate", setMinrefreshrate);
        request.setAttribute("maxrefreshrate",200);
        
        request.setAttribute("componentType", componentType);
        request.setAttribute("aspectRatios",getAspectRatios());
        request.setAttribute("maxResolutions",getMaxResolutions());
        request.setAttribute("storageInterface",getStorageInterface());
        request.setAttribute("componentType", componentType);        
        request.setAttribute("sockets",getSockets(componentType));
        request.setAttribute("manufacturers", getManufacturers(componentType));
        request.setAttribute("memoryTypes",getMemoryTypes());
        request.setAttribute("gpumemoryTypes",getgpuMemoryTypes());
        request.setAttribute("memoryCapacities",getMemoryCapacities());
        request.setAttribute("formFactor",getFormFactor(componentType));
        
        request.setAttribute("componentslist",getList(componentType));
       
        request.getRequestDispatcher("searchpage.jsp").forward(request, response);
    }
    
    
    private HashMap getList(String compType)
    {
        
        HashMap manuf = new HashMap();
         
        
        if(compType.equals("Processor") || compType.equals("CPU"))
        {
            List<Processor> components = WebMethods.getProcessorList();
            for(int i = 0; i < components.size();i++)
            {
                HashMap items = new HashMap();
          
                items.put("1",components.get(i).getPartId());
                items.put("2",components.get(i).getPartName());
                items.put("3",Double.toString(components.get(i).getPartPrice()));
                
             //  String corethreads = components.ge
                
              //  items.put("4",components.get(i).g);
                
                             
                
                manuf.put(Integer.toString(i), items);
            }
        }
        else if(compType.equals("GPU") || compType.equals("graphicscard"))
        {
            List<GraphicsCard> components = WebMethods.getGraphicsCardList();
            for(int i = 0; i < components.size();i++)
            {
                HashMap items = new HashMap();
             
                items.put("1",components.get(i).getPartId());
                items.put("2",components.get(i).getPartName());
                items.put("3",Double.toString(components.get(i).getPartPrice()));
                
                             
                
                manuf.put(Integer.toString(i), items);
            }
        }
        else if(compType.equals("Monitor"))
        {
            List<Monitor> components = WebMethods.getMonitorList();
            for(int i = 0; i < components.size();i++)
            {
                HashMap items = new HashMap();
             
                items.put("1",components.get(i).getPartId());
                items.put("2",components.get(i).getPartName());
                items.put("3",Double.toString(components.get(i).getPartPrice()));
                
                             
                
                manuf.put(Integer.toString(i), items);
            }
        }
        else if(compType.equals("Memory"))
        {
            List<Memory> components = WebMethods.getMemoryList();
            for(int i = 0; i < components.size();i++)
            {
                HashMap items = new HashMap();
             
                items.put("1",components.get(i).getPartId());
                items.put("2",components.get(i).getPartName());
                items.put("3",Double.toString(components.get(i).getPartPrice()));
                
                             
                
                manuf.put(Integer.toString(i), items);
            }
        }
        else if(compType.equals("Mouse"))
        {
            List<Mouse> components = WebMethods.getMouseList();
            for(int i = 0; i < components.size();i++)
            {
                HashMap items = new HashMap();
             
                items.put("1",components.get(i).getPartId());
                items.put("2",components.get(i).getPartName());
                items.put("3",Double.toString(components.get(i).getPartPrice()));
                
                             
                
                manuf.put(Integer.toString(i), items);
            }
        }
        else if(compType.equals("Motherboard"))
        {
            List<Motherboard> components = WebMethods.getMotherboardList();
            for(int i = 0; i < components.size();i++)
            {
                HashMap items = new HashMap();
             
                items.put("1",components.get(i).getPartId());
                items.put("2",components.get(i).getPartName());
                items.put("3",Double.toString(components.get(i).getPartPrice()));
                
                             
                
                manuf.put(Integer.toString(i), items);
            }
        }
        else if(compType.equals("Cooler"))
        {
            List<Cooler> components = WebMethods.getCoolerList();
            for(int i = 0; i < components.size();i++)
            {
                HashMap items = new HashMap();
             
                items.put("1",components.get(i).getPartId());
                items.put("2",components.get(i).getPartName());
                items.put("3",Double.toString(components.get(i).getPartPrice()));
                
                             
                
                manuf.put(Integer.toString(i), items);
            }
        }
        else if(compType.equals("Storage"))
        {
            List<Storage> components= WebMethods.getStorageList();
            for(int i = 0; i < components.size();i++)
            {
                HashMap items = new HashMap();
             
                items.put("1",components.get(i).getPartId());
                items.put("2",components.get(i).getPartName());
                items.put("3",Double.toString(components.get(i).getPartPrice()));
                
                             
                
                manuf.put(Integer.toString(i), items);
            }
        }
        else if(compType.equals("Power Supply"))
        {
            List<PowerSupply> components = WebMethods.getPowerSupplyList();
            for(int i = 0; i < components.size();i++)
            {
                HashMap items = new HashMap();
             
                items.put("1",components.get(i).getPartId());
                items.put("2",components.get(i).getPartName());
                items.put("3",Double.toString(components.get(i).getPartPrice()));
                
                             
                
                manuf.put(Integer.toString(i), items);
            }
        }
        else if(compType.equals("Keyboard"))
        {
            List<Keyboard> components = WebMethods.getKeyboardList();
            for(int i = 0; i < components.size();i++)
            {
                HashMap items = new HashMap();
             
                items.put("1",components.get(i).getPartId());
                items.put("2",components.get(i).getPartName());
                items.put("3",Double.toString(components.get(i).getPartPrice()));
                
                             
                
                manuf.put(Integer.toString(i), items);
            }
        }
//        //todo -- get motherboard formfactor
       
        
        return manuf;
        
        
    }
    
    
    private HashMap getAspectRatios()
    {
        HashMap manuf = new HashMap();
        
        
        //todo -- get motherboard formfactor
        manuf.put("1", "16:9");
        manuf.put("2", "21:9");
        manuf.put("3", "4:3");
        
        return manuf;
    }   
    
    
    private HashMap getMaxResolutions()
    {
        HashMap manuf = new HashMap();
        
        List<String> resos = WebMethods.getMaxResolutions_1();
       
        for(int i = 0; i < resos.size(); i++)
            manuf.put(Integer.toString(i),resos.get(i));
      
        
        return manuf;
    }       
            
            
    private HashMap getStorageInterface()
    {
        HashMap manuf = new HashMap();
        
     
        //todo -- get motherboard formfactor
        manuf.put("1", "SATA");
        manuf.put("2", "FC");
        manuf.put("3", "PCIe");
        
        return manuf;
    }
    private int getMaxPrice(String componentType)
    {
        //todo-get max price of component type
        return 190000 + 10000;//+10000 kelangan minsan di nakukuha max sa range
    }
    private HashMap getFormFactor(String componentType)
    {
        HashMap manuf = new HashMap();
        
        if(componentType.equals("Motherboard") || componentType.equals("Cooler"))
        //todo -- get motherboard formfactor
        manuf.put("1", "Micro-ATX");
        manuf.put("2", "Standard-ATX");
        manuf.put("3", "Mini-ATX");
        
        return manuf;
    }
    
    private HashMap getgpuMemoryTypes()
    {
        HashMap manuf = new HashMap();
      
        List<String> memtypes = WebMethods.getGPUMemoryTypes();

        for(int i = 0; i < memtypes.size(); i++)
            manuf.put(Integer.toString(i),memtypes.get(i));
       
        
        return manuf;
    }
    private HashMap getMemoryTypes()
    {
        HashMap manuf = new HashMap();
        
        List<String> memtypes = WebMethods.getMemoryTypes_1();
       
        for(int i = 0; i < memtypes.size(); i++)
            manuf.put(Integer.toString(i),memtypes.get(i));
       
       
        
        return manuf;
    }
    private HashMap getMemoryCapacities()
    {
        HashMap manuf = new HashMap();
        
        //todo -- getMemoryCapacities
        manuf.put("1", "2gb");
        manuf.put("2", "4gb");
        manuf.put("3", "8gb");
        manuf.put("4", "16gb");
        
        return manuf;
    }
    
    private HashMap getSockets(String componentType)
    {
        HashMap manuf = new HashMap();
        
        if(componentType.equals("CPU")||componentType.equals("Processor")||componentType.equals("Motherboard"))
        {
        //todo -- get socket list from processor rable
            manuf.put("1", "socket1");
            manuf.put("2", "socket2");
            manuf.put("3", "socket3");
        }
        
        return manuf;
    }
    
    private HashMap getManufacturers(String componentType)
    {
        HashMap manuf = new HashMap();
        
        String comp_type ="";
        switch(componentType)
        {            
            case "CPU": comp_type="Processor";break;
            case "Cooler": comp_type="Heatsink";break;
            case "GPU":comp_type="Graphics Card";break;
            default: comp_type = componentType;
        }       
        
        List<String> manufs =  WebMethods.getManufacturers_1(comp_type);
        for(int i = 0; i < manufs.size(); i++)
            manuf.put(Integer.toString(i), manufs.get(i));
        
        return manuf;
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
