package com.hz.ui.myphoto.data;

import com.hz.ui.myphoto.bean.PhotoBean;
import com.hz.ui.myphoto.bean.PhotoInfoBean;
import com.hz.ui.myphoto.constants.MyPhotoConstantsUI;
import com.hz.utils.ProjectConfigUtil;
import com.hz.utils.StringUtil;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

/**
 * Created by hasee on 2017/9/20.
 */
public class PhotoData {
    private static String type;
    
    private static String catalogId;
    
    private static String  username;

    public static String getType() {
        return type;
    }

    public static void setType(String type) {
        PhotoData.type = type;
    }

    public static int getPage() {
        return page;
    }

    public static void setPage(int page) {
        PhotoData.page = page;
    }


    public static String getCatalogId() {
		return catalogId;
	}

	public static void setCatalogId(String catalogId) {
		PhotoData.catalogId = catalogId;
	}

	public static String getUsername() {
		return username;
	}

	public static void setUsername(String username) {
		PhotoData.username = username;
	}


	private static int page;

    private static int num=8;



    public static ArrayList<PhotoBean> search(){
        ArrayList<PhotoBean> data=new ArrayList<>();
        if(StringUtil.isEmpty(catalogId)){
        	catalogId="29";
        }
        List<PhotoInfoBean> list=ProjectConfigUtil.showPhotoInfo(catalogId ,"hz"); //用户名暂时写死
        if(list.size()>0){
        	for (int i=0;i<list.size();i++){
                PhotoBean photoBean=new PhotoBean();
                photoBean.setWidth(200);
                photoBean.setImageheight(300);
                photoBean.setInfoheight(30);
                photoBean.setName(list.get(i).getTitle());
                photoBean.setJifen(list.get(i).getJifen());
                //http://3d.tmalld.com/d/file/models/2017-08-24/92c6d65b7c2ac2d4492461576a39d981.jpeg
                //MyPhotoConstantsUI.PHOTO_TEST_SHOW
                photoBean.setImagePath("http://3d.tmalld.com/"+list.get(i).getTitlepic());
                photoBean.setModelPath(MyPhotoConstantsUI.MAX3D_PATH+list.get(i).getId());
                
                photoBean.setImageFilePath(MyPhotoConstantsUI.PHPTO_PATH+list.get(i).getId());
                photoBean.setMax3dFilePath(MyPhotoConstantsUI.MAX3D_PATH+list.get(i).getId());
                photoBean.setPhotoId(list.get(i).getId());
                data.add(photoBean);
            }
        }
//        else{ //查询图片失败
//        	 JOptionPane.showMessageDialog(null,"账号不能为空","错误",JOptionPane.ERROR_MESSAGE);
//        }
//        for (int i=0;i<num;i++){
//            PhotoBean photoBean=new PhotoBean();
//            photoBean.setWidth(200);
//            photoBean.setImageheight(300);
//            photoBean.setInfoheight(30);
//            photoBean.setName("KKKK");
//            //http://3d.tmalld.com/d/file/models/2017-08-24/92c6d65b7c2ac2d4492461576a39d981.jpeg
//            //MyPhotoConstantsUI.PHOTO_TEST_SHOW
//            photoBean.setImagePath("http:\\3d.tmalld.com\\d\\file\\models\\2017-08-24\\92c6d65b7c2ac2d4492461576a39d981.jpeg");
//            photoBean.setModelPath(MyPhotoConstantsUI.MAX_TEST_SHOW);
//            data.add(photoBean);
//        }
        num++;
        return data;
    }

}
