package pcpicker;

import javax.xml.bind.annotation.*;
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Monitor")
public class Monitor extends Part
{    

    /**
     * @return the aspect_ratio
     */
    public String getAspect_ratio() {
        return aspect_ratio;
    }

    /**
     * @param aspect_ratio the aspect_ratio to set
     */
    public void setAspect_ratio(String aspect_ratio) {
        this.aspect_ratio = aspect_ratio;
    }

    /**
     * @return the screen_size
     */
    public int getScreen_size() {
        return screen_size;
    }

    /**
     * @param screen_size the screen_size to set
     */
    public void setScreen_size(int screen_size) {
        this.screen_size = screen_size;
    }

    /**
     * @return the max_resolution
     */
    public String getMax_resolution() {
        return max_resolution;
    }

    /**
     * @param max_resolution the max_resolution to set
     */
    public void setMax_resolution(String max_resolution) {
        this.max_resolution = max_resolution;
    }

    /**
     * @return the refresh_rate
     */
    public int getRefresh_rate() {
        return refresh_rate;
    }

    /**
     * @param refresh_rate the refresh_rate to set
     */
    public void setRefresh_rate(int refresh_rate) {
        this.refresh_rate = refresh_rate;
    }

    @XmlElement(name = "aspect_ratio")
    private String aspect_ratio;    
    @XmlElement(name = "screen_size")
    private int screen_size;
    @XmlElement(name = "max_resolution")
    private String max_resolution ;
    @XmlElement(name = "refresh_rate")
    private int refresh_rate;
    
  
}
