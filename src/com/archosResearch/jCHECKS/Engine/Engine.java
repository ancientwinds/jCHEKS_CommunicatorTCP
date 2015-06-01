/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.archosResearch.jCHECKS.Engine;

import com.archosResearch.jCHEKS.communicator.tcp.TCPCommunicator;
import com.archosResearch.jCHEKS.communicator.tcp.TempGUI;
import java.awt.EventQueue;

/**
 *
 * @author Thomas Lepage
 */
public class Engine extends EngineInterface{
    
    @Override
    public void messageReceived(String message) {
        //TODO Temporary method.
        System.out.println("Message received: " + message);
    }

    @Override
    public void ackReceived() {
        //TODO Temporary method.
        System.out.println("ACK received");
    }
    
    public static void main(String[] args) {
        
        Engine engine = new Engine();
        TCPCommunicator communicator = new TCPCommunicator("127.0.0.1", 9000, engine);
        //TODO Temporary UI for testing.
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                TempGUI ex = new TempGUI(communicator);
                ex.setVisible(true);
            }
        });
    } 
    
}
