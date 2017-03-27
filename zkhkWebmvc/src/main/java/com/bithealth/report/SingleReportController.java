package com.bithealth.report;


import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bithealth.measureCore.facade.Facade;
import com.bithealth.reportCore.facade.enmu.FunctionEnmu;
import com.bithealth.reportCore.facade.model.AuditProgressParam;
import com.bithealth.reportCore.facade.service.ReportIFService;
import com.bithealth.reportCore.report.model.AuditProgress;
import com.bithealth.reportCore.report.model.SingleReport;
import com.bithealth.reportCore.report.service.AuditProgressService;
import com.bithealth.reportCore.report.service.SingleReportService;
import com.bithealth.reportCore.template.model.AuditOpinionTemplate;
import com.bithealth.reportCore.template.model.AuditOpinionTemplateExample;
import com.bithealth.sdk.core.feature.orm.mybatis.Page;
import com.bithealth.sdk.web.controller.BaseSpringController;
import com.bithealth.sdk.web.vo.ShiroUser;


/**
 * 类名称: SingleReportController  
 * 功能描述: 单项报告控制器  
 * 日期: 2016年7月23日 上午11:03:52 
 * 
 * @author 谢美团
 * @version  
 */
@Controller
@RequestMapping(value = "/singleReport")
public class SingleReportController extends BaseSpringController {

    @Resource
    private SingleReportService singleReportService;
    
    @Resource
    private ReportIFService reportIFService;
    
    @Resource
    AuditProgressService auditProgressService;
    
    @Resource
    Facade chartService;
    
    private static Logger logger=Logger.getLogger(SingleReportController.class);
 
    
    
    /**
     * @Title:showSingAduitList 
     * @Description:获取 单项待审核报告 列表并跳转到该列表页面
     * @author 谢美团
     * @param model
     * @param request
     * @param page
     * @return 
     * @throws
     * @retrun String
     */ 
    @RequestMapping(value = "/showSingAduitList", method = RequestMethod.GET)
    public String showSingAduitList(ModelMap model,HttpServletRequest request,Page<AuditProgress> page) {
    	page = new Page<AuditProgress>(page.getPageNo(),page.getPageSize());
    	reportIFService.selectAuditProgressReportByDocIdAndFunID(page,String.valueOf(getCurentUser().getId()), 1);
    	model.put("page", page);
        return "/report/audit/singlePendingAuditReport";
    }
     
    /**
     * @Title:showSingleReportList 
     * @Description:获取 已审核单项报告 列表并跳转到改列表页面
     * @author 谢美团
     * @param model
     * @param request
     * @param page
     * @return 
     * @throws
     * @retrun String
     */ 
    @RequestMapping(value = "/showSingleReportList")
    public String showSingleReportList(ModelMap model,HttpServletRequest request,Page<SingleReport> page) {
    	ShiroUser shiroUser =(ShiroUser)request.getSession().getAttribute("userInfo");
    	page = new Page<SingleReport>(page.getPageNo(),page.getPageSize());
    	//调用分页查询方法后从 page 对象中获取结果
    	reportIFService.getSingleReportByDocidAndOrgid(page, shiroUser.getId(), shiroUser.getDept_id());
    	
    	model.put("funId", FunctionEnmu.SINGLE_MEASURE.getValue());
    	model.put("count", page.getTotalCount());
    	model.put("page", page);
    	return "/report/audit/singleReportList";
    }
    
    
    /**
     * @Title:getReportDetail 
     * @Description:获取单项报告详细内容
     * @author 谢美团
     * @param model
     * @param reportNo
     * @return 
     * @throws
     * @retrun String
     */ 
    @RequestMapping(value = "/getSingleReportDetail")
    public String getSingleReportDetail(ModelMap model,String reportNo) {
    	try{
        	Map<String, Object>  map = reportIFService.getMemberReport(Integer.parseInt(reportNo));

        	SingleReport omrr =(SingleReport) map.get("omrr");
        	
        	boolean isAuditEdit = reportIFService.isAuditEdit(getCurentUser().getDept_id(), omrr.getOptId(), omrr.getPendingLevel(), omrr.getReportState());
        	if(!isAuditEdit){
        		model.put("isAudit","N");
        	}
        	Map<String, Object>  auditResultMap = reportIFService.getSingleAuditResult(omrr.getAuditList(), getCurentUser().getDept_id());
        	model.put("mrrCommons",auditResultMap.get("smr1Commons"));
        	model.put("smr1Others",auditResultMap.get("smr1Others"));
        	model.put("oasr", map.get("oasr"));
        	model.put("omem", map.get("omem"));
        	model.put("omrr", omrr);
        	model.put("age", map.get("age"));
        	model.put("lastDay", map.get("lastDay"));
        	Short optId = omrr.getOptId() == null?-1:omrr.getOptId() ;
        	switch (optId) {
	        	case 1:  // 血压
					  Map<?, ?> map1 =  reportIFService.calculOsbp(omrr.getOsbps());	
					  model.put("data1", map1.get("data1"));
					  model.put("dates", map1.get("dates"));
					  Map<?, ?> map2 = reportIFService.calculOsbpDay(omrr.getOsbps());
					  model.put("data2", map2.get("data2"));
					  model.put("dates2", map2.get("dates2"));
					  Map<?, ?> map3 = reportIFService. calculOsbpEvening(omrr.getOsbps());
					  model.put("data3", map3.get("data3"));
					  model.put("dates3", map3.get("dates3"));
					  return "/report/audit/singleOsbpRep";
	        	case 2: //血糖
	        		  return "/report/audit/singleObsrRep";
	        	case 3: //三合一
	        		  return "/report/audit/singleSanHeYiRep";
	        	case 4: //动态心电
	        		  return "/report/audit/singleDongTaiXinDianRep";
				default:{
					model.put("err_msg", "单项测量报告信息为空！找不到该单项测量数据");
					return "/notice";
				}
        	}
    	}catch(Exception e){
			model.put("err_msg", "系统异常");
			return "/notice";
    	}
    }
    
    
    
