package pcpicker;

import java.util.List;
import javax.xml.bind.annotation.*;
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Inventory")
public class Inventory
{

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
    @XmlElement(name = "part_id")
    private String part_id;    
    @XmlElement(name = "date_acquired")
    private String date_acquired;    
    @XmlElement(name = "branch_id")
    private int branch_id;
    @XmlElement(name = "quantity")
    private int quantity;   
 
}