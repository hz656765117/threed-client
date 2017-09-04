package com.hz.ui.myphoto.bean;

import java.util.List;
import java.util.Map;

public class CatalogBean {
	private  List<String> catalogType;  //目录类型
	private  Map<String,List<String>> map; //目录具体名称
	public List<String> getCatalogType() {
		return catalogType;
	}
	public void setCatalogType(List<String> catalogType) {
		this.catalogType = catalogType;
	}
	public Map<String, List<String>> getMap() {
		return map;
	}
	public void setMap(Map<String, List<String>> map) {
		this.map = map;
	}
	
	

}
