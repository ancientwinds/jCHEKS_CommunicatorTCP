package com.archosResearch.jCHEKS.communicator.tcp;

import com.archosResearch.jCHEKS.communicator.mock.MockTCPReceiver;
import com.archosResearch.jCHEKS.communicator.Communication;
import com.archosResearch.jCHEKS.communicator.exception.CommunicatorException;
import com.archosResearch.jCHEKS.communicator.mock.MockEngine;
import com.archosResearch.jCHEKS.communicator.mock.MockTCPSender;
import com.archosResearch.jCHEKS.concept.communicator.AbstractCommunication;
import com.archosResearch.jCHEKS.concept.exception.AbstractCommunicatorException;
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
        String ipAddress = "1.1.1.1";
        int port = 9000;

        MockTCPSender sender = new MockTCPSender(ipAddress, port);
        MockTCPReceiver receiver = new MockTCPReceiver();
        
        TCPCommunicator communicator = new TCPCommunicator(sender, receiver);
        assertNotNull(communicator);
    }
    
    @Test
    public void test_notifyMessageReceived() {
        String ipAddress = "1.1.1.1";
        int port = 9000;

        MockTCPSender sender = new MockTCPSender(ipAddress, port);
        MockTCPReceiver receiver = new MockTCPReceiver();
        
        TCPCommunicator communicator = new TCPCommunicator(sender, receiver);
        MockEngine engine = new MockEngine();
        communicator.addObserver(engine);
        
        AbstractCommunication communication = new Communication("temp", "temp", "temp");
        
        /*************************/
        receiver.notifyMessage(ipAddress, communication);
        
        /*************************/
        assertTrue(communication == engine.lastCommunication);
        
    }
    
    @Test
    public void test_ackReceived(){
        String ipAddress = "1.1.1.1";
        int port = 9000;

        MockTCPSender sender = new MockTCPSender(ipAddress, port);
        MockTCPReceiver receiver = new MockTCPReceiver();
        
        TCPCommunicator communicator = new TCPCommunicator(sender, receiver);
        MockEngine engine = new MockEngine();
        communicator.addObserver(engine);
        
        AbstractCommunication communication = new Communication("temp", "temp", "temp");
        
        /*************************/
        sender.receiveAck();
        
        /*************************/
        assertTrue(engine.ackReceived);
    }
    /**
     * Test of the sendCommunication method, of class TCPCommunicator.
     * @throws com.archosResearch.jCHEKS.communicator.exception.CommunicatorException
     */
    @Test
    public void test_sendCommunication() throws AbstractCommunicatorException {
        String ipAddress = "1.1.1.1";
        int port = 9000;

        MockTCPSender sender = new MockTCPSender(ipAddress, port);
        MockTCPReceiver receiver = new MockTCPReceiver();
        
        TCPCommunicator communicator = new TCPCommunicator(sender, receiver);
        MockEngine engine = new MockEngine();
        communicator.addObserver(engine);
        
        AbstractCommunication communication = new Communication("temp", "temp", "temp");

        communicator.sendCommunication(communication);
                
        assertTrue(communication == sender.lastCommunication);

    }

    @Test(expected = CommunicatorException.class)
    public void test_sendCommunication_with_exception() throws AbstractCommunicatorException {
        String ipAddress = "1.1.1.1";
        int port = 9000;

        MockTCPSender sender = new MockTCPSender(ipAddress, port);
        MockTCPReceiver receiver = new MockTCPReceiver();
        
        TCPCommunicator communicator = new TCPCommunicator(sender, receiver);
        MockEngine engine = new MockEngine();
        communicator.addObserver(engine);
        
        AbstractCommunication communication = new Communication("temp", "temp", "temp");
        sender.setThrowException(true);
        
        communicator.sendCommunication(communication);                
    }

}
