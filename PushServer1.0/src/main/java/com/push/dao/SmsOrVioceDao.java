package com.push.dao;

import java.util.List;

import com.push.model.HkPushMemberTag;
import com.push.model.SmsBean;
import com.push.model.SmsConfig;
import com.push.model.SmsReceiverRelation;


/** 
 * @ClassName: SmsOrVioceDao 
 * @Description: 短信语音发送dao
 * @author 谢美团
 * @date 2015年12月8日 下午2:24:41  
 */
public interface SmsOrVioceDao {
	
	 /** 
	 * @Title: saveSmsInfo 
	 * @Description: 保存短信语音信息 
	 * @param text    
	 * @retrun void
	 */
	void saveSmsInfo(SmsBean text);
	
	 /** 
	 * @Title: querySmsConfig 
	 * @Description: 查询短信语音配置信息 
	 * @return    
	 * @retrun List<HKPushTextMsgConfig>
	 */
	List<SmsConfig> querySmsConfig();
    
	 /** 
	 * @Title: saveSmsReceiverRelation 
	 * @Description: 保存短信和接受者关联关系
	 * @param list    
	 * @retrun void
	 */
	void saveSmsReceiverRelation(List<SmsReceiverRelation> list);
	
	
	
}