package com.archosResearch.jCHEKS.communicator.tcp;

import com.archosResearch.jCHEKS.communicator.*;
import com.archosResearch.jCHEKS.communicator.tcp.exception.*;
import com.archosResearch.jCHEKS.concept.communicator.AbstractCommunication;
import com.archosResearch.jCHEKS.concept.exception.*;
import java.io.*;
import java.net.*;

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
        Runnable sendCommunicationTask = () -> {
            try {
                sendCommunicationThread(communication);
            } catch (TCPSocketException | CommunicationException | TCPAckReceiverException ex) {
                notifyException(ex, communication);
            }
        };
        Thread sendCommunicationThread = new Thread(sendCommunicationTask);
        sendCommunicationThread.setDaemon(true);
        sendCommunicationThread.start();
    }
    
    private void sendCommunicationThread(AbstractCommunication communication) throws TCPSocketException, CommunicationException, TCPAckReceiverException {
        try {
            Socket clientSocket = new Socket(this.ipAddress, port);
            clientSocket.setSoTimeout(10000); 
            DataOutputStream dataOut = new DataOutputStream(clientSocket.getOutputStream());
            dataOut.writeUTF(communication.getCommunicationString());

            try {
                InputStream inFromDestination = clientSocket.getInputStream();
                DataInputStream dataInFromDestination = new DataInputStream(inFromDestination);
                String ackMessage = dataInFromDestination.readUTF();
                if(ackMessage.equals(communication.getCipherCheck())) {
                    notifyMessageACK(communication);         
                    try {
                        String secureAckMessage = dataInFromDestination.readUTF();
                        notifySecureACK(communication, secureAckMessage);
                    } catch (SocketTimeoutException ex) {
                        notifyFailSecureACK(communication);
                    }                               
                } else {
                    notifyFailAck(communication);
                } 
                clientSocket.close();
            } catch (SocketTimeoutException ex) {
                notifyFailAck(communication);
            } catch (IOException ex) {
                throw new TCPAckReceiverException("Error when receiving acknowledge", ex);
            }

        } catch (NoRouteToHostException ex) {
            throw new TCPNoRouteException("The destination is unreachable.", ex);
        } catch (ConnectException ex) {
            throw new TCPDestinationNotListeningException("The destination does not listen on the port: " + port, ex);
        } catch (IOException ex) {
            throw new TCPSocketException("Socket error.", ex);
        }
    }

    protected void notifyMessageACK(AbstractCommunication communication) {
        for (SenderObserver observer : this.observers) {
            observer.ackReceived(communication);
        }
    }

    protected void notifySecureACK(AbstractCommunication communication, String secureAck) {
        for (SenderObserver observer : this.observers) {
            observer.secureAckReceived(communication, secureAck);
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
    
    protected void notifyException(CommunicatorException exception, AbstractCommunication communication) {
        for (SenderObserver observer : this.observers) {
            observer.exceptionThrown(exception, communication);
        }
    }
}
