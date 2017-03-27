 
/**
 * @PackageName:      com.bithealth.taskMgrCore.quartz
 * @FileName:     ManageschemeTaskJob.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      名字  * 
 * @version      V1.0  
 * @Createdate:  2016年12月29日 下午3:23:06  
 * 
 */

package com.bithealth.taskMgrCore.quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;

import com.bithealth.healthCore.facede.service.ManageschemeTaskFacedeService;


/**
 * 类名称: ManageschemeTaskJob  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年12月29日 下午3:23:06 
 * 
 * @author baozj
 * @version  
 */
public class ManageschemeTaskJob implements Job {

	@Autowired
	ManageschemeTaskFacedeService service;
	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see org.quartz.Job#execute(org.quartz.JobExecutionContext)
	 */
	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		service.insertMessageTask();
	}

}

