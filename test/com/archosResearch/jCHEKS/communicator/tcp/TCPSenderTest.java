package com.archosResearch.jCHEKS.communicator.tcp;

import static org.junit.Assert.assertNotNull;
import org.junit.Test;

/**
 *
 * @author Thomas Lepage
 */
public class TCPSenderTest {

    /**
     * Test of the constructor, of class TCPSender.
     */
    @Test
    public void test_TCPSender() {
        TCPSender sender = new TCPSender("127.0.0.1", 9000);

        assertNotNull(sender);
    }

}
