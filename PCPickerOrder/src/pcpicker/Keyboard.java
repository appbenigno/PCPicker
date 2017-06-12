package pcpicker;

import javax.xml.bind.annotation.*;
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Keyboard")
public class Keyboard extends Part
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
     * @return the backlit
     */
    public boolean isBacklit() {
        return backlit;
    }

    /**
     * @param backlit the backlit to set
     */
    public void setBacklit(boolean backlit) {
        this.backlit = backlit;
    }


    @XmlElement(name = "backlit")
    private boolean backlit;    
    @XmlElement(name = "type_")
    protected String type_;
    
  
}
