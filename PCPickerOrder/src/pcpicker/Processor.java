package pcpicker;

import javax.xml.bind.annotation.*;
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Processor")
public class Processor extends Part {


    /**
     * @return the core_clock
     */
    public double getCore_clock() {
        return core_clock;
    }

    /**
     * @param core_clock the core_clock to set
     */
    public void setCore_clock(double core_clock) {
        this.core_clock = core_clock;
    }

    /**
     * @return the core_num
     */
    public int getCore_num() {
        return core_num;
    }

    /**
     * @param core_num the core_num to set
     */
    public void setCore_num(int core_num) {
        this.core_num = core_num;
    }

    /**
     * @return the thread_num
     */
    public int getThread_num() {
        return thread_num;
    }

    /**
     * @param thread_num the thread_num to set
     */
    public void setThread_num(int thread_num) {
        this.thread_num = thread_num;
    }

    /**
     * @return the socket_
     */
    public String getSocket_() {
        return socket_;
    }

    /**
     * @param socket_ the socket_ to set
     */
    public void setSocket_(String socket_) {
        this.socket_ = socket_;
    }

    /**
     * @return the tdp
     */
    public int getTdp() {
        return tdp;
    }

    /**
     * @param tdp the tdp to set
     */
    public void setTdp(int tdp) {
        this.tdp = tdp;
    }

    /**
     * @return the comp_price
     */
    
  

    @XmlElement(name = "core_clock")
    protected double core_clock;    
    @XmlElement(name = "core_num")
    protected int core_num;
    @XmlElement(name = "thread_num")
    protected int thread_num;
    
    @XmlElement(name = "socket_")
    protected String socket_;
    @XmlElement(name = "tdp")
    protected int tdp;
    
   
}
