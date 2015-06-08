package com.archosResearch.jCHEKS.communicator.tcp;

import com.archosResearch.jCHEKS.communicator.Communication;
import java.io.*;
import java.net.*;
import java.util.logging.*;

/**
 *
 * @author Thomas Lepage
 */
public class TCPReceiver extends AbstractReceiver implements Runnable {

    private static TCPReceiver instance = null;

    private static int port;
    private boolean running = true;

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
    
    /*public void stopReceiver() {
        this.running = false;
    }*/

    @Override
    public void run() {
        try {
            ServerSocket listeningSocket = new ServerSocket(TCPReceiver.port);

            while (running) {
                Socket client = listeningSocket.accept();
                System.out.println("Receiving communication...");

                DataInputStream dataIn = new DataInputStream(client.getInputStream());
                DataOutputStream dataOut = new DataOutputStream(client.getOutputStream());

                notifyMessageReceived(client.getInetAddress().getHostAddress(), Communication.createCommunication(dataIn.readUTF()));
                System.out.println("Sending ACK...");
                 //TODO create better ack system.
                dataOut.writeUTF("I received your message");
                client.close();
            }

            listeningSocket.close();
        } catch (IOException ex) {
            
            //Find how to throw an exception through a thread.
            Logger.getLogger(TCPCommunicator.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
