package com.archosResearch.jCHEKS.communicator.tcp;

import com.archosResearch.jCHEKS.communicator.*;
import com.archosResearch.jCHEKS.communicator.exception.ReceiverObserverNotFoundException;
import com.archosResearch.jCHEKS.communicator.tcp.exception.TCPSocketException;
import java.io.*;
import java.net.*;
import java.util.Arrays;
import java.util.logging.*;

/**
 *
 * @author Thomas Lepage thomas.lepage@hotmail.ca
 */
public class TCPReceiver extends AbstractReceiver implements Runnable {

    private static TCPReceiver instance = null;

    private static int port = 9000;
    private boolean running = true;

    protected TCPReceiver() {
    }

    public static TCPReceiver getInstance(int port) {
        if (instance == null) {
            instance = new TCPReceiver();
            TCPReceiver.port = port;
            Thread receiverThread = new Thread(instance);
            receiverThread.setDaemon(true);
            receiverThread.start();
        }
        return instance;
    }
    
    public static TCPReceiver getInstance() {
        return TCPReceiver.getInstance(TCPReceiver.port);
    }

    public void stopReceiver() {
        this.running = false;
    }

    @Override
    public void run() {
        try {
            ServerSocket listeningSocket = new ServerSocket(TCPReceiver.port);

            while (running) {
                Socket client = listeningSocket.accept();

                Runnable receiveTask = () -> {
                    try {
                        receiveCommunication(client, this);
                    } catch (ReceiverObserverNotFoundException | TCPSocketException ex) {
                        Logger.getLogger(TCPReceiver.class.getName()).log(Level.SEVERE, null, ex);
                    }
                };
                Thread receiveThread = new Thread(receiveTask);
                receiveThread.start();
            }

            listeningSocket.close();
        } catch (IOException ex) {
            //Find how to throw an exception through a thread.
            Logger.getLogger(TCPCommunicator.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void receiveCommunication(Socket socket, TCPReceiver receiver) throws ReceiverObserverNotFoundException, TCPSocketException {
        try {

            DataInputStream dataIn = new DataInputStream(socket.getInputStream());
            DataOutputStream dataOut = new DataOutputStream(socket.getOutputStream());

            //TODO Maybe rethink this.
            byte[] message = new byte[2048];
            int bytesRead = dataIn.read(message);
            System.out.println("Receiving communication");

            message = Arrays.copyOf(message, bytesRead);
            //TODO create better ack system.
            
            //Reception of the message ACK
            Communication receivedCommunication = Communication.createCommunication(new String(message));
            dataOut.writeUTF(receivedCommunication.getCipherCheck());

            String ackSecure = receiver.notifyMessageReceived(receivedCommunication);
            //Decoding of the message ACK (Secure ACK)
            dataOut.writeUTF(ackSecure);

            socket.close();
        } catch (IOException ex) {
            throw new TCPSocketException("TCPReceiver error", ex);
        }
    }

}
