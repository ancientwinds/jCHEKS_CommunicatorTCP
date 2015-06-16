package com.archosResearch.jCHEKS.communicator.tcp;

import com.archosResearch.jCHEKS.communicator.AbstractReceiver;
import com.archosResearch.jCHEKS.communicator.Communication;
import java.io.*;
import java.net.*;
import java.util.HashMap;
import java.util.logging.*;

/**
 *
 * @author Thomas Lepage thomas.lepage@hotmail.ca
 */
public class TCPReceiver extends AbstractReceiver implements Runnable {

    private static TCPReceiver instance = null;

    private static int port = 9000;
    private boolean running = true;
    
    private HashMap<String, Socket> openClients = new HashMap();

    protected TCPReceiver() {}
    
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
    
    /*public void stopReceiver() {
        this.running = false;
    }*/

    @Override
    public void run() {
        try {
            ServerSocket listeningSocket = new ServerSocket(TCPReceiver.port);

            while (running) {
                Socket client = listeningSocket.accept();
                
                /*TCPReceiveThread receiveThread = new TCPReceiveThread(client, this);
                receiveThread.start();*/
                
                Runnable receiveTask = () -> { receiveSecureAck(client, this); };
                Thread receiveThread = new Thread(receiveTask);
                receiveThread.start();
            }

            listeningSocket.close();
        } catch (IOException ex) {
            //Find how to throw an exception through a thread.
            Logger.getLogger(TCPCommunicator.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    public int getPort() {
        return this.port;
    }
    
    private void receiveSecureAck(Socket socket, TCPReceiver receiver) {
        try {            
            System.out.println("Receiving communication...");

            DataInputStream dataIn = new DataInputStream(socket.getInputStream());
            DataOutputStream dataOut = new DataOutputStream(socket.getOutputStream());

            //TODO Maybe rethink this.
            
            byte[] message = new byte[2048]; 
            int bytesRead = dataIn.read(message);
            
            byte[] newMessage = new byte[bytesRead];
            newMessage = message;
            String ackSecure = receiver.notifyMessageReceived(Communication.createCommunication(new String(newMessage)));
            System.out.println("Sending ACK...");
             //TODO create better ack system.
            dataOut.writeUTF("I received your message");

            dataOut.writeUTF(ackSecure);

            socket.close();
        } catch (IOException ex) {
            //TODO Throw exception!!!
        }
    }

}
