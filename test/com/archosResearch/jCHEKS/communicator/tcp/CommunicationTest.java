package com.archosResearch.jCHEKS.communicator.tcp;

import com.archosResearch.jCHEKS.communicator.Communication;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
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

    /**
     * Test of the single parameter constructor, of class Communication
     */
    @Test
    public void test_constructor_single() {
        Communication instance = Communication.createCommunication(communicationString);

        assertNotNull(instance);
    }

    /**
     * Test of the three parameters constructor, of class Communication
     */
    @Test
    public void test_constructor_multiple() {
        Communication instance = new Communication(cipher, cipherCheck, systemId);

        assertNotNull(instance);
    }

    /**
     * Test of getSystemId method, of class Communication.
     */
    @Test
    public void test_get_systemId1() {
        Communication instance = new Communication(cipher, cipherCheck, systemId);
        String expResult = systemId;
        String result = instance.getSystemId();
        assertEquals(expResult, result);
    }

    /**
     * Test of getChipher method, of class Communication.
     */
    @Test
    public void test_get_cipher1() {
        Communication instance = new Communication(cipher, cipherCheck, systemId);
        String expResult = cipher;
        String result = instance.getCipher();
        assertEquals(expResult, result);
    }

    /**
     * Test of getChipherCheck method, of class Communication.
     */
    @Test
    public void test_get_cipherCheck1() {
        Communication instance = new Communication(cipher, cipherCheck, systemId);
        String expResult = cipherCheck;
        String result = instance.getCipherCheck();
        assertEquals(expResult, result);
    }

    /**
     * Test of getSystemId method, of class Communication.
     */
    @Test
    public void test_get_systemId2() {
        Communication instance = Communication.createCommunication(communicationString);
        String expResult = systemId;
        String result = instance.getSystemId();
        assertEquals(expResult, result);
    }

    /**
     * Test of getChipher method, of class Communication.
     */
    @Test
    public void test_get_cipher2() {
        Communication instance = Communication.createCommunication(communicationString);
        String expResult = cipher;
        String result = instance.getCipher();
        assertEquals(expResult, result);
    }

    /**
     * Test of getChipherCheck method, of class Communication.
     */
    @Test
    public void test_get_cipherCheck2() {
        Communication instance = Communication.createCommunication(communicationString);
        String expResult = cipherCheck;
        String result = instance.getCipherCheck();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCommunicationString method, of class Communication.
     */
    @Test
    public void test_get_communicationString() {
        Communication instance = new Communication(cipher, cipherCheck, systemId);
        String expResult = communicationString;
        String result = instance.getCommunicationString();
        assertEquals(expResult, result);

    }

}
