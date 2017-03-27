package com.bithealth.reportCore.facade.service.impl;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.bithealth.doctorCore.docGroup.model.DocToGroup;
import com.bithealth.doctorCore.docGroup.model.DocToGroupExample;
import com.bithealth.doctorCore.docGroup.model.DocToGroupExample.Criteria;
import com.bithealth.doctorCore.docGroup.model.DoctorGroup;
import com.bithealth.doctorCore.docGroup.model.DoctorGroupExample;
import com.bithealth.doctorCore.docGroup.service.DoctorGroupService;
import com.bithealth.doctorCore.docGroup.service.DoctorToGroupService;
import com.bithealth.doctorCore.doctor.model.Doctor;
import com.bithealth.doctorCore.doctor.model.DoctorExample;
import com.bithealth.doctorCore.doctor.service.DoctorService;
import com.bithealth.measureCore.bloodPressure.model.Osbp;
import com.bithealth.measureCore.bloodPressure.model.OsbpExample;
import com.bithealth.measureCore.bloodPressure.service.BloodPressureService;
import com.bithealth.measureCore.bloodSugar.model.Obsr;
import com.bithealth.measureCore.bloodSugar.model.ObsrExample;
import com.bithealth.measureCore.bloodSugar.service.BloodSugarService;
import com.bithealth.measureCore.electrocardio.model.Ecg1;
import com.bithealth.measureCore.electrocardio.model.Ecg2;
import com.bithealth.measureCore.electrocardio.model.Oecg;
import com.bithealth.measureCore.electrocardio.model.OecgExample;
import com.bithealth.measureCore.electrocardio.model.OecgExc;
import com.bithealth.measureCore.electrocardio.service.Ecg1Service;
import com.bithealth.measureCore.electrocardio.service.Ecg2Service;
import com.bithealth.measureCore.electrocardio.service.ElectrocardioExcService;
import com.bithealth.measureCore.electrocardio.service.ElectrocardioService;
import com.bithealth.measureCore.electrocardioPulse.model.ExcOppg;
import com.bithealth.measureCore.electrocardioPulse.model.Oppg;
import com.bithealth.measureCore.electrocardioPulse.model.OppgExample;
import com.bithealth.measureCore.electrocardioPulse.service.PulseService;
import com.bithealth.measureCore.enmu.BloodSugarTimeQType;
import com.bithealth.measureCore.enmu.ElectrocardioType;
import com.bithealth.memberCore.member.model.Member;
import com.bithealth.memberCore.member.model.MemberExample;
import com.bithealth.memberCore.member.model.MemberExt;
import com.bithealth.memberCore.member.service.MemberService;
import com.bithealth.msgCenterCore.constants.MessageTypeEnum;
import com.bithealth.msgCenterCore.constants.UserTypeEnum;
import com.bithealth.msgCenterCore.facade.service.MessageCenterFacadeService;
import com.bithealth.msgCenterCore.model.MessageCenter;
import com.bithealth.questionCore.answer.model.OuaiExample;
import com.bithealth.questionCore.answer.service.OuaiService;
import com.bithealth.reportCore.facade.constants.Contrants;
import com.bithealth.reportCore.facade.enmu.FunctionEnmu;
import com.bithealth.reportCore.facade.enmu.ReportStatusEnmu;
import com.bithealth.reportCore.facade.model.AuditProgressParam;
import com.bithealth.reportCore.facade.service.ReportIFService;
import com.bithealth.reportCore.report.model.AuditProgress;
import com.bithealth.reportCore.report.model.AuditProgressExample;
import com.bithealth.reportCore.report.model.AuditProgressParams;
import com.bithealth.reportCore.report.model.SingleReport;
import com.bithealth.reportCore.report.model.SingleReportAudit;
import com.bithealth.reportCore.report.model.SingleReportAuditExample;
import com.bithealth.reportCore.report.model.SingleReportExample;
import com.bithealth.reportCore.report.model.SummaryReport;
import com.bithealth.reportCore.report.model.SummaryReportAudit;
import com.bithealth.reportCore.report.model.SummaryReportRelation;
import com.bithealth.reportCore.report.model.SummaryReportRelationExample;
import com.bithealth.reportCore.report.service.AuditProgressService;
import com.bithealth.reportCore.report.service.SingleReportAuditService;
import com.bithealth.reportCore.report.service.SingleReportService;
import com.bithealth.reportCore.report.service.SummaryReportAuditService;
import com.bithealth.reportCore.report.service.SummaryReportRelationService;
import com.bithealth.reportCore.report.service.SummaryReportService;
import com.bithealth.reportCore.template.model.SingleTemplate;
import com.bithealth.reportCore.template.model.SingleTemplateExample;
import com.bithealth.reportCore.template.model.SummaryTemplate;
import com.bithealth.reportCore.template.model.SummaryTemplateExample;
import com.bithealth.reportCore.template.service.SingleTemplateService;
import com.bithealth.reportCore.template.service.SummaryTemplateService;
import com.bithealth.sdk.client.http.Response;
import com.bithealth.sdk.common.utils.TimeUtil;
import com.bithealth.sdk.core.feature.orm.mybatis.Page;



/**
 * 类名称: ReportIFServiceImpl  
 * 功能描述: 报告及审核对外服务接口实现类  
 * 日期: 2016年7月20日 上午11:35:11 
 * 
 * @author 谢美团
 * @version  
 */
@Service("reportIFService") 
@SuppressWarnings("restriction")
public class ReportIFServiceImpl implements ReportIFService{
	
	protected static Logger logger = Logger.getLogger(ReportIFServiceImpl.class);
	
	@Resource
	private DoctorToGroupService doctorToGroupService;

	@Resource
	private AuditProgressService auditProgressService;
	@Resource
	private SingleReportService singleReportService;
	@Resource
	private SummaryTemplateService summaryTemplateService;
	@Resource
	private SingleTemplateService singleTemplateService;
	@Resource
	private SummaryReportService summaryReportService;
	@Resource
	SummaryReportAuditService  summaryReportAuditService;
    @Resource
    DoctorService doctorService;
    @Resource
    DoctorGroupService doctorGroupService;
    @Resource
    MemberService memberService;
    @Resource
    BloodPressureService bloodPressureService;
    @Resource
    BloodSugarService bloodSugarService;
    @Resource
    SingleReportAuditService singleReportAuditService ;
    @Resource
    PulseService  pulseService;
    @Resource
    ElectrocardioService electrocardioService;
    @Resource
    Ecg1Service ecg1Service;
    @Resource
    Ecg2Service ecg2Service;
    @Resource
    SummaryReportRelationService summaryReportRelationService;
    @Resource
    OuaiService ouaiService;
    @Resource
    MessageCenterFacadeService  msgService;
    @Resource
    ElectrocardioExcService electrocardioExcService;
    
    

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<AuditProgress> selectAuditProgressReportByDocIdAndFunID(Page<AuditProgress> page,String docId, Integer funID) {

		List<AuditProgress> AuditProgressList = new ArrayList<AuditProgress>();
		//根据医生id和功能id获取该医生的所有分组的审核权限明细
		List<Integer> funIdList = new ArrayList<Integer>();
		funIdList.add(FunctionEnmu.SINGLE_MEASURE.getValue());
		funIdList.add(FunctionEnmu.SUMMARY_MEASURE.getValue());
		List<DocToGroup>  docToGroupList =  doctorToGroupService.selectByDocIdAndFunId(Integer.parseInt(docId), funIdList,null);
		if(docToGroupList == null || docToGroupList.size() == 0){
			return AuditProgressList;
		}		
		//根据医生id和该医生的分组审核权限获取待审核的汇总报告
		AuditProgressParams params = new AuditProgressParams();
		params.setDoctorId(docId);
		params.setFunctionId(funID);
		List list = new ArrayList();
		for(DocToGroup docToGroup:docToGroupList){
			list.add(docToGroup.getOdgpid());
		}
		params.setGroupIdList(list);
		
		List<AuditProgress> auditProgressList = auditProgressService.selectByParamsAndPage(page, params);

		if(auditProgressList != null && auditProgressList.size() > 0){
			if(funID == 1){ //单项模板
				SingleTemplateExample  example  = new SingleTemplateExample ();
				example.createCriteria().andTempCodeIn(getTempCodeList(auditProgressList));
				 List<SingleTemplate> singleTemplateList = singleTemplateService.selectByExample(example);
				 for(AuditProgress auditProgress:auditProgressList){
					 for(SingleTemplate singleTemplate:singleTemplateList){
						 if(singleTemplate.getTempCode() != null && singleTemplate.getTempCode().equals(auditProgress.getTempCode())){
							 auditProgress.setTemplateName(singleTemplate.getTempName());
						 }
					 }
				 }
			}else if(funID == 2){ //汇总模板
				SummaryTemplateExample example = new SummaryTemplateExample();
				example.createCriteria().andSumRepTempCodeIn(getTempCodeList(auditProgressList));
				 List<SummaryTemplate> summaryTemplateList = summaryTemplateService.selectByExample(example);
				 for(AuditProgress auditProgress:auditProgressList){
					 for(SummaryTemplate summaryTemplate:summaryTemplateList){
						 if(summaryTemplate.getSumRepTempCode() != null && summaryTemplate.getSumRepTempCode().equals(auditProgress.getTempCode())){
							 auditProgress.setTemplateName(summaryTemplate.getTempName());
						 }
					 }
				 }
			}
			// 根据报告查询检验报告期内的测量是否有异常
			auditProgressList = checkAbnormal(auditProgressList,funID);
		}
		return auditProgressList;
	}
	
	
	private List<Integer> getTempCodeList(List<AuditProgress>  auditProgressList){
		List<Integer> list = new ArrayList<Integer>();
		for(AuditProgress auditProgress:auditProgressList){
			list.add(auditProgress.getTempCode());
		}
		return list;
	}
	
	
	
	
	/**
	 * @Title:checkAbnormal 
	 * @Description:检查报告是否有异常
	 * @author 谢美团
	 * @param auditProgressList
	 * @param funID
	 * @return 
	 * @throws
	 * @retrun List<AuditProgress>
	 */ 
	private List<AuditProgress> checkAbnormal(List<AuditProgress> auditProgressList,Integer funID){

		for (AuditProgress oasr : auditProgressList) {
			if (funID == 1) {// 单项测量中是否有异常
				SingleReport omrr = singleReportService.selectById(oasr.getReportNo());
				omrr = getMeasureBySingleReport(omrr);
				// 是否有心电和三合一异常数据
				if (omrr.getOecgs() != null) {
					//三合一和心电中心电是否异常
					for (int i = 0; i < omrr.getOecgs().size(); i++) {
						List<Ecg2> ecg2s = omrr.getOecgs().get(i).getEcg2s();
						if (!ecg2s.isEmpty()) {
							oasr.setExt("Y");
							break;
						}
					}
					//三合一中脉搏是否异常
					List<Oecg> oecgs = omrr.getOecgs();
					for(Oecg oecg : oecgs){
						Oppg  oppg  = pulseService.selectOppgByOecg(oecg.getDocentry());
						if(oppg != null && oppg.getMeasureResult().size() != 0){
							oasr.setExt("Y");
							break;
						}
					}
				}
				// 是否有血糖异常数据
				if (omrr.getObsrs() != null) {
					for (int i = 0; i < omrr.getObsrs().size(); i++) {
						String result = omrr.getObsrs().get(i).getAnalysisresult();
						if (!"0".equals(result)) {
							oasr.setExt("Y");
							break;
						}
					}
				}
				// 是否有血压异常数据
				if (omrr.getOsbps() != null) {
					for (int i = 0; i < omrr.getOsbps().size(); i++) {
						String result = omrr.getOsbps().get(i).getAbnormal();
						if (!"0".equals(result)) {
							oasr.setExt("Y");
							break;
						}
					}
				}
			}else if(funID == 2){ // 汇总测量中是否有异常
				SummaryReport osmr = summaryReportService.selectById(oasr.getReportNo());
				osmr = getMeasureBySummaryReport(osmr);
				for (SingleReport omrr : osmr.getSingleReportList()) {
					// 是否有心电和三合一异常数据
					if (omrr.getOecgs() != null) {
						//三合一和心电中心电是否异常
						for (int i = 0; i < omrr.getOecgs().size(); i++) {
							List<Ecg2> ecg2s = omrr.getOecgs().get(i).getEcg2s();
							if (!ecg2s.isEmpty()) {
								oasr.setExt("Y");
								break;
							}
						}
						//三合一中脉搏是否异常
						List<Oecg> oecgs = omrr.getOecgs();
						for(Oecg oecg : oecgs){
							Oppg  oppg  = pulseService.selectOppgByOecg(oecg.getDocentry());
							if(oppg != null && oppg.getMeasureResult().size() != 0){
								oasr.setExt("Y");
								break;
							}
						}
					}
					// 是否有血糖异常数据
					if (omrr.getObsrs() != null) {
						for (int i = 0; i < omrr.getObsrs().size(); i++) {
							String result = omrr.getObsrs().get(i)
									.getAnalysisresult();
							if (!"0".equals(result)) {
								oasr.setExt("Y");
								break;
							}
						}
					}
					// 是否有血压异常数据
					if (omrr.getOsbps() != null) {
						for (int i = 0; i < omrr.getOsbps().size(); i++) {
							String result = omrr.getOsbps().get(i)
									.getAbnormal();
							if (!"0".equals(result)) {
								oasr.setExt("Y");
								break;
							}
						}
					}

				}
			}
		}
		
		return auditProgressList;
	}


