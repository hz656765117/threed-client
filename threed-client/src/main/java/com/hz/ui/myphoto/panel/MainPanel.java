package com.hz.ui.myphoto.panel;

import com.hz.ui.myphoto.layout.VFlowLayout;

import javax.swing.*;
import java.awt.*;

/**
 * Created by hasee on 2017/9/2.
 * 主体面板：右边
 * 包含：搜索面板和展示面板
 */
public class MainPanel extends JPanel {

    private int width;
    private int height;

    public MainPanel(int _width,int _heigth){
        this.width=_width;
        this.height=_heigth;
        init();
        setVisible(true);
    }

    private void init(){
        this.setPreferredSize(new Dimension(this.width,this.height));
        this.setLayout(new BorderLayout());
        MainTopPanel topPanel=new MainTopPanel(this.width);
        this.add(topPanel,BorderLayout.NORTH);

        MainPhotoPanel photoPanel=new MainPhotoPanel(this.width-35,this.height-topPanel.getHeight()-120);
        JPanel panel=new JPanel();
        panel.add(photoPanel);
        this.add(panel,BorderLayout.CENTER);

        PaginationPanel paginationPanel=new PaginationPanel(this.width);
        panel=new JPanel();
        panel.add(paginationPanel);
        this.add(panel,BorderLayout.SOUTH);

    }

    @Override
    public void paint(Graphics g) {
        setSize(this.width,this.height);
        super.paint(g);
    }
}
