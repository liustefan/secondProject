package com.bithealth.packagCore.packag.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bithealth.packagCore.packag.dao.MemberPackagMapper;
import com.bithealth.packagCore.packag.model.MemberPackag;
import com.bithealth.packagCore.packag.model.MemberPackagExample;
import com.bithealth.packagCore.packag.model.MemberPackagKey;
import com.bithealth.packagCore.packag.service.MemberPackagService;
import com.bithealth.sdk.core.generic.GenericBaseDao;
import com.bithealth.sdk.core.generic.GenericBaseServiceImpl;

@Service("memberpackagService") 
public class MemberPackagServiceImpl extends GenericBaseServiceImpl<MemberPackag,MemberPackagExample,
      MemberPackagKey> implements MemberPackagService {
          
    @Resource 
    MemberPackagMapper memberpackagMapper;
        
    @Override
    public GenericBaseDao<MemberPackag,MemberPackagExample,  MemberPackagKey > getDao() {
        return memberpackagMapper;
    }

	@Override
	public Integer selectMaxLineNum() {
		return memberpackagMapper.selectMaxLineNum();
	}

	@Override
	public List<MemberPackag> selectByParam(Integer packageCode) {
		return memberpackagMapper.selectByParam(packageCode);
	}

	public void exProc_pro_updOsrs2(Integer createId, Integer memberId) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("createId", createId);
		paramMap.put("memberId", memberId);
		memberpackagMapper.exProc_pro_updOsrs2(paramMap);
	} 
	
	public void exProc_pro_insOMAS(Integer createId, String createName,Integer memberId) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("createId", createId);
		paramMap.put("createName", createName);
		paramMap.put("memberId", memberId);
		memberpackagMapper.exProc_pro_insOMAS(paramMap);
	}  
}
