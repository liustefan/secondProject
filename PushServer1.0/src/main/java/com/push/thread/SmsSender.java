package com.push.thread;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.annotation.Resource;

import net.sf.ehcache.Cache;
import net.sf.ehcache.Element;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.push.Utils.SmsPushHelper;
import com.push.Utils.TimeUtil;
import com.push.constants.Constants;
import com.push.model.SmsConfig;
import com.push.model.SmsQueue;
import com.push.model.WsdlSmsBean;
import com.push.service.SmsOrVioceService;
import com.push.service.Impl.PushMsgServiceImpl;


/**
 * @ClassName:     SmsSender.java 
 * @Description:   短信语音发送器
 * @author         谢美团  
 * @version        V1.0   
 * @Date           2015年12月9日 上午11:41:14
*****/
@Service 
public class SmsSender{

	private static Logger logger = Logger.getLogger(PushMsgServiceImpl.class); 
	private static boolean isStart = false;
	
	private boolean isContinue = true;
	
    @Resource(name="smsOrVioceService")  
    private SmsOrVioceService smsOrVioceService;
    
    Cache cache1 = EcacheManager.getCache(Constants.CACHE_SMS_LEVEL1);
    Cache cache2 = EcacheManager.getCache(Constants.CACHE_SMS_LEVEL2);
    Cache cache3 = EcacheManager.getCache(Constants.CACHE_SMS_LEVEL3);
    Cache cache4 = EcacheManager.getCache(Constants.CACHE_SMS_LEVEL4);
    Cache cache5 = EcacheManager.getCache(Constants.CACHE_SMS_LEVEL5);
    
	private void invoke(){		
		if(!isStart){
			logger.info("短信语音循环发送任务已经启动。不需要在启动");
			return;
		}
		logger.info("短信语音循环发送任务开始启动。");

		while(isContinue){
			long startTime = System.currentTimeMillis();
			boolean isBreak = false;
			try{
				isStart = true;
				for(int i=1;i<=5;i++){
					
					if(isBreak){//循环时间超过 定义的时间段（如5秒）跳出本次循环，重新获取缓存中的数据
						break;
					}
					
					if(i==1){
						isBreak = forCaches(cache1,startTime);
					}else if(i==2){
						isBreak = forCaches(cache2,startTime);
					}else if(i==3){
						isBreak = forCaches(cache3,startTime);
					}else if(i==4){
						isBreak = forCaches(cache4,startTime);
					}else{
						isBreak = forCaches(cache5,startTime);
					}
				}

			}catch(Exception e){
				logger.info("短信语音发送任务运行异常。"+e);
			}
		}

	}
	
	private boolean forCaches(Cache cache,long startTime) throws Exception{
		boolean isBreak = false;
		for(Object key:cache.getKeys()){
			SmsQueue smsQueue = (SmsQueue)cache.get(key).getObjectValue();
			cache.remove(key);
			send(smsQueue);
			if((System.currentTimeMillis()-startTime)>5000){
				isBreak = true;
				break;
			}
		}
		return isBreak;
	}
	
	
	@SuppressWarnings("unchecked")
	private void send(SmsQueue smsQueue) throws Exception{
		WsdlSmsBean wsdlSmsBean = new WsdlSmsBean();
		List<SmsConfig> configList = null;
		//获取配置信息缓存
		Cache config = EcacheManager.getCache(Constants.CACHE_SMS_CONFIG);
		
		if(config.getSize() == 0){ //配置信息未成初始化，重新初始化
			configList = smsOrVioceService.initConfig();
		}else{
			Element elememt = config.get(Constants.CACHE_SMS_CONFIG);
			if(elememt != null){
				configList = (List<SmsConfig>) elememt.getObjectValue();
			}
		}
		
		if(configList != null){
			boolean isFindConfig = false;
			for(SmsConfig smsConfig:configList){
				if(smsQueue.getServerId() == smsConfig.getServerId()){ //循环找到组织对应的账号信息，封装相关信息，结束循环
					wsdlSmsBean.setUsername(smsConfig.getAccount());
					wsdlSmsBean.setPassword(smsConfig.getPassWord());
					wsdlSmsBean.setPresendTime(TimeUtil.formatDatetime2(new Date()));
					wsdlSmsBean.setFrom(smsQueue.getMsgId());
					wsdlSmsBean.setTo(smsQueue.getPhones());
					wsdlSmsBean.setText(smsQueue.getContent());
					wsdlSmsBean.setEndpointURL(smsConfig.getEndpointURL());
					isFindConfig = true; 
					break;
				}
			}
			
			if(isFindConfig){
				Object obj = SmsPushHelper.smsSend(wsdlSmsBean);
				
				
				
				
				
				logger.info("短信语音已发送，msgID："+smsQueue.getMsgId());
			}else{
				logger.info("未找到发送的网关账号信息，发送失败。");
			}
		}else{
			logger.info("未找到发送的网关账号信息，发送失败。");
		}

	}
	
	
	
	
}
