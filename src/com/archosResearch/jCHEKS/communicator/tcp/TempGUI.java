/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.archosResearch.jCHEKS.communicator.tcp;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Thomas Lepage thomas.lepage@hotmail.ca
 */
public class TempGUI extends JFrame{
    
    private JTextField text = new JTextField();
    private TCPCommunicator communicator = null;
    public TempGUI(){
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        JButton createCommunicator = new JButton("Create communicator");
        createCommunicator.addActionListener(new createHandler());
        JButton sendMessage = new JButton("Send message");
        sendMessage.addActionListener(new sendHandler());
        
        
        this.setLayout(new BorderLayout());
        JPanel panel = new JPanel();
        
        panel.setLayout(new GridLayout(1, 3));
        panel.add(createCommunicator);
        panel.add(sendMessage);
        panel.add(text);
        this.add(panel, BorderLayout.CENTER);
        this.revalidate();

    }
    
    private class createHandler implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
        communicator = new TCPCommunicator((Integer.parseInt(text.getText())));
        }
    }
    
    private class sendHandler implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
        communicator.sendCommunication(new Communication(text.getText()));
        }
    }

    
       
}
