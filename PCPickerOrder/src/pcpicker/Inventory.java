package pcpicker;

import javax.xml.bind.annotation.*;
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Inventory")
public class Inventory 
{

    /**
     * @return the comp_name
     */
    public String getComp_name() {
        return comp_name;
    }

    /**
     * @param comp_name the comp_name to set
     */
    public void setComp_name(String comp_name) {
        this.comp_name = comp_name;
    }

    /**
     * @return the comp_price
     */
    public double getComp_price() {
        return comp_price;
    }

    /**
     * @param comp_price the comp_price to set
     */
    public void setComp_price(double comp_price) {
        this.comp_price = comp_price;
    }

    /**
     * @return the comp_manufacturer
     */
    public String getComp_manufacturer() {
        return comp_manufacturer;
    }

    /**
     * @param comp_manufacturer the comp_manufacturer to set
     */
    public void setComp_manufacturer(String comp_manufacturer) {
        this.comp_manufacturer = comp_manufacturer;
    }

    /**
     * @return the comp_type
     */
    public String getComp_type() {
        return comp_type;
    }

    /**
     * @param comp_type the comp_type to set
     */
    public void setComp_type(String comp_type) {
        this.comp_type = comp_type;
    }

    /**
     * @return the comp_id
     */
    public int getComp_id() {
        return comp_id;
    }

    /**
     * @param comp_id the comp_id to set
     */
    public void setComp_id(int comp_id) {
        this.comp_id = comp_id;
    }

    /**
     * @return the date_acquired
     */
    public String getDate_acquired() {
        return date_acquired;
    }

    /**
     * @param date_acquired the date_acquired to set
     */
    public void setDate_acquired(String date_acquired) {
        this.date_acquired = date_acquired;
    }

    /**
     * @return the branch_id
     */
    public int getBranch_id() {
        return branch_id;
    }

    /**
     * @param branch_id the branch_id to set
     */
    public void setBranch_id(int branch_id) {
        this.branch_id = branch_id;
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
    @XmlElement(name = "comp_id")
    private int comp_id;    
    @XmlElement(name = "date_acquired")
    private String date_acquired;    
    @XmlElement(name = "branch_id")
    private int branch_id;
    @XmlElement(name = "quantity")
    private int quantity;    
    
    @XmlElement(name = "comp_name")
    private String comp_name;    
    @XmlElement(name = "comp_price")
    private double comp_price;    
    @XmlElement(name = "comp_manufacturer")
    private String comp_manufacturer;
    @XmlElement(name = "comp_type")
    private String comp_type;    
}