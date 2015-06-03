package com.archosResearch.jCHEKS.communicator.tcp;

import com.archosResearch.jCHEKS.communicator.SenderObserver;
import com.archosResearch.jCheks.concept.communicator.AbstractCommunication;

/**
 *
 * @author Thomas Lepage
 */
public class MockTCPSender extends ITCPSender {

    private boolean communicationSent = false;
    public boolean throwException = false;
    public SenderObserver observer;

    @Override
    public void sendCommunication(AbstractCommunication communication) throws TCPSocketException {
        if (throwException) {
            throw new TCPSocketException();
        }
        this.communicationSent = true;
    }

    public boolean isCommunicationSent() {
        return this.communicationSent;
    }

    @Override
    public void addObserver(SenderObserver observer) {
        this.observer = observer;
    }

    @Override
    public void notifyMessageACK() {
    }

}
