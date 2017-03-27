 
/**
 * @PackageName:      com.bithealth.printCore.service.impl
 * @FileName:     ExportWordServiceImpl.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      陈哲 
 * @version      V1.0  
 * @Createdate:  2016年7月30日 下午5:43:10  
 * 
 */

package com.bithealth.printCore.service.impl;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import sun.misc.BASE64Encoder;

import com.bithealth.printCore.MyConverter;
import com.bithealth.printCore.service.ExportWordService;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;



/**
 * 类名称: ExportWordServiceImpl  
 * 功能描述: word导出接口实现
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年7月30日 下午5:43:10 
 * 
 * @author 陈哲
 * @version  
 */
@Service
public class ExportWordServiceImpl implements ExportWordService {
	private final static Logger logger = Logger.getLogger(ExportWordServiceImpl.class);
	
	/**
	     * @Title: send 
	     * @Description: 导出word
	     * @param  
	     * @throws      
	     * @retrun  
	     *  @see com.bithealth.printCore.service.ExportWordService#ExportWord(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.util.Map, java.lang.String, java.lang.String)
	 */
	public void ExportWord(HttpServletRequest request, HttpServletResponse response, Map<String, Object> dataMap, String exportFileName,
			String templateName) {
		//对fileName编码，因为含有汉字，会导致出现乱码。
		String rfileName = null;
		try {
			rfileName = new String((exportFileName+".doc").getBytes("GB2312"), "ISO8859-1");
		} catch (Exception e) {
			logger.error("word导出，文件名编码解码转换异常！");
			return;
		} 
		response.setContentType("application/octet-stream; charset=UTF-8");  
		response.setHeader("content-disposition", "attachment;filename=" + rfileName);
		Writer out = null;
		try {
			out = new BufferedWriter(new OutputStreamWriter(response.getOutputStream(),"UTF-8"));
		} catch (Exception e) {
			logger.error("word导出，Writer对象处理异常！");
		}
		
		ServletContext context = request.getSession().getServletContext();
		
		createDoc(dataMap, out, context, templateName);
		
	}
	
	/**
	 * @Title:createDoc 
	 * @Description:freemarker创建生成word
	 * @author 陈哲
	 * @param dataMap
	 * @param out
	 * @param context
	 * @param fileName 
	 * @throws
	 * @retrun void
	 */
	public void createDoc(Map<String, Object> dataMap, Writer out, ServletContext context, String fileName) {
		Configuration configuration = new Configuration();
		configuration.setDefaultEncoding("UTF-8");
		
        configuration.setServletContextForTemplateLoading(context, "/ftl");
        configuration.setTagSyntax(Configuration.AUTO_DETECT_TAG_SYNTAX);//Freemarker默认是使用<>,修改使用[]
		Template t = null;
		try {
			t = configuration.getTemplate(fileName);
			t.setEncoding("utf-8");
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			t.process(dataMap, out);
		} catch (TemplateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	     * @Title: send 
	     * @Description: svg字符串转换成图片Base64编码
	     * @param  
	     * @throws      
	     * @retrun  
	     *  @see com.bithealth.printCore.service.ExportWordService#doImage(java.lang.String, javax.servlet.http.HttpServletRequest)
	 */
	public String doImage(String svgStr, HttpServletRequest request){	
		String WebRoot = request.getRealPath("")+"\\temp\\";
		
		// 生成png图片的临时文件名
		String temp = WebRoot+System.currentTimeMillis()+(int)(Math.random()*1000)+".png";
		
		//svg字符串转换并生成png图片保存到临时文件目录temp中
		MyConverter.convertToPng(svgStr, temp);
		
		String imagrStr=getImageStr(temp);
		//将生成的临时png图片给删掉，减小服务器压力
		File file = new File(temp);
		if(file.exists()){
			file.delete();
		}
		
		return imagrStr;
	}
	
	public String getImageStr(String imgFile) {
		InputStream in = null;
		byte[] data = null;
		try {
			in = new FileInputStream(imgFile);
			data = new byte[in.available()];
			in.read(data);
			in.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		BASE64Encoder encoder = new BASE64Encoder();
		return encoder.encode(data);
	}

}

