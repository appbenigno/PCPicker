/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pcpicker;

import javax.xml.bind.annotation.XmlElement;

/**
 *
 * @author admin
 */
import javax.xml.bind.annotation.*;
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Part")
public class Part {
  
    
    public String getPart_id() {
        return part_id;
    }

    /**
     * @param comp_id the comp_id to set
     */
    public void setPart_id(String comp_id) {
        this.part_id = comp_id;
    }

    /**
     * @return the comp_manufacturer
     */
    public String getPart_manufacturer() {
        return part_manufacturer;
    }

    /**
     * @param comp_manufacturer the comp_manufacturer to set
     */
    public void setPart_manufacturer(String comp_manufacturer) {
        this.part_manufacturer = comp_manufacturer;
    }

    public double getPart_price() {
        return part_price;
    }

    /**
     * @param comp_price the comp_price to set
     */
    public void setPart_price(double comp_price) {
        this.part_price = comp_price;
    }

    /**
     * @return the comp_type
     */
    public String getPart_type() {
        return part_type;
    }

    /**
     * @param comp_type the comp_type to set
     */
    public void setPart_type(String comp_type) {
        this.part_type = comp_type;
    }
    
    public String getPart_name() {
        return part_name;
    }

    /**
     * @param comp_name the comp_name to set
     */
    public void setPart_name(String comp_name) {
        this.part_name = comp_name;
    }
    
    @XmlElement(name = "part_id")
    protected String part_id;    
    @XmlElement(name = "part_manufacturer")
    protected String part_manufacturer;    
    @XmlElement(name = "part_name")
    protected String part_name;
    @XmlElement(name = "part_price")
    protected double part_price;    
    @XmlElement(name = "part_type")
    protected String part_type;
}
