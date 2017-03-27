package com.bithealth.dataConversionServer.quertzSchedule;

import java.util.Date;

import org.apache.log4j.Logger;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.PersistJobDataAfterExecution;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.bithealth.dataConversionServer.qiangHua.thread.HealthExamTask;


/**
 * @ClassName:     HealthExamTask.java 
 * @Description:   体检数据定时任务类
 * @author         谢美团  
 * @version        V1.0   
 * @Date           2016年2月26日 上午10:43:16
*****/

@Service
public class QuertzJobHealthExamTask implements Job   {

    private static final Logger logger = Logger.getLogger(QuertzJobHealthExamTask.class);
	@Autowired
	private HealthExamTask healthExamTask;
	

	public void execute(JobExecutionContext jobexecutioncontext)throws JobExecutionException {
		logger.info("开始调用QuertzJobHealthExamTask"+new Date());
		healthExamTask.timingGetHealthExamData();
		logger.info("调用完成QuertzJobHealthExamTask");
	}	
}