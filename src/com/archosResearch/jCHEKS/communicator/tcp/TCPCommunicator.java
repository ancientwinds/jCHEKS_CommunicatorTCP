package com.archosResearch.jCHEKS.communicator.tcp;

import com.archosResearch.jCHEKS.communicator.*;
import com.archosResearch.jCHEKS.communicator.tcp.exception.TCPSocketException;
import com.archosResearch.jCHEKS.concept.communicator.*;
import com.archosResearch.jCHEKS.concept.exception.CommunicatorException;

/**
 *
 * @author Thomas Lepage thomas.lepage@hotmail.ca
 */
public class TCPCommunicator extends AbstractCommunicator implements SenderObserver, ReceiverObserver {

    private final AbstractSender sender;
    private final AbstractReceiver receiver;

    public TCPCommunicator(AbstractSender sender, AbstractReceiver receiver, String uniqueId) {
        this.sender = sender;
        this.receiver = receiver;
        this.sender.addObserver(this);
        this.receiver.addObserver(uniqueId, this);
    }

    @Override
    public void sendCommunication(AbstractCommunication communication) throws CommunicatorException {
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
    public void ackReceived(AbstractCommunication communication) {
        notifyAckReceived(communication);
    }

    @Override
    public void secureAckReceived(AbstractCommunication communication) {
        notifySecureAckReceived(communication);
    }

    @Override
    public void failToReceiveAck(AbstractCommunication communication) {
        notifyFailToReceiveAck(communication);
    }

    @Override
    public void failToReceiveSecureAck(AbstractCommunication communication) {
        notifyFailToReceiveSecureAck(communication);
    }

    @Override
    public void timeOutReached(AbstractCommunication communication) {
        notifyTimeOutReached(communication);
    }

    @Override
    public void exceptionThrown(CommunicatorException exception, AbstractCommunication communication) {
        notifyExceptionThrown(exception, communication);
    }

}
