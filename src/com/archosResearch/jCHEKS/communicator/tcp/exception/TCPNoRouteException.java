/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
