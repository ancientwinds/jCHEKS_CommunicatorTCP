
package com.archosResearch.jCHEKS.communicator.tcp;

import com.archosResearch.jCHEKS.communicator.Communication;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Thomas Lepage
 */
public class CommunicationTest {
    
    private static final String chipher = "chipher";
    private static final String chipherCheck = "chipher check";
    private static final String systemId = "system id";
    private static final String communicationString = chipher + "~" + chipherCheck + "~" + systemId;
    
    /**
     * Test of the single parameter constructor, of class Communication
     */
    @Test
    public void test_constructor_single() {
        Communication instance = new Communication(communicationString);
        
        assertNotNull(instance);
    }
    
    /**
     *  Test of the three parameters constructor, of class Communication
     */
    @Test
    public void test_constructor_multiple() {
        Communication instance = new Communication(chipher, chipherCheck, systemId);
        
        assertNotNull(instance);
    }
    
    /**
     * Test of getSystemId method, of class Communication.
     */
    @Test
    public void test_get_systemId1() {
        Communication instance = new Communication(chipher, chipherCheck, systemId);
        String expResult = systemId;
        String result = instance.getSystemId();
        assertEquals(expResult, result);
    }

    /**
     * Test of getChipher method, of class Communication.
     */
    @Test
    public void test_get_chipher1() {
        Communication instance = new Communication(chipher, chipherCheck, systemId);
        String expResult = chipher;
        String result = instance.getChipher();
        assertEquals(expResult, result);
    }

    /**
     * Test of getChipherCheck method, of class Communication.
     */
    @Test
    public void test_get_chipherCheck1() {
        Communication instance = new Communication(chipher, chipherCheck, systemId);
        String expResult = chipherCheck;
        String result = instance.getChipherCheck();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of getSystemId method, of class Communication.
     */
    @Test
    public void test_get_systemId2() {
        Communication instance = new Communication(communicationString);
        String expResult = systemId;
        String result = instance.getSystemId();
        assertEquals(expResult, result);
    }

    /**
     * Test of getChipher method, of class Communication.
     */
    @Test
    public void test_get_chipher2() {
        Communication instance = new Communication(communicationString);
        String expResult = chipher;
        String result = instance.getChipher();
        assertEquals(expResult, result);
    }

    /**
     * Test of getChipherCheck method, of class Communication.
     */
    @Test
    public void test_get_chipherCheck2() {
        Communication instance = new Communication(communicationString);
        String expResult = chipherCheck;
        String result = instance.getChipherCheck();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCommunicationString method, of class Communication.
     */
    @Test
    public void test_get_communicationString() {
        Communication instance = new Communication(chipher, chipherCheck, systemId);
        String expResult = communicationString;
        String result = instance.getCommunicationString();
        assertEquals(expResult, result);

    }
    
}
