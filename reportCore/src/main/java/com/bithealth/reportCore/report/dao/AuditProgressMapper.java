/*
 * AuditProgressMapper.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-07-20 Created
 */
package com.bithealth.reportCore.report.dao;

import java.util.List;
import java.util.Map;

import com.bithealth.reportCore.report.model.AuditProgress;
import com.bithealth.reportCore.report.model.AuditProgressExample;
import com.bithealth.sdk.core.feature.orm.mybatis.Page;
import com.bithealth.sdk.core.generic.GenericBaseDao;

public interface AuditProgressMapper extends GenericBaseDao<AuditProgress, AuditProgressExample, Long> {
	
	/**
	 * @Title:selectByParamsAndPage 
	 * @Description: 根据医生查询该医生的待审核单项或汇总报告列表，支持分页
	 * @author 谢美团
	 * @param params
	 * @return 
	 * @throws
	 * @retrun List<AuditProgress>
	 */ 
	public List<AuditProgress> selectByParamsAndPage(Page<AuditProgress> page,Map<String,Object> paramMap);
	
	/**
	 * @Title:selectMaxAuditLevel 
	 * @Description:查询审核报告进度中模板的最大审核级数
	 * @author 谢美团
	 * @param auditProgress
	 * @return 
	 * @throws
	 * @retrun int
	 */ 
	public int selectMaxAuditLevel(AuditProgress auditProgress);
	
	/**
	 * @Title:updateByTableNameAndParam 
	 * @Description:根据表名更新审核进度的分表
	 * @author 谢美团
	 * @param parmaMap
	 * @return 
	 * @throws
	 * @retrun int
	 */ 
	public int updateByTableNameAndParam(Map<String ,Object> parmaMap);
	
	/**
	 * @Title:exProc_pro_updOASR 
	 * @Description:调用审核进度表存储过程
	 * @author 谢美团 
	 * @throws
	 * @retrun void
	 */ 
	public void exProc_pro_updOASR(Integer reportNo);
	
	
	/**
	 * @Title:updateByReportNoAndSerialNumber 
	 * @Description:根据报告id等跟新待审
	 * @author 谢美团
	 * @param parmaMap
	 * @return 
	 * @throws
	 * @retrun int
	 */ 
	public int updateByReportNoAndSerialNumber(Map<String ,Object> parmaMap);
	
	/**
	 * @Title:exProc_pro_OtherinsOASR 
	 * @Description:调用pro_OtherinsOASR存储过程
	 * @author 谢美团
	 * @param oasr 
	 * @throws
	 * @retrun void
	 */ 
	public void exProc_pro_OtherinsOASR(AuditProgress oasr);
	
	
}