 
/**
 * @PackageName:      com.bithealth.healthCore.managescheme.service
 * @FileName:     ManageschemeService.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      名字  * 
 * @version      V1.0  
 * @Createdate:  2016年12月8日 上午11:02:59  
 * 
 */

package com.bithealth.healthCore.managescheme.service;

import com.bithealth.healthCore.enmu.GroupManageschemeEnum;
import com.bithealth.healthCore.enmu.SchemeTypeEnum;
import com.bithealth.healthCore.managescheme.model.ManageschemeDesign;
import com.bithealth.healthCore.managescheme.model.ManageschemeDesignTask;
import com.bithealth.healthCore.managescheme.model.ManageschemeExec;
import com.bithealth.sdk.core.feature.orm.mybatis.Page;


/**
 * 类名称: ManageschemeService  
 * 功能描述: TODO 个人方案、群体方案管理  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年12月8日 上午11:02:59 
 * 
 * @author baozj
 * @version  
 */
public interface ManageschemeService {
	
	Page<ManageschemeExec> selectPersonManageschemePage(Page<ManageschemeExec> page, ManageschemeExec model);
	
	Page<ManageschemeDesign> selectGroupManageschemePage(Page<ManageschemeDesign> page, ManageschemeDesign model);

	ManageschemeDesign selectManageschemeById(Integer MSDesignID);
	
	boolean deleteManagescheme(Integer MSDesignID);
	
	boolean deleteManageschemeTask(Integer MSDTaskID, SchemeTypeEnum st);
	
	boolean updateManagescheme(Integer docId, Integer MSDesignID, GroupManageschemeEnum newStatus, GroupManageschemeEnum oldStatus, String massOffReason);
	
	boolean insertManagescheme(ManageschemeDesign model);
	
	boolean updateManagescheme(ManageschemeDesign model);
	
	boolean insertManageschemeTask(ManageschemeDesignTask model, SchemeTypeEnum sType, Long MSExecID);
	
	boolean updateManageschemeTask(ManageschemeDesignTask model);
	
	Page<ManageschemeExec> selectManageschemePage(Page<ManageschemeExec> page, ManageschemeExec model);
	
	ManageschemeExec selectManageschemeById(Long MSExecID);
	
	ManageschemeExec selectHasManageschemeExec(Integer memberId);
	
	int insertManageschemeExecs(ManageschemeExec... execs);
	
	boolean deleteAttached(Integer id);
}

