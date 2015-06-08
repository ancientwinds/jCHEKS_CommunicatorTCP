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
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.cipher);
        stringBuilder.append("~");
        stringBuilder.append(this.cipherCheck);
        stringBuilder.append("~");
        stringBuilder.append(this.systemId);

        return stringBuilder.toString();
    }
}
