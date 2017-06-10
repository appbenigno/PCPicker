package pcpicker;

import javax.xml.bind.annotation.*;
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Image")
public class Image 
{

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
     * @return the imageclass
     */
    public String getImageclass() {
        return imageclass;
    }

    /**
     * @param imageclass the imageclass to set
     */
    public void setImageclass(String imageclass) {
        this.imageclass = imageclass;
    }

    /**
     * @return the imagepath
     */
    public String getImagepath() {
        return imagepath;
    }

    /**
     * @param imagepath the imagepath to set
     */
    public void setImagepath(String imagepath) {
        this.imagepath = imagepath;
    }
    @XmlElement(name = "comp_id")
    private String comp_id;    
    @XmlElement(name = "imageclass")
    private String imageclass;    
    @XmlElement(name = "imagepath")
    private String imagepath;
}
