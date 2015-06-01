/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.archosResearch.jCHEKS.communicator.tcp;

import com.archosResearch.jCHEKS.communicator.Communication;

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
    
}
