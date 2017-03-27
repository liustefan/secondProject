 
/**
 * @PackageName:      com.bithealth.healthCore.templet.service
 * @FileName:     TempletService.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      名字  * 
 * @version      V1.0  
 * @Createdate:  2016年11月29日 上午10:23:37  
 * 
 */

package com.bithealth.healthCore.templet.service;

import com.bithealth.healthCore.enmu.TempletStatusEnum;
import com.bithealth.healthCore.templet.model.ManageschemeTemplet;
import com.bithealth.healthCore.templet.model.ManageschemeTempletTask;
import com.bithealth.sdk.core.feature.orm.mybatis.Page;


/**
 * 类名称: TempletService  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年11月29日 上午10:23:37 
 * 
 * @author baozj
 * @version  
 */
public interface TempletService {

	ManageschemeTemplet selectTempletById(Integer id);
	
	boolean deleteTemplet(Integer...ids);
	
	boolean insertTemplet(ManageschemeTemplet model);
	
	boolean updateTemplet(ManageschemeTemplet model);
	
	boolean updateTempletStatus(Integer id, TempletStatusEnum newStatus, TempletStatusEnum oldStatus);
	
	boolean insertTempletTask(ManageschemeTempletTask model);
	
	boolean updateTempletTask(ManageschemeTempletTask model);
	
	boolean deleteTempletTask(Integer id);
	
	Page<ManageschemeTemplet> selectTempletPage(Page<ManageschemeTemplet> page, ManageschemeTemplet model);
	
	boolean selectTempletIsExist(String schemeTitle, Integer id, Integer docId);
	
	boolean deleteAttached(Integer id);
	
	boolean updateUsedNumber(Integer id);
	
	ManageschemeTemplet selectTempletIsExist(Integer roleId, String schemeTitle, Integer id, Integer docId, String allSharedOrg);
}

