package com.archosResearch.jCHEKS.communicator.tcp;

import com.archosResearch.jCHEKS.communicator.tcp.exception.TCPSocketException;
import com.archosResearch.jCHEKS.communicator.*;
import com.archosResearch.jCHEKS.communicator.exception.CommunicatorException;
import com.archosResearch.jCHEKS.concept.communicator.*;
import com.archosResearch.jCHEKS.concept.exception.AbstractCommunicatorException;

/**
 *
 * @author Thomas Lepage thomas.lepage@hotmail.ca
 */
public class TCPCommunicator extends AbstractCommunicator implements SenderObserver, ReceiverObserver {

    private final TCPSender sender;
    private final TCPReceiver receiver;

    public TCPCommunicator(TCPSender sender, TCPReceiver receiver) {
        this.sender = sender;
        this.receiver = receiver;
        this.sender.addObserver(this);
        this.receiver.addObserver(this.sender.getIpAddress() + this.sender.getPort(), this);
    }

    @Override
    public void sendCommunication(AbstractCommunication communication) throws AbstractCommunicatorException {
        try {
            this.sender.sendCommunication(communication);
        } catch (TCPSocketException ex) {
            throw new CommunicatorException("Cannot send communication.", ex);
        }
    }
    
    @Override
    public String messageReceived(AbstractCommunication communication) {
        return notifyCommunicationReceived(communication);
    }

    @Override
    public void ackReceived() {
        notifyAckReceived();
    }

    @Override
    public void secureAckReceived() {
        notifySecureAckReceived();
    }

}
