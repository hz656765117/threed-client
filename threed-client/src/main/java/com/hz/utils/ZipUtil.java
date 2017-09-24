package com.hz.utils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

import org.apache.commons.io.IOUtils;




 
 
 

/** 
 * 通过Java的Zip输入输出流实现压缩和解压文件
 * @author huangzhuo
 *
 */
public final class ZipUtil {
 

    private static String sepa = java.io.File.separator;
 
    private ZipUtil() {
        // empty
    }
 
    /**
     * 压缩文件
     * 
     * @param filePath
     *            待压缩的文件路径
     * @return 压缩后的文件
     */
    public static File zip(String filePath) {
        File target = null;
        File source = new File(filePath);
        if (source.exists()) {
            // 压缩文件名=源文件名.zip
            String zipName = source.getName() + ".zip";
            target = new File(source.getParent(), zipName);
            if (target.exists()) {
                target.delete(); // 删除旧的文件
            }
            FileOutputStream fos = null;
            ZipOutputStream zos = null;
            try {
                fos = new FileOutputStream(target);
                zos = new ZipOutputStream(new BufferedOutputStream(fos));
                // 添加对应的文件Entry
                addEntry("/", source, zos);
            } catch (IOException e) {
                throw new RuntimeException(e);
            } finally {
            	IOUtils.closeQuietly(zos);
            	IOUtils.closeQuietly(fos);
            }
        }
        return target;
    }
 
    /**
     * 扫描添加文件Entry
     * 
     * @param base
     *            基路径
     * 
     * @param source
     *            源文件
     * @param zos
     *            Zip文件输出流
     * @throws IOException
     */
    private static void addEntry(String base, File source, ZipOutputStream zos)
            throws IOException {
        // 按目录分级，形如：/aaa/bbb.txt
        String entry = base + source.getName();
        if (source.isDirectory()) {
            for (File file : source.listFiles()) {
                // 递归列出目录下的所有文件，添加文件Entry
                addEntry(entry + "/", file, zos);
            }
        } else {
            FileInputStream fis = null;
            BufferedInputStream bis = null;
            try {
                byte[] buffer = new byte[1024 * 10];
                fis = new FileInputStream(source);
                bis = new BufferedInputStream(fis, buffer.length);
                int read = 0;
                zos.putNextEntry(new ZipEntry(entry));
                while ((read = bis.read(buffer, 0, buffer.length)) != -1) {
                    zos.write(buffer, 0, read);
                }
                zos.closeEntry();
            } finally {
            	IOUtils.closeQuietly(bis);
            	IOUtils.closeQuietly(fis);
            }
        }
    }
 
    /**
     * 解压文件
     * 
     * @param filePath
     *            压缩文件路径
     */
    public static void unzip(String filePath) {
        File source = new File(filePath);
        if (source.exists()) {
            ZipInputStream zis = null;
            BufferedOutputStream bos = null;
            try {
                zis = new ZipInputStream(new FileInputStream(source));
                ZipEntry entry = null;
                
                while ((entry = zis.getNextEntry()) != null ) {
                    File target = new File(source.getParent(), entry.getName());
                    if (!target.getParentFile().exists()) {
                        // 创建文件父目录
                        target.getParentFile().mkdirs();
                    }
                    // 写入文件
                    bos = new BufferedOutputStream(new FileOutputStream(target));
                    int read = 0;
                    byte[] buffer = new byte[1024 * 10];
                    while ((read = zis.read(buffer, 0, buffer.length)) != -1) {
                        bos.write(buffer, 0, read);
                    }
                    bos.flush();
                }
                zis.closeEntry();
            } catch (IOException e) {
                throw new RuntimeException(e);
            } finally {
            	IOUtils.closeQuietly(zis);
            	IOUtils.closeQuietly(bos);
            }
        }
    }
    
    
    
    
    
    
    
    /** 
     * 解压到指定目录 
     * @param zipPath 
     * @param descDir 
     * @author isea533 
     */  
//    public static void unZipFiles(String zipPath,String descDir,String fileName)throws IOException{  
//        unZipFiles(new File(zipPath), descDir, fileName);  
//    }  
    /** 
     * 解压文件到指定目录 
     * @param zipFile 
     * @param descDir 
     * @author isea533 
     */  
    @SuppressWarnings("rawtypes")  
    public static void unZipFiles(File zipFile,String descDir,String fileName)throws IOException{  
        File pathFile = new File(descDir);  
        if(!pathFile.exists()){  
            pathFile.mkdirs();  
        }  
        ZipFile zip = new ZipFile(zipFile);  
        for(Enumeration entries = zip.entries();entries.hasMoreElements();){  
            ZipEntry entry = (ZipEntry)entries.nextElement();  
            String zipEntryName = entry.getName();  
            InputStream in = zip.getInputStream(entry);  
            String outPath =  (descDir+ sepa +zipEntryName);
           
            //判断路径是否存在,不存在则创建文件路径  
//            File file = new File(outPath.substring(0, outPath.lastIndexOf('/')));  
//            if(!file.exists()){  
//                file.mkdirs();  
//            }  
            //判断文件全路径是否为文件夹,如果是上面已经上传,不需要解压  
           boolean index=zipEntryName.indexOf(".")>0?true:false;
            if( !index){   
                continue;  
            }  
            //输出文件路径信息  
            outPath=outPath.replace("/", "\\");
           String newzipEntryName=zipEntryName.substring(zipEntryName.lastIndexOf('.'),zipEntryName.length());
            String newFileName=descDir+File.separator+fileName+newzipEntryName;
              
            OutputStream out = new FileOutputStream(newFileName);  
            byte[] buf1 = new byte[1024];  
            int len;  
            while((len=in.read(buf1))>0){  
                out.write(buf1,0,len);  
            }  
            in.close();  
            out.close();  
            }  
    }  
    
 
 
}