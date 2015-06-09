package com.archosResearch.jCHEKS.communicator;

/**
 *
 * @author Thomas Lepage thomas.lepage@hotmail.ca
 */
public interface SenderObserver {
    public void ackReceived();
    public void secureAckReceived();
}
