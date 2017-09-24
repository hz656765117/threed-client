package com.hz.utils;

import java.awt.Desktop;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URI;
import java.net.URISyntaxException;

public class OpenBrowserUtil {
	 /** 
     * 打开IE浏览器访问页面 
     */  
    public static void openIEBrowser(String url){  
         //启用cmd运行IE的方式来打开网址。  
        String str = "cmd /c start iexplore "+url;  
        try {  
            Runtime.getRuntime().exec(str);  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
    }  
    /** 
     * 打开默认浏览器访问页面 
     */  
    public static void openDefaultBrowser(String url){  
        //启用系统默认浏览器来打开网址。  
        try {  
            URI uri = new URI(url);  
            Desktop.getDesktop().browse(uri);  
        } catch (URISyntaxException e) {  
            e.printStackTrace();  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
    }  
    
    
    private static void browse(String url) throws Exception { 
     //获取操作系统的名字 
     String osName = System.getProperty("os.name", ""); 
     if (osName.startsWith("Mac OS")) { 
      //苹果的打开方式 
      Class fileMgr = Class.forName("com.apple.eio.FileManager"); 
      Method openURL = fileMgr.getDeclaredMethod("openURL", new Class[] { String.class }); 
      openURL.invoke(null, new Object[] { url }); 
     } else if (osName.startsWith("Windows")) { 
      //windows的打开方式。 
      Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + url); 
     } else { 
      // Unix or Linux的打开方式 
      String[] browsers = { "firefox", "opera", "konqueror", "epiphany", "mozilla", "netscape" }; 
      String browser = null; 
      for (int count = 0; count < browsers.length && browser == null; count++) 
       //执行代码，在brower有值后跳出， 
       //这里是如果进程创建成功了，==0是表示正常结束。 
       if (Runtime.getRuntime().exec(new String[] { "which", browsers[count] }).waitFor() == 0) 
        browser = browsers[count]; 
      if (browser == null) 
       throw new Exception("Could not find web browser"); 
      else
       //这个值在上面已经成功的得到了一个进程。 
       Runtime.getRuntime().exec(new String[] { browser, url }); 
     } 
    } 
    
    public static void openURL(String url) { 
    	  try { 
    	   browse(url); 
    	  } catch (Exception e) { 
    	  } 
    } 
  //主方法 测试类
    public static void main(String[] args) {
     // 这里填写你的网址
     String url = "http://3d.tmalld.com/e/member/register/index.php?tobind=0&groupid=1";   
     OpenBrowserUtil.openPhotoShop(); 
    }
    
    public static void openPhotoShop(){
    	 //获取操作系统的名字 
        String osName = System.getProperty("os.name", ""); 
        try {
			if (osName.startsWith("Windows")) { 
			    //windows的打开方式。 
				String[] cmd = {"F:\\photoshop_cs6_33lc\\Adobe Photoshop CS6\\Adobe Photoshop CS6\\Photoshop.exe","F:\\Hydrangeas.jpg"};
			    Runtime.getRuntime().exec(cmd); 
			   }
		} catch (IOException e) {
			e.printStackTrace();
		} 
    }
}
