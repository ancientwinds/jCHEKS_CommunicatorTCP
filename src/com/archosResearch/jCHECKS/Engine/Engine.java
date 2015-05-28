/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.archosResearch.jCHECKS.Engine;

import com.archosResearch.jCHEKS.communicator.AbstractCommunicator;
import com.archosResearch.jCHEKS.communicator.CommunicatorObserver;
import com.archosResearch.jCHEKS.communicator.tcp.TCPCommunicator;
import com.archosResearch.jCHEKS.communicator.tcp.TempGUI;
import java.awt.EventQueue;

/**
 *
 * @author Thomas Lepage thomas.lepage@hotmail.ca
 */
public class Engine implements CommunicatorObserver{
    
    private static AbstractCommunicator communicator;
    
    public Engine(){
        communicator = new TCPCommunicator("127.0.0.1", 9000, this);
    }

    @Override
    public void messageReceived(String aMessage) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void ackReceived() {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public static void main(String[] args) {

        Engine engine = new Engine();
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
