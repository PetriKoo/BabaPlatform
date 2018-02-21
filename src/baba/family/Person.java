package baba.family;

import baba.library.BabaSuperObject;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Petri Koskelainen
 */

@XmlRootElement
public class Person extends BabaSuperObject {

    private String FirstName;
    private String LastName;
    
    @XmlElement
    public void setFirstName(String sFirstName) { this.FirstName = sFirstName; }
    public String getFirstName() { return FirstName; }
    
    @XmlElement
    public void setLastName(String sLastName) { this.LastName = sLastName; }
    public String getLastName() { return LastName; }
    
}