	public SummaryReport selectSummaryReportById(Integer reportId) {
		//获取汇总报告
		SummaryReport summaryReport =  summaryReportService.selectById(reportId);
		//获取汇总报告关联的单项报告列表
		List<SingleReport>  singleReportList = singleReportService.selectBySumReportId(reportId);
		for(SingleReport singleReport : singleReportList){
			getMeasureBySingleReport(singleReport);
		}
		summaryReport.setSingleReportList(singleReportList);
		return summaryReport;
	}
	
	
	
	/**
	 * @Title:checkReadSumReportAuthority 
	 * @Description:根据医生id医生所属的组织和报告id等看该医生是否有该条报告的查看审核权限
	 * @author 谢美团
	 * @return 
	 * @throws
	 * @retrun boolean
	 */ 
	public  boolean checkReadSumReportAuthority(DocToGroup docToGroup){
		DocToGroupExample example = new DocToGroupExample();
		
		Criteria  Criteria  = example.createCriteria();
		Criteria.andAuditlevelEqualTo(docToGroup.getAuditlevel()).andDocidEqualTo(docToGroup.getDocid()).andOrgidEqualTo(docToGroup.getOrgid());
		if(docToGroup.getOdgpid() != -1){ //分组id为 -1 表示该组织下有审核权限的医生都可以审核，不管分组。分组 id不等于 -1时表示只有该组织下的指定医生分组的医生才有审核权限
			Criteria.andOdgpidEqualTo(docToGroup.getOdgpid());
		}
		List<DocToGroup> list = doctorToGroupService.selectByExample(example);
		if(list != null && list.size() > 0){
			return true;
		}else{
			return false;
		}
	}


	public boolean isAuditEdit(int docId, int optId, int currentLevel,String reportState) {
		if( !ReportStatusEnmu.pending_audit.getValue().equals(reportState)){ //不是待审状态
			return false;
		}
		List<DocToGroup>  docToGroupList =  doctorToGroupService.selectByDocIdAndFunId(docId, null,optId);
		if(docToGroupList != null && docToGroupList.size() > 0){
			for(DocToGroup docToGroup:docToGroupList){
				if(docToGroup.getAuditlevel() != null && docToGroup.getAuditlevel() == currentLevel){
					return true;
				}
			}
		}
		return false;
	}


	public boolean saveReportAudit(AuditProgressParam auditProgressParam) {		

		//根据主键获取审核进度明细
		AuditProgress auditProgress = auditProgressService.selectById(auditProgressParam.getSerialNumber());
		auditProgress.setDocid(auditProgressParam.getDocid());//当前医生id
				
		//获取汇总模板的最大审核级别
		int maxLevel = auditProgressService.selectMaxAuditLevel(auditProgress);
		
		boolean isFinalAudit = false;//是否为终审
		if (auditProgress.getAuditLevel() == maxLevel){
			isFinalAudit = true;
		}
		
		//更新汇总报告表	
		SummaryReport  summaryReport  = new SummaryReport ();
		summaryReport.setID(auditProgress.getReportNo());
		summaryReport.setChkDesc(auditProgressParam.getMyAdvice());
		if(isFinalAudit){ //终审 
			summaryReport.setPendingLevel((short)0);
			summaryReport.setReportState(ReportStatusEnmu.publish.getValue());//报告已发布
			summaryReport.setReadStatus(1);//未读
		}else{ 
			summaryReport.setPendingLevel((short)(auditProgress.getAuditLevel()+1));
			summaryReport.setReportState(ReportStatusEnmu.pending_audit.getValue());//报告审核中
		}
		summaryReportService.update(summaryReport);
		
		//插入汇总报告审核结果
		SummaryReportAudit auditParam = new SummaryReportAudit();
		auditParam.setAuditDesc(auditProgressParam.getAuditMode());
		BeanUtils.copyProperties(auditProgress, auditParam);
		auditParam.setID((Integer)auditProgress.getReportNo());
		auditParam.setAuditTime(new Date());
		auditParam.setAuditDesc(auditProgressParam.getMyAdvice());
		if(isFinalAudit){ //终审 
			auditParam.setStat(auditProgress.getAuditState().equals("R")?(short)3:0);
		}else{
			auditParam.setStat((short)0);
		}
		summaryReportAuditService.insert(auditParam);
		
		//根据表名更新报告审核进度的分表
		String tableName = "oasr_"+auditProgress.getSerialNumber()%100;
		AuditProgress param = new AuditProgress();
		param.setSerialNumber(auditProgress.getSerialNumber());
		param.setAuditState("Y");
		param.setDocid(auditProgressParam.getDocid());
		param.setAuditDatetime(new Date());
		if(auditProgress.getAuditLevel() == maxLevel){ //终审 
			param.setYNTag("Y");
		}
		auditProgressService.updateByTableNameAndParam(param, tableName);
		
		if(isFinalAudit){ 
			//终审流程，调用存储过程
			auditProgressService.exProc_pro_updOASR(auditProgress.getReportNo());
			//发送消息给关注的人
			SummaryTemplate  summaryTemplate  = summaryTemplateService.selectById(auditProgress.getTempCode());
			MessageCenter messageCenter = new MessageCenter();
			messageCenter.setLastcontent("您收到一条测量报告:"+summaryTemplate.getTempName());
			messageCenter.setLastsourceid(auditProgress.getReportNo().longValue());
			messageCenter.setMsgtype(MessageTypeEnum.SUMMARY_REPORT.getType());
			Member  member  = memberService.selectById(auditProgress.getMemberid());
			messageCenter.setReceiver(member.getMemberGUID());
			messageCenter.setReceivetype(UserTypeEnum.MEMBER.getType());
			messageCenter.setSender("0");
			messageCenter.setSendtype(UserTypeEnum.SYSTEM.getType());
			Response response =new Response ();
			try {
				response = msgService.insertOrUpdateMessageSynchronized(messageCenter);
			} catch (Exception e) {
				logger.error("审核完成，发送消息给测量报告的会员发生异常："+JSONObject.toJSONString(response));
			}
		}	
		return true;
	}


	public String checkSumRepAudit(int docid, int orgid, long serialNumber) {
		//根据主键查询审核进度明细
		AuditProgress  auditProgress  = auditProgressService.selectById(serialNumber);
		String result = "Y";
		if(auditProgress != null && result.equals(auditProgress.getAuditState())){ //防止重申
			DocToGroup docToGroup = new DocToGroup();
			docToGroup.setAuditlevel(auditProgress.getAuditLevel());
			docToGroup.setDocid(docid);
			docToGroup.setOrgid(orgid);
			docToGroup.setOdgpid(auditProgress.getDocGrpCode());
			if(checkReadSumReportAuthority(docToGroup)){  
				result = "N";   //防止重申
			}
		}
		return result;
	}


	public Map<String, Object> getSummaryAuditResult(List<SummaryReportAudit> list,Integer docGrpCode) {
		Map<String,Object> map = new HashMap<String,Object>();
    	List<SummaryReportAudit> smr1Commons = new ArrayList<SummaryReportAudit>();// 同组医生审核结果
    	List<SummaryReportAudit> smr1Others = new ArrayList<SummaryReportAudit>();// 其他组医生审核结果
    	if(list != null && list.size() > 0){
    	  	Page<Doctor> page = new Page<Doctor>(1,20);
        	DoctorExample example = new DoctorExample();
        	List<Integer> docIdList = new ArrayList<Integer>();
        	for(SummaryReportAudit audit:list){
        		docIdList.add(audit.getDocid());
        	}
        	example.createCriteria().andDocidIn(docIdList);
        	List<Doctor> doctorList = doctorService.selectByExampleAndPage(page, example);
        	
        	for(SummaryReportAudit audit:list){
        		for(Doctor doctor:doctorList){
        			if(doctor.getDocid().equals(audit.getDocid())){
        				audit.setDoctorName(doctor.getDocname());
        				audit.setSignaddress(doctor.getSignaddress());
        				break;
        			}
        		}
        		if(audit.getDocGrpCode() != null && audit.getDocGrpCode().equals(docGrpCode)){
        			smr1Commons.add(audit);
        		}else{
        			smr1Others.add(audit);
        		}
        	}	
    	}
    	map.put("smr1Commons", smr1Commons);
    	map.put("smr1Others", smr1Others);
		return map;
	}


	public List<SingleReport> getSingleReportByDocidAndOrgid(Page<SingleReport> page, int docId, int orgId) {
		
		List<SingleReport> singleReportList = singleReportService.selectByDocidAndOrgid(page, docId, orgId);
		//根据报告集合批量获取报告关联的会员姓名
		List<Integer> memberIdList = new ArrayList<Integer>();
		for(SingleReport singleReport:singleReportList){
			memberIdList.add(singleReport.getMemberid());
		}
		MemberExample example  = new MemberExample ();
		example.createCriteria().andMemberidIn(memberIdList);
		List<Member> memberList = memberService.selectByExample(example);
		
		for(SingleReport singleReport:singleReportList){
			for(Member member:memberList){
				if(singleReport.getMemberid().equals(member.getMemberid())){
					singleReport.setMemName(member.getMemname());
					break;
				}
			}
		}
		return singleReportList;
	}


