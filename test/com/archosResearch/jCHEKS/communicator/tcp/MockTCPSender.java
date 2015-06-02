/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.archosResearch.jCHEKS.communicator.tcp;

import com.archosResearch.jCHEKS.communicator.SenderObserver;
import com.archosResearch.jCheks.concept.communicator.Communication;

/**
 *
 * @author Thomas Lepage thomas.lepage@hotmail.ca
 */
public class MockTCPSender extends ITCPSender{

    private boolean communicationSent = false;
    
    @Override
    public void sendCommunication(Communication communication) {
        this.communicationSent = true;
    }
    
    public boolean isCommunicationSent() {
        return this.communicationSent;
    }

    @Override
    public void addObserver(SenderObserver observer) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void notifyMessageACK() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
