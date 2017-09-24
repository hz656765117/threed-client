package com.hz.ui.myphoto.control;

import com.hz.ui.myphoto.bean.PhotoBean;
import com.hz.ui.myphoto.data.PhotoData;
import com.hz.ui.myphoto.panel.MainPanel;

import javax.swing.*;
import java.util.ArrayList;

/**
 * Created by hasee on 2017/9/20.
 */
public class AppControl {

    private MainPanel mainPanel;

    private static AppControl appControl=new AppControl();

    public static AppControl instance(){
        return appControl;
    }

    public MainPanel getMainPanel() {
        return mainPanel;
    }

    public void setMainPanel(MainPanel mainPanel) {
        this.mainPanel = mainPanel;
    }

    public void update(){
        mainPanel.updateData();
    }


}
