/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pcpicker_webclient;
import pcpicker.*;
import pcpicker.PcpickerWebservice_Service;
import java.util.ArrayList;
import java.util.HashMap;
import javax.xml.ws.WebServiceRef;
/**
 *
 * @author admin
 */
public class WebMethods {
    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/192.168.119.185_8080/pcpicker_webserver/pcpicker_webservice.wsdl")
    private static PcpickerWebservice_Service service = new pcpicker.PcpickerWebservice_Service();
    
    
    public static java.util.List<java.lang.String> getManufacturers_1(java.lang.String type) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        pcpicker.PcpickerWebservice port = service.getPcpickerWebservicePort();
        return port.getManufacturers(type);
    }

    public static java.util.List<java.lang.String> getMaxResolutions_1() {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        pcpicker.PcpickerWebservice port = service.getPcpickerWebservicePort();
        return port.getMaxResolutions();
    }

    public static java.util.List<java.lang.String> getMemoryTypes_1() {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        pcpicker.PcpickerWebservice port = service.getPcpickerWebservicePort();
        return port.getMemoryTypes();
    }

    public static java.util.List<java.lang.String> getGPUMemoryTypes() {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        pcpicker.PcpickerWebservice port = service.getPcpickerWebservicePort();
        return port.getGPUMemoryTypes();
    }

    public static java.util.List<pcpicker.Monitor> getMonitorList() {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        pcpicker.PcpickerWebservice port = service.getPcpickerWebservicePort();
        return port.getMonitorList();
    }

    public static java.util.List<pcpicker.Memory> getMemoryList() {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        pcpicker.PcpickerWebservice port = service.getPcpickerWebservicePort();
        return port.getMemoryList();
    }

    public static java.util.List<pcpicker.Processor> getProcessorList() {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        pcpicker.PcpickerWebservice port = service.getPcpickerWebservicePort();
        return port.getProcessorList();
    }

    public static java.util.List<pcpicker.Storage> getStorageList() {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        pcpicker.PcpickerWebservice port = service.getPcpickerWebservicePort();
        return port.getStorageList();
    }

    public static java.util.List<pcpicker.Mouse> getMouseList() {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        pcpicker.PcpickerWebservice port = service.getPcpickerWebservicePort();
        return port.getMouseList();
    }

    public static java.util.List<pcpicker.Motherboard> getMotherboardList() {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        pcpicker.PcpickerWebservice port = service.getPcpickerWebservicePort();
        return port.getMotherboardList();
    }

    public static java.util.List<pcpicker.Keyboard> getKeyboardList() {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        pcpicker.PcpickerWebservice port = service.getPcpickerWebservicePort();
        return port.getKeyboardList();
    }

    public static java.util.List<pcpicker.GraphicsCard> getGraphicsCardList() {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        pcpicker.PcpickerWebservice port = service.getPcpickerWebservicePort();
        return port.getGraphicsCardList();
    }

    public static java.util.List<pcpicker.Cooler> getCoolerList() {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        pcpicker.PcpickerWebservice port = service.getPcpickerWebservicePort();
        return port.getCoolerList();
    }

    public static java.util.List<pcpicker.PowerSupply> getPowerSupplyList() {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        pcpicker.PcpickerWebservice port = service.getPcpickerWebservicePort();
        return port.getPowerSupplyList();
    }

    public static Part getPart(java.lang.String partId) {
      
        pcpicker.PcpickerWebservice port = service.getPcpickerWebservicePort();
        return port.getPart(partId);
    }
}
