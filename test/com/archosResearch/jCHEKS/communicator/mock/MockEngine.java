package com.archosResearch.jCHEKS.communicator.mock;

import com.archosResearch.jCHEKS.concept.communicator.*;

/**
 *
 * @author Thomas Lepage thomas.lepage@hotmail.ca
 */
public class MockEngine implements CommunicatorObserver{
    
    public boolean ackReceived = false;
    public boolean secureAckReceived = false;
    public AbstractCommunication lastCommunication;

    @Override
    public void ackReceived() {
        this.ackReceived = true;
    }

    @Override
    public String communicationReceived(AbstractCommunication communication) {
        this.lastCommunication = communication;
        return communication.getCipher();
    }

    @Override
    public void secureAckReceived() {
        this.secureAckReceived = true;
    }
}
