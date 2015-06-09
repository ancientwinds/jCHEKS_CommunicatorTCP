package com.archosResearch.jCHEKS.communicator.tcp.exception;

import com.archosResearch.jCHEKS.concept.exception.AbstractCommunicatorException;

/**
 *
 * @author Thomas Lepage thomas.lepage@hotmail.ca
 */
public class TCPSocketException extends AbstractCommunicatorException {

    public TCPSocketException(String message, Throwable throwable) {
        super(message, throwable);
    }

}
