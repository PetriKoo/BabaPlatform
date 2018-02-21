package baba.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Petri Koskelainen
 */
public class ServerSocketThread extends Thread {

    private int iSocketPort;
    ServerSocket serverSocket = null;
    boolean bLoop = true;
    public ServerSocketThread() {
        
    }
    
    public void initialize() {
        System.out.print("Setting server on port " + this.iSocketPort + "....");
        try {
            serverSocket = new ServerSocket( this.iSocketPort );
            System.out.println("OK!");
        } catch (IOException e) { 
            System.out.println("failed: " + e.getLocalizedMessage());
        }
    }
    
    @Override
    public void run() {
        Socket clientSocket;
        System.out.println("Server socket started accepting connections");
        while (bLoop) {
            try {                
                clientSocket = serverSocket.accept();
                ClientConnections.getInstance().addSocket( clientSocket );
            } catch (IOException e) {
                try {
                    this.finalize();
                } catch (Throwable ex) {}
            }
        }
        System.out.println("Server socket stopped accepting connections");
        this.finalize();
    }

    void setPort(int iSocketPort) { this.iSocketPort = iSocketPort; }
    
    public void stopListeningSocket() { bLoop = false; }
    
    @Override
    public void finalize() {
        if (this.isAlive()) this.stopListeningSocket();
        if (serverSocket != null) {
            System.out.print("Closing server socket....");
            try {
                this.serverSocket.close();
                System.out.println("OK!");
                this.serverSocket = null;
            } catch (IOException e) {
                System.out.println("failed: " + e.getLocalizedMessage());
            }
        } else {
            System.out.println("Not needed to close socket, it was null!");
        }
        
        
        try {
            super.finalize();
        } catch (Throwable ex) {}
    }
    
}
