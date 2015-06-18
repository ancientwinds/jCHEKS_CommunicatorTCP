package com.archosResearch.jCHEKS.communicator.tcp;

import com.archosResearch.jCHEKS.communicator.*;
import com.archosResearch.jCHEKS.communicator.tcp.exception.*;
import com.archosResearch.jCHEKS.concept.communicator.AbstractCommunication;
import java.io.*;
import java.net.Socket;
import java.net.SocketTimeoutException;
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

            Runnable senderTask = () -> {
                try {
                    receiveAck(clientSocket, communication);
                } catch (TCPAckReceiverException ex) {
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
    
    protected void notifyFailAck(AbstractCommunication communication) {
        for (SenderObserver observer : this.observers) {
            observer.failToReceiveAck(communication);
        }
    }
    
    protected void notifyFailSecureACK(AbstractCommunication communication) {
        for (SenderObserver observer : this.observers) {
            observer.failToReceiveSecureAck(communication);
        }
    }
    
    protected void notifyTimeOutReach(AbstractCommunication communication) {
        for (SenderObserver observer : this.observers) {
            observer.timeOutReached(communication);
        }
    }

    private void receiveAck(Socket clientSocket, AbstractCommunication communication) throws TCPAckReceiverException {
        try {
            InputStream inFromDestination = clientSocket.getInputStream();
            DataInputStream dataInFromDestination = new DataInputStream(inFromDestination);
            String ackMessage = dataInFromDestination.readUTF();
            if(ackMessage.equals(communication.getCipherCheck())) {
                notifyMessageACK(communication);                
               
                String secureAckMessage = dataInFromDestination.readUTF();                
                if(secureAckMessage.equals("Testing secure ACK")) {
                    notifySecureACK(communication);
                } else {
                    notifyFailSecureACK(communication);
                }                
            } else {
                notifyFailAck(communication);
            } 
            clientSocket.close();
        } catch (SocketTimeoutException ex) {
            notifyFailAck(communication);
        } catch (IOException ex) {
            Logger.getLogger(TCPSender.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
