/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.archosResearch.jCHEKS.communicator.exception;

import com.archosResearch.jCHEKS.concept.exception.AbstractCommunicatorException;

/**
 *
 * @author Thomas Lepage thomas.lepage@hotmail.ca
 */
public class CommunicatorException extends AbstractCommunicatorException{

    public CommunicatorException(String message) {
        super(message);
    }
    
    public CommunicatorException(String message, Throwable throwable) {
        super(message, throwable);
    }
    
}
