package com.bithealth.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alibaba.fastjson.JSON;
import com.bithealth.fileCore.constant.FileTypeEnum;
import com.bithealth.fileCore.facade.service.FileManagerServiceFacade;
import com.bithealth.fileCore.model.FileConfigModel;
import com.bithealth.sdk.core.entity.JSONResult;
import com.bithealth.sdk.web.controller.BaseSpringController;
import com.bithealth.util.MessageUtil;

/**
 * @PackageName: com.bithealth.controller
 * @FileName:    FileController.java  
 * @Description: 文件，图片，略缩图下载功能  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      liuxiaoqin
 * @version      V1.0  
 * @Createdate:  2016年8月16日 
 */
@Controller
@RequestMapping(value = "/file")
public class FileController extends BaseSpringController{
	
	@Resource
    private FileManagerServiceFacade fileManagerServiceFacade;
	
	/**
	 * @Description: 下载文件或者略缩图片 
	 * @author:      liuxiaoqin
	 * @version      V1.0  
	 * @Createdate:  2016年8月16日 
	 */
	@RequestMapping(value = "/downloadThumbnailImage", method = RequestMethod.GET)
    public void selectThumbnailImage(HttpServletRequest request,HttpServletResponse response) throws IOException{
		response.setCharacterEncoding("UTF-8");
		OutputStream output = null;
		String contentType = "";
		try{
	    	String fileName = request.getParameter("fileName");
			if(StringUtils.isEmpty(fileName)){
				JSONResult<Object> value = new JSONResult<Object>();
				PrintWriter out = response.getWriter();
				value.setStatusCode(1);
				value.setMessage("文件fileName【"+fileName+"】不能为空");
				logger.info("文件fileName【"+fileName+"】不能为空");
				value.setSuccess(false);
				out.write(JSON.toJSONString(value));
				return;
	    	}
			String fileType = StringUtils.getFilenameExtension(fileName);
			String fileId = StringUtils.stripFilenameExtension(fileName);
			FileConfigModel modle = new FileConfigModel();
			if(StringUtils.isEmpty(fileType)){
				fileType = "png";
			}
			if(fileType.equals("jpg") || fileType.equals("jpeg")|| fileType.equals("png")|| fileType.equals("gif") || fileType.equals("bmp")){
				contentType = "image/" + fileType;
			}else if(fileType.equals("amr")){
				contentType = "audio/" + fileType;
			}else if(fileType.equals("mp4") || fileType.equals("avi")){
				contentType = "video/" + fileType;
			}else if(fileType.equals("custom")){
				contentType = "custom/" + fileType;
			}
			response.setContentType(contentType);
			modle.setTypeEnum(FileTypeEnum.findEnumByFormat(fileType));
			modle.setUniqueId(fileId);
			modle.setNeedCompress(false);
			byte[] by = fileManagerServiceFacade.downloadThumbnailImage(modle);
			output = response.getOutputStream();  
            output.write(by);  
            output.flush();
    	}catch(Exception e){
    		JSONResult<Object> value = new JSONResult<Object>();
			PrintWriter out = response.getWriter();
    		value.setStatusCode(2);
    		value.setMessage(MessageUtil.getValue("error.select.data"));
			logger.info("下载文件异常"+e);
			value.setSuccess(false);
			out.write(JSON.toJSONString(value));
    	}finally{
    		try{  
                if(output !=null){  
                    //关闭流  
                    output.close();  
                }  
            }catch (Exception e) {  
                e.printStackTrace();  
            }    
    	}
	}
	
	/**
	 * @Description: 文件或者图片下载 
	 * @author:      liuxiaoqin
	 * @version      V1.0  
	 * @Createdate:  2016年8月16日 
	 */
	@RequestMapping(value = "/downloadFileOrImage", method = RequestMethod.GET)
    public void selectFileOrImage(HttpServletRequest request,HttpServletResponse response) throws IOException{
		response.setCharacterEncoding("UTF-8");
		OutputStream output = null; 
		String contentType = "";
		try{
	    	String fileName = request.getParameter("fileName");
			String fileType = StringUtils.getFilenameExtension(fileName);
			String fileId = StringUtils.stripFilenameExtension(fileName);
			FileConfigModel modle = new FileConfigModel();
			if(StringUtils.isEmpty(fileType)){
				fileType = "png";
			}
			if(fileType.equals("jpg") || fileType.equals("jpeg")|| fileType.equals("png")|| fileType.equals("gif") || fileType.equals("bmp")){
				contentType = "image/" + fileType;
			}else if(fileType.equals("amr")){
				contentType = "audio/" + fileType;
			}else if(fileType.equals("mp4") || fileType.equals("avi")){
				contentType = "video/" + fileType;
			}else if(fileType.equals("custom")){
				contentType = "custom/" + fileType;
			}
			response.setContentType(contentType);
			modle.setTypeEnum(FileTypeEnum.findEnumByFormat(fileType));
			modle.setUniqueId(fileId);
			modle.setNeedCompress(false);
			byte[] by = fileManagerServiceFacade.downloadFile(modle);
			if(by != null){
				output = response.getOutputStream();  
				output.write(by);  
				output.flush();
			}else{
				return;
			}
    	}catch(Exception e){
    		JSONResult<Object> value = new JSONResult<Object>();
			PrintWriter out = response.getWriter();
    		value.setStatusCode(2);
    		value.setMessage(MessageUtil.getValue("error.select.data"));
			logger.info("下载文件异常"+e);
			value.setSuccess(false);
			out.write(JSON.toJSONString(value)); 
    	}finally{
    		try{  
                if(output !=null){  
                    //关闭流  
                    output.close();  
                }  
            }catch (Exception e) {  
                e.printStackTrace();  
            }    
    	}
	}
}
