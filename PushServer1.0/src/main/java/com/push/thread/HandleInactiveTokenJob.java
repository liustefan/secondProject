package com.push.thread;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.push.Utils.APNSPushHelper;
import com.push.controller.PushMsgController;
import com.push.dao.PushMemberMapper;


@Service 
public class HandleInactiveTokenJob{
	
	private static Logger logger = Logger.getLogger(HandleInactiveTokenJob.class); 
	
	APNSPushHelper apnsPushHelper = APNSPushHelper.getAPNSPushHelper();
	
	@Autowired
	private PushMemberMapper pushMemberMapper;
	
	public void handleInactiveToken(){
		
		logger.info("ios失效设备token定时清理任务启动。");
		Map<String, Date> tokenMap = apnsPushHelper.getInactiveDevices();
		StringBuffer buffer = new StringBuffer();
		List<String> tokenList = new ArrayList<String>();
		for(String token:tokenMap.keySet()){
			buffer.append(token+", ");
			tokenList.add(token);
		}
		logger.info("失效token ："+buffer.toString());
		
		if(tokenList.size() > 0){
			pushMemberMapper.updateMemberLineStatus(tokenList);
		}
	}
}
