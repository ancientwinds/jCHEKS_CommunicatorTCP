/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.archosResearch.jCHEKS.communicator.mock;

import com.archosResearch.jCHEKS.concept.communicator.AbstractCommunication;
import com.archosResearch.jCHEKS.concept.communicator.CommunicatorObserver;

/**
 *
 * @author Thomas Lepage thomas.lepage@hotmail.ca
 */
public class MockCommunicatorObserver implements CommunicatorObserver{

    public boolean ackReceived = false;
    public AbstractCommunication communication;
    
    @Override
    public void ackReceived() {
        this.ackReceived = true;
    }

    @Override
    public void communicationReceived(AbstractCommunication communication) {
        this.communication = communication;
    }
    
}
