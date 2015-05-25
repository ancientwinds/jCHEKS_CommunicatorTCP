/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.archosResearch.jCHEKS.communicator.tcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Thomas Lepage thomas.lepage@hotmail.ca
 */
public class TCPCommunicator extends AbstractCommunicator{

    private ArrayList<Client> clients = new ArrayList<>();
    
    public TCPCommunicator(int port){
        clients.add(new Client());
        
        this.listenThread = new Thread(new ListeningThread(port, this));
        this.listenThread.start();
    }
    
    @Override
    public boolean sendCommunication(Communication communication) {
        Client destinationClient = getClientForSystemId(communication.getSystemId());
        
        try {
            System.out.println("Attempting to connect to " + destinationClient.getConnectionInfo());
            Socket clientSocket = new Socket(destinationClient.getIpAddress(), destinationClient.getPort());
            
            System.out.println("Connection established to " + destinationClient.getConnectionInfo());
            
            OutputStream outToDestination = clientSocket.getOutputStream();
            DataOutputStream dataOutToDestination = new DataOutputStream(outToDestination);
            
            System.out.println("Sending communication to destination...");
            dataOutToDestination.writeUTF(communication.getChipher());
            
            System.out.println("Waiting for ACK");
            InputStream inFromDestination = clientSocket.getInputStream();
            DataInputStream dataInFromDestination = new DataInputStream(inFromDestination);
            
            notifyMessageACK();
            System.out.println("From dest: " + dataInFromDestination.readUTF());
            
            clientSocket.close();
        } catch (IOException ex) {
            System.out.println("Could not create socket to the destination client.");
            Logger.getLogger(TCPCommunicator.class.getName()).log(Level.SEVERE, null, ex);
        }  
        
        return false;
        
    }
    
    @Override
    public void receivingCommunication()
    {
        
    }
    
    private Client getClientForSystemId(int systemId){
        for (Client client : clients) {
            if (client.getSystemId() == systemId) {
                return client;
            }
        }
        
        return null;
    }

   

}
