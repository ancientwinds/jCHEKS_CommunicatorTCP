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
        
        //TODO Temporary UI for testing.
        EventQueue.invokeLater(new Runnable() {
        
            @Override
            public void run() {
                TempGUI ex = new TempGUI();
                ex.setVisible(true);
            }
        });
    } 
}
