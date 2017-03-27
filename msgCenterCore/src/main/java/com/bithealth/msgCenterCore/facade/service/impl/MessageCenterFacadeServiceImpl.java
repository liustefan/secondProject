/**
 * @PackageName:      com.bithealth.msgCenterCore.facade.service.impl
 * @FileName:     MessageCenterFacadeServiceImpl.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      胡翔  * 
 * @version      V1.0  
 * @Createdate:  2016年7月28日 下午2:10:15  
 * 
 */
package com.bithealth.msgCenterCore.facade.service.impl;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bithealth.agentCore.agent.RedicrectService;
import com.bithealth.agentCore.bean.Parameter;
import com.bithealth.agentCore.enums.MessageMethodEnum;
import com.bithealth.common.cache.model.CacheLog;
import com.bithealth.common.cache.service.ICacheLogService;
import com.bithealth.msgCenterCore.facade.service.MessageCenterFacadeService;
import com.bithealth.msgCenterCore.model.MessageCenter;
import com.bithealth.msgCenterCore.model.MessageCenterExample;
import com.bithealth.msgCenterCore.model.ResponseObject;
import com.bithealth.msgCenterCore.model.SmsConfig;
import com.bithealth.msgCenterCore.model.SmsSearchParams;
import com.bithealth.msgCenterCore.model.SmsSendParams;
import com.bithealth.msgCenterCore.model.SmsStatistic;
import com.bithealth.sdk.client.http.Response;
import com.bithealth.sdk.common.cache.memcached.MemcacheMgr;
import com.bithealth.sdk.common.utils.Md5Utils;
import com.bithealth.sdk.common.utils.TimeUtil;
import com.bithealth.sdk.core.feature.orm.mybatis.Page;
import com.bithealth.sdk.core.generic.GenericBaseDao;
import com.bithealth.sdk.core.generic.GenericBaseServiceImpl;

/**
 * 类名称: MessageCenterFacadeServiceImpl 功能描述: TODO 消息中心对外接口实现类 增加/修改原 因: TODO ADD
 * REASON(可选). 日期: 2016年7月28日 下午2:10:15
 * 
 * @author 胡翔
 * @version
 */