	public Map<String, Object> getMemberReport(Integer reportNo) throws Exception {
		
		Map<String,Object> resultMap = new HashMap<String,Object>();
    	//获取审核报告进度数据
    	AuditProgressExample auditExample = new AuditProgressExample();
    	auditExample.createCriteria().andReportNoEqualTo(reportNo).andOptIdLessThan((short)5);
    	List<AuditProgress>  oasrList = auditProgressService.selectByExample(auditExample);
    	AuditProgress oasr = new AuditProgress();
    	if(oasrList != null && oasrList.size() > 0){
    		oasr = oasrList.get(0);
    	}
    	if(oasr.getTempCode() != null){
    		SingleTemplate  singleTemplate  = singleTemplateService.selectById(oasr.getTempCode());
    		oasr.setTemplateName(singleTemplate.getTempName());
    	}
    	
    	resultMap.put("oasr", oasr);
    	
    	//获取单项测量报告信息
    	SingleReport   omrr  = singleReportService.selectById(reportNo);
    	if(omrr == null || omrr.getMemberid() == null){
    		return null;
    	}
    	//获取报告广联的审核结果
    	SingleReportAuditExample example = new SingleReportAuditExample();
    	example.createCriteria().andIDEqualTo(omrr.getID());
    	List<SingleReportAudit> auditList = singleReportAuditService.selectByExample(example);
    	
    	omrr.setAuditList(auditList);
    	//根据报告获取测量数据
    	omrr = getMeasureBySingleReport(omrr);
    	resultMap.put("omrr", omrr);
		
    	//获取会员信息
    	MemberExt  omem = memberService.selectMemberExtById(omrr.getMemberid());
    	resultMap.put("omem", omem);
    	//会员年龄
		String dataStr = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		String datel = dataStr.substring(0, 4);
		if(omem != null && omem.getBirthdate() != null){
			String ageStr = new SimpleDateFormat("yyyy-MM-dd").format(
			omem.getBirthdate()).substring(0, 4);
			Integer age = Integer.parseInt(datel) - Integer.parseInt(ageStr);
			resultMap.put("age", age);
		}
		// 测量持续时间
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date measTermTime = sdf.parse(sdf.format(omrr.getMeasTermTime()));
		Date measTime = sdf.parse(sdf.format(omrr.getMeasTime()));
		Calendar cal = Calendar.getInstance();    
        cal.setTime(measTermTime);    
        long time1 = cal.getTimeInMillis();                 
        cal.setTime(measTime);    
        long time2 = cal.getTimeInMillis();         
        Short lastDay = (short) ((time1 - time2)/ (24 * 60 * 60 * 1000) + 1);
        resultMap.put("lastDay", lastDay);
		return resultMap;
	}
	
	
	/**
	 * @Title:getMeasureBySingleReport 
	 * @Description:根据报告查询其关联的测量数据
	 * @author 谢美团
	 * @param singleReport
	 * @return 
	 * @throws
	 * @retrun SingleReport
	 */ 
	private SingleReport getMeasureBySingleReport(SingleReport singleReport){
		switch(singleReport.getOptId()){
			case 1://血压
				OsbpExample example = new OsbpExample();
				example.createCriteria().andMemberidEqualTo(singleReport.getMemberid()).andTesttimeGreaterThanOrEqualTo(singleReport.getMeasTime())
						.andTesttimeLessThanOrEqualTo(singleReport.getMeasTermTime());
				example.setOrderByClause("TestTime desc");
				List<Osbp> osbps = bloodPressureService.selectByExample(example);
				singleReport.setOsbps(osbps);
			   break;
			case 2://血糖
				ObsrExample obsrexample = new ObsrExample();
				obsrexample.createCriteria().andMemberidEqualTo(singleReport.getMemberid()).andTesttimeGreaterThanOrEqualTo(singleReport.getMeasTime())
							.andTesttimeLessThanOrEqualTo(singleReport.getMeasTermTime());
				obsrexample.setOrderByClause("TestTime desc");
				List<Obsr> obsrs = bloodSugarService.selectByExample(obsrexample);
				if(obsrs != null){
					for(Obsr obsr:obsrs){
						try{
							obsr.setPeriodName(BloodSugarTimeQType.getTimeQTypeName(Integer.parseInt(obsr.getTimeperiod())));
						}catch(Exception e){
							
						}
					}
				}
				singleReport.setObsrs(obsrs);
			    break;
			case 3: //三合一
				OppgExample oppgExample = new OppgExample();
				oppgExample.createCriteria().andMemberidEqualTo(singleReport.getMemberid()).andMeasuretimeGreaterThanOrEqualTo(singleReport.getMeasTime())
							.andMeasuretimeLessThanOrEqualTo(singleReport.getMeasTermTime());
				oppgExample.setOrderByClause("MeasureTime desc");
				List<Oppg> oppgs = pulseService.selectByExample(oppgExample);
				if(oppgs != null && oppgs.size() > 0){
					singleReport.setOppgs(oppgs);
					List<Long> eventIds = new ArrayList<Long>();
					for(Oppg oppg:oppgs){
						eventIds.add(oppg.getEventid());
						oppg.setExcOppgs(getExcPulseInfo(oppg));
						oppg.setOecg(electrocardioService.selectElectrocardioByEventId(oppg.getEventid()));
					}
					//获取三合一测量数据
					OecgExample oecgExample = new OecgExample();
					oecgExample.createCriteria().andEventidIn(eventIds);
					List<Oecg> oecgs = electrocardioService.selectByExample(oecgExample);
					//获取测量数据的异常信息
					for(Oecg oecg:oecgs){
						oecg = getEcg2ByOecg(oecg);
						//获取该条心电数据对应的脉搏数据
						Oppg  oppg  = pulseService.selectOppgByOecg(oecg.getDocentry());
						if(oppg != null && oppg.getStatustag() == 2){
							oppg.setExtName(oppg.getMeasureResult());
						}
						oecg.setOppg(oppg);
					}
					singleReport.setOecgs(oecgs);
				}
				break;
			case 4: //动态心电
				Page<Oecg>  page = electrocardioService.selectElectrocardioAndPage(singleReport.getMemberid(), 1, 50, singleReport.getMeasTime(), singleReport.getMeasTermTime());
				List<Oecg> oecgs = page.getResult();
				//获取测量数据的异常信息
				for(Oecg oecg:oecgs){
					oecg = getEcg2ByOecg(oecg);
				}
				singleReport.setOecgs(oecgs);
			   break;
			default: new IllegalArgumentException("没有此选项测量报告存在！");
		}
		return singleReport;
	}

    private List<ExcOppg> getExcPulseInfo(Oppg oppg){
		List<ExcOppg> list = new ArrayList<ExcOppg>();
		if(oppg.getPulserate() == null){
			oppg.setPulserate((short)0);
		}
		if(oppg.getPulserate() < 55){
			ExcOppg exc = new ExcOppg();
			exc.setName("平均脉率");
			exc.setValue(oppg.getPulserate());
			exc.setResult("偏低");
			list.add(exc);
		}else if(oppg.getPulserate() > 100){
			ExcOppg exc = new ExcOppg();
			exc.setName("平均脉率");
			exc.setValue(oppg.getPulserate());
			exc.setResult("偏低");
			list.add(exc);
		}
		
		if(oppg.getCo() == null){
			oppg.setCo(BigDecimal.ZERO);
		}
		if(oppg.getCo().compareTo(new BigDecimal(3)) < 0){
			ExcOppg exc = new ExcOppg();
			exc.setName("平均每分射血量");
			exc.setValue(oppg.getCo().doubleValue());
			exc.setResult("偏低");
			list.add(exc);
		}else if(oppg.getCo().compareTo(new BigDecimal(7.5)) > 0){
			ExcOppg exc = new ExcOppg();
			exc.setName("平均每分射血量");
			exc.setValue(oppg.getCo().doubleValue());
			exc.setResult("偏高");
			list.add(exc);
		}
		
		if(oppg.getSv() == null){
			oppg.setSv(BigDecimal.ZERO);
		}
		if(oppg.getSv().compareTo(new BigDecimal(55)) < 0){
			ExcOppg exc = new ExcOppg();
			exc.setName("心脏每搏射血量");
			exc.setValue(oppg.getSv().doubleValue());
			exc.setResult("偏低");
			list.add(exc);
		}else if(oppg.getSv().compareTo(new BigDecimal(105)) > 0){
			ExcOppg exc = new ExcOppg();
			exc.setName("心脏每搏射血量");
			exc.setValue(oppg.getSv().doubleValue());
			exc.setResult("偏高");
			list.add(exc);
		}
		
		if(oppg.getSpo() == null){
			oppg.setSpo((short)0);
		}
		if(oppg.getSpo() < 95){
			ExcOppg exc = new ExcOppg();
			exc.setName("血氧饱和度");
			exc.setValue(oppg.getSpo());
			exc.setResult("偏低");
			list.add(exc);
		}else if(oppg.getSpo() > 100){
			ExcOppg exc = new ExcOppg();
			exc.setName("血氧饱和度");
			exc.setValue(oppg.getSpo());
			exc.setResult("偏高");
			list.add(exc);
		}
		
		if(oppg.getCi() == null){
			oppg.setCi(BigDecimal.ZERO);
		}
		if(oppg.getCi().compareTo(new BigDecimal(2.3)) < 0){
			ExcOppg exc = new ExcOppg();
			exc.setName("心指数");
			exc.setValue(oppg.getCi().doubleValue());
			exc.setResult("偏低");
			list.add(exc);
		}else if(oppg.getCi().compareTo(new BigDecimal(100)) > 0){
			ExcOppg exc = new ExcOppg();
			exc.setName("心指数");
			exc.setValue(oppg.getCi().doubleValue());
			exc.setResult("偏高");
			list.add(exc);
		}
		
		if(oppg.getSpi() == null){
			oppg.setSpi(BigDecimal.ZERO);
		}
		if(oppg.getSpi().compareTo(new BigDecimal(33)) < 0){
			ExcOppg exc = new ExcOppg();
			exc.setName("心搏指数");
			exc.setValue(oppg.getSpi().doubleValue());
			exc.setResult("偏低");
			list.add(exc);
		}else if(oppg.getSpi().compareTo(new BigDecimal(200)) > 0){
			ExcOppg exc = new ExcOppg();
			exc.setName("心搏指数");
			exc.setValue(oppg.getSpi().doubleValue());
			exc.setResult("偏低");
			list.add(exc);
		}
		
		if(oppg.getK() == null){
			oppg.setK(BigDecimal.ZERO);
		}
		if(oppg.getK().compareTo(new BigDecimal(0.29)) < 0){
			ExcOppg exc = new ExcOppg();
			exc.setName("波形特征量");
			exc.setValue(oppg.getK().doubleValue());
			exc.setResult("偏低");
			list.add(exc);
		}else if(oppg.getK().compareTo(new BigDecimal(0.46)) > 0){
			ExcOppg exc = new ExcOppg();
			exc.setName("波形特征量");
			exc.setValue(oppg.getK().doubleValue());
			exc.setResult("偏高");
			list.add(exc);
		}
		
		if(oppg.getV() == null){
			oppg.setV(BigDecimal.ZERO);
		}
		if(oppg.getV().compareTo(new BigDecimal(3)) < 0){
			ExcOppg exc = new ExcOppg();
			exc.setName("血液黏度");
			exc.setValue(oppg.getV().doubleValue());
			exc.setResult("偏低");
			list.add(exc);
		}else if(oppg.getV().compareTo(new BigDecimal(5.04)) > 0){
			ExcOppg exc = new ExcOppg();
			exc.setName("血液黏度");
			exc.setValue(oppg.getV().doubleValue());
			exc.setResult("偏高");
			list.add(exc);
		}
		
		if(oppg.getTpr() == null){
			oppg.setTpr(BigDecimal.ZERO);
		}
		if(oppg.getTpr().compareTo(new BigDecimal(750)) < 0){
			ExcOppg exc = new ExcOppg();
			exc.setName("外周阻力");
			exc.setValue(oppg.getTpr().doubleValue());
			exc.setResult("偏低");
			list.add(exc);
		}else if(oppg.getTpr().compareTo(new BigDecimal(1450)) > 0){
			ExcOppg exc = new ExcOppg();
			exc.setName("外周阻力");
			exc.setValue(oppg.getTpr().doubleValue());
			exc.setResult("偏高");
			list.add(exc);
		}
		
		if(oppg.getAc() == null){
			oppg.setAc(BigDecimal.ZERO);
		}
		if(oppg.getAc().compareTo(new BigDecimal(1.2)) < 0){
			ExcOppg exc = new ExcOppg();
			exc.setName("血管顺应度");
			exc.setValue(oppg.getAc().doubleValue());
			exc.setResult("偏低");
			list.add(exc);
		}else if(oppg.getAc().compareTo(new BigDecimal(3)) > 0){
			ExcOppg exc = new ExcOppg();
			exc.setName("血管顺应度");
			exc.setValue(oppg.getAc().doubleValue());
			exc.setResult("偏高");
			list.add(exc);
		}
		
		if(oppg.getPm() == null){
			oppg.setPm(BigDecimal.ZERO);
		}
		if(oppg.getPm().compareTo(new BigDecimal(70)) < 0){
			ExcOppg exc = new ExcOppg();
			exc.setName("平均动脉压");
			exc.setValue(oppg.getPm().doubleValue());
			exc.setResult("偏低");
			list.add(exc);
		}else if(oppg.getPm().compareTo(new BigDecimal(105)) > 0){
			ExcOppg exc = new ExcOppg();
			exc.setName("平均动脉压");
			exc.setValue(oppg.getPm().doubleValue());
			exc.setResult("偏高");
			list.add(exc);
		}
		
		if(oppg.getSi() == null){
			oppg.setSi(BigDecimal.ZERO);
		}
		if(oppg.getSi().compareTo(new BigDecimal(0)) < 0){
			ExcOppg exc = new ExcOppg();
			exc.setName("血管硬化指数");
			exc.setValue(oppg.getSi().doubleValue());
			list.add(exc);
		}else if(oppg.getSi().compareTo(new BigDecimal(8)) > 0){
			ExcOppg exc = new ExcOppg();
			exc.setName("血管硬化指数");
			exc.setValue(oppg.getSi().doubleValue());
			exc.setResult("偏高");
			list.add(exc);
		}
		return list;
    }
	
