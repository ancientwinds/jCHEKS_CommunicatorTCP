package com.archosResearch.jCHEKS.communicator.tcp;

import com.archosResearch.jCHEKS.communicator.ReceiverObserver;
import com.archosResearch.jCHEKS.concept.communicator.AbstractObservable;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Thomas Lepage thomas.lepage@hotmail.ca
 */
public class TCPReceiveThread implements Runnable{

    private Socket clientSocket;
    private TCPReceiver receiver;
    
    public TCPReceiveThread(Socket clientSocket, TCPReceiver receiver) {
        this.clientSocket = clientSocket;
        this.receiver = receiver;
    }
    @Override
    public void run() {
        try {
            
            System.out.println("Receiving communication...");

                DataInputStream dataIn = new DataInputStream(clientSocket.getInputStream());
                DataOutputStream dataOut = new DataOutputStream(clientSocket.getOutputStream());

                //TODO Maybe rethink this.
                String ackSecure = this.receiver.notifyMessageReceived(clientSocket.getInetAddress().getHostAddress(), Communication.createCommunication(dataIn.readUTF()));
                System.out.println("Sending ACK...");
                 //TODO create better ack system.
                dataOut.writeUTF("I received your message");
                
                dataOut.writeUTF("This is the secure ACK");

                clientSocket.close();
            this.wait();
        } catch (InterruptedException ex) {
            Logger.getLogger(TCPReceiveThread.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(TCPReceiveThread.class.getName()).log(Level.SEVERE, null, ex);
        }
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }        
}
