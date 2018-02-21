package baba.client;

import baba.library.exceptions.FileException;
import baba.library.fileutils.PropertyFileUtils;
import java.io.FileNotFoundException;
import java.util.Properties;

/**
 *
 * @author petri
 */
public class Start {
    
    private static BabaClient CLIENT;
    
    public static void main(String args[])  {
        Properties props = new Properties();
        boolean bReadingErrorOccurs = false;
        try {
            props = PropertyFileUtils.read( PropertyFileUtils.PropertyFile );
        } catch (FileNotFoundException | FileException ex) {
            bReadingErrorOccurs = true;
        }
        
        if (!bReadingErrorOccurs) {
            CLIENT = new BabaClient( props );
        } else {
            props = new Properties();
            props.setProperty("ServerAddress", "127.0.0.1");
            props.setProperty("ServerPort", "6068");
            try {
                PropertyFileUtils.write( PropertyFileUtils.PropertyFile , props , "- - - Settings for BabaClient - - -");
                System.out.println("Settings file written");
            } catch (FileException ex) {
                
            } finally {
                CLIENT = new BabaClient( props );
            }
            
        }
    }
}
