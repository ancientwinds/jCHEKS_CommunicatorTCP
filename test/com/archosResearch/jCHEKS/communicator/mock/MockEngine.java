package com.archosResearch.jCHEKS.communicator.mock;

import com.archosResearch.jCHEKS.concept.communicator.*;

/**
 *
 * @author Thomas Lepage thomas.lepage@hotmail.ca
 */
public class MockEngine implements CommunicatorObserver{
    
    public boolean ackReceived = false;
    public AbstractCommunication lastCommunication;

    @Override
    public void ackReceived() {
        this.ackReceived = true;
    }

    @Override
    public void communicationReceived(AbstractCommunication communication) {
        this.lastCommunication = communication;
    }
}
