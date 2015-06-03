
package com.archosResearch.jCHEKS.communicator.tcp;

import com.archosResearch.jCHEKS.communicator.tcp.exception.TCPSocketException;
import com.archosResearch.jCHEKS.communicator.AbstractObservable;
import com.archosResearch.jCHEKS.communicator.SenderObserver;
import com.archosResearch.jCheks.concept.communicator.AbstractCommunication;

/**
 *
 * @author Thomas Lepage thomas.lepage@hotmail.ca
 */
public abstract class AbstractSender extends AbstractObservable<SenderObserver> {

    protected String ipAddress;
    protected int port;
    
    public abstract void sendCommunication(AbstractCommunication communication) throws TCPSocketException;

    public String getIpAddress() {
        return this.ipAddress;
    }
}
