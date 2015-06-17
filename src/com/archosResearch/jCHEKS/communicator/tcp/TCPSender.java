package com.archosResearch.jCHEKS.communicator.tcp;

import com.archosResearch.jCHEKS.communicator.*;
import com.archosResearch.jCHEKS.communicator.tcp.exception.*;
import com.archosResearch.jCHEKS.concept.communicator.AbstractCommunication;
import java.io.*;
import java.net.Socket;
import java.util.logging.*;

/**
 *
 * @author Thomas Lepage thomas.lepage@hotmail.ca
 */
public class TCPSender extends AbstractSender {

    private final String ipAddress;
    private final int port;

    public TCPSender(String ipAddress, int port) {
        this.ipAddress = ipAddress;
        this.port = port;
    }

    @Override
    public void sendCommunication(AbstractCommunication communication) throws TCPSocketException {
        try {
            Socket clientSocket = new Socket(this.ipAddress, port);

            clientSocket.setSoTimeout(10000);

            OutputStream outToDestination = clientSocket.getOutputStream();
            DataOutputStream dataOutToDestination = new DataOutputStream(outToDestination);

            dataOutToDestination.write(communication.getCommunicationString().getBytes());

            InputStream inFromDestination = clientSocket.getInputStream();
            DataInputStream dataInFromDestination = new DataInputStream(inFromDestination);

            //TODO Create better ack system.
            dataInFromDestination.readUTF();
            notifyMessageACK(communication);

            Runnable senderTask = () -> {
                try {
                    receiveSecureAck(clientSocket, communication);
                } catch (TCPSecureAckReceiverException ex) {
                    Logger.getLogger(TCPSender.class.getName()).log(Level.SEVERE, null, ex);
                }
            };
            Thread senderSecureAckThread = new Thread(senderTask);
            senderSecureAckThread.start();

        } catch (IOException ex) {
            throw new TCPSocketException("Socket error.", ex);
        }
    }

    protected void notifyMessageACK(AbstractCommunication communication) {
        for (SenderObserver observer : this.observers) {
            observer.ackReceived(communication);
        }
    }

    protected void notifySecureACK(AbstractCommunication communication) {
        for (SenderObserver observer : this.observers) {
            observer.secureAckReceived(communication);
        }
    }

    private void receiveSecureAck(Socket clientSocket, AbstractCommunication communication) throws TCPSecureAckReceiverException {
        try {
            InputStream inFromDestination = clientSocket.getInputStream();
            DataInputStream dataInFromDestination = new DataInputStream(inFromDestination);
            String ackMessage = dataInFromDestination.readUTF();

            //Maybe send the ack.
            notifySecureACK(communication);
            clientSocket.close();
        } catch (IOException ex) {
            throw new TCPSecureAckReceiverException("Secure ACK error", ex);
        }
    }
}
