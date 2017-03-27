package com.bithealth.report;


import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import sun.misc.BASE64Encoder;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bithealth.doctorCore.docGroup.model.DocToGroup;
import com.bithealth.doctorCore.doctor.model.Doctor;
import com.bithealth.doctorCore.doctor.service.DoctorService;
import com.bithealth.measureCore.bloodPressure.model.Osbp;
import com.bithealth.measureCore.bloodSugar.model.Obsr;
import com.bithealth.measureCore.common.model.ImageParam;
import com.bithealth.measureCore.electrocardio.model.Ecg1;
import com.bithealth.measureCore.electrocardio.model.Ecg2;
import com.bithealth.measureCore.electrocardio.model.Oecg;
import com.bithealth.measureCore.electrocardio.model.OecgExc;
import com.bithealth.measureCore.electrocardio.service.Ecg1Service;
import com.bithealth.measureCore.electrocardio.service.Ecg2Service;
import com.bithealth.measureCore.electrocardio.service.ElectrocardioExcService;
import com.bithealth.measureCore.electrocardio.service.ElectrocardioFileService;
import com.bithealth.measureCore.electrocardio.service.ElectrocardioService;
import com.bithealth.measureCore.electrocardioPulse.model.Oppg;
import com.bithealth.measureCore.electrocardioPulse.service.PulseService;
import com.bithealth.measureCore.enmu.BloodSugarTimeQType;
import com.bithealth.memberCore.member.model.MemberExt;
import com.bithealth.memberCore.member.service.MemberService;
import com.bithealth.printCore.service.ExportWordService;
import com.bithealth.reportCore.facade.constants.Contrants;
import com.bithealth.reportCore.facade.enmu.FunctionEnmu;
import com.bithealth.reportCore.facade.model.AuditProgressParam;
import com.bithealth.reportCore.facade.service.ReportIFService;
import com.bithealth.reportCore.report.model.AuditProgress;
import com.bithealth.reportCore.report.model.AuditProgressExample;
import com.bithealth.reportCore.report.model.SingleReport;
import com.bithealth.reportCore.report.model.SummaryReport;
import com.bithealth.reportCore.report.service.AuditProgressService;
import com.bithealth.reportCore.report.service.SummaryReportService;
import com.bithealth.reportCore.template.model.SingleTemplate;
import com.bithealth.reportCore.template.model.SummaryTemplate;
import com.bithealth.reportCore.template.service.SingleTemplateService;
import com.bithealth.reportCore.template.service.SummaryTemplateService;
import com.bithealth.sdk.common.utils.TimeUtil;
import com.bithealth.sdk.core.feature.orm.mybatis.Page;
import com.bithealth.sdk.web.controller.BaseSpringController;
import com.bithealth.sdk.web.vo.ShiroUser;



/**
 * 类名称: SummaryReportController  
 * 功能描述: 汇总报告控制器 
 * 日期: 2016年7月23日 上午11:04:09 
 * 
 * @author 谢美团
 * @version  
 */
@Controller
@RequestMapping(value = "/summaryReport")
public class SummaryReportController extends BaseSpringController {

