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
    
    public Client(int aPort){
        this(aPort, "127.0.0.1", 1);
    }
    
    public Client(int aPort, String aIp, int aSystemId){
        this.ipAddress = aIp;
        this.port = aPort;
        this.systemId = aSystemId;
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
