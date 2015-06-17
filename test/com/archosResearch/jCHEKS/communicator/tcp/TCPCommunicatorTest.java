package com.archosResearch.jCHEKS.communicator.tcp;

import com.archosResearch.jCHEKS.communicator.Communication;
import com.archosResearch.jCHEKS.communicator.exception.CommunicatorException;
import com.archosResearch.jCHEKS.communicator.exception.ReceiverObserverNotFoundException;
import com.archosResearch.jCHEKS.communicator.mock.*;
import com.archosResearch.jCHEKS.concept.communicator.AbstractCommunication;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author Thomas Lepage thomas.lepage@hotmail.ca
 */
public class TCPCommunicatorTest {

    private final String cipherTest = "cipherTest";
    private final String cipherCheckTest = "cipherCheckTest";
    private final String uniqueIdTest = "uniqueIdTest";
    
    @Test
    public void constructor_should_create_the_TCPCommunicator() {
        MockTCPSender sender = new MockTCPSender("1.1.1.1", 9000);
        MockTCPReceiver receiver = new MockTCPReceiver();
        
        TCPCommunicator communicator = null;
        communicator = new TCPCommunicator(sender, receiver, uniqueIdTest);
        assertNotNull(communicator);
    }
    
    @Test
    public void notifyMessageReceived_should_notify_communicator_observers() throws ReceiverObserverNotFoundException {
        MockTCPSender sender = new MockTCPSender("1.1.1.1", 9000);
        MockTCPReceiver receiver = new MockTCPReceiver();
        
        TCPCommunicator communicator = new TCPCommunicator(sender, receiver, uniqueIdTest);
        MockEngine engine = new MockEngine();
        communicator.addObserver(engine);
        
        AbstractCommunication communication = new Communication(cipherTest, cipherCheckTest, uniqueIdTest);
        
        receiver.notifyMessage(communication);
        
        assertTrue(communication == engine.lastCommunication);
    }
    
    @Test
    public void ackReceived_should_notify_communicator_observers(){
        MockTCPSender sender = new MockTCPSender("1.1.1.1", 9000);
        MockTCPReceiver receiver = new MockTCPReceiver();
        
        TCPCommunicator communicator = new TCPCommunicator(sender, receiver, uniqueIdTest);
        MockEngine engine = new MockEngine();
        communicator.addObserver(engine);
                
        sender.receiveAck(new Communication(cipherTest, cipherCheckTest, uniqueIdTest));
        
        assertTrue(engine.ackReceived);
    }
    
        @Test
    public void secureAckReceived_should_notify_communicator_observers(){
        MockTCPSender sender = new MockTCPSender("1.1.1.1", 9000);
        MockTCPReceiver receiver = new MockTCPReceiver();
        
        TCPCommunicator communicator = new TCPCommunicator(sender, receiver, uniqueIdTest);
        MockEngine engine = new MockEngine();
        communicator.addObserver(engine);
                
        sender.receiveSecureAck(new Communication(cipherTest, cipherCheckTest, uniqueIdTest));
        
        assertTrue(engine.secureAckReceived);
    }
    
    @Test
    public void sendCommunication_should_send_the_communication() throws CommunicatorException {
        MockTCPSender sender = new MockTCPSender("1.1.1.1", 9000);
        MockTCPReceiver receiver = new MockTCPReceiver();
        
        TCPCommunicator communicator = new TCPCommunicator(sender, receiver, uniqueIdTest);
        MockEngine engine = new MockEngine();
        communicator.addObserver(engine);
        
        AbstractCommunication communication = new Communication(cipherTest, cipherCheckTest, uniqueIdTest);

        communicator.sendCommunication(communication);
                
        assertTrue(communication == sender.lastCommunication);
    }

    @Test(expected = CommunicatorException.class)
    public void sendCommunication_should_throw_an_exception_when_he_catch_one() throws CommunicatorException {
        MockTCPSender sender = new MockTCPSender("1.1.1.1", 9000);
        MockTCPReceiver receiver = new MockTCPReceiver();
        
        TCPCommunicator communicator = new TCPCommunicator(sender, receiver, uniqueIdTest);
        MockEngine engine = new MockEngine();
        communicator.addObserver(engine);
        
        AbstractCommunication communication = new Communication(cipherTest, cipherCheckTest, uniqueIdTest);
        sender.setThrowException(true);
        
        communicator.sendCommunication(communication);                
    }

}
