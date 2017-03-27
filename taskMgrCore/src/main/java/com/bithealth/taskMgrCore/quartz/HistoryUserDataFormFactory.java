package com.bithealth.taskMgrCore.quartz;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.PersistJobDataAfterExecution;
 

/**
 * @ClassName:     ZLJYHistoryUserDataFormFactory.java 
 * @Description:    定时任务服务  查看用户
 * @author         柴仕富
 * @version        V1.0   
 * @Date           2016年08月31日 下午3:59:32
*****/
@PersistJobDataAfterExecution  
@DisallowConcurrentExecution
public class HistoryUserDataFormFactory implements Job  {
    	private static final Logger logger = Logger.getLogger(HistoryUserDataFormFactory.class);
 
	public void execute(JobExecutionContext context) throws JobExecutionException {
	    try {


	    	System.out.println(" 被调用的时间是："+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
	    	  
		} catch (Exception e) {
		    logger.info("QuartzJobFactory执行失败。");  
		    e.printStackTrace();
		    
		}
	    
	}


    
}
