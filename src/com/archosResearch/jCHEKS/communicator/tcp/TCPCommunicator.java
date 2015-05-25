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
    
    public TCPCommunicator(int port, int clientPort){
        clients.add(new Client(clientPort));
        
        this.listenThread = new Thread(new ListeningThread(port, this));
        this.listenThread.start();
    }
    
    @Override
    public boolean sendCommunication(Communication communication) {
        
        try {   
            Client destinationClient = getClientForSystemId(communication.getSystemId());

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
        } catch (Exception ex) {
            System.out.println("Could not find client.");
            Logger.getLogger(TCPCommunicator.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;        
    }
    
    @Override
    public void receivingCommunication(String message)
    {
        notifyMessageReceived(message);
    }
    
    private Client getClientForSystemId(int systemId) throws Exception{
        for (Client client : clients) {
            if (client.getSystemId() == systemId) {
                return client;
            }
        }
        
        throw new Exception("Client not found for the system id: " + systemId);
    }

   

}
