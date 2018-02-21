package baba.server;

import java.net.Socket;

/**
 *
 * @author Petri Koskelainen
 */
public class ClientConnections {
    
    private static ClientConnections INSTANCE = null;
    
    private ClientConnections() {
                
    }
        
    public static ClientConnections getInstance() {
        if (INSTANCE == null) {
            
            synchronized (ClientConnections.class) {
                if (INSTANCE == null) {
                    INSTANCE = new ClientConnections();
                }
            }
        }
        return INSTANCE;
    }
    
    public synchronized void addSocket( Socket s) {
        ClientConnThread cct = new ClientConnThread();
        cct.setSocket( s );
        cct.start();
    }
}
