
package com.archosResearch.jCHEKS.communicator;

import com.archosResearch.jCheks.concept.communicator.AbstractCommunication;

/**
 *
 * @author Thomas Lepage
 */
public class Communication extends AbstractCommunication{
    
    public Communication(String communication)
    {   
        String[] communicationElements = communication.split("~");
        this.chipher = communicationElements[0];
        this.chiperCheck = communicationElements[1];
        this.systemId = communicationElements[2];
    }
    
    public Communication(String chipher, String chipherCheck, String systemId)
    {
        super(chipher, chipherCheck, systemId);
    }
    
    @Override
    public String getCommunicationString(){
        StringBuilder sb = new StringBuilder();
        sb.append(this.chipher);
        sb.append("~");
        sb.append(this.chiperCheck);
        sb.append("~");
        sb.append(this.systemId);
        
        return sb.toString();
    }
}
