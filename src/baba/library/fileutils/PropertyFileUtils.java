package baba.library.fileutils;

import baba.library.exceptions.FileException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author petri
 */
public class PropertyFileUtils {

    public static File PropertyFile = new File("config.cfg");
    
    public static Properties read(File fFile) throws FileException,FileNotFoundException {
        Properties props = new Properties();
        if (!fFile.exists()) throw new FileNotFoundException( "File: " + fFile.getAbsolutePath());
        try {
            props.load( new FileReader( fFile ) );
        } catch (IOException ex) {
            throw new FileException(PropertyFileUtils.class, "IO-Error while reading file " + fFile.getAbsolutePath());
        }
        return props;
    }
    
    public static void write(File fFile, Properties props, String sCommentText) throws FileException {
        try {
            props.store( new FileWriter( fFile), sCommentText) ;
        } catch (IOException ex) {
            throw new FileException(PropertyFileUtils.class, "IO-Error while writing file " + fFile.getAbsolutePath());
        }
    }
   
}
