package pcpicker;

import javax.xml.bind.annotation.*;
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Mouse")
public class Mouse extends Part
{    

    /**
     * @return the dpi
     */
    public int getDpi() {
        return dpi;
    }

    /**
     * @param dpi the dpi to set
     */
    public void setDpi(int dpi) {
        this.dpi = dpi;
    }

    /**
     * @return the connection_
     */
    public String getConnection_() {
        return connection_;
    }

    /**
     * @param connection_ the connection_ to set
     */
    public void setConnection_(String connection_) {
        this.connection_ = connection_;
    }

    @XmlElement(name = "dpi")
    private int dpi;    
    @XmlElement(name = "connection_")
    private String connection_;
    

}
