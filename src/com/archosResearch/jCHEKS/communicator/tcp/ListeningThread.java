/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.archosResearch.jCHEKS.communicator.tcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Thomas Lepage thomas.lepage@hotmail.ca
 */
public class ListeningThread implements Runnable{
    
    private int port = 9000;
    private ServerSocket listeningSocket;
    private boolean running = true;
    
    public ListeningThread(int port){
        this.port = port;
    }
    
     @Override
    public void run() {
        try {
            listeningSocket = new ServerSocket(this.port);
            
            while(running) {
                Socket client = listeningSocket.accept();
                DataInputStream dataIn = new DataInputStream(client.getInputStream());
                DataOutputStream dataOut = new DataOutputStream(client.getOutputStream());
                
                System.out.println("Received: " + dataIn.readUTF());
                
                //TODO better way to ack the sender.
                dataOut.writeUTF("I received your message");
            }                
            
            listeningSocket.close();
        } catch (IOException ex) {
            Logger.getLogger(TCPCommunicator.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void stop(){
        running = false;
    }
}
