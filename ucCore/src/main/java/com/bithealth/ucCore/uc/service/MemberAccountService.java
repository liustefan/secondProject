package com.bithealth.ucCore.uc.service;

import java.util.List;

import com.bithealth.sdk.core.generic.GenericBaseService;
import com.bithealth.ucCore.facade.enmu.AccountTypeEnum;
import com.bithealth.ucCore.uc.model.MemberAccount;
import com.bithealth.ucCore.uc.model.MemberAccountExample;

public interface MemberAccountService extends GenericBaseService<MemberAccount,MemberAccountExample, Integer > { 
	
	/**
	 * 
	 * @Title:updateAccount 
	 * @Description:依据UUID和类型更新账号. 
	 * @author liuhm
	 * @param account
	 * @return 
	 * @param 
	 * @throws
	 * @retrun int
	 */
	int updateAccount(MemberAccount account);
	
	int deleteAccount(String uuid, AccountTypeEnum atype, Integer serverId);
	
	int deleteAccountByGuid(String guid);
	
	int insertBatch(List<MemberAccount> list);
}
