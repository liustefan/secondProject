 
/**
 * @PackageName:      com.bithealth
 * @FileName:     BaseWebController.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      陈哲 
 * @version      V1.0  
 * @Createdate:  2016年8月12日 下午2:40:14  
 * 
 */

package com.bithealth;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.bithealth.fileCore.constant.FileTypeEnum;
import com.bithealth.fileCore.facade.service.FileManagerServiceFacade;
import com.bithealth.fileCore.model.FileConfigModel;
import com.bithealth.sdk.web.controller.BaseSpringController;


/**
 * 类名称: BaseWebController  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年8月12日 下午2:40:14 
 * 
 * @author 陈哲
 * @version  
 */
public class BaseWebController extends BaseSpringController {
	
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
	public String uploadImage(MultipartFile file){
		if(file==null || file.isEmpty() || file.getSize() == 0 ){
			return null;
		}
		String originalFilename = file.getOriginalFilename();
		String fileFormat = originalFilename.split("\\.")[1];
		FileTypeEnum typeEnum = FileTypeEnum.findEnumByFormat(fileFormat);
		if(typeEnum == null){ //校验是否为可上传的文件类型
			return null;
		}
		
		FileConfigModel model = new FileConfigModel();
		model.setTypeEnum(typeEnum);
		
		String uniqueId = null;
		try {
			//文件上传
			uniqueId = fileManagerServiceFacade.uploadFile(file.getInputStream(), model);
		} catch (Exception e) {
			return null;
		}
		return uniqueId;
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
	public void getImage(String uniqueId, HttpServletResponse response){
		 
		try {
			byte[] byteArray = getMongodbfile(  uniqueId) ;
			if(byteArray == null){
				return;
			}
			response.setHeader("Content-Type","Mime-type");
			ServletOutputStream outputStream = response.getOutputStream();
			outputStream.write(byteArray);
			outputStream.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	public byte[] getMongodbfile(String uniqueId) throws Exception{
		if(!ObjectId.isValid(uniqueId)){
			return null;
		}
		
		FileConfigModel model = new FileConfigModel();
		model.setUniqueId(uniqueId);
		FileTypeEnum fileTypeEnum = FileTypeEnum.CUSTOM_FILE;
		fileTypeEnum.setFormat("headImage");
		model.setTypeEnum(fileTypeEnum);
		model.setNeedCompress(false);
		 
	    byte[] byteArray = fileManagerServiceFacade.downloadFile(model);

       	return byteArray;
			  
	}
	

}

