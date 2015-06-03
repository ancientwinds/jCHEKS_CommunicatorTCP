package com.archosResearch.jCHEKS.communicator.tcp;

import static org.junit.Assert.assertNotNull;
import org.junit.Test;

/**
 *
 * @author Thomas Lepage
 */
public class TCPReceiverTest {

    /**
     * Test of getInstance method, of class TCPReceiver.
     */
    @Test
    public void test_getInstance_for_the_first_time() {
        TCPReceiver instance = TCPReceiver.getInstance();

        assertNotNull(instance);
    }

    /**
     * Test of getInstance method, of class TCPReceiver.
     *
     */
    @Test
    public void test_getInstance_for_the_second_time() {
        TCPReceiver instance = TCPReceiver.getInstance();

        assertNotNull(instance);
    }

}
