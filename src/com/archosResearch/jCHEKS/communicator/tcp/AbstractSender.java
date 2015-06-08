package com.archosResearch.jCHEKS.communicator.tcp;

import com.archosResearch.jCHEKS.communicator.tcp.exception.TCPSocketException;
import com.archosResearch.jCHEKS.concept.communicator.*;
import com.archosResearch.jCHEKS.communicator.SenderObserver;

/**
 *
 * @author Thomas Lepage thomas.lepage@hotmail.ca
 */
public abstract class AbstractSender extends AbstractObservable<SenderObserver> {
    public abstract void sendCommunication(AbstractCommunication communication) throws TCPSocketException;
}
