/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.archosResearch.jCHEKS.communicator.tcp;

/**
 *
 * @author Thomas Lepage thomas.lepage@hotmail.ca
 */
public abstract class AbstractListeningThread implements Runnable{
    
    protected AbstractCommunicator communicator;
    protected boolean running = true;

    public void stop(){
        running = false;
    }
}
