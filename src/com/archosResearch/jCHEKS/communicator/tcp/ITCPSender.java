/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.archosResearch.jCHEKS.communicator.tcp;

import com.archosResearch.jCHEKS.communicator.Communication;
import com.archosResearch.jCHEKS.communicator.SenderObservable;

/**
 *
 * @author Thomas Lepage thomas.lepage@hotmail.ca
 */
public abstract class ITCPSender extends SenderObservable{
    public abstract boolean sendCommunication(Communication communication);

}
