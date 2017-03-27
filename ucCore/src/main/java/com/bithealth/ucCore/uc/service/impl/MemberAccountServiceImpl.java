package com.bithealth.ucCore.uc.service.impl;

import java.util.List;

import javax.annotation.Resource; 

import org.springframework.stereotype.Service; 

import com.bithealth.sdk.core.generic.GenericBaseDao;
import com.bithealth.sdk.core.generic.GenericBaseServiceImpl; 
import com.bithealth.ucCore.facade.enmu.AccountTypeEnum;
import com.bithealth.ucCore.uc.dao.MemberAccountMapper;
import com.bithealth.ucCore.uc.model.MemberAccount; 
import com.bithealth.ucCore.uc.model.MemberAccountExample;
import com.bithealth.ucCore.uc.service.MemberAccountService;

@Service("memberaccountService") 
public class MemberAccountServiceImpl extends GenericBaseServiceImpl<MemberAccount,MemberAccountExample,
      Integer> implements MemberAccountService {
          
    @Resource MemberAccountMapper memberaccountMapper;
        
    @Override
    public GenericBaseDao<MemberAccount,MemberAccountExample,  Integer > getDao() {
        return memberaccountMapper;
    }

	@Override
	public int updateAccount(MemberAccount account) {
		MemberAccountExample example = new MemberAccountExample();
		example.createCriteria().andMemberIDEqualTo(account.getMemberID())
		.andAccountTypeEqualTo(account.getAccountType()).andServerIdEqualTo(account.getServerId());
		MemberAccount record = new MemberAccount();
		record.setAccount(account.getAccount());
		return memberaccountMapper.updateByExampleSelective(record, example);
	}

	@Override
	public int deleteAccount(String uuid, AccountTypeEnum atype, Integer serverId) {
		MemberAccountExample example = new MemberAccountExample();
		example.createCriteria().andMemberIDEqualTo(uuid)
		.andAccountTypeEqualTo(atype.getType()).andServerIdEqualTo(serverId);
		return memberaccountMapper.deleteByExample(example);
	}

	@Override
	public int deleteAccountByGuid(String guid) {
		MemberAccountExample example = new MemberAccountExample();
		example.createCriteria().andMemberIDEqualTo(guid);
		return memberaccountMapper.deleteByExample(example);
	}

	@Override
	public int insertBatch(List<MemberAccount> list) {
		return memberaccountMapper.insertBatch(list);
	}  
	
}
