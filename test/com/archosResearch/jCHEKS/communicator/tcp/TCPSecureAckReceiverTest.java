package com.archosResearch.jCHEKS.communicator.tcp;

import com.archosResearch.jCHEKS.communicator.mock.StubSocket;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Thomas Lepage thomas.lepage@hotmail.ca
 */
public class TCPSecureAckReceiverTest {
    

    @Test
    public void costructor_should_create_the_object() {
        TCPSecureAckReceiver instance = null;
        instance = new TCPSecureAckReceiver(new StubSocket());
        assertNotNull(instance);
    }   
}
