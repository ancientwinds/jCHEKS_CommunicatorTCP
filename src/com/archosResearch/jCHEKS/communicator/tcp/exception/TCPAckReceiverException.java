package com.archosResearch.jCHEKS.communicator.tcp.exception;

import com.archosResearch.jCHEKS.communicator.exception.CommunicatorException;

/**
 *
 * @author Thomas Lepage thomas.lepage@hotmail.ca
 */
public class TCPAckReceiverException extends CommunicatorException {

    public TCPAckReceiverException(String message, Throwable throwable) {
        super(message, throwable);
    }

}
