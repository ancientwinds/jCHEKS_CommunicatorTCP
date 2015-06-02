
package com.archosResearch.jCHEKS.communicator;

import com.archosResearch.jCheks.concept.communicator.AbstractCommunication;

/**
 *
 * @author Thomas Lepage
 */
public interface ReceiverObserver {
        
    public void messageReceived(AbstractCommunication communication);
}
