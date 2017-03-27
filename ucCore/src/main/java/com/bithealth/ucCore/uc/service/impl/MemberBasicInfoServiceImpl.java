package com.bithealth.ucCore.uc.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource; 

import org.springframework.stereotype.Service; 

import com.bithealth.sdk.core.generic.GenericBaseDao;
import com.bithealth.sdk.core.generic.GenericBaseServiceImpl; 
import com.bithealth.ucCore.uc.dao.MemberBasicInfoMapper;
import com.bithealth.ucCore.uc.model.MemberBasicInfo; 
import com.bithealth.ucCore.uc.model.MemberBasicInfoExample;
import com.bithealth.ucCore.uc.result.MemberBase;
import com.bithealth.ucCore.uc.service.MemberBasicInfoService;

@Service("memberbasicinfoService") 
public class MemberBasicInfoServiceImpl extends GenericBaseServiceImpl<MemberBasicInfo,MemberBasicInfoExample,
      Integer> implements MemberBasicInfoService {
          
    @Resource MemberBasicInfoMapper memberbasicinfoMapper;
        
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

	@Override
	public List<MemberBasicInfo> selectByIdCareOrMemberNameAndTel(MemberBasicInfo memberBasicInfo) {
		return memberbasicinfoMapper.selectByIdCareOrMemberNameAndTel(memberBasicInfo);
	} 

	@Override
	public List<MemberBase> selectMemberByDetail(String memberName, String idcard, String tel) {
		return memberbasicinfoMapper.selectMemberByDetail(memberName, idcard, tel);
	}

	@Override
	public MemberBasicInfo selectByAccount(String account) {
		return memberbasicinfoMapper.selectByAccount(account);
	}

	@Override
	public MemberBasicInfo selectByIdcard(String idcard) {
		MemberBasicInfoExample example = new MemberBasicInfoExample();
		example.createCriteria().andIDCardEqualTo(idcard);
		List<MemberBasicInfo> list = memberbasicinfoMapper.selectByExample(example);
		if(list == null || list.size() == 0) {
			return null;
		}
		return list.get(0);
	}

	@Override
	public Integer countByTel(String tel, String memberGuid) {
		MemberBasicInfoExample example = new MemberBasicInfoExample();
		example.createCriteria().andMobileEqualTo(tel).andMemberIDNotEqualTo(memberGuid);
		return memberbasicinfoMapper.countByExample(example);
	}

	@Override
	public MemberBasicInfo selectByGuid(String guid) {
		MemberBasicInfoExample example = new MemberBasicInfoExample();
		example.createCriteria().andMemberIDEqualTo(guid);
		List<MemberBasicInfo> list = memberbasicinfoMapper.selectByExample(example);
		if(list == null || list.size() == 0) {
			return null;
		}
		return list.get(0);
	}

	@Override
	public MemberBasicInfo selectByNameAndTel(String name, String tel, Byte isInfoPerfect) {
		MemberBasicInfoExample example = new MemberBasicInfoExample();
		MemberBasicInfoExample.Criteria c = example.createCriteria();
		c.andMobileEqualTo(tel).andMemberNameEqualTo(name);
		if(isInfoPerfect != null) {
			c.andIsInfoPerfectEqualTo(isInfoPerfect);
		}
		List<MemberBasicInfo> list = memberbasicinfoMapper.selectByExample(example);
		if(list == null || list.size() == 0) {
			return null;
		}
		return list.get(0);
	}

	@Override
	public int updateLabel(Byte verified, String memberGuid) {
		MemberBasicInfo member = this.selectByGuid(memberGuid);
		member.setVerifyType(verified);
		return memberbasicinfoMapper.updateByPrimaryKey(member);
	}

}
