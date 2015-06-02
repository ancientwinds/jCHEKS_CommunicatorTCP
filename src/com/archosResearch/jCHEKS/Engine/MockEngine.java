/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.archosResearch.jCHEKS.Engine;

import com.archosResearch.jCHEKS.communicator.Communication;
import com.archosResearch.jCheks.concept.communicator.AbstractCommunication;

/**
 *
 * @author Thomas Lepage
 */
public class MockEngine extends EngineInterface{
    
    private boolean ackReceived = false;
    private String messageReceived = "";
    
    public boolean isAckReceived()
    {
        return ackReceived;
    }
    
    public String getMessageReceived()
    {
        return messageReceived;
    }

    @Override
    public void ackReceived() {
        this.ackReceived = true;
    }

    @Override
    public void messageReceived(AbstractCommunication communication) {
        this.messageReceived = communication.getChipher(); 
    }
    
}