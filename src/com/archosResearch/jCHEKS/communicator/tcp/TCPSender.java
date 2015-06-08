package com.archosResearch.jCHEKS.communicator.tcp;

import com.archosResearch.jCHEKS.communicator.tcp.exception.TCPSocketException;
import com.archosResearch.jCHEKS.communicator.SenderObserver;
import com.archosResearch.jCHEKS.concept.communicator.AbstractCommunication;
import java.io.*;
import java.net.Socket;

/**
 *
 * @author Thomas Lepage
 */
public class TCPSender extends AbstractSender {

    private final String ipAddress;
    private final int port;
    
    public TCPSender(String ipAddress, int port) {
        this.ipAddress = ipAddress;
        this.port = port;
    }
    
    public String getIpAddress() {
        return this.ipAddress;
    }
     
    @Override
    public void sendCommunication(AbstractCommunication communication) throws TCPSocketException {
        try {
            Socket clientSocket = new Socket(this.ipAddress, this.port);

            OutputStream outToDestination = clientSocket.getOutputStream();
            DataOutputStream dataOutToDestination = new DataOutputStream(outToDestination);

            System.out.println("Sending communication to destination...");
            
            dataOutToDestination.writeUTF(communication.getCommunicationString());
            
            // TODO : We should put a max waiting time for the ack to avoid hanging processes if the communication is lost
            // TODO : Then, we need to decide what we do if we don't receive the ack : to evolve, or not to evolve, that is the question!
            System.out.println("Waiting for ACK");
            InputStream inFromDestination = clientSocket.getInputStream();
            DataInputStream dataInFromDestination = new DataInputStream(inFromDestination);

            
            //TODO Create better ack system.
            notifyMessageACK();

            System.out.println("From dest: " + dataInFromDestination.readUTF());

            clientSocket.close();
        } catch (IOException ex) {
            throw new TCPSocketException("Socket error.", ex);
        }
    }

    public void notifyMessageACK() {
        for (SenderObserver observer : this.observers) {
            observer.ackReceived();
        }
    }
}
