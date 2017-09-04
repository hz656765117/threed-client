package com.hz.ui.myphoto.panel;

import com.hz.ui.myphoto.Label.MypohotoJLabel;
import com.hz.ui.myphoto.constants.MyPhotoConstantsUI;

import javax.swing.*;
import javax.swing.plaf.basic.BasicComboBoxUI;
import java.awt.*;

/**
 * Created by hasee on 2017/9/2.
 * 主体上部面板
 */
public class MainTopPanel extends JPanel {
    //宽度
    private int width;

    public MainTopPanel(int width){
        this.width=width;
        init();
    }

    private void init(){
        this.setLayout(new BorderLayout());

        this.add(searchPanel(),BorderLayout.WEST);
        this.add(categoryPanel(),BorderLayout.CENTER);
        this.add(timePanel(),BorderLayout.EAST);
    }

    private JPanel searchPanel(){
        JPanel panel=new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.LEFT,20,10));
        JLabel searchPic= new MypohotoJLabel(MyPhotoConstantsUI.USER_PIC_PATH);
        JTextField searchField =new JTextField(35);
        panel.add(searchPic);
        panel.add(searchField);
        return panel;
    }

    private JPanel categoryPanel(){
        JPanel panel=new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER,20,15));
        JButton allButton =new JButton("全部");
        allButton.setContentAreaFilled(false);
        JButton freeButton =new JButton("免费");
        freeButton.setContentAreaFilled(false);
        JButton payButton=new JButton("付费");
        payButton.setContentAreaFilled(false);
        panel.add(allButton);
        panel.add(freeButton);
        panel.add(payButton);
        return panel;
    }


    private JPanel timePanel(){
        JPanel panel=new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.LEFT,20,15));
        JComboBox timeBox=new JComboBox(new String []{"今天","一天前","三天前","半个月前"});
        timeBox.setOpaque(false);
        timeBox.setUI(new BasicComboBoxUI() {

            public void installUI(JComponent comboBox) {

                super.installUI(comboBox);

                //listBox.setForeground(Color.WHITE);

                //listBox.setSelectionBackground(new Color(0,0,0,0));

                //listBox.setSelectionForeground(Color.BLACK);

            }
            /**

             * 该方法返回右边的按钮

             */

            protected JButton createArrowButton() {

                return super.createArrowButton();

            }

        });
        panel.add(timeBox);
        return panel;
    }

}
