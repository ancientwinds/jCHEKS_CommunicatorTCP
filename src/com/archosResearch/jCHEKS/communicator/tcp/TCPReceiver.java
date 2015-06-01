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
 * @author Thomas Lepage
 */
public class TCPReceiver extends ITCPReceiver implements Runnable{
    private static TCPReceiver instance = null;
    
    private final int port = 9001;
    private ServerSocket listeningSocket;
    private boolean running = true;   
    
    public static TCPReceiver getInstance(){
        if(instance == null){
            instance = new TCPReceiver();
            new Thread(instance).start();
        }
        return instance;
    }
    
    public void stopReceiver(){
        this.running = false;
    }

    @Override
    public void run() {
       try {
            listeningSocket = new ServerSocket(this.port);
            
            while(running) {
                Socket client = listeningSocket.accept();
                System.out.println("Receiving communication...");                
                
                DataInputStream dataIn = new DataInputStream(client.getInputStream());
                DataOutputStream dataOut = new DataOutputStream(client.getOutputStream());

                notifyMessageReceived(dataIn.readUTF());
                System.out.println("Sending ACK...");
                
                dataOut.writeUTF("I received your message");
            }                
            
            listeningSocket.close();
        } catch (IOException ex) {
            Logger.getLogger(TCPCommunicator.class.getName()).log(Level.SEVERE, null, ex); 
        }
    }
}
