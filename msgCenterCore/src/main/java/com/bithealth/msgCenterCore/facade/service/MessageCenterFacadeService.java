/**
 * @PackageName:      com.bithealth.msgCenterCore.facade.service
 * @FileName:     MessageCenterFacadeService.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      胡翔  * 
 * @version      V1.0  
 * @Createdate:  2016年7月26日 下午2:41:57  
 * 
 */
package com.bithealth.msgCenterCore.facade.service;

import java.util.List;

import com.bithealth.msgCenterCore.model.MessageCenter;
import com.bithealth.msgCenterCore.model.MessageCenterExample;
import com.bithealth.msgCenterCore.model.SmsConfig;
import com.bithealth.msgCenterCore.model.SmsSearchParams;
import com.bithealth.msgCenterCore.model.SmsSendParams;
import com.bithealth.msgCenterCore.model.SmsStatistic;
import com.bithealth.sdk.client.http.Response;
import com.bithealth.sdk.core.feature.orm.mybatis.Page;
import com.bithealth.sdk.core.generic.GenericBaseService;

/**
 * 类名称: MessageCenterFacadeService  
 * 功能描述: 消息中心对外接口  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年7月26日 下午2:41:57 
 * 
 * @author 曾许华
 * @version  
 */
public interface MessageCenterFacadeService extends GenericBaseService<MessageCenter, MessageCenterExample, Integer>{
	/**
	 * 
	 * @Title:insertMessage 
	 * @Description: 同步插入或更新消息数据.  
	 * @author 胡翔
	 * @param 要插入或更新的消息记录对象
	 * @return 返回数据处理结果
	 */
	Response insertOrUpdateMessageSynchronized(MessageCenter messageCenter) throws Exception;
	
	/**
	 * 
	 * @Title:insertMessage 
	 * @Description: 异步调用插入或更新消息数据.  
	 * @author 胡翔
	 * @param 要插入或更新的消息记录对象
	 * @return 返回数据处理结果
	 */
	Response insertOrUpdateMessageAsynchronous(MessageCenter messageCenter) throws Exception;
	/**
	 * 
	 * @Title:getMessageList 
	 * @Description:TODO(根据IDS查询条件获取消息列表).  
	 * @author 曾许华
	 * @return 查询得到的分页结果
	 */
	List<Integer> getMessageListByIds(List list,Byte msgType);
	
	/**
	 * 
	 * @Title:deleteById 
	 * @Description:TODO(通过ID删除已发送的消息).  
	 * @author 曾许华
	 * @param id 要删除的消息中心表ID
	 * @return 返回删除结果
	 */
	boolean deleteBySendAndReceiver(String send,String receiver,Byte msgType);
	/**
	 * 
	 * @Title:deleteById 
	 * @Description:TODO(通过ID删除已发送的消息).  
	 * @author 曾许华
	 * @param id 要删除的消息中心表ID
	 * @return 返回删除结果
	 */
	boolean deleteById(Integer id,Byte msgType,String recieverGUID);

	
	/**
	 * @Title:saveSmsConfig 
	 * @Description:新增或者更新短信配置
	 * @author 谢美团
	 * @param smsConfig
	 * @return 
	 * @throws
	 * @retrun boolean
	 */ 
	boolean saveSmsConfig(SmsConfig smsConfig);
	
	/**
	 * @Title:smsSend 
	 * @Description:发送短信
	 * @author 谢美团
	 * @param smsSendParams
	 * @return 
	 * @throws
	 * @retrun boolean
	 */ 
	boolean smsSend(SmsSendParams smsSendParams);
	
	
	/**
	 * @Title:getSmsList 
	 * @Description:  获取短信发送记录
	 * @author 谢美团
	 * @param smsParams
	 * @return 
	 * @throws
	 * @retrun List<SmsSendDetail>
	 */ 
	Page getSmsList(SmsSearchParams smsParams);
	
	
	/**
	 * @Title:saveSmsConfig 
	 * @Description:获取组织的短信配置信息
	 * @author 谢美团
	 * @param smsConfig
	 * @return 
	 * @throws
	 * @retrun SmsConfig
	 */ 
	SmsConfig getSmsConfig(SmsConfig smsConfig);
	
	
	/**
	 * @Title:生成短信验证码的方法  @Description:(生成短信验证码的方法). TODO(这里描述这个方法适用条件 执行流程 使用方法
	 *                   注意事项– 可选).
	 * @author "jason chai"
	 * @param smstype
	 *            短信类型
	 * @param receivenum
	 *            接收手机号码
	 * @param charCount
	 *            验证码位数
	 * @param expire
	 *            多长时间有效：以秒做为单位  @throws  *  code 生成验证码
	 */
	 String sendSmsCode(String smstype, String receivenum, int charCount,
			long expire)  ;

	/**
	 * @Title:getSmsCode  @Description:(获取最近有效短信验证码的方法). 
	 * 
	 * TODO(这里描述这个方法适用条件 执行流程
	 *                   使用方法 注意事项– 可选).
	 * @author "jason chai"
	 * @param smstype
	 *            短信类型
	 * @param receivenum
	 *            接收手机号码
	 * @return  @throws  * @retrun String
	 */
	  String getSmsCode(String smstype, String receivenum);
		
		 
		/**
		 * @Title:getSmsStatistic 
		 * @Description:获取短信发送记录统计数据
		 * @author 谢美团
		 * @param smsParams
		 * @return 
		 * @throws
		 * @retrun List<SmsStatistic>
		 */ 
		List<SmsStatistic> getSmsStatistic(SmsSearchParams smsParams);
		
		boolean deleteSmsConfig(SmsConfig smsConfig);
}
