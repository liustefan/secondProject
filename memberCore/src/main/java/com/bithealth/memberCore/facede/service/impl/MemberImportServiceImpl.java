/**
 * @PackageName:      com.bithealth.memberCore.facede.service.impl
 * @FileName:     MemberImportServiceImpl.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      liuhm
 * @version      V1.0  
 * @Createdate:  2016年9月12日 下午3:02:55  
 * 
 */
package com.bithealth.memberCore.facede.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bithealth.memberCore.constants.CodeStatus;
import com.bithealth.memberCore.enmu.AccountTypeEnum;
import com.bithealth.memberCore.enmu.UseTag;
import com.bithealth.memberCore.facede.service.MemberImportService;
import com.bithealth.memberCore.member.dao.MemberMapper;
import com.bithealth.memberCore.member.model.MemAccount;
import com.bithealth.memberCore.member.model.MemImportLog;
import com.bithealth.memberCore.member.model.Member;
import com.bithealth.memberCore.member.model.MemberExample;
import com.bithealth.memberCore.member.model.MemberExt;
import com.bithealth.memberCore.uc.bean.Account;
import com.bithealth.memberCore.uc.bean.AgentResponse;
import com.bithealth.memberCore.uc.bean.MemberResponse;
import com.bithealth.memberCore.uc.bean.MemberRet;
import com.bithealth.memberCore.uc.service.UnifiedAuthServiceImpl;
import com.bithealth.sdk.common.utils.StringUtil;
import com.bithealth.sdk.core.feature.orm.mybatis.Page;

/**
 * 类名称: MemberImportServiceImpl  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年9月12日 下午3:02:55 
 * 
 * @author liuhm
 * @version  
 */
@Service
public class MemberImportServiceImpl extends UnifiedAuthServiceImpl implements MemberImportService {
	
	@Autowired
	private MemberMapper memberMapper;
	
	

	@Override
	public String exist(Member member) {
		return super.isExist(member);
	}

	@Override
	public Page<Map<String, Object>> selectErrorMemberList(Page<Map<String, Object>> page, Member member) {
		Map<String, Object> params = new HashMap<String, Object>();
		member = member == null ? new Member() : member;
		member.setUsetag(UseTag.E.name());
		params.put("page", page);
		params.put("member", member);
		page.setResult(memberMapper.selectErrorMemberList(params));
		page.setTotalCount(memberMapper.countErrorMemberList(member));
		return page;
	}
	
	@Override
	public String insert(MemberExt member) {
		String msg = super.isExist(member);
		if(StringUtil.isNotEmpty(msg)) {
			return msg;
		}
		MemberExt data = memberService.selectMemberExtById(member.getMemberid());
		member.setStatus(data.getStatus());
		member.setSource(data.getSource());
		member.setMemSession(data.getMemSession());
		member.setUsetag(UseTag.E.name());
		member.setImportLog(LogService.selectByUUID(member.getMemberGUID(), UseTag.E));
		member.setOrgid(data.getOrgid());
		member.setDocid(data.getDocid());
		member.setDocname(data.getDocname());
		member.setMemberGroupList(data.getMemberGroupList());
		member.setCreatetime(new java.util.Date());
		super.saveOrUpdateMember(member);
		List<String> param = new ArrayList<String>();
		param.add(super.getInfo(member));
		memberService.updateTagById(member.getMemberid(), UseTag.R);
		LogService.updateContent(member.getMemberGUID(), UseTag.R, param.toString());
		try {
			AgentResponse result = super.regist(param, false);
			if(result.getCode() != CodeStatus.OK) {
				return result.getMessage();
			}
			List<MemberResponse> returnList = result.getContent();
			if(returnList == null || returnList.size() == 0) {
				return "注册中心无会员信息返回";
			}
			MemberResponse response = returnList.get(0);
			if(response.getCode() == MemberRet.SUCCESS) {
				memberService.updateUseTagByUUID(response.getGuid(), UseTag.T);
				List<MemAccount> accountList = new ArrayList<>();
				for(Account res : response.getAccountList()) {
					accountList.add(new MemAccount(res.getAccount(), AccountTypeEnum.getAccountType(Short.valueOf(res.getAccountType()))));
				}
				memAccountService.insertOrUpdate(accountList, member);
				LogService.deleteByUUID(response.getGuid(), UseTag.R);  //删除日志表
			} else {
				memberService.updateTagById(member.getMemberid(), UseTag.E);
				LogService.updateTagByUUID(member.getMemberGUID(), UseTag.E, response.getMsg());
				return response.getMsg();
			}
		} catch (Exception e) {
			return e.getLocalizedMessage();
		}
		return null;
	}

	@Override
	public String deleteErrorMember(String[] uidList) {
		if(uidList == null || uidList.length == 0) {
			return "请选择要删除的会员";
		}
		StringBuilder msg = new StringBuilder();
		for(String uid : uidList) {
			Member member = memberService.selectByUUID(uid, null);
			if(member == null) {
				continue;
			}
			if(UseTag.T.name().equals(member.getUsetag())) {
				msg.append(member.getMemname() + "不能删除；");
				continue;
			}
			this.delete(member);
			LogService.deleteByUUID(uid, UseTag.E);
		}
		return msg.toString();
	}
	
	@Override
	public String insertErrorData(List<MemberExt> memberList) {
		if(memberList == null || memberList.size() == 0) {
			return null;
		}
		List<MemImportLog> list = new ArrayList<MemImportLog>();
		for(MemberExt member : memberList) {
			member.setUsetag(UseTag.E.name());
			member.setMemberGUID(StringUtil.UUID());
			super.saveOrUpdateMember(member);
			MemImportLog memberLog = member.getImportLog();
			if(memberLog == null) {
				memberLog = new MemImportLog();
			}
			memberLog.setMemberGUID(member.getMemberGUID());
			memberLog.setImportBatchGUID(StringUtil.UUID());
			memberLog.setImportTime(new Date());
			memberLog.setUseTag(UseTag.E.name());
			memberLog.setUpdateTime(new Date());
			memberLog.setSyncTimestamp(new Date().getTime());
			list.add(memberLog);
		}
		LogService.insertLogs(list);
		return null;
	}
	
	@Override
	public int deleteAll(Integer docId) {
		LogService.deleteErrorLog(docId);
		MemberExample example = new MemberExample();
		example.createCriteria().andDocidEqualTo(docId).andUsetagEqualTo(UseTag.E.name());
		return memberService.deleteByExample(example);
	}

	@Override
	public int countMemberInporting(int docId, UseTag tag) {
		Member member = new Member();
		member.setDocid(docId);
		member.setUsetag(tag.name());
		return memberMapper.countErrorMemberList(member);
	}

	private void delete(Member member) {
		memberService.deleteByUUID(member.getMemberGUID());
		memberSessionService.delete(member.getMemberid());
		memAccountService.deleteByMember(member.getMemberid());
		diseasesHistoryService.insertOrUpdate(null, member);
		familyHistoryService.insetOrUpdate(null, member);
		habitService.delete(member.getMemberid());
		linkManService.insertOrUpdate(null, member);
		physicalService.delete(member.getMemberid());
		MemToGroupService.insertBatchByMember(null, member, null); //从分组中移除
	}

}
