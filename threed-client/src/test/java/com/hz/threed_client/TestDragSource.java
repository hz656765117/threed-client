package com.hz.threed_client;

import java.awt.Cursor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DragGestureEvent;
import java.awt.dnd.DragGestureListener;
import java.awt.dnd.DragSource;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

public class TestDragSource  
{  
    JFrame jf = new JFrame("Swing的拖放支持");  
    JLabel srcLabel = new JLabel( );  
    public void init()  
    {  
        DragSource dragSource = DragSource.getDefaultDragSource();  
        //将srcLabel转换成拖放源，它能接受复制、移动两种操作  
        dragSource.createDefaultDragGestureRecognizer(srcLabel,  
            DnDConstants.ACTION_COPY_OR_MOVE, new DragGestureListener()  
            {  
                public void dragGestureRecognized(DragGestureEvent event)  
                {    
                    //将JLabel里的文本信息包装成Transferable对象  
                    String txt = srcLabel.getText();  
                    Icon icon = srcLabel.getIcon();  
//                   Transferable transferable = new DataSelection(icon);  
                    Transferable transferable = new StringSelection(txt);  
                    
                    //继续拖放操作,拖放过程中使用手状光标  
                    event.startDrag(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR),   
                        transferable);  
                    
                    event.startDrag(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR), transferable);
                }  
            });  
        
        ImageIcon ICON_DATABASE = new ImageIcon( "F:\\spring-overview.png" );
        srcLabel.setIcon(ICON_DATABASE);
        srcLabel.setText("eeeeeee");
        jf.add(new JScrollPane(srcLabel));  
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        jf.pack();  
        jf.setVisible(true);  
    }  
    public static void main(String[] args)   
    {  
        new TestDragSource().init();  
    }  
} 