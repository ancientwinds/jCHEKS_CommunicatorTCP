package com.archosResearch.jCHEKS.communicator.tcp;

/**
 *
 * @author Thomas Lepage thomas.lepage@hotmail.ca
 */
public interface SecureAckObserver {
    public void notifySecureAckReceived(String ackMessage);
    public void notifyTimeoutReached();
}
