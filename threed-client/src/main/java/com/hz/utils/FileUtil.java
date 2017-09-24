package com.hz.utils;


import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Date;

import org.apache.commons.io.FileUtils;


import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;



 

/**
 * 基本文件函数
 * @author huangzhuo
 *
 */
public class FileUtil extends FileUtils {
    public static long fileCode = 0;
    private static FileOutputStream fs;

    public FileUtil() {

    }

   

    /**
     * 文件分隔符
     * 
     * @return 字符串
     */
    public static String separator() {
        return File.separator;
    }

    /**
     * 复制文件
     * 
     * @param src
     *            String 源文件路径
     * @param dst
     *            String 目标文件路径
     */
    public static void copy(File src, File dst) {
        try {
            InputStream in = new FileInputStream(src);
            OutputStream out = new FileOutputStream(dst);
            // Transfer bytes from in to out
            byte[] buf = new byte[1024];
            int len;
            while ((len = in.read(buf)) > 0) {
                out.write(buf, 0, len);
            }
            in.close();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 创建文件夹
     * 
     * @param fileName
     *            String 文件路径
     * 
     */
    public static boolean mkDir(String fileName) {
        boolean make = false;
        try {
            make = (new File(fileName)).mkdirs();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return make;
    }

    /**
     * 获取文件后缀
     */

    public static String getFileExt(String fileName) {
        if (fileName == null || fileName.equals("")) {
            return "";
        }
        String[] ext = fileName.trim().split("\\.");
        
        return ext.length <=1 ? "" : ext[ext.length - 1].toLowerCase();
    }

    /**
     * 创建写入记事本
     * 
     * @param filePath
     *            String 文件路径
     * 
     * @param txt
     *            String 待写入行字串
     */
    public static void writeTxt(String filePath, String txt) {
        try {
            PrintWriter pw = new PrintWriter(new FileWriter(filePath, true),
                    true);
            pw.println(txt);
            pw.close();
        } catch (Exception e) {
           
        }
    }

    /**
     * 读取文本文件内容
     * 
     * @param filePath
     *            String 文件路径
     * 
     * 
     */
    public static String readTxt(String filePath) {
        String rtn = null;
        File txtFile = new File(filePath);
        FileReader f=null;
        BufferedReader br=null;
        if (!txtFile.exists()) {
            return rtn;
        }

        try {
            f=new FileReader(txtFile);
            br = new BufferedReader(f);
            String s = "";
            StringBuffer sb = new StringBuffer("");
            while ((s = br.readLine()) != null) {
                sb.append(s);
            }
            f.close();
            br.close();
            return sb.toString();
        } catch (IOException e) {
            e.getStackTrace();
        }finally{
            try {
                f.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            try {
                br.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return rtn;
    }

    /**
     * 读取文本文件内容
     * 
     * @param filePath
     *            String 文件路径
     * 
     * 
     */
    public static ArrayList<String> readTxtToArray(String filePath) {
        ArrayList<String> al = new ArrayList<String>();

        File txtFile = new File(filePath);
        if (!txtFile.exists()) {
            return al;
        }

        try {
            BufferedReader br = new BufferedReader(new FileReader(txtFile));
            String s = "";
            // StringBuffer sb = new StringBuffer("");
            while ((s = br.readLine()) != null) {
                al.add(s);
                // sb.append(s + "\r\n");
            }
            br.close();
            // return sb.toString();
        } catch (IOException e) {
            e.getStackTrace();
        }
        return al;
    }


    /**
     * 删除文件
     * 
     * @param filePathAndName
     *            String 文件路径及名称 如c:/fqf.txt
     * @param fileContent
     *            String
     * @return boolean
     */
    public static void delFile(String filePathAndName) {
        try {
            String filePath = filePathAndName;
            filePath = filePath.toString();
            java.io.File myDelFile = new java.io.File(filePath);
            myDelFile.delete();

        } catch (Exception e) {
            e.printStackTrace();

        }

    }



    /**
     * 移动文件到指定目录
     * 
     * @param oldPath
     *            String 如：c:/fqf.txt
     * @param newPath
     *            String 如：d:/fqf.txt
     */
    public static void moveFile(String oldPath, String newPath) {
        copyFile(oldPath, newPath);
        delFile(oldPath);

    }

    /**
     * 复制单个文件
     * 
     * @param oldPath
     *            String 原文件路径 如：c:/fqf.txt
     * @param newPath
     *            String 复制后路径 如：f:/fqf.txt
     * @return boolean
     */
    public static void copyFile(String oldPath, String newPath) {
        try {
            int byteread = 0;
            File oldfile = new File(oldPath);
            if (oldfile.exists()) { // 文件存在时
                InputStream inStream = new FileInputStream(oldPath); // 读入原文件
                fs = new FileOutputStream(newPath);
                byte[] buffer = new byte[1444];
                while ((byteread = inStream.read(buffer)) != -1) {
                    fs.write(buffer, 0, byteread);
                }
                inStream.close();
            }
        } catch (Exception e) {
            e.printStackTrace();

        }

    }
    
    public static int getTotalLines(String filePath) throws IOException {  
        File sourceFile = new File(filePath);
        FileReader in = new FileReader(sourceFile);  
        LineNumberReader reader = new LineNumberReader(in);  
        String s = reader.readLine();  
        int lines = 0;  
       while (s != null) {  
            lines++;  
           s = reader.readLine();  
        }  
        reader.close();  
        in.close();  
        return lines;  
    } 
    
    /**
     * 编辑参数值
     * @param param
     * @param value
     */
    public static void editParamValue(String path,String param,String value) {
        param = param + "=";
        String temp = "";
        try {
            File file = new File(path);
            FileInputStream fis = new FileInputStream(file);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            StringBuffer buf = new StringBuffer();

            // 保存该行前面的内容
            for (int j = 1; (temp = br.readLine()) != null
                    && !temp.contains(param); j++) {
                buf = buf.append(temp);
                buf = buf.append(System.getProperty("line.separator"));
            }
            
            // 将内容插入
            buf = buf.append(param+value);

            // 保存该行后面的内容
            while ((temp = br.readLine()) != null) {
                buf = buf.append(System.getProperty("line.separator"));
                buf = buf.append(temp);
            }

            br.close();
            FileOutputStream fos = new FileOutputStream(file);
            PrintWriter pw = new PrintWriter(fos);
            pw.write(buf.toString().toCharArray());
            pw.flush();
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static String getFileSha1(File file) {
	    if (!file.isFile()) {
	        return null;
	    }
	    MessageDigest digest = null;
	    FileInputStream in = null;
	    byte buffer[] = new byte[8192];
	    int len;
	    try {
	        digest =MessageDigest.getInstance("SHA-1");
	        in = new FileInputStream(file);
	        while ((len = in.read(buffer)) != -1) {
	            digest.update(buffer, 0, len);
	        }
	        BigInteger bigInt = new BigInteger(1, digest.digest());
	        return bigInt.toString(16);
	    } catch (Exception e) {
	        e.printStackTrace();
	        return null;
	    } finally {
	        try {
	            in.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	}
    
    
    
    
    
    
    /**
	 * Str-File
	 */
	public static File getFileByBaseStr(String fileName, String str) {
		try {

			byte[] bytes = new BASE64Decoder().decodeBuffer(str);
//			byte[] bytes = new Base64().decode(str);
			
//			 BASE64Decoder decoder = new BASE64Decoder();  
//			 byte[] bytes = decoder.decodeBuffer(str);  
			
			// 将字符串转换为byte数组//
			// byte[] bytes = Base64Util.decode(str);
			ByteArrayInputStream in = new ByteArrayInputStream(bytes);
			byte[] buffer = new byte[1024];

			File file = new File(fileName);
			FileOutputStream out = new FileOutputStream(file);
			int bytesum = 0;
			int byteread = 0;
			while ((byteread = in.read(buffer)) != -1) {
				bytesum += byteread;
				out.write(buffer, 0, byteread); // 文件写操作
			}
			out.close();

			return file;
		} catch (Exception e) {
			return null;
		}
	}
	
 

	/**
	 * File-Str
	 */
	public static String getBaseStrByFile(File file) {
		try {

			InputStream in = new FileInputStream(file);
			// 返回文件的字节长度
			in.available();
			byte[] bytes = new byte[in.available()];
			// 将文件中的内容读入到数组中
			in.read(bytes);
			 String strBase64 = new BASE64Encoder().encode(bytes); 
//			String strBase64 = new Base64().encode(bytes); //
			// 将字节流数组转换为字符串
			// String strBase64 = Base64Util.encode(bytes);
			in.close();

			return strBase64;
		} catch (Exception e) {
			return null;
		}
	}
	 public static boolean createFile(String destFileName) {  
	        File file = new File(destFileName);  
	        if(file.exists()) {  
	            return false;  
	        }  
	        if (destFileName.endsWith(File.separator)) {  
	            return false;  
	        }  
	        //判断目标文件所在的目录是否存在  
	        if(!file.getParentFile().exists()) {  
	            //如果目标文件所在的目录不存在，则创建父目录  
	            if(!file.getParentFile().mkdirs()) {  
	                return false;  
	            }  
	        }  
	        //创建目标文件  
	        try {  
	            if (file.createNewFile()) {  
	                return true;  
	            } else {  
	                return false;  
	            }  
	        } catch (IOException e) {  
	            e.printStackTrace();  
	            return false;  
	        }  
	    } 
	 
	 
	 // 判断文件是否存在
     public static boolean judeFileExists(File file) {
 
         if (file.exists()) {
             return true;
         } else {
           return false;
         }
 
     }

     // 判断文件是否存在
     public static boolean judeExists(String filePath) {
 
    	 File f = new File(filePath); 
    	    if(f.isDirectory()){ // 首先判断该路径是否是文件夹，如果不是就自己结束吧，此处省略不是文件夹的情况
    	         File[] fileList = f.listFiles();// 得到该文件夹下的所有文件和文件夹列表	
    	         for(File fs : fileList) {  //  循环该列表
		    		if(fs.isFile()) {  // 如果得到的为文件，则提示
		    		    return true;
		    		}
    	       }
    	    }
    	    
    	    return false;
     }
     
     // 获取文件目录下的文件
     public static File getFile(String filePath) {
 
    	 File f = new File(filePath); 
    	    if(f.isDirectory()){ // 首先判断该路径是否是文件夹，如果不是就自己结束吧，此处省略不是文件夹的情况
    	         File[] fileList = f.listFiles();// 得到该文件夹下的所有文件和文件夹列表	
    	         if(fileList.length>0){
    	        	 return fileList[0];
    	         }
    	    }
    	    
    	    return null;
     }

}
