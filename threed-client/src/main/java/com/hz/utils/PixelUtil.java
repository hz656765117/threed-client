package com.hz.utils;

import java.awt.*;

/**
 * Created by hasee on 2017/9/1.
 * 用于对不同显示屏像素的转化
 */
public class PixelUtil {

    private static int LOCAL_SCREEN_WIDTH;
    private static int LOCAL_SCREEN_HEIGHT;

    static {
        Dimension dimension=Toolkit.getDefaultToolkit().getScreenSize();
        LOCAL_SCREEN_WIDTH=dimension.width;
        LOCAL_SCREEN_HEIGHT=dimension.height;
    }


    /**
     * 按占全屏宽度百分比计算实际宽度
     * @param precentOfwidth
     * @return
     */
    public static int scaleWidth(float precentOfwidth){

        return (int) (LOCAL_SCREEN_WIDTH*precentOfwidth);
    }

    /**
     * 按占全屏宽度百分比计算实际高度
     * @param precentOfheight
     * @return
     */
    public static int scaleHeight(float precentOfheight){

        return (int) (LOCAL_SCREEN_HEIGHT*precentOfheight);
    }


    public static void main(String[] args) {
        System.out.println(scaleWidth(0.67f));
    }


}
