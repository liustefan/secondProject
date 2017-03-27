/**
 * @PackageName:      com.bithealth.taskMgrCore.quartz
 * @FileName:     MemberUpdateJob.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      liuhm
 * @version      V1.0  
 * @Createdate:  2016年9月6日 下午5:54:54  
 * 
 */
package com.bithealth.taskMgrCore.quartz;

import org.apache.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;

import com.bithealth.memberCore.task.MemberSyncService;

/**
 * 类名称: MemberUpdateJob  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年9月6日 下午5:54:54 
 * 
 * @author liuhm
 * @version  
 */
public class MemberUpdateJob implements Job {

private static final Logger logger = Logger.getLogger(MemberUpdateJob.class);
	
	@Autowired
	private MemberSyncService memberSyncService;

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		logger.info("会员修改同步任务执行");
		memberSyncService.updateMember();
	}

}
