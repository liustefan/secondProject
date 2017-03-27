package com.bithealth.reportCore.facade.service;

import java.util.List;
import java.util.Map;

import com.bithealth.doctorCore.docGroup.model.DocToGroup;
import com.bithealth.measureCore.bloodPressure.model.Osbp;
import com.bithealth.measureCore.bloodSugar.model.Obsr;
import com.bithealth.measureCore.electrocardio.model.Oecg;
import com.bithealth.measureCore.electrocardio.model.OecgExc;
import com.bithealth.reportCore.facade.model.AuditProgressParam;
import com.bithealth.reportCore.report.model.AuditProgress;
import com.bithealth.reportCore.report.model.SingleReport;
import com.bithealth.reportCore.report.model.SingleReportAudit;
import com.bithealth.reportCore.report.model.SummaryReport;
import com.bithealth.reportCore.report.model.SummaryReportAudit;
import com.bithealth.sdk.core.feature.orm.mybatis.Page;

/**
 * 类名称: ReportIFService  
 * 功能描述: 报告及审核对外接口 
 * 日期: 2016年7月20日 上午11:33:58 
 * 
 * @author 谢美团
 * @version  
 */
public interface ReportIFService{
	
	/**
	 * @Title:selectAuditProgressReportByDocIdAndFunID 
	 * @Description:根据医生id和功能代码查询该医生的待审核的单项或者汇总测量报告
	 * @author 谢美团
	 * @param docId
	 * @param funID
	 * @return 
	 * @throws
	 * @retrun List<AuditProgress>
	 */ 
	public List<AuditProgress> selectAuditProgressReportByDocIdAndFunID(Page<AuditProgress> page,String docId,Integer funID);
	
	
	
	/**
	 * @Title:selectSummaryReportById 
	 * @Description:根据报告id获取汇总报告及其所关联的明细和单项报告
	 * @author 谢美团
	 * @param page
	 * @param reportId
	 * @return 
	 * @throws
	 * @retrun List<SummaryReport>
	 */ 
	public SummaryReport selectSummaryReportById(Integer reportId);
	
	/**
	 * @Title:checkReadSumReportAuthority 
	 * @Description:验证医生是否有报告的审核权限
	 * @author 谢美团
	 * @param docToGroup
	 * @return 
	 * @throws
	 * @retrun boolean
	 */ 
	public  boolean checkReadSumReportAuthority(DocToGroup docToGroup);
	
	

 
	/**
	 * @Title:checkReadSingleReportAuthority 
	 * @Description:验证单项报告审核权限
	 * @author 谢美团
	 * @param odgpId 医生分组
	 * @param docid 医生id
	 * @param orgId 医生做属组织
	 * @param optId 选项
	 * @param auditLevel 审核级别
	 * @return 
	 * @throws
	 * @retrun boolean
	 */ 
	public  boolean checkReadSingleReportAuthority(int odgpId ,int docid,int orgId,int optId,int auditLevel);
	
	
	/**
	 * @Title:isAuditEdit 
	 * @Description:根据选项id 医生id 和当前待审核报告的审核级别 判断医生是否有审核权限
	 * @author 谢美团
	 * @param docId
	 * @param optId
	 * @param currentLevel
	 * @return 
	 * @throws
	 * @retrun boolean
	 */ 
	public boolean isAuditEdit(int docId,int optId,int currentLevel,String reportState);
	
	
	/**
	 * @Title:saveReportAudit 
	 * @Description:保存汇总报告的审核内容
	 * @author 谢美团
	 * @return 
	 * @throws
	 * @retrun boolean
	 */ 
	public boolean saveReportAudit(AuditProgressParam param);
	
	/**
	 * @Title:checkSumRepAudit 
	 * @Description:检查汇总报告审核 
	 * @author 谢美团
	 * @param docid
	 * @param orgid
	 * @param serialNumber
	 * @return 
	 * @throws
	 * @retrun String
	 */ 
	public String checkSumRepAudit(int docid, int orgid, long serialNumber);
	
	/**
	 * @Title:getAuditResult 
	 * @Description:获取同组医生汇总报告审核结果和其他组医生汇总报告审核结果
	 * @author 谢美团
	 * @param list
	 * @return 
	 * @throws
	 * @retrun Map<String,Object>
	 */ 
	Map<String,Object> getSummaryAuditResult(List<SummaryReportAudit> list,Integer docGrpCode);
	
