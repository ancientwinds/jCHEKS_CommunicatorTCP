package com.archosResearch.jCHEKS.communicator.tcp.exception;

/**
 *
 * @author Thomas Lepage thomas.lepage@hotmail.ca
 */
public class TCPNoRouteException extends TCPSocketException{

    public TCPNoRouteException(String message, Throwable throwable) {
        super(message, throwable);
    }
    
}
