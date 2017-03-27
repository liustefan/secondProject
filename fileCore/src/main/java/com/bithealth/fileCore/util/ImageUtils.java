/**
 * @PackageName:  com.bithealth.fileCore.util
 * @FileName:     ImageUtils.java  
 * @Description:  图片压缩工具类
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      胡翔  
 * @version      V1.0  
 * @Createdate:  2016年6月21日 上午10:44:35  
 * 
 */
package com.bithealth.fileCore.util;


import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;

import javax.imageio.ImageIO;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

/**
 * 类名称: ImageUtils  
 * 功能描述: 图片压缩工具类  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年6月21日 下午4:39:54 
 * 
 * @author 胡翔
 * @version  
 */
public class ImageUtils {
	/**
	 * 等比压缩图片宽度
	 */
	private static int resizeWidth = 40;
	
	/**
	 * appChat聊天等比压缩图片宽度
	 */
	private static int resizeAppChatWidth = 200;
	

	/**
	 * 强制压缩/放大图片到固定的大小
	 * @param input 文件流对象
	 * @return 压缩后的图片字节数组
	 * @throws IOException 
	 */
	public static byte[] resize(InputStream input) throws IOException{
		try(ByteArrayOutputStream out = new ByteArrayOutputStream()){
			BufferedImage img = ImageIO.read(input);
			if(null!=img){
				int width = img.getWidth();
				//等比压缩的长度
				int resizeHeight = img.getHeight() / (width / resizeWidth);
				BufferedImage image = new BufferedImage(resizeWidth,resizeHeight,BufferedImage.TYPE_INT_RGB);
				image.getGraphics().drawImage(img, 0, 0, resizeWidth,resizeHeight, null); // 绘制缩小后的图
				// 可以正常实现bmp、png、gif转jpg
				JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
				encoder.encode(image); // JPEG编码		
				return out.toByteArray();
			}else{
				return null;
			}
		}
	}
	
	/**
	 * 强制压缩/放大图片到固定的大小(app聊天)
	 * @param input 文件流对象
	 * @return 压缩后的图片字节数组
	 * @throws IOException 
	 */
	public static byte[] resizeAppChat(InputStream input) throws IOException{
		try(ByteArrayOutputStream out = new ByteArrayOutputStream()){
			BufferedImage img = ImageIO.read(input);
			if(null!=img){
				int width = img.getWidth();
				int hegihtNew = img.getHeight();
				
				//等比压缩的长度
				BigDecimal i = BigDecimal.valueOf(width).divide( BigDecimal.valueOf(resizeAppChatWidth));
				BigDecimal height = BigDecimal.valueOf(hegihtNew).divideToIntegralValue(i);
				int resizeHeight = (int)height.doubleValue();
				BufferedImage image = new BufferedImage(resizeAppChatWidth,resizeHeight,BufferedImage.TYPE_INT_RGB);
				image.getGraphics().drawImage(img, 0, 0, resizeAppChatWidth,resizeHeight, null); // 绘制缩小后的图
				// 可以正常实现bmp、png、gif转jpg
				JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
				encoder.encode(image); // JPEG编码		
				return out.toByteArray();
			}else{
				return null;
			}
		}
	}
}

