package pcpicker;

import javax.xml.bind.annotation.*;
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Order_Parts")
public class Order_Parts 
{
    @XmlElement(name = "order_id")
    private int order_id;    
    @XmlElement(name = "part_id")
    private String part_id;    
    @XmlElement(name = "quantity")
    private int quantity;
    @XmlElement(name = "price")
    protected double price;
    @XmlElement(name = "part")
    protected Part part;
    
    
    
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
     * @return the part_id
     */
    public String getPart_id() {
        return part_id;
    }

    /**
     * @param part_id the part_id to set
     */
    public void setPart_id(String part_id) {
        this.part_id = part_id;
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
   
    /**
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * @return the part
     */
    public Part getPart() {
        return part;
    }

    /**
     * @param part the part to set
     */
    public void setPart(Part part) {
        this.part = part;
    }
}