package com.hz.ui.myphoto.bean;

import java.util.List;
import java.util.Map;

public class CatalogBean {
	private List<CatalogInfoBean> catalogInfoFather; //çˆ¶ç›®å½•ä¿¡æ¯
	private  List<String> catalogType;  //ç›®å½•ç±»åž‹
	private  Map<String,List<String []>> map; //ç›®å½•å…·ä½“åç§°
	public List<String> getCatalogType() {
		return catalogType;
	}
	public void setCatalogType(List<String> catalogType) {
		this.catalogType = catalogType;
	}

	public Map<String, List<String[]>> getMap() {
		return map;
	}
	public void setMap(Map<String, List<String[]>> map) {
		this.map = map;
	}
	public List<CatalogInfoBean> getCatalogInfoFather() {
		return catalogInfoFather;
	}
	public void setCatalogInfoFather(List<CatalogInfoBean> catalogInfoFather) {
		this.catalogInfoFather = catalogInfoFather;
	}

	private Map<String,Integer> CatalogNumMap;

	public Map<String, Integer> getCatalogNumMap() {
		return CatalogNumMap;
	}

	public void setCatalogNumMap(Map<String, Integer> catalogNumMap) {
		CatalogNumMap = catalogNumMap;
	}
}
