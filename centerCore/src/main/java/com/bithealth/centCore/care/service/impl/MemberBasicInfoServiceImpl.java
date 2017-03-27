package com.bithealth.centCore.care.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bithealth.centCore.care.dao.MemberInfoMapper;
import com.bithealth.centCore.care.model.MemberBasicInfo;
import com.bithealth.centCore.care.model.MemberBasicInfoExample;
import com.bithealth.centCore.care.service.MemberBasicInfoService;
import com.bithealth.sdk.core.generic.GenericBaseDao;
import com.bithealth.sdk.core.generic.GenericBaseServiceImpl;

@Service("memberInfoService") 
public class MemberBasicInfoServiceImpl extends GenericBaseServiceImpl<MemberBasicInfo,MemberBasicInfoExample,
      Integer> implements MemberBasicInfoService {
          
    @Resource MemberInfoMapper memberbasicinfoMapper;
        
    @Override
    public GenericBaseDao<MemberBasicInfo,MemberBasicInfoExample,  Integer > getDao() {
        return memberbasicinfoMapper;
    }

	@Override
	public List<MemberBasicInfo> selectByMemberIDs(List<String> memberIdList) {
		return memberbasicinfoMapper.selectByMemberIDs(memberIdList);
	}

	@Override
	public List<MemberBasicInfo> selectMemberBySearchParam(String param) {
		return memberbasicinfoMapper.selectMemberBySearchParam(param);
	}

	@Override
	public List<MemberBasicInfo> selectMemberByAccountAndPwd(String account,String pwd) {
		Map<String ,String> param = new HashMap<String,String>();
		param.put("account", account);
		param.put("pwd", pwd);
		return memberbasicinfoMapper.selectMemberByAccountAndPwd(param);
	}  
}
