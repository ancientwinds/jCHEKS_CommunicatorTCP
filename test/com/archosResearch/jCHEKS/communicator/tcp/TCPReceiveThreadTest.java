package com.archosResearch.jCHEKS.communicator.tcp;

import com.archosResearch.jCHEKS.communicator.mock.*;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Thomas Lepage thomas.lepage@hotmail.ca
 */
public class TCPReceiveThreadTest {
    
    @Test
    public void constructor_should_create_the_object() {
        TCPReceiveThread instance = null;
        instance = new TCPReceiveThread(new StubSocket(), new MockTCPReceiver());
        
        assertNotNull(instance);
    }   
    
}
