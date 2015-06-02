/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.archosResearch.jCHEKS.communicator.tcp;

import com.archosResearch.jCHEKS.communicator.SenderObservable;
import com.archosResearch.jCheks.concept.communicator.Communication;

/**
 *
 * @author Thomas Lepage thomas.lepage@hotmail.ca
 */
public abstract class ITCPSender implements SenderObservable{
    public abstract void sendCommunication(Communication communication)  throws TCPSocketException;

}
