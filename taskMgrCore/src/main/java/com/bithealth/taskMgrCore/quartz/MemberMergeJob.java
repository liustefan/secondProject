
package com.bithealth.taskMgrCore.quartz;

import org.apache.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bithealth.taskMgrCore.server.MemberMergeService;


/**
 * 类名称: MemberMergeJob  
 * 功能描述: 会员测量，关注等数据合并定时任务
 * 日期: 2016年12月21日 下午2:19:53 
 * 
 * @author 谢美团
 * @version  
 */
@Service("memberMergeJob")
public class MemberMergeJob implements Job {

    private static final Logger logger = Logger.getLogger(MemberMergeJob.class);
    

   // public static boolean isStart = false;
	
	@Autowired
	private MemberMergeService memberMergeService;

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		memberMergeService.memberMerge();
	}

}