@Service("messageCenterFacadeService")
public class MessageCenterFacadeServiceImpl extends GenericBaseServiceImpl<MessageCenter,MessageCenterExample,Integer> implements
		MessageCenterFacadeService {
	
	protected static Logger logger = Logger.getLogger(MessageCenterFacadeServiceImpl.class);


	private ICacheLogService cacheLogService;

	@Resource(name = "cacheLogService")
	public void setCacheLogService(ICacheLogService cacheLogService) {
		this.cacheLogService = cacheLogService;
	}
	
	@Autowired
	private  RedicrectService redirectImpl;
	private boolean fla;
	private Parameter parameter = new Parameter();;

	
	
	/**
	 * 
	 * insertOrUpdateMessageSynchronized  @Description: 同步插入或更新消息数据.
	 * @author 曾许华
	 * @param 要插入或更新的消息记录对象
	 * @return 返回数据处理结果
	 */
	@Override
	public Response insertOrUpdateMessageSynchronized(MessageCenter messageCenter)
			throws Exception {
		logger.info("msgCenterCore对外提供的调用消息入库更新的同步接口");
		parameter = new Parameter();
		Map<String,CharSequence> map = new HashMap<String,CharSequence>();
		String msgJson=JSONObject.toJSON(messageCenter).toString();
		logger.info("组装的参数为msgJson:"+msgJson);
		map.put("messageCenter", msgJson);
		parameter.setParam(map);
		logger.info("调用代理服务器");
		Response resp=redirectImpl.redirect(MessageMethodEnum.MessageSynchronized, parameter);
		logger.info("返回的状态为:"+resp.getStatus());
		return resp;
	}

	/**
	 * 
	 * @Title:insertMessage  @Description: 异步调用插入或更新消息数据.
	 * @author 曾许华
	 * @param 要插入或更新的消息记录对象
	 * @return 返回数据处理结果
	 */
	@Override
	public Response insertOrUpdateMessageAsynchronous(MessageCenter messageCenter)
			throws Exception {
		logger.info("msgCenterCore对外提供的调用消息入库更新的异步接口");
		Map<String,CharSequence> map = new HashMap<String,CharSequence>();
		String msgJson=JSONObject.toJSON(messageCenter).toString();
		map.put("messageCenter", msgJson);
		logger.info("组装的参数为msgJson:"+msgJson);
		parameter.setParam(map);
		logger.info("调用代理服务器");
		Response resp=redirectImpl.redirect(MessageMethodEnum.MessageAsynchronous, parameter);
		logger.info("返回的状态为:"+resp.getStatus());
		return resp;
	}

	/**
	 * 
	 * deleteById  @Description: 删除消息记录（温馨提示，医患沟通，亲友动态类型的消息）
	 * @author 曾许华
	 * @param 通过发送者，接收者删除消息记录
	 * @return 返回数据处理结果
	 */
	@Override
	public boolean deleteBySendAndReceiver(String send, String receiver,Byte msgType) {
		logger.info("msgCenterCore对外提供的调用消息删除接口");
		Map<String,CharSequence> map = new HashMap<String,CharSequence>();
		map.put("send", send.toString());
		map.put("receiver", receiver.toString());
		map.put("msgType", msgType.toString());
		logger.info("消息类型msgType:"+msgType.toString()+",发送者："+send+",接收者："+receiver);
		parameter.setParam(map);
		Response resp=redirectImpl.redirect(MessageMethodEnum.MessageDeleteBySendAndReceiver, parameter);
		if(resp.getStatus()==200){
			fla=true;
		}else{
			logger.info("返回的内容:"+JSONObject.toJSONString(resp));
		}
		return fla;
	}
	
	/**
	 * 
	 * deleteById  @Description: 删除消息记录(问卷和报告类型的消息)
	 * @author 曾许华
	 * @param 通过ID删除消息记录
	 * @return 返回数据处理结果
	 */
	@Override
	public boolean deleteById(Integer id,Byte msgType,String recieverGUID) {
		
		//TODO 问卷和报告的功能在消息中心已经去掉
		
/*		logger.info("msgCenterCore对外提供的调用消息删除接口");
		Map<String,CharSequence> map = new HashMap<String,CharSequence>();
		map.put("sourId", id.toString());
		map.put("msgType", msgType.toString());
		map.put("reciever", recieverGUID);
		logger.info("组装的参数为来源ID,sourId:"+id.toString()+";消息类型msgType:"+msgType.toString());
		parameter.setParam(map);
		logger.info("调用代理服务器");
		Response resp=redirectImpl.redirect(MessageMethodEnum.MessageDelete, parameter);
		logger.info("返回的状态为:"+resp.getStatus());
		if(resp.getStatus()==200){
			fla=true;
		}*/
		return false;
	}

	/** 
     * @Title: send 
     * @param  
     * @throws      
     * @retrun  
     *  @see com.bithealth.msgCenterCore.facade.service.MessageCenterFacadeService#getMessageListByIds(java.util.List)
     */
	@Override
	public List<Integer> getMessageListByIds(List list,Byte msgType) {
		logger.info("msgCenterCore对外（appServer）提供的调用消息查询接口");
		Map<String,CharSequence> map = new HashMap<String,CharSequence>();
		String str=null;
		parameter = new Parameter();
		String str1 = StringUtils.collectionToDelimitedString(list, ",");
		map.put("ids", str1);
		map.put("msgType", msgType.toString());
		logger.info("组装的参数为来源IDS,ids:"+str1.toString()+";消息类型msgType:"+msgType.toString());
		parameter.setParam(map);
		logger.info("调用代理服务器");
		Response resp=redirectImpl.redirect(MessageMethodEnum.MessageList, parameter);
		logger.info("返回的状态为:"+resp.getStatus());
		if(resp.getStatus()==200){
			 str=resp.getBody();
		}
		logger.info("返回出去的参数str:"+str);
		List<Integer> listMSG=JSONObject.parseArray(str, Integer.class);
		return listMSG;
	}
	

	@Override
	public int insert(MessageCenter model) {
		return 0;
	}

	@Override
	public int update(MessageCenter model) {
		return 0;
	}

	@Override
	public int updateByPrimaryKey(MessageCenter model) {
		return 0;
	}

	@Override
	public int updateByExampleSelective(MessageCenter model,
			MessageCenterExample example) {
		return 0;
	}

	@Override
	public int updateByExample(MessageCenter model, MessageCenterExample example) {
		return 0;
	}

	@Override
	public int delete(Integer id) {
		return 0;
	}

	@Override
	public MessageCenter selectById(Integer id) {
		return null;
	}

	@Override
	public List<MessageCenter> selectByExampleAndPage(Page<MessageCenter> page,
			MessageCenterExample example) {
		return null;
	}

	@Override
	public int countByExample(MessageCenterExample example) {
		return 0;
	}

	@Override
	public int deleteByExample(MessageCenterExample example) {
		return 0;
	}

	@Override
	public List<MessageCenter> selectByExample(MessageCenterExample example) {
		return null;
	}

	@Override
	public GenericBaseDao<MessageCenter, MessageCenterExample, Integer> getDao() {
		return null;
	}

	
	
	@SuppressWarnings("unchecked")
	@Override
	public boolean saveSmsConfig(SmsConfig smsConfig) {
		try{
			Map<String, CharSequence> paramMap = new HashMap<String, CharSequence>();
			paramMap = convertBean(smsConfig);
			Parameter parameter = new Parameter();
			parameter.setParam(paramMap);
			Response  response = redirectImpl.redirect(MessageMethodEnum.SaveSmsConfig, parameter);
			if(200 == response.getStatus()){
				ResponseObject responseObject = JSONObject.parseObject(response.getBody(), ResponseObject.class);
				if(responseObject.getStatusCode() == 0){
					return true;
				}
			}
			logger.error("HTTP请求返回内容："+JSONObject.toJSONString(response));
			return false;
		}catch(Exception e){
			logger.error("保存短信配置异常。"+e.getMessage());
			return false;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean smsSend(SmsSendParams smsSendParams) {
		try{
			Map<String, CharSequence> paramMap = new HashMap<String, CharSequence>();
			paramMap = convertBean(smsSendParams);
			Parameter parameter = new Parameter();
			parameter.setParam(paramMap);
			Response  response = redirectImpl.redirect(MessageMethodEnum.SendSms, parameter);
			if(200 == response.getStatus()){
				ResponseObject responseObject = JSONObject.parseObject(response.getBody(), ResponseObject.class);
				if(responseObject.getStatusCode() == 0){
					return true;
				}
			}
			logger.error("HTTP请求返回内容："+JSONObject.toJSONString(response));
			return false;
		}catch(Exception e){
			logger.error("发送短信录异常。"+e.getMessage());
			return false;
		}
	}

	
	
	@SuppressWarnings("unchecked")
	@Override
	public Page getSmsList(SmsSearchParams smsParams) {
		try{
			Map<String, CharSequence> paramMap = new HashMap<String, CharSequence>();
			paramMap = convertBean(smsParams);
			Parameter parameter = new Parameter();
			parameter.setParam(paramMap);
			Response  response = redirectImpl.redirect(MessageMethodEnum.SmsList, parameter);
			Page page = new Page();
			if(200 == response.getStatus()){
				ResponseObject responseObject = JSONObject.parseObject(response.getBody(), ResponseObject.class);
				if(responseObject.getStatusCode() == 0){
					page = JSONObject.parseObject(responseObject.getData().toString(), Page.class);
					return page;	
				}
			}
			return null;
		}catch(Exception e){
			logger.error("从centerServer中获取短信记录异常。"+e.getMessage());
			return null;
		}
	}

    @SuppressWarnings({ "rawtypes", "unchecked" })
	public  Map convertBean(Object bean)  throws IntrospectionException, IllegalAccessException, InvocationTargetException { 
        Class type = bean.getClass(); 
        Map returnMap = new HashMap(); 
        BeanInfo beanInfo = Introspector.getBeanInfo(type); 
        PropertyDescriptor[] propertyDescriptors =  beanInfo.getPropertyDescriptors(); 
        for (int i = 0; i< propertyDescriptors.length; i++) { 
            PropertyDescriptor descriptor = propertyDescriptors[i]; 
            String propertyName = descriptor.getName(); 
            if (!propertyName.equals("class")) { 
                java.lang.reflect.Method readMethod = descriptor.getReadMethod(); 
                Object result = readMethod.invoke(bean, new Object[0]); 
                if (result != null) { 
                	if(Date.class.equals(descriptor.getPropertyType())){
                		returnMap.put(propertyName, TimeUtil.formatDatetime2((Date)result)); 
                	}else if(ArrayList.class.equals(descriptor.getPropertyType())){
                		ArrayList list =(ArrayList) result;
                		returnMap.put(propertyName, JSONArray.toJSONString(list)); 
                	}else{
                		returnMap.put(propertyName, result.toString()); 
                	}
                }  
            } 
        } 
        return returnMap; 
    }

	@SuppressWarnings("unchecked")
	@Override
	public SmsConfig getSmsConfig(SmsConfig smsConfig) {
		try{
			Map<String, CharSequence> paramMap = new HashMap<String, CharSequence>();
			paramMap = convertBean(smsConfig);
			Parameter parameter = new Parameter();
			parameter.setParam(paramMap);
			Response  response = redirectImpl.redirect(MessageMethodEnum.GetSmsConfig, parameter);
			SmsConfig config = new SmsConfig();
			if(200 == response.getStatus()){
				ResponseObject responseObject = JSONObject.parseObject(response.getBody(), ResponseObject.class);
				if(responseObject.getStatusCode() == 0 && responseObject.getData() != null){
					config = JSONObject.parseObject(responseObject.getData().toString(), SmsConfig.class);
					return config;	
				}
			}
			return new SmsConfig();
		}catch(Exception e){
			logger.error("从centerServer中获取组织短信配置异常。"+e.getMessage());
			return new SmsConfig();
		}
	}
		

	@SuppressWarnings("unchecked")
	@Override
	public boolean deleteSmsConfig(SmsConfig smsConfig) {
		try{
			Map<String, CharSequence> paramMap = new HashMap<String, CharSequence>();
			paramMap = convertBean(smsConfig);
			Parameter parameter = new Parameter();
			parameter.setParam(paramMap);
			Response  response = redirectImpl.redirect(MessageMethodEnum.DeleteSmsConfig, parameter);
			if(200 == response.getStatus()){
				ResponseObject responseObject = JSONObject.parseObject(response.getBody(), ResponseObject.class);
				if(responseObject.getStatusCode() == 0){
					return true;
				}
			}
			logger.error("HTTP请求返回内容："+JSONObject.toJSONString(response));
			return false;
		}catch(Exception e){
			logger.error("保存短信配置异常。"+e.getMessage());
			return false;
		}
	}
 
	public String getRandNum(int charCount) {
		String charValue = "";
		for (int i = 0; i < charCount; i++) {
			char c = (char) (randomInt(0, 10) + '0');
			charValue += String.valueOf(c);
		}
		return charValue;
	}

	public int randomInt(int from, int to) {
		Random r = new Random();
		return from + r.nextInt(to - from);
	}

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
	 *            多长时间有效：以秒做为单位  @throws  * @retrun code 生成验证码 
	 */
	public String sendSmsCode(String smstype, String receivenum, int charCount,
			long expire) {
		
		String  code = "";
		Object result = null;

		if (expire <= 0) {
			expire = 60 * 5;
		}

		//
		long expiration = 1000 * expire;

		String tempKey = receivenum;

		String key = smstype + "_" + tempKey;

		String prefix = "sms_" + smstype;
		key = Md5Utils.encript(key);

		result = MemcacheMgr.get(key);

		if (null == result) {
			try {
				result = getRandNum(charCount);
			 
				
			} catch (Throwable e) {
				e.printStackTrace();
				
			}

		}
		
		// expiration = cache.expiration();//1000*60*60*2==2小时过期
		Date d = new Date();
		d = new Date(d.getTime() + expiration);
		// , d
		MemcacheMgr.set(key, result, d);

		// 将key存入数据库
		CacheLog log = new CacheLog();
		log.setPrefix(prefix);
		log.setCacheKey(key);
		log.setAddTime(new Date());
		this.cacheLogService.add(log);
		
		
		code =(result == null ? null : (String) result);  
		
		return code;

	}

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
	public String getSmsCode(String smstype, String receivenum) {
		String result = null;

		String tempKey = receivenum;

		String key = smstype + "_" + tempKey;

		String prefix = "sms_" + smstype;
		key = Md5Utils.encript(key);

		Object memkey = MemcacheMgr.get(key);
		result = (memkey == null ? null : (String) memkey);

		return result;
	}
	
	@SuppressWarnings({ "unchecked" })
	@Override
	public List<SmsStatistic> getSmsStatistic(SmsSearchParams smsParams) {
		try{
			Map<String, CharSequence> paramMap = new HashMap<String, CharSequence>();
			paramMap = convertBean(smsParams);
			Parameter parameter = new Parameter();
			parameter.setParam(paramMap);
			Response  response = redirectImpl.redirect(MessageMethodEnum.SmsStatistic, parameter);
			List<SmsStatistic> list = new ArrayList<SmsStatistic>();
			if(200 == response.getStatus()){
				ResponseObject responseObject = JSONObject.parseObject(response.getBody(), ResponseObject.class);
				if(responseObject.getStatusCode() == 0){
					list = JSONArray.parseArray(responseObject.getData().toString(), SmsStatistic.class);
					return list;	
				}
			}
			return null;
		}catch(Exception e){
			logger.error("从centerServer中获取组织短信统计数据异常。"+e.getMessage());
			return null;
		}
	}
}
