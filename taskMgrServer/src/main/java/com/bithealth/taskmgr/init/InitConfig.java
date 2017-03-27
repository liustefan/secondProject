package com.bithealth.taskmgr.init;


import java.util.List;

import javax.annotation.Resource;

import net.sf.ehcache.Cache;

import org.apache.log4j.Logger;
import org.quartz.Scheduler;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bithealth.taskMgrCore.constants.Constants;
import com.bithealth.taskMgrCore.model.JobConfig;
import com.bithealth.taskMgrCore.quartz.MeasureResultMsgSendJob;
import com.bithealth.taskMgrCore.quartz.QuertzScheduleJob;
import com.bithealth.taskMgrCore.server.IJobConfigService;
//
//import com.data.bean.CenterConfig;
//import com.data.bean.JobConfig;
//import com.data.constants.Constants;
//import com.data.quartz.QuertzScheduleJob;
//import com.data.service.ICenterConfigService;
//import com.data.service.IJobConfigService;
//import com.data.thread.ConsumerThread;
//import com.data.thread.ZLJYGetDataTask;
//import com.data.utils.EcacheManager;

/**
 * @ClassName:     InitConfig.java 
 * @Description:   初始化配置信息
 * @author         谢美团  
 * @version        V1.0   
 * @Date           2015年12月17日 下午4:00:40
*****/
public class InitConfig implements ApplicationListener<ContextRefreshedEvent> {
	
	private static boolean isCalled = false;
	
	private  Logger logger = Logger.getLogger(InitConfig.class); 
 
	
	@Resource(name="jobConfigService")  
	private  IJobConfigService jobConfigService; 
	@Resource
	QuertzScheduleJob quertzScheduleJob;
	@Resource
	MeasureResultMsgSendJob measureResultMsgSendJob;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		if(!isCalled){
			isCalled = true;
			//初始化定时任务
			try{
				List<JobConfig> jobList = jobConfigService.selectAll(Constants.detaCenter);
				if(null!=jobList && jobList.size()>0){
					for(JobConfig job:jobList){
						if(job.getJobStatus().equals("0")){
							quertzScheduleJob.startJob(job);
						}
					}
				}
				logger.info("定时任务初始化成功。");
			}catch(Exception e){
				e.printStackTrace();
				logger.info("初始化定时任务失败。"+e);
			}
			
			try {
				//new一个线程 执行消费线程实时消费消息队列中的消息
				new Thread(){
					@Override
					public void run() {
						try {
							measureResultMsgSendJob.measureResultMsgSend();
							logger.error("启动测量结果消息发送线程成功");
						} catch (Exception e) {
							logger.error("启动测量结果消息发送线程失败。无法接受MQ中的消息命令。",e);
						}
					}
				}.start();
			} catch (Exception e) {
				logger.error("启动测量结果消息发送线程失败。无法接受MQ中的消息命令。",e);
			}
			
		}
	}

}
