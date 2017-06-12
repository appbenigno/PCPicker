package pcpicker;

import javax.xml.bind.annotation.*;
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Storage")
public class Storage extends Part
{    

    /**
     * @return the type_
     */
    public String getType_() {
        return type_;
    }

    /**
     * @param type_ the type_ to set
     */
    public void setType_(String type_) {
        this.type_ = type_;
    }

    /**
     * @return the capacity
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * @param capacity the capacity to set
     */
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    /**
     * @return the interface_
     */
    public String getInterface_() {
        return interface_;
    }

    /**
     * @param interface_ the interface_ to set
     */
    public void setInterface_(String interface_) {
        this.interface_ = interface_;
    }


    @XmlElement(name = "type_")
    private String type_;    
    @XmlElement(name = "capacity")
    private int capacity;
    @XmlElement(name = "interface")
    private String interface_;           //////////////////////
    
  
}
