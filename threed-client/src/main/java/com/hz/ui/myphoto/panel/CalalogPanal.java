package com.hz.ui.myphoto.panel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;


import com.hz.ui.ConstantsUI;
import com.hz.ui.myphoto.Label.MypohotoJLabel;
import com.hz.ui.myphoto.constants.MyPhotoConstantsUI;



public class CalalogPanal extends JPanel {
	private static final long serialVersionUID = 1L;
    // 主面板水平间隔
    public final static int MAIN_H_GAP = 25;
	private static final Graphics Graphics = null;
    
    private MypohotoJLabel userLabel;   //登录人头像
    private JLabel userName;   //登录人姓名
	/**
	 * 构造
	 * @return 
	 */
	public  CalalogPanal(JFrame frame) {
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
		JPanel catalogPanel = new JPanel();
		int windowWide=(int) frame.getSize().getWidth();
    	int windowHeight=(int) frame.getSize().getHeight();
    	
    	catalogPanel.setLocation(MyPhotoConstantsUI.CALALOG_X, MyPhotoConstantsUI.CALALOG_Y);
    	catalogPanel.setPreferredSize(new Dimension(MyPhotoConstantsUI.CALALOG_WIDTH,windowHeight));
    	GridBagLayout layout = new GridBagLayout(); 
    	catalogPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 10)); 
    	
    	GridBagConstraints s= new GridBagConstraints();//定义一个GridBagConstraints， 

		//登陆部分
		userLabel=new MypohotoJLabel(70,70,MyPhotoConstantsUI.USER_PIC_PATH);
		catalogPanel.add(userLabel);
		userName=new JLabel("linglili");
		catalogPanel.add(userName);

		//
		JLabel catalog2=new MypohotoJLabel(50,50,MyPhotoConstantsUI.CATALOG_BENDI);
		catalogPanel.add(catalog2);
		JLabel catalog3=new MypohotoJLabel(50,50,MyPhotoConstantsUI.CATALOG_YUN);
		catalogPanel.add(catalog3);
		
		JLabel catalog4=new JLabel("自定义选项",SwingConstants.CENTER);
		
		catalogPanel.add(catalog4);
		
//		JLabel catalog5=new JLabel("catalog5");
//		catalogPanel.add(catalog5);
//		JLabel catalog6=new JLabel("catalog6");
//	    catalogPanel.add(catalog6);
//		JLabel catalog7=new JLabel("catalog7");
//		catalogPanel.add(catalog7);

		
		catalogPanel.setBackground(Color.GRAY);
		return catalogPanel;
	}
	
}
