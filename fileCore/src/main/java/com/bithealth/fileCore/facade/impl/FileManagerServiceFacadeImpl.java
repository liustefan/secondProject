/**
 * @PackageName:      com.bithealth.fileCore.facade.impl
 * @FileName:     FileManagerServiceFacadeImpl.java  
 * @Description: TODO(文件管理对外接口实现类)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      胡翔  * 
 * @version      V1.0  
 * @Createdate:  2016年6月28日 上午10:33:44  
 * 
 */
package com.bithealth.fileCore.facade.impl;

import java.io.InputStream;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bithealth.fileCore.facade.service.FileManagerServiceFacade;
import com.bithealth.fileCore.model.FileConfigModel;
import com.bithealth.fileCore.service.FileManagerService;

/**
 * 类名称: FileManagerServiceFacadeImpl  
 * 功能描述: TODO 文件管理对外接口实现类.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年6月28日 上午10:33:44 
 * 
 * @author 胡翔
 * @version  
 */
@Service
public class FileManagerServiceFacadeImpl implements FileManagerServiceFacade{

	@Autowired
	private FileManagerService fileManagerService; 
	
	@Override
	public byte[] downloadFile(FileConfigModel model) throws Exception {
		if(model == null || StringUtils.isBlank(model.getUniqueId())){
			throw new Exception("model对象或者uniqueId不能为空");
		}
		return fileManagerService.downloadFile(model);
	}

	@Override
	public byte[] downloadThumbnailImage(FileConfigModel model)	throws Exception {
		if(model == null || StringUtils.isBlank(model.getUniqueId())){
			throw new Exception("model对象或者uniqueId不能为空");
		}
		return fileManagerService.downloadThumbnailImage(model);
	}
	
	@Override
	public String uploadFile(InputStream in, FileConfigModel model)	throws Exception {
		checkModelIsValid(model);
		return fileManagerService.uploadFile(in, model);
	}
	
	@Override
	public boolean deleteFile(FileConfigModel model) throws Exception {
		checkModelIsValid(model);
		return fileManagerService.deleteFile(model);
	}
	

	/**
	 * @Title:checkModelIsValid 
	 * @Description:TODO(检查文件管配置model的属性是否合法).  
	 * @author 胡翔
	 * @param model 
	 * @throws Exception 
	 */ 
	private void checkModelIsValid(FileConfigModel model) throws Exception {
		if(model==null){
			throw new Exception("fileConfigeModel不能为空");
		}else if(model.getTypeEnum() == null ){
			throw new Exception("fileConfigeModel的文件类型不能为空");
		}
	}
	
	/**
	 * @Title:uploadFileAppChat 
	 * @Description:TODO(app聊天模块上传图片指定压缩比例).  
	 * @author liuxiaoqin
	 * @param in 需要保存的文件流对象
	 * @date 2016-10-28
	 * @param model 
	 * @return String 返回源文件的唯一标识
	 * @throws Exception 
	 */ 
	public String uploadFileAppChat(InputStream in, FileConfigModel model) throws Exception{
		checkModelIsValid(model);
		return fileManagerService.uploadAppChatFile(in, model);
	}

}
