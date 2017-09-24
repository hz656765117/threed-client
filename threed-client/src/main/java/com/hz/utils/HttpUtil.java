package com.hz.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.SecureRandom;
import java.util.Iterator;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;


import org.apache.commons.httpclient.DefaultHttpMethodRetryHandler;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.alibaba.fastjson.JSONObject;

public class HttpUtil {

	private static Log log = LogFactory.getLog(HttpUtil.class);

	/**
	 * http请求
	 * 
	 * @param url
	 *            请求地址
	 * @param charset
	 *            字符编码
	 * @param params
	 *            传递参数
	 * @return 網頁源代碼
	 */
	public static Object post(String url, String charset, Map params) {
		HttpClient client = new HttpClient();
		
		PostMethod method = new PostMethod(url);
		// 设置参数
		if (params != null) {
			Iterator it = params.entrySet().iterator();
			while (it.hasNext()) {
				Map.Entry entry = (Map.Entry) it.next();
				String _n = entry.getKey().toString();
				String _v = entry.getValue().toString();
				method.addParameter(_n, _v);
			}
		}
		method.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET,
				charset);
		method.getParams().setParameter(HttpMethodParams.RETRY_HANDLER,
				new DefaultHttpMethodRetryHandler(3, false));
		try {
			int statusCode = client.executeMethod(method);
			method.getParams().setParameter(
					HttpMethodParams.HTTP_CONTENT_CHARSET, charset);
			if (statusCode != HttpStatus.SC_OK
					&& statusCode != HttpStatus.SC_MOVED_TEMPORARILY) {
			}
			byte[] responseBody = method.getResponseBody();
			return new String(responseBody, charset);
		} catch (HttpException e) {
		} catch (IOException e) {
		} finally {
			method.releaseConnection();
		}
		return null;
	}

	public static String get(String url) {
		String sCurrentLine = "";
		String sTotalString = "";
		try {
			URL l_url = new URL(url);
			HttpURLConnection l_connection = (HttpURLConnection) l_url
					.openConnection();
			/*
			 * l_connection.setRequestProperty("x-up-calling-line-id",
			 * "18958003200");
			 * l_connection.setRequestProperty("HTTP_X_UP_BEAR_TYPE", "gprs");
			 * l_connection.setRequestProperty("Accept", "vnd.wap.wml");
			 */
			l_connection.connect();
			InputStream l_urlStream;
			l_urlStream = l_connection.getInputStream();
			BufferedReader l_reader = new BufferedReader(new InputStreamReader(
					l_urlStream, "utf-8"));
			// sCurrentLine = l_reader.readLine();
			while ((sCurrentLine = l_reader.readLine()) != null) {
				sTotalString += sCurrentLine + "\r\n";
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sTotalString;
	}

	/**
	 * 检验登陆姓名和密码
	 * @param name
	 * @param pwd
	 * @return
	 */
	public static String getServerResult(String url){
		
		String resultStr = "";
		
		try {
			//获取登陆检验路径
			
			PostMethod postMethod = new PostMethod(url);
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
	
}
