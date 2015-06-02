/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.archosResearch.jCHEKS.Engine;

import com.archosResearch.jCHEKS.communicator.tcp.TCPCommunicator;
import com.archosResearch.jCHEKS.TempGUI.TempGUI;
import com.archosResearch.jCHEKS.communicator.tcp.TCPReceiver;
import com.archosResearch.jCHEKS.communicator.tcp.TCPSender;
import com.archosResearch.jCheks.concept.communicator.AbstractCommunicator;
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
        TCPSender sender = new TCPSender("127.0.0.1", 9000);
       
        AbstractCommunicator communicator = new TCPCommunicator(sender, TCPReceiver.getInstance(), engine);
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
