package com.bithealth.centCore.sms.service;

import java.util.List;

import com.bithealth.sdk.core.generic.GenericBaseService;
import com.bithealth.centCore.sms.model.SmsSendDetail;
import com.bithealth.centCore.sms.model.SmsSendDetailExample; 

public interface SmsSendDetailService extends GenericBaseService<SmsSendDetail,SmsSendDetailExample,
   Integer > {    
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
}
