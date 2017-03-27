/**
 * @PackageName:      com.bithealth.memberCore.member.service.impl
 * @FileName:     MemImportLogServiceImpl.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      liuhm
 * @version      V1.0  
 * @Createdate:  2016年8月27日 下午2:19:41  
 * 
 */
package com.bithealth.memberCore.member.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bithealth.memberCore.enmu.UseTag;
import com.bithealth.memberCore.member.dao.MemImportLogMapper;
import com.bithealth.memberCore.member.model.MemImportLog;
import com.bithealth.memberCore.member.model.MemImportLogExample;
import com.bithealth.memberCore.member.service.MemImportLogService;
import com.bithealth.sdk.common.utils.StringUtil;
import com.bithealth.sdk.core.generic.GenericBaseDao;
import com.bithealth.sdk.core.generic.GenericBaseServiceImpl;

/**
 * 类名称: MemImportLogServiceImpl  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年8月27日 下午2:19:41 
 * 
 * @author liuhm
 * @version  
 */
@Service
public class MemImportLogServiceImpl extends GenericBaseServiceImpl<MemImportLog, MemImportLogExample, Long> implements MemImportLogService {

	@Autowired
	private MemImportLogMapper mapper;
	
	@Override
	public GenericBaseDao<MemImportLog, MemImportLogExample, Long> getDao() {
		return mapper;
	}
	
	@Override
	public int insertLogs(List<MemImportLog> list) {
		return mapper.insertBatch(list);
	}

	@Override
	public int deleteByUUID(String uuid, UseTag tag) {
		if(StringUtil.isEmpty(uuid)) {
			return 0;
		}
		MemImportLogExample example = new MemImportLogExample();
		example.createCriteria().andMemberGUIDEqualTo(uuid).andUseTagEqualTo(tag.name());
		return mapper.deleteByExample(example);
	}

	@Override
	public int updateTagByUUID(String uuid, UseTag tag, String reason) {
		if(StringUtil.isEmpty(uuid)) {
			return 0;
		}
		MemImportLog log = new MemImportLog();
		log.setUseTag(tag.name());
		log.setReason(reason);
		MemImportLogExample example = new MemImportLogExample();
		example.createCriteria().andMemberGUIDEqualTo(uuid);
		return mapper.updateByExampleSelective(log, example);
	}

	@Override
	public MemImportLog selectByUUID(String uuid, UseTag tag) {
		MemImportLogExample example = new MemImportLogExample();
		example.createCriteria().andMemberGUIDEqualTo(uuid).andUseTagEqualTo(tag.name());
		List<MemImportLog> list = mapper.selectByExample(example);
		if(list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	@Override
	public MemImportLog updateContent(String uuid, UseTag tag, String content) {
		MemImportLog memberLog = this.selectByUUID(uuid, UseTag.E);
		memberLog.setContent(content);
		memberLog.setUseTag(tag.name());
		mapper.updateByPrimaryKey(memberLog);
		return memberLog;
	}

	@Override
	public int deleteErrorLog(Integer docId) {
		return mapper.deleteErrorLog(docId);
	}

}
