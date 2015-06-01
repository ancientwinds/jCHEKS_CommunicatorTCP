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
public class TCPReceiverTest {
    
    /**
     * Test of getInstance method, of class TCPReceiver.
     */
    @Test
    public void test_getInstance_for_the_first_time() {
        TCPReceiver instance = TCPReceiver.getInstance();
        
        assertNotNull(instance);
    }
    
    /**
     * Test of getInstance method, of class TCPReceiver.
     * 
     */
    @Test
    public void test_getInstance_for_the_second_time() {
        TCPReceiver instance = TCPReceiver.getInstance();
        
        assertNotNull(instance);
    }
    
}
