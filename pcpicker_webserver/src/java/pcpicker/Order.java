package pcpicker;

import javax.xml.bind.annotation.*;
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Order")
public class Order extends Part
{

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
     * @return the cust_id
     */
    public int getCust_id() {
        return cust_id;
    }

    /**
     * @param cust_id the cust_id to set
     */
    public void setCust_id(int cust_id) {
        this.cust_id = cust_id;
    }

    /**
     * @return the date_created
     */
    public String getDate_created() {
        return date_created;
    }

    /**
     * @param date_created the date_created to set
     */
    public void setDate_created(String date_created) {
        this.date_created = date_created;
    }

    /**
     * @return the payment_type
     */
    public String getPayment_type() {
        return payment_type;
    }

    /**
     * @param payment_type the payment_type to set
     */
    public void setPayment_type(String payment_type) {
        this.payment_type = payment_type;
    }
    @XmlElement(name = "order_id")
    private int order_id;    
    @XmlElement(name = "cust_id")
    private int cust_id;    
    @XmlElement(name = "date_created")
    private String date_created;
    @XmlElement(name = "payment_type")
    private String payment_type;    
}