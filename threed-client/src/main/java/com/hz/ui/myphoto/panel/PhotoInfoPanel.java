package com.hz.ui.myphoto.panel;

import com.hz.ui.myphoto.bean.PhotoBean;
import com.hz.ui.myphoto.layout.VFlowLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseListener;

/**
 * Created by hasee on 2017/9/3.
 * 图片信息展示面板
 */
public class PhotoInfoPanel extends JPanel {

    //要展示的图片信息
    private PhotoBean photoBean;

    public PhotoInfoPanel(PhotoBean photoBean) {
        this.photoBean = photoBean;
        init();
    }


    private void init(){
        this.setPreferredSize(new Dimension(photoBean.getWidth(),photoBean.getImageheight()+photoBean.getInfoheight()));
        this.setLayout(new VFlowLayout());
        addImage();
        addInfo();
    }


    private void addImage(){
        if(photoBean.getWidth()!=0&& photoBean.getImageheight()!=0){
            JLabel label=new JLabel();
            ImageIcon image = new ImageIcon(photoBean.getImagePath());
            image.setImage(image.getImage().getScaledInstance(photoBean.getWidth(),photoBean.getImageheight(),Image.SCALE_DEFAULT));
            label.setIcon(image);
            this.add(label);
        }
    }


    private void addInfo(){
        JPanel jPanel=new JPanel();
        jPanel.setLayout(new GridLayout(1,4));
        jPanel.add(new JLabel(photoBean.getName()));
        jPanel.add(new JLabel(photoBean.getChargeType()));
        jPanel.add(new JLabel("收藏"));
        jPanel.add(new JLabel("下载"));
        this.add(jPanel);
    }


}
