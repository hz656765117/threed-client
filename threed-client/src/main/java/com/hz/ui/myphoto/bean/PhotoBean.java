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
    private String modelPath;
    private String jifen;
    
    private String photoId;
    
    private String imageFilePath;  //下载下来的图片路径
    private String max3dFilePath; //下载下来的3dmax的路径

    public String getModelPath() {
        return modelPath;
    }

    public void setModelPath(String modelPath) {
        this.modelPath = modelPath;
    }

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

	public String getJifen() {
		return jifen;
	}

	public void setJifen(String jifen) {
		this.jifen = jifen;
	}

	public String getPhotoId() {
		return photoId;
	}

	public void setPhotoId(String photoId) {
		this.photoId = photoId;
	}

	public String getImageFilePath() {
		return imageFilePath;
	}

	public void setImageFilePath(String imageFilePath) {
		this.imageFilePath = imageFilePath;
	}

	public String getMax3dFilePath() {
		return max3dFilePath;
	}

	public void setMax3dFilePath(String max3dFilePath) {
		this.max3dFilePath = max3dFilePath;
	}
    
    
}
