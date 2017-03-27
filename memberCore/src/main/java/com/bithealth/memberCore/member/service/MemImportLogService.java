/**
 * @PackageName:      com.bithealth.memberCore.member.service
 * @FileName:     MemImportLogService.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      liuhm
 * @version      V1.0  
 * @Createdate:  2016年8月27日 下午1:56:29  
 * 
 */
package com.bithealth.memberCore.member.service;

import java.util.List;

import com.bithealth.memberCore.enmu.UseTag;
import com.bithealth.memberCore.member.model.MemImportLog;
import com.bithealth.memberCore.member.model.MemImportLogExample;
import com.bithealth.sdk.core.generic.GenericBaseService;

/**
 * 类名称: MemImportLogService  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年8月27日 下午1:56:29 
 * 
 * @author liuhm
 * @version  
 */
public interface MemImportLogService extends GenericBaseService<MemImportLog, MemImportLogExample, Long> {
	
	public int insertLogs(List<MemImportLog> list);
	
	/**
	 * 依据GUID删除数据
	 * @Title:deleteByUUID 
	 * @Description:(这里用一句话描述这个方法的作用). 
	 * TODO(这里描述这个方法适用条件  执行流程  使用方法 注意事项– 可选).  
	 * @author liuhm
	 * @param uuid
	 * @return 
	 * @param 
	 * @throws
	 * @retrun int
	 */
	public int deleteByUUID(String uuid, UseTag tag);
	
	/**
	 * 
	 * @Title:updateTagByUUID 
	 * @Description:更新同步数据状态. 
	 * TODO(这里描述这个方法适用条件  执行流程  使用方法 注意事项– 可选).  
	 * @author liuhm
	 * @param uuid
	 * @param tag
	 * @return 
	 * @param 
	 * @throws
	 * @retrun int
	 */
	public int updateTagByUUID(String uuid, UseTag tag, String reason);
	
	public MemImportLog selectByUUID(String uuid, UseTag tag);
	
	public MemImportLog updateContent(String uuid, UseTag tag, String content);
	
	public int deleteErrorLog(Integer docId);

}
