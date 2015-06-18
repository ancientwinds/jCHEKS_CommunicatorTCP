package com.archosResearch.jCHEKS.communicator;

import com.archosResearch.jCHEKS.concept.communicator.AbstractCommunication;

/**
 *
 * @author Thomas Lepage thomas.lepage@hotmail.ca
 */
public interface SenderObserver {
    public void ackReceived(AbstractCommunication communication);
    public void secureAckReceived(AbstractCommunication communication);    
    public void failToReceiveAck(AbstractCommunication communication);    
    public void failToReceiveSecureAck(AbstractCommunication communication);
    public void timeOutReached(AbstractCommunication communication);
}