    /**
     * @Title:singleMeasueChart 
     * @Description:获取chart图数据
     * @author 谢美团
     * @param memberid
     * @param reportNo
     * @param funId
     * @return 
     * @throws
     * @retrun String
     */ 
    @ResponseBody
    @RequestMapping(value = "/singleMeasueChart",produces = "plain/text; charset=UTF-8")
    public String singleMeasueChart(Integer memberid,Integer reportNo,Integer funId, boolean flag) {
    	
    	JSONArray jsonArr = new JSONArray();
    	if(funId ==1){
    		//饼图
    		JSONObject piechart = new JSONObject();
    		piechart.put("pie1", chartService.selectBloodPresPieChartJson(memberid,reportNo));
    		jsonArr.add(piechart);
    		//柱状图
    		JSONObject barchart = new JSONObject();
    		barchart.put("bar4", chartService.selectBloodPresBarChartJson(memberid, reportNo));
    		jsonArr.add(barchart);
    		//4个小饼图
    		JSONObject timeQChart = new JSONObject();
    		timeQChart.put("timeQ", chartService.selectBloodPresSubPieChartJson(memberid, reportNo));
    		jsonArr.add(timeQChart);
    		//24小时分布图
    		jsonArr.add(chartService.selectBloodPresDistriChartJson(memberid, reportNo));
    		//所有血压趋势图
    		JSONObject trend1 = new JSONObject();
    		trend1.put("trend1", chartService.selectBloodPresMeasTrendChartJson(memberid, reportNo));
    		jsonArr.add(trend1);
    		//起床后血压趋势图
    		JSONObject trend2 = new JSONObject();
    		trend2.put("trend2", chartService.selectBloodPresMeasAfterbedTrendChartJson(memberid, reportNo));
    		jsonArr.add(trend2);
    		//起床前血压趋势图
    		JSONObject trend3 = new JSONObject();
    		trend3.put("trend3", chartService.selectBloodPresMeasBeforebedTrendChartJson(memberid, reportNo));
    		jsonArr.add(trend3);
    	}else if (funId ==2){ 
    		//24小时血糖分布图
    		jsonArr.add(chartService.selectBloodSugarDistriChartJson(memberid, reportNo));
    		//血糖分布盒图
    		jsonArr.add(chartService.selectBloodSugarDistriBoxChartJson(memberid, reportNo));
    		//血糖最值图
    		jsonArr.add(chartService.selectBloodSugarMaxAndMinTrendChartJson(memberid, reportNo));
    		//血糖饼图
    		jsonArr.add(chartService.selectBloodSugarTimeQPieChartJson(memberid, reportNo));
    		//血糖趋势图
    		JSONObject trend = new JSONObject();
    		trend.put("trend",chartService.selectBloodSugarMeasTrendsChartJson(memberid, reportNo));
    		jsonArr.add(trend);
    	}else if(funId ==3){
    		//三合一24小时异常心电分布图
    		jsonArr.add(chartService.selectElectrocardioPulseExcTrendChartJson(memberid, reportNo));
    		//三合一异常心电柱状图
    		jsonArr.add(chartService.selectElectrocardioPulseExcBarChartJson(memberid, reportNo));
    		//24小时脉搏指标分布图
    		jsonArr.add(chartService.selectPulseIndicatorsTrendChartJson(memberid, reportNo));
    		//异常脉搏指标柱状图
    		jsonArr.add(chartService.selectPulseIndicatorsExcBarChartJson(memberid, reportNo));
    		
    		if(flag){
    			//异常脉搏指标趋势图
        		jsonArr.add(chartService.selectPulseAllTrends(memberid, reportNo));
    		}
    	}else if(funId ==4){
    		//动态心电24小时异常心电分布图
    		jsonArr.add(chartService.selectElectrocardioExcTrendChartJson(memberid, reportNo));
    		//动态心电异常心电柱状图
    		jsonArr.add(chartService.selectElectrocardioExcBarChartJson(memberid, reportNo));
    	}
        return jsonArr.toString();
    }
    
    
    @RequestMapping(value = "/toSingleReportAuditPage")
    public String toSingleReportAuditPage(ModelMap model,Page<SingleReport> page,Integer serialNumber,Integer reportNo) {
    	page = new Page<SingleReport>(page.getPageNo(),page.getPageSize());
    	try{
        	if(serialNumber != null && serialNumber  >0){
        		AuditProgress auditProgress = auditProgressService.selectById(serialNumber.longValue()) ;
        		boolean result = false;
        		if(auditProgress != null){
        			result = reportIFService.checkReadSingleReportAuthority(-1, getCurentUser().getId(), getCurentUser().getDept_id(), auditProgress.getOptId(), auditProgress.getAuditLevel());
        		}
        		if(!result){
            		model.put("err_msg", "您权限不足于查看该条报告");
            		return "/notice";
        		}
        	}
        	
        	Map<String, Object>  map = reportIFService.getMemberReport(reportNo);

        	SingleReport omrr =(SingleReport) map.get("omrr");
        	
        	boolean isAuditEdit = reportIFService.isAuditEdit(getCurentUser().getId(), omrr.getOptId(), omrr.getPendingLevel(), omrr.getReportState());
        	if(!isAuditEdit){
        		model.put("isAudit","N");
        	}
        	Map<String, Object>  auditResultMap = reportIFService.getSingleAuditResult(omrr.getAuditList(), getCurentUser().getDept_id());
        	model.put("mrrCommons",auditResultMap.get("smr1Commons"));
        	model.put("smr1Others",auditResultMap.get("smr1Others"));
        	model.put("oasr", map.get("oasr"));
        	model.put("omem", map.get("omem"));
        	model.put("omrr", omrr);
        	model.put("age", map.get("age"));
        	model.put("lastDay", map.get("lastDay"));
        	Short optId = omrr.getOptId() == null?-1:omrr.getOptId() ;
        	switch (optId) {
            	case 1:  // 血压
    				  Map<?, ?> map1 =  reportIFService.calculOsbp(omrr.getOsbps());	
    				  model.put("data1", map1.get("data1"));
    				  model.put("dates", map1.get("dates"));
    				  Map<?, ?> map2 = reportIFService.calculOsbpDay(omrr.getOsbps());
    				  model.put("data2", map2.get("data2"));
    				  model.put("dates2", map2.get("dates2"));
    				  Map<?, ?> map3 = reportIFService. calculOsbpEvening(omrr.getOsbps());
    				  model.put("data3", map3.get("data3"));
    				  model.put("dates3", map3.get("dates3"));
    				  return "/report/audit/singleOsbpRep";
            	case 2: //血糖
            		  return "/report/audit/singleObsrRep";
            	case 3: //三合一
            		  return "/report/audit/singleSanHeYiRep";
            	case 4: //动态心电
            		  return "/report/audit/singleDongTaiXinDianRep";
    			default:{
    				model.put("err_msg", "单项测量报告信息为空！找不到该单项测量数据");
    				return "/notice";
    			}
        	}
    	}catch(Exception e){
			model.put("err_msg", "系统异常");
			return "/notice";
    	}
    }
    