    @Resource
    private ReportIFService reportIFService;
    @Resource
    private AuditProgressService  auditProgressService;
    @Resource
    private SummaryTemplateService summaryTemplateService;
    @Resource
    SummaryReportService summaryReportService;
    @Resource
    SingleTemplateService singleTemplateService;
    @Resource
    Ecg1Service ecg1Service;
    @Resource
    Ecg2Service ecg2Service;
    @Resource
    ElectrocardioExcService electrocardioExcService;
    @Resource
    MemberService memberService;
    @Resource
    DoctorService doctorService;
    @Resource
    PulseService pulseService;
    @Resource
    ElectrocardioService electrocardioService;
    @Resource
    ElectrocardioFileService electrocardioFileService;
    @Resource
    ExportWordService exportWordService;

    
    private static Logger logger=Logger.getLogger(SummaryReportController.class);
    

   
    /**
     * @Title:showSumAduitList 
     * @Description:获取  待审核报告  列表并跳转到该列表页面
     * @author 谢美团
     * @param model
     * @param request
     * @param page
     * @return 
     * @throws
     * @retrun String
     */ 
    @RequestMapping(value = "/showSumAduitList")
    public String showSumAduitList(ModelMap model,HttpServletRequest request,Page<AuditProgress> page) {
    	try{
    		page = new Page<AuditProgress>(page.getPageNo(),page.getPageSize());
        	ShiroUser shiroUser =(ShiroUser)request.getSession().getAttribute("userInfo");
        	//调用分页查询方法后从 page 对象中获取结果
        	reportIFService.selectAuditProgressReportByDocIdAndFunID(page,String.valueOf(shiroUser.getId()), 2);
        	model.put("count", page.getTotalCount());
        	model.put("auditProgressList", page.getResult());
        	model.put("page", page);
        	return "/report/audit/sumPendingAuditReport";
    	}catch(Exception e){
    		logger.error("获取待审核报告 列表并跳转到该列表页面异常。"+e);
    		model.put("code", "8888");
    		model.put("err_msg", "系统发生异常。");
    		return "/notice";
    	}

    }
    
    
    /**
     * @Title:showSumReportList 
     * @Description:获取  已审核报告   列表并跳转到该列表页面
     * @author 谢美团
     * @param model
     * @param request
     * @param page
     * @return 
     * @throws
     * @retrun String
     */ 
    @RequestMapping(value = "/showSumReportList")
    public String showSumReportList(ModelMap model,HttpServletRequest request,Page<SummaryReport> page) {
    	page = new Page<SummaryReport>(page.getPageNo(),page.getPageSize());
    	ShiroUser shiroUser =(ShiroUser)request.getSession().getAttribute("userInfo");
    	//调用分页查询方法后从 page 对象中获取结果
    	summaryReportService.selectByDocIdAndOrgid(page, shiroUser.getId(), shiroUser.getDept_id());
    	
    	model.put("count", page.getTotalCount());
    	model.put("funId", FunctionEnmu.SUMMARY_MEASURE.getValue());
    	model.put("page", page);
    	return "/report/audit/sumReportList";
    }
    
    
    
    
    
    
    
    /**
     * @Title:toReportAuditPage 
     * @Description:跳转到审核页面
     * @author 谢美团
     * @param model
     * @param request
     * @param serialNumber
     * @param reportNo
     * @return 
     * @throws
     * @retrun String
     */ 
    @RequestMapping(value = "/toReportAuditPage")
    public String toReportAuditPage(ModelMap model,HttpServletRequest request,String serialNumber,String reportNo,String auditLevel,String sourceType) {
    	ShiroUser shiroUser =(ShiroUser)request.getSession().getAttribute("userInfo");
    	if(shiroUser == null){
       		model.put("err_msg", "session过期，请重新登录");
    		return "/notice";
    	}
    	AuditProgress auditProgress  = new AuditProgress();
    	//获取审核进度相关明细
    	if( serialNumber!= null){ //从待审列表页面审核按钮 跳转过来
    		auditProgress = auditProgressService.selectById(Long.parseLong(serialNumber.trim())) ;
        	//验证该医生是否有该表报告的查看审核权限
        	DocToGroup docToGroup = new DocToGroup ();
        	docToGroup.setAuditlevel(auditProgress.getAuditLevel()==0?1:auditProgress.getAuditLevel());
        	docToGroup.setDocid(shiroUser.getId());
        	docToGroup.setOrgid(shiroUser.getDept_id());
        	docToGroup.setOdgpid(auditProgress.getDocGrpCode());
        	boolean result = reportIFService.checkReadSumReportAuthority(docToGroup);
        	if(!result){//没有权限
        		model.put("err_msg", "您权限不足于查看该条报告");
        		return "/notice";
        	}
    	}else{ // 从已审核的列表页面查看按钮跳转而来
    		AuditProgressExample example = new AuditProgressExample();
    		Short tempAuditLevel = 1;
    		if(auditLevel != null && !auditLevel.equals("") && !auditLevel.equals("0")){
    			tempAuditLevel= Short.parseShort(auditLevel);
    		}
    		example.createCriteria().andOptIdEqualTo((short)5).andReportNoEqualTo(Integer.parseInt(reportNo)).andAuditLevelEqualTo(tempAuditLevel);
    		List<AuditProgress> list = auditProgressService.selectByExample(example);
    		if(list != null && list.size() > 0){
    			auditProgress = list.get(0);
    		}
    	}

    	//根据报告id获取汇总报告及其明细等
    	SummaryReport  summaryReport  = reportIFService.selectSummaryReportById(Integer.parseInt(reportNo));
    	Map<String,Object> map = new HashMap<String,Object>();
    	if(auditProgress.getReportNo() != null && reportNo.equals(auditProgress.getReportNo().toString())){
	    	//获取报告关联的汇总模板
	    	SummaryTemplate summaryTemplate  = summaryTemplateService.selectById(summaryReport.getSumRepTempCode());
	    	if("Y".equals(summaryTemplate.getChTag())){//判断该模板下的报告是否需要审核
				//当前医生是否为最后审核对应的医生
				if("Y".equals(auditProgress.getYNTag())&& shiroUser.getId().equals(auditProgress.getDocid()) && auditProgress.getAuditDatetime() != null){
					//审核时间与当前时间相隔时间小于30分钟，可以做重新审核操作
					if(((new Timestamp(System.currentTimeMillis()).getTime() - auditProgress.getAuditDatetime().getTime()) / (1000*60)) < 30){
						model.put("isReAudit", "Y");
					}
				}
	    	}
	    	// 判断医生是否有当前阶段的审核权限  
	    	if(!reportIFService.isAuditEdit(shiroUser.getId(), auditProgress.getOptId(), summaryReport.getPendingLevel(),summaryReport.getReportState())){
	    		model.put("isAudit", "N");
	    	}
	    	map = reportIFService.getSummaryAuditResult(summaryReport.getSumRepAuditList(), auditProgress.getDocGrpCode());
    	}else{
    		auditProgress = new AuditProgress();
    		auditProgress.setReportNo(Integer.parseInt(reportNo));
    		auditProgress.setAuditLevel((short)0);
			model.put("isAudit", "N");// 是否为审核操作标志
    	}
    	model.put("auditProgress", auditProgress);
    	model.put("summaryReport", summaryReport);
    	model.put("smr1Commons", map.get("smr1Commons"));
    	model.put("smr1Others", map.get("smr1Others"));
    	model.put("sourceType", sourceType);
    	return "/report/audit/sumReportAduitPage";
    }
    
  
 
