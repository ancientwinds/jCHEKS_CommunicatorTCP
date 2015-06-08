package com.archosResearch.jCHEKS.communicator.tcp.exception;

import com.archosResearch.jCHEKS.concept.exception.AbstractCommunicatorException;

/**
 *
 * @author Thomas Lepage
 */
public class TCPSocketException extends AbstractCommunicatorException {

    public TCPSocketException(String message) {
        super(message);
    }
    
    public TCPSocketException(String message, Throwable throwable) {
        super(message, throwable);
    }

}
