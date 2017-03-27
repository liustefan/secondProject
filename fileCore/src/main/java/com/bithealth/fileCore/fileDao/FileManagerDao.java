/**
 * @PackageName:      com.bithealth.fileCore.dao
 * @FileName:     FileManagerDao.java  
 * @Description: TODO(文件管理dao层接口)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      胡翔  * 
 * @version      V1.0  
 * @Createdate:  2016年6月27日 下午6:00:52  
 * 
 */
package com.bithealth.fileCore.fileDao;

import java.io.InputStream;

/**
 * 类名称: FileManagerDao  
 * 功能描述: TODO 文件管理dao层接口.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年6月27日 下午6:00:52 
 * 
 * @author 胡翔
 * @version  
 */

public interface FileManagerDao {
	/**
	 * @Title:saveFile 
	 * @Description:TODO(保存文件并返回文件唯一标识).  
	 * @author 胡翔
	 * @param by 文件字节流数组
	 * @param pathname 文件路径
	 * @param uniqueId 文件唯一标识， (新上传文件时为空；修改文件时，不能为空) 
	 * @return String 保存成功后的唯一标识
	 * @throws Exception 
	 */ 
	String saveFile(byte[] by,String pathname, String uniqueId) throws Exception;
	
	/**
	 * @Title:getFile 
	 * @Description:TODO(获取文件).  
	 * @author 胡翔
	 * @param pathname 文件路径
	 * @param uniqueId 文件唯一标识
	 * @return InputStream 返回的文件流对象
	 * @throws Exception 
	 */ 
	InputStream getFile(String pathname,String uniqueId) throws Exception;
	
	/**
	 * @Title:deleteFile 
	 * @Description:TODO(删除文件并返回删除结果).  
	 * @author 胡翔
	 * @param pathname 文件路径
	 * @param uniqueId 文件唯一标识
	 * @return boolean 删除结果
	 * @throws Exception 
	 */ 
	boolean deleteFile(String pathname,String uniqueId) throws Exception;
}