    /**
     * @Title:saveSingleAuditContent 
     * @Description:批量或者单个审核审核单项报告
     * @author 谢美团
     * @param model
     * @param request
     * @param oasr
     * @param ids
     * @param myAdvice
     * @return 
     * @throws
     * @retrun String
     */ 
    @RequestMapping(value = "/saveSingleAuditContent")
    public String saveSingleAuditContent(ModelMap model,HttpServletRequest request,AuditProgress oasr,AuditProgressParam auditProgressParam ) {
    	ShiroUser shiroUser =(ShiroUser)request.getSession().getAttribute("userInfo");
    	String auditMode="0";
    	try{
        	if(auditProgressParam.getIds() != null){
    			auditMode="1";
    			String[] tempIds=auditProgressParam.getIds().split(",");
    			for(String id:tempIds){
    				oasr = auditProgressService.selectById(Long.parseLong(id));
    				if(oasr.getDocid()==null){
    					oasr.setDocid(shiroUser.getId());
    				}
    				reportIFService.saveSingleAuditContent_trans(oasr, auditProgressParam.getMyAdvice(), auditMode, null);
    			}
        		
        	}else{
        		if(oasr.getDocid() == null){
        			oasr.setDocid(shiroUser.getId());
        		}
        		reportIFService.saveSingleAuditContent_trans(oasr, auditProgressParam.getMyAdvice(), auditMode, null);
        	}
        	return "redirect:/singleReport/showSingAduitList";
    	}catch(Exception e){
			model.put("err_msg", "系统异常");
			return "/notice";
    	}
    }
    

    
}
