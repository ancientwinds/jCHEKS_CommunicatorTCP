package com.archosResearch.jCHEKS.communicator.tcp;

import com.archosResearch.jCHEKS.concept.communicator.AbstractObservable;
import java.io.*;
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
            System.out.println("Waiting for secure ack");
            String ackMessage = dataInFromDestination.readUTF();
            
            notifyAckReceived(ackMessage);
            
            clientSocket.close();
            
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
