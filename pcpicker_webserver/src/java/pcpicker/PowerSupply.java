package pcpicker;

import javax.xml.bind.annotation.*;
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PowerSupply")
public class PowerSupply extends Part
{

    /**
    /**
     * @return the wattage
     */
    public int getWattage() {
        return wattage;
    }

    /**
     * @param wattage the wattage to set
     */
    public void setWattage(int wattage) {
        this.wattage = wattage;
    }

    /**
     * @return the rating
     */
    public String getRating() {
        return rating;
    }

    /**
     * @param rating the rating to set
     */
    public void setRating(String rating) {
        this.rating = rating;
    }

    /**
     * @return the form_factor
     */
    public String getForm_factor() {
        return form_factor;
    }

    /**
     * @param form_factor the form_factor to set
     */
    public void setForm_factor(String form_factor) {
        this.form_factor = form_factor;
    }

    
    @XmlElement(name = "wattage")
    private int wattage;    
    @XmlElement(name = "rating")
    private String rating;
    @XmlElement(name = "form_factor")
    private String form_factor ;
}
