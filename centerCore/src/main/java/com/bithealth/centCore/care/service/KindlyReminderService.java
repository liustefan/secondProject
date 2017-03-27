package com.bithealth.centCore.care.service;

import java.util.List;

import com.bithealth.centCore.care.model.KindlyReminder;
import com.bithealth.centCore.care.model.KindlyReminderExample;
import com.bithealth.sdk.core.feature.orm.mybatis.Page;
import com.bithealth.sdk.core.generic.GenericBaseService;

public interface KindlyReminderService extends GenericBaseService<KindlyReminder,KindlyReminderExample, Integer > {  
	
	/**
	 * @Title:selectByParam 
	 * @Description:多表查询温馨提示列表
	 * @author 谢美团
	 * @param memberGUID
	 * @return 
	 * @throws
	 * @retrun List<KindlyReminder>
	 */ 
	public List<KindlyReminder> selectByParam(String memberGUID,Page<KindlyReminder> page);
	
	
}
