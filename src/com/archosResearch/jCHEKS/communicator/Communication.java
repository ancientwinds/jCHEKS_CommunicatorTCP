package com.archosResearch.jCHEKS.communicator;

import com.archosResearch.jCHEKS.concept.exception.CommunicationException;
import com.archosResearch.jCHEKS.concept.communicator.AbstractCommunication;
import java.io.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.*;
import org.xml.sax.*;

/**
 *
 * @author Thomas thomas.lepage@hotmail.ca
 */
public class Communication extends AbstractCommunication {

    public static Communication createCommunication(String communicationString) throws CommunicationException{
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            InputSource is = new InputSource();
            is.setCharacterStream(new StringReader(communicationString));
            
            Document doc = db.parse(is);            
            String cipher = getTextForField("cipher", doc);
            String cipherCheck = getTextForField("cipherCheck", doc);
            String systemId = getTextForField("systemId", doc);
            
            return new Communication(cipher, cipherCheck, systemId);
        } catch (ParserConfigurationException | SAXException | IOException ex) {
            throw new CommunicationException("Error while parsing the communication", ex);
        }
    }
    
    private static String getTextForField(String field, Document doc) {
        return doc.getElementsByTagName(field).item(0).getTextContent();
    }

    public Communication(String cipher, String cipherCheck, String systemId) {
        super(cipher, cipherCheck, systemId);
    }

    @Override
    public String getCommunicationString() throws CommunicationException{
        
        try {
            Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
            
            Element rootElement = doc.createElement("communication");
            doc.appendChild(rootElement);
            
            Element cipherEle = doc.createElement("cipher");
            cipherEle.appendChild(doc.createTextNode(this.cipher));
            rootElement.appendChild(cipherEle);
            
            Element cipherCheckEle = doc.createElement("cipherCheck");
            cipherCheckEle.appendChild(doc.createTextNode(this.cipherCheck));
            rootElement.appendChild(cipherCheckEle);
            
            Element systemIdEle = doc.createElement("systemId");
            systemIdEle.appendChild(doc.createTextNode(this.systemId));
            rootElement.appendChild(systemIdEle);
            
            DOMSource domSource = new DOMSource(doc);
            StringWriter writer = new StringWriter();
            StreamResult result = new StreamResult(writer);
            TransformerFactory.newInstance().newTransformer().transform(domSource, result);
            
            return writer.toString();
        } catch (ParserConfigurationException | TransformerException ex) {
            throw new CommunicationException("Error creating communication string", ex);
        }
    }
}
