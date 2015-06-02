/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.archosResearch.jCHEKS.communicator;

/**
 *
 * @author Thomas Lepage
 */
public interface SenderObservable {
    
    
    public void addObserver(SenderObserver observer);
    
    public void notifyMessageACK();
}
