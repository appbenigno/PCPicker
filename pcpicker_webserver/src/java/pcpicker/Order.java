package pcpicker;

import java.sql.Date;
import java.util.List;
import javax.xml.bind.annotation.*;
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Order")
public class Order
{
    @XmlElement(name = "order_id")
    protected int order_id;    
    @XmlElement(name = "cust_id")
    protected int cust_id;    
    @XmlElement(name = "date_created")
    protected String date_created;
    @XmlElement(name = "payment_type")
    protected String payment_type;   
    @XmlElement(name = "active")
    protected Boolean active;
    @XmlElement(name ="acceptedBy")
    protected int acceptedBy; 
    @XmlElement(name ="items")
    protected List<Order_Parts> items;  
    @XmlElement(name ="deliveryDate")
    protected String deliveryDate; 
    @XmlElement(name ="cancel")
    protected Boolean cancel; 
    @XmlElement(name ="cancelDate")
    protected String cancelDate; 
    /**
     * @return the acceptedBy
     */
    public int getAcceptedBy() {
        return acceptedBy;
    }

    /**
     * @param acceptedBy the acceptedBy to set
     */
    public void setAcceptedBy(int acceptedBy) {
        this.acceptedBy = acceptedBy;
    }

    /**
     * @return the cancelDate
     */
    public String getCancelDate() {
        return cancelDate;
    }

    /**
     * @param cancelDate the cancelDate to set
     */
    public void setCancelDate(String cancelDate) {
        this.cancelDate = cancelDate;
    }
  
    
    
    
    /**
     * @return the 
     */
    public Boolean getActive() {
        return active;
    }  
    public void setActive(Boolean active) {
        this.active = active;
    }

    /**
     * @return the items
     */
    public List<Order_Parts> getItems() {
        return items;
    }

    /**
     * @param items the items to set
     */
    public void setItems(List<Order_Parts> items) {
        this.items = items;
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

    /**
     * @return the deliveryDate
     */
    public String getDeliveryDate() {
        return deliveryDate;
    }

    /**
     * @param deliveryDate the deliveryDate to set
     */
    public void setDeliveryDate(String deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    /**
     * @return the cancel
     */
    public Boolean getCancel() {
        return cancel;
    }

    /**
     * @param cancel the cancel to set
     */
    public void setCancel(Boolean cancel) {
        this.cancel = cancel;
    }
    
 
}