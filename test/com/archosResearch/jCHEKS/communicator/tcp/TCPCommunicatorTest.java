package com.archosResearch.jCHEKS.communicator.tcp;

import com.archosResearch.jCHEKS.communicator.Communication;
import com.archosResearch.jCheks.concept.communicator.CommunicatorException;
import java.util.logging.Level;
import java.util.logging.Logger;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

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
        TCPCommunicator instance = new TCPCommunicator(new TCPSender("0.0.0.0", 9000), TCPReceiver.getInstance(9001));

        assertNotNull(instance);
    }

    /**
     * Test of the sendCommunication method, of class TCPCommunicator.
     */
    /*@Test
    public void test_sendCommunication() {
        MockTCPSender sender = new MockTCPSender();
        MockTCPReceiver receiver = new MockTCPReceiver();
        TCPCommunicator instance = new TCPCommunicator(sender, receiver);
        Communication communication = new Communication("test", "test", "test");

        try {
            instance.sendCommunication(communication);
        } catch (CommunicatorException ex) {
            Logger.getLogger(TCPCommunicatorTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        assertTrue(sender.isCommunicationSent());
    }

    @Test(expected = CommunicatorException.class)
    public void test_sendCommunication_with_exception() throws CommunicatorException {
        MockTCPSender sender = new MockTCPSender();
        sender.throwException = true;
        MockTCPReceiver receiver = new MockTCPReceiver();
        TCPCommunicator instance = new TCPCommunicator(sender, receiver);
        Communication communication = new Communication("test", "test", "test");

        instance.sendCommunication(communication);
    }*/

}
