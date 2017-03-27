/**
 * @PackageName:      com.bithealth.memberCore.member.service.impl
 * @FileName:     MemberAccountServiceImpl.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      liuhm
 * @version      V1.0  
 * @Createdate:  2016年7月4日 上午10:56:00  
 * 
 */
package com.bithealth.memberCore.member.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bithealth.memberCore.enmu.AccountTypeEnum;
import com.bithealth.memberCore.member.dao.MemAccountMapper;
import com.bithealth.memberCore.member.model.MemAccount;
import com.bithealth.memberCore.member.model.MemAccountExample;
import com.bithealth.memberCore.member.model.Member;
import com.bithealth.memberCore.member.service.MemberAccountService;
import com.bithealth.sdk.core.generic.GenericBaseDao;
import com.bithealth.sdk.core.generic.GenericBaseServiceImpl;

/**
 * 类名称: MemberAccountServiceImpl  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年7月4日 上午10:56:00 
 * 
 * @author liuhm
 * @version  
 */
@Service("memberAccountService")
public class MemberAccountServiceImpl extends GenericBaseServiceImpl<MemAccount, MemAccountExample, Integer> implements MemberAccountService {
	
	@Autowired
	private MemAccountMapper memAccountMapper;
	
	@Override
	public GenericBaseDao<MemAccount, MemAccountExample, Integer> getDao() {
		return memAccountMapper;
	}

	@Override
	public boolean checkAccountUnique(AccountTypeEnum type, String account, Integer memberId) {
		MemAccountExample example = new MemAccountExample();
		MemAccountExample.Criteria criteria = example.createCriteria();
		if(memberId != null) {
			criteria.andMemberidNotEqualTo(memberId);
		}
		criteria.andAccountEqualTo(account);
		criteria.andAccounttypeEqualTo(type.getType().byteValue());
		return memAccountMapper.countByExample(example) > 0;
	}

	@Override
	public List<MemAccount> selectAccountsByMember(Integer memberId) {
		MemAccountExample example = new MemAccountExample();
		MemAccountExample.Criteria criteria = example.createCriteria();
		criteria.andMemberidEqualTo(memberId);
		return memAccountMapper.selectByExample(example);
	}

	@Override
	public int insertOrUpdate(List<MemAccount> accounts, Member member) {
		int count = this.deleteByMember(member.getMemberid());
		if(accounts == null || accounts.size() == 0) {
			return count;
		}
		for(MemAccount account : accounts) {
			account.setMemberid(member.getMemberid());
		}
		return memAccountMapper.insertBatch(accounts);
	}

	@Override
	public MemAccount selectByAccount(String account) {
		MemAccountExample example = new MemAccountExample();
		MemAccountExample.Criteria criteria = example.createCriteria();
		criteria.andAccountEqualTo(account);
		List<MemAccount> list = memAccountMapper.selectByExample(example);
		if(list == null || list.size() == 0) {
			return null;
		}
		return list.get(0);
	}

	@Override
	public int deleteByMember(Integer memberId) {
		MemAccountExample example = new MemAccountExample();
		example.createCriteria().andMemberidEqualTo(memberId);
		return memAccountMapper.deleteByExample(example);
	}

	@Override
	public int deleteByMemberAndAccount(Integer memberId, AccountTypeEnum type, String account) {
		MemAccountExample example = new MemAccountExample();
		example.createCriteria().andMemberidEqualTo(memberId).
		andAccountEqualTo(account).andAccounttypeEqualTo(type.getType().byteValue());
		return memAccountMapper.deleteByExample(example);
	}

	@Override
	public int updateByMemberAndType(MemAccount account) {
		MemAccountExample example = new MemAccountExample();
		example.createCriteria().andMemberidEqualTo(account.getMemberid()).
		andAccounttypeEqualTo(account.getAccounttype());
		MemAccount record = new MemAccount();
		record.setAccount(account.getAccount());
		record.setUpdatedrid(account.getUpdatedrid());
		record.setUpdatetime(new java.util.Date());
		return memAccountMapper.updateByExampleSelective(record, example);
	}

	@Override
	public String selectAccountByTypeAndAccount(String account, AccountTypeEnum type) {
		MemAccount memberAccount = new MemAccount(account, type);
		return memAccountMapper.selectAccountByTypeAndAccount(memberAccount);
	}
	

}
