package baba.server;

import baba.library.transfering.Parcel;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Date;

/**
 *
 * @author Petri Koskelainen
 */
public class ClientConnThread extends Thread {        
    
    boolean bLoop = false;
    private Socket socket = null;
    private Date tsInitialized = null;
    
    private ObjectInputStream INPUT = null;
    private ObjectOutputStream OUTPUT = null;
    
    
    
    public ClientConnThread() {
        tsInitialized = new Date();
    }
    
    @Override
    public void start(){
        if (socket != null) {
            try {
            INPUT = new ObjectInputStream( socket.getInputStream() );
            OUTPUT = new ObjectOutputStream( socket.getOutputStream() );
            bLoop = true;
            } catch (IOException e){}            
        } else {
            System.out.println("Started connection had no socket, stopping before starting");
            try {
                this.finalize();
            } catch (Throwable ex) {}
        }
        super.start();
    }
    
    @Override
    public void run() {        
        Object oReceived = null;
        while (bLoop) {
            try {
                oReceived = INPUT.readObject();
                this.receivingObject( oReceived );
            } catch (IOException e) {
                
            } catch (ClassNotFoundException ex) {
                
            }
        }
        this.finalize();
    }
    
    public synchronized void receivingObject( Object object ) {
        if (object instanceof Parcel) {
            Parcel p = (Parcel) object;
            System.out.println( p.getMessage() );
        }
    }
    
    public synchronized void sendObject( Object object ) {
        try {
            OUTPUT.writeObject( object );
            OUTPUT.flush();
        } catch (IOException e) {
            
        }
    }

    void setSocket(Socket s) {
        this.socket = s;         
    }
    
    public synchronized void  closeLoop() { this.bLoop = false; }
    
    @Override
    public void finalize() {
        this.closeLoop();
        try {
            if (this.INPUT != null) this.INPUT.close();
            if (this.OUTPUT != null) this.OUTPUT.close();
            if (this.socket != null) this.socket.close();
        } catch (IOException e) {}
        try {
            super.finalize();
        } catch (Throwable t) {}
    }
    
}
