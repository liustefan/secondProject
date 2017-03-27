/*
 * SmsSendDetailMapper.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-11-28 Created
 */
package com.bithealth.centCore.sms.dao;

import java.util.List;
import java.util.Map;

import com.bithealth.centCore.sms.model.SmsSearchParams;
import com.bithealth.centCore.sms.model.SmsSendDetail;
import com.bithealth.centCore.sms.model.SmsSendDetailExample;
import com.bithealth.centCore.sms.model.SmsStatistic;
import com.bithealth.sdk.core.feature.orm.mybatis.Page;
import com.bithealth.sdk.core.generic.GenericBaseDao;

public interface SmsSendDetailMapper extends GenericBaseDao<SmsSendDetail, SmsSendDetailExample, Integer> {
	
	
	/**
	 * @Title:insertByBatch 
	 * @Description:批量插入
	 * @author 谢美团
	 * @param list
	 * @return 
	 * @throws
	 * @retrun int
	 */ 
	public int insertByBatch(List<SmsSendDetail> list);
	
	/**
	 * @Title:getSmsListByParams 
	 * @Description:查询组织短信发送记录
	 * @author 谢美团
	 * @param smsParams
	 * @return 
	 * @throws
	 * @retrun List<SmsSendDetail>
	 */ 
	public List<SmsSendDetail> selectSmsByParams(SmsSearchParams smsParams,Page<SmsSendDetail> page);
	
	/**
	 * @Title:exProc_proc_smssend_getStatisticByOrgID 
	 * @Description:短信统计
	 * @author 谢美团
	 * @param paramMap
	 * @return 
	 * @throws
	 * @retrun List<SmsStatistic>
	 */ 
	public List<SmsStatistic> exProc_proc_smssend_getStatisticByOrgID(Map paramMap);
	
	
	/**
	 * @Title:selectSmsSumByOrgId 
	 * @Description:根据参数查询组织的发送短信的总数量
	 * @author 谢美团
	 * @param orgId
	 * @return 
	 * @throws
	 * @retrun Integer
	 */ 
	public Integer selectSmsSumByParam(Map paramMap);
	

	/**
	 * @Title:selectPhoneSmsSum 
	 * @Description:查询手机号的短信发送总数量
	 * @author 谢美团
	 * @param phone
	 * @return 
	 * @throws
	 * @retrun Integer
	 */ 
	public Integer selectPhoneSmsSum(Map paramMap);
	
	/**
	 * @Title:selectPhoneSmsRepeatSum 
	 * @Description:查询手机号当天重复的短信数量
	 * @author 谢美团
	 * @param paramMap
	 * @return 
	 * @throws
	 * @retrun Integer
	 */ 
	public Integer selectPhoneSmsRepeatSum(Map paramMap);
	
	

}