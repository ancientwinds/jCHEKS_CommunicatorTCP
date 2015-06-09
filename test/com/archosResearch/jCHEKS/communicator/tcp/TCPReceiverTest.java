package com.archosResearch.jCHEKS.communicator.tcp;

import static org.junit.Assert.assertNotNull;
import org.junit.Test;

/**
 *
 * @author Thomas Lepage thomas.lepage@hotmail.ca
 */
public class TCPReceiverTest {

    @Test
    public void getInstance_create_the_TCPReceiver() {
        TCPReceiver instance = TCPReceiver.getInstance(9000);
        assertNotNull(instance);
    }

    @Test
    public void getInstance_return_the_instance_if_it_exist() {
        TCPReceiver.getInstance(9000);
        TCPReceiver instance = TCPReceiver.getInstance(9000);
        assertNotNull(instance);
    }

}
