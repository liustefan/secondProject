 
/**
 * @PackageName:      com.bithealth.healthCore.dao
 * @FileName:     ManageschemeDao.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      名字  * 
 * @version      V1.0  
 * @Createdate:  2016年12月13日 下午3:03:00  
 * 
 */

package com.bithealth.healthCore.dao;

import java.util.List;
import java.util.Map;


/**
 * 类名称: ManageschemeDao  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年12月13日 下午3:03:00 
 * 
 * @author baozj
 * @version  
 */
public interface ManageschemeDao {

	List<Map<String, Object>> exProcMschemeGetMemberByDocId(Map<String, Object> params);
	List<Map<String, Object>> exProcMschemeGetoraddMemberByDocId(Map<String, Object> params);
	void exProcMschemeAddMemberByDocId(Map<String, Object> params);
	void exProcMschemeAddExecTaskByMSDesignID(Map<String, Object> params);
	
}

