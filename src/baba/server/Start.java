package baba.server;

import baba.library.exceptions.FileException;
import baba.library.fileutils.PropertyFileUtils;
import java.io.FileNotFoundException;
import java.util.Properties;

/**
 *
 * @author Petri Koskelainen
 */
public class Start {
    
    private static BabaServer SERVER;
    
    public static void main(String args[]) {
        Properties props = new Properties();
        boolean bReadingErrorOccurs = false;
        try {
            props = PropertyFileUtils.read( PropertyFileUtils.PropertyFile );
        } catch (FileNotFoundException | FileException ex) {
            bReadingErrorOccurs = true;
        }
        
        if (!bReadingErrorOccurs) {
            SERVER = new BabaServer( props );
        } else {
            props = new Properties();    
            // ToDo: Tähän oletusasetuksia
            props.setProperty("ServerPort", "6068");
            try {
                PropertyFileUtils.write( PropertyFileUtils.PropertyFile , props , "- - - Settings for BabaServer - - -");
            } catch (FileException ex) {
                
            } finally {
                SERVER = new BabaServer( props );
            }
        }
    }
}
