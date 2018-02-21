/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baba.server;

/**
 *
 * @author pete
 */
public class ShutdownHook extends Thread {

    private final BabaServer BABASERVER;

    ShutdownHook(BabaServer aThis) {
        this.BABASERVER = aThis;
    }
    
    @Override
    public void run() {
        System.out.println();
        System.out.println("Final shutdown!!");
        this.BABASERVER.finalize();
    }
}
