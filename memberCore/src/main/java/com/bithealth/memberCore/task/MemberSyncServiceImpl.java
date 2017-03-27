/**
 * @PackageName:      com.bithealth.memberCore.task
 * @FileName:     MemberSyncServiceImpl.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      liuhm
 * @version      V1.0  
 * @Createdate:  2016年9月5日 下午4:18:49  
 * 
 */
package com.bithealth.memberCore.task;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.bithealth.memberCore.constants.CodeStatus;
import com.bithealth.memberCore.constants.Constrants;
import com.bithealth.memberCore.enmu.UseTag;
import com.bithealth.memberCore.member.model.MemImportLog;
import com.bithealth.memberCore.member.model.MemImportLogExample;
import com.bithealth.memberCore.member.model.Member;
import com.bithealth.memberCore.member.model.MemberExt;
import com.bithealth.memberCore.uc.bean.AgentResponse;
import com.bithealth.memberCore.uc.bean.MemberResponse;
import com.bithealth.memberCore.uc.bean.MemberRet;
import com.bithealth.memberCore.uc.service.UnifiedAuthServiceImpl;
import com.bithealth.sdk.core.feature.orm.mybatis.Page;

/**
 * 类名称: MemberSyncServiceImpl  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年9月5日 下午4:18:49 
 * 
 * @author liuhm
 * @version  
 */
@Service
public class MemberSyncServiceImpl extends UnifiedAuthServiceImpl implements MemberSyncService {
	
	private final static Logger logger = Logger.getLogger(MemberSyncServiceImpl.class);
	
	@Override
	public void deleteMember() {
		while(true) {
			List<String> list = this.getParams(UseTag.D);
			if(list == null || list.isEmpty()){
				break;
			}
			boolean isBreak = list.size() < Constrants.MAX_AUTH;
			try {
				AgentResponse response = super.delMember(list);
				if(response.getCode() == CodeStatus.OK) {
					for(MemberResponse member : response.getContent()) {
						Member mem = null;
						if(member.getCode() == MemberRet.SUCCESS) {
							mem = memberService.selectByUUID(member.getGuid(), null);
						} 
						super.afterDelete(mem, member);
					}
				}
			} catch (Exception e) {
				logger.error(e);
				break;
			}
			if(isBreak) {
				break;
			}
		}
	}
	
	@Override
	public void updateMember() {
		while(true) {
			List<String> list = this.getParams(UseTag.M);
			if(list == null || list.isEmpty()){
				break;
			}
			boolean isBreak = list.size() < Constrants.MAX_AUTH;
			try {
				AgentResponse response = super.regist(list, false);
				logger.info("UC返回信息：" + response.toString());
				if(response.getCode() == CodeStatus.OK) {
					for(MemberResponse member : response.getContent()) {
						super.afterUpdate(member);
					}
				}
			} catch (Exception e) {
				logger.error(e);
				break;
			}
			if(isBreak) {
				break;
			}
		}
		
	}

	@Override
	public void insertMember() {
		while(true) {
			List<String> list = this.getParams(UseTag.R);
			if(list == null || list.isEmpty()){
				break;
			}
			boolean isBreak = list.size() < Constrants.MAX_AUTH;
			try {
				AgentResponse response = super.regist(list, false);
				logger.info("UC返回信息：" + response.toString());
				if(response.getCode() == CodeStatus.OK) {
					for(MemberResponse member : response.getContent()) {
						Member mem = null;
						if(member.getCode() == MemberRet.SUCCESS) {
							mem = memberService.selectByUUID(member.getGuid(), null);
						}
//						super.afterInsert(mem, member);
						super.afterImport(mem, member);
					}
				}
			} catch (Exception e) {
				logger.error(e);
				break;
			}
			if(isBreak) {
				break;
			}
		}
	}
	
	
	private List<String> getParams(UseTag tag) {
		Date now = new Date();
		now = new Date(now.getTime() - Constrants.INTERVAL_TIME * 60 * 1000);
		MemImportLogExample example = new MemImportLogExample();
		example.setOrderByClause("UpdateTime ASC");
		example.createCriteria().andUseTagEqualTo(tag.name()).andUpdateTimeLessThanOrEqualTo(now);
		Page<MemImportLog> page = new Page<MemImportLog>(1, Constrants.MAX_AUTH);
		List<MemImportLog> list = LogService.selectByExampleAndPage(page, example);
		if(list == null || list.isEmpty()) {
			return null;
		}
		List<String> result = new ArrayList<String>();
		for(MemImportLog  log : list) {
			if(tag == UseTag.D) {
				result.add(JSONObject.toJSONString(log.getMemberGUID()));
			} else if(tag == UseTag.M) {
				String content = log.getContent();
				MemberExt member = JSONObject.parseObject(content, MemberExt.class);
				result.add(super.getInfo(member));
			} else if(tag == UseTag.R) {
//				result.add(JSONObject.toJSONString(log.getMemberGUID()));
				result.add(log.getContent());
			}
		}
		return result;
	}

}
