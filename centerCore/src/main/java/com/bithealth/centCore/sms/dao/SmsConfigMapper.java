/*
 * SmsConfigMapper.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-12-08 Created
 */
package com.bithealth.centCore.sms.dao;

import java.util.List;

import com.bithealth.centCore.sms.model.SmsConfig;
import com.bithealth.centCore.sms.model.SmsConfigExample;
import com.bithealth.centCore.sms.model.SmsSendDetail;
import com.bithealth.sdk.core.generic.GenericBaseDao;

public interface SmsConfigMapper extends GenericBaseDao<SmsConfig, SmsConfigExample, Integer> {
	
	/**
	 * @Title:selectTToBeSendSms 
	 * @Description:查询待发送短信列表
	 * @author 谢美团
	 * @return 
	 * @throws
	 * @retrun List<SmsConfig>
	 */ 
	public List<SmsConfig> selectToBeSendSms();
	
	/**
	 * @Title:selectHaveSendStatusSms 
	 * @Description:查询发送状态为已发送的短信呢记录，并按日期，发送号码分组
	 * @author 谢美团
	 * @return 
	 * @throws
	 * @retrun List<SmsSendDetail>
	 */ 
	public List<SmsConfig>  selectHaveSendStatusSms();
}