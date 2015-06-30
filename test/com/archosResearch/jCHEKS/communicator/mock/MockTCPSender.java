package com.archosResearch.jCHEKS.communicator.mock;

import com.archosResearch.jCHEKS.communicator.tcp.TCPSender;
import com.archosResearch.jCHEKS.communicator.tcp.exception.TCPSocketException;
import com.archosResearch.jCHEKS.concept.communicator.AbstractCommunication;
import java.net.SocketException;

/**
 *
 * @author Thomas Lepage thomas.lepage@hotmail.ca
 */
public class MockTCPSender extends TCPSender {

    public AbstractCommunication lastCommunication;
    public boolean shouldThrowException = false;

    public MockTCPSender(String ipAddress, int port) {
        super(ipAddress, port);
    }

    @Override
    public void sendCommunication(AbstractCommunication communication) throws TCPSocketException {
        if (this.shouldThrowException) {
            throw new TCPSocketException("error", new SocketException());
        }
        this.lastCommunication = communication;
    }

    public void receiveAck(AbstractCommunication communication) {
        notifyMessageACK(communication);
    }

    public void receiveSecureAck(AbstractCommunication communication, String secureAck) {
        notifySecureACK(communication, secureAck);
    }

    public void setThrowException(boolean shouldThrowException) {
        this.shouldThrowException = shouldThrowException;
    }

}
