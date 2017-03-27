package com.bithealth.centCore.schedule.service;

import com.bithealth.sdk.core.generic.GenericBaseService;
import com.bithealth.centCore.schedule.model.MessageSchedule;
import com.bithealth.centCore.schedule.model.MessageScheduleExample; 

public interface MessageScheduleService extends GenericBaseService<MessageSchedule,MessageScheduleExample, Long > {    
	
	/**
	 * @Title:sendMsgToMsgCenter 
	 * @Description:发送定时消息到消息中心统计表中
	 * @author 谢美团 
	 * @throws
	 * @retrun void
	 */ 
	public void sendMsgToMsgCenter();
}
