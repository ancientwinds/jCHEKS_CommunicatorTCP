package com.archosResearch.jCHEKS.communicator.tcp;

import com.archosResearch.jCHEKS.communicator.ReceiverObserver;
import com.archosResearch.jCHEKS.communicator.SenderObserver;
import com.archosResearch.jCheks.concept.communicator.AbstractCommunication;
import com.archosResearch.jCheks.concept.communicator.AbstractCommunicator;
import com.archosResearch.jCheks.concept.communicator.CommunicatorException;

/**
 *
 * @author Thomas Lepage
 */
public class TCPCommunicator extends AbstractCommunicator implements SenderObserver, ReceiverObserver {

    private final AbstractTCPSender sender;
    private final AbstractTCPReceiver receiver;

    public TCPCommunicator(AbstractTCPSender sender, AbstractTCPReceiver receiver) {

        this.sender = sender;
        this.sender.addObserver(this);

        this.receiver = receiver;
        this.receiver.addObserver(this.sender.getIpAddress(), this);
    }

    @Override
    public void sendCommunication(AbstractCommunication communication) throws CommunicatorException {
        try {
            this.sender.sendCommunication(communication);
        } catch (TCPSocketException ex) {
            throw new CommunicatorException();
        }

    }

    @Override
    public void messageReceived(AbstractCommunication communication) {
        notifyCommunicationReceived(communication);
    }

    @Override
    public void ackReceived() {
        notifyAckReceived();
    }
}
