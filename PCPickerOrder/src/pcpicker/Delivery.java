package pcpicker;

import javax.xml.bind.annotation.*;
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Delivery")
public class Delivery 
{

    /**
     * @return the delivery_num
     */
    public int getDelivery_num() {
        return delivery_num;
    }

    /**
     * @param delivery_num the delivery_num to set
     */
    public void setDelivery_num(int delivery_num) {
        this.delivery_num = delivery_num;
    }

    /**
     * @return the order_id
     */
    public int getOrder_id() {
        return order_id;
    }

    /**
     * @param order_id the order_id to set
     */
    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    /**
     * @return the date_delivery
     */
    public String getDate_delivery() {
        return date_delivery;
    }

    /**
     * @param date_delivery the date_delivery to set
     */
    public void setDate_delivery(String date_delivery) {
        this.date_delivery = date_delivery;
    }

    /**
     * @return the accepted_by
     */
    public String getAccepted_by() {
        return accepted_by;
    }

    /**
     * @param accepted_by the accepted_by to set
     */
    public void setAccepted_by(String accepted_by) {
        this.accepted_by = accepted_by;
    }
    @XmlElement(name = "delivery_num")
    private int delivery_num;
    @XmlElement(name = "order_id")
    private int order_id;    
    @XmlElement(name = "date_delivery")
    private String date_delivery;    
    @XmlElement(name = "accepted_by")
    private String accepted_by;
}