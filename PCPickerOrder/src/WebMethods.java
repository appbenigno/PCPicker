
import pcpicker_webservicefordesktop.Customer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author admin
 */
public class WebMethods {
    public static java.util.List<pcpicker_webservicefordesktop.OrderParts> getOrderComponentList() {
        pcpicker_webservicefordesktop.PcpickerWebserviceForDesktop_Service service = new pcpicker_webservicefordesktop.PcpickerWebserviceForDesktop_Service();
        pcpicker_webservicefordesktop.PcpickerWebserviceForDesktop port = service.getPcpickerWebserviceForDesktopPort();
        return port.getOrderComponentList();
    }

    public static void acceptOrder(int orderId, int branchId) {
        pcpicker_webservicefordesktop.PcpickerWebserviceForDesktop_Service service = new pcpicker_webservicefordesktop.PcpickerWebserviceForDesktop_Service();
        pcpicker_webservicefordesktop.PcpickerWebserviceForDesktop port = service.getPcpickerWebserviceForDesktopPort();
        port.acceptOrder(orderId, branchId);
    }
    
//    public static java.util.List<pcpicker_webservicefordesktop.Order> getOrderList() {
//        pcpicker_webservicefordesktop.PcpickerWebserviceForDesktop_Service service = new pcpicker_webservicefordesktop.PcpickerWebserviceForDesktop_Service();
//        pcpicker_webservicefordesktop.PcpickerWebserviceForDesktop port = service.getPcpickerWebserviceForDesktopPort();
//        return null;//port.getOrderList();
//    }

    public static java.util.List<pcpicker_webservicefordesktop.Branch> getBranchesList() {
        pcpicker_webservicefordesktop.PcpickerWebserviceForDesktop_Service service = new pcpicker_webservicefordesktop.PcpickerWebserviceForDesktop_Service();
        pcpicker_webservicefordesktop.PcpickerWebserviceForDesktop port = service.getPcpickerWebserviceForDesktopPort();
        return port.getBranchesList();
    }

   

    public static java.util.List<pcpicker_webservicefordesktop.Customer> getCustomerList() {
        pcpicker_webservicefordesktop.PcpickerWebserviceForDesktop_Service service = new pcpicker_webservicefordesktop.PcpickerWebserviceForDesktop_Service();
        pcpicker_webservicefordesktop.PcpickerWebserviceForDesktop port = service.getPcpickerWebserviceForDesktopPort();
        return port.getCustomerList();
    }

    public static Customer getCustomer(int custId) {
        pcpicker_webservicefordesktop.PcpickerWebserviceForDesktop_Service service = new pcpicker_webservicefordesktop.PcpickerWebserviceForDesktop_Service();
        pcpicker_webservicefordesktop.PcpickerWebserviceForDesktop port = service.getPcpickerWebserviceForDesktopPort();
        return port.getCustomer(custId);
    }

    public static java.util.List<pcpicker_webservicefordesktop.Customer> getCustomerList_1() {
        pcpicker_webservicefordesktop.PcpickerWebserviceForDesktop_Service service = new pcpicker_webservicefordesktop.PcpickerWebserviceForDesktop_Service();
        pcpicker_webservicefordesktop.PcpickerWebserviceForDesktop port = service.getPcpickerWebserviceForDesktopPort();
        return port.getCustomerList();
    }

    public static java.util.List<pcpicker_webservicefordesktop.Order> getActivePendingOrderList(int branchId) {
        pcpicker_webservicefordesktop.PcpickerWebserviceForDesktop_Service service = new pcpicker_webservicefordesktop.PcpickerWebserviceForDesktop_Service();
        pcpicker_webservicefordesktop.PcpickerWebserviceForDesktop port = service.getPcpickerWebserviceForDesktopPort();
        return port.getActivePendingOrderList(branchId);
    }

    public static int rejectOrder(int orderId) {
        pcpicker_webservicefordesktop.PcpickerWebserviceForDesktop_Service service = new pcpicker_webservicefordesktop.PcpickerWebserviceForDesktop_Service();
        pcpicker_webservicefordesktop.PcpickerWebserviceForDesktop port = service.getPcpickerWebserviceForDesktopPort();
        return port.rejectOrder(orderId);
    }

    public static int completeOrder(int orderId) {
        pcpicker_webservicefordesktop.PcpickerWebserviceForDesktop_Service service = new pcpicker_webservicefordesktop.PcpickerWebserviceForDesktop_Service();
        pcpicker_webservicefordesktop.PcpickerWebserviceForDesktop port = service.getPcpickerWebserviceForDesktopPort();
        return port.completeOrder(orderId);
    }

    public static void setOrderDeliveryDate(int orderId, java.lang.String deliveryDate) {
        pcpicker_webservicefordesktop.PcpickerWebserviceForDesktop_Service service = new pcpicker_webservicefordesktop.PcpickerWebserviceForDesktop_Service();
        pcpicker_webservicefordesktop.PcpickerWebserviceForDesktop port = service.getPcpickerWebserviceForDesktopPort();
        port.setOrderDeliveryDate(orderId, deliveryDate);
    }

    public static java.util.List<pcpicker_webservicefordesktop.Order> getForDeliveryOrders(int branchId) {
        pcpicker_webservicefordesktop.PcpickerWebserviceForDesktop_Service service = new pcpicker_webservicefordesktop.PcpickerWebserviceForDesktop_Service();
        pcpicker_webservicefordesktop.PcpickerWebserviceForDesktop port = service.getPcpickerWebserviceForDesktopPort();
        return port.getForDeliveryOrders(branchId);
    }
}
