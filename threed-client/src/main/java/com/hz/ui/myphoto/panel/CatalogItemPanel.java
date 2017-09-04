package com.hz.ui.myphoto.panel;

import com.hz.ui.myphoto.Label.CatalogTopLabel;
import com.hz.ui.myphoto.Label.SubCatalogLabel;
import com.hz.ui.myphoto.layout.VFlowLayout;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by hasee on 2017/9/2.
 */
public class CatalogItemPanel extends JPanel {
    //宽度
    private int width;

    //目录名字
    private String CatalogTopName;
    //该目录下的子目录
    private List<String> subCatalogNames;

    //目录标签
    private CatalogTopLabel catalogTopLabel;

    private List<SubCatalogLabel> subCatalogLabels=new ArrayList<>();

    private JPanel father;

    public void setFather(JPanel father) {
        this.father = father;
    }

    public CatalogItemPanel(int width, String catalogTopName, List<String> subCatalogNames){
        this.width=width;
        this.CatalogTopName=catalogTopName;
        this.subCatalogNames=subCatalogNames;
        this.initialization();
    }

    private void initialization(){
        this.setOpaque(false);
        //this.setSize(this.width,this.height);
        this.setLayout(new VFlowLayout(0,0,0,true,false));
        this.catalogTopLabel=new CatalogTopLabel(this.width,CatalogTopName,this);
        this.add(this.catalogTopLabel);
        for (String subcatalogname:subCatalogNames) {
            SubCatalogLabel subCatalogLabel=new SubCatalogLabel(subcatalogname);
            this.subCatalogLabels.add(subCatalogLabel);
        }
    }


    /**
     * 发送消息去通知其他所有目录收起子目录
     */
    public void sendMsgToOtherCatalogHold(){
        int count=this.father.getComponentCount();
        for (int i=0;i<count;i++) {
            Component component=this.father.getComponent(i);
            System.out.println(component.getClass().getName());
            if (component instanceof CatalogItemPanel&&component!=this){
                ((CatalogItemPanel) component).holdAllSubCatalog();
            }
        }
    }

    /**
     * 打开该目录下的子目录
     */
    public void addAllSubCatalog(){
        for (SubCatalogLabel subCatalog:subCatalogLabels) {
            this.add(subCatalog);
        }
    }

    /**
     * 收起该目录下的子目录
     */
    public void holdAllSubCatalog(){
        for (SubCatalogLabel subCatalog:subCatalogLabels) {
            this.remove(subCatalog);
        }
        this.catalogTopLabel.setHoldSubCatalogIcon();
    }

}
