package com.archosResearch.jCHEKS.communicator.mock;

import com.archosResearch.jCHEKS.communicator.ReceiverObserver;
import com.archosResearch.jCHEKS.communicator.SenderObserver;
import com.archosResearch.jCHEKS.concept.communicator.AbstractCommunication;
import com.archosResearch.jCHEKS.concept.communicator.AbstractCommunicator;
import com.archosResearch.jCHEKS.concept.exception.CommunicatorException;

/**
 *
 * @author Thomas Lepage thomas.lepage@hotmail.ca
 */
public class MockCommunicator extends AbstractCommunicator implements SenderObserver, ReceiverObserver{

    public AbstractCommunication messageAckCommunication = null;
    public AbstractCommunication secureAckCommunication = null;
    public String secureAckString = "";
    public AbstractCommunication failAckCommunication = null;
    public AbstractCommunication failSecureAckCommunication = null;
    public AbstractCommunication timeOutCommunication = null;
    public AbstractCommunication exceptionCommunication = null;
    public Exception notifyException = null;

    
    @Override
    public void sendCommunication(AbstractCommunication communication) throws CommunicatorException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void ackReceived(AbstractCommunication communication) {
        this.messageAckCommunication = communication;
    }

    @Override
    public void secureAckReceived(AbstractCommunication communication, String secureAck) {
        this.secureAckCommunication = communication;
        this.secureAckString = secureAck;
    }

    @Override
    public void failToReceiveAck(AbstractCommunication communication) {
        this.failAckCommunication = communication;
    }

    @Override
    public void failToReceiveSecureAck(AbstractCommunication communication) {
        this.failSecureAckCommunication = communication;
    }

    @Override
    public void timeOutReached(AbstractCommunication communication) {
        this.timeOutCommunication = communication;
    }

    @Override
    public void exceptionThrown(CommunicatorException exception, AbstractCommunication communication) {
        this.exceptionCommunication = communication;
        this.notifyException = exception;
    }

    @Override
    public String messageReceived(AbstractCommunication communication) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
