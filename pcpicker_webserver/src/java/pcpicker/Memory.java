package pcpicker;

import javax.xml.bind.annotation.*;
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Memory")
public class Memory extends Part
{


    /**
     * @return the mem_capacity
     */
    public int getMem_capacity() {
        return mem_capacity;
    }

    /**
     * @param mem_capacity the mem_capacity to set
     */
    public void setMem_capacity(int mem_capacity) {
        this.mem_capacity = mem_capacity;
    }

    /**
     * @return the mem_ddr
     */
    public String getMem_ddr() {
        return mem_ddr;
    }

    /**
     * @param mem_ddr the mem_ddr to set
     */
    public void setMem_ddr(String mem_ddr) {
        this.mem_ddr = mem_ddr;
    }

    /**
     * @return the mem_clock
     */
    public int getMem_clock() {
        return mem_clock;
    }

    /**
     * @param mem_clock the mem_clock to set
     */
    public void setMem_clock(int mem_clock) {
        this.mem_clock = mem_clock;
    }

    
    @XmlElement(name = "mem_capacity")
    private int mem_capacity;    
    @XmlElement(name = "mem_ddr")
    private String mem_ddr;
    @XmlElement(name = "mem_clock")
    private int mem_clock;
}
