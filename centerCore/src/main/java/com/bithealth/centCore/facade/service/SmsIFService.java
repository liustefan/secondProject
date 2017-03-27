 

package com.bithealth.centCore.facade.service;

import java.util.List;

import com.bithealth.centCore.sms.model.SmsConfig;
import com.bithealth.centCore.sms.model.SmsSearchParams;
import com.bithealth.centCore.sms.model.SmsSendDetail;
import com.bithealth.centCore.sms.model.SmsSendParams;
import com.bithealth.centCore.sms.model.SmsStatistic;
import com.bithealth.centCore.sms.taobao.AlibabaSmsReq;
import com.bithealth.sdk.core.feature.orm.mybatis.Page;




/**
 * 类名称: SmsIFService  
 * 功能描述:短信对外接口 
 * 日期: 2016年11月28日 下午2:52:40 
 * 
 * @author 谢美团
 * @version  
 */
public interface SmsIFService  {
	

	/**
	 * @Title:saveSmsConfig 
	 * @Description:保存短信配置信息
	 * @author 谢美团
	 * @param SmsConfig
	 * @return
	 * @throws Exception 
	 * @throws
	 * @retrun boolean
	 */ 
	public boolean saveSmsConfig_trans(SmsConfig smsConfig) throws Exception;
	
	
	/**
	 * @Title:getSmsConfigByOrgid 
	 * @Description:根据组织id获取组织短信配置
	 * @author 谢美团
	 * @param smsConfig
	 * @return
	 * @throws Exception 
	 * @throws
	 * @retrun SmsConfig
	 */ 
	public SmsConfig getSmsConfigByOrgid(SmsConfig smsConfig) throws Exception;
	
	
	/**
	 * @Title:getSmsListByParams 
	 * @Description:根据参数查询短信记录
	 * @author 谢美团
	 * @param smsParams
	 * @return
	 * @throws Exception 
	 * @throws
	 * @retrun List<SmsSendDetail>
	 */ 
	public Page<SmsSendDetail> getSmsListByParams(SmsSearchParams smsParams) throws Exception;
	
	
	/**
	 * @Title:smsSend 
	 * @Description:发送短信到指定手机上
	 * @author 谢美团
	 * @param smsParams
	 * @return
	 * @throws Exception 
	 * @throws
	 * @retrun boolean
	 */ 
	public boolean smsSend(SmsSendParams smsParams,SmsConfig smsConfig) throws Exception;
	
	
	/**
	 * @Title:smsSendAndUpdate 
	 * @Description:发送并更新结果
	 * @author 谢美团
	 * @param AlibabaSmsReq
	 * @return
	 * @throws Exception 
	 * @throws
	 * @retrun boolean
	 */ 
	public boolean smsSendAndUpdate(AlibabaSmsReq AlibabaSmsReq,Integer sSendID,Integer failCount) throws Exception;
	
	
	/**
	 * @Title:isnertSms 
	 * @Description:保存短信发送记录到数据库中 
	 * @author 谢美团
	 * @param smsParams
	 * @return
	 * @throws Exception 
	 * @throws
	 * @retrun boolean
	 */ 
	public SmsConfig isnertSms(SmsSendParams smsParams) throws Exception;
	
	
	/**
	 * @Title:selectSmsStatistic 
	 * @Description:根据参数获取短信发送记录统计数据
	 * @author 谢美团
	 * @param serverId
	 * @param orgIdListStr
	 * @param startTime
	 * @param endTime
	 * @param smsType
	 * @param recvNumber
	 * @return
	 * @throws Exception 
	 * @throws
	 * @retrun List<SmsStatistic>
	 */ 
	public List<SmsStatistic> selectSmsStatistic(SmsSearchParams smsParams) throws Exception;
	
	/**
	 * @Title:getTemplateNo 
	 * @Description:根据发送的短信类型获取短信模板id  
	 * @author 谢美团
	 * @param smsConfig
	 * @param smsType
	 * @return 
	 * @throws
	 * @retrun String
	 */ 
	public String getTemplateNo(SmsConfig smsConfig,Integer smsType);
	

}

