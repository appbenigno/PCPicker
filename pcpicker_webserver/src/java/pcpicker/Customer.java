package pcpicker;

import javax.xml.bind.annotation.*;
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Customer")
public class Customer 
{

    /**
     * @return the cust_id
     */
    public int getCust_id() {
        return cust_id;
    }

    /**
     * @param cust_id the cust_id to set
     */
    public void setCust_id(int cust_id) {
        this.cust_id = cust_id;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city the city to set
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @return the zip_code
     */
    public int getZip_code() {
        return zip_code;
    }

    /**
     * @param zip_code the zip_code to set
     */
    public void setZip_code(int zip_code) {
        this.zip_code = zip_code;
    }
    @XmlElement(name = "cust_id")
    private int cust_id;    
    @XmlElement(name = "username")
    private String username;    
    @XmlElement(name = "password")
    private String password;
    @XmlElement(name = "address")
    private String address;
    @XmlElement(name = "city")
    private String city;    
    @XmlElement(name = "zip_code")
    private int zip_code;    
}