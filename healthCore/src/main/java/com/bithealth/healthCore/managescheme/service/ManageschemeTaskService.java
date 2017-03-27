 
/**
 * @PackageName:      com.bithealth.healthCore.managescheme.service
 * @FileName:     ManageschemeTaskService.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      名字  * 
 * @version      V1.0  
 * @Createdate:  2016年12月8日 上午11:04:10  
 * 
 */

package com.bithealth.healthCore.managescheme.service;

import com.bithealth.healthCore.managescheme.model.ManageschemeExecTask;
import com.bithealth.sdk.core.feature.orm.mybatis.Page;


/**
 * 类名称: ManageschemeTaskService  
 * 功能描述: TODO 个人任务管理 
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年12月8日 上午11:04:10 
 * 
 * @author baozj
 * @version  
 */
public interface ManageschemeTaskService {

	Page<ManageschemeExecTask> selectManageschemeTaskPage(Page<ManageschemeExecTask> page, ManageschemeExecTask model);
	
	ManageschemeExecTask selectExecTask(Long MSExecID);
	
	/**
	 * 
	 * @Title:updateExecTaskResult 
	 * @Description:
	 * TODO  
	 * @author baozj
	 * @param model 任务参数
	 * @param finish true：执行任务 false：保存任务信息不执行
	 * @param termination
	 * @return 
	 * @throws
	 * @retrun boolean
	 */
	boolean updateExecTaskResult(ManageschemeExecTask model, boolean finish, boolean termination);
}

