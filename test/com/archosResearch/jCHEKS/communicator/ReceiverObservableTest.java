/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.archosResearch.jCHECKS.communicator;

import com.archosResearch.jCHEKS.communicator.ReceiverObservable;
import com.archosResearch.jCHEKS.Engine.MockEngine;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Thomas Lepage
 */
public class ReceiverObservableTest {

    private static final String message = "Test message";

    /**
     * Test of notifyMessageReceived method, of class ReceiverObservable.
     */
    @Test
    public void test_notify_message_received() {
        MockEngine engine = new MockEngine();
        ReceiverObservable instance = new ReceiverObservable();
        instance.addObserver(engine);
        
        instance.notifyMessageReceived(message);
        
        assertEquals(engine.getMessageReceived(), message);
    }
    
}
