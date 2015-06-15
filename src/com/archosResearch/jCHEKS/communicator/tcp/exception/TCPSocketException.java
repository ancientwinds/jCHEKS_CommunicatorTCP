package com.archosResearch.jCHEKS.communicator.tcp.exception;

import com.archosResearch.jCHEKS.concept.exception.CommunicatorException;

/**
 *
 * @author Thomas Lepage thomas.lepage@hotmail.ca
 */
public class TCPSocketException extends CommunicatorException {

    public TCPSocketException(String message, Throwable throwable) {
        super(message, throwable);
    }

}
