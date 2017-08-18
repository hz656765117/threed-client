/*
 * MyPhotoShow.java
 *
 * Created on __DATE__, __TIME__
 */

package com.hz.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.hz.ui.myphoto.panel.CalalogPanal;
import com.hz.ui.myphoto.panel.PhotoShowPanal;
import com.hz.ui.myphoto.panel.SearchPanal;
import com.hz.ui.myphoto.panel.UserPanal;



/**
 *
 * @author  __USER__
 */
public class MyPhotoShow extends javax.swing.JFrame {
	private JPanel calalogPanel;  
	private JPanel searchPanal;  
	private JPanel userPanal;  
	private JPanel photoShowPanal;  
	private JFrame frame;

	public MyPhotoShow() {
		initComponents();
	}

	private void initComponents() {
		// 设置系统默认样式
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException
                | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }


		frame = new JFrame();
		frame.setBounds(ConstantsUI.MAIN_WINDOW_X, ConstantsUI.MAIN_WINDOW_Y, ConstantsUI.MAIN_WINDOW_WIDTH,
                ConstantsUI.MAIN_WINDOW_HEIGHT);
        frame.setTitle(ConstantsUI.APP_NAME);
        frame.setIconImage(ConstantsUI.IMAGE_ICON);
        frame.setBackground(ConstantsUI.MAIN_BACK_COLOR);
        
        
        calalogPanel =new CalalogPanal( frame);;  
       // searchPanal=new SearchPanal( frame);  
    	//userPanal=new UserPanal( frame);  
    	photoShowPanal=new PhotoShowPanal( frame);  
    	frame.setLayout( new BorderLayout());
    	


    	
    	//frame.add(userPanal,"North");//用户信息和查找
    	//frame.add(searchPanal,"South"); //分页
    	frame.add(photoShowPanal,"East"); //图片展示
    	frame.add(calalogPanel,"West"); //目录
    	

		pack();
	}


	public static void main(String args[]) {
		 EventQueue.invokeLater(new Runnable() {
			public void run() {
				MyPhotoShow window = new MyPhotoShow();
                window.frame.setVisible(true);
			}
		});
	}

	

}