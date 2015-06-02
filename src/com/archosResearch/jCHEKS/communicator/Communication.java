/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.archosResearch.jCHEKS.communicator;

import com.archosResearch.jCheks.concept.communicator.AbstractCommunication;

/**
 *
 * @author Thomas Lepage
 */
public class Communication extends AbstractCommunication{
    private final String systemId;
    private final String chipher;
    private final String chiperCheck;
    
    public Communication(String communication)
    {   
        String[] communicationElements = communication.split("~");
        this.chipher = communicationElements[0];
        this.chiperCheck = communicationElements[1];
        this.systemId = communicationElements[2];
    }
    
    public Communication(String aChipher, String aChipherCheck, String aSystemId){
        this.chipher = aChipher;
        this.chiperCheck = aChipherCheck;
        this.systemId = aSystemId;
    }
    
    public String getSystemId() {
        
        return this.systemId;
    }
    
    public String getChipher() {
        return this.chipher;
    }
    
    public String getChipherCheck()
    {
        return this.chiperCheck;
    }
    
    public String getCommunicationString(){
        StringBuilder sb = new StringBuilder();
        sb.append(this.chipher);
        sb.append("~");
        sb.append(this.chiperCheck);
        sb.append("~");
        sb.append(this.systemId);
        
        return sb.toString();
    }
}
