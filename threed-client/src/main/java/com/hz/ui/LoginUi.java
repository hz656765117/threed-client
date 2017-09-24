package com.hz.ui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.alibaba.fastjson.JSONObject;
import com.hz.ui.myphoto.Label.LinkLabel;
import com.hz.ui.myphoto.constants.MyPhotoConstantsUI;
import com.hz.utils.CheckLoginUtil;
import com.hz.utils.OpenBrowserUtil;
import com.hz.utils.StringUtil;

@SuppressWarnings("serial")
public class LoginUi extends JFrame{
	 public JPanel pnluser;
	 public JLabel lbluserLogIn;
	 public JLabel lbluserName;
	 public JLabel lbluserPWD;
	 public JTextField txtName;
	 public JPasswordField pwdPwd;
	 public JButton btnSub;
	 public LinkLabel btnReset;
	 public JButton btnMin;
	 public JButton btnClose;
	//用于处理拖动事件，表示鼠标按下时的坐标，相对于JFrame
	 int xOld = 0;
	 int yOld = 0;
	 public LoginUi(){
		  pnluser = new JPanel(){
	             public void paintComponent(Graphics g) {
		                ImageIcon icon =
		                         new ImageIcon(MyPhotoConstantsUI.LOGIN_BACKGROUND);
	                // 图片随窗体大小而变化
		                g.drawImage(icon.getImage(), 0, 0, this.getSize().width,this.getSize().height,this);
		            }
		    };
		  lbluserLogIn = new JLabel();
		  lbluserName = new JLabel();
		  lbluserPWD = new JLabel();
		 // txtName = new JTextField();

		  txtName = new JTextField(){

	            public void paint(Graphics g) {
	                super.paint(g);
	                Graphics2D g2d = (Graphics2D) g;
	                g2d.setPaint(Color.BLACK);
	                g2d.drawLine(0, txtName.getHeight() - 1, txtName.getWidth(), txtName.getHeight() - 1);
	            }
	        };
	        
	        pwdPwd = new JPasswordField(){

	            public void paint(Graphics g) {
	                super.paint(g);
	                Graphics2D g2d = (Graphics2D) g;
	                g2d.setPaint(Color.BLACK);
	                g2d.drawLine(0, pwdPwd.getHeight() - 1, pwdPwd.getWidth(), pwdPwd.getHeight() - 1);
	            }
	        };
	        
		  btnSub = new JButton();
		  btnReset = new LinkLabel("注册",CheckLoginUtil.getRegisterUrl());
		  btnMin = new JButton();
		  btnClose = new JButton();
		  userInit();
		 }
		 
