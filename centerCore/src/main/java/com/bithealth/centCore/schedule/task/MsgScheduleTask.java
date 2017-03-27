
package com.bithealth.centCore.schedule.task;

import java.util.TimerTask;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.bithealth.centCore.schedule.service.MessageScheduleService;

/**
 * 类名称: MsgScheduleTask  
 * 功能描述: 定时消息发送Task 
 * 日期: 2017年1月6日 下午1:51:50 
 * 
 * @author 谢美团
 * @version  
 */
@Service("msgScheduleTask")
public class MsgScheduleTask extends TimerTask {

	protected static Logger logger = Logger.getLogger(MsgScheduleTask.class);

	@Autowired
	MessageScheduleService messageScheduleService;

	@Override
	public void run() {
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
		messageScheduleService.sendMsgToMsgCenter();
	}



	
	
	
}
