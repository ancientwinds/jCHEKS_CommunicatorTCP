package com.archosResearch.jCHEKS.communicator;

import com.archosResearch.jCheks.concept.communicator.AbstractCommunication;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Thomas Lepage
 */
public abstract class ReceiverObservable {

    private final Map<String, ReceiverObserver> observers = new HashMap();

    public void addObserver(String ipAddress, ReceiverObserver observer) {
        this.observers.put(ipAddress, observer);
    }

    public void notifyMessageReceived(String ipAddress, AbstractCommunication communication) {
        System.out.println(ipAddress);
        System.out.println("count: " + this.observers.size());
        this.observers.get(ipAddress).messageReceived(communication);
    }
}
