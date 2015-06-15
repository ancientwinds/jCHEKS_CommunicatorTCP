package com.archosResearch.jCHEKS.communicator.tcp;

import static org.junit.Assert.assertNotNull;
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
    


}
