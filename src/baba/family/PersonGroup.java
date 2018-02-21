package baba.family;

import baba.library.BabaSuperObject;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Petri Koskelainen
 */

@XmlRootElement
public class PersonGroup extends BabaSuperObject {
    
    private List<Person> Persons;
    
    @XmlElement
    public void setPersons(List<Person> list) { this.Persons = list; }
    public List<Person> getPersons() { return this.Persons; }
        
}
