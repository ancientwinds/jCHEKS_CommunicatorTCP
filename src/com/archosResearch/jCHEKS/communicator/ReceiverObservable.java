package com.archosResearch.jCHEKS.communicator;

import com.archosResearch.jCHEKS.concept.communicator.AbstractCommunication;
import java.util.HashMap;

/**
 *
 * @author Thomas Lepage thomas.lepage@hotmail.ca
 */
public abstract class ReceiverObservable {

    private final HashMap<String, ReceiverObserver> observers = new HashMap();

    public void addObserver(String ipAddress, ReceiverObserver observer) {
        this.observers.put(ipAddress, observer);
    }

    public String  notifyMessageReceived(String ipAddress, AbstractCommunication communication) {
        return this.observers.get(ipAddress).messageReceived(communication);
    }
}
