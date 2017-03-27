/**
 * @PackageName:      com.bithealth.memberCore.task
 * @FileName:     MemberSyncService.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      liuhm
 * @version      V1.0  
 * @Createdate:  2016年9月5日 下午4:16:47  
 * 
 */
package com.bithealth.memberCore.task;

/**
 * 类名称: MemberSyncService  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年9月5日 下午4:16:47 
 * 
 * @author liuhm
 * @version  
 */
public interface MemberSyncService {
	
	public void deleteMember();
	
	public void updateMember();
	
	public void insertMember();

}
