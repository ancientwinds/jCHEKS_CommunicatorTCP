
package com.archosResearch.jCHEKS.communicator.tcp;

import com.archosResearch.jCheks.concept.communicator.AbstractCommunication;
import com.archosResearch.jCheks.concept.communicator.AbstractCommunicator;
import com.archosResearch.jCheks.concept.communicator.CommunicatorException;

/**
 *
 * @author Thomas Lepage
 */
public class TCPCommunicator extends AbstractCommunicator {
    
    private final ITCPSender sender;
    private final ITCPReceiver receiver;
   
    public TCPCommunicator(ITCPSender sender, ITCPReceiver receiver){

        this.sender = sender;
        
        this.receiver = receiver;
    }
    
    @Override
    public void sendCommunication(AbstractCommunication communication) throws CommunicatorException{
        try {
            this.sender.sendCommunication(communication);
        } catch (TCPSocketException ex) {
            throw new CommunicatorException();
        }

    }  
}
