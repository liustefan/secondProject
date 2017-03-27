package com.push.service.Impl;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import net.sf.ehcache.Cache;
import net.sf.ehcache.Element;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.push.Utils.UniqueIdCreater;
import com.push.constants.Constants;
import com.push.controller.PushTagController;
import com.push.dao.SmsOrVioceDao;
import com.push.model.SmsBean;
import com.push.model.SmsConfig;
import com.push.model.SmsQueue;
import com.push.model.SmsReceiverRelation;
import com.push.model.SmsRequestBean;
import com.push.service.SmsOrVioceService;
import com.push.thread.EcacheManager;


/**
 * 短信语音发送服务
 * @author 谢美团
 * @version v1.0
 *
 */
@Service("smsOrVioceService")
public class SmsOrVioceServiceImpl implements SmsOrVioceService{

	private static Logger logger = Logger.getLogger(PushTagController.class); 
	@Autowired
	SmsOrVioceDao smsOrVioceDao;

	@Override
	@SuppressWarnings("unchecked")
	public void smsOrVoiceSend(SmsRequestBean smsParam) throws Exception {
		SmsBean text = new SmsBean();
		
		BeanUtils.copyProperties(smsParam, text);
		
		text.setType(smsParam.getBusinessType());
		text.setMsgId(UniqueIdCreater.getUniqueNumberId());
		//保存发送短信信息
		smsOrVioceDao.saveSmsInfo(text);
		
		//保存短信和接收者关联关系
		String phonesStr = smsParam.getPhones();
		String[] phones = phonesStr.split(",");
		List<SmsReceiverRelation> list = new ArrayList<SmsReceiverRelation>();
		for(String phone:phones){
			SmsReceiverRelation smsRelation = new SmsReceiverRelation();
			smsRelation.setMsgId(text.getMsgId());
			smsRelation.setReceivePhone(phone);
		}
		smsOrVioceDao.saveSmsReceiverRelation(list);
		
		//获取优先级对应的缓存队列
		Cache cache = EcacheManager.getCache(Constants.CACHE_SMS_LEVEL+String.valueOf(smsParam.getLevel()));
		//将待发送短信放入缓存队列中
		SmsQueue smsQueue  = new SmsQueue();
		BeanUtils.copyProperties(text, smsQueue);
		smsQueue.setPhones(smsParam.getPhones());
		cache.put(new Element(smsQueue.getMsgId(),smsQueue));
		logger.info(smsQueue+"，缓存发送队列成功。");
		
	}



	@Override
	public List<SmsConfig> initConfig() throws Exception {
		//获取配置信息缓存
		Cache config = EcacheManager.getCache(Constants.CACHE_SMS_CONFIG);
		List<SmsConfig>  cofigList = smsOrVioceDao.querySmsConfig();
		if(cofigList != null && cofigList.size() != 0 ){
			config.put(new Element(Constants.CACHE_SMS_CONFIG,cofigList));
			logger.info("初始化短信配置信息缓存成功。");
		}else{
			logger.info("未获取到config信息，初始化短信推送配置信息失败。");
		}
		return cofigList;
	}



    
    
}