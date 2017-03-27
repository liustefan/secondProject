/**
 * @PackageName:      com.bithealth.memberCore.member.service.impl
 * @FileName:     MemberServiceImpl.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      liuhm
 * @version      V1.0  
 * @Createdate:  2016年6月30日 上午9:51:28  
 * 
 */
package com.bithealth.memberCore.member.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bithealth.memberCore.enmu.UseTag;
import com.bithealth.memberCore.member.dao.MemberMapper;
import com.bithealth.memberCore.member.model.Member;
import com.bithealth.memberCore.member.model.MemberExample;
import com.bithealth.memberCore.member.model.MemberExt;
import com.bithealth.memberCore.member.model.SearchCondition;
import com.bithealth.memberCore.member.service.MemberService;
import com.bithealth.memberCore.member.vo.MemberVo;
import com.bithealth.sdk.common.utils.StringUtil;
import com.bithealth.sdk.core.feature.orm.mybatis.Page;
import com.bithealth.sdk.core.generic.GenericBaseDao;
import com.bithealth.sdk.core.generic.GenericBaseServiceImpl;

/**
 * 类名称: MemberServiceImpl  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年6月30日 上午9:51:28 
 * 
 * @author liuhm
 * @version  
 */
@Service("memberService")
public class MemberServiceImpl extends GenericBaseServiceImpl<Member, MemberExample, Integer> implements MemberService {
	
	@Autowired
	private MemberMapper memberMapper;
	
	@Override
	public GenericBaseDao<Member, MemberExample, Integer> getDao() {
		return memberMapper;
	}

	@Override
	public MemberExt selectMemberExtById(Integer id) {
		return memberMapper.selectMemberExtById(id);
	}
	
	@Override
	public MemberExt selectMemberExtByUUID(String uuid) {
		MemberExample example = new MemberExample();
		example.createCriteria().andMemberGUIDEqualTo(uuid);
		List<MemberExt> list = memberMapper.selectMemberExtByExample(example);
		if(list == null || list.size() == 0) {
			return null;
		}
		return list.get(0);
	}

	@Override
	public int delete(Integer id) {
		Member member = memberMapper.selectByPrimaryKey(id);
		List<String> memberList = new ArrayList<String>();
		memberList.add(member.getMemberGUID());
		member.setUsetag(UseTag.F.name());
		return memberMapper.updateByPrimaryKey(member);
	}

	@Override
	public int updateUseTagByUUID(String UUID, UseTag tag) {
		Member member = new Member();
		member.setMemberGUID(UUID);
		member.setUsetag(tag.name());
		return memberMapper.updateUseTagByUUID(member);
	}

	@Override
	public int updateTagById(Integer memberId, UseTag tag) {
		Member member = new Member();
		member.setMemberid(memberId);
		member.setUsetag(tag.name());
		return memberMapper.updateByPrimaryKeySelective(member);
	}

	@Override
	public int deleteByUUID(String UUID) {
		MemberExample example = new MemberExample();
		example.createCriteria().andMemberGUIDEqualTo(UUID);
		return memberMapper.deleteByExample(example);
	}

	@Override
	public Member selectByIdcard(String idcard) {
		if(StringUtil.isEmpty(idcard)) {
			return null;
		}
		MemberExample example = new MemberExample();
		MemberExample.Criteria criteria = example.createCriteria();
		criteria.andIdcardEqualTo(idcard);
		criteria.andUsetagNotEqualTo(UseTag.F.name());
		List<Member> list = memberMapper.selectByExample(example);
		if(list == null  || list.size() == 0) {
			return null;
		}
		return list.get(0);
	}

	@Override
	public Member selectByUniqueId(String uniqueId) {
		MemberExample example = new MemberExample();
		MemberExample.Criteria criteria = example.createCriteria();
		criteria.andUsetagEqualTo(UseTag.T.name());
		criteria.andUniqueIdEqualTo(uniqueId);
		List<Member> list = memberMapper.selectByExample(example);
		if(list == null  || list.size() == 0) {
			return null;
		}
		return list.get(0);
	}

	@Override
	public Member selectById(Integer id) {
		Member member = super.selectById(id);
		if(member != null && !UseTag.T.name().equals(member.getUsetag())) {
			return null;
		}
		return member;
	}

	@Override
	public Page<MemberVo> listMyMemberByPage(SearchCondition<MemberVo> condition) {
		List<MemberVo> list = memberMapper.exeProMyMembers(condition);
		return getPage(condition, list);
	}

	@Override
	public Page<MemberVo> listOtherMemberByPage(SearchCondition<MemberVo> condition) {
		List<MemberVo> list = memberMapper.exeProOtherMembers(condition);
		return getPage(condition, list);
	}

	@Override
	public Page<MemberVo> listAllMemberByPage(SearchCondition<MemberVo> condition) {
		List<MemberVo> list = memberMapper.exeProAllMembers(condition);
		return getPage(condition, list);
	}
	
	@Override
	public Member selectByUUID(String UUID, UseTag tag) {
		MemberExample example = new MemberExample();
		MemberExample.Criteria c = example.createCriteria();
		c.andMemberGUIDEqualTo(UUID);
		if(tag != null) {
			c.andUsetagEqualTo(tag.name());
		}
		List<Member> list = memberMapper.selectByExample(example);
		if(list == null || list.size() == 0) {
			return null;
		}
		return list.get(0);
	}

	private Page<MemberVo> getPage(SearchCondition<MemberVo> condition, List<MemberVo> list) {
		int total = condition.getiCount();
		condition.getPage().setTotalCount(total);
		condition.getPage().setResult(list);
		return condition.getPage();
	}

	@Override
	public Member selectByNameAndTel(String tel, String name) {
		if(StringUtil.isEmpty(name) || StringUtil.isEmpty(tel)) {
			return null;
		}
		MemberExample example = new MemberExample();
		example.createCriteria().andTelEqualTo(tel).andMemnameEqualTo(name).andUsetagNotEqualTo(UseTag.F.name());
		List<Member> list = memberMapper.selectByExample(example);
		if(list == null || list.size() == 0) {
			return null;
		}
		return list.get(0);
	}

	@Override
	public List<MemberExt> selectMemberExt(Member member) {
		MemberExample example = new MemberExample();
		MemberExample.Criteria criteria = example.createCriteria();
		if(StringUtil.isNotEmpty(member.getMemname())) {
			criteria.andMemnameLike(member.getMemname());
		}
		if(StringUtil.isNotEmpty(member.getTel())) {
			criteria.andTelLike(member.getTel());
		}
		if(StringUtil.isNotEmpty(member.getIdcard())) {
			criteria.andIdcardLike(member.getIdcard());
		}
		if(member.getDocid() != null) {
			criteria.andDocidEqualTo(member.getDocid());
		}
		if(StringUtil.isNotEmpty(member.getUsetag())){
			criteria.andUsetagEqualTo(member.getUsetag());
		}
		return memberMapper.selectMemberExtByExample(example);
	}
	
	
}
