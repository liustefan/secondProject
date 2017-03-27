/*
 * SingleAuditDetailMapper.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-07-14 Created
 */
package com.bithealth.reportCore.template.dao;

import java.util.List;

import com.bithealth.reportCore.template.model.SingleAuditDetail;
import com.bithealth.reportCore.template.model.SingleAuditDetailExample;
import com.bithealth.reportCore.template.model.SingleAuditDetailKey;
import com.bithealth.sdk.core.generic.GenericBaseDao;

public interface SingleAuditDetailMapper extends GenericBaseDao<SingleAuditDetail, SingleAuditDetailExample, SingleAuditDetailKey> {
	
	/**
	 * @Title:insertBatch 
	 * @Description:批量插入
	 * TODO(这里描述这个方法适用条件  执行流程  使用方法 注意事项– 可选).  
	 * @author 谢美团
	 * @param list
	 * @return 
	 * @throws
	 * @retrun int
	 */ 
	public int insertByBatch(List<SingleAuditDetail> list);
}