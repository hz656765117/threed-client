/*
 * MyPhotoShow.java
 *
 * Created on __DATE__, __TIME__
 */

package com.hz.ui;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.hz.ui.myphoto.Listener.FrameChangeListener;
import com.hz.ui.myphoto.constants.MyPhotoConstantsUI;
import com.hz.ui.myphoto.control.AppControl;
import com.hz.ui.myphoto.panel.*;
import com.hz.utils.PixelUtil;


/**
 *
 * @author  __USER__
 */
public class MyPhotoShow extends javax.swing.JFrame {
	private JFrame frame;
	private String userName;

	public MyPhotoShow() {
		initComponents();
	}
	public MyPhotoShow(String userName) {
		this.setUserName(userName);
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
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//设置关闭框架的同时结束程序
		frame.setBounds(ConstantsUI.MAIN_WINDOW_X, ConstantsUI.MAIN_WINDOW_Y, PixelUtil.scaleWidth(ConstantsUI.MAIN_WINDOW_WIDTH_PRECENT),
				PixelUtil.scaleHeight(ConstantsUI.MAIN_WINDOW_HEIFHT_PRECENT));
        frame.setTitle(ConstantsUI.APP_NAME);
        frame.setIconImage(ConstantsUI.IMAGE_ICON);
        frame.setBackground(ConstantsUI.MAIN_BACK_COLOR);
        
        
    	frame.setLayout( new BorderLayout());

		AppControl appControl=AppControl.instance();
		CategoryPanel categoryPanel=new CategoryPanel(MyPhotoConstantsUI.CALALOG_WIDTH,frame.getSize().height,this.getUserName());

		MainPanel mainPanel=new MainPanel(frame.getSize().width-MyPhotoConstantsUI.CALALOG_WIDTH,frame.getSize().height);
		
		frame.add(categoryPanel,"West");
    	frame.add(mainPanel,"East"); //图片展示
		





		java.util.List<JPanel> panelList=new ArrayList<>();
		panelList.add(categoryPanel);
		panelList.add(mainPanel);
		FrameChangeListener listener=new FrameChangeListener(frame,panelList,this.getUserName(),appControl);
		frame.setResizable(false);
		appControl.setMainPanel(mainPanel);

		pack();
		
		this.frame.setVisible(true);
	}



	public static void main(String args[]) {
		MyPhotoShow window = new MyPhotoShow();
//		 EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				MyPhotoShow window = new MyPhotoShow();
//              //  window.frame.setVisible(true);
//			}
//		});
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}

	

}