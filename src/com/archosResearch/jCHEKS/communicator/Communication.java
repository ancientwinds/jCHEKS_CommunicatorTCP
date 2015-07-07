package com.archosResearch.jCHEKS.communicator;

import com.archosResearch.jCHEKS.concept.exception.CommunicationException;
import com.archosResearch.jCHEKS.concept.communicator.AbstractCommunication;
import java.io.*;
import java.util.logging.*;
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
            NodeList cipher = doc.getElementsByTagName("cipher");
            Element cipherEle = (Element) cipher.item(0);
            NodeList cipherCheck = doc.getElementsByTagName("cipherCheck");
            Element cipherCheckEle = (Element) cipherCheck.item(0);
            NodeList systemId = doc.getElementsByTagName("systemId");
            Element systemIdEle = (Element) systemId.item(0);
            
            return new Communication(cipherEle.getTextContent(), cipherCheckEle.getTextContent(), systemIdEle.getTextContent());
        } catch (ParserConfigurationException | SAXException | IOException ex) {
            throw new CommunicationException("Error while parsing the communication", ex);
        }
    }

    public Communication(String cipher, String cipherCheck, String systemId) {
        super(cipher, cipherCheck, systemId);
    }

    @Override
    public String getCommunicationString() throws CommunicationException{
        
        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            
            // root elements
            Document doc = docBuilder.newDocument();
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
            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer transformer = tf.newTransformer();
            transformer.transform(domSource, result);
            
            return writer.toString();
        } catch (ParserConfigurationException | TransformerException ex) {
            throw new CommunicationException("Error creating communication string", ex);
        }
    }
}
