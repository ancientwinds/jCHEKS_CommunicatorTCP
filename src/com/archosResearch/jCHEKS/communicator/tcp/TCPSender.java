package com.archosResearch.jCHEKS.communicator.tcp;

import com.archosResearch.jCHEKS.communicator.tcp.exception.TCPSocketException;
import com.archosResearch.jCHEKS.communicator.SenderObserver;
import com.archosResearch.jCHEKS.concept.communicator.AbstractCommunication;
import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 *
 * @author Thomas Lepage thomas.lepage@hotmail.ca
 */
public class TCPSender extends AbstractSender implements SecureAckObserver{

    private final String ipAddress;
    private final int port;
    
    public TCPSender(String ipAddress, int port) {
        this.ipAddress = ipAddress;
        this.port = port;
    }
    
    public String getIpAddress() {
        return this.ipAddress;
    }
    
    public int getPort() {
        return this.port;
    }
     
    @Override
    public void sendCommunication(AbstractCommunication communication) throws TCPSocketException {
        try {
            Socket clientSocket = new Socket();
            clientSocket.connect(new InetSocketAddress(this.ipAddress, port), 5000);
                        
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
            System.out.println(dataInFromDestination.readUTF());
            notifyMessageACK();
            
            TCPSecureAckReceiver ackReceiver = new TCPSecureAckReceiver(clientSocket);
            ackReceiver.addObserver(this);
            new Thread(ackReceiver).start();
            
        } catch (IOException ex) {
            throw new TCPSocketException("Socket error.", ex);
        }
    }

    protected void notifyMessageACK() {
        for (SenderObserver observer : this.observers) {
            observer.ackReceived();
        }
    }
    
    protected void notifySecureACK() {
        for (SenderObserver observer : this.observers) {
            observer.secureAckReceived();
        }
    }

    @Override
    public void notifySecureAckReceived(String ackMessage) {
        System.out.println("Secure ACK: " + ackMessage);
    }

    @Override
    public void notifyTimeoutReached() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
