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
    private int systemId;
    private String chipher;
    private String chiperCheck;
    
    public Communication(String chiper)
    {
        this.chipher = chiper;
        this.systemId = 1;
        this.chiperCheck = "fdsdDS";
    }
    
    public int getSystemId() {
        
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
