package com.archosResearch.jCHEKS.communicator.exception;

/**
 *
 * @author Thomas Lepage thomas.lepage@hotmail.ca
 */
public class CommunicatorException extends com.archosResearch.jCHEKS.concept.exception.CommunicatorException{
    
    public CommunicatorException(String message) {
        super(message);
    }
    
    public CommunicatorException(String message, Throwable throwable) {
        super(message, throwable);
    }
    
}
