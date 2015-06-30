package com.archosResearch.jCHEKS.communicator.tcp;

import com.archosResearch.jCHEKS.communicator.Communication;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author Thomas Lepage thomas.lepage@hotmail.ca
 */
public class CommunicationTest {

    private static final String cipher = "cipher";
    private static final String cipherCheck = "cipher check";
    private static final String systemId = "system id";
    private static final String communicationString = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?><communication><cipher>"+ cipher + "</cipher><cipherCheck>"+ cipherCheck + "</cipherCheck><systemId>"+ systemId + "</systemId></communication>";

    @Test
    public void factory_should_create_and_return_a_communication() throws Exception {
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
        System.out.println(instance.getCommunicationString());
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
    public void getSystemId_should_return_systemId_using_factory() throws Exception {
        Communication instance = Communication.createCommunication(communicationString);
        String expResult = systemId;
        String result = instance.getSystemId();
        assertEquals(expResult, result);
    }

    @Test
    public void getCipher_should_return_cipher_using_factory() throws Exception {
        Communication instance = Communication.createCommunication(communicationString);
        String expResult = cipher;
        String result = instance.getCipher();
        assertEquals(expResult, result);
    }

    @Test
    public void getCipherCheck_should_return_cipherCheck_using_factory() throws Exception {
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
