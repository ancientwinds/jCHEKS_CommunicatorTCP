/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.archosResearch.jCHEKS.communicator.tcp;

import com.archosResearch.jCHECKS.Engine.Engine;
import com.archosResearch.jCHEKS.communicator.CommunicatorObservable;

/**
 *
 * @author Thomas Lepage thomas.lepage@hotmail.ca
 */
public class TCPReceiver extends CommunicatorObservable{
    private static TCPReceiver instance = null;
    
    private Thread listenThread;
    
    protected TCPReceiver(){
        this.listenThread = new Thread(new ListeningThread(9000, this));
        this.listenThread.start();
    }
    
    public static void start(Engine engine){
        if(instance == null){
            instance = new TCPReceiver();
            instance.addObserver(engine);
        }
    }
    
    public void receivingCommunication(String message){
        System.out.println("Received message: " + message);
        notifyMessageReceived(message);
    }
}
