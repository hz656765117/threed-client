package com.hz.ui.myphoto.panel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;


import com.hz.ui.ConstantsUI;
import com.hz.ui.myphoto.Label.MypohotoJLabel;
import com.hz.ui.myphoto.bean.CatalogBean;
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
	 * 添加组件
	 */
	private void addComponent(JFrame frame) {

		this.add(getCatalogPanel(frame));

	}
	
	/**
	 * 用户面板
	 * 
	 * @return
	 */
	private JPanel getCatalogPanel(JFrame frame) {
		int windowWide=(int) frame.getSize().getWidth();
    	int windowHeight=(int) frame.getSize().getHeight();
		ImageIcon image = new ImageIcon(MyPhotoConstantsUI.PHOTO_TEST_BACKGOUND1); 
		image.setImage(image.getImage().getScaledInstance(MyPhotoConstantsUI.CALALOG_WIDTH,windowHeight,Image.SCALE_DEFAULT)); 
		//设置背景图片
		final JPanel catalogPanel =  new JPanel(){
			             public void paintComponent(Graphics g) {
				                ImageIcon icon =
				                         new ImageIcon(MyPhotoConstantsUI.PHOTO_TEST_BACKGOUND1);
			                // 图片随窗体大小而变化
				                g.drawImage(icon.getImage(), 0, 0, this.getSize().width,this.getSize().height,this);
				            }
				    };
		

    	catalogPanel.setLocation(MyPhotoConstantsUI.CALALOG_X, MyPhotoConstantsUI.CALALOG_Y);
    	catalogPanel.setPreferredSize(new Dimension(MyPhotoConstantsUI.CALALOG_WIDTH,windowHeight));
    	GridBagLayout layout = new GridBagLayout(); 
    	catalogPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 10)); 
    	
    	GridBagConstraints s= new GridBagConstraints();//定义一个GridBagConstraints， 

		//登陆部分
		userLabel=new MypohotoJLabel(60,60,MyPhotoConstantsUI.USER_PIC_PATH);
		catalogPanel.add(userLabel);
		userName=new MypohotoJLabel("linglilillll",SwingConstants.CENTER,Color.WHITE);
		catalogPanel.add(userName);

		//
		JLabel catalog2=new MypohotoJLabel(50,50,MyPhotoConstantsUI.CATALOG_BENDI);
		catalogPanel.add(catalog2);
		JLabel catalog3=new MypohotoJLabel(50,50,MyPhotoConstantsUI.CATALOG_YUN);
		catalogPanel.add(catalog3);
