package com.hz.utils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.commons.httpclient.methods.StringRequestEntity;

import com.alibaba.fastjson.JSONObject;

public class CheckLoginUtil {
	
	/**
	 * 检验登陆姓名和密码
	 * @param name
	 * @param pwd
	 * @return
	 */
	public static String chechLogin(String name,String pwd){
		
		String resultStr = "";
		if(StringUtil.isEmpty(name) || StringUtil.isEmpty(pwd)){
			return resultStr;
		}
		try {
			//获取登陆检验路径
			String checkLoginUrl=CheckLoginUtil.getCheckLoginUrl();
			
			PostMethod postMethod = new PostMethod(checkLoginUrl+"?username="+name+"&password="+pwd);
			HttpClient client = new HttpClient();
			RequestEntity entity = new StringRequestEntity("", "application/json", "utf-8");
			postMethod.setRequestEntity(entity);
			client.getHttpConnectionManager().getParams().setConnectionTimeout(30 * 1000);
			Integer statusCode = client.executeMethod(postMethod);
			if (statusCode == HttpStatus.SC_OK) {
				resultStr = new String(postMethod.getResponseBodyAsString());
			}
			return resultStr;
		} catch (UnsupportedEncodingException e) {
			return resultStr;
		} catch (HttpException e) {
			return resultStr;
		} catch (IOException e) {
			return resultStr;
		}
	}
	
	public static void main(String[] args) {
		CheckLoginUtil.chechLogin("","");
	}

	/**
	 * 得到注册路径
	 * @return
	 */
	public static String getRegisterUrl(){
		String registerUrl=ProjectConfigUtil.getProperty("project.register.url");
		if(StringUtil.isEmpty(registerUrl)){  //如果配置为空，则默认一个注册页面
			registerUrl="http://3d.tmalld.com/e/member/register/index.php?tobind=0&groupid=1";
			
		}
		return registerUrl;
	}
	
	/**
	 * 得到登陆验证路径
	 * @return
	 */
	public static String getCheckLoginUrl(){
		String checkLoginUrl=ProjectConfigUtil.getProperty("project.checkLogin.url");
		if(StringUtil.isEmpty(checkLoginUrl)){  //如果配置为空，则默认一个登陆验证路径
			checkLoginUrl="http://39.108.216.43:8088/login/login";
			
		}
		return checkLoginUrl;
	}
}
