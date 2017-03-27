/*
 * MemBerPackagTemplateMapper.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-07-05 Created
 */
package com.bithealth.packagCore.packag.dao;

import java.util.List;

import com.bithealth.packagCore.packag.model.MemBerPackagTemplate;
import com.bithealth.packagCore.packag.model.MemBerPackagTemplateExample;
import com.bithealth.packagCore.packag.model.MemBerPackagTemplateKey;
import com.bithealth.sdk.core.generic.GenericBaseDao;

public interface MemBerPackagTemplateMapper extends GenericBaseDao<MemBerPackagTemplate, MemBerPackagTemplateExample, MemBerPackagTemplateKey> {

	/**
	 * @Title:selectByEndDayAndKey 
	 * @Description:根据套餐使用结束时间和套餐主键查询套餐使用模板明细. 
	 * 此方法适用于验证套餐是否在有效期内（套餐类型：计时）.  
	 * @author 谢美团
	 * @param memBerPackagTemplate
	 * @return 
	 * @throws
	 * @retrun List<MemBerPackagTemplate>
	 */ 
	public List<MemBerPackagTemplate> selectByEndDayAndKey(MemBerPackagTemplate memBerPackagTemplate);
	
	/**
	 * @Title:selectByNumTimesAndKey 
	 * @Description:根据套餐使用次数和套餐主键查询套餐使用模板明细. . 
	 * 此方法适用于验证套餐是否在有效期内（套餐类型：计次）.  
	 * @author 谢美团
	 * @param memBerPackagTemplate
	 * @return 
	 * @throws
	 * @retrun List<MemBerPackagTemplate>
	 */ 
	public List<MemBerPackagTemplate> selectByNumTimesAndKey(MemBerPackagTemplate memBerPackagTemplate);
	
	/**
	 * @Title:insertByBatch 
	 * @Description:批量插入
	 * TODO(这里描述这个方法适用条件  执行流程  使用方法 注意事项– 可选).  
	 * @author 谢美团
	 * @param list
	 * @return 
	 * @throws
	 * @retrun int
	 */ 
	public int insertByBatch(List<MemBerPackagTemplate> list);
	
	/**
	 * @Title:selectMemPackageDetailList 
	 * @Description:查询会员订购套餐的模板使用情况（多表关联）
	 * @author 谢美团
	 * @param memBerPackagTemplate
	 * @return 
	 * @throws
	 * @retrun List<MemBerPackagTemplate>
	 */ 
	public List<MemBerPackagTemplate> selectMemPackageDetailList(MemBerPackagTemplate memBerPackagTemplate);
	

}