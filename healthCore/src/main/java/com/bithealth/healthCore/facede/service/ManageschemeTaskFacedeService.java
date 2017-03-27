 
/**
 * @PackageName:      com.bithealth.healthCore.facede.service
 * @FileName:     ManageschemeTaskFacedeService.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      名字  * 
 * @version      V1.0  
 * @Createdate:  2016年12月8日 上午11:04:46  
 * 
 */

package com.bithealth.healthCore.facede.service;

import com.bithealth.healthCore.managescheme.model.ManageschemeExecTask;
import com.bithealth.questionCore.answer.model.Ouai;
import com.bithealth.sdk.core.feature.orm.mybatis.Page;


/**
 * 类名称: ManageschemeTaskFacedeService  
 * 功能描述: TODO 个人任务管理  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年12月8日 上午11:04:46 
 * 
 * @author baozj
 * @version  
 */
public interface ManageschemeTaskFacedeService {
	
	/**
	 * 
	 * @Title:selectManageschemeTaskPage 
	 * @Description: 分页查询健康管理任务 
	 * TODO  
	 * @author baozj
	 * @param page
	 * @param model
	 * @return 
	 * @throws
	 * @retrun Page<ManageschemeExecTask>
	 */
	Page<ManageschemeExecTask> selectManageschemeTaskPage(Page<ManageschemeExecTask> page, ManageschemeExecTask model);

	/**
	 * 
	 * @Title:selectExecTask 
	 * @Description: 查询任务详情
	 * TODO  
	 * @author baozj
	 * @param MSExecID
	 * @return 
	 * @throws
	 * @retrun ManageschemeExecTask
	 */
	ManageschemeExecTask selectExecTask(Long MSExecID);
	
	/**
	 * 
	 * @Title:updateExecTaskResult 
	 * @Description: 执行任务
	 * TODO  
	 * @author baozj
	 * @param model
	 * @return 
	 * @throws
	 * @retrun boolean
	 */
	boolean updateExecTaskResult(ManageschemeExecTask model, boolean finish, boolean termination);
	
	/**
	 * 
	 * @Title:insertTaskAnswerResult 
	 * @Description: 作答任务中的单份答卷
	 * TODO  
	 * @author baozj
	 * @param pojo
	 * @return 
	 * @throws
	 * @retrun boolean
	 */
	boolean insertTaskAnswerResult(Ouai pojo);
	
	/**
	 * 
	 * @Title:insertMessageTask 
	 * @Description: 执行所有当天及当天之前的消息类任务
	 * TODO  
	 * @author baozj
	 * @return 
	 * @throws
	 * @retrun boolean
	 */
	boolean insertMessageTask();
}

