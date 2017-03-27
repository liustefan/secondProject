/*
 * MemImportLogMapper.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-09-01 Created
 */
package com.bithealth.memberCore.member.dao;

import java.util.List;

import com.bithealth.memberCore.member.model.MemImportLog;
import com.bithealth.memberCore.member.model.MemImportLogExample;
import com.bithealth.sdk.core.generic.GenericBaseDao;

public interface MemImportLogMapper extends GenericBaseDao<MemImportLog, MemImportLogExample, Long> {
	
	public int insertBatch(List<MemImportLog> list);
	
	public int deleteErrorLog(Integer docId);
}