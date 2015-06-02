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
public class TCPSenderTest {

    /**
     * Test of the constructor, of class TCPSender.
     */
    @Test
    public void test_TCPSender() {
        TCPSender sender = new TCPSender("127.0.0.1", 9000);
        
        assertNotNull(sender);
    }
    
}
