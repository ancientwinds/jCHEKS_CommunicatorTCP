package com.archosResearch.jCHEKS.communicator;

import com.archosResearch.jCHEKS.communicator.exception.ReceiverObserverNotFoundException;
import com.archosResearch.jCHEKS.concept.communicator.AbstractCommunication;
import java.util.HashMap;

/**
 *
 * @author Thomas Lepage thomas.lepage@hotmail.ca
 */
public abstract class ReceiverObservable {

    private final HashMap<String, ReceiverObserver> observers = new HashMap();

    public void addObserver(String uniqueId, ReceiverObserver observer) {
        this.observers.put(uniqueId, observer);
    }

    public String notifyMessageReceived(AbstractCommunication communication) throws ReceiverObserverNotFoundException {
        ReceiverObserver observer = this.observers.get(communication.getSystemId());
        if (observer == null) {
            throw new ReceiverObserverNotFoundException("Receiver observer not found");
        }
        return observer.messageReceived(communication);
    }
}
