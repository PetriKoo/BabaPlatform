package baba.library;

import java.io.File;
import java.io.Serializable;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
/**
 *
 * @author Petri Koskelainen
 */
@XmlRootElement
public class BabaSuperObject implements Serializable {
    
    private Long Id;
    
    @XmlAttribute
    public void setId( long l) { this.Id = l; }
    public long getId() { return this.Id; }
    
    public static void saveObjectToXml( BabaSuperObject object, Class<?> cClass, String sFileName) {
        try {
            File file = new File(sFileName);
            JAXBContext jaxbContext = JAXBContext.newInstance(cClass);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.marshal(object, file);		

        } catch (JAXBException e) { }
    }
    
    public static BabaSuperObject loadObjectFromXml(Class<?> cClass, String sFileName) {
        BabaSuperObject bsReturn = null;
        try {
            File file = new File(sFileName);
            JAXBContext jaxbContext = JAXBContext.newInstance(cClass);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            bsReturn = (BabaSuperObject) jaxbUnmarshaller.unmarshal(file);		
	  } catch (JAXBException e) {

	  }
        return bsReturn;
    }
    
}
