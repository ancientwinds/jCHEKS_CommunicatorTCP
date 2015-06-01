/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.archosResearch.jCHEKS.communicator;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Thomas Lepage thomas.lepage@hotmail.ca
 */
public class ReceiverObservable {
    
    private final List<ReceiverObserver> observers = new ArrayList<>();
    
    public void addObserver(ReceiverObserver observer){
        this.observers.add(observer);
    }
    
    public void notifyMessageReceived(String message){
        for(ReceiverObserver observer: this.observers){
            observer.messageReceived(message);
        }
    }
}
