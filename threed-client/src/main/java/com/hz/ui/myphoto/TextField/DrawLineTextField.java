package com.hz.ui.myphoto.TextField;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JTextField;

public class DrawLineTextField extends JTextField{
	 private static JTextField jTextField;

	 /*
	  * x - 组件的新 x 坐标
		y - 组件的新 y 坐标
		width - 组件的新 width
		height - 组件的新 height
		只有下划线，并且透明的JTextField
	  */
	 public static JTextField getJTextField(int x,
             int y,
             int width,
             int height){
		  jTextField=new JTextField(){

	            public void paint(Graphics g) {
	                super.paint(g);
	                Graphics2D g2d = (Graphics2D) g;
	                g2d.setPaint(Color.BLACK);
	                g2d.drawLine(0, jTextField.getHeight() - 1, jTextField.getWidth(), jTextField.getHeight() - 1);
	            }
	        };
	        jTextField.setBorder(null);
	        jTextField.setOpaque(false);
	        jTextField.setBounds(x, y, width, height);
	        return jTextField;
	 }
}
