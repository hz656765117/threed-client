package com.hz.ui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Test  extends JFrame {
	 private JTextField textField;
	    private static final long serialVersionUID = -2397593626990759111L;

	    private JPanel pane = null;

	   // private MQDocument doc = null;

	    public Test() {      
	    	super("Test");
	        pane = new JPanel();
	        pane.setLayout(null);

	        this.getContentPane().add(pane);

	        textField = new JTextField(){

	            public void paint(Graphics g) {
	                super.paint(g);
	                Graphics2D g2d = (Graphics2D) g;
	                g2d.setPaint(Color.BLACK);
	                g2d.drawLine(0, textField.getHeight() - 1, textField.getWidth(), textField.getHeight() - 1);
	            }
	        };
	        textField.setBorder(null);
	        textField.setOpaque(false);
	        textField.setBounds(10, 10, 89, 22);
	        pane.add(textField);
	        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        this.setSize(270, 370);
	        this.setVisible(true);
	    }

	    public static void main(String args[]) {
	        new Test();
	    }

}
