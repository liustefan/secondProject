 

package com.bithealth.careCore.facade.service.Impl;

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

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bithealth.agentCore.agent.RedicrectService;
import com.bithealth.agentCore.bean.Parameter;
import com.bithealth.agentCore.enums.MessageMethodEnum;
import com.bithealth.careCore.care.constants.Constrants;
import com.bithealth.careCore.facade.model.KindlyReminder;
import com.bithealth.careCore.facade.model.MsgCenter;
import com.bithealth.careCore.facade.model.ResponseObject;
import com.bithealth.careCore.facade.service.CareIFService;
import com.bithealth.sdk.client.http.Response;
import com.bithealth.sdk.common.utils.TimeUtil;
import com.bithealth.sdk.core.feature.orm.mybatis.Page;


/**
 * 类名称: CareInfoService  
 * 功能描述: 关注模块对医生端接口实现类
 * 日期: 2016年6月17日 下午3:16:41 
 * 
 * @author 谢美团
 * @version  
 */
@Service("careIFService")
public class CareIFServiceImpl  implements CareIFService {
	 private static Logger logger=Logger.getLogger(CareIFServiceImpl.class);
	
	@Resource
	RedicrectService  redicrectService;
	
	@SuppressWarnings("unchecked")
	@Override
	public void sendMsgToCareMeMember(MsgCenter msgCenter) throws Exception {
		Response  response = new Response();
		try{
			Map<String, CharSequence> paramMap = new HashMap<String, CharSequence>();
			paramMap = convertBean(msgCenter);
			Parameter parameter = new Parameter();
			parameter.setParam(paramMap);
			response = redicrectService.redirect(MessageMethodEnum.SendMsgToCareMeMember, parameter);
			logger.info(JSONObject.toJSONString(response));
		}catch(Exception e){
			logger.error("发送测量数据消息或公卫数据消息给关注我的人异常。"+JSONObject.toJSONString(response));
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public Page getMsgListFormCenterServer(KindlyReminder KindlyReminder){
		try{
			Map<String, CharSequence> paramMap = new HashMap<String, CharSequence>();
			paramMap = convertBean(KindlyReminder);
			Parameter parameter = new Parameter();
			parameter.setParam(paramMap);
			Response  response = redicrectService.redirect(MessageMethodEnum.CareMessageList, parameter);
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
			logger.error("从centerServer中获取温馨提示异常。"+e.getMessage());
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
	public String sendKindlyReminder(KindlyReminder KindlyReminder)throws Exception {
		if(KindlyReminder.getReceiverGUIDList() != null && KindlyReminder.getReceiverGUIDList().size() > Constrants.MAX_SEND_NUM){
			return "接受者GUID List 过大。";
		}
		if(KindlyReminder.getSenderName() == null){
			return "发送者姓名不能为空。";
		}
		try{
			Map<String, CharSequence> paramMap = new HashMap<String, CharSequence>();
			paramMap = convertBean(KindlyReminder);
			Parameter parameter = new Parameter();
			parameter.setParam(paramMap);
			Response  response  = redicrectService.redirect(MessageMethodEnum.KindlyReminder, parameter);
			if(response != null && response.getStatus() == 200){
				ResponseObject responseObject = JSONObject.parseObject(response.getBody(), ResponseObject.class);
				if(responseObject.getStatusCode() == 0){
					return "success";
				}
			}
			logger.error("HTTP请求返回内容："+JSONObject.toJSONString(response));
			return "发送医生嘱咐（温馨提示）给会员异常";
		}catch(Exception e){
			logger.error("医生发送医生嘱咐（温馨提示）给会员异常。"+e.getMessage());
			return "发送医生嘱咐（温馨提示）给会员异常" ;
		}
	}

	@Override
	public boolean deleteMsg(List<Integer> logIDList) throws Exception {
		try{
			Map<String, CharSequence> paramMap = new HashMap<String, CharSequence>();
			paramMap.put("logIDList", JSONArray.toJSONString(logIDList));
			Parameter parameter = new Parameter();
			parameter.setParam(paramMap);
			redicrectService.redirect(MessageMethodEnum.DeleteKindlyReminder, parameter);
			return true;
		}catch(Exception e){
			return false;
		}
	} 


	
}

