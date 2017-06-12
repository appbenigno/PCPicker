package pcpicker;

import javax.xml.bind.annotation.*;
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Order_component")
public class Order_component 
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
     * @return the comp_id
     */
    public String getComp_id() {
        return comp_id;
    }

    /**
     * @param comp_id the comp_id to set
     */
    public void setComp_id(String comp_id) {
        this.comp_id = comp_id;
    }

    /**
     * @return the quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    @XmlElement(name = "order_id")
    private int order_id;    
    @XmlElement(name = "comp_id")
    private String comp_id;    
    @XmlElement(name = "quantity")
    private int quantity;
}