	/**
	 * @Title:getMeasureBySummaryReport 
	 * @Description:根据汇总报告获取器关联的单项报告的测量数据
	 * @author 谢美团
	 * @param summaryReport
	 * @return 
	 * @throws
	 * @retrun SummaryReport
	 */ 
	private SummaryReport getMeasureBySummaryReport(SummaryReport summaryReport){
		SummaryReportRelationExample example = new SummaryReportRelationExample();
		example.createCriteria().andIDEqualTo(summaryReport.getID());
		List<SummaryReportRelation>  smr2s = summaryReportRelationService.selectByExample(example);
		List<SingleReport> omrrs=new ArrayList<SingleReport>();
		for(SummaryReportRelation smr2:smr2s)
		{
			SingleReport omrr = singleReportService.selectById(smr2.getSingleID());
			omrr = getMeasureBySingleReport(omrr);
			omrrs.add(omrr);
		}
		summaryReport.setSingleReportList(omrrs);
		return summaryReport;
	}

	/**
	 * @Title:getEcg2ByOecg 
	 * @Description:根据心电数据获取该条心电的异常信息
	 * @author 谢美团
	 * @param oecg
	 * @return 
	 * @throws
	 * @retrun Oecg
	 */ 
	private Oecg getEcg2ByOecg(Oecg oecg){
		List<Ecg2> list = ecg2Service.selectEcg2ListByDocentry(oecg.getDocentry());
		for(Ecg2 ecg2:list){
			ecg2.setAbnCname(ElectrocardioType.getTypeChinaName(ecg2.getAbnname()));
		}
		oecg.setEcg2s(list);
		return oecg;
	};
	
	
	
	public Map<String, Object> getSingleAuditResult(List<SingleReportAudit> list, Integer docGrpCode) {

		Map<String,Object> map = new HashMap<String,Object>();
    	List<SingleReportAudit> smr1Commons = new ArrayList<SingleReportAudit>();// 同组医生审核结果
    	List<SingleReportAudit> smr1Others = new ArrayList<SingleReportAudit>();// 其他组医生审核结果
    	if(list != null && list.size() > 0){
    	  	Page<Doctor> page = new Page<Doctor>(1,20);
        	DoctorExample example = new DoctorExample();
        	List<Integer> docIdList = new ArrayList<Integer>();
        	List<Integer> docGrpCodeList = new ArrayList<Integer>();
        	for(SingleReportAudit audit:list){
        		docIdList.add(audit.getDocid());
        		docGrpCodeList.add(audit.getDocGrpCode());
        	}
        	example.createCriteria().andDocidIn(docIdList);
        	List<Doctor> doctorList = doctorService.selectByExampleAndPage(page, example);
        	DoctorGroupExample doctorGroupExample = new DoctorGroupExample();
        	doctorGroupExample.createCriteria().andOdgpidIn(docGrpCodeList);
        	List<DoctorGroup> doctorGroupList = doctorGroupService.selectByExample(doctorGroupExample);
        	for(SingleReportAudit audit:list){
        		for(Doctor doctor:doctorList){
        			if(doctor.getDocid().equals(audit.getDocid())){
        				audit.setDoctorName(doctor.getDocname());
        				audit.setSignaddress(doctor.getSignaddress());
        				break;
        			}
        		}
        		for(DoctorGroup doctorGroup:doctorGroupList){
        			if(doctorGroup.getOdgpid().equals(audit.getDocGrpCode())){
        				audit.setDocGrpName(doctorGroup.getOdgpname());
        			}
        		}
        		
/*        		if(audit.getDocGrpCode() != null && audit.getDocGrpCode().equals(docGrpCode)){
        			smr1Commons.add(audit);
        		}else{
        			smr1Others.add(audit);
        		}*/
        		smr1Commons.add(audit);
        	}	
    	}
    	map.put("smr1Commons", smr1Commons);
    	map.put("smr1Others", smr1Others);
		return map;
	}


	public Map<String, Object> calculOsbp(List<Osbp> osbps) throws Exception {
		Integer [] data1=new Integer[12];
		String dates[]=new String[6];
		SimpleDateFormat simple=new SimpleDateFormat("MM-dd HH:mm");
		int sumSbp=0;int sumDbp=0;int sumPluRate=0;int sumAvgOsbp=0;
		int maxSbp=0;int maxPluRate=0;int maxDbp=0;int maxAvgOsbp=0;
		int minSbp=1000;int minDbp=1000;int minPluRate=1000;int minAvgOsbp=1000;
		
		for(Osbp o:osbps){
			int avgOsbp = (o.getSbp() + o.getDbp() * 2) / 3;
			sumAvgOsbp+=avgOsbp;
			sumSbp+=o.getSbp();
			sumDbp+=o.getDbp();
			sumPluRate+=o.getPulserate();
			
			if(avgOsbp > maxAvgOsbp){
				
				maxAvgOsbp=avgOsbp;
			}
			
			if(o.getSbp()>maxSbp){
				
				maxSbp=o.getSbp();
				dates[0]=simple.format(o.getTesttime());
			}
			
			if(o.getDbp()>maxDbp){
				
				maxDbp=o.getDbp();
				dates[1]=simple.format(o.getTesttime());
			}
			
			if(o.getPulserate()>maxPluRate){
				
				maxPluRate=o.getPulserate();
				dates[2]=simple.format(o.getTesttime());
			}
			
			if(avgOsbp < minAvgOsbp){
				
				minAvgOsbp=avgOsbp;
			}
			
			if(o.getSbp()<minSbp){
				
				minSbp=o.getSbp();
				dates[3]=simple.format(o.getTesttime());
			}
			
			if(o.getDbp()<minDbp){
				
				minDbp=o.getDbp();
				dates[4]=simple.format(o.getTesttime());
			}
			
			if(o.getPulserate()<minPluRate){
				
				minPluRate=o.getPulserate();
				dates[5]=simple.format(o.getTesttime());
			}
		}
		data1[4]=maxSbp;
		data1[5]=maxDbp;
		data1[6]=maxAvgOsbp;
		data1[7]=maxPluRate;
		
		if(osbps.size() > 0){
			data1[0]=sumSbp/osbps.size();
			data1[1]=sumDbp/osbps.size();
			data1[2]=sumAvgOsbp/osbps.size();
			data1[3]=sumPluRate/osbps.size();
		}
		data1[8]=minSbp;
		data1[9]=minDbp;
		data1[10]=minAvgOsbp;
		data1[11]=minPluRate;
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("data1",data1);
		map.put("dates", dates);
		return map;
	}


	public Map<String, Object> calculOsbpDay(List<Osbp> osbps) throws Exception {
		Integer [] data2=new Integer[12];
		String dates[]=new String[6];
		SimpleDateFormat simple=new SimpleDateFormat("MM-dd HH:mm");
		int sumSbp=0;int sumDbp=0;int sumPluRate=0;int sumAvgOsbp=0;
		int maxSbp=0;int maxPluRate=0;int maxDbp=0;int maxAvgOsbp=0;
		int minSbp=1000;int minDbp=1000;int minPluRate=1000;int minAvgOsbp=1000;
		int count=0;
		for(Osbp o:osbps){
			int hours=o.getTesttime().getHours();
			//处理22:00:00是白天的情况
			if(hours == 22){
				SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
				String str = sdf.format(o.getTesttime());
				if(str.equals("22:00:00")){
					hours = hours - 1;
				}
			}
			if(hours>=8&&hours<22){
				count++;
				int avgOsbp = (o.getSbp() + o.getDbp() * 2) / 3;
				sumAvgOsbp+=avgOsbp;
				sumSbp+=o.getSbp();
				sumDbp+=o.getDbp();
				sumPluRate+=o.getPulserate();
				
				if(avgOsbp > maxAvgOsbp){
					
					maxAvgOsbp=avgOsbp;
				}
				
				if(o.getSbp()>maxSbp){
					
					maxSbp=o.getSbp();
					dates[0]=simple.format(o.getTesttime());
				}
				if(o.getDbp()>maxDbp){
					
					maxDbp=o.getDbp();
					dates[1]=simple.format(o.getTesttime());
				}
				
				if(o.getPulserate()>maxPluRate){
					
					maxPluRate=o.getPulserate();
					dates[2]=simple.format(o.getTesttime());
				}
				
				if(avgOsbp < minAvgOsbp){
					
					minAvgOsbp=avgOsbp;
				}
				
				if(o.getSbp()<minSbp){
					
					minSbp=o.getSbp();
					dates[3]=simple.format(o.getTesttime());
				}
				if(o.getDbp()<minDbp){
					
					minDbp=o.getDbp();
					dates[4]=simple.format(o.getTesttime());
				}
				if(o.getPulserate()<minPluRate){
					
					minPluRate=o.getPulserate();
					dates[5]=simple.format(o.getTesttime());
				}
			}
		}
		data2[4]=maxSbp;
		data2[5]=maxDbp;
		data2[6]=maxAvgOsbp;
		data2[7]=maxPluRate;
		
		if(count != 0){
			data2[0]=sumSbp/count;
			data2[1]=sumDbp/count;
			data2[2]=sumAvgOsbp/count;
			data2[3]=sumPluRate/count;
		}
		data2[8]=minSbp;
		data2[9]=minDbp;
		data2[10]=minAvgOsbp;
		data2[11]=minPluRate;
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("data2",data2);
		map.put("dates2", dates);
		return map;
	}


	public Map<String, Object> calculOsbpEvening(List<Osbp> osbps)throws Exception {

		Integer [] data3=new Integer[12];
		String dates[]=new String[6];
		SimpleDateFormat simple=new SimpleDateFormat("MM-dd HH:mm");
		int sumSbp=0;int sumDbp=0;int sumPluRate=0;int sumAvgOsbp=0;
		int maxSbp=0;int maxPluRate=0;int maxDbp=0;int maxAvgOsbp=0;
		int minSbp=1000;int minDbp=1000;int minPluRate=1000;int minAvgOsbp=1000;
		int count=0;
		for(Osbp o:osbps){
			int hours=o.getTesttime().getHours();
			//处理22:00:00是白天的时间情况
			if(hours == 22){
				SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
				String str = sdf.format(o.getTesttime());
				if(str.equals("22:00:00")){
					hours = hours - 1;
				}
			}
			if(hours>=8&&hours<22){
				continue;
			}
			
			count++;
			int avgOsbp = (o.getSbp() + o.getDbp() * 2) / 3;
			sumAvgOsbp+=avgOsbp;
			sumSbp+=o.getSbp();
			sumDbp+=o.getDbp();
			sumPluRate+=o.getPulserate();
			
			if(avgOsbp > maxAvgOsbp){
				
				maxAvgOsbp=avgOsbp;
			}
			
			if(o.getSbp()>maxSbp){
				
				maxSbp=o.getSbp();
				dates[0]=simple.format(o.getTesttime());
			}
			if(o.getDbp()>maxDbp){
				
				maxDbp=o.getDbp();
				dates[1]=simple.format(o.getTesttime());
			}
			
			if(o.getPulserate()>maxPluRate){
				
				maxPluRate=o.getPulserate();
				dates[2]=simple.format(o.getTesttime());
			}
			
			if(avgOsbp < minAvgOsbp){
				
				minAvgOsbp=avgOsbp;
			}
			
			if(o.getSbp()<minSbp){
				
				minSbp=o.getSbp();
				dates[3]=simple.format(o.getTesttime());
			}
			if(o.getDbp()<minDbp){
				
				minDbp=o.getDbp();
				dates[4]=simple.format(o.getTesttime());
			}
			if(o.getPulserate()<minPluRate){
				
				minPluRate=o.getPulserate();
				dates[5]=simple.format(o.getTesttime());
			}
			}
		
		data3[4]=maxSbp;
		data3[5]=maxDbp;
		data3[6]=maxAvgOsbp;
		data3[7]=maxPluRate;
		
		if(count != 0){
			data3[0]=sumSbp/count;
			data3[1]=sumDbp/count;
			data3[2]=sumAvgOsbp/count;
			data3[3]=sumPluRate/count;
		}
		
		data3[8]=minSbp;
		data3[9]=minDbp;
		data3[10]=minAvgOsbp;
		data3[11]=minPluRate;		

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("data3",data3);
		map.put("dates3", dates);
		return map;
	}


