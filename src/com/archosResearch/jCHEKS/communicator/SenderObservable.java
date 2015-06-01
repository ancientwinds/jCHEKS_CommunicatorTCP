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
 * @author Thomas Lepage
 */
public class SenderObservable {
    
    private final List<SenderObserver> observers = new ArrayList<>();
    
    public void addObserver(SenderObserver observer){
        this.observers.add(observer);
    }
    
    public void notifyMessageACK(){
        for(SenderObserver observer: this.observers){
            observer.ackReceived();
        }
    }
}
