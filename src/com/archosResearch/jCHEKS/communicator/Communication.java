package com.archosResearch.jCHEKS.communicator;

import com.archosResearch.jCHEKS.concept.communicator.AbstractCommunication;

/**
 *
 * @author Thomas Lepage
 */
public class Communication extends AbstractCommunication {
    
    public static Communication createCommunication(String communicationString)
    {        
        String[] communicationElements = communicationString.split("~");

        Communication communication = new Communication(communicationElements[0], communicationElements[1], communicationElements[2]);
        return communication;
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
