/**
 * @PackageName:  com.bithealth.fileCore.util
 * @FileName:     FileOperateUtil.java  
 * @Description:  文件操作处理工具类
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      胡翔  
 * @version      V1.0  
 * @Createdate:  2016年6月21日 上午10:44:35  
 * 
 */
package com.bithealth.fileCore.util;

import it.sauronsoftware.jave.AudioAttributes;
import it.sauronsoftware.jave.Encoder;
import it.sauronsoftware.jave.EncoderException;
import it.sauronsoftware.jave.EncodingAttributes;
import it.sauronsoftware.jave.InputFormatException;

import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/**
 * @PackageName: com.bithealth.fileCore.util
 *                * @FileName:     FileOperateUtil.java   * @Description: 
 *               文件操作处理工具类  Copyright:    Copyright(C) 2016-2026   公司:       
 *               深圳中科汇康技术有限公司   @author:     胡翔  
 * @version     V1.0    * @Createdate:  2016年6月21日 上午10:44:35    
 */
public class FileOperateUtil {
	/**
	 * 一次读取的字节数组大小
	 */
	public static final int byteSize = 1024 * 1024;

	/**
	 * @Title:gzip  @Description:将原文件流对象压缩成gzip文件
	 * @author 胡翔
	 * @param 文件字节流数组
	 * @return 返回gzip压缩后的byte数组
	 * @throws IOException
	 */
	public static byte[] gzip(byte[] val) throws IOException {
		try (ByteArrayOutputStream bos = new ByteArrayOutputStream(val.length);
				GZIPOutputStream gos = new GZIPOutputStream(bos)) {
			gos.write(val, 0, val.length);
			gos.finish();
			gos.flush();
			bos.flush();
			val = bos.toByteArray();
		}
		return val;
	}

	/**
	 * @Title:gzip  @Description:将原文件流对象压缩成gzip文件
	 * @author 胡翔
	 * @param in
	 *            文件流对象
	 * @return 返回gzip压缩后的byte数组
	 * @throws IOException
	 */
	public static byte[] gzip(InputStream in) throws IOException {
		try (ByteArrayOutputStream bos = new ByteArrayOutputStream();
				GZIPOutputStream gos = new GZIPOutputStream(bos)) {
			byte[] byteArray = new byte[byteSize];
			int index = 0;
			while ((index = in.read(byteArray)) != -1) {
				gos.write(byteArray, 0, index);
			}
			gos.finish();
			gos.flush();
			bos.flush();
			return bos.toByteArray();
		}
	}

	/**
	 * 将输入流转化为byteArray输出流。需要对同一个InputStream对象读取多次时，可以使用这个方法
	 * 
	 * @Title:getOutputStream 
	 *                         @Description:需要对同一个InputStream对象读取多次时，可以使用这个方法,记得关闭
	 *                        ByteArrayOutputStream流对象
	 * @author 胡翔
	 * @param in
	 * @return byteArray输出流
	 * @throws IOException
	 */
	public static ByteArrayOutputStream getByteArrayOutputStream(InputStream in)
			throws IOException {
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		byte[] buffer = new byte[byteSize];
		int len;
		while ((len = in.read(buffer)) > -1) {
			bos.write(buffer, 0, len);
		}
		bos.flush();
		return bos;
	}

	/**
	 * @Title:unGzip  @Description: 解压gzip文件数据。
	 * @author 胡翔
	 * @param buf
	 *            gzip格式的文件数据
	 * @return 解压后的字节数组
	 * @throws IOException
	 */
	public static byte[] unGzip(byte[] buf) throws IOException {
		try (GZIPInputStream gzi = new GZIPInputStream(
				new ByteArrayInputStream(buf));
				ByteArrayOutputStream bos = new ByteArrayOutputStream(
						buf.length)) {
			int count = 0;
			byte[] tmp = new byte[byteSize];
			while ((count = gzi.read(tmp)) != -1) {
				bos.write(tmp, 0, count);
			}
			bos.flush();
			buf = bos.toByteArray();
		}
		return buf;
	}

	/**
	 * @Title:convertVoice  @Description: AMR文件转成MP3文件
	 * @author
	 * @param gzip文件流对象
	 * @return 解压后的byte数组
	 */
	public static void convertVoice(File source, File target) {
		// File source = new
		// File("E:\\gtGEHFWPLYxlsJmjaMJJYwuvvQxh6qHcZxzV-FuvCtkWM9XFimee0L2Zi9sCepqS.amr");
		// File target = new File("D:\\1381370093615.mp3");
		AudioAttributes audio = new AudioAttributes();
		Encoder encoder = new Encoder();

		audio.setCodec("libmp3lame");
		audio.setBitRate(new Integer(128000)); //比特率 
		audio.setChannels(new Integer(2)); //声音频道 audio.setSamplingRate(new Integer(44100)); //节录率
		EncodingAttributes attrs = new EncodingAttributes();
		attrs.setFormat("mp3");
		attrs.setAudioAttributes(audio);

		try {
			encoder.encode(source, target, attrs);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InputFormatException e) {
			e.printStackTrace();
		} catch (EncoderException e) {
			e.printStackTrace();
		}
	}
	
	
	//根据byte数组，生成文件 
    public static File getFile(byte[] bfile, String filePath,String fileName) {  
        BufferedOutputStream bos = null;  
        FileOutputStream fos = null;  
        File file = null;  
        try {  
            File dir = new File(filePath);  
            if(!dir.exists()&&dir.isDirectory()){//判断文件目录是否存在  
                dir.mkdirs();  
            }  
            file = new File(filePath+File.separator+fileName);  
            fos = new FileOutputStream(file);  
            bos = new BufferedOutputStream(fos);  
            bos.write(bfile);  
        } catch (Exception e) {  
            e.printStackTrace();  
        } finally {  
            if (bos != null) {  
                try {  
                    bos.close();  
                } catch (IOException e1) {  
                   e1.printStackTrace();  
                }  
            }  
            if (fos != null) {  
                try {  
                    fos.close();  
                } catch (IOException e1) {  
                    e1.printStackTrace();  
                }  
            }  
        }  
        return file;
    }  


	/**
	 * @Title:unGzip  @Description: 解压gzip文件流对象
	 * @author 胡翔
	 * @param gzip文件流对象
	 * @return 解压后的byte数组
	 */
	public static byte[] unGzip(InputStream in) throws IOException {
		byte[] buf = null;
		if (in == null) {
			return null;
		}
		try (GZIPInputStream gzi = new GZIPInputStream(in);
				ByteArrayOutputStream bos = new ByteArrayOutputStream()) {
			int count = 0;
			byte[] tmp = new byte[byteSize];
			while ((count = gzi.read(tmp)) != -1) {
				bos.write(tmp, 0, count);
			}
			bos.flush();
			buf = bos.toByteArray();
		}
		return buf;
	}
	
	public static void main(String[] args) throws Exception {
//		File source, File target
		 File source = new  File("E:\\test\\bubugao.amr");
		 File target = new File("E:\\test\\1381370093615.mp3");
		 
		 convertVoice(  source,   target);
		 
	}
}
