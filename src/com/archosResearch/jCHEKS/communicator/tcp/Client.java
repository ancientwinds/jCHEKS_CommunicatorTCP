/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.archosResearch.jCHEKS.communicator.tcp;

/**
 *
 * @author Thomas Lepage thomas.lepage@hotmail.ca
 */
public class Client {
    
    private String ipAddress;
    private int port;
    private int systemId;
    
    public Client(int port){
        this.ipAddress = "127.0.0.1";
        this.port = port;
        this.systemId = 1;
    }
    
    public String getIpAddress(){
        return this.ipAddress;
    }
    
    public int getPort(){
        return this.port;
    } 
    
    public int getSystemId(){
        return this.systemId;
    }
    
    public String getConnectionInfo(){
        StringBuilder sb = new StringBuilder();
        sb.append("ip address: ");
        sb.append(this.ipAddress);
        sb.append(" on port: ");
        sb.append(this.port);
        
        return sb.toString();
    }
}