	public Map<String, Object> getRepStatist(Integer memberid) throws Exception {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		String [] strs=new String[3];
		Long [] reps=new Long [23];
			strs[0]=getYearMonth(2);
			strs[1]=getYearMonth(1);
			strs[2]=getYearMonth(0);
			
			reps[0]=getOptMeasRepCount(2, "1", memberid);
			reps[1]=getOptMeasRepCount(1, "1", memberid);
			reps[2]=getOptMeasRepCount(0, "1", memberid);
			reps[3]=reps[0]+reps[1]+reps[2];
			
			
			reps[4]=getOptMeasRepCount(2, "2", memberid);
			reps[5]=getOptMeasRepCount(1, "2", memberid);
			reps[6]=getOptMeasRepCount(0, "2", memberid);
			reps[7]=reps[4]+reps[5]+reps[6];
			
			reps[8]=getOptMeasRepCount(2, "3", memberid);
			reps[9]=getOptMeasRepCount(1, "3", memberid);
			reps[10]=getOptMeasRepCount(0, "3", memberid);
			reps[11]=reps[8]+reps[9]+reps[10];
			
			reps[12]=getOptMeasRepCount(2, "4", memberid);
			reps[13]=getOptMeasRepCount(1, "4", memberid);
			reps[14]=getOptMeasRepCount(0, "4", memberid);
			reps[15]=reps[12]+reps[13]+reps[14];
			
			reps[16]=getQuaiRepCount(2, memberid, "T");
			reps[17]=getQuaiRepCount(1, memberid, "T");
			reps[18]=getQuaiRepCount(0, memberid, "T");
			reps[19]=reps[16]+reps[17]+reps[18];
			resultMap.put("reps", reps);
			resultMap.put("strs", strs);
		return resultMap;
	}
	
	
	/**
	 * @Title:getOptMeasRepCount 
	 * @Description:获取会员指定选项一段时间内的测量报告数量
	 * @author 谢美团
	 * @param n
	 * @param optId
	 * @param memberid
	 * @return 
	 * @throws
	 * @retrun Long
	 * @throws Exception 
	 */ 
	public Long getOptMeasRepCount(int n,String optId,Integer memberid) throws Exception{
		Timestamp date1=TimeUtil.getYearAndMonth(n);
		Timestamp date2=TimeUtil.getYearAndMonth(n+1);
		List<String> statusList = new ArrayList<String>();
		statusList.add("2");
		statusList.add("3");
		SingleReportExample example = new SingleReportExample();
		example.createCriteria().andOptIdEqualTo(Short.parseShort(optId)).andMemberidEqualTo(memberid)
				.andReportStateIn(statusList).andGrenerTimeBetween(date2, date1);
		int count = singleReportService.countByExample(example);
		return (long)count;
	}
	
	
	/**
	 * @Title:countQustTag 
	 * @Description:根据会员及答卷状态来统计答卷
	 * @author 谢美团
	 * @param n
	 * @param memberid
	 * @param qustTag
	 * @return 
	 * @throws
	 * @retrun long
	 * @throws ParseException 
	 */ 
	public long getQuaiRepCount(int n, int memberid, String qustTag) throws ParseException{
		Timestamp date1=TimeUtil.getYearAndMonth(n);
		Timestamp date2=TimeUtil.getYearAndMonth(n+1);
		OuaiExample example = new OuaiExample();
		example.createCriteria().andMemberidEqualTo(memberid).andQustTagEqualTo(qustTag).andPublisherTimeBetween(date2, date1);
		int count = ouaiService.countByExample(example);
		return (long)count;
	}
	
	
	
	
	
	private  String  getYearMonth(int n){
		Calendar c=Calendar.getInstance();
		//获得系统当前日期 
		int year=c.get(Calendar.YEAR);
		int month=c.get(Calendar.MONTH)+1;
		if(month<=n){
			year-=1;
		}
		String s =year+"年"+(month-n)+"月";
		return s;
	}


	@Override
	public AuditProgress getAuditProgressByReportNoAndAuditeLevel(Integer reportNo,Short auditLevel) {
		AuditProgress auditProgress = new AuditProgress();
		AuditProgressExample auditExample = new AuditProgressExample();
		auditExample.createCriteria().andReportNoEqualTo(reportNo).andAuditLevelEqualTo(auditLevel);
		List<AuditProgress> auditList =	auditProgressService.selectByExample(auditExample);
		if(auditList != null && auditList.size() > 0 ){
			auditProgress = auditList.get(0);
		}else{
			auditProgress.setReportNo(reportNo);
			auditProgress.setAuditLevel((short)0);
		}
		return auditProgress;
	}


	@Override
	public Integer getLatestDoctorId(SummaryReport summaryReport) {
		List<SummaryReportAudit> sumRepAuditLis = summaryReport.getSumRepAuditList();
		List<SingleReport> singleReportsList = summaryReport.getSingleReportList();
		Integer docid = -1;
		if(sumRepAuditLis != null && sumRepAuditLis.size() > 0){
			SummaryReportAudit summaryReportAudit = null;
			if(sumRepAuditLis.size() == 1){
				summaryReportAudit = sumRepAuditLis.get(0);
			}else{
    			for(int i = 1;i<sumRepAuditLis.size();i++){
    				if(sumRepAuditLis.get(i).getAuditLevel() > sumRepAuditLis.get(i-1).getAuditLevel()){
    					summaryReportAudit = sumRepAuditLis.get(i);
    				}else{
    					summaryReportAudit = sumRepAuditLis.get(i-1);
    				}
    			}
			}
			if(summaryReportAudit != null){ //没有汇总报告审核结果
				docid = summaryReportAudit.getDocid();
			}else if(singleReportsList != null && singleReportsList.size() >0){ // 验证是否有单项报告审核结果
				SingleReportAudit singleReportAudit = new SingleReportAudit();
				
				if(singleReportsList.size() == 1){
					List<SingleReportAudit> singleAuditList =singleReportsList.get(0).getAuditList();
					if(singleAuditList != null && singleAuditList.size() ==1){
						singleReportAudit = singleReportsList.get(0).getAuditList().get(0);
					}else if(singleAuditList != null && singleAuditList.size() > 1){
						for(int i = 1;i<singleAuditList.size();i++){
							if(singleAuditList.get(i).getAuditLevel() > singleAuditList.get(i-1).getAuditLevel()){
								singleReportAudit = singleAuditList.get(i);
							}
						}
					}
				}else{
					for(int j = 0;j<singleReportsList.size();j++){
						SingleReportAudit tempAudit = new SingleReportAudit();
						List<SingleReportAudit> singleAuditList =singleReportsList.get(j).getAuditList();
						if(singleAuditList != null && singleAuditList.size() ==1){
							tempAudit = singleReportsList.get(0).getAuditList().get(0);
						}else if(singleAuditList != null && singleAuditList.size() > 1){
							for(int i = 1;i<singleAuditList.size();i++){
								if(singleAuditList.get(i).getAuditLevel() > singleAuditList.get(i-1).getAuditLevel()){
									tempAudit = singleAuditList.get(i);
								}
							}
						}
						if(singleReportAudit.getAuditLevel() ==null || singleReportAudit.getAuditLevel() < tempAudit.getAuditLevel()){
							singleReportAudit = tempAudit;
						}
					}
				}
				
				docid = singleReportAudit.getDocGrpCode();
			}
		}
		return docid;
	}


	@Override
	public boolean checkReadSingleReportAuthority(int odgpId ,int docId,int orgId,int optId,int auditLevel) {
		List<DocToGroup> list = null;
		if(odgpId != -1){
			DocToGroupExample example = new DocToGroupExample();
			example.createCriteria().andOdgpidEqualTo(odgpId).andDocidEqualTo(docId);
			list = doctorToGroupService.selectByExample(example);
		}else{
			list = doctorToGroupService.selectByOptAndLevel(docId, optId, auditLevel,orgId);
		}
		if(list != null && list.size() > 0){
			return true;
		}
		return false;
	}
	
    /**
     * @Title:getExportWordData 
     * @Description:word打印模板，数据封装map
     * @author 陈哲
     * @param reportNo
     * @param auditLevel
     * @return
     * @throws Exception 
     * @throws
     * @retrun Map<String,Object>
     */
    public Map<String, Object> getExportWordData(Integer reportNo,Short auditLevel) throws Exception{
		Map<String, Object> dataMap = new HashMap<String, Object>();
		//获取审核进度数据
		AuditProgress auditProgress = getAuditProgressByReportNoAndAuditeLevel(reportNo, auditLevel);
		Doctor doctor = doctorService.selectById(auditProgress.getDocid());
		//获取汇总报告数据
		SummaryReport  summaryReport = selectSummaryReportById(reportNo);
		SummaryTemplate  SummaryTemplate  = new SummaryTemplate ();
		if(summaryReport.getSumRepTempCode() != null){
			SummaryTemplate = summaryTemplateService.selectById(summaryReport.getSumRepTempCode());//获取报告关联的模板数据
		}
		dataMap.put("reportSumName", SummaryTemplate.getTempName() == null?"":SummaryTemplate.getTempName());
		List<SingleReport> singleReportsList = summaryReport.getSingleReportList();
		if(singleReportsList != null && singleReportsList.size() > 0 && singleReportsList.get(0).getMemberid() !=null){
			MemberExt  omem  = memberService.selectMemberExtById(singleReportsList.get(0).getMemberid());
			omem.setGender("M".equals(omem.getGender()) ? "男" : "女");
			dataMap.put("omem", omem);
			dataMap.put("age", TimeUtil.getAge(omem.getBirthdate()));
			dataMap.put("memberid", omem.getMemberid());
			dataMap.put("doctor", doctor);
			dataMap.put("oasr", auditProgress);
			dataMap.put("osmr", summaryReport);
			int count = 0;
	    	for(SingleReport sr : singleReportsList){
	    		SingleTemplate singleTemplate = singleTemplateService.selectById(sr.getTempCode());
	    		String subTempName = singleTemplate.getTempName();
	    		if(sr.getOptId() == 1){
	    			List<Osbp> osbps = sr.getOsbps();
	    			dataMap.putAll(wrapCalculOsbpData(osbps));
	    			dataMap.putAll(wrapCalculOsbpDayData(osbps));
	    			dataMap.putAll(wrapCalculOsbpEveningData(osbps));
	    			getMeasureOsbp(osbps, dataMap);
	    			
	    			dataMap.put("omrr_1", sr);//血压
	    			dataMap.put("osbps", osbps);
	    			dataMap.put("osbpsCount", osbps.size());
	    			dataMap.put("optId_1", sr.getOptId());
	    			dataMap.put("id_1", sr.getID());
	    			dataMap.put("subTempName_1", subTempName);
	    			count++;
	    			dataMap.put("osbpCount",count);
	    		}else if(sr.getOptId() == 2){
	    			List<Obsr> obsrs = sr.getObsrs();
	    			Map<String, Object> data = consTableData(obsrs);
	    			dataMap.put("minData", data.get("minData"));
	    			dataMap.put("maxData", data.get("maxData"));
	    			dataMap.put("avgData", data.get("avgData"));
	    			dataMap.put("exData", data.get("exData"));
	    			dataMap.put("data", data.get("data"));
	    			
	    			dataMap.put("maxObsr",getObsr(data.get("maxData"), true));
	    			dataMap.put("minObsr",getObsr(data.get("minData"), false));
	    			dataMap.put("avgObsr",getAvgObsr(data.get("data")));
	    			dataMap.put("exObsr",getExData((List<Map<String,Object>>)data.get("exData"), (List<Obsr>)data.get("data")));
	    			
	    			dataMap.put("omrr_2", sr);//血糖
	    			dataMap.put("osbrsCount", obsrs.size());
					dataMap.put("optId_2", sr.getOptId());
					dataMap.put("id_2", sr.getID());
					dataMap.put("subTempName_2", subTempName);
					count++;
	    			dataMap.put("obsrCount",count);
	    		}else if(sr.getOptId() == 3){
	    			List<Oppg> oppgs = sr.getOppgs();
	    			List<Oecg> oecgs = sr.getOecgs();
	    			
	    			Iterator<Oecg> its = oecgs.iterator();
	    			while(its.hasNext()){
	    				Oecg oecg = its.next();
	    				if(oecg.getStatustag() == null || oecg.getStatustag() < 2){
	    					its.remove();
	    				}
	    			}
	    			
	    			Iterator<Oppg> it = oppgs.iterator();
	    			while(it.hasNext()){
	    				Oppg oppg = it.next();
	    				if(oppg.getStatustag() == null || oppg.getStatustag() < 2){
	    					it.remove();
	    				}
	    			}
	    			
	    			if (oecgs != null && oecgs.size() > 0 && oppgs != null && oppgs.size() > 0) {
	    				Map<String, List<OecgExc>> map = new HashMap<String, List<OecgExc>>();
	    				List<OecgExc> oecgExcs = doElectrocardioReportData(oecgs, map);
	    				dataMap.put("ecg12s_tab3", oecgExcs);
	    				dataMap.put("ecg12s_3", JSONObject.toJSONString(map));
	    				
	    			}
	    			count++;
	    			dataMap.put("id_3", sr.getID());
	    			dataMap.put("optId_3", sr.getOptId());
	    			dataMap.put("omrr_3", sr);
	    			dataMap.put("subTempName_3", subTempName);
	    			dataMap.put("oecg3Count",count);
	    		}else{
	    			List<Oecg> oecgs = sr.getOecgs();
	    			Iterator<Oecg> its = oecgs.iterator();
	    			while(its.hasNext()){
	    				Oecg oecg = its.next();
	    				if(oecg.getStatustag() == null || oecg.getStatustag() < 2){
	    					its.remove();
	    				}
	    			}
	    			
	    			if (oecgs != null && oecgs.size() > 0) {
	    				Map<String, List<OecgExc>> map = new HashMap<String, List<OecgExc>>();
	    				List<OecgExc> oecgExcs = doElectrocardioReportData(oecgs, map);
	    				dataMap.put("ecg12s_tab4", oecgExcs);
	    				dataMap.put("ecg12s_3", JSONObject.toJSONString(map));
	    			}
	    			count++;
	    			dataMap.put("id_4", sr.getID());
	    			dataMap.put("optId_4", sr.getOptId());
	    			dataMap.put("omrr_4", sr);
	    			dataMap.put("subTempName_4", subTempName);
	    			dataMap.put("oecg4Count",count);
	    		}
	    	}    			
	    	dataMap.put("total",count);
	    	
	    	short lastDay = 0;
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date measTermTime = sdf.parse(sdf.format(singleReportsList.get(0).getMeasTermTime()));
			Date measTime = sdf.parse(sdf.format(singleReportsList.get(0).getMeasTime()));
			Calendar cal = Calendar.getInstance();    
	        cal.setTime(measTermTime);    
	        long time1 = cal.getTimeInMillis();                 
	        cal.setTime(measTime);    
	        long time2 = cal.getTimeInMillis();         
	        lastDay = (short) ((time1 - time2)/ (24 * 60 * 60 * 1000) + 1);
	        dataMap.put("lastDay",lastDay);  
		}
		
		dataMap.put("docid",getLatestDoctorId(summaryReport));
		return dataMap;
    }
    