	/**
	 * @Title:getSingleAuditResult 
	 * @Description:获取同组医生单项报告审核结果和其他组医生单项报告审核结果
	 * @author 谢美团
	 * @param list
	 * @param docGrpCode
	 * @return 
	 * @throws
	 * @retrun Map<String,Object>
	 */ 
	Map<String,Object> getSingleAuditResult(List<SingleReportAudit> list,Integer docGrpCode);
	
	
	/**
	 * @Title:selectByDocidAndOrgid 
	 * @Description:根据医生获取单项神恶化报告，并且添加获取该报告的会员名称，模板名称等
	 * @author 谢美团
	 * @param page
	 * @param docId
	 * @param orgId
	 * @return 
	 * @throws
	 * @retrun List<SingleReport>
	 */ 
	public List<SingleReport> getSingleReportByDocidAndOrgid(Page<SingleReport> page,int docId ,int orgId);

	/**
	 * @Title:getMemberReport 
	 * @Description:获取会员报告相关数据
	 * @author 谢美团
	 * @return 
	 * @throws
	 * @retrun Map<String,Object>
	 * @throws Exception 
	 */ 
	public Map<String ,Object> getMemberReport(Integer reportNo) throws Exception;
	
	
	
	/**
	 * @Title:calculOsbp 
	 * @Description:计算血压测量数据24小时
	 * @author 谢美团
	 * @param osbp
	 * @return
	 * @throws Exception 
	 * @throws
	 * @retrun Map<String,Object>
	 */ 
	public Map<String ,Object> calculOsbp(List<Osbp> osbp) throws Exception;
	public Map<String ,Object> calculOsbpDay(List<Osbp> osbp) throws Exception;
	public Map<String ,Object> calculOsbpEvening(List<Osbp> osbp) throws Exception;
	

	/**
	 * @Title:getOptMeasRepCount 
	 * @Description:报告统计报表数据
	 * @author 谢美团
	 * @param n
	 * @param optId
	 * @param memberid
	 * @return 
	 * @throws
	 * @retrun Map<String,Object>
	 */ 
	public Map<String,Object> getRepStatist(Integer memberid) throws Exception;
	
	
	/**
	 * @Title:getAuditProgressByReportNoAndAuditeLevel 
	 * @Description:根据报告单号和审核级别获取审核进度信息 
	 * @author 谢美团
	 * @return 
	 * @throws
	 * @retrun AuditProgress
	 */ 
	public AuditProgress getAuditProgressByReportNoAndAuditeLevel(Integer reportNo,Short auditLevel);
	
	
	
	
	/**
	 * @Title:getLatestDoctorId 
	 * @Description:获取汇总报告中的最新审核医生的id
	 * @author 谢美团
	 * @param summaryReport
	 * @return 
	 * @throws
	 * @retrun Integer
	 */ 
	public Integer getLatestDoctorId(SummaryReport summaryReport);
	
	public Map<String, Object> wrapCalculOsbpDayData(List<Osbp> osbps) throws Exception;
	 
	public Map<String, Object> wrapCalculOsbpData(List<Osbp> osbps) throws Exception;
	
	public Map<String, Object> wrapCalculOsbpEveningData(List<Osbp> osbps) throws Exception;
	
	public List<OecgExc> doElectrocardioReportData(List<Oecg> oecgs, Map<String, List<OecgExc>> map);
	
	public Map<String, Object> getExData(Object object, List<Obsr> obsrs);
	
	public Map<String, Object> getExportWordData(Integer reportNo,Short auditLevel) throws Exception;
	
	public Map<String, Object> consTableData(List<Obsr> obsrs);
	
	public Obsr getObsr(Object object, boolean maxOrMin);
	
	public String getAvgObsr(Object object);
	
	/**
	 * @Title:saveSingleAuditContent 
	 * @Description:保存单项报告审核内容 
	 * @author 谢美团
	 * @param oasr
	 * @param myAdvice
	 * @param auditMode
	 * @param approvalReason
	 * @return 
	 * @throws
	 * @retrun boolean
	 */ 
	public boolean saveSingleAuditContent_trans(AuditProgress oasr, String myAdvice, String auditMode,String approvalReason);
	
	
	
}



