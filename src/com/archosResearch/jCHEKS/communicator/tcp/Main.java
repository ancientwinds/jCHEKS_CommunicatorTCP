/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.archosResearch.jCHEKS.communicator.tcp;

import java.awt.EventQueue;
import java.io.Console;
import java.util.Scanner;

/**
 *
 * @author Thomas Lepage thomas.lepage@hotmail.ca
 */
public class Main {
    
    
    public static void main(String[] args) {
        
        EventQueue.invokeLater(new Runnable() {
        
            @Override
            public void run() {
                TempGUI ex = new TempGUI();
                ex.setVisible(true);
            }
        });
        /*Scanner reader = new Scanner(System.in);
        System.out.println("Enter the port number");
        // get user input for a
        TCPCommunicator tcpCommunicator = null;
        while(true){
            int a = reader.nextInt();
            if(a == 1){
                tcpCommunicator = new TCPCommunicator(9000);
            }
            if(a == 2){
                tcpCommunicator = new TCPCommunicator(9001);
            }
            if(a == 3){
                tcpCommunicator.sendCommunication(new Communication("Test de sending"));
            }
        }*/
    } 
}
