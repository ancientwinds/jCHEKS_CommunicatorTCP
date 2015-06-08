package com.archosResearch.jCHEKS.communicator.tcp;

import com.archosResearch.jCHEKS.communicator.Communication;
import com.archosResearch.jCHEKS.communicator.exception.CommunicatorException;
import com.archosResearch.jCHEKS.communicator.mock.*;
import com.archosResearch.jCHEKS.concept.communicator.AbstractCommunication;
import com.archosResearch.jCHEKS.concept.exception.AbstractCommunicatorException;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author Thomas Lepage
 */
public class TCPCommunicatorTest {

    @Test
    public void constructor_should_create_the_TCPCommunicator() {
        String ipAddress = "1.1.1.1";
        int port = 9000;

        MockTCPSender sender = new MockTCPSender(ipAddress, port);
        MockTCPReceiver receiver = new MockTCPReceiver();
        
        TCPCommunicator communicator = null;
        communicator = new TCPCommunicator(sender, receiver);
        assertNotNull(communicator);
    }
    
    @Test
    public void notifyMessageReceived_should_notify_communicator_observers() {
        String ipAddress = "1.1.1.1";
        int port = 9000;

        MockTCPSender sender = new MockTCPSender(ipAddress, port);
        MockTCPReceiver receiver = new MockTCPReceiver();
        
        TCPCommunicator communicator = new TCPCommunicator(sender, receiver);
        MockEngine engine = new MockEngine();
        communicator.addObserver(engine);
        
        AbstractCommunication communication = new Communication("temp", "temp", "temp");
        
        receiver.notifyMessage(ipAddress, communication);
        
        assertTrue(communication == engine.lastCommunication);
    }
    
    @Test
    public void ackReceived_should_notify_communicator_observers(){
        String ipAddress = "1.1.1.1";
        int port = 9000;

        MockTCPSender sender = new MockTCPSender(ipAddress, port);
        MockTCPReceiver receiver = new MockTCPReceiver();
        
        TCPCommunicator communicator = new TCPCommunicator(sender, receiver);
        MockEngine engine = new MockEngine();
        communicator.addObserver(engine);
        
        AbstractCommunication communication = new Communication("temp", "temp", "temp");
        
        sender.receiveAck();
        
        assertTrue(engine.ackReceived);
    }
    
    @Test
    public void sendCommunication_should_send_the_communication() throws AbstractCommunicatorException {
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
    public void sendCommunication_should_throw_an_exception_when_he_catch_one() throws AbstractCommunicatorException {
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