    /**
     * @Title:saveReportAudit 
     * @Description:批量或者单个保存审核的内容  
     * @author 谢美团
     * @param model
     * @param auditProgressParam
     * @return 
     * @throws
     * @retrun String
     */ 
    @RequestMapping(value = "/saveReportAudit")
    public String saveReportAudit(ModelMap model,AuditProgressParam auditProgressParam,HttpServletRequest request,String sourceType,String memberid) {
    	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
    	if("memSumRep".equals(sourceType)){
    		model.put("URL", basePath+"/summaryReport/toMemSumReportPage?memberid="+memberid);
    	}else{
    		model.put("URL", basePath+"/summaryReport/showSumAduitList");
    	}
    	
    	try{
        	if(auditProgressParam.getIds() != null){ //批量审核
        		String[] ids = auditProgressParam.getIds().split(",");
        		for(String id:ids){
        			auditProgressParam.setAuditMode("1");//0：人工审核，1：批量审核
        			auditProgressParam.setSerialNumber(Long.parseLong(id));
        			reportIFService.saveReportAudit(auditProgressParam);
        		}
        	}else{  //人工审核
        		auditProgressParam.setAuditMode("0");//0：人工审核，1：批量审核
        		reportIFService.saveReportAudit(auditProgressParam);
        	}
        	model.put("code", "0000");
    		model.put("err_msg", "审核成功!");
    		return "/notice";
    	}catch(Exception e){
    		e.printStackTrace();
    		model.put("code", "9999");
    		model.put("err_msg", "业务执行异常");
    		return "/notice";
    	}
    }
    
    
    @ResponseBody
    @RequestMapping(value = "/checkSumRepAudit")
    public Map<String,Object> checkSumRepAudit(HttpServletRequest request,String docentry){
    	Map<String,Object> resultMap  =  new HashMap<String,Object>();
    	try{
    	   	ShiroUser shiroUser =(ShiroUser)request.getSession().getAttribute("userInfo");
        	String result = reportIFService.checkSumRepAudit(shiroUser.getId(), shiroUser.getDept_id(), Integer.parseInt(docentry));
        	resultMap.put("ret", result);
    	}catch(Exception e){
    		resultMap.put("ret", "");
    		logger.error("检查汇总报告审核异常。"+e);
    	}
    	return resultMap;
    }
    
