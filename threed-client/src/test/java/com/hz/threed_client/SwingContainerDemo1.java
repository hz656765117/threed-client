package com.hz.threed_client;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SwingContainerDemo1 {
   private JFrame mainFrame;
   private JLabel headerLabel;
   private JLabel statusLabel;
   private JPanel controlPanel;
   private JLabel msglabel;

   public SwingContainerDemo1(){
      prepareGUI();
   }

   public static void main(String[] args){
      SwingContainerDemo1  swingContainerDemo = new SwingContainerDemo1();  
      swingContainerDemo.showJPanelDemo();
   }

   private void prepareGUI(){
      mainFrame = new JFrame("Java Swing Examples");
      mainFrame.setSize(400,800);
      mainFrame.setLayout(new GridLayout(3, 1));
      mainFrame.addWindowListener(new WindowAdapter() {
         public void windowClosing(WindowEvent windowEvent){
            System.exit(0);
         }        
      });    
      headerLabel = new JLabel("", JLabel.CENTER);        
      statusLabel = new JLabel("",JLabel.CENTER);    

      statusLabel.setSize(350,300);

      msglabel = new JLabel("Welcome to TutorialsPoint SWING Tutorial."
         , JLabel.CENTER);

      controlPanel = new JPanel();
      controlPanel.setLayout(new FlowLayout());

      mainFrame.add(headerLabel);
      mainFrame.add(controlPanel);
      mainFrame.add(statusLabel);
      mainFrame.setVisible(true);  
   }


   private void showJPanelDemo(){
      headerLabel.setText("Container in action: JPanel");      

      JPanel panel = new JPanel();
      panel.setBackground(Color.red);
      panel.setLayout(new FlowLayout());        
      panel.add(msglabel);

      controlPanel.add(panel);        
      mainFrame.setVisible(true);      
   }   
}