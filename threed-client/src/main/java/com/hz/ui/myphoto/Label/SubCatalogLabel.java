package com.hz.ui.myphoto.Label;

import com.hz.ui.myphoto.control.AppControl;
import com.hz.ui.myphoto.data.PhotoData;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by hasee on 2017/9/2.
 * 子目录标签
 */
public class SubCatalogLabel extends JLabel implements MouseListener {

    private AppControl appControl=AppControl.instance();

    private String catalogId;
    public SubCatalogLabel(String text){
        this.setText(text);
        this.setForeground(Color.WHITE);
        this.setHorizontalTextPosition(JLabel.CENTER);
        this.addMouseListener(this);
    }
    public SubCatalogLabel(String text,String catalogId){
    	this.setCatalogId(catalogId);
        this.setText(text);
        this.setForeground(Color.WHITE);
        this.setHorizontalTextPosition(JLabel.CENTER);
        this.addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO: 2017/9/2 这里写具体的子目录点击之后的操作，对数据的处理，比如植物下的某个子级目录的点击加载数据等。
        JLabel label= (JLabel) e.getComponent();
        String text=label.getText().toString();
        PhotoData.setType(text);
        PhotoData.setCatalogId(this.getCatalogId());
        appControl.update();
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
	public String getCatalogId() {
		return catalogId;
	}
	public void setCatalogId(String catalogId) {
		this.catalogId = catalogId;
	}
    
    
}
