package com.archosResearch.jCHEKS.communicator.exception;

import com.archosResearch.jCHEKS.concept.exception.AbstractCommunicatorException;

/**
 *
 * @author Thomas Lepage thomas.lepage@hotmail.ca
 */
public class CommunicatorException extends AbstractCommunicatorException{
    
    public CommunicatorException(String message, Throwable throwable) {
        super(message, throwable);
    }
    
}
