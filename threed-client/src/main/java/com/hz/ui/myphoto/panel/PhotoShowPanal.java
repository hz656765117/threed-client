package com.hz.ui.myphoto.panel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;


import com.hz.ui.ConstantsUI;
import com.hz.ui.myphoto.Label.MypohotoJLabel;
import com.hz.ui.myphoto.constants.MyPhotoConstantsUI;



public class PhotoShowPanal extends JPanel {
	private static final long serialVersionUID = 1L;
    // 主面板水平间隔
    public final static int MAIN_H_GAP = 25;
    
    private MypohotoJLabel userLabel;   //登录人头像
    private JLabel userName;   //登录人姓名
	/**
	 * 构造
	 * @return 
	 */
	public  PhotoShowPanal(JFrame frame) {
		//initialize();
		addComponent( frame);
	}
	/**
	 * 初始化
	 */
	private void initialize() {
		this.setBackground(ConstantsUI.MAIN_BACK_COLOR);
		this.setLayout(new BorderLayout());
	}

	/**
	 * 添加组件
	 */
	private void addComponent(JFrame frame) {

		this.add(getCatalogPanel( frame), BorderLayout.WEST);

	}
	
	/**
	 * 用户面板
	 * 
	 * @return
	 */
	private JScrollPane getCatalogPanel(JFrame frame) {
		JPanel photoPanel = new JPanel();
		int windowWide=(int) frame.getSize().getWidth();
    	int windowHeight=(int) frame.getSize().getHeight();
    	
    	photoPanel.setLocation(100, 0);
    	photoPanel.setPreferredSize(new Dimension(windowWide-200,windowHeight*2));
    	photoPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 25, 15));
		
		JLabel searchPic= new MypohotoJLabel(MyPhotoConstantsUI.USER_PIC_PATH);
		JTextField searchField =new JTextField(35);
		//searchField.setLocation(100,20);
		JButton allButton =new JButton("全部");
		JButton freeButton =new JButton("免费");
		JButton payButton=new JButton("付费");
		JComboBox timeBox=new JComboBox(new String []{"今天","一天前","三天前","半个月前"});
		
		
		photoPanel.add(searchPic);
		photoPanel.add(searchField);
		photoPanel.add(allButton);
		photoPanel.add(freeButton);
		photoPanel.add(payButton);
		photoPanel.add(timeBox);
		
		
		//图片部分
		JLabel photo1= new MypohotoJLabel(200,300,MyPhotoConstantsUI.PHOTO_TEST_SHOW);
		JLabel photo2= new MypohotoJLabel(200,300,MyPhotoConstantsUI.PHOTO_TEST_SHOW);
		JLabel photo3= new MypohotoJLabel(200,300,MyPhotoConstantsUI.PHOTO_TEST_SHOW);
		JLabel photo4= new MypohotoJLabel(200,300,MyPhotoConstantsUI.PHOTO_TEST_SHOW);
		JLabel photo5= new MypohotoJLabel(200,300,MyPhotoConstantsUI.PHOTO_TEST_SHOW);
		JLabel photo6= new MypohotoJLabel(200,300,MyPhotoConstantsUI.PHOTO_TEST_SHOW);
		photoPanel.add(photo1);
		photoPanel.add(photo2);
		photoPanel.add(photo3);
		photoPanel.add(photo4);
		photoPanel.add(photo5);
		photoPanel.add(photo6);
		
		
		
		photoPanel.setBackground(Color.PINK);
		 JScrollPane scrollPane = new JScrollPane(photoPanel);
		 scrollPane.setPreferredSize(new Dimension(windowWide-200,windowHeight));
		return scrollPane;
	}
	
}
