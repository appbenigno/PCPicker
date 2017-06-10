package pcpicker;

import javax.xml.bind.annotation.*;
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Motherboard")
public class Motherboard extends Part
{    

    /**
     * @return the socket
     */
    public String getSocket() {
        return socket;
    }

    /**
     * @param socket the socket to set
     */
    public void setSocket(String socket) {
        this.socket = socket;
    }

    /**
     * @return the mem_slots
     */
    public int getMem_slots() {
        return mem_slots;
    }

    /**
     * @param mem_slots the mem_slots to set
     */
    public void setMem_slots(int mem_slots) {
        this.mem_slots = mem_slots;
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

 
    @XmlElement(name = "socket")
    private String socket;    
    @XmlElement(name = "mem_slots")
    private int mem_slots;
    @XmlElement(name = "form_factor")
    private String form_factor ;

}