    /**
     * @Title:toExportPreview 
     * @Description:打印预览页面数据
     * @author 陈哲
     * @param model
     * @param reportNo
     * @param auditLevel
     * @return
     * @throws Exception 
     * @throws
     * @retrun String
     */
    @RequestMapping(value = "/toExportPreview")
    public String toExportPreview(ModelMap model,Integer reportNo,Short auditLevel) throws Exception{
    	try{
    		//获取审核进度数据
    		AuditProgress auditProgress = reportIFService.getAuditProgressByReportNoAndAuditeLevel(reportNo, auditLevel);
    		Doctor doctor = doctorService.selectById(auditProgress.getDocid());
    		//获取汇总报告数据
    		SummaryReport  summaryReport = reportIFService.selectSummaryReportById(reportNo);
    		SummaryTemplate  SummaryTemplate  = new SummaryTemplate ();
    		if(summaryReport.getSumRepTempCode() != null){
    			SummaryTemplate = summaryTemplateService.selectById(summaryReport.getSumRepTempCode());//获取报告关联的模板数据
    		}
    		model.put("reportSumName", SummaryTemplate.getTempName() == null?"":SummaryTemplate.getTempName());
    		List<SingleReport> singleReportsList = summaryReport.getSingleReportList();
    		if(singleReportsList != null && singleReportsList.size() > 0 && singleReportsList.get(0).getMemberid() !=null){
    			MemberExt  omem  = memberService.selectMemberExtById(singleReportsList.get(0).getMemberid());
    			omem.setGender("M".equals(omem.getGender()) ? "男" : "女");
    			model.put("omem", omem);
    			model.put("age", TimeUtil.getAge(omem.getBirthdate()));
    			model.put("memberid", omem.getMemberid());
    			model.put("doctor", doctor);
    			model.put("oasr", auditProgress);
    			model.put("osmr", summaryReport);
    			int count = 0;
    	    	for(SingleReport sr : singleReportsList){
    	    		SingleTemplate singleTemplate = singleTemplateService.selectById(sr.getTempCode());
    	    		String subTempName = singleTemplate.getTempName();
    	    		if(sr.getOptId() == 1){
    	    			List<Osbp> osbps = sr.getOsbps();
    	    			Map<String, Object> allDay = reportIFService.calculOsbp(osbps);
    	    			Map<String, Object> day = reportIFService.calculOsbpDay(osbps);
    	    			Map<String, Object> evening = reportIFService.calculOsbpEvening(osbps);
    	    			model.addAttribute("data1", allDay.get("data1"));
    	    			model.addAttribute("dates", allDay.get("dates"));
    	    			
    	    			model.addAttribute("data2", day.get("data2"));
    	    			model.addAttribute("dates2", day.get("dates2"));
    	    			
    	    			model.addAttribute("data3", evening.get("data3"));
    	    			model.addAttribute("dates3", evening.get("dates3"));
    	    			
    	    			model.addAttribute("omrr_1", sr);//血压
    	    			model.addAttribute("osbps", osbps);
    	    			model.addAttribute("osbpsCount", osbps.size());
    	    			model.addAttribute("optId_1", sr.getOptId());
    	    			model.addAttribute("id_1", sr.getID());
    	    			model.addAttribute("subTempName_1", subTempName);
    	    			count++;
    	    			model.addAttribute("osbpCount",count);
    	    		}else if(sr.getOptId() == 2){
    	    			List<Obsr> obsrs = sr.getObsrs();
    	    			Map<String, Object> data = reportIFService.consTableData(obsrs);
    	    			model.addAttribute("minData", data.get("minData"));
    	    			model.addAttribute("maxData", data.get("maxData"));
    	    			model.addAttribute("avgData", data.get("avgData"));
    	    			model.addAttribute("exData", data.get("exData"));
    	    			model.addAttribute("data", data.get("data"));
    	    			
    	    			model.addAttribute("maxObsr",produceHtml(reportIFService.getObsr(data.get("maxData"), true), "最大血糖值"));
    	    			model.addAttribute("minObsr",produceHtml(reportIFService.getObsr(data.get("minData"), false), "最小血糖值"));
    	    			model.addAttribute("avgObsr",reportIFService.getAvgObsr(data.get("data")));
    	    			model.addAttribute("exObsr",getEx((List<Map<String,Object>>)data.get("exData"), (List<Obsr>)data.get("data")));
    	    			
    	    			model.addAttribute("omrr_2", sr);//血糖
    	    			model.addAttribute("osbrsCount", obsrs.size());
    					model.addAttribute("optId_2", sr.getOptId());
    					model.addAttribute("id_2", sr.getID());
    					model.addAttribute("subTempName_2", subTempName);
    					count++;
    	    			model.addAttribute("obsrCount",count);
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
    	    				List<OecgExc> oecgExcs = reportIFService.doElectrocardioReportData(oecgs, map);
    	    				model.addAttribute("ecg12s_tab3", oecgExcs);
    	    				model.addAttribute("ecg12s_3", JSONObject.toJSONString(map));
    	    				
    	    			}
    	    			count++;
    	    			model.addAttribute("id_3", sr.getID());
    	    			model.addAttribute("optId_3", sr.getOptId());
    	    			model.addAttribute("omrr_3", sr);
    	    			model.addAttribute("subTempName_3", subTempName);
    	    			model.addAttribute("oecg3Count",count);
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
    	    				List<OecgExc> oecgExcs = reportIFService.doElectrocardioReportData(oecgs, map);
    	    				model.addAttribute("ecg12s_tab4", oecgExcs);
    	    				model.addAttribute("ecg12s_4", JSONObject.toJSONString(map));
    	    			}
    	    			count++;
    	    			model.addAttribute("id_4", sr.getID());
    	    			model.addAttribute("optId_4", sr.getOptId());
    	    			model.addAttribute("omrr_4", sr);
    	    			model.addAttribute("subTempName_4", subTempName);
    	    			model.addAttribute("oecg4Count",count);
    	    		}
    	    	}    			
    	    	model.addAttribute("total",count);
    	    	
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
    	        model.addAttribute("lastDay",lastDay);  
    		}
    		
