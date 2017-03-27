/**
 * @PackageName:      com.bithealth.memberCore.member.service
 * @FileName:     MemberAccountService.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      liuhm
 * @version      V1.0  
 * @Createdate:  2016年7月4日 上午10:52:46  
 * 
 */
package com.bithealth.memberCore.member.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bithealth.memberCore.enmu.AccountTypeEnum;
import com.bithealth.memberCore.member.model.MemAccount;
import com.bithealth.memberCore.member.model.MemAccountExample;
import com.bithealth.memberCore.member.model.Member;
import com.bithealth.sdk.core.generic.GenericBaseService;

/**
 * 类名称: MemberAccountService  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年7月4日 上午10:52:46 
 * 
 * @author liuhm
 * @version  
 */
public interface MemberAccountService extends GenericBaseService<MemAccount, MemAccountExample, Integer> {
	
	/**
	 * 
	 * @Title:checkAccountUnique 
	 * @Description:判断账号是否存在. 
	 * @author liuhm
	 * @param type  账号类型
	 * @param account
	 * @param memberId
	 * @return 
	 * @param 
	 * @throws
	 * @retrun boolean
	 */
	boolean checkAccountUnique(AccountTypeEnum type, String account, Integer memberId);
	
	/**
	 * 
	 * @Title:selectAccountsByMember 
	 * @Description:依据会员查询账号. 
	 * @author liuhm
	 * @param memberId
	 * @return 
	 * @param 
	 * @throws
	 * @retrun List<MemAccount>
	 */
	List<MemAccount> selectAccountsByMember(Integer memberId);
	
	/**
	 * 
	 * insertBatch 
	 * @Description:保存/更新一个会员的多帐号. 
	 * @author liuhm
	 * @param accounts
	 * @param member
	 * @return 
	 * @param 
	 * @throws
	 * @retrun int
	 */
	int insertOrUpdate(List<MemAccount> accounts, Member member);
	
	/**
	 * 
	 * @Title:selectByAccount 
	 * @Description:依据账号查询. 
	 * @author liuhm
	 * @param account
	 * @return 
	 * @param 
	 * @throws
	 * @retrun MemAccount
	 */
	MemAccount selectByAccount(String account);
	
	/**
	 * 
	 * @Title:deleteByMember 
	 * @Description:删除会员账号. 
	 * @author liuhm
	 * @param memberId
	 * @return 
	 * @param 
	 * @throws
	 * @retrun int
	 */
	int deleteByMember(Integer memberId);
	
	int deleteByMemberAndAccount(Integer memberId, AccountTypeEnum type, String account);
	
	int updateByMemberAndType(MemAccount account);
	
	/**
	 * 
	 * @Title:selectAccountByTypeAndAccount 
	 * @Description:依据账号，返回该会员其他指定类型的账号. 
	 * @author liuhm
	 * @param account
	 * @param type
	 * @return 
	 * @param 
	 * @throws
	 * @retrun String
	 */
	String selectAccountByTypeAndAccount(String account, AccountTypeEnum type);
}
