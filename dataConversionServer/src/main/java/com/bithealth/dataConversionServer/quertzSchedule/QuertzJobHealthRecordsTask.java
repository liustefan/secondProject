package com.bithealth.dataConversionServer.quertzSchedule;

import org.apache.log4j.Logger;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.PersistJobDataAfterExecution;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.bithealth.dataConversionServer.qiangHua.thread.HealthRecordsTask;



@Service
public class QuertzJobHealthRecordsTask implements Job   {

	private static final Logger logger = Logger.getLogger(QuertzJobHealthRecordsTask.class);
	@Autowired
	private HealthRecordsTask healthRecordsTask;
	
	
	public void execute(JobExecutionContext jobexecutioncontext)
		throws JobExecutionException {
	    	healthRecordsTask.insertDbToHealthRecords();
	}
}