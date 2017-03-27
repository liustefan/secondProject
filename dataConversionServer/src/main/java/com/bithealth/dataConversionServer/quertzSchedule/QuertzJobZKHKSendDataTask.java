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

import com.bithealth.dataConversionServer.zhongLian.thread.ZKHKSendDatasTask;



/**
 * @ClassName:     QuertzJobOneTask.java 
 * @Description:   调度任务：zkhk发送数据到数据中心服务器
 * @author         Administrator  
 * @version        V1.0   
 * @Date           2015年12月28日 上午9:59:11
 *****/
@Service
public class QuertzJobZKHKSendDataTask implements Job   {

    private static final Logger logger = Logger.getLogger(QuertzJobZKHKSendDataTask.class);
    
    @Autowired
    private ZKHKSendDatasTask zkhkSendDatasTask;

    /** 
	 * @Title: execute 
	 * @Description: TODO 
	 * @param:     
	 * @return:      
	 * @throws
	 */
    
    public void execute(JobExecutionContext context) throws JobExecutionException {
		try {
		     zkhkSendDatasTask.SendDataToZLJY();
		     zkhkSendDatasTask.SendDataToGoodDoctor();
            logger.info("开始执行发送zkhk的数据到数据中心服务器。");
        } catch (Exception e) {
            logger.info("QuertzJobZKHKSendDataTask执行失败。");  
            e.printStackTrace();
            
        }
    }


    
}
