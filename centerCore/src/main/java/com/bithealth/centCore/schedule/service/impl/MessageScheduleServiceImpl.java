package com.bithealth.centCore.schedule.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource; 

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service; 

import com.bithealth.sdk.common.utils.TimeUtil;
import com.bithealth.sdk.core.feature.orm.mybatis.Page;
import com.bithealth.sdk.core.generic.GenericBaseDao;
import com.bithealth.sdk.core.generic.GenericBaseServiceImpl; 
import com.bithealth.centCore.msgCenterCore.model.MessageCenter;
import com.bithealth.centCore.msgCenterCore.service.MessageCenterFacadeService;
import com.bithealth.centCore.schedule.dao.MessageScheduleMapper;
import com.bithealth.centCore.schedule.model.MessageSchedule; 
import com.bithealth.centCore.schedule.model.MessageScheduleExample;
import com.bithealth.centCore.schedule.service.MessageScheduleService;
import com.bithealth.centCore.schedule.task.MsgScheduleTask;

@Service("messagescheduleService") 
public class MessageScheduleServiceImpl extends GenericBaseServiceImpl<MessageSchedule,MessageScheduleExample,
      Long> implements MessageScheduleService {
	protected static Logger logger = Logger.getLogger(MessageScheduleServiceImpl.class);  
	
    @Resource 
    MessageScheduleMapper messagescheduleMapper;

	@Autowired
	MessageCenterFacadeService  msgCenterService;
        
    @Override
    public GenericBaseDao<MessageSchedule,MessageScheduleExample,  Long > getDao() {
        return messagescheduleMapper;
    }

	@Override
	public void sendMsgToMsgCenter() {
		int pageNo = 1;
		int pageSize = 500;
		int second = -24*60*60;
		boolean isEnd = false;
		while(!isEnd){
			try{
				Page<MessageSchedule> page = new Page<MessageSchedule>(pageNo,pageSize);
				MessageScheduleExample example = new MessageScheduleExample();
				example.createCriteria().andScheduleTimeBetween(TimeUtil.addSecond(new Date(), second), new Date());
				
				List<MessageSchedule>  scheduleMsgList = messagescheduleMapper.selectByExampleAndPage(page, example);
				if(scheduleMsgList == null || scheduleMsgList.size() < pageSize){
					isEnd = true;
				}
				for(MessageSchedule messageSchedule:scheduleMsgList){
					MessageCenter messageCenter = new MessageCenter();
					BeanUtils.copyProperties(messageSchedule, messageCenter);
					messageCenter.setLogID(null);
					boolean isSuccess = msgCenterService.insertOrUpdateMessageSynchronized(messageCenter);
					if(isSuccess){//发送成功，删除定时消息
						messagescheduleMapper.deleteByPrimaryKey(messageSchedule.getLogID());
					}
				}
				pageNo++;
			}catch(Exception e){
				logger.error("定时消息发送任务异常。"+e.getMessage());
			}
		}
	}  
}