		 public void userInit(){
		  this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//设置关闭框架的同时结束程序
		//  this.setBounds(250,250,250,250);
		  //设置去掉边框  
	      this.setUndecorated(true);  
	      
	      
	      //处理拖动事件---去掉默认边框后，不能拖动了，具体实现如下
	      this.addMouseListener(new MouseAdapter() {
	      @Override
	      public void mousePressed(MouseEvent e) {
	        xOld = e.getX();//记录鼠标按下时的坐标
	        yOld = e.getY();
	       }
	      });
	      
	      this.addMouseMotionListener(new MouseMotionAdapter() {
	        @Override
	        public void mouseDragged(MouseEvent e) {
	        int xOnScreen = e.getXOnScreen();
	        int yOnScreen = e.getYOnScreen();
	        int xx = xOnScreen - xOld;
	        int yy = yOnScreen - yOld;
	        LoginUi.this.setLocation(xx, yy);//设置拖拽后，窗口的位置
	        }
	      });
	        
	      this.setVisible(true);  
		  this.setSize(300,200);//设置框架大小为长300,宽200
		  this.setResizable(false);//设置框架不可以改变大小
		  this.setTitle("用户登录");//设置框架标题
		  
		  int w = (Toolkit.getDefaultToolkit().getScreenSize().width - 300) / 2;
		  int h = (Toolkit.getDefaultToolkit().getScreenSize().height - 200) / 2;
		  this.setLocation(w, h);
		  
		  this.pnluser.setLayout(null);//设置面板布局管理
		  this.pnluser.setBackground(Color.cyan);//设置面板背景颜色
		  this.lbluserLogIn.setText("用户登录");//设置标签标题
		  this.lbluserLogIn.setFont(new Font("宋体",Font.BOLD | Font.ITALIC,14));//设置标签字体
		  this.lbluserLogIn.setForeground(Color.RED);//设置标签字体颜色
		  
		  this.lbluserName.setText("用户名:");
		  this.lbluserPWD.setText("密    码:");
		  this.btnSub.setText("登录");
		//  this.btnReset.setText("注册");
		  this.btnClose.setText("关闭");
		  this.btnMin.setText("最小化");
		  this.lbluserLogIn.setBounds(120,15,60,20);//设置标签x坐标120,y坐标15,长60,宽20
		  
		  this.lbluserName.setBounds(70,35,140,20);
		  this.lbluserName.setBorder(new EmptyBorder(0,0,0,0));
		  this.lbluserName.setOpaque(false);
		  
		  this.lbluserPWD.setBounds(70,75,140,25);
		  this.lbluserPWD.setBorder(new EmptyBorder(0,0,0,0));
		  this.lbluserPWD.setOpaque(false);
		 // this.txtName.setBounds(110,55,120,20);
		 // this.txtName.setBorder(new EmptyBorder(0,0,0,0));
		 // this.txtName.setOpaque(false);
		  this.txtName.setBorder(null);
		  this.txtName.setOpaque(false);
		  this.txtName.setBounds(70,55,140,20);
		  
		  
		  this.pwdPwd.setBorder(null);
		  this.pwdPwd.setOpaque(false);
		  this.pwdPwd.setBounds(70,95,140,20);
		  this.btnSub.setBounds(70,130,140,20);
		  
		  //登陆按钮
		  this.btnSub.addActionListener(new ActionListener()//匿名类实现ActionListener接口
		   {
		    public void actionPerformed(ActionEvent e){
		     btnsub_ActionEvent(e);
		    }    
		   }
		  ); 
		  
		  //注册按钮
		  this.btnReset.setBounds(240,170,60,20);
		  this.btnReset.setBorder(null);
		  this.btnReset.setOpaque(false);

		  
		  //最小化按钮
		  this.btnMin.setBounds(250,0,25,25);
		  this.btnMin.addActionListener(new ActionListener()//匿名类实现ActionListener接口
		   {
		    public void actionPerformed(ActionEvent e){
		    	btnMin_ActionEvent(e);
		    }    
		   }
		  ); 
		  
		  //关闭按钮
		  this.btnClose.setBounds(275,0,25,25);
		  this.btnClose.addActionListener(new ActionListener()//匿名类实现ActionListener接口
		   {
		    public void actionPerformed(ActionEvent e){
		    	btnClose_ActionEvent(e);
		    }    
		   }
		  ); 
		  
		  this.pnluser.add(lbluserLogIn);//加载标签到面板
		  this.pnluser.add(lbluserName);
		  this.pnluser.add(lbluserPWD);
		  this.pnluser.add(txtName);
		  this.pnluser.add(pwdPwd);
		  this.pnluser.add(btnSub);
		  this.pnluser.add(btnReset);
		  this.pnluser.add(btnMin);
		  this.pnluser.add(btnClose);
		  this.add(pnluser);//加载面板到框架
		  this.setVisible(true);//设置框架可显  
		 }
		 
		 //登陆
		 public void btnsub_ActionEvent(ActionEvent e){
		  String name = txtName.getText();
		  String pwd = String.valueOf(pwdPwd.getPassword());
		  if(name.equals("")){
			   JOptionPane.showMessageDialog(null,"账号不能为空","错误",JOptionPane.ERROR_MESSAGE);
			   return;
		  }else if (pwd.equals("")){
			   JOptionPane.showMessageDialog(null,"密码不能为空","错误",JOptionPane.ERROR_MESSAGE);
			   return;
		  }else{
			 String result=CheckLoginUtil.chechLogin(name, pwd);
			 if(StringUtil.isEmpty(result)){
				 JOptionPane.showMessageDialog(null,"账号或密码错误","错误",JOptionPane.ERROR_MESSAGE);
				   return;
			 }else{
				 JSONObject 	json = JSONObject.parseObject(result);//fromObject(result);
				 String results = json.getString("success");
				 if("true".equals(results)){
					 EventQueue.invokeLater(new Runnable() {
						public void run() {
							MyPhotoShow window = new MyPhotoShow(txtName.getText());
							//window.setVisible(true);
						}
					});
						this.dispose();//销毁登陆窗口
				 }else{
					 JOptionPane.showMessageDialog(null,"账号或密码错误","错误",JOptionPane.ERROR_MESSAGE);
					   return;
				 }
//				 EventQueue.invokeLater(new Runnable() {
//						public void run() {
//						}
//					});
//				    this.dispose();//销毁登陆窗口
			 }
			
		  }

		 }
		 
		 //注册
		 public void btnreset_ActionEvent(ActionEvent e){
			 OpenBrowserUtil.openURL(CheckLoginUtil.getRegisterUrl());
		 }
		 
		 //关闭
		 public void btnClose_ActionEvent(ActionEvent e){
			 System.exit(0);  
		 }
		 
		 
		 //最小化
		 public void btnMin_ActionEvent(ActionEvent e){
			 setExtendedState(JFrame.ICONIFIED);
		 }
		 
		 public static void main(String[] args){
		  new LoginUi();
		 }
}
