/**
 * @PackageName:  com.bithealth.fileCore.model
 * @FileName:     FileConfigModel.java  
 * @Description: 文件配置model  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      胡翔  
 * @version      V1.0  
 * @Createdate:  2016年6月16日 下午3:37:27  
 * 
 */
package com.bithealth.fileCore.model;

import com.bithealth.fileCore.constant.FileTypeEnum;

/**
 * 类名称: FileConfigModel  
 * 功能描述: 文件配置model 
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年6月16日 下午2:23:03 
 * 
 * @author 胡翔
 * @version  
 */
public class FileConfigModel{
	/**
	 * 文件唯一标识，若上传文件时，此字段不为空，视为  修改原文件
	 */
	private String uniqueId;
	/**
	 * 文件类型,必填项，不能为空
	 */
	private FileTypeEnum typeEnum;
	/**
	 * 保存文件/获取文件时，压缩/解压文件。默认为ture：压缩，false：不压缩
	 */
	private boolean needCompress = true; 
	
	/**
	 * needCompress.
	 *
	 * @return  the needCompress 
	 */
	public boolean isNeedCompress() {
		return needCompress;
	}
	/**
	 * needCompress.
	 *
	 * @param   needCompress    the needCompress to set 
	 */
	public void setNeedCompress(boolean needCompress) {
		this.needCompress = needCompress;
	}
	public String getUniqueId() {
		return uniqueId;
	}
	public void setUniqueId(String uniqueId) {
		this.uniqueId = uniqueId;
	}
	public FileTypeEnum getTypeEnum() {
		return typeEnum;
	}
	public void setTypeEnum(FileTypeEnum typeEnum) {
		this.typeEnum = typeEnum;
	}
	
}
