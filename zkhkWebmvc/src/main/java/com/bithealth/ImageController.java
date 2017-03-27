 
/**
 * @PackageName:      com.bithealth
 * @FileName:     FileManagerController.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      陈哲 
 * @version      V1.0  
 * @Createdate:  2016年7月25日 上午9:16:17  
 * 
 */

package com.bithealth;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.bithealth.fileCore.constant.FileTypeEnum;
import com.bithealth.fileCore.facade.service.FileManagerServiceFacade;
import com.bithealth.fileCore.model.FileConfigModel;


/**
 * 类名称: FileManagerController  
 * 功能描述: 图片文件处理  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年7月25日 上午9:16:17 
 * 
 * @author 陈哲
 * @version  
 */
@Controller
@RequestMapping("/image")
public class ImageController extends BaseWebController{
	private Logger logger = LoggerFactory.getLogger(ImageController.class);
	
	@Autowired
	private FileManagerServiceFacade fileManagerServiceFacade;
	
	/**
	 * @Title:uploadImage 
	 * @Description:图片文件上传
	 * @author 陈哲
	 * @param request
	 * @return 
	 * @throws
	 * @retrun String
	 */
	@RequestMapping(method=RequestMethod.POST,value="/uploadImage")
	public String uploadImage(HttpServletRequest request){
		MultipartHttpServletRequest mulRequest = (MultipartHttpServletRequest)request;
		MultipartFile file = mulRequest.getFile("file");
		return super.uploadImage(file);
	}
	
	
	/**
	 * @Title:getImage 
	 * @Description:获取图片
	 * @author 陈哲
	 * @param uniqueId
	 * @param response 
	 * @throws
	 * @retrun void
	 */
	@RequestMapping(method=RequestMethod.GET,value="/getImage")
	public void getImage(String uniqueId, HttpServletResponse response){
		super.getImage(uniqueId, response);
	}

}

