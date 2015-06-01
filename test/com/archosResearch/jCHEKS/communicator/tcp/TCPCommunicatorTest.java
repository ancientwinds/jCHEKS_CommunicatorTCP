/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.archosResearch.jCHEKS.communicator.tcp;

import com.archosResearch.jCHEKS.Engine.Engine;
import com.archosResearch.jCHEKS.communicator.tcp.TCPCommunicator;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Thomas Lepage
 */
public class TCPCommunicatorTest {
    
    /**
     * Test of the constructor, of class TCPCommunicator.
     */
    @Test
    public void test_TCPCommunicator_constructor() {
        TCPCommunicator instance = new TCPCommunicator("127.0.0.1", 9000, new Engine());
        
        assertNotNull(instance);
    }
    
    @Test
    public void test_TCPCommunicator_second_instance() {
        TCPCommunicator instance = new TCPCommunicator("127.0.0.1", 9002, new Engine());
        
        assertNotNull(instance);
    }

}
