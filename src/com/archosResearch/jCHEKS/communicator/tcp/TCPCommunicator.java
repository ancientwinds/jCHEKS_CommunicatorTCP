/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.archosResearch.jCHEKS.communicator.tcp;

import com.archosResearch.jCHEKS.communicator.AbstractCommunicator;
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
    
    public TCPCommunicator(int aPort, int aClientPort){
        clients.add(new Client(aClientPort));
        
        this.listenThread = new Thread(new ListeningThread(aPort, this));
        this.listenThread.start();
    }
    
    @Override
    public boolean sendCommunication(Communication aCommunication) {
        Client destinationClient = getClientForSystemId(aCommunication.getSystemId());
        
        try {
            System.out.println("Attempting to connect to " + destinationClient.getConnectionInfo());
            Socket clientSocket = new Socket(destinationClient.getIpAddress(), destinationClient.getPort());
            
            System.out.println("Connection established to " + destinationClient.getConnectionInfo());
            
            OutputStream outToDestination = clientSocket.getOutputStream();
            DataOutputStream dataOutToDestination = new DataOutputStream(outToDestination);
            
            System.out.println("Sending communication to destination...");
            dataOutToDestination.writeUTF(aCommunication.getChipher());
            
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
    
    @Override
    public void receivingCommunication(String aMessage)
    {
        System.out.print("Received message: " + aMessage);
        notifyMessageReceived(aMessage);
    }
    
    private Client getClientForSystemId(String aSystemId){
        for (Client client : clients) {
            if (client.getSystemId().equals(aSystemId)) {
                return client;
            }
        }
        
        //TODO Remove null and add an exception.
        return null;
    }
    
    public void addClient(Client aClient){
        if(clients != null){
            clients.add(aClient);
        }
    }

   

}