    /**
         * @Title: send 
         * @Description: 打印模板，血压24小时数据封装map
         * @param  
         * @throws      
         * @retrun  
         *  @see com.bithealth.reportCore.facade.service.ReportIFService#wrapCalculOsbpData(java.util.List)
     */
    public Map<String, Object> wrapCalculOsbpData(List<Osbp> osbps) throws Exception{
    	Map<String, Object> dataMap = new HashMap<String, Object>();
    	Map<String, Object> map = calculOsbp(osbps);
    	Integer[] data1 = (Integer[])map.get("data1");
    	String[] dates = (String[])map.get("dates");

    	//将24小时数据用dataMap保存起来，供word模板使用
		//收缩压
		if(data1[0] == null || data1[0] == 0){
			dataMap.put("data1_0", "- (90-140)");
		}else{
			dataMap.put("data1_0", data1[0]+" (90-140)");
		}
		
		if(data1[4] == null || data1[4] == 0){
			if(dates[0] != null && dates[0] != ""){
				dataMap.put("data1_4", "- ("+dates[0]+")");
			}else{
				dataMap.put("data1_4", "-");
			}
		}else{
			if(dates[0] != null && dates[0] != ""){
				dataMap.put("data1_4", data1[4]+"("+dates[0]+")");
			}else{
				dataMap.put("data1_4", data1[4]);
			}
		}
		
		if(data1[8] == null || data1[8] == 0){
			if(dates[3] != null && dates[3] != ""){
				dataMap.put("data1_8", "- ("+dates[3]+")");
			}else{
				dataMap.put("data1_8", "-");
			}
		}else{
			if(dates[3] != null && dates[3] != ""){
				dataMap.put("data1_8", data1[8]+"("+dates[3]+")");
			}else{
				dataMap.put("data1_8", data1[8]);
			}
		}
		
		//舒张压
		if(data1[1] == null || data1[1] == 0){
			dataMap.put("data1_1", "- (60-90)");
		}else{
			dataMap.put("data1_1", data1[1]+" (60-90)");
		}
		
		if(data1[5] == null || data1[5] == 0){
			if(dates[1] != null && dates[1] != ""){
				dataMap.put("data1_5", "- ("+dates[1]+")");
			}else{
				dataMap.put("data1_5", "-");
			}
		}else{
			if(dates[1] != null && dates[1] != ""){
				dataMap.put("data1_5", data1[5]+"("+dates[1]+")");
			}else{
				dataMap.put("data1_5", data1[5]);
			}
		}
		
		if(data1[9] == null || data1[9] == 0){
			if(dates[4] != null && dates[4] != ""){
				dataMap.put("data1_9", "- ("+dates[4]+")");
			}else{
				dataMap.put("data1_9", "-");
			}
		}else{
			if(dates[4] != null && dates[4] != ""){
				dataMap.put("data1_9", data1[9]+"("+dates[4]+")");
			}else{
				dataMap.put("data1_9", data1[9]);
			}
		}
		
		//平均压
		if(data1[2] == null || data1[2] == 0){
			dataMap.put("data1_2", "-");
		}else{
			dataMap.put("data1_2", data1[2]);
		}
		
		if(data1[6] == null || data1[6] == 0){
			dataMap.put("data1_6", "-");	
		}else{
			dataMap.put("data1_6", data1[6]);
		}
		
		if(data1[10] == null || data1[10] == 0){
			dataMap.put("data1_10", "-");	
		}else{
			dataMap.put("data1_10", data1[10]);
		}

		//脉搏
		if(data1[3] == null || data1[3] == 0){
			dataMap.put("data1_3", "- (60-100)");
		}else{
			dataMap.put("data1_3", data1[3]+" (60-100)");
		}
				
		if(data1[7] == null || data1[7] == 0){
			if(dates[2] != null && dates[2] != ""){
				dataMap.put("data1_7", "- ("+dates[2]+")");
			}else{
				dataMap.put("data1_7", "-");
			}
		}else{
			if(dates[2] != null && dates[2] != ""){
				dataMap.put("data1_7", data1[7]+"("+dates[2]+")");
			}else{
				dataMap.put("data1_7", data1[7]);
			}
		}
				
		if(data1[11] == null || data1[11] == 0){
			if(dates[5] != null && dates[5] != ""){
				dataMap.put("data1_11", "- ("+dates[5]+")");
			}else{
				dataMap.put("data1_11", "-");
			}
		}else{
			if(dates[5] != null && dates[5] != ""){
				dataMap.put("data1_11", data1[11]+"("+dates[5]+")");
			}else{
				dataMap.put("data1_11", data1[11]);
			}
		}
		return dataMap;
    }
    
    /**
         * @Title: send 
         * @Description: 打印模板，血压白天数据封装map
         * @param  
         * @throws      
         * @retrun  
         *  @see com.bithealth.reportCore.facade.service.ReportIFService#wrapCalculOsbpDayData(java.util.List)
     */
    public Map<String, Object> wrapCalculOsbpDayData(List<Osbp> osbps) throws Exception{
    	Map<String, Object> dataMap = new HashMap<String, Object>();
    	Map<String, Object> map = calculOsbpDay(osbps);
    	Integer[] data2 = (Integer[])map.get("data2");
    	String[] dates = (String[])map.get("dates2");
    	//将白天血压数据保存在dataMap集合中，供word使用
		//收缩压
		if(data2[0] == null || data2[0] == 0){
			dataMap.put("data2_0", "- (90-140)");
		}else{
			dataMap.put("data2_0", data2[0]+" (90-140)");
		}
		
		if(data2[4] == null || data2[4] == 0){
			if(dates[0] != null && dates[0] != ""){
				dataMap.put("data2_4", "- ("+dates[0]+")");
			}else{
				dataMap.put("data2_4", "-");
			}
		}else{
			if(dates[0] != null && dates[0] != ""){
				dataMap.put("data2_4", data2[4]+"("+dates[0]+")");
			}else{
				dataMap.put("data2_4", data2[4]);
			}
		}
		
		if(data2[8] == null || data2[8] == 0){
			if(dates[3] != null && dates[3] != ""){
				dataMap.put("data2_8", "- ("+dates[3]+")");
			}else{
				dataMap.put("data2_8", "-");
			}
		}else{
			if(dates[3] != null && dates[3] != ""){
				dataMap.put("data2_8", data2[8]+"("+dates[3]+")");
			}else{
				dataMap.put("data2_8", data2[8]);
			}
		}
		
		//舒张压
		if(data2[1] == null || data2[1] == 0){
			dataMap.put("data2_1", "- (60-90)");
		}else{
			dataMap.put("data2_1", data2[1]+" (60-90)");
		}
		
		if(data2[5] == null || data2[5] == 0){
			if(dates[1] != null && dates[1] != ""){
				dataMap.put("data2_5", "- ("+dates[1]+")");
			}else{
				dataMap.put("data2_5", "-");
			}
		}else{
			if(dates[1] != null && dates[1] != ""){
				dataMap.put("data2_5", data2[5]+"("+dates[1]+")");
			}else{
				dataMap.put("data2_5", data2[5]);
			}
		}
		
		if(data2[9] == null || data2[9] == 0){
			if(dates[4] != null && dates[4] != ""){
				dataMap.put("data2_9", "- ("+dates[4]+")");
			}else{
				dataMap.put("data2_9", "-");
			}
		}else{
			if(dates[4] != null && dates[4] != ""){
				dataMap.put("data2_9", data2[9]+"("+dates[4]+")");
			}else{
				dataMap.put("data2_9", data2[9]);
			}
		}
		
		//平均压
		if(data2[2] == null || data2[2] == 0){
			dataMap.put("data2_2", "-");
		}else{
			dataMap.put("data2_2", data2[2]);
		}
		
		if(data2[6] == null || data2[6] == 0){
			dataMap.put("data2_6", "-");	
		}else{
			dataMap.put("data2_6", data2[6]);
		}
		
		if(data2[10] == null || data2[10] == 0){
			dataMap.put("data2_10", "-");	
		}else{
			dataMap.put("data2_10", data2[10]);
		}
		
		//脉搏			
		if(data2[3] == null || data2[3] == 0){
			dataMap.put("data2_3", "- (60-100)");
		}else{
			dataMap.put("data2_3", data2[3]+" (60-100)");
		}
				
		if(data2[7] == null || data2[7] == 0){
			if(dates[2] != null && dates[2] != ""){
				dataMap.put("data2_7", "- ("+dates[2]+")");
			}else{
				dataMap.put("data2_7", "-");
			}
		}else{
			if(dates[2] != null && dates[2] != ""){
				dataMap.put("data2_7", data2[7]+"("+dates[2]+")");
			}else{
				dataMap.put("data2_7", data2[7]);
			}
		}
				
		if(data2[11] == null || data2[11] == 0){
			if(dates[5] != null && dates[5] != ""){
				dataMap.put("data2_11", "- ("+dates[5]+")");
			}else{
				dataMap.put("data2_11", "-");
			}
		}else{
			if(dates[5] != null && dates[5] != ""){
				dataMap.put("data2_11", data2[11]+"("+dates[5]+")");
			}else{
				dataMap.put("data2_11", data2[11]);
			}
		}
    	return dataMap;
    }
    
