package com.bithealth.dataConversionServer.quertzSchedule;

import org.apache.log4j.Logger;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.PersistJobDataAfterExecution;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.bithealth.dataConversionServer.qiangHua.thread.DiabetesVisitsTask;




@Service
public class QuertzJobDiabetesVisitsTask implements Job   {

    private static final Logger logger = Logger.getLogger(QuertzJobDiabetesVisitsTask.class);
    @Autowired
    private DiabetesVisitsTask diabetesVisitsTask;

    
    public void execute(JobExecutionContext jobexecutioncontext){
	try{  	
	    logger.info("开始执行定时获取随访糖尿病。");
	    diabetesVisitsTask.saveDiabetesVisitsData();
	    logger.info("定时获取随访糖尿病完成。");
	}catch(Exception e){
	    logger.info("开始获取随访糖尿病出现异常。");
	    e.fillInStackTrace();
	}
    }
}