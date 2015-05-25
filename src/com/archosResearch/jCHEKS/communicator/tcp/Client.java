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
    
    public Client(){
        this.ipAddress = "127.0.0.1";
        this.port = 9000;
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
}
