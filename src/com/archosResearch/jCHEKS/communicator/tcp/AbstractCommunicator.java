/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.archosResearch.jCHEKS.communicator.tcp;

import java.util.Observable;

/**
 *
 * @author Thomas Lepage thomas.lepage@hotmail.ca
 */
public abstract class AbstractCommunicator extends Observable{
    //TODO eventually move this class into the Conceps project
    //TODO do not use the Java Observable mechanism, build our own instead so it will be tailored to our needs. 
    private Thread listenThread;
    
    public abstract boolean sendCommunication(Communication communication);
}
