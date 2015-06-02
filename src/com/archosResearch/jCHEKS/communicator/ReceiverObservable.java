/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.archosResearch.jCHEKS.communicator;

import com.archosResearch.jCheks.concept.communicator.AbstractCommunication;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Thomas Lepage
 */
public class ReceiverObservable {
    
    private final List<ReceiverObserver> observers = new ArrayList<>();
    
    public void addObserver(ReceiverObserver observer){
        this.observers.add(observer);
    }
    
    public void notifyMessageReceived(AbstractCommunication communication){
        for(ReceiverObserver observer: this.observers){
            observer.messageReceived(communication);
        }
    }
}