//		
//		JLabel catalog4=new MypohotoJLabel("自定义选项项项",SwingConstants.CENTER,Color.WHITE);
//		catalogPanel.add(catalog4);		
//		JLabel catalog10=new MypohotoJLabel(MyPhotoConstantsUI.PHOTO_TEST_ARROW1);
//		catalogPanel.add(catalog10);
		
		catalogPanel.setBackground(Color.GRAY);
		
		analysisXml(catalogPanel);
		return catalogPanel;
	}
	
	private void analysisXml(final JPanel catalogPanel){
		 try {
			SAXReader sax=new SAXReader();//创建一个SAXReader对象  
			 File xmlFile=new File(MyPhotoConstantsUI.CALALOG_XML_PATH);//根据指定的路径创建file对象  
			 Document document=sax.read(xmlFile);//获取document对象,如果文档无节点，则会抛出Exception提前结束  
			 Element root=document.getRootElement();//获取根节点  
			 CatalogBean catalogBean= this.getNodes(root);//从根节点开始遍历所有节点  
			 final List<String> catalogTypeList=catalogBean.getCatalogType();
			 final Map<String,List<String>> map=catalogBean.getMap();
			 if(catalogTypeList.size()>0){
				 for(final String catalogType:catalogTypeList){
					    JLabel catalog9=new MypohotoJLabel(catalogType,SwingConstants.CENTER,Color.WHITE);
						catalogPanel.add(catalog9);
						
						JLabel catalog11=new MypohotoJLabel(MyPhotoConstantsUI.PHOTO_TEST_ARROW1);
						catalog11.addMouseListener(new MouseAdapter() {
							public void mouseClicked(MouseEvent evt) {
								addCatalog(evt,catalogPanel,catalogType,map,catalogTypeList);
							}
						});
						catalogPanel.add(catalog11);
				 }
			 }
				JLabel catalog4=new MypohotoJLabel("自定义选项项",SwingConstants.CENTER,Color.WHITE);
				catalogPanel.add(catalog4);	
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
    /** 
	* 从指定节点开始,递归遍历所有子节点 
	* @author chenleixing 
	*/  
	public CatalogBean getNodes(Element node){  
	  CatalogBean catalogBean=new CatalogBean(); 
	  List<String> catalogLong=new ArrayList<String>();
	  Map<String,List<String>> map=new HashMap<String,List<String>>();
	  Iterator iter = node.elementIterator("type"); // 获取根节点下的子节点head
	  while (iter.hasNext()) {
		  List<String> content=new ArrayList<String>();
		  Element recordEle = (Element) iter.next();
		  String catalogType= recordEle.attribute("editor").getValue();
		  if(catalogType.length()>7){
			  catalogType=catalogType.substring(0,7);
		  }else if(catalogType.length()<7){
			  int i=7-catalogType.length();
			  for(int j=0;j<i;j++){
				  catalogType+=" ";
			  }
		  }
		  catalogLong.add(catalogType);
		  Iterator iters = recordEle.elementIterator("typeVale"); // 获取子节点head下的子节点script
		  while (iters.hasNext()) {
			  Element recordEle2 = (Element) iters.next();
			  String catalogContent="  "+recordEle2.getTextTrim();
			  
			  if(catalogContent.length()>10){
				  catalogContent=catalogContent.substring(0,10);
			  }else if(catalogContent.length()<10){
				  int i=6-catalogContent.length();
				  for(int j=0;j<i;j++){
					  catalogContent+=" ";
				  }
			  }
			  
			  content.add(catalogContent);
			
		  }
		  map.put(catalogType, content);
	  }
	  
	  catalogBean.setCatalogType(catalogLong);
	  catalogBean.setMap(map);
	  return catalogBean;
	}  


	private void addCatalog(MouseEvent evt,final JPanel catalogPanel,String contentType,final Map<String,List<String>> map,final List<String> catalogTypeList){
		catalogPanel.removeAll(); //清空组件
		catalogPanel.add(userLabel);
		catalogPanel.add(userName);
		JLabel catalog2=new MypohotoJLabel(50,50,MyPhotoConstantsUI.CATALOG_BENDI);
		catalogPanel.add(catalog2);
		JLabel catalog3=new MypohotoJLabel(50,50,MyPhotoConstantsUI.CATALOG_YUN);
		catalogPanel.add(catalog3);
		
		if(catalogTypeList.size()>0){
			for(final String catalogType:catalogTypeList){
				if(contentType.equals(catalogType)){
					JLabel catalog9=new MypohotoJLabel(catalogType,SwingConstants.CENTER,Color.WHITE);
					catalogPanel.add(catalog9);
					
					JLabel catalog11=new MypohotoJLabel(MyPhotoConstantsUI.PHOTO_TEST_ARROW1);
					catalog11.addMouseListener(new MouseAdapter() {
						public void mouseClicked(MouseEvent evt) {
							addCatalog(evt,catalogPanel,catalogType,map,catalogTypeList);
						}
					});
					
					catalogPanel.add(catalog11);
					
					List<String> catalogContentList=map.get(contentType);
					if(catalogContentList.size()>0){
						for(String catalogContent:catalogContentList){
							JLabel catalog7=new MypohotoJLabel(catalogContent,SwingConstants.CENTER,Color.WHITE);
							catalogPanel.add(catalog7);
							
							JLabel catalog8=new MypohotoJLabel(MyPhotoConstantsUI.PHOTO_TEST_ARROW1);
							catalogPanel.add(catalog8);														
						}
					}
					
				}else{
					JLabel catalog9=new MypohotoJLabel(catalogType,SwingConstants.CENTER,Color.WHITE);
					catalogPanel.add(catalog9);
					
					JLabel catalog11=new MypohotoJLabel(MyPhotoConstantsUI.PHOTO_TEST_ARROW1);
					catalog11.addMouseListener(new MouseAdapter() {
						public void mouseClicked(MouseEvent evt) {
							addCatalog(evt,catalogPanel,catalogType,map,catalogTypeList);
						}
					});
					catalogPanel.add(catalog11);
				}	
		   }
		}	
		JLabel catalog4=new MypohotoJLabel("自定义选项项",SwingConstants.CENTER,Color.WHITE);
		catalogPanel.add(catalog4);		
		catalogPanel.validate(); //刷新
	}




}


