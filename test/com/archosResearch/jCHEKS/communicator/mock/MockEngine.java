package com.archosResearch.jCHEKS.communicator.mock;

import com.archosResearch.jCHEKS.concept.communicator.*;
import com.archosResearch.jCHEKS.concept.exception.CommunicatorException;

/**
 *
 * @author Thomas Lepage thomas.lepage@hotmail.ca
 */
public class MockEngine implements CommunicatorObserver {

    public boolean ackReceived = false;
    public boolean secureAckReceived = false;
    public AbstractCommunication lastCommunication;

    @Override
    public void ackReceived(AbstractCommunication communication) {
        this.ackReceived = true;
    }

    @Override
    public String communicationReceived(AbstractCommunication communication) {
        this.lastCommunication = communication;
        return communication.getCipher();
    }

    @Override
    public void secureAckReceived(AbstractCommunication communication, String secureAck) {
        this.secureAckReceived = true;
    }

    @Override
    public void failToReceiveAck(AbstractCommunication communication) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void failToReceiveSecureAck(AbstractCommunication communication) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void timeOutReached(AbstractCommunication communication) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void exceptionThrown(CommunicatorException ex, AbstractCommunication communication) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
