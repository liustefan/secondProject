/**
 * @PackageName:      com.bithealth.fileCore.facade
 * @FileName:     FileManagerServiceFacade.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      胡翔  * 
 * @version      V1.0  
 * @Createdate:  2016年6月28日 上午10:32:39  
 * 
 */
package com.bithealth.fileCore.facade.service;

import java.io.InputStream;

import com.bithealth.fileCore.model.FileConfigModel;

/**
 * 类名称: FileManagerServiceFacade  
 * 功能描述: TODO 对外提供的文件管理业务接口.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年6月28日 上午10:32:39 
 * 
 * @author 胡翔
 * @version  
 */
public interface FileManagerServiceFacade {

	/**
	 * @Title:downloadFile 
	 * @Description:TODO(下载源文件).  
	 * @author 胡翔
	 * @param model 文件配置model
	 * @return byte[] 文件字节数组
	 * @throws Exception 
	 */ 
	byte[] downloadFile(FileConfigModel model) throws Exception;
	
	/**
	 * @Title:downloadThumbnailImage 
	 * @Description:TODO(下载图片文件的缩略图).  
	 * @author 胡翔
	 * @param model 文件配置model 
	 * @return byte[] 文件字节数组
	 * @throws Exception 
	 */ 
	byte[] downloadThumbnailImage(FileConfigModel model) throws Exception;
	
	/**
	 * @Title:uploadFile 
	 * @Description:TODO(上传文件并返回源文件的唯一标识).  
	 * @author 胡翔
	 * @param in 需要保存的文件流对象
	 * @param model 
	 * @return String 返回源文件的唯一标识
	 * @throws Exception 
	 */ 
	String uploadFile(InputStream in, FileConfigModel model) throws Exception;
	
	/**
	 * @Title:deleteFile 
	 * @Description:TODO(删除原文件（缩略图也会一并删除）).  
	 * @author 胡翔
	 * @param model 文件配置model
	 * @return boolean 删除结果
	 * @throws Exception 
	 */ 
	boolean deleteFile(FileConfigModel model) throws Exception;
	
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
	String uploadFileAppChat(InputStream in, FileConfigModel model) throws Exception;
}
