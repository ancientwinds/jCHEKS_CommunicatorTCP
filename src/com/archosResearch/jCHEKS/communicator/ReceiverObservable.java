package com.archosResearch.jCHEKS.communicator;

import com.archosResearch.jCHEKS.communicator.tcp.TCPReceiver;
import com.archosResearch.jCHEKS.concept.communicator.AbstractCommunication;
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
        this.observers.get(ipAddress).messageReceived(communication);
    }
}
