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
public class Communication {
    private String systemId;
    private String chipher;
    private String chiperCheck;
    
    public Communication(String aChipher)
    {   
        this(aChipher, "Temp", "tempId");
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
}
