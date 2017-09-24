package com.hz.ui.myphoto.panel;

import com.hz.ui.myphoto.bean.PhotoBean;
import com.hz.ui.myphoto.data.PhotoData;
import com.hz.ui.myphoto.layout.VFlowLayout;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by hasee on 2017/9/2.
 * 主体面板：右边
 * 包含：搜索面板和展示面板
 */
public class MainPanel extends JPanel {

    private int width;
    private int height;

    private JPanel photoinfo;
    private MainTopPanel topPanel;


    public MainPanel(int _width,int _heigth){
        this.width=_width;
        this.height=_heigth;
        init();
        setVisible(true);
    }

    private void init(){
        this.setPreferredSize(new Dimension(this.width,this.height));
        this.setLayout(new BorderLayout());
        topPanel=new MainTopPanel(this.width);
        this.add(topPanel,BorderLayout.NORTH);

        MainPhotoPanel photoPanel=new MainPhotoPanel(this.width-35,this.height-topPanel.getHeight()-120);
        photoPanel.setData(PhotoData.search());
        photoPanel.init();
        photoinfo=new JPanel();
        photoinfo.add(photoPanel);
        this.add(photoinfo,BorderLayout.CENTER);

        PaginationPanel paginationPanel=new PaginationPanel(this.width-35);
        JPanel panel=new JPanel();
        panel.add(paginationPanel);
        this.add(panel,BorderLayout.SOUTH);

    }

    @Override
    public void paint(Graphics g) {
        setSize(this.width,this.height);
        super.paint(g);
    }

    public void updateData(){
        this.photoinfo.removeAll();
        this.photoinfo.setVisible(false);
        this.addCom();
        this.photoinfo.revalidate();
        this.photoinfo.setVisible(true);
    }

    public void addCom(){
        MainPhotoPanel photoPanel=new MainPhotoPanel(this.width-35,this.height-topPanel.getHeight()-120);
        photoPanel.setData(PhotoData.search());
        photoPanel.init();
        photoinfo.add(photoPanel);
    }


}
