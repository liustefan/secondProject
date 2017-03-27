package com.bithealth.reportCore.report.service;

import java.util.List;
import java.util.Map;

import com.bithealth.sdk.core.feature.orm.mybatis.Page;
import com.bithealth.sdk.core.generic.GenericBaseService;
import com.bithealth.packagCore.packag.model.MemBerPackagTemplate;
import com.bithealth.reportCore.report.model.AuditProgress;
import com.bithealth.reportCore.report.model.AuditProgressExample; 
import com.bithealth.reportCore.report.model.AuditProgressParams;

public interface AuditProgressService extends GenericBaseService<AuditProgress,AuditProgressExample,Long > {    
	
	/**
	 * @Title:selectByParamsAndpage 
	 * @Description:根据医生查询该医生的待审核单项或汇总报告列表，支持分页
	 * @author 谢美团
	 * @param params
	 * @return 
	 * @throws
	 * @retrun List<AuditProgress>
	 */ 
	public List<AuditProgress> selectByParamsAndPage(Page<AuditProgress> page,AuditProgressParams params);
	
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
	 * @param auditProgress
	 * @param tableName
	 * @return 
	 * @throws
	 * @retrun int
	 */ 
	public int updateByTableNameAndParam(AuditProgress auditProgress,String tableName);
	
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
	 * @Description:根据报告id更新单项审核进度表
	 * @author 谢美团
	 * @param parmaMap
	 * @return 
	 * @throws
	 * @retrun int
	 */ 
	public int updateByReportNoAndSerialNumber(String tableName,Integer docId,Integer reportNo,Long serialNumber,String AuditState,String YNTag);
	
	
	/**
	 * @Title:exProc_pro_updOASR 
	 * @Description:调用pro_OtherinsOASR存储过程
	 * @author 谢美团 
	 * @throws
	 * @retrun void
	 */ 
	public void exProc_pro_OtherinsOASR(AuditProgress auditProgress);
	
	
}
