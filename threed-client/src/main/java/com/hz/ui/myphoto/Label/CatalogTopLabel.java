package com.hz.ui.myphoto.Label;

import com.hz.ui.myphoto.constants.MyPhotoConstantsUI;
import com.hz.ui.myphoto.panel.CatalogItemPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by hasee on 2017/9/2.
 * 顶级目录标签
 */
public class CatalogTopLabel extends JLabel implements MouseListener{

    private boolean isDrop=false;

    private CatalogItemPanel father;

    public void setFather(CatalogItemPanel father){
        this.father=father;
    }

    public CatalogTopLabel(int _width, String text,CatalogItemPanel father){
        this.father=father;
        ImageIcon image = new ImageIcon(MyPhotoConstantsUI.PHOTO_TEST_ARROW1);
        int width=image.getIconWidth();
        int height=image.getIconHeight();
        image.setImage(image.getImage().getScaledInstance(width,height, Image.SCALE_DEFAULT));
        this.setSize(_width,height);
        this.setText(text);
        this.setForeground(Color.WHITE);
        this.setHorizontalTextPosition(JLabel.LEFT);
        this.setIcon(image);
        this.addMouseListener(this);
    }

    public CatalogTopLabel(String text){
        this.setText(text);
        this.setForeground(Color.WHITE);
        this.setHorizontalTextPosition(JLabel.CENTER);
    }


    public void setHoldSubCatalogIcon(){
        this.setIcon(null);
        ImageIcon image= new ImageIcon(MyPhotoConstantsUI.PHOTO_TEST_ARROW1);
        int width=image.getIconWidth();
        int height=image.getIconHeight();
        image.setImage(image.getImage().getScaledInstance(width,height, Image.SCALE_DEFAULT));
        this.setIcon(image);
        this.repaint();
    }




    @Override
    public void paint(Graphics g) {
        super.paint(g);

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        this.setIcon(null);
        isDrop=!isDrop;
        ImageIcon image;
        if(isDrop){
            image = new ImageIcon(MyPhotoConstantsUI.PHOTO_TEST_ARROW2);
        }else {
            image = new ImageIcon(MyPhotoConstantsUI.PHOTO_TEST_ARROW1);
        }
        int width=image.getIconWidth();
        int height=image.getIconHeight();
        image.setImage(image.getImage().getScaledInstance(width,height, Image.SCALE_DEFAULT));
        this.setIcon(image);
        this.repaint();

        if(isDrop){
            this.father.sendMsgToOtherCatalogHold();
            this.father.addAllSubCatalog();
        }else{
            this.father.holdAllSubCatalog();
        }

    }





    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