    		model.put("docid",reportIFService.getLatestDoctorId(summaryReport));
    		model.put("items", "");  
    		return "/audit/exportPreview";
    	}catch(Exception e){
    		logger.error("跳转到打印预览页面异常。"+e);
    		model.put("code", "8888");
    		model.put("err_msg", "跳转到打印预览页面异常");
    		return "/notice";
    	}
    }

   
    /**
     * @Title:toMemSumReportPage 
     * @Description:跳转到单一会员汇总报告列表
     * @author 谢美团
     * @param model
     * @param request
     * @param page
     * @return 
     * @throws
     * @retrun String
     */ 
    @RequestMapping(value = "/toMemSumReportPage")
    public String toMemSumReportPage(ModelMap model,HttpServletRequest request,Page<SummaryReport> page,Integer memberid) {
    	page = new Page<SummaryReport>(page.getPageNo(),page.getPageSize());
    	//调用分页查询方法后从 page 对象中获取结果
    	summaryReportService.selectMemSumReportList(page, memberid);
    	model.put("page", page);
    	model.put("memberid", memberid);
    	return "/report/audit/memSumRepList";
    }

    /**
     * @Title:getPreviewAbecgData 
     * @Description:打印预览，获取异常心电图
     * @author 陈哲
     * @param objectId
     * @param docentry
     * @param measTime
     * @return
     * @throws Exception 
     * @throws
     * @retrun String
     */
    @ResponseBody
	@RequestMapping(value="/getPreviewAbecgData",produces="text/plain;charset=UTF-8")
    public String getPreviewAbecgData(String objectId, Long docentry, Long measTime) throws Exception{
		Oecg oecg = electrocardioService.selectElectrocardioByDocentry(docentry);
		
		ImageParam param = new ImageParam();
		param.setRawImage(objectId.replaceAll("'", ""));
		param.setFs(oecg.getFs());
		param.setWidth(1000);
		param.setHeight(300);
		param.setPage(1);
		param.setMeasureTime(new Date(measTime));
		param.setDeviceCode(oecg.getDevicecode());

		param.setType("ab_ecg"); 
		
		Map<String, Object> map = electrocardioFileService.getExcElectrocardioChartFileData(param);
		
		return JSONObject.toJSONString(map);
	}
    
    /**
     * @Title:getReportSVGData 
     * @Description:打印预览中图片svg数据
     * @author 陈哲
     * @param request
     * @return 
     * @throws
     * @retrun String
     */
    @ResponseBody
	@RequestMapping(value="/getReportSVGData")
	public String getReportSVGData(HttpServletRequest request){
		String jsonStr = request.getParameter("jsonStr");
		Object jsonObj = JSONObject.toJSON(jsonStr);

		request.getSession().setAttribute("jsonArr", jsonObj);
		
		return "1";
	}
    
    /**
     * @Title:exportReportWord 
     * @Description:打印word
     * @author 陈哲
     * @param request
     * @param response
     * @param reportNo
     * @param auditLevel
     * @param docSign
     * @throws Exception 
     * @throws
     * @retrun void
     */
    @RequestMapping(value="/exportReportWord")
	public void exportReportWord(HttpServletRequest request, HttpServletResponse response, Integer reportNo, Short auditLevel, String docSign) throws Exception{
		//从session中获取svg字符串
		JSONArray jsonArr = JSONArray.parseArray((String)request.getSession().getAttribute("jsonArr"));
		Map<String ,Object> dataMap = reportIFService.getExportWordData(reportNo, auditLevel);
		for(int i=0;i<jsonArr.size();i++){
			JSONObject jsonObj =jsonArr.getJSONObject(i);
			Set<String> keys = jsonObj.keySet(); 
			for(String key : keys){
				if("xy_tab1".equals(key)){
					String value = jsonObj.getString(key);
					dataMap.put(key, value);
				}else if("xy_tab2".equals(key)){
					String value = jsonObj.getString(key);
					dataMap.put(key, value);
				}else if("xy_chart1_0".equals(key)){
					String value = jsonObj.getString(key);
					dataMap.put(key, value);
					
					JSONArray jsonArrSvg = jsonObj.getJSONArray("svg");
					String svgStr = jsonArrSvg.getString(0);
					dataMap.put("xy_chart1_0_svg", exportWordService.doImage(svgStr, request));
				}else if("xy_chart1_1".equals(key)){
					String value = jsonObj.getString(key);
					dataMap.put(key, value);
					
					JSONArray jsonArrSvg = jsonObj.getJSONArray("svg");
					String svgStr = jsonArrSvg.getString(0);
					dataMap.put("xy_chart1_1_svg", exportWordService.doImage(svgStr, request));
				}else if("xy_chart1_2".equals(key)){
					String value = jsonObj.getString(key);
					dataMap.put(key, value);
					
					JSONArray jsonArrSvg = jsonObj.getJSONArray("svg");
					String svgStr = jsonArrSvg.getString(0);
					dataMap.put("xy_chart1_2_svg", exportWordService.doImage(svgStr, request));
				}else if("xy_chart2".equals(key)){
					String value = jsonObj.getString(key);
					dataMap.put(key, value);
					
					JSONArray jsonArrSvg = jsonObj.getJSONArray("svg");
					List<String> svgList = new ArrayList<String>();
					for(int j=0;j<jsonArrSvg.size();j++){
						String svgStr = jsonArrSvg.getString(j);
						svgList.add(exportWordService.doImage(svgStr, request));
					}
					dataMap.put("xy_chart2_svgs", svgList);
				}else if("xy_chart3".equals(key)){
					String value = jsonObj.getString(key);
					dataMap.put(key, value);
					
					JSONArray jsonArrSvg = jsonObj.getJSONArray("svg");
					String svgStr = jsonArrSvg.getString(0);
					dataMap.put("xy_chart3_svg", exportWordService.doImage(svgStr, request));
				}else if("xy_chart4".equals(key)){
					String value = jsonObj.getString(key);
					dataMap.put(key, value);
					
					JSONArray jsonArrSvg = jsonObj.getJSONArray("svg");
					String svgStr = jsonArrSvg.getString(0);
					dataMap.put("xy_chart4_svg", exportWordService.doImage(svgStr, request));
					
				}else if("xt_tab1".equals(key)){
					String value = jsonObj.getString(key);
					dataMap.put(key, value);
				}else if("xt_tab2".equals(key)){
					String value = jsonObj.getString(key);
					dataMap.put(key, value);
				}else if("xt_chart1".equals(key)){
					String value = jsonObj.getString(key);
					dataMap.put(key, value);
					
					JSONArray jsonArrSvg = jsonObj.getJSONArray("svg");
					String svgStr = jsonArrSvg.getString(0);
					dataMap.put("xt_chart1_svg", exportWordService.doImage(svgStr, request));
				}else if("xt_chart2".equals(key)){
					String value = jsonObj.getString(key);
					dataMap.put(key, value);
					
					JSONArray jsonArrSvg = jsonObj.getJSONArray("svg");
					String svgStr = jsonArrSvg.getString(0);
					dataMap.put("xt_chart2_svg", exportWordService.doImage(svgStr, request));
				}else if("xt_chart3".equals(key)){
					String value = jsonObj.getString(key);
					dataMap.put(key, value);
					
					JSONArray jsonArrSvg = jsonObj.getJSONArray("svg");
					String svgStr = jsonArrSvg.getString(0);
					dataMap.put("xt_chart3_svg", exportWordService.doImage(svgStr, request));
					
				}else if("xt_chart4".equals(key)){
					String value = jsonObj.getString(key);
					dataMap.put(key, value);
					
					JSONArray jsonArrSvg = jsonObj.getJSONArray("svg");	
					String svgStr = jsonArrSvg.getString(0);
					dataMap.put("xt_chart4_svg", exportWordService.doImage(svgStr, request));
				}else if("xt_chart5".equals(key)){
					String value = jsonObj.getString(key);
					dataMap.put(key, value);
					
					JSONArray jsonArrSvg = jsonObj.getJSONArray("svg");
					List<String> svgList = new ArrayList<String>();
					for(int j=0;j<jsonArrSvg.size();j++){
						String svgStr = jsonArrSvg.getString(j);
						svgList.add(exportWordService.doImage(svgStr, request));
					}
					dataMap.put("xt_chart5_svgs", svgList);
				}else if("shy_tab1".equals(key)){
					String value = jsonObj.getString(key);
					dataMap.put(key, value);
				}else if("shy_tab2".equals(key)){
					String value = jsonObj.getString(key);
					dataMap.put(key, value);
				}else if("shy_tab3".equals(key)){
					String value = jsonObj.getString(key);
					dataMap.put(key, value);
				}else if("shy_chart1".equals(key)){
					String value = jsonObj.getString(key);
					dataMap.put(key, value);
					
					JSONArray jsonArrSvg = jsonObj.getJSONArray("svg");
					String svgStr = jsonArrSvg.getString(0);
					dataMap.put("shy_chart1_svg", exportWordService.doImage(svgStr, request));
				}else if("shy_chart2".equals(key)){
					String value = jsonObj.getString(key);
					dataMap.put(key, value);
					
					JSONArray jsonArrSvg = jsonObj.getJSONArray("svg");
					String svgStr = jsonArrSvg.getString(0);
					dataMap.put("shy_chart2_svg", exportWordService.doImage(svgStr, request));
				}else if("shy_chart3".equals(key)){
					String value = jsonObj.getString(key);
					dataMap.put(key, value);
					
					JSONArray jsonArrSvg = jsonObj.getJSONArray("svg");
					List<String> svgList = new ArrayList<String>();
					for(int j=0;j<jsonArrSvg.size();j++){
						String svgStr = jsonArrSvg.getString(j);
						svgList.add(exportWordService.doImage(svgStr, request));					
					}
					dataMap.put("shy_chart3_svgs", svgList);
				}else if("shy_chart4".equals(key)){
					String value = jsonObj.getString(key);
					dataMap.put(key, value);
					
					JSONArray jsonArrSvg = jsonObj.getJSONArray("svg");
					String svgStr = jsonArrSvg.getString(0);
					dataMap.put("shy_chart4_svg", exportWordService.doImage(svgStr, request));				
				}else if("shy_chart5".equals(key)){
					String value = jsonObj.getString(key);
					dataMap.put(key, value);
					
					JSONArray jsonArrSvg = jsonObj.getJSONArray("svg");			
					String svgStr = jsonArrSvg.getString(0);
					dataMap.put("shy_chart5_svg", exportWordService.doImage(svgStr, request));
				}else if("shy_chart6".equals(key)){
					String value = jsonObj.getString(key);
					dataMap.put(key, value);
					
					JSONArray jsonArrSvg = jsonObj.getJSONArray("svg");
					List<String> svgList = new ArrayList<String>();
					for(int j=0;j<jsonArrSvg.size();j++){
						String svgStr = jsonArrSvg.getString(j);
						svgList.add(exportWordService.doImage(svgStr, request));
					}
					dataMap.put("shy_chart6_svgs", svgList);
				}else if("xd_tab1".equals(key)){
					String value = jsonObj.getString(key);
					dataMap.put(key, value);
				}else if("xd_tab2".equals(key)){
					String value = jsonObj.getString(key);
					dataMap.put(key, value);
				}else if("xd_chart1".equals(key)){
					String value = jsonObj.getString(key);
					dataMap.put(key, value);
					
					JSONArray jsonArrSvg = jsonObj.getJSONArray("svg");				
					String svgStr = jsonArrSvg.getString(0);
					dataMap.put("xd_chart1_svg", exportWordService.doImage(svgStr, request));			
				}else if("xd_chart2".equals(key)){
					String value = jsonObj.getString(key);
					dataMap.put(key, value);
					
					JSONArray jsonArrSvg = jsonObj.getJSONArray("svg");
					String svgStr = jsonArrSvg.getString(0);
					dataMap.put("xd_chart2_svg", exportWordService.doImage(svgStr, request));
				}else if("xd_chart3".equals(key)){
					String value = jsonObj.getString(key);
					dataMap.put(key, value);
					
					JSONArray jsonArrSvg = jsonObj.getJSONArray("svg");
					List<String> svgList = new ArrayList<String>();
					for(int j=0;j<jsonArrSvg.size();j++){
						String svgStr = jsonArrSvg.getString(j);
						svgList.add(exportWordService.doImage(svgStr, request));
					}
					dataMap.put("xd_chart3_svgs", svgList);
				}		
			}
		}
		dataMap.put("docSign", doDocSign(docSign));
		
		MemberExt member = (MemberExt)dataMap.get("omem");
		
		String exportFileName = member.getMemname() + "的"+ dataMap.get("reportSumName") + new SimpleDateFormat("yyyyMMdd").format(new Date());
		exportWordService.ExportWord(request, response, dataMap, exportFileName, "base.ftl");
	}
    
    /**
     * @Title:doDocSign 
     * @Description:获取医生签名图片，并转换为base64格式
     * @author 陈哲
     * @param imageId
     * @return 
     * @throws
     * @retrun String
     */
    private String doDocSign(String imageId){
    	byte[] data = null;
		try {
			if(imageId != null && !"".equals(imageId)){
				data = electrocardioFileService.getFile(false, imageId);
				if(data == null){
					return null;
				}
				BASE64Encoder encoder = new BASE64Encoder();
				return encoder.encode(data);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
    }

    /**
     * @Title:produceHtml 
     * @Description:html数据组装
     * @author 陈哲
     * @param obsr
     * @param title
     * @return 
     * @throws
     * @retrun String
     */
    private String produceHtml(Obsr obsr, String title){
    	StringBuffer tr = new StringBuffer();
		tr.append("<tr style=\"border-top: 1px #ccc solid;\">");
		tr.append("<td>").append(title).append("</td>");
		tr.append("<td>").append(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(obsr.getTesttime())).append("</td>");
		tr.append("<td>").append(obsr.getBsvalue()).append("</td>");
		tr.append("<td></td>");
		tr.append("</tr>");
    	return tr.toString();
    }
    
    /**
     * @Title:getEx 
     * @Description:异常心电汇总，html数据组装
     * @author 陈哲
     * @param exData
     * @param obsrs
     * @return 
     * @throws
     * @retrun String
     */
    private String getEx(List<Map<String, Object>> exData, List<Obsr> obsrs){
    	StringBuffer tr = new StringBuffer();
    	DecimalFormat df = new DecimalFormat("######0.00");
    	
    	Map<String, Object> data = reportIFService.getExData(exData, obsrs);
		tr.append("<tr style=\"border-top: 1px #ccc solid;\">");
		tr.append("<td>").append("汇总").append("</td>");
		tr.append("<td>").append(data.get("tooLowTimes")).append("</td>");
		tr.append("<td>").append(data.get("tooHighTimes")).append("</td>");
		tr.append("<td>").append(df.format(data.get("tooLowRate"))).append("%</td>");
		tr.append("<td>").append(df.format(data.get("tooHighRate"))).append("%</td>");
		tr.append("</tr>");
    	return tr.toString();
    }
    
}
