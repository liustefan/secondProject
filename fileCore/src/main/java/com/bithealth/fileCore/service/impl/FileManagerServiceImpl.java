/**
 * @PackageName:  com.bithealth.fileCore.service.impl
 * @FileName:     FileManagerServiceImpl.java  
 * @Description: 文件管理服务实现类   
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      胡翔  
 * @version      V1.0  
 * @Createdate:  2016年6月16日 下午3:37:27  
 * 
 */
package com.bithealth.fileCore.service.impl;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bithealth.fileCore.constant.Constants;
import com.bithealth.fileCore.constant.FileTypeEnum;
import com.bithealth.fileCore.fileDao.FileManagerDao;
import com.bithealth.fileCore.model.FileConfigModel;
import com.bithealth.fileCore.service.FileManagerService;
import com.bithealth.fileCore.util.FileOperateUtil;
import com.bithealth.fileCore.util.ImageUtils;

/**
 * 类名称: FileManagerServiceImpl  
 * 功能描述: 文件管理服务实现类  
 * 日期: 2016年6月17日 下午1:56:30 
 * 
 * @author 胡翔
 * @version  
 */
@Service
public class FileManagerServiceImpl implements FileManagerService{
	@Autowired
	private FileManagerDao fileManagerDao;
	
	@Override
	public String uploadFile(InputStream in, FileConfigModel model) throws Exception  {
		String id = model.getUniqueId();
		if(StringUtils.isNotBlank(id)){//需要和mongodb模块讨论怎么处理源文件更新的需求，是先删除再保存。还是直接替换原有的文件（查找源文件后直接替换）。
			deleteFile(model); //如果id不为空，表明已存在源文件，所以先删除再保存最新的。
		}
		
		ByteArrayOutputStream out = FileOperateUtil.getByteArrayOutputStream(in);
		byte[] fileBytes = out.toByteArray();
		if(model.isNeedCompress()){
			fileBytes = FileOperateUtil.gzip(fileBytes);
		}
		String uniqueId = fileManagerDao.saveFile(fileBytes,Constants.FILE_SAVE_PATH,id);
		
		if(Constants.IMAGE_FILE.equals(model.getTypeEnum().getType())){//保存图片文件缩略图
			saveThumbnailImage(new ByteArrayInputStream(out.toByteArray()),uniqueId);
		}
		//关闭byteArrayOutputStream流对象
		out.close();
		return uniqueId;
	}
	
	/**
	 * @Title:saveThumbnailImage 
	 * @Description: 生成文件缩略图，并保存缩略图文件 
	 * @author 胡翔
	 * @param in 源文件 
	 * @param uniqueId 原文件的唯一标识 
	 * @retrun void
	 * @throws Exception 
	 */ 
	private void saveThumbnailImage(InputStream in, 
			String uniqueId) throws Exception {
		byte[] resizebyte = FileOperateUtil.gzip(ImageUtils.resize(in));
		fileManagerDao.saveFile(resizebyte,Constants.CUT_IMAGE_PATH, uniqueId);
		in.close();
	}

	@Override
	public byte[] downloadFile(FileConfigModel model) throws Exception {
		//mongodb集合保存路径 
		InputStream in = fileManagerDao.getFile(Constants.FILE_SAVE_PATH, model.getUniqueId());
		if(in == null){
			return null;
		}
		if(model.isNeedCompress()){
			return FileOperateUtil.unGzip(in);
		}
		ByteArrayOutputStream byteArrayOutputStream = FileOperateUtil.getByteArrayOutputStream(in);
		byte[] by = byteArrayOutputStream.toByteArray();
		byteArrayOutputStream.close();
		return by;
	}

	@Override
	public byte[] downloadThumbnailImage(FileConfigModel model) throws Exception {
		if(Constants.IMAGE_FILE.equals(model.getTypeEnum().getType())){
			InputStream in = fileManagerDao.getFile(Constants.CUT_IMAGE_PATH, model.getUniqueId());
			byte[] by=FileOperateUtil.unGzip(in);
			if(null==by){
				byte[] b=this.downloadFile(model);
				InputStream input = new ByteArrayInputStream(b);
				this.saveThumbnailImage(input, model.getUniqueId());
				InputStream inputStream = fileManagerDao.getFile(Constants.CUT_IMAGE_PATH, model.getUniqueId());
				by=FileOperateUtil.unGzip(inputStream);
			}
			return by;
		}
		return null;
	}

	@Override
	public boolean deleteFile(FileConfigModel model) throws Exception {
		/**
		 * 删除图片时，缩略图也一并删除
		 */
		if(model.getTypeEnum()!=null && Constants.IMAGE_FILE.equals(model.getTypeEnum().getType())){
			fileManagerDao.deleteFile(Constants.CUT_IMAGE_PATH, model.getUniqueId());
		}
		return fileManagerDao.deleteFile(Constants.FILE_SAVE_PATH, model.getUniqueId());
	}
	
	/**
	 * @Title:uploadAppChatFile
	 * @Description: app生成指定大小的文件
	 * @author liuxiaoqin
	 * @date 2016-10-28
	 * @param in 源文件 
	 * @param uniqueId 原文件的唯一标识 
	 * @retrun void
	 * @throws Exception 
	 */ 
	public String uploadAppChatFile(InputStream in, FileConfigModel model) throws Exception  {
		String id = model.getUniqueId();
		if(StringUtils.isNotBlank(id)){//需要和mongodb模块讨论怎么处理源文件更新的需求，是先删除再保存。还是直接替换原有的文件（查找源文件后直接替换）。
			deleteFile(model); //如果id不为空，表明已存在源文件，所以先删除再保存最新的。
		}
		
		ByteArrayOutputStream out = FileOperateUtil.getByteArrayOutputStream(in);
		byte[] fileBytes = out.toByteArray();
		if(model.isNeedCompress()){
			fileBytes = FileOperateUtil.gzip(fileBytes);
		}
		String uniqueId = fileManagerDao.saveFile(fileBytes,Constants.FILE_SAVE_PATH,id);
		
		if(Constants.IMAGE_FILE.equals(model.getTypeEnum().getType())){//保存图片文件缩略图
			saveAppChatThumbnailImage(new ByteArrayInputStream(out.toByteArray()),uniqueId);
		}
		//关闭byteArrayOutputStream流对象
		out.close();
		return uniqueId;
	}
	
	/**
	 * @Title:saveAppChatThumbnailImage 
	 * @Description: app生成指定大小的文件缩略图，并保存缩略图文件 
	 * @author liuxiaoqin
	 * @date 2016-10-28
	 * @param in 源文件 
	 * @param uniqueId 原文件的唯一标识 
	 * @retrun void
	 * @throws Exception 
	 */ 
	private void saveAppChatThumbnailImage(InputStream in, 
			String uniqueId) throws Exception {
		byte[] resizebyte = FileOperateUtil.gzip(ImageUtils.resizeAppChat(in));
		fileManagerDao.saveFile(resizebyte,Constants.CUT_IMAGE_PATH, uniqueId);
		in.close();
	}
	
}
