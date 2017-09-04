package com.hz.ui.myphoto.XmlUtil;

import com.hz.ui.myphoto.bean.CatalogBean;
import com.hz.ui.myphoto.constants.MyPhotoConstantsUI;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.*;

/**
 * Created by hasee on 2017/9/2.
 * 解析目录的xml
 */
public class AnalysisCatalogXml {

    public static CatalogBean analysis(){
        CatalogBean catalogBean=null;
        try {
            SAXReader sax = new SAXReader();//创建一个SAXReader对象
            File xmlFile = new File(MyPhotoConstantsUI.CALALOG_XML_PATH);//根据指定的路径创建file对象
            Document document = sax.read(xmlFile);//获取document对象,如果文档无节点，则会抛出Exception提前结束
            Element root=document.getRootElement();//获取根节点
            catalogBean= getNodes(root);//从根节点开始遍历所有节点
            return catalogBean;
        }catch (Exception e){
            e.printStackTrace();
        }
        return catalogBean;
    }

    /**
     * 从指定节点开始,递归遍历所有子节点
     * @author chenleixing
     */
    public static CatalogBean getNodes(Element node){
        CatalogBean catalogBean=new CatalogBean();
        List<String> catalogLong=new ArrayList<String>();
        Map<String,List<String>> map=new HashMap<String,List<String>>();
        Iterator iter = node.elementIterator("type"); // 获取根节点下的子节点head
        while (iter.hasNext()) {
            List<String> content=new ArrayList<String>();
            Element recordEle = (Element) iter.next();
            String catalogType= recordEle.attribute("editor").getValue();
            if(catalogType.length()>7){
                catalogType=catalogType.substring(0,7);
            }else if(catalogType.length()<7){
                int i=7-catalogType.length();
                for(int j=0;j<i;j++){
                    catalogType+=" ";
                }
            }
            catalogLong.add(catalogType);
            Iterator iters = recordEle.elementIterator("typeVale"); // 获取子节点head下的子节点script
            while (iters.hasNext()) {
                Element recordEle2 = (Element) iters.next();
                String catalogContent="  "+recordEle2.getTextTrim();

                if(catalogContent.length()>10){
                    catalogContent=catalogContent.substring(0,10);
                }else if(catalogContent.length()<10){
                    int i=6-catalogContent.length();
                    for(int j=0;j<i;j++){
                        catalogContent+=" ";
                    }
                }

                content.add(catalogContent);

            }
            map.put(catalogType, content);
        }

        catalogBean.setCatalogType(catalogLong);
        catalogBean.setMap(map);
        return catalogBean;
    }

}
