/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.archosResearch.jCHEKS.communicator.tcp;

import com.archosResearch.jCheks.concept.communicator.AbstractCommunication;
import com.archosResearch.jCheks.concept.communicator.AbstractCommunicator;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Thomas Lepage
 */
public class TCPCommunicator extends AbstractCommunicator {
    
    private final ITCPSender sender;
    private final ITCPReceiver receiver;
   
    public TCPCommunicator(ITCPSender sender, ITCPReceiver receiver){

        this.sender = sender;
        //this.sender.addObserver(engine);
        
        this.receiver = receiver;
        //this.receiver.addObserver(engine);
    }
    
    @Override
    public void sendCommunication(AbstractCommunication communication) {
        try {
            this.sender.sendCommunication(communication);
        } catch (TCPSocketException ex) {
            Logger.getLogger(TCPCommunicator.class.getName()).log(Level.SEVERE, null, ex);
        }
    }  
}
