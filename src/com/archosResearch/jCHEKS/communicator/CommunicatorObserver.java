/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.archosResearch.jCHEKS.communicator;

/**
 *
 * @author Thomas Lepage thomas.lepage@hotmail.ca
 */
public abstract class CommunicatorObserver {
    
    public abstract void update();
    
    public abstract void messageReceived(String message);
    public abstract void ackReceived();
}
