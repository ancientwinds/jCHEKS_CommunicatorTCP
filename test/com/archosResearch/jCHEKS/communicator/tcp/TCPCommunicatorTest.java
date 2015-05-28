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
public class TCPCommunicatorTest {
    
    public TCPCommunicatorTest() {
    }

    /**
     * Test of sendCommunication method, of class TCPCommunicator.
     */
    @Test
    public void testSendCommunication() {
        System.out.println("sendCommunication");
        Communication communication = new Communication("Test de communication");
        TCPCommunicator sendingCommunicator = new TCPCommunicator(9000, 9001);
        TCPCommunicator receivingCommunicator = new TCPCommunicator(9001, 9000);

        boolean expResult = true;
        boolean result = sendingCommunicator.sendCommunication(communication);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of receivingCommunication method, of class TCPCommunicator.
     */
    /*@Test
    public void testReceivingCommunication() {
        System.out.println("receivingCommunication");
        String message = "";
        TCPCommunicator instance = null;
        instance.receivingCommunication(message);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/

}
