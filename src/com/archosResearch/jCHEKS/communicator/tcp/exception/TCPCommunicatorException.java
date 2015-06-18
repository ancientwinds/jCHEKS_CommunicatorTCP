package com.archosResearch.jCHEKS.communicator.tcp.exception;

import com.archosResearch.jCHEKS.concept.exception.CommunicatorException;

/**
 *
 * @author Thomas Lepage thomas.lepage@hotmail.ca
 */
public class TCPCommunicatorException extends CommunicatorException {

    public TCPCommunicatorException(String message) {
        super(message);
    }

    public TCPCommunicatorException(String message, Throwable throwable) {
        super(message, throwable);
    }

}
