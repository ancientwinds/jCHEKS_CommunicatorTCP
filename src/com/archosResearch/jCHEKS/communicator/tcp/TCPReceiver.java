package com.archosResearch.jCHEKS.communicator.tcp;

import com.archosResearch.jCHEKS.communicator.Communication;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Thomas Lepage
 */
public class TCPReceiver extends AbstractReceiver implements Runnable {

    private static TCPReceiver instance = null;

    private static int port;
    private boolean running = true;

    private TCPReceiver() {
        
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
    
    public void stopReceiver() {
        this.running = false;
    }

    @Override
    public void run() {
        try {
            ServerSocket listeningSocket = new ServerSocket(TCPReceiver.port);

            while (running) {
                Socket client = listeningSocket.accept();
                System.out.println("Receiving communication...");

                DataInputStream dataIn = new DataInputStream(client.getInputStream());
                DataOutputStream dataOut = new DataOutputStream(client.getOutputStream());

                Communication communication = new Communication(dataIn.readUTF());
                notifyMessageReceived(client.getInetAddress().getHostAddress(), communication);
                System.out.println("Sending ACK...");
                 //TODO
                dataOut.writeUTF("I received your message");
            }

            listeningSocket.close();
        } catch (IOException ex) {
            Logger.getLogger(TCPCommunicator.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
