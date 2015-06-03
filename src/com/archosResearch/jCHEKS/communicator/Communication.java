package com.archosResearch.jCHEKS.communicator;

import com.archosResearch.jCheks.concept.communicator.AbstractCommunication;

/**
 *
 * @author Thomas Lepage
 */
public class Communication extends AbstractCommunication {

    //TODO Fsctory
    public Communication(String communication) {
        String[] communicationElements = communication.split("~");
        this.cipher = communicationElements[0];
        this.cipherCheck = communicationElements[1];
        this.systemId = communicationElements[2];
    }

    public Communication(String cipher, String cipherCheck, String systemId) {
        super(cipher, cipherCheck, systemId);
    }

    @Override
    public String getCommunicationString() {
        //TODO change sb to StringBuilder
        StringBuilder sb = new StringBuilder();
        sb.append(this.cipher);
        sb.append("~");
        sb.append(this.cipherCheck);
        sb.append("~");
        sb.append(this.systemId);

        return sb.toString();
    }
}
