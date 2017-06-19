/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pcpicker;

import javax.xml.bind.annotation.*;
/**
 *
 * @author admin
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Test")
public class Test {
    @XmlElement(name = "firstName")
    protected String firstName;    
    @XmlElement(name = "lastName")
    protected String lastName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String value) {
        this.firstName = value;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String value) {
        this.lastName = value;
    }
}
