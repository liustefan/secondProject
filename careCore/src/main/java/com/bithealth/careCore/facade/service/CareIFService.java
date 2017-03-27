 

package com.bithealth.careCore.facade.service;

import java.util.List;

import com.bithealth.careCore.facade.model.KindlyReminder;
import com.bithealth.careCore.facade.model.MsgCenter;
import com.bithealth.sdk.core.feature.orm.mybatis.Page;



/**
 * 类名称: CareIFService  
 * 功能描述: 关注模块对医生端接口
 * 日期: 2016年8月23日 下午3:20:01 
 * 
 * @author 谢美团
 * @version  
 */
public interface CareIFService  {
	

	
	/**
	 * @Title:sendMsgToMyCare 
	 * @Description:发送测量数据消息或者公卫服务消息给关注我的人  （通过HTTP请求发送到centerServer）
	 *	体检和随访的摘要格式中使用 (??) 代表发送者和接收者的关系。 
	 * @author 谢美团 
	 * @throws
	 * @retrun void
	 */ 
	public void sendMsgToCareMeMember(MsgCenter msgCenter) throws Exception;
	
	/**
	 * @Title:getMsgListFormCenterServer 
	 * @Description:获取温馨提示列表（医生嘱咐，供医生端端调用） （通过HTTP请求请求到centerServer）
	 * @author 谢美团
	 * @param KindlyReminder
	 * @throws Exception 
	 * @throws
	 * @retrun void
	 */ 
	public Page getMsgListFormCenterServer(KindlyReminder KindlyReminder) throws Exception;
	
	
	
	/**
	 * @Title:sendKindlyReminder 
	 * @Description:医生发送医生嘱咐给会员（即发送温馨提示）,支持群发 （通过HTTP请求请求到centerServer）
	 * @author 谢美团
	 * @param KindlyReminder
	 * @throws Exception 
	 * @throws
	 * @retrun void
	 */ 
	public String sendKindlyReminder(KindlyReminder KindlyReminder) throws Exception;
	
	
	
	/**
	 * @Title:deleteMsg 
	 * @Description:删除消息，支持批量
	 * @author 谢美团
	 * @param logIDList 数据主键List
	 * @return
	 * @throws Exception 
	 * @throws
	 * @retrun boolean
	 */ 
	public boolean deleteMsg(List<Integer> logIDList)throws Exception;
	


}

