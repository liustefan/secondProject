package com.bithealth.centCore.sms.service;

import java.util.List;

import com.bithealth.sdk.core.generic.GenericBaseService;
import com.bithealth.centCore.sms.model.SmsConfig;
import com.bithealth.centCore.sms.model.SmsConfigExample; 

public interface SmsConfigService extends GenericBaseService<SmsConfig,SmsConfigExample,Integer > {  
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
