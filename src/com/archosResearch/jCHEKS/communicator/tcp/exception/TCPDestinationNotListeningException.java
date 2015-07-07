package com.archosResearch.jCHEKS.communicator.tcp.exception;

/**
 *
 * @author Thomas Lepage thomas.lepage@hotmail.ca
 */
public class TCPDestinationNotListeningException extends TCPSocketException{

    public TCPDestinationNotListeningException(String message, Throwable throwable) {
        super(message, throwable);
    }
    
}
