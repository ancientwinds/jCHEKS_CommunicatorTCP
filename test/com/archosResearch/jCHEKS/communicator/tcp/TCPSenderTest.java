package com.archosResearch.jCHEKS.communicator.tcp;

import com.archosResearch.jCHEKS.communicator.Communication;
import com.archosResearch.jCHEKS.communicator.mock.MockCommunicator;
import com.archosResearch.jCHEKS.concept.communicator.AbstractCommunication;
import com.archosResearch.jCHEKS.concept.exception.CommunicatorException;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 *
 * @author Thomas Lepage thomas.lepage@hotmail.ca
 */
public class TCPSenderTest {

    @Test
    public void constructor_should_create_the_object() {
        TCPSender sender;
        sender = new TCPSender("127.0.0.1", 9000);
        assertNotNull(sender);
    }
    
    @Test
    public void notifyMessageAck_should_notify_observer() {
        MockCommunicator communicator = new MockCommunicator();
        TCPSender sender = new TCPSender("1.1.1.1", 9000);
        sender.addObserver(communicator);
        AbstractCommunication communication = new Communication("cipher", "cipherCheck", "systemId");
        
        sender.notifyMessageACK(communication);
        
        assertTrue(communicator.messageAckCommunication == communication);
    }
    
    @Test
    public void notifySecureAck_should_notify_observer() {
        MockCommunicator communicator = new MockCommunicator();
        TCPSender sender = new TCPSender("1.1.1.1", 9000);
        sender.addObserver(communicator);
        AbstractCommunication communication = new Communication("cipher", "cipherCheck", "systemId");
        
        sender.notifySecureACK(communication, "test");
        
        assertTrue(communicator.secureAckCommunication == communication);
        assertEquals(communicator.secureAckString, "test");
    }
    
    @Test
    public void notifyFailAck_should_notify_observer() {
        MockCommunicator communicator = new MockCommunicator();
        TCPSender sender = new TCPSender("1.1.1.1", 9000);
        sender.addObserver(communicator);
        AbstractCommunication communication = new Communication("cipher", "cipherCheck", "systemId");
        
        sender.notifyFailAck(communication);
        
        assertTrue(communicator.failAckCommunication == communication);
    }
    
    @Test
    public void notifyFailSecureAck_should_notify_observer() {
        MockCommunicator communicator = new MockCommunicator();
        TCPSender sender = new TCPSender("1.1.1.1", 9000);
        sender.addObserver(communicator);
        AbstractCommunication communication = new Communication("cipher", "cipherCheck", "systemId");
        
        sender.notifyFailSecureACK(communication);
        
        assertTrue(communicator.failSecureAckCommunication == communication);
    }
    
    @Test
    public void notifyTimeOut_should_notify_observer() {
        MockCommunicator communicator = new MockCommunicator();
        TCPSender sender = new TCPSender("1.1.1.1", 9000);
        sender.addObserver(communicator);
        AbstractCommunication communication = new Communication("cipher", "cipherCheck", "systemId");
        
        sender.notifyTimeOutReach(communication);
        
        assertTrue(communicator.timeOutCommunication == communication);
    }
    
    @Test
    public void notifyException_should_notify_observer() {
        MockCommunicator communicator = new MockCommunicator();
        TCPSender sender = new TCPSender("1.1.1.1", 9000);
        sender.addObserver(communicator);
        AbstractCommunication communication = new Communication("cipher", "cipherCheck", "systemId");
        CommunicatorException exception = new CommunicatorException("Exception");
        
        sender.notifyException(exception, communication);
        
        assertTrue(communicator.exceptionCommunication == communication);
        assertTrue(communicator.notifyException == exception);

    }

}
