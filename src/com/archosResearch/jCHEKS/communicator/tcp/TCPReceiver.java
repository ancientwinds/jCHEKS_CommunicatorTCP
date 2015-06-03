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
public class TCPReceiver extends AbstractTCPReceiver implements Runnable {

    private static TCPReceiver instance = null;

    private final int port = 9000;
    private ServerSocket listeningSocket;
    private boolean running = true;

    public static TCPReceiver getInstance() {
        if (instance == null) {
            instance = new TCPReceiver();
            Thread receiverThread = new Thread(instance);
            receiverThread.setDaemon(true);
            receiverThread.start();

        }
        return instance;
    }

    @Override
    public void run() {
        try {
            listeningSocket = new ServerSocket(this.port);

            while (running) {
                Socket client = listeningSocket.accept();
                System.out.println("Receiving communication...");

                DataInputStream dataIn = new DataInputStream(client.getInputStream());
                DataOutputStream dataOut = new DataOutputStream(client.getOutputStream());

                Communication communication = new Communication(dataIn.readUTF());
                notifyMessageReceived(communication);
                System.out.println("Sending ACK...");

                dataOut.writeUTF("I received your message");
            }

            listeningSocket.close();
        } catch (IOException ex) {
            Logger.getLogger(TCPCommunicator.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
