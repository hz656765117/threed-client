package com.hz.ui.myphoto.panel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


import com.hz.ui.ConstantsUI;
import com.hz.ui.myphoto.Label.MypohotoJLabel;
import com.hz.ui.myphoto.constants.MyPhotoConstantsUI;



public class SearchPanal extends JPanel {
	private static final long serialVersionUID = 1L;
    // 主面板水平间隔
    public final static int MAIN_H_GAP = 25;
    
    private MypohotoJLabel userLabel;   //登录人头像
    private JLabel userName;   //登录人姓名
	/**
	 * 构造
	 * @return 
	 */
	public  SearchPanal(JFrame frame) {
		//initialize();
		addComponent();
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
	private void addComponent() {

		this.add(getCatalogPanel(), BorderLayout.WEST);

	}
	
	/**
	 * 用户面板
	 * 
	 * @return
	 */
	private JPanel getCatalogPanel() {
		JPanel leftPanel = new JPanel();
		//leftPanel.setLayout(null);
//		leftPanel.setLocation(MyPhotoConstantsUI.MYPHOTO_LEFT_X, MyPhotoConstantsUI.MYPHOTO_LEFT_Y);
//		leftPanel.setPreferredSize(new Dimension(MyPhotoConstantsUI.MYPHOTO_LEFT_WIDTH, MyPhotoConstantsUI.MYPHOTO_LEFT_HEIGHT));
		leftPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 5));
		//登陆部分
		userLabel=new MypohotoJLabel(MyPhotoConstantsUI.USER_PIC_PATH);
		leftPanel.add(userLabel);
		userName=new JLabel("查询");
		leftPanel.add(userName);
		
		
		
		leftPanel.setBackground(Color.RED);
		return leftPanel;
	}
	
}
