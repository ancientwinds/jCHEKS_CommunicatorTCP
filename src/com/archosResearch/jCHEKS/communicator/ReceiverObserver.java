package com.archosResearch.jCHEKS.communicator;

import com.archosResearch.jCHEKS.concept.communicator.AbstractCommunication;

/**
 *
 * @author Thomas Lepage
 */
public interface ReceiverObserver {
    public String messageReceived(AbstractCommunication communication);
}