    /**
         * @Title: send 
         * @Description: 打印模板，血压晚上数据封装map
         * @param  
         * @throws      
         * @retrun  
         *  @see com.bithealth.reportCore.facade.service.ReportIFService#wrapCalculOsbpEveningData(java.util.List)
     */
    public Map<String, Object> wrapCalculOsbpEveningData(List<Osbp> osbps) throws Exception{
    	Map<String, Object> dataMap = new HashMap<String, Object>();
    	Map<String, Object> map = calculOsbpEvening(osbps);
    	Integer[] data3 = (Integer[])map.get("data3");
    	String[] dates = (String[])map.get("dates3");
    	
    	//将在晚上的血压信息保存在dataMap中，供word使用
		//收缩压
		if(data3[0] == null || data3[0] == 0){
			dataMap.put("data3_0", "- (90-140)");
		}else{
			dataMap.put("data3_0", data3[0]+" (90-140)");
		}
		
		if(data3[4] == null || data3[4] == 0){
			if(dates[0] != null && dates[0] != ""){
				dataMap.put("data3_4", "- ("+dates[0]+")");
			}else{
				dataMap.put("data3_4", "-");
			}
		}else{
			if(dates[0] != null && dates[0] != ""){
				dataMap.put("data3_4", data3[4]+"("+dates[0]+")");
			}else{
				dataMap.put("data3_4", data3[4]);
			}
		}
		
		if(data3[8] == null || data3[8] == 0 || data3[8] == 1000){
			if(dates[3] != null && dates[3] != ""){
				dataMap.put("data3_8", "- ("+dates[3]+")");
			}else{
				dataMap.put("data3_8", "-");
			}
		}else{
			if(dates[3] != null && dates[3] != ""){
				dataMap.put("data3_8", data3[8]+"("+dates[3]+")");
			}else{
				dataMap.put("data3_8", data3[8]);
			}
		}
		
		//舒张压
		if(data3[1] == null || data3[1] == 0){
			dataMap.put("data3_1", "- (60-90)");
		}else{
			dataMap.put("data3_1", data3[1]+" (60-90)");
		}
		
		if(data3[5] == null || data3[5] == 0){
			if(dates[1] != null && dates[1] != ""){
				dataMap.put("data3_5", "- ("+dates[1]+")");
			}else{
				dataMap.put("data3_5", "-");
			}
		}else{
			if(dates[1] != null && dates[1] != ""){
				dataMap.put("data3_5", data3[5]+"("+dates[1]+")");
			}else{
				dataMap.put("data3_5", data3[5]);
			}
		}
		
		if(data3[9] == null || data3[9] == 0 || data3[9]==1000){
			if(dates[4] != null && dates[4] != ""){
				dataMap.put("data3_9", "- ("+dates[4]+")");
			}else{
				dataMap.put("data3_9", "-");
			}
		}else{
			if(dates[4] != null && dates[4] != ""){
				dataMap.put("data3_9", data3[9]+"("+dates[4]+")");
			}else{
				dataMap.put("data3_9", data3[9]);
			}
		}
		
		//平均压
		if(data3[2] == null || data3[2] == 0){
			dataMap.put("data3_2", "-");
		}else{
			dataMap.put("data3_2", data3[2]);
		}
		
		if(data3[6] == null || data3[6] == 0){
			dataMap.put("data3_6", "-");	
		}else{
			dataMap.put("data3_6", data3[6]);
		}
		
		if(data3[10] == null || data3[10] == 0 || data3[10] == 1000){
			dataMap.put("data3_10", "-");	
		}else{
			dataMap.put("data3_10", data3[10]);
		}
		
		//脉搏			
		if(data3[3] == null || data3[3] == 0){
			dataMap.put("data3_3", "- (60-100)");
		}else{
			dataMap.put("data3_3", data3[3]+" (60-100)");
		}
				
		if(data3[7] == null || data3[7] == 0){
			if(dates[2] != null && dates[2] != ""){
				dataMap.put("data3_7", "- ("+dates[2]+")");
			}else{
				dataMap.put("data3_7", "-");
			}
		}else{
			if(dates[2] != null && dates[2] != ""){
				dataMap.put("data3_7", data3[7]+"("+dates[2]+")");
			}else{
				dataMap.put("data3_7", data3[7]);
			}
		}
				
		if(data3[11] == null || data3[11] == 0 || data3[11]==1000){
			if(dates[5] != null && dates[5] != ""){
				dataMap.put("data3_11", "- ("+dates[5]+")");
			}else{
				dataMap.put("data3_11", "-");
			}
		}else{
			if(dates[5] != null && dates[5] != ""){
				dataMap.put("data3_11", data3[11]+"("+dates[5]+")");
			}else{
				dataMap.put("data3_11", data3[11]);
			}
		}
    	return dataMap;
    }
    
    /**
     * @Title:getMeasureOsbp 
     * @Description:打印模板，血压测量数据封装map
     * @author 陈哲
     * @param osbps
     * @param dataMap
     * @return 
     * @throws
     * @retrun Map<String,Object>
     */
    private Map<String, Object> getMeasureOsbp(List<Osbp> osbps, Map<String, Object> dataMap){
		List<Map<String, Object>> newsList = new ArrayList<Map<String, Object>>();
		for(Osbp osbp : osbps){
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("testTime", osbp.getTesttime());
			
			if("0".equals(osbp.getTimeperiod())){
				map.put("type", "其他");
			}else if("1".equals(osbp.getTimeperiod())){
				map.put("type", "起床后两小时");
			}else{
				map.put("type", "睡觉前");
			}
			
			map.put("blood", osbp.getSbp()+" / "+ osbp.getDbp());
			map.put("avgBlood", (osbp.getSbp() + osbp.getDbp()) / 2.0);
			map.put("pluse", osbp.getSbp() - osbp.getDbp());
			map.put("multi", osbp.getSbp() * osbp.getPulserate());
			map.put("pluseRate", osbp.getPulserate());
			newsList.add(map);
		}
		dataMap.put("newsList", newsList);
		dataMap.put("osbpCount", newsList.size());
		return dataMap;
	}
    
    /**
         * @Title: send 
         * @Description: 血糖数据封装map
         * @param  
         * @throws      
         * @retrun  
         *  @see com.bithealth.reportCore.facade.service.ReportIFService#consTableData(java.util.List)
     */
    public Map<String, Object> consTableData(List<Obsr> obsrs){
    	List<Obsr> minData = new ArrayList<Obsr>();
    	List<Obsr> maxData = new ArrayList<Obsr>();
    	List<Obsr> avgData = new ArrayList<Obsr>();
    	List<Map<String, Object>> exData = new ArrayList<Map<String, Object>>();
    	Map<String, Object> data = new HashMap<String, Object>();
    	Map<String, List<Obsr>> map = new HashMap<String, List<Obsr>>();
    	for(Iterator<Obsr> it = obsrs.iterator();it.hasNext();){
    		Obsr obsr = it.next();
    		if(map.get(obsr.getTimeperiod()) == null)
    			map.put(obsr.getTimeperiod(), new ArrayList<Obsr>());
    		map.get(obsr.getTimeperiod()).add(obsr);
    		obsr.setNv(obsr.getTimeperiod());
    	}
    	
    	Obsr mino, maxo;Double total;
    	for(Iterator<Entry<String, List<Obsr>>> it = map.entrySet().iterator(); it.hasNext();){
    		Entry<String, List<Obsr>> entry = it.next();
    		mino = null;maxo = null;total=0d;
    		Map<String, Object> exMap = new HashMap<String, Object>();
    		exMap.put("timePeriodName", BloodSugarTimeQType.getTimeQTypeName(Integer.valueOf(entry.getKey())));
    		exMap.put("tooLowTimes", 0);
    		exMap.put("tooHighTimes", 0);
    		for(Iterator<Obsr> itt = entry.getValue().iterator(); itt.hasNext();){
    			Obsr obsr = itt.next();
    			obsr.setTimeperiod(BloodSugarTimeQType.getTimeQTypeName(Integer.valueOf(obsr.getTimeperiod())));
    			total += obsr.getBsvalue();
    			if(mino == null){
    				mino = obsr;
    				maxo = obsr;
    			}else{
    				if(obsr.getBsvalue() > maxo.getBsvalue())//取最大值
    					maxo = obsr;
    				else if(obsr.getBsvalue() < mino.getBsvalue())//取最小值
    					mino = obsr;
    			}
    			//异常项
				if(obsr.getBsvalue() < obsr.getNv().getMin()){//小于次数
					exMap.put("tooLowTimes", ((int)exMap.get("tooLowTimes"))+1);
				}else if(obsr.getBsvalue() > obsr.getNv().getMax()){//大于次数
					exMap.put("tooHighTimes", ((int)exMap.get("tooHighTimes"))+1);
				}
    		}
    		
    		DecimalFormat df = new DecimalFormat("######0.00");
    		exMap.put("tooLowRate", df.format(Double.parseDouble(exMap.get("tooLowTimes").toString())/entry.getValue().size()*100));
    		exMap.put("tooHighRate", df.format(Double.parseDouble(exMap.get("tooHighTimes").toString())/entry.getValue().size()*100));
    		Obsr avgo = new Obsr();
    		avgo.setTimeperiod(BloodSugarTimeQType.getTimeQTypeName(Integer.valueOf(entry.getKey())));
    		avgo.setNv(entry.getKey());
    		avgo.setTesttime(null);
    		avgo.setBsvalue(Double.valueOf(df.format(total/entry.getValue().size())));
    		avgData.add(avgo);
    		minData.add(mino);
    		maxData.add(maxo);
    		exData.add(exMap);
    	}
    	data.put("minData", minData);
    	data.put("maxData", maxData);
    	data.put("avgData", avgData);
    	data.put("exData", exData);
    	data.put("data", obsrs);
    	return data;
    }
    
    /**
         * @Title: send 
         * @Description: 血糖异常数据封装map
         * @param  
         * @throws      
         * @retrun  
         *  @see com.bithealth.reportCore.facade.service.ReportIFService#getExData(java.lang.Object, java.util.List)
     */
	public Map<String, Object> getExData(Object object, List<Obsr> obsrs){
    	Map<String, Object> data = new HashMap<String, Object>();
    	if(object instanceof List){
    		List<Map<String, Object>> exData = (List<Map<String, Object>>)object;
    		int tooLowTimes = 0,tooHigthTimes = 0;
        	double tooLowRate = 0d, tooHightRate = 0d;
        	for(Iterator<Map<String, Object>> it = exData.iterator(); it.hasNext();){
        		Map<String, Object> map = it.next();
        		tooLowTimes += (int)map.get("tooLowTimes");
        		tooHigthTimes += (int)map.get("tooHighTimes");
        		tooLowRate += Double.parseDouble(map.get("tooLowRate").toString());
        		tooHightRate += Double.parseDouble(map.get("tooHighRate").toString());
        	}
        	data.put("tooLowTimes", tooLowTimes);
        	data.put("tooHighTimes", tooHigthTimes);
        	data.put("tooLowRate", tooLowTimes*100.0/ obsrs.size());
        	data.put("tooHighRate", tooHigthTimes*100.0/ obsrs.size());
    	}
    	return data;
    } 
	
	/**
	     * @Title: send 
	     * @Description: 获取血糖集合中最大值或最小值的血糖记录
	     * @param  
	     * @throws      
	     * @retrun  
	     *  @see com.bithealth.reportCore.facade.service.ReportIFService#getObsr(java.lang.Object, boolean)
	 */
    public Obsr getObsr(Object object, boolean maxOrMin){
    	Obsr obsr = null;
    	if(object instanceof List){
    		List<Obsr> obsrs = (List<Obsr>)object;
        	Obsr pojo;
        	for(Iterator<Obsr> it = obsrs.iterator(); it.hasNext();){
        		pojo = it.next();
        		if(obsr == null){
        			obsr = pojo;
        		}else{
        			if(maxOrMin){
        				if(obsr.getBsvalue() < pojo.getBsvalue())
        					obsr = pojo;
        			}else{
        				if(obsr.getBsvalue() > pojo.getBsvalue())
            				obsr = pojo;
        			}
        		}
        	}
    	}
    	return obsr;
    }
    
