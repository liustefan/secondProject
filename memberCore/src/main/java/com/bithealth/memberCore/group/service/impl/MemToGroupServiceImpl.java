/**
 * @PackageName:      com.bithealth.memberCore.group.service.impl
 * @FileName:     MemToGroupServiceImpl.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      liuhm
 * @version      V1.0  
 * @Createdate:  2016年6月29日 下午5:12:11  
 * 
 */
package com.bithealth.memberCore.group.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bithealth.memberCore.group.dao.MemToGroupMapper;
import com.bithealth.memberCore.group.model.MemToGroupExample;
import com.bithealth.memberCore.group.model.MemToGroupKey;
import com.bithealth.memberCore.group.model.MemberGroup;
import com.bithealth.memberCore.group.service.MemToGroupService;
import com.bithealth.memberCore.member.model.Member;
import com.bithealth.sdk.core.generic.GenericBaseDao;
import com.bithealth.sdk.core.generic.GenericBaseServiceImpl;

/**
 * 类名称: MemToGroupServiceImpl  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年6月29日 下午5:12:11 
 * 
 * @author liuhm
 * @version  
 */
@Service("memToGroupService")
public class MemToGroupServiceImpl extends GenericBaseServiceImpl<MemToGroupKey, MemToGroupExample, MemToGroupKey> implements MemToGroupService {

	@Autowired
	private MemToGroupMapper memToGroupMapper;
	
	@Override
	public GenericBaseDao<MemToGroupKey, MemToGroupExample, MemToGroupKey> getDao() {
		return memToGroupMapper;
	}

	@Override
	public int insertBatchByGroup(List<Member> list, MemberGroup group) {
		if(group == null || group.getMemgrpid() == null) {
			return 0;
		}
		if(list == null || list.isEmpty()) {
			return 0;
		}
		int grpId = group.getMemgrpid();
		List<MemToGroupKey> dataList = new ArrayList<MemToGroupKey>();
		for(Member member : list) {
			if(member.getMemberid() == null) {
				continue;
			}
			MemToGroupKey key = new MemToGroupKey();
			key.setMemberid(member.getMemberid());
			key.setMemgrpid(grpId);
			dataList.add(key);
		}
		if(dataList.isEmpty()) {
			return 0;
		}
		deleteByExam(null, group.getMemgrpid(), null);
		return memToGroupMapper.insertBatch(dataList);
	}

	@Override
	public int insertBatchByMember(List<MemberGroup> list, Member member, List<MemberGroup> docAuthGroups) {
		if(member == null || member.getMemberid() == null) {
			return 0;
		}
		int memberId = member.getMemberid();
		int count = deleteByExam(memberId, null, docAuthGroups);
		if(list == null || list.isEmpty()) {
			return count;
		}
		
		List<MemToGroupKey> dataList = new ArrayList<MemToGroupKey>();
		for(MemberGroup group : list) {
			if(group.getMemgrpid() == null) {
				continue;
			}
			MemToGroupKey key = new MemToGroupKey();
			key.setMemberid(memberId);
			key.setMemgrpid(group.getMemgrpid());
			dataList.add(key);
		}
		if(dataList.isEmpty()) {
			return 0;
		}
		
		return memToGroupMapper.insertBatch(dataList);
	}
	
	
	@Override
	public int insertBatch(List<MemberGroup> groupList, List<Member> memberList) {
		if(groupList == null || groupList.isEmpty()) {
			return 0;
		}
		if(memberList == null || memberList.isEmpty()) {
			return 0;
		}
		
		List<MemToGroupKey> dataList = new ArrayList<MemToGroupKey>();
		for(MemberGroup group : groupList) {
			Integer grpId = group.getMemgrpid();
			if(grpId == null  || grpId.intValue() == 0) {
				continue;
			}
			for(Member memebr : memberList) {
				if(memebr.getMemberid() == null || memebr.getMemberid().intValue() == 0) {
					continue;
				}
				MemToGroupKey key = new MemToGroupKey();
				key.setMemberid(memebr.getMemberid());
				key.setMemgrpid(grpId);
				dataList.add(key);
			}
		}
		
		if(dataList.isEmpty()) {
			return 0;
		}
		
		return memToGroupMapper.insertBatch(dataList);
	}

	@Override
	public int countByMemAndGrpId(Integer memberId, Integer grpId) {
		MemToGroupExample example = new MemToGroupExample();
		MemToGroupExample.Criteria c = example.createCriteria();
		if(memberId != null) {
			c.andMemberidEqualTo(memberId);
		}
		if(grpId != null) {
			c.andMemgrpidEqualTo(grpId);
		}
		return memToGroupMapper.countByExample(example);
	}

	private int deleteByExam(Integer memberId, Integer grpId, List<MemberGroup> docAuthGroups) {
		MemToGroupExample example = new MemToGroupExample();
		MemToGroupExample.Criteria c = example.createCriteria();
		if(memberId == null && grpId == null) {  //避免全表删除
			return 0;
		}
		if(memberId != null) {
			c.andMemberidEqualTo(memberId);
		}
		if(grpId != null) {
			c.andMemgrpidEqualTo(grpId);
		}
		if(docAuthGroups != null && docAuthGroups.size() > 0) {
			List<Integer> list = new ArrayList<Integer>();
			for(MemberGroup group : docAuthGroups) {
				list.add(group.getMemgrpid());
			}
			c.andMemgrpidIn(list);
		}
		return memToGroupMapper.deleteByExample(example);
	}
	
	
	
}
