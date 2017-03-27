/*
 * KindlyReminderMapper.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-08-24 Created
 */
package com.bithealth.centCore.care.dao;

import java.util.List;

import com.bithealth.centCore.care.model.KindlyReminder;
import com.bithealth.centCore.care.model.KindlyReminderExample;
import com.bithealth.sdk.core.feature.orm.mybatis.Page;
import com.bithealth.sdk.core.generic.GenericBaseDao;

public interface KindlyReminderMapper extends GenericBaseDao<KindlyReminder, KindlyReminderExample, Integer> {
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