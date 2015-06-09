/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.archosResearch.jCHEKS.communicator.tcp;

import com.archosResearch.jCHEKS.communicator.SenderObserver;
import com.archosResearch.jCHEKS.concept.communicator.AbstractObservable;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

/**
 *
 * @author Thomas Lepage thomas.lepage@hotmail.ca
 */
public class TCPSecureAckReceiver extends AbstractObservable<SecureAckObserver> implements Runnable{

    private final Socket clientSocket;
    
    public TCPSecureAckReceiver(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }
    
    @Override
    public void run() {
        try {
            InputStream inFromDestination = this.clientSocket.getInputStream();
            DataInputStream dataInFromDestination = new DataInputStream(inFromDestination);
            
            String ackMessage = dataInFromDestination.readUTF();
            
            notifyAckReceived(ackMessage);
            
            
        } catch (IOException ex) {
            //TODO throw TCPSecureAckReceiverException
        }
    }
    
    private void notifyAckReceived(String ackMessage) {
        for (SecureAckObserver observer : this.observers) {
            observer.notifySecureAckReceived(ackMessage);
        }
    }
    
}
