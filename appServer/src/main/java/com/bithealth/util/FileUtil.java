package com.bithealth.util;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.log4j.Logger;
import sun.misc.BASE64Encoder;

public class FileUtil {
	
	private static Logger logger = Logger.getLogger(FileUtil.class);
	

	 /** 
	 * @Title: feadFileToString 
	 * @Description: 将文件转换成字符串 
	 * @param filePath
	 * @return    
	 * @retrun String
	 * @throws Exception 
	 */
	public static String feadFileToString(String filePath) throws Exception{
        InputStream in = null;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try {
            // 一次读多个字节
            byte[] tempbytes = new byte[512];
            int byteread = 0;
            in = new FileInputStream(filePath);
            BASE64Encoder encoder = new BASE64Encoder(); 
            while ((byteread = in.read(tempbytes)) != -1) {
            	out.write(tempbytes, 0, byteread);
            }
            return encoder.encode(out.toByteArray());
        } catch (Exception e) {
        	logger.error("文件读取异常。"+e);
        	throw new Exception();
        } finally {
        	close(in,out);
        }
	}
	
	
	private static void close(InputStream in,OutputStream out){
		try{
			if(out != null ){
				out.close();
			}
			if(in != null){
				in.close();
			}
		}catch(Exception e){
		}
	}

	
}
