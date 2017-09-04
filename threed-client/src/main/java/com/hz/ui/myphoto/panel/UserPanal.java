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
import javax.swing.JTextField;


import com.hz.ui.ConstantsUI;
import com.hz.ui.myphoto.Label.MypohotoJLabel;
import com.hz.ui.myphoto.constants.MyPhotoConstantsUI;



public class UserPanal extends JPanel {
	private static final long serialVersionUID = 1L;
    // 主面板水平间隔
    public final static int MAIN_H_GAP = 25;
    
    private JLabel userLabel;   //登录人头像
    private JLabel userName;   //登录人姓名
    private JLabel searchPic;
    private JTextField searchField;
    private JButton allButton;
    private JButton freeButton;
    private JButton payButton;
    private JComboBox timeBox;
	/**
	 * 构造
	 * @return 
	 */
	public  UserPanal(JFrame frame) {
		//initialize();
		addComponent(frame);
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

		this.add(getCatalogPanel(frame), BorderLayout.WEST);

	}
	
	/**
	 * 用户面板
	 * 
	 * @return
	 */
	private JPanel getCatalogPanel(JFrame frame) {
		JPanel leftPanel = new JPanel();
		//leftPanel.setSize(100, 100);
		//leftPanel.setLayout(null);
    	int windowWide=(int) frame.getSize().getWidth();
    	int windowHeight=(int) frame.getSize().getHeight();
    	
		leftPanel.setLocation(MyPhotoConstantsUI.USER_LEFT_X, MyPhotoConstantsUI.USER_LEFT_Y);
		leftPanel.setPreferredSize(new Dimension(windowWide, MyPhotoConstantsUI.USER_HEIGHT));
		leftPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 30, 30));
		//登陆部分
		userLabel=new MypohotoJLabel(MyPhotoConstantsUI.USER_PIC_PATH);
		leftPanel.add(userLabel);
		userName=new JLabel("登录人");
		leftPanel.add(userName);
		
		
		searchPic= new MypohotoJLabel(MyPhotoConstantsUI.USER_PIC_PATH);
		searchField =new JTextField(40);
		//searchField.setLocation(100,20);
		allButton =new JButton("全部");
		freeButton =new JButton("免费");
		payButton=new JButton("付费");
	    timeBox=new JComboBox(new String []{"今天","一天前","三天前","半个月前"});
		
		leftPanel.add(searchPic);
		leftPanel.add(searchField);
		leftPanel.add(allButton);
		leftPanel.add(freeButton);
		leftPanel.add(payButton);
		leftPanel.add(timeBox);
		 
		leftPanel.setBackground(Color.ORANGE);
		return leftPanel;
	}
	
}
