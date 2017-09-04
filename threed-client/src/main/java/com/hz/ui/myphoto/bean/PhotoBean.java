package com.hz.ui.myphoto.bean;

/**
 * Created by hasee on 2017/9/2.
 */
public class PhotoBean {

    private int width;
    private int imageheight;
    private int infoheight;
    private String name;
    private String imagePath;
    private String chargeType="免费";

    public int getImageheight() {
        return imageheight;
    }

    public void setImageheight(int imageheight) {
        this.imageheight = imageheight;
    }

    public int getInfoheight() {
        return infoheight;
    }

    public void setInfoheight(int infoheight) {
        this.infoheight = infoheight;
    }

    public String getChargeType() {
        return chargeType;
    }

    public void setChargeType(String chargeType) {
        this.chargeType = chargeType;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
}
