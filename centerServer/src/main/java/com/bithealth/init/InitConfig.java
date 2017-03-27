package com.bithealth.init;

import javax.servlet.ServletContext;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.web.context.ServletContextAware;

import com.bithealth.centCore.msgCenterCore.task.MsgCenterCodeTask;
import com.bithealth.centCore.schedule.task.MsgScheduleTask;
import com.bithealth.centCore.sms.task.SmsSendStatusUpdateTask;
import com.bithealth.centCore.sms.task.SmsSendTask;


public class InitConfig implements InitializingBean, ServletContextAware {

	protected static Logger logger = Logger.getLogger(InitConfig.class);


	@Override
	public void setServletContext(ServletContext servletContext) {
		java.util.Timer timer = new java.util.Timer(false);
		
		//发送失败消息定时再次发送定时任务
/*		MsgCenterCodeTask task = new MsgCenterCodeTask();
		timer.schedule(task,0,300000l);
		logger.info("发送失败消息定时再次发送定时任务启动完成");*/
		
		//短信定时发送任务
/*		SmsSendTask smsSendTask = new SmsSendTask();
		timer.schedule(smsSendTask, 0, 2*60*1000);
		logger.info("短信定时发送任务启动完成");*/
		
		//短信发送状态定时更新任务
		SmsSendStatusUpdateTask smsSendStatusUpdateTask = new SmsSendStatusUpdateTask();
		timer.schedule(smsSendStatusUpdateTask, 0, 2*60*1000);
		logger.info("短信发送状态定时更新任务启动完成");
		
		//定时发送 定时消息到消息中心统计表任务
		MsgScheduleTask msgScheduleTask = new MsgScheduleTask();		
		timer.schedule(msgScheduleTask, 0, 2*60*1000);
		logger.info("定时消息 定时发送任务任务启动完成");
		
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		
	}
	
}
