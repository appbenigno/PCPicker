package pcpicker;

import javax.xml.bind.annotation.*;
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Cooler")
public class Cooler extends Part
{    

    /**
     * @return the liquid_cooling
     */
    public boolean isLiquid_cooling() {
        return liquid_cooling;
    }

    /**
     * @param liquid_cooling the liquid_cooling to set
     */
    public void setLiquid_cooling(boolean liquid_cooling) {
        this.liquid_cooling = liquid_cooling;
    }

    /**
     * @return the rated_tdp
     */
    public int getRated_tdp() {
        return rated_tdp;
    }

    /**
     * @param rated_tdp the rated_tdp to set
     */
    public void setRated_tdp(int rated_tdp) {
        this.rated_tdp = rated_tdp;
    }

    /**
     * @return the supported_sockets
     */
    public String getSupported_sockets() {
        return supported_sockets;
    }

    /**
     * @param supported_sockets the supported_sockets to set
     */
    public void setSupported_sockets(String supported_sockets) {
        this.supported_sockets = supported_sockets;
    }


   
    @XmlElement(name = "liquid_cooling")
    private boolean liquid_cooling;    
    @XmlElement(name = "rated_tdp")
    private int rated_tdp;
    @XmlElement(name = "supported_sockets")
    private String supported_sockets;
    
}
