
package com.archosResearch.jCHEKS.communicator.tcp;

import com.archosResearch.jCHEKS.communicator.SenderObserver;
import com.archosResearch.jCheks.concept.communicator.AbstractCommunication;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Thomas Lepage
 */
public class TCPSender extends ITCPSender{
            
    private final List<SenderObserver> observers = new ArrayList<>();

    private final String ipAddress;
    private final int port;
    
    public TCPSender(String ipAddress, int port) {
        this.ipAddress = ipAddress;
        this.port = port;
    }

    @Override
    public void sendCommunication(AbstractCommunication communication) throws TCPSocketException{
        try {
            //System.out.println("Attempting to connect to " + destinationClient.getConnectionInfo());
            Socket clientSocket = new Socket(this.ipAddress, this.port);
            
            //System.out.println("Connection established to " + destinationClient.getConnectionInfo());
            
            OutputStream outToDestination = clientSocket.getOutputStream();
            DataOutputStream dataOutToDestination = new DataOutputStream(outToDestination);
            
            System.out.println("Sending communication to destination...");
            dataOutToDestination.writeUTF(communication.getCommunicationString());
            
            // TODO : We should put a max waiting time for the ack to avoid hanging processes if the communication is lost
            // TODO : Then, we need to decide what we do if we don't receive the ack : to evolve, or not to evolve, that is the question!
            System.out.println("Waiting for ACK");
            InputStream inFromDestination = clientSocket.getInputStream();
            DataInputStream dataInFromDestination = new DataInputStream(inFromDestination);
            
            notifyMessageACK();
            
            System.out.println("From dest: " + dataInFromDestination.readUTF());
            
            clientSocket.close();
        } catch (IOException ex) {
            System.out.println("Could not create socket to the destination client.");
            Logger.getLogger(TCPCommunicator.class.getName()).log(Level.SEVERE, null, ex);
            throw new TCPSocketException();
        }    }

    @Override
    public void addObserver(SenderObserver observer) {
        this.observers.add(observer);
    }

    @Override
    public void notifyMessageACK() {
        for(SenderObserver observer: this.observers){
            observer.ackReceived();
        }
    }
}
