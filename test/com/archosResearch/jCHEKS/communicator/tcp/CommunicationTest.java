package com.archosResearch.jCHEKS.communicator.tcp;

import com.archosResearch.jCHEKS.communicator.Communication;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author Thomas Lepage
 */
public class CommunicationTest {

    private static final String cipher = "cipher";
    private static final String cipherCheck = "cipher check";
    private static final String systemId = "system id";
    private static final String communicationString = cipher + "~" + cipherCheck + "~" + systemId;

    @Test
    public void factory_should_create_and_return_a_communication() {
        Communication instance = null;
        instance = Communication.createCommunication(communicationString);
        assertNotNull(instance);
    }


    @Test
    public void constructor_with_three_parameters_should_create_a_communication() {
        Communication instance = null;
        instance = new Communication(cipher, cipherCheck, systemId);
        assertNotNull(instance);
    }

    @Test
    public void getSystemId_should_return_systemId_using_constructor() {
        Communication instance = new Communication(cipher, cipherCheck, systemId);
        String expResult = systemId;
        String result = instance.getSystemId();
        assertEquals(expResult, result);
    }
    
    @Test
    public void getCipher_should_return_cipher_using_constructor() {
        Communication instance = new Communication(cipher, cipherCheck, systemId);
        String expResult = cipher;
        String result = instance.getCipher();
        assertEquals(expResult, result);
    }

    @Test
    public void getCipherCheck_should_return_cipherCheck_using_constructor() {
        Communication instance = new Communication(cipher, cipherCheck, systemId);
        String expResult = cipherCheck;
        String result = instance.getCipherCheck();
        assertEquals(expResult, result);
    }

    @Test
    public void getSystemId_should_return_systemId_using_factory() {
        Communication instance = Communication.createCommunication(communicationString);
        String expResult = systemId;
        String result = instance.getSystemId();
        assertEquals(expResult, result);
    }

    @Test
    public void getCipher_should_return_cipher_using_factory() {
        Communication instance = Communication.createCommunication(communicationString);
        String expResult = cipher;
        String result = instance.getCipher();
        assertEquals(expResult, result);
    }

    @Test
    public void getCipherCheck_should_return_cipherCheck_using_factory() {
        Communication instance = Communication.createCommunication(communicationString);
        String expResult = cipherCheck;
        String result = instance.getCipherCheck();
        assertEquals(expResult, result);
    }

    @Test
    public void getCommunicationString_should_return_the_communication_in_string_format() {
        Communication instance = new Communication(cipher, cipherCheck, systemId);
        String expResult = communicationString;
        String result = instance.getCommunicationString();
        assertEquals(expResult, result);
    }

}