    /**
         * @Title: send 
         * @Description: 打印预览，获取血糖平均值
         * @param  
         * @throws      
         * @retrun  
         *  @see com.bithealth.reportCore.facade.service.ReportIFService#getAvgObsr(java.lang.Object)
     */
    public String getAvgObsr(Object object){
    	if(object instanceof List){
    		List<Obsr> obsrs = (List<Obsr>)object;
    		return getAvgObsrData(obsrs);
    	}
    	return "";
    }
    
    public String getAvgObsrData(List<Obsr> obsrs){
    	DecimalFormat df = new DecimalFormat("######0.00");
    	double avg = 0d;
    	Obsr pojo;
    	for(Iterator<Obsr> it = obsrs.iterator(); it.hasNext();){
    		pojo = it.next();
    		avg += pojo.getBsvalue();
    	}
    	avg = avg/obsrs.size();
    	return df.format(avg);
    }
    
    /**
         * @Title: send 
         * @Description: 处理异常心电数据
         * @param  
         * @throws      
         * @retrun  
         *  @see com.bithealth.reportCore.facade.service.ReportIFService#doElectrocardioReportData(java.util.List, java.util.Map)
     */
    public List<OecgExc> doElectrocardioReportData(List<Oecg> oecgs, Map<String, List<OecgExc>> map){
		List<OecgExc> oecgExc_tab = new ArrayList<OecgExc>();
		for(int k=0; k<oecgs.size();k++){
			Oecg oecg = oecgs.get(k);
			
			List<Ecg1> ecg1s = ecg1Service.selectEcg1ListByDocentry(oecg.getDocentry());
			List<Ecg2> ecg2s = ecg2Service.selectEcg2ListByDocentry(oecg.getDocentry());
			List<OecgExc> oecgExcs = electrocardioExcService.doElectrocardioExcInfo(ecg1s, ecg2s, oecg);
			
			List<OecgExc> oecgExcs1 = getOecgExcNewList(oecgExcs, oecg, map);
			
			for(OecgExc oecgExc : oecgExcs1){
				OecgExc oecgExc_tab1 = new OecgExc();
				
				oecgExc_tab1.setExpCname(oecgExc.getExpCname());
				oecgExc_tab1.setExpName(oecgExc.getExpName());
				
				if(oecgExc.getExtMss().size() == 1){
					String[] objectids = oecgExc.getObjectIds().get(0).split("'");
					int periodTime = electrocardioExcService.getElectrocardioExcTimeP(objectids[1], oecg);
					long endTime = oecgExc.getExtMss().get(0) + periodTime;
					
					Timestamp timestamp1 = new Timestamp(oecgExc.getExtMss().get(0));
					Timestamp timestamp2 = new Timestamp(endTime);
					oecgExc.setTimePoint1(timestamp1);
					oecgExc.setTimePoint2(timestamp2);
					
					oecgExc_tab.add(oecgExc);
				}else{
					List<Long> extMss_tab = new ArrayList<Long>();
					List<String> objectIds_tab = new ArrayList<String>();
					
					for(int i=0;i<oecgExc.getExtMss().size();i++){
						if(i==0){
							objectIds_tab.add(oecgExc.getObjectIds().get(i));
							extMss_tab.add(oecgExc.getExtMss().get(i));
							continue;
						}
						long time = oecgExc.getExtMss().get(i);
						String[] objectids = oecgExc.getObjectIds().get(i-1).split("'");
						String objectid = objectids[1];
						int periodTime = electrocardioExcService.getElectrocardioExcTimeP(objectid, oecg);
						long endTime = oecgExc.getExtMss().get(i-1) + periodTime;
						float minu = ((float)(time - endTime) / 1000 / 60);
						
						Integer intervalTime = Contrants.INTERVAL_TIME;
						
						if(minu < intervalTime){
							objectIds_tab.add(oecgExc.getObjectIds().get(i));
							extMss_tab.add(oecgExc.getExtMss().get(i));
						}else{
							oecgExc_tab1.setObjectIds(objectIds_tab);
							oecgExc_tab1.setExtMss(extMss_tab);
							
							Timestamp timestamp1 = new Timestamp(extMss_tab.get(0));
							Timestamp timestamp2 = new Timestamp(endTime);
							oecgExc_tab1.setTimePoint1(timestamp1);
							oecgExc_tab1.setTimePoint2(timestamp2);
							
							oecgExc_tab.add(oecgExc_tab1);
							
							oecgExc_tab1 = new OecgExc();
							oecgExc_tab1.setExpCname(oecgExc.getExpCname());
							oecgExc_tab1.setExpName(oecgExc.getExpName());
							
							extMss_tab = new ArrayList<Long>();
							objectIds_tab = new ArrayList<String>();
							
							objectIds_tab.add(oecgExc.getObjectIds().get(i));
							extMss_tab.add(oecgExc.getExtMss().get(i));
						}
						
						if(i==oecgExc.getExtMss().size()-1){
							oecgExc_tab1.setObjectIds(objectIds_tab);
							oecgExc_tab1.setExtMss(extMss_tab);
							
							String[] objectids1 = oecgExc.getObjectIds().get(i).split("'");
							
							int periodTime1 = electrocardioExcService.getElectrocardioExcTimeP(objectids1[1], oecg);
							long endTime1 = oecgExc.getExtMss().get(i) + periodTime1;
							
							Timestamp timestamp1 = new Timestamp(extMss_tab.get(0));
							Timestamp timestamp2 = new Timestamp(endTime1);
							oecgExc_tab1.setTimePoint1(timestamp1);
							oecgExc_tab1.setTimePoint2(timestamp2);
							
							oecgExc_tab.add(oecgExc_tab1);
						}
					}
				}
			}
		}
    	return oecgExc_tab;
    }
    
    /**
     * @Title:getOecgExcNewList 
     * @Description:打印模板，异常心电数据封装
     * @author 陈哲
     * @param oecgExcs
     * @param oecg
     * @param map
     * @return 
     * @throws
     * @retrun List<OecgExc>
     */
    private List<OecgExc> getOecgExcNewList(List<OecgExc> oecgExcs, Oecg oecg, Map<String, List<OecgExc>> map){
    	List<OecgExc> oecgExcList = new ArrayList<OecgExc>();
		for(OecgExc oecgExc : oecgExcs){
			if(oecgExc.getExpNum() != 0){
				oecgExc.setDocentry(oecg.getDocentry());
				oecgExcList.add(oecgExc);
				if(!map.containsKey(oecgExc.getExpCname())){
					map.put(oecgExc.getExpCname(), new ArrayList<OecgExc>());
				}
				map.get(oecgExc.getExpCname()).add(oecgExc);
			}
		}
    	return oecgExcList;
    }


	@Override
	public boolean saveSingleAuditContent_trans(AuditProgress oasr, String myAdvice,String auditMode, String approvalReason) {
		short pendingLevel=(short) (oasr.getAuditLevel()-1);
		if(oasr.getAuditLevel()==1){
			pendingLevel=1;
		}
		if(approvalReason!=null){ //退审流程
			String tableName ="oasr_"+oasr.getSerialNumber()%100;
			auditProgressService.updateByReportNoAndSerialNumber(tableName, oasr.getDocid(), oasr.getReportNo(), oasr.getSerialNumber(),"N",null);
			//更新审核进度表
			AuditProgressExample example = new AuditProgressExample();
			example.createCriteria().andReportNoEqualTo(oasr.getReportNo()).andAuditLevelEqualTo(pendingLevel).andDocGrpCodeEqualTo(oasr.getDocGrpCode());
			AuditProgress auditParam = new AuditProgress();
			auditParam.setAuditState("N");
			auditParam.setAuditDatetime(new Date());
			auditProgressService.updateByExampleSelective(auditParam, example);
			//更新单项报告表
			SingleReport  singleParam  = new SingleReport();
			singleParam.setID(oasr.getReportNo());
			singleParam.setRetrialBackTag("Y");
			singleParam.setApprovalReason(approvalReason);
			singleParam.setPendingLevel(pendingLevel);
			singleReportService.update(singleParam);
			
			//删除之前的审核记录
			SingleReportAuditExample singleReportAuditExample = new SingleReportAuditExample();
			singleReportAuditExample.createCriteria().andIDEqualTo(oasr.getReportNo()).andDocGrpCodeEqualTo(oasr.getDocGrpCode()).andAuditLevelEqualTo(pendingLevel);
			singleReportAuditService.deleteByExample(singleReportAuditExample);
			return true;
		}
		
		if("Y".equals(oasr.getSubmitOther())){ //提交其他组审核流程
			SingleReport singleParam  = new SingleReport();
			singleParam.setID(oasr.getReportNo());
			singleParam.setReportState("1");;
			singleReportService.update(singleParam);
			//调用pro_OtherinsOASR存储过程
			auditProgressService.exProc_pro_OtherinsOASR(oasr);
		}
		
		
		// 以单项模板最大审核级别为准
		AuditProgressExample example2 = new AuditProgressExample();
		example2.setOrderByClause("AuditLevel desc");
		example2.createCriteria().andOptIdLessThan((short)5).andReportNoEqualTo(oasr.getReportNo());
		Page<AuditProgress> page2 = new Page<AuditProgress>(1,2);
		List<AuditProgress>  auditList = auditProgressService.selectByExampleAndPage(page2, example2);
		int CHLevel = 0;
		if(auditList != null && auditList.size()> 0){
			CHLevel = auditList.get(0).getAuditLevel();
		}
		
		if(oasr.getAuditLevel()==CHLevel){
			String tableName ="oasr_"+oasr.getSerialNumber()%100;
			auditProgressService.updateByReportNoAndSerialNumber(tableName, oasr.getDocid(), oasr.getReportNo(), oasr.getSerialNumber(),"Y","Y");
			//更新单项报告表
			SingleReport  singleParam  = new SingleReport();
			singleParam.setID(oasr.getReportNo());
			singleParam.setReportState("2");
			singleParam.setChkDesc(myAdvice);
			singleParam.setPendingLevel((short)0);
			singleReportService.update(singleParam);
			//插入审核明细
			SingleReportAudit singleReportAudit = new SingleReportAudit();
			singleReportAudit.setID(oasr.getReportNo());
			singleReportAudit.setDocGrpCode(oasr.getDocGrpCode());
			singleReportAudit.setAuditLevel(oasr.getAuditLevel());
			singleReportAudit.setDocid(oasr.getDocid());
			singleReportAudit.setAuditDesc(myAdvice);
			singleReportAudit.setAuditTime(new Date());
			singleReportAudit.setAuditMode(auditMode);
			singleReportAuditService.insert(singleReportAudit);
			
			//调用pro_updOASR存储过程
			auditProgressService.exProc_pro_updOASR(oasr.getReportNo());
		}else{
			//更新单项报告表
			SingleReport  singleParam  = new SingleReport();
			singleParam.setID(oasr.getReportNo());
			singleParam.setChkDesc(myAdvice);
			singleParam.setPendingLevel(pendingLevel);
			singleReportService.update(singleParam);
			//插入审核明细
			SingleReportAudit singleReportAudit = new SingleReportAudit();
			singleReportAudit.setID(oasr.getReportNo());
			singleReportAudit.setDocGrpCode(oasr.getDocGrpCode());
			singleReportAudit.setAuditLevel(oasr.getAuditLevel());
			singleReportAudit.setDocid(oasr.getDocid());
			singleReportAudit.setAuditDesc(myAdvice);
			singleReportAudit.setAuditTime(new Date());
			singleReportAudit.setAuditMode(auditMode);
			singleReportAuditService.insert(singleReportAudit);
			
			String tableName ="oasr_"+oasr.getSerialNumber()%100;
			auditProgressService.updateByReportNoAndSerialNumber(tableName, oasr.getDocid(), oasr.getReportNo(), oasr.getSerialNumber(),"Y",null);
		}
		return true;
	}
	
}



