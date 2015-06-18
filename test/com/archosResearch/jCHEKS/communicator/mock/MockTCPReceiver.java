package com.archosResearch.jCHEKS.communicator.mock;

import com.archosResearch.jCHEKS.communicator.exception.ReceiverObserverNotFoundException;
import com.archosResearch.jCHEKS.communicator.tcp.TCPReceiver;
import com.archosResearch.jCHEKS.concept.communicator.AbstractCommunication;

/**
 *
 * @author Thomas Lepage thomas.lepage@hotmail.ca
 */
public class MockTCPReceiver extends TCPReceiver {

    public void notifyMessage(AbstractCommunication communication) throws ReceiverObserverNotFoundException {
        super.notifyMessageReceived(communication);
    }
}
