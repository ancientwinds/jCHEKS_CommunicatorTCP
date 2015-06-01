/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.archosResearch.jCHEKS.communicator.tcp;

import com.archosResearch.jCHEKS.communicator.AbstractCommunicator;
import com.archosResearch.jCHEKS.communicator.Communication;
import com.archosResearch.jCHEKS.Engine.Engine;

/**
 *
 * @author Thomas Lepage
 */
public class TCPCommunicator extends AbstractCommunicator{
    
    private final ITCPSender sender;
    private final ITCPReceiver receiver;
   
    public TCPCommunicator(ITCPSender sender, ITCPReceiver receiver, Engine engine){

        this.sender = sender;
        this.sender.addObserver(engine);
        
        this.receiver = receiver;
        this.receiver.addObserver(engine);
    }
    
    @Override
    public boolean sendCommunication(Communication communication) {
        return this.sender.sendCommunication(communication);
    }  
}
