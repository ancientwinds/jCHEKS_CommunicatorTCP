/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.archosResearch.jCHEKS.communicator.tcp;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Thomas Lepage thomas.lepage@hotmail.ca
 */
public class CommunicatorObservable {
    
    private List<CommunicatorObserver> observers = new ArrayList<CommunicatorObserver>();
    
    public void addObserver(CommunicatorObserver observer){
        this.observers.add(observer);
    }
    
    public void notifyMessageReceived(){
        for(CommunicatorObserver observer: this.observers){
            observer.messageReceived();
        }
    }
    
    public void notifyMessageACK(){
        for(CommunicatorObserver observer: this.observers){
            observer.ackReceived();
        }
    }
}
