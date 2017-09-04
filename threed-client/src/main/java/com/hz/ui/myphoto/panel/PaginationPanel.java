package com.hz.ui.myphoto.panel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

/**
 * Created by hasee on 2017/9/3.
 */
public class PaginationPanel extends JPanel implements MouseListener{

    //初始分页按钮
    private int[] pageNums={1,2,3,4};

    //总的分页数
    private int totalPageNum=85;

    //宽度
    private int width;
    //页面选择按钮
    private ArrayList<JButton> pageNumButton=new ArrayList<>();

    //按钮 : ...
    private JButton nextBatchButton;


    public PaginationPanel(int _width) {
        this.width=_width;
        init();
    }


    private void init(){
//        this.setPreferredSize(new Dimension(this.width,0));
        this.setLayout(new FlowLayout(FlowLayout.CENTER,10,5));

        //根据总的页面数去创建按钮
        addPageButton();

        this.add(new JLabel("共"+totalPageNum+"页"));

        addPageJumpButton();

    }

    /**
     * 页面跳转按钮
     */
    private void addPageJumpButton(){
        JPanel jPanel=new JPanel();
        jPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        jPanel.add(new JLabel("到第"));
        jPanel.add(new JTextField(3));
        jPanel.add(new JLabel("页"));
        this.add(jPanel);
        JButton button=new JButton("确定");
        this.add(button);
        button.addMouseListener(this);
    }


    /**
     * 添加页面选择按钮
     */
    private void addPageButton(){
        ArrayList<JButton> buttons=  createPageButtons();
        for (JButton button:buttons) {
            button.addMouseListener(this);
            this.add(button);
        }
    }


    /**
     * 获取页面选择按钮
     * @return
     */
    private java.util.ArrayList<JButton> createPageButtons(){
        ArrayList<JButton> buttons=new ArrayList<>();
        for (int idx:pageNums) {
            JButton button=new JButton(""+idx);
            button.setBackground(Color.white);
            buttons.add(button);
            pageNumButton.add(button);
        }

        nextBatchButton=new JButton("...");
        nextBatchButton.setBackground(Color.white);
        buttons.add(nextBatchButton);

        JButton button=new JButton(""+totalPageNum);
        button.setBackground(Color.white);
        buttons.add(button);

        button=new JButton("下一页");
        button.setBackground(Color.white);
        buttons.add(button);

        button=new JButton("末页");
        button.setBackground(Color.white);
        buttons.add(button);

        return buttons;
    }


    private void updatePageButton(){
        for(int i=0;i<pageNumButton.size();i++){
            pageNumButton.get(i).setText(""+pageNums[i]);
        }
    }


    private void nextBatchPage(){
        int nextPageMaxNum=pageNums[3]+4;
        if (nextPageMaxNum<totalPageNum){
            pageNums=new int[]{nextPageMaxNum-3,nextPageMaxNum-2,nextPageMaxNum-1,nextPageMaxNum};
        }else if(nextPageMaxNum>=totalPageNum){
            pageNums=new int[]{totalPageNum-3,totalPageNum-2,totalPageNum-1,totalPageNum};
        }
    }



    @Override
    public void mouseClicked(MouseEvent e) {
       JButton button= (JButton) e.getComponent();
       String text=button.getText();
       if(text.equals("...")){
           nextBatchPage();
           updatePageButton();
       }
       System.out.println("text="+text);
       this.repaint();

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
