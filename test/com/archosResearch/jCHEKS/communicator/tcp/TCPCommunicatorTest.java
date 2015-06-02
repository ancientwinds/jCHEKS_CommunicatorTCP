
package com.archosResearch.jCHEKS.communicator.tcp;

import com.archosResearch.jCheks.concept.communicator.Communication;
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
        TCPCommunicator instance = new TCPCommunicator(new MockTCPSender(), new MockTCPReceiver());
        
        assertNotNull(instance);
    }
    
    /**
     * Test of the sendCommunication method, of class TCPCommunicator.
     */
    @Test
    public void test_sendCommunication() {
       MockTCPSender sender = new MockTCPSender();
       MockTCPReceiver receiver = new MockTCPReceiver();
       TCPCommunicator instance = new TCPCommunicator(sender, receiver);
       Communication communication = new Communication("test", "test", "test");
       
       instance.sendCommunication(communication);

       assertTrue(sender.isCommunicationSent());
    }
    
    
}
