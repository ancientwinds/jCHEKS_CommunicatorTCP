/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.archosResearch.jCHEKS.communicator.tcp;

import com.archosResearch.jCHEKS.communicator.Communication;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Thomas Lepage
 */
public class TCPSender extends ITCPSender{
    
    private final String ipAddress;
    private final int port;
    
    public TCPSender(String ipAddress, int port) {
        this.ipAddress = ipAddress;
        this.port = port;
    }
    
    @Override
    public boolean sendCommunication(Communication communication) {
        try {
            //System.out.println("Attempting to connect to " + destinationClient.getConnectionInfo());
            Socket clientSocket = new Socket(this.ipAddress, this.port);
            
            //System.out.println("Connection established to " + destinationClient.getConnectionInfo());
            
            OutputStream outToDestination = clientSocket.getOutputStream();
            DataOutputStream dataOutToDestination = new DataOutputStream(outToDestination);
            
            System.out.println("Sending communication to destination...");
            dataOutToDestination.writeUTF(communication.getCommunicationString());
            
            System.out.println("Waiting for ACK");
            InputStream inFromDestination = clientSocket.getInputStream();
            DataInputStream dataInFromDestination = new DataInputStream(inFromDestination);
            
            notifyMessageACK();
            
            System.out.println("From dest: " + dataInFromDestination.readUTF());
            
            clientSocket.close();
        } catch (IOException ex) {
            System.out.println("Could not create socket to the destination client.");
            Logger.getLogger(TCPCommunicator.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }  
        
        return true;  
    }
}
