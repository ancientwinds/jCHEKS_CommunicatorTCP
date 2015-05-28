/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.archosResearch.jCHEKS.communicator.tcp;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Thomas Lepage thomas.lepage@hotmail.ca
 */
public class CommunicationTest {
    
    public CommunicationTest() {
    }

    private static final String chipher = "chipher";
    private static final String chipherCheck = "chipher check";
    private static final String systemId = "system id";
    private static final String communicationString = chipher + "~" + chipherCheck + "~" + systemId;
    /**
     * Test of getSystemId method, of class Communication.
     */
    @Test
    public void testGetSystemId() {
        System.out.println("getSystemId");
        Communication instance = new Communication(chipher, chipherCheck, systemId);
        String expResult = systemId;
        String result = instance.getSystemId();
        assertEquals(expResult, result);
    }

    /**
     * Test of getChipher method, of class Communication.
     */
    @Test
    public void testGetChipher() {
        System.out.println("getChipher");
        Communication instance = new Communication(chipher, chipherCheck, systemId);
        String expResult = chipher;
        String result = instance.getChipher();
        assertEquals(expResult, result);
    }

    /**
     * Test of getChipherCheck method, of class Communication.
     */
    @Test
    public void testGetChipherCheck() {
        System.out.println("getChipherCheck");
        Communication instance = new Communication(chipher, chipherCheck, systemId);
        String expResult = chipherCheck;
        String result = instance.getChipherCheck();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCommunicationString method, of class Communication.
     */
    @Test
    public void testGetCommunicationString() {
        System.out.println("getCommunicationString");
        Communication instance = new Communication(chipher, chipherCheck, systemId);
        String expResult = communicationString;
        String result = instance.getCommunicationString();
        assertEquals(expResult, result);

    }
    
}
