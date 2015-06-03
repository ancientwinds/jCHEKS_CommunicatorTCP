package com.archosResearch.jCHEKS.communicator.tcp;

import com.archosResearch.jCHEKS.communicator.SenderObserver;
import com.archosResearch.jCheks.concept.communicator.AbstractCommunication;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Thomas Lepage
 */
public class TCPSender extends AbstractTCPSender {

    private final String ipAddress;
    private final int port;

    public TCPSender(String ipAddress, int port) {
        this.ipAddress = ipAddress;
        this.port = port;
    }

    @Override
    public void sendCommunication(AbstractCommunication communication) throws TCPSocketException {
        try {
            Socket clientSocket = new Socket(this.ipAddress, this.port);

            OutputStream outToDestination = clientSocket.getOutputStream();
            DataOutputStream dataOutToDestination = new DataOutputStream(outToDestination);

            System.out.println("Sending communication to destination...");
            dataOutToDestination.writeUTF(communication.getCommunicationString());

            System.out.println("Waiting for ACK");
            InputStream inFromDestination = clientSocket.getInputStream();
            DataInputStream dataInFromDestination = new DataInputStream(inFromDestination);

            notifyMessageACK();

            System.out.println("From dest: " + dataInFromDestination.readUTF());

            clientSocket.close();
        } catch (IOException ex) {
            throw new TCPSocketException();
        }
    }

    public void notifyMessageACK() {
        for (SenderObserver observer : this.observers) {
            observer.ackReceived();
        }
    }
}
