/*
 * MemberPackagMapper.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-07-05 Created
 */
package com.bithealth.packagCore.packag.dao;

import java.util.List;
import java.util.Map;

import com.bithealth.packagCore.packag.model.MemBerPackagTemplate;
import com.bithealth.packagCore.packag.model.MemberPackag;
import com.bithealth.packagCore.packag.model.MemberPackagExample;
import com.bithealth.packagCore.packag.model.MemberPackagKey;
import com.bithealth.sdk.core.generic.GenericBaseDao;

public interface MemberPackagMapper extends GenericBaseDao<MemberPackag, MemberPackagExample, MemberPackagKey> {
	
	/**
	 * @Title:selectMaxLineNum 
	 * @Description:获取会员订购套表中最大的lineNum. 
	 * TODO(这里描述这个方法适用条件  执行流程  使用方法 注意事项– 可选).  
	 * @author 谢美团
	 * @return 
	 * @throws
	 * @retrun MemberPackag
	 */ 
	public Integer selectMaxLineNum();
	
	/**
	 * @Title:selectByPamram 
	 * @Description:根据套餐代码查询会员订购改套餐的相关信息
	 * @author 谢美团
	 * @param packageCode
	 * @return 
	 * @throws
	 * @retrun List<MemberPackag>
	 */ 
	public List<MemberPackag> selectByParam(Integer packageCode);
	
	/**
	 * @Title:exProc_pro_updOsrs2 
	 * @Description:调用 pro_updOsrs2 存储过程
	 * @author 谢美团
	 * @param paramMap 
	 * @throws
	 * @retrun void
	 */ 
	public void exProc_pro_updOsrs2(Map<String,Object> paramMap);
	

	/**
	 * @Title:exProc_pro_insOMAS 
	 * @Description:调用pro_insOMAS存储过程
	 * @author 谢美团
	 * @param paramMap 
	 * @throws
	 * @retrun void
	 */ 
	public void exProc_pro_insOMAS(Map<String,Object> paramMap);
	
	
}