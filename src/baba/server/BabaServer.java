package baba.server;

import java.util.Properties;

/**
 *
 * @author Petri Koskelainen
 */
public class BabaServer {

    private ServerSocketThread SOCKETTHREAD = null;
    private int iSocketPort = 6060;
        
    public BabaServer(Properties props) {
        Runtime.getRuntime().addShutdownHook( new ShutdownHook(this) );
        this.init();
        iSocketPort = Integer.parseInt( props.getProperty("ServerPort") );
    }
    
    private void init() {
        SOCKETTHREAD = new ServerSocketThread();
        SOCKETTHREAD.setPort( this.iSocketPort );
        SOCKETTHREAD.initialize();
        SOCKETTHREAD.start();                
    }
    
    @Override
    public void finalize() {
        System.out.println("BabaServer - finalize");        
        if (SOCKETTHREAD != null) {
            this.SOCKETTHREAD.stopListeningSocket();
            this.SOCKETTHREAD.finalize();
        }
        
        try {            
            super.finalize();
        } catch (Throwable e) {}        
    }
    
}
