/*
 * MemAccountMapper.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-06-23 Created
 */
package com.bithealth.memberCore.member.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bithealth.memberCore.member.model.MemAccount;
import com.bithealth.memberCore.member.model.MemAccountExample;
import com.bithealth.sdk.core.generic.GenericBaseDao;

public interface MemAccountMapper extends GenericBaseDao<MemAccount, MemAccountExample, Integer> {
	
	/**
	 * 
	 * @Title:insertBatch 
	 * @Description:批量保存账号. 
	 * TODO(这里描述这个方法适用条件  执行流程  使用方法 注意事项– 可选).  
	 * @author liuhm
	 * @param list
	 * @return 
	 * @param 
	 * @throws
	 * @retrun int
	 */
	int insertBatch(List<MemAccount> list);
	
	/**
	 * 
	 * @Title:selectAccountByTypeAndAccount 
	 * @Description:依据账号，返回该会员其他指定类型的账号. 
	 * @author liuhm
	 * @param account
	 * @param accounttype
	 * @return 
	 * @param 
	 * @throws
	 * @retrun String
	 */
	String selectAccountByTypeAndAccount(MemAccount account);
}