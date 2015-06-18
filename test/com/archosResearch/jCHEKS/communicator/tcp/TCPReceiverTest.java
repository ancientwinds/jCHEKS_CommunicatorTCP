package com.archosResearch.jCHEKS.communicator.tcp;

import static org.junit.Assert.assertNotNull;
import org.junit.Test;

/**
 *
 * @author Thomas Lepage thomas.lepage@hotmail.ca
 */
public class TCPReceiverTest {

    private final int port = 9000;

    @Test
    public void getInstance_with_port_create_the_TCPReceiver() {
        TCPReceiver instance = null;
        instance = TCPReceiver.getInstance(port);
        assertNotNull(instance);
    }

    @Test
    public void getInstance_with_port_return_the_instance_if_it_exist() {
        TCPReceiver.getInstance(port);
        TCPReceiver instance = TCPReceiver.getInstance(port);
        assertNotNull(instance);
    }
    
    @Test
    public void getInstance_without_port_return_the_instance_if_it_exist() {
        TCPReceiver instance = null;
        instance = TCPReceiver.getInstance();
        assertNotNull(instance);
    }

}
