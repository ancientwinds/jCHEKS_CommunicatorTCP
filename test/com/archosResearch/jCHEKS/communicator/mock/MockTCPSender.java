package com.archosResearch.jCHEKS.communicator.mock;

import com.archosResearch.jCHEKS.communicator.tcp.TCPSender;
import com.archosResearch.jCHEKS.communicator.tcp.exception.TCPSocketException;
import com.archosResearch.jCHEKS.concept.communicator.AbstractCommunication;
import java.net.SocketException;

/**
 *
 * @author Thomas Lepage
 */
public class MockTCPSender extends TCPSender {

    public AbstractCommunication lastCommunication;
    public boolean shouldThrowException = false;
    
    public MockTCPSender(String ipAddress, int port) {
        super(ipAddress, port);
    }
    
    @Override
    public void sendCommunication(AbstractCommunication communication) throws TCPSocketException {
        if(this.shouldThrowException) {
            throw new TCPSocketException("error", new SocketException());
        }
        this.lastCommunication = communication;
    }
    
    public void receiveAck() {
        notifyMessageACK();
    }
    
    public void receiveSecureAck() {
        notifySecureACK();
    }
    
    public void setThrowException(boolean shouldThrowException){
        this.shouldThrowException = shouldThrowException;
    }


    
}
