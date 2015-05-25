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
        
        (new Thread(new ListeningThread(port))).start();
        //(new Thread(new TCPCommunicator())).start();
    }
    
    @Override
    public boolean sendCommunication(Communication communication) {
        Client destinationClient = getClientForSystemId(communication.getSystemId());
        
        try {
            Socket clientSocket = new Socket(destinationClient.getIpAddress(), destinationClient.getPort());
            
            System.out.println("Socket connected to destination: " + destinationClient.getIpAddress() + " on port: " + destinationClient.getPort());
            OutputStream outToDestination = clientSocket.getOutputStream();
            DataOutputStream dataOutToDestination = new DataOutputStream(outToDestination);
            dataOutToDestination.writeUTF(communication.getChipher());
            
            InputStream inFromDestination = clientSocket.getInputStream();
            DataInputStream dataInFromDestination = new DataInputStream(inFromDestination);
            System.out.println("From dest: " + dataInFromDestination.readUTF());
            
            clientSocket.close();
        } catch (IOException ex) {
            System.out.println("Could not create socket to the destination client.");
            Logger.getLogger(TCPCommunicator.class.getName()).log(Level.SEVERE, null, ex);
        }  
        
        return false;
        
    }
    
    public void receivingCommunication()
    {
        
        
        setChanged();
        notifyObservers();
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
