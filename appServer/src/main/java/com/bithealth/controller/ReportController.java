package com.bithealth.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bithealth.constants.Constants;
import com.bithealth.doctorCore.doctor.model.Doctor;
import com.bithealth.doctorCore.doctor.service.DoctorService;
import com.bithealth.measureCore.bloodPressure.model.Osbp;
import com.bithealth.measureCore.bloodPressure.service.BloodPressureService;
import com.bithealth.measureCore.bloodSugar.model.Obsr;
import com.bithealth.measureCore.bloodSugar.service.BloodSugarService;
import com.bithealth.measureCore.electrocardio.model.Ecg1;
import com.bithealth.measureCore.electrocardio.model.Ecg1Example;
import com.bithealth.measureCore.electrocardio.model.Ecg2;
import com.bithealth.measureCore.electrocardio.model.Oecg;
import com.bithealth.measureCore.electrocardio.service.Ecg1Service;
import com.bithealth.measureCore.electrocardio.service.Ecg2Service;
import com.bithealth.measureCore.electrocardio.service.ElectrocardioService;
import com.bithealth.measureCore.electrocardioPulse.model.Oppg;
import com.bithealth.measureCore.electrocardioPulse.service.PulseService;
import com.bithealth.measureCore.facade.Facade;
import com.bithealth.model.AppUser;
import com.bithealth.msgCenterCore.constants.MessageTypeEnum;
import com.bithealth.msgCenterCore.facade.service.MessageCenterFacadeService;
import com.bithealth.reportCore.facade.service.ReportIFService;
import com.bithealth.reportCore.report.model.SingleReport;
import com.bithealth.reportCore.report.model.SummaryReport;
import com.bithealth.reportCore.report.model.SummaryReportAudit;
import com.bithealth.reportCore.report.model.SummaryReportAuditExample;
import com.bithealth.reportCore.report.model.SummaryReportExample;
import com.bithealth.reportCore.report.model.SummaryReportExample.Criteria;
import com.bithealth.reportCore.report.model.SummaryReportRelation;
import com.bithealth.reportCore.report.model.SummaryReportRelationExample;
import com.bithealth.reportCore.report.service.SingleReportService;
import com.bithealth.reportCore.report.service.SummaryReportAuditService;
import com.bithealth.reportCore.report.service.SummaryReportRelationService;
import com.bithealth.reportCore.report.service.SummaryReportService;
import com.bithealth.reportCore.template.model.SingleTemplate;
import com.bithealth.reportCore.template.model.SummaryTemplate;
import com.bithealth.reportCore.template.service.SingleTemplateService;
import com.bithealth.reportCore.template.service.SummaryTemplateService;
import com.bithealth.sdk.core.entity.JSONResult;
import com.bithealth.sdk.core.feature.orm.mybatis.Page;
import com.bithealth.sdk.web.controller.BaseSpringController;
import com.bithealth.util.MessageUtil;
import com.bithealth.util.TimeUtil;

/**
 * @PackageName: com.bithealth.controller
 * @FileName:    ReportController.java  
 * @Description: 报告功能  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      liuxiaoqin
 * @version      V1.0  
 * @Createdate:  2016年7月28日 
 */
@Controller
@RequestMapping(value = "/report")
public class ReportController extends BaseSpringController{
	
	@Resource
    private ReportIFService reportIFService;
	
	@Resource
    private SummaryReportService summaryReportService;
	
	@Resource
    private SummaryTemplateService summaryTemplateService;
	
	@Resource
    private SummaryReportRelationService summaryReportRelationService;
	
	@Resource
    private SummaryReportAuditService summaryReportAuditService;
	
	@Resource
    private SingleTemplateService singleTemplateService;
	
	@Resource
	private SingleReportService singleReportService;
	
	@Resource
    private DoctorService doctorService;
	
	@Resource
    private BloodPressureService bloodPressureService;
	
	@Resource
    private BloodSugarService bloodSugarService;
	
	@Resource
    private ElectrocardioService electrocardioService;
	
	@Resource
    private PulseService pulseService;
	
	@Resource
    private Ecg2Service ecg2Service;
	
	@Resource
    private Ecg1Service ecg1Service;
	
	@Resource
    private MessageCenterFacadeService messageCenterFacadeService;
	
	@Resource
    private Facade chartService;
	
	/**
	 * @Description: 分页条件查询我的汇总测量报告列表
	 * @author:      liuxiaoqin
	 * @version      V1.0  
	 * @Createdate:  2016年8月6日 
	 */
	@RequestMapping(value = "/findSummaryReportList", method = RequestMethod.POST)
    public void selectSummaryReportList(HttpServletRequest request,HttpServletResponse response) throws IOException{
		PrintWriter out = response.getWriter();
		JSONResult<Object> value = new JSONResult<Object>();
		String appUser = (String)request.getAttribute("appUserStr");
    	AppUser user = JSON.parseObject(appUser, AppUser.class);
    	String otherParam = (String)request.getAttribute("otherParamStr");
    	JSONObject StrObject = JSON.parseObject(otherParam);
    	Integer pageNow = StrObject.getInteger("pageNow");
    	Integer pageSize = StrObject.getInteger("pageSize");
    	try{
    		Integer memberId = user.getUserId();
    		if(user.getUserType() == 2){
    			Integer newMemberId = StrObject.getInteger("memberId");
    			if(newMemberId == null || newMemberId <=0){
    				value.setStatusCode(1);
    				value.setMessage("参数memberId【"+newMemberId+"】应为正整数");
    				logger.info("参数memberId【"+newMemberId+"】应为正整数");
    				value.setSuccess(false);
    				out.write(JSON.toJSONString(value));
    				return;
    			}
    			memberId = newMemberId;
    		}
    		Page<SummaryReport> page = new Page<SummaryReport>(pageNow,pageSize);				
    		SummaryReportExample example = new SummaryReportExample();
    		Criteria criteria = example.createCriteria();
    		criteria.andMemberidEqualTo(memberId);
    		criteria.andReportStateNotEqualTo("0");
    		example.setOrderByClause("GrenerTime DESC");
    		List<SummaryReport> list = summaryReportService.selectByExampleAndPage(page, example);
    		if(list != null && list.size()>0){
    			/*获取未读数据的id begin */
    			List<Integer> unreadMgsIds = new ArrayList<Integer>();
    			List<Integer> mgsIds = new ArrayList<Integer>();
    			for(SummaryReport report : list){
    				mgsIds.add(report.getID());
    			}
    			if(mgsIds != null && mgsIds.size() > 0){
    				Byte msgType = MessageTypeEnum.SUMMARY_REPORT.getType();
    				List<Integer> unreadMsgList = messageCenterFacadeService.getMessageListByIds(mgsIds,msgType);
    				if(unreadMsgList != null && unreadMsgList.size() > 0){
    					for(Integer msgId : unreadMsgList){
    						unreadMgsIds.add(msgId);
    					}
    				}
    			}
    			/*获取未读数据的id end */
    			List<Map<String,Object>> mapList = getSummaryReportDataList(list,unreadMgsIds);
    			value.setData(mapList);
    			value.setStatusCode(0);
    			value.setMessage("分页条件查询我的汇总测量报告列表成功");
    			logger.info("分页条件查询我的汇总测量报告列表成功！");
    			value.setSuccess(true);
    		}else{
    			value.setStatusCode(3);
    			value.setMessage("没有汇总报告 ");
    			logger.info("没有汇总报告");
    			value.setSuccess(false);
    		}
    	}catch(Exception e){
    		value.setStatusCode(2);
    		value.setMessage(MessageUtil.getValue("error.select.data"));
			logger.info("分页条件查询我的汇总测量报告列表"+e);
			value.setSuccess(false);
    	}
    	out.write(JSON.toJSONString(value));
	}
	
	/**
	 * @Description: 根据汇总报告id查询汇总报告明细
	 * @author:      liuxiaoqin
	 * @version      V1.0  
	 * @Createdate:  2016年8月16日 
	 */
	@RequestMapping(value = "/findSummaryReportDetail", method = RequestMethod.POST)
    public void selectSummaryReportDetail(HttpServletRequest request,HttpServletResponse response) throws IOException{
		PrintWriter out = response.getWriter();
		JSONResult<Object> value = new JSONResult<Object>();
		String appUser = (String)request.getAttribute("appUserStr");
    	AppUser user = JSON.parseObject(appUser, AppUser.class);
    	String otherParam = (String)request.getAttribute("otherParamStr");
    	JSONObject StrObject = JSON.parseObject(otherParam);
    	try{
    	    Integer id = StrObject.getInteger("id");
    	    if(id == null || id <=0){
				value.setStatusCode(1);
				value.setMessage("参数id【"+id+"】应为正整数");
				logger.info("参数id【"+id+"】应为正整数");
				value.setSuccess(false);
				out.write(JSON.toJSONString(value));
				return;
			}
    	    SummaryReport report = summaryReportService.selectById(id);
    	    if(report != null){
    	    	Map<String,Object> map = getSummaryReportData(report,user);
    	    	value.setData(map);
    			value.setStatusCode(0);
    			value.setMessage("查询汇总报告明细成功");
    			logger.info("查询汇总报告明细成功！");
    			value.setSuccess(true);
    	    }else{
    			value.setStatusCode(3);
    			value.setMessage("没有汇总报告明细 ");
    			logger.info("没有汇总报告明细");
    			value.setSuccess(false);
    		}
    	}catch(Exception e){
    		value.setStatusCode(2);
    		value.setMessage(MessageUtil.getValue("error.select.data"));
			logger.info("查询汇总报告明细"+e);
			value.setSuccess(false);
    	}
    	out.write(JSON.toJSONString(value));
	}
	
	/**
	 * @Description: 根据关联单项报告的汇总报告id集合与报告类型查询单项报告明细
	 * @author:      liuxiaoqin
	 * @version      V1.0  
	 * @Createdate:  2016年8月19日 
	 */
	@RequestMapping(value = "/findRelationSingleReport", method = RequestMethod.POST)
    public void selectRelationSingleReport(HttpServletRequest request,HttpServletResponse response) throws IOException{
		PrintWriter out = response.getWriter();
		JSONResult<Object> value = new JSONResult<Object>();
    	String otherParam = (String)request.getAttribute("otherParamStr");
    	JSONObject StrObject = JSON.parseObject(otherParam);
    	try{
	    	Short sReportType = StrObject.getShort("sReportType");
	    	if(sReportType == null || sReportType <= 0){
	    		value.setStatusCode(1);
				value.setMessage("参数sReportType【"+sReportType+"】应为正整数");
				logger.info("参数sReportType【"+sReportType+"】应为正整数");
				value.setSuccess(false);
				out.write(JSON.toJSONString(value));
				return; 
	    	}
	    	Integer sumReportId = StrObject.getInteger("sumReportId");
    	    if(sumReportId == null || sumReportId <=0){
				value.setStatusCode(1);
				value.setMessage("参数sumReportId【"+sumReportId+"】应为正整数");
				logger.info("参数sumReportId【"+sumReportId+"】应为正整数");
				value.setSuccess(false);
				out.write(JSON.toJSONString(value));
				return;
			}
	    	List<SingleReport> list = singleReportService.selectBySumReportId(sumReportId);
    		if(list != null && list.size()>0){
    			Map<String,Object> map = new HashMap<String, Object>();
    			for(SingleReport report : list){
    				if(report.getOptId() == sReportType){
    					map = getSingleReportData(report,sReportType);
    				}
    			}
    			value.setData(map);
    			value.setStatusCode(0);
    			value.setMessage("根据汇总报告查询其所关联的单项报告列表成功");
    			logger.info("根据汇总报告查询其所关联的单项报告列表成功！");
    			value.setSuccess(true);
    		}else{
    			value.setStatusCode(3);
    			value.setMessage("没有所关联的单项报告 ");
    			logger.info("没有所关联的单项报告");
    			value.setSuccess(false);
    		}
    	}catch(Exception e){
    		value.setStatusCode(2);
    		value.setMessage(MessageUtil.getValue("error.select.data"));
			logger.info("根据汇总报告查询其所关联的单项报告列表"+e);
			value.setSuccess(false);
    	}
    	out.write(JSON.toJSONString(value));
	}
	
	/**
	 * @Description: 根据单项报告报告id和类型查看报告图表
	 * @author:      liuxiaoqin
	 * @version      V1.0  
	 * @Createdate:  2016年9月12日 
	 */
	@RequestMapping(value = "/findMeasureReportChart", method = RequestMethod.POST)
    public void selectMeasureReportChart(HttpServletRequest request,HttpServletResponse response) throws IOException{
		PrintWriter out = response.getWriter();
		JSONResult<Object> value = new JSONResult<Object>();
    	String otherParam = (String)request.getAttribute("otherParamStr");
    	JSONObject StrObject = JSON.parseObject(otherParam);
    	try{
	    	Short sReportType = StrObject.getShort("sReportType");
	    	if(sReportType == null || sReportType <= 0){
	    		value.setStatusCode(1);
				value.setMessage("参数sReportType【"+sReportType+"】应为正整数");
				logger.info("参数sReportType【"+sReportType+"】应为正整数");
				value.setSuccess(false);
				out.write(JSON.toJSONString(value));
				return; 
	    	}
	    	Integer sReportId = StrObject.getInteger("sReportId");
    	    if(sReportId == null || sReportId <=0){
				value.setStatusCode(1);
				value.setMessage("参数sReportId【"+sReportId+"】应为正整数");
				logger.info("参数sReportId【"+sReportId+"】应为正整数");
				value.setSuccess(false);
				out.write(JSON.toJSONString(value));
				return;
			}
    	    String appUser = (String)request.getAttribute("appUserStr");
        	AppUser user = JSON.parseObject(appUser, AppUser.class);
    	    Integer memberId = user.getUserId();
    	    JSONArray jsonArr = new JSONArray();
    	    if(sReportType == 1){
    	    	/* 血压图表  begin */
    	    	//饼图
        		JSONObject piechart = new JSONObject();
        		piechart.put("pie1", chartService.selectBloodPresPieChartJson(memberId,sReportId));
        		jsonArr.add(piechart);
        		//柱状图
        		JSONObject barchart = new JSONObject();
        		barchart.put("bar4", chartService.selectBloodPresBarChartJson(memberId, sReportId));
        		jsonArr.add(barchart);
        		//4个小饼图
        		JSONObject timeQChart = new JSONObject();
        		timeQChart.put("timeQ", chartService.selectBloodPresSubPieChartJson(memberId, sReportId));
        		jsonArr.add(timeQChart);
        		//24小时分布图
        		jsonArr.add(chartService.selectBloodPresDistriChartJson(memberId, sReportId));
        		//所有血压趋势图
        		JSONObject trend1 = new JSONObject();
        		trend1.put("trend1", chartService.selectBloodPresMeasTrendChartJson(memberId, sReportId));
        		jsonArr.add(trend1);
        		//起床后血压趋势图
        		JSONObject trend2 = new JSONObject();
        		trend2.put("trend2", chartService.selectBloodPresMeasAfterbedTrendChartJson(memberId, sReportId));
        		jsonArr.add(trend2);
        		//起床前血压趋势图
        		JSONObject trend3 = new JSONObject();
        		trend3.put("trend3", chartService.selectBloodPresMeasBeforebedTrendChartJson(memberId, sReportId));
        		jsonArr.add(trend3);
    	    	/* 血压图表  end */
    	    }else if(sReportType == 2){
    	    	/* 血糖图表  begin */
    	    	//24小时血糖分布图
        		jsonArr.add(chartService.selectBloodSugarDistriChartJson(memberId, sReportId));
        		//血糖分布盒图
        		jsonArr.add(chartService.selectBloodSugarDistriBoxChartJson(memberId, sReportId));
        		//血糖趋势图
        		JSONObject trend = new JSONObject();
        		trend.put("trend",chartService.selectBloodSugarMeasTrendsChartJson(memberId, sReportId));
        		//血糖最值图
        		jsonArr.add(chartService.selectBloodSugarMaxAndMinTrendChartJson(memberId, sReportId));
        		//血糖饼图
        		jsonArr.add(chartService.selectBloodSugarTimeQPieChartJson(memberId, sReportId));
    	    	/* 血糖图表  end */
    	    }else if(sReportType == 3){
    	    	/* 三合一图表  begin */
    	    	//三合一24小时异常心电分布图
        		jsonArr.add(chartService.selectElectrocardioPulseExcTrendChartJson(memberId, sReportId));
        		//三合一异常心电柱状图
        		jsonArr.add(chartService.selectElectrocardioPulseExcBarChartJson(memberId, sReportId));
        		//24小时脉搏指标分布图
        		jsonArr.add(chartService.selectPulseIndicatorsTrendChartJson(memberId, sReportId));
        		//异常脉搏指标柱状图
        		jsonArr.add(chartService.selectPulseIndicatorsExcBarChartJson(memberId, sReportId));
    	    	/* 三合一图表  end */
    	    }else if(sReportType == 4){
    	    	/* mini图表  begin */
    	    	//动态心电24小时异常心电分布图
        		jsonArr.add(chartService.selectElectrocardioExcTrendChartJson(memberId, sReportId));
        		//动态心电异常心电柱状图
        		jsonArr.add(chartService.selectElectrocardioExcBarChartJson(memberId, sReportId));
    	    	/* mini图表  end */
    	    }
    		if(jsonArr != null && jsonArr.size() >0 && jsonArr.isEmpty() == false){
    			value.setData(jsonArr);
    			value.setStatusCode(0);
    			value.setMessage(" 根据单项报告报告id和类型查看报告图表成功");
    			logger.info(" 根据单项报告报告id和类型查看报告图表成功！");
    			value.setSuccess(true);
    		}else{
    			value.setStatusCode(3);
    			value.setMessage("没有报告图表 ");
    			logger.info("没有报告图表");
    			value.setSuccess(false);
    		}
    	}catch(Exception e){
    		value.setStatusCode(2);
    		value.setMessage(MessageUtil.getValue("error.select.data"));
			logger.info(" 根据单项报告报告id和类型查看报告图表异常"+e);
			value.setSuccess(false);
    	}
    	out.write(JSON.toJSONString(value));
	}
	
	/**
	 * @Description: 转化汇总报告列表返回值属性名 
	 * @author:      liuxiaoqin
	 * @version      V1.0  
	 * @Createdate:  2016年8月9日 
	 */
	public List<Map<String,Object>> getSummaryReportDataList(List<SummaryReport> list,List<Integer> unreadMgsIds)throws Exception{
		List<Map<String,Object>> mapList = new ArrayList<Map<String,Object>>();
		for(SummaryReport report : list){
			Map<String,Object> map = new HashMap<String, Object>();
			int id = report.getID();
			map.put("id", id);
			map.put("memberId", report.getMemberid());
			Date date = report.getGrenerTime();
			if(date != null){
				map.put("grenerTime", TimeUtil.formatDate(date));
			}
			Integer sumRepTempCode = report.getSumRepTempCode();
			/* 获取汇总报告名称  begin */
			if(sumRepTempCode != null && sumRepTempCode > 0){
				map.put("sumRepTempCode", sumRepTempCode);
				SummaryTemplate template = summaryTemplateService.selectById(sumRepTempCode);
				if(template != null){
					map.put("templateName", template.getTempName());
				}
			}
			//是否为未读消息 :0未读；1已读
			int hasRead = 1;
			if(unreadMgsIds != null && unreadMgsIds.size() > 0){
				for(Integer msgId : unreadMgsIds){
					if(msgId.equals(id)){
						hasRead = 0;
					}
				}
			}
			map.put("hasRead",hasRead);
			/* 获取汇总报告名称  end */
			mapList.add(map);
		}
		return mapList;
	}
	
	/**
	 * @Description: 转化汇总报告明细返回值属性名 
	 * @author:      liuxiaoqin
	 * @version      V1.0  
	 * @Createdate:  2016年8月9日 
	 */
	public Map<String,Object> getSummaryReportData(SummaryReport report,AppUser user)throws Exception{
			Map<String,Object> map = new HashMap<String, Object>();
			int id = report.getID();
			map.put("id", id);
			map.put("memberId", report.getMemberid());
			Date date = report.getGrenerTime();
			if(date != null){
				map.put("produceTime", TimeUtil.formatDatetime2(date));
			}
			Integer sumRepTempCode = report.getSumRepTempCode();
			/* 获取汇总报告名称  begin */
			if(sumRepTempCode != null && sumRepTempCode > 0){
				map.put("sumRepTempCode", sumRepTempCode);
				SummaryTemplate template = summaryTemplateService.selectById(sumRepTempCode);
				if(template != null){
					map.put("templateName", template.getTempName());
				}
			}
			/* 获取汇总报告名称  end */
			
			/* 获取关联单项报告的id集合  begin */
			//是否有各种类型的单项报告(1:有;2:无)
			int hasBloodPressureReport = 2;
			int hasBloodSugerReport = 2;
			int hasMiniReport = 2;
			int hasThreeInOneReport = 2;
			SummaryReportRelationExample example = new SummaryReportRelationExample();
			com.bithealth.reportCore.report.model.SummaryReportRelationExample.Criteria criteria = example.createCriteria();
			criteria.andIDEqualTo(id);
			example.setOrderByClause("SingleID DESC");
			List<SummaryReportRelation> relationList = summaryReportRelationService.selectByExample(example);
			if(relationList != null && relationList.size()>0){
				List<Integer> singleIds = new ArrayList<Integer>();
				for(SummaryReportRelation relation : relationList){
					Integer singleReportId = relation.getSingleID();
					/* 是否有各种类型的单项报告(1:有;2:无)  begin */
					SingleReport  singleReport = singleReportService.selectById(singleReportId);
					if(singleReport != null){
						int singleReportType = singleReport.getOptId();
						if(singleReportType == 1){
							hasBloodPressureReport = 1;
						}else if(singleReportType == 2){
							hasBloodSugerReport = 1;
						}else if(singleReportType == 3){
							hasThreeInOneReport = 1;
						}else if(singleReportType == 4){
							hasMiniReport = 1;
						}
					}
					/* 是否有各种类型的单项报告(1:有;2:无)   end */
					singleIds.add(relation.getSingleID());
				}
				String singleReportIds = StringUtils.collectionToCommaDelimitedString(singleIds);
				map.put("singleReportIds", singleReportIds);
			}
			map.put("hasBloodPressureReport", hasBloodPressureReport);
			map.put("hasBloodSugerReport", hasBloodSugerReport);
			map.put("hasMiniReport", hasMiniReport);
			map.put("hasThreeInOneReport", hasThreeInOneReport);
			/* 获取关联单项报告的id集合  end */
			
			/* 获取汇总报告的审核意见等  begin */
			SummaryReportAuditExample auditExample = new SummaryReportAuditExample();
			com.bithealth.reportCore.report.model.SummaryReportAuditExample.Criteria auditCriteria = auditExample.createCriteria();
			auditCriteria.andIDEqualTo(id);
			auditExample.setOrderByClause("AuditLevel DESC");
			List<SummaryReportAudit> auditList =  summaryReportAuditService.selectByExample(auditExample);
			if(auditList != null && auditList.size()>0){
				SummaryReportAudit audit = auditList.get(0);
				int doctorId = audit.getDocid();
				map.put("auditDocId", doctorId);
				Date auditDate = audit.getAuditTime();
				if(auditDate != null){
					map.put("auditTime", TimeUtil.formatDatetime2(auditDate));
				}
				map.put("auditAdvise", audit.getAuditDesc());
				map.put("sumRepCode", audit.getSerialNumber());
				Doctor doctor = doctorService.selectById(doctorId);
				if(doctor != null){
					map.put("auditDocName", doctor.getDocname());
					map.put("auditDocSignature", doctor.getSignaddress());
				}
			}
			/* 设置消息为已读   begin */
			Byte msgType = MessageTypeEnum.SUMMARY_REPORT.getType();
			boolean isOk = messageCenterFacadeService.deleteById(id,msgType,user.getUserGUID());
			if(isOk == true){
				logger.info("更新消息为已读成功。");
			}else{
				logger.info("更新消息为已读失败。");
			}
			/* 设置消息为已读   end */
			/* 获取汇总报告的审核意见等  end */
		return map;
	}
	
	
	/**
	 * @Description: 转化单项报告明细返回值属性名 
	 * @author:      liuxiaoqin
	 * @version      V1.0  
	 * @Createdate:  2016年8月19日 
	 */
	public Map<String,Object> getSingleReportData(SingleReport report,Short sReportType)throws Exception{
			Map<String,Object> map = new HashMap<String, Object>();
			int id = report.getID();
			map.put("srId", id);
			Integer memberId = report.getMemberid();
			map.put("srMemberId", memberId);
			Date date = report.getGrenerTime();
			if(date != null){
				map.put("srProduceTime", TimeUtil.formatDatetime2(date));
			}
			Integer tempCode = report.getTempCode();
			map.put("srTempCode", tempCode);
			/* 获取报告名称 begin */
			SingleTemplate singleTempate = singleTemplateService.selectById(tempCode);
			if(singleTempate != null){
				map.put("srTemplateName", singleTempate.getTempName());
			}
			/* 获取报告名称 end */
			map.put("srReportCode", report.getReportCode());
			Date beginTime = report.getMeasTime();
			if(beginTime != null){
				map.put("srMeasBeginTime", TimeUtil.formatDatetime2(beginTime));
			}
			Date endTime = report.getMeasTermTime();
			if(endTime != null){
				map.put("srMeasEndTime", TimeUtil.formatDatetime2(endTime));
			}
			if(beginTime != null && endTime != null){
				int days = (int)((endTime.getTime() - beginTime.getTime())/86400000);
				map.put("srTakeDay", days);
				String beginDate = TimeUtil.formatDate(beginTime);
				String endDate = TimeUtil.formatDate(endTime);
				map.put("srMeasTime", beginDate + "至" + endDate);
			}
			if(sReportType == 1){
			    Page<Osbp> pages = bloodPressureService.selectBloodPressAndPage(memberId,1,Constants.REPORT_PAGE_SIZE,beginTime,endTime);
			    if(pages != null && pages.getResult() != null && pages.getResult().size() >0){
			    	map.put("srMeasData",getBloodPressureReportData(pages.getResult()));
			    }
			}else if(sReportType == 2){
				Page<Obsr> pagesObsr = bloodSugarService.selectBloodSugarAndPage(memberId,1,Constants.REPORT_PAGE_SIZE,beginTime,endTime,null);
			    if(pagesObsr != null && pagesObsr.getResult() != null && pagesObsr.getResult().size() >0){
			    	map.put("srMeasData",getBloodSugerReportData(pagesObsr.getResult()));
			    }
			}else if(sReportType == 3){
				Page<Oecg> pagesOecg = pulseService.selectElectrocardioPulseAndPage(memberId, 1,Constants.REPORT_PAGE_SIZE,beginTime,endTime);
			    if(pagesOecg != null && pagesOecg.getResult() != null && pagesOecg.getResult().size() >0){
			    	map.put("srMeasData",getThreeInOneReportData(pagesOecg.getResult()));
			    }
			}else if(sReportType == 4){
				Page<Oecg> pagesOecg = electrocardioService.selectElectrocardioAndPage(memberId,1,Constants.REPORT_PAGE_SIZE,beginTime,endTime);
			    if(pagesOecg != null && pagesOecg.getResult() != null && pagesOecg.getResult().size() >0){
			    	map.put("srMeasData",getMiniReportData(pagesOecg.getResult()));
			    }
			}
			map.put("sReportType", sReportType);
		return map;
	}
	
	/**
	 * @Description: 获取血压详情值 
	 * @author:      liuxiaoqin
	 * @version      V1.0  
	 * @Createdate:  2016年8月19日 
	 */
	@SuppressWarnings("deprecation")
	public Map<String,Object> getBloodPressureReportData(List<Osbp> list)throws Exception{
		Map<String,Object> map = new HashMap<String, Object>();
		if(list != null && list.size() > 0){
			List<Osbp> dayList = new ArrayList<Osbp>();
			List<Osbp> nightList = new ArrayList<Osbp>();
			for(Osbp osbp : list){
				int hour = osbp.getTesttime().getHours();
				if(hour >= 8 && hour <= 22){
					dayList.add(osbp);
				}else{
					nightList.add(osbp);
				}
			}
			map.put("allDayData", getBloodPressureList(list));
			map.put("dayData", getBloodPressureList(dayList));
			map.put("nightData", getBloodPressureList(nightList));
			map.put("totalRecord", list.size());
			map.put("bloodPressureRecordList", getBloodPressureRecordList(list));
		}
		return map;
	}
	
	/**
	 * @Description: 获取血压详情detail值 
	 * @author:      liuxiaoqin
	 * @version      V1.0  
	 * @Createdate:  2016年8月19日 
	 */
	public List<Map<String,Object>> getBloodPressureList(List<Osbp> list)throws Exception{
		List<Map<String,Object>> mapList = new ArrayList<Map<String,Object>>();
		if(list != null && list.size() > 0){
			List<Integer> diastolicList = new ArrayList<Integer>();
			List<Integer> systolicList = new ArrayList<Integer>();
			List<Integer> pulseList = new ArrayList<Integer>();
			List<Integer> avgPressureList = new ArrayList<Integer>();
			List<String> testTimeList = new ArrayList<String>();
			Integer totalDiastolic = 0;
			Integer totalSystolic = 0;
			Integer totalPulse = 0;
			Integer totalAvgPressure = 0;
			for(Osbp osbp : list){
				Integer diastolic = osbp.getDbp();
				Integer systolic = osbp.getSbp();
				Integer pulse = osbp.getPulserate();
				Integer avgPressure = (diastolic * 2 + systolic)/3;
				diastolicList.add(diastolic);
				systolicList.add(systolic);
				pulseList.add(pulse);
				avgPressureList.add(avgPressure);
				totalDiastolic += diastolic;
				totalSystolic += systolic;
				totalPulse += pulse;
				totalAvgPressure += avgPressure;
				Date date = osbp.getTesttime();
				if(date != null){
					String testTime = TimeUtil.formatDatetime2(date);
					testTimeList.add(testTime);
				}
			}
			/* 舒张压  begin */
			if(diastolicList != null && diastolicList.size() > 0){
				Map<String,Object> map = new HashMap<String, Object>();
				Object[] diastolicArr = diastolicList.toArray();
				Object[] testTimeArr = testTimeList.toArray();
				Arrays.sort(diastolicArr);
				Arrays.sort(testTimeArr);
				int size = diastolicArr.length;
				Integer maxDiastolic = (Integer)diastolicArr[size-1];
				Integer minDiastolic = (Integer)diastolicArr[0];
				Double avgDiastolic = (double)(totalDiastolic/size);
				String maxTestTime = (String)testTimeArr[size-1];
				String minTestTime = (String)testTimeArr[0];
				map.put("maxValue", maxDiastolic);
				map.put("minValue", minDiastolic);
				map.put("avgValue", avgDiastolic);
				map.put("maxTestTime", maxTestTime);
				map.put("minTestTime", minTestTime);
				map.put("testName", "舒张压");
				mapList.add(map);
			}
			/* 舒张压  end */
			
			/* 收缩压  begin */
			if(systolicList != null && systolicList.size() > 0){
				Map<String,Object> map = new HashMap<String, Object>();
				Object[] systolicArr = systolicList.toArray();
				Object[] testTimeArr = testTimeList.toArray();
				Arrays.sort(systolicArr);
				Arrays.sort(testTimeArr);
				int size1 = systolicArr.length;
				Integer maxSystolic = (Integer)systolicArr[size1-1];
				Integer minSystolic = (Integer)systolicArr[0];
				Double avgSystolic = (double)(totalSystolic/size1);
				String maxTestTime = (String)testTimeArr[size1-1];
				String minTestTime = (String)testTimeArr[0];
				map.put("maxValue", maxSystolic);
				map.put("minValue", minSystolic);
				map.put("avgValue", avgSystolic);
				map.put("maxTestTime", maxTestTime);
				map.put("minTestTime", minTestTime);
				map.put("testName", "收缩压");
				mapList.add(map);
			}
			/* 收缩压  end */
			
			/* 脉搏  begin */
			if(pulseList != null && pulseList.size() > 0){
				Map<String,Object> map = new HashMap<String, Object>();
				Object[] pulseArr = pulseList.toArray();
				Object[] testTimeArr = testTimeList.toArray();
				Arrays.sort(pulseArr);
				Arrays.sort(testTimeArr);
				int size1 = pulseArr.length;
				Integer maxPulse = (Integer)pulseArr[size1-1];
				Integer minPulse = (Integer)pulseArr[0];
				Double avgPulse = (double)(totalPulse/size1);
				String maxTestTime = (String)testTimeArr[size1-1];
				String minTestTime = (String)testTimeArr[0];
				map.put("maxValue", maxPulse);
				map.put("minValue", minPulse);
				map.put("avgValue", avgPulse);
				map.put("maxTestTime", maxTestTime);
				map.put("minTestTime", minTestTime);
				map.put("testName", "脉搏");
				mapList.add(map);
			}
			/* 脉搏 end */
			
			/* 平均圧  begin */
			if(avgPressureList != null && avgPressureList.size() > 0){
				Map<String,Object> map = new HashMap<String, Object>();
				Object[] avgPressureArr = avgPressureList.toArray();
				Object[] testTimeArr = testTimeList.toArray();
				Arrays.sort(avgPressureArr);
				Arrays.sort(testTimeArr);
				int size1 = avgPressureArr.length;
				Integer maxAvgPressure = (Integer)avgPressureArr[size1-1];
				Integer minAvgPressure = (Integer)avgPressureArr[0];
				Double avgAvgPressure = (double)(totalAvgPressure/size1);
				String maxTestTime = (String)testTimeArr[size1-1];
				String minTestTime = (String)testTimeArr[0];
				map.put("maxValue", maxAvgPressure);
				map.put("minValue", minAvgPressure);
				map.put("avgValue", avgAvgPressure);
				map.put("maxTestTime", maxTestTime);
				map.put("minTestTime", minTestTime);
				map.put("testName", "平均压");
				mapList.add(map);
			}
			/* 平均圧  end */
		}
		return mapList;
	}
	
	/**
	 * @Description: 获取血压所有记录值 
	 * @author:      liuxiaoqin
	 * @version      V1.0  
	 * @Createdate:  2016年8月19日 
	 */
	public List<Map<String,Object>> getBloodPressureRecordList(List<Osbp> list)throws Exception{
		List<Map<String,Object>> mapList = new ArrayList<Map<String,Object>>();
		for(Osbp osbp :list){
			Map<String,Object> map = new HashMap<String, Object>();
			String timePeriod = osbp.getTimeperiod();
			String timePeriodStr = MeasureController.convertTimePeriod(Integer.valueOf(timePeriod),1);
			String bloodPressure = "";
			Integer pressureDiffer = 0;
			Integer avgPressure = 0;
			Integer productIndex = 0;
			Integer pluseRate = osbp.getPulserate();
			//是否偏高2，偏低1，正常0
			Integer isHighOrLow = 0;
			Date date = osbp.getTesttime();
			if(date != null){
				map.put("testTime", TimeUtil.formatDatetime2(date));
			}
			//收缩压
			Integer sbp = osbp.getSbp();
			//舒张压
			Integer dbp = osbp.getDbp();
			if(sbp != null && dbp != null){
				bloodPressure = sbp + "/" + dbp;
				avgPressure = (sbp + dbp * 2)/3;
				pressureDiffer = Math.abs(sbp - dbp);
				productIndex = sbp * pluseRate;
			}else if(sbp != null && dbp == null){
				bloodPressure = String.valueOf(sbp);
				avgPressure = sbp/3;
				pressureDiffer = sbp * pluseRate;
			}else if(sbp == null && dbp != null){
				bloodPressure = String.valueOf(dbp);
				avgPressure = (dbp * 2)/3;
				pressureDiffer = dbp;
			}
			//分析血压数据异常状态 0 正常1 低血压2 高度高血压3 中度高血压4 轻度高血压5 单纯收缩高血压
			String abnormal = osbp.getAbnormal();
			if(!StringUtils.isEmpty(abnormal)){
				if(Integer.valueOf(abnormal)== 0){
					isHighOrLow = 0;
				}else if(Integer.valueOf(abnormal)== 1){
					isHighOrLow = 1;
				}else{
					isHighOrLow = 2;
				}
			}
			map.put("bloodPressure", bloodPressure);
			map.put("avgPressure", avgPressure);
			map.put("pluseRate", pluseRate);
			map.put("pressureDiffer", pressureDiffer);
			map.put("productIndex", productIndex);
			map.put("timePeriodStr", timePeriodStr);
			map.put("isHighOrLow", isHighOrLow);
			mapList.add(map);
		}
		return mapList;
	}
	
	/**
	 * @Description: 获取血糖详情值 
	 * @author:      liuxiaoqin
	 * @version      V1.0  
	 * @Createdate:  2016年8月19日 
	 */
	public Map<String,Object> getBloodSugerReportData(List<Obsr> list)throws Exception{
		Map<String,Object> map = new HashMap<String, Object>();
		if(list != null && list.size() > 0){
			map.put("maxSugerData", getMaxSugerData(list));
			map.put("minSugerData", getMinSugerData(list));
			map.put("avgSugerData", getAvgSugerData(list));
			map.put("abnormalSugerData", getAbnormalSugerData(list));
			map.put("totalRecord", list.size());
			map.put("bloodSugerRecordList", getBloodSugerRecordList(list));
		}
		return map;
	}
	
	/**
	 * @Description: 获取各个时间段血糖最大值
	 * @author:      liuxiaoqin
	 * @version      V1.0  
	 * @Createdate:  2016年9月6日 
	 */
	public List<Map<String,Object>> getMaxSugerData(List<Obsr> list)throws Exception{
		List<Map<String,Object>> mapList = new ArrayList<Map<String,Object>>();
		if(list != null && list.size() > 0){
			Double maxAvg = 0d;
			String maxAvgTime = "";
			List<Double> suger0 = new ArrayList<Double>();
			List<Double> suger1 = new ArrayList<Double>();
			List<Double> suger2 = new ArrayList<Double>();
			List<Double> suger3 = new ArrayList<Double>();
			List<Double> suger4 = new ArrayList<Double>();
			List<Double> suger5 = new ArrayList<Double>();
			List<Double> suger6 = new ArrayList<Double>();
			List<Double> suger7 = new ArrayList<Double>();
			List<Double> suger8 = new ArrayList<Double>();
			List<Double> maxBS = new ArrayList<Double>();
			List<Date> time0 = new ArrayList<Date>();
			List<Date> time1 = new ArrayList<Date>();
			List<Date> time2 = new ArrayList<Date>();
			List<Date> time3 = new ArrayList<Date>();
			List<Date> time4 = new ArrayList<Date>();
			List<Date> time5 = new ArrayList<Date>();
			List<Date> time6 = new ArrayList<Date>();
			List<Date> time7 = new ArrayList<Date>();
			List<Date> time8 = new ArrayList<Date>();
			List<String> maxTime = new ArrayList<String>();
			for(Obsr obsr : list){
				String timePeriod = obsr.getTimeperiod();
				Double bsValue = obsr.getBsvalue();
				Date testTime = obsr.getTesttime();
				if(timePeriod.equals("0")){
					suger0.add(bsValue);
					time0.add(testTime);
				}else if(timePeriod.equals("1")){
					suger1.add(bsValue);
					time1.add(testTime);
				}else if(timePeriod.equals("2")){
					suger2.add(bsValue);
					time2.add(testTime);
				}else if(timePeriod.equals("3")){
					suger3.add(bsValue);
					time3.add(testTime);
				}else if(timePeriod.equals("4")){
					suger4.add(bsValue);
					time4.add(testTime);
				}else if(timePeriod.equals("5")){
					suger5.add(bsValue);
					time5.add(testTime);
				}else if(timePeriod.equals("6")){
					suger6.add(bsValue);
					time6.add(testTime);
				}else if(timePeriod.equals("7")){
					suger7.add(bsValue);
					time7.add(testTime);
				}else if(timePeriod.equals("8")){
					suger8.add(bsValue);
					time8.add(testTime);
				}
			}
			if(suger0 != null && suger0.size() > 0){
				Map<String,Object> map = new HashMap<String, Object>();
				Map<String,Object> mapNew = getBloodSugerMaxOrMinOrAvgData(suger0,time0);
				Double value = (Double)mapNew.get("maxValue");
				String testTime = (String)mapNew.get("testTime");
				map.put("testTime", testTime);
				map.put("sugerValue", mapNew.get("maxValue"));
				map.put("testPeriod", 0);
				map.put("testName", "随机");
				mapList.add(map);
				maxBS.add(value);
				maxTime.add(testTime);
			}
			if(suger1 != null && suger1.size() > 0){
				Map<String,Object> map = new HashMap<String, Object>();
				Map<String,Object> mapNew = getBloodSugerMaxOrMinOrAvgData(suger1,time1);
				Double value = (Double)mapNew.get("maxValue");
				String testTime = (String)mapNew.get("testTime");
				map.put("testTime", testTime);
				map.put("sugerValue", value);
				map.put("testPeriod", 1);
				map.put("testName", "早晨空腹");
				mapList.add(map);
				maxBS.add(value);
				maxTime.add(testTime);
			}
			if(suger2 != null && suger2.size() > 0){
				Map<String,Object> map = new HashMap<String, Object>();
				Map<String,Object> mapNew = getBloodSugerMaxOrMinOrAvgData(suger2,time2);
				Double value = (Double)mapNew.get("maxValue");
				String testTime = (String)mapNew.get("testTime");
				map.put("testTime", testTime);
				map.put("sugerValue", value);
				map.put("testPeriod", 2);
				map.put("testName", "早餐后2小时");
				mapList.add(map);
				maxBS.add(value);
				maxTime.add(testTime);
			}
			if(suger3 != null && suger3.size() > 0){
				Map<String,Object> map = new HashMap<String, Object>();
				Map<String,Object> mapNew = getBloodSugerMaxOrMinOrAvgData(suger3,time3);
				Double value = (Double)mapNew.get("maxValue");
				String testTime = (String)mapNew.get("testTime");
				map.put("testTime", testTime);
				map.put("sugerValue", value);
				map.put("testPeriod", 3);
				map.put("testName", "午餐前");
				mapList.add(map);
				maxBS.add(value);
				maxTime.add(testTime);
			}
			if(suger4 != null && suger4.size() > 0){
				Map<String,Object> map = new HashMap<String, Object>();
				Map<String,Object> mapNew = getBloodSugerMaxOrMinOrAvgData(suger4,time4);
				Double value = (Double)mapNew.get("maxValue");
				String testTime = (String)mapNew.get("testTime");
				map.put("testTime", testTime);
				map.put("sugerValue", value);
				map.put("testPeriod", 4);
				map.put("testName", "午餐后2小时");
				mapList.add(map);
				maxBS.add(value);
				maxTime.add(testTime);
			}
			if(suger5 != null && suger5.size() > 0){
				Map<String,Object> map = new HashMap<String, Object>();
				Map<String,Object> mapNew = getBloodSugerMaxOrMinOrAvgData(suger5,time5);
				Double value = (Double)mapNew.get("maxValue");
				String testTime = (String)mapNew.get("testTime");
				map.put("testTime", testTime);
				map.put("sugerValue", value);
				map.put("testPeriod", 5);
				map.put("testName", "晚餐前");
				mapList.add(map);
				maxBS.add(value);
				maxTime.add(testTime);
			}
			if(suger6 != null && suger6.size() > 0){
				Map<String,Object> map = new HashMap<String, Object>();
				Map<String,Object> mapNew = getBloodSugerMaxOrMinOrAvgData(suger6,time6);
				Double value = (Double)mapNew.get("maxValue");
				String testTime = (String)mapNew.get("testTime");
				map.put("testTime", testTime);
				map.put("sugerValue", value);
				map.put("testPeriod", 6);
				map.put("testName", "晚餐后2小时");
				mapList.add(map);
				maxBS.add(value);
				maxTime.add(testTime);
			}
			if(suger7 != null && suger7.size() > 0){
				Map<String,Object> map = new HashMap<String, Object>();
				Map<String,Object> mapNew = getBloodSugerMaxOrMinOrAvgData(suger7,time7);
				Double value = (Double)mapNew.get("maxValue");
				String testTime = (String)mapNew.get("testTime");
				map.put("testTime", testTime);
				map.put("sugerValue", value);
				map.put("testPeriod", 7);
				map.put("testName", "睡觉前");
				mapList.add(map);
				maxBS.add(value);
				maxTime.add(testTime);
			}
			if(suger8 != null && suger8.size() > 0){
				Map<String,Object> map = new HashMap<String, Object>();
				Map<String,Object> mapNew = getBloodSugerMaxOrMinOrAvgData(suger8,time8);
				Double value = (Double)mapNew.get("maxValue");
				String testTime = (String)mapNew.get("testTime");
				map.put("testTime", testTime);
				map.put("sugerValue", value);
				map.put("testPeriod", 8);
				map.put("testName", "夜间");
				mapList.add(map);
				maxBS.add(value);
				maxTime.add(testTime);
			}
			
			/* 所有测量时间段最大血糖值和时间  begin */
			if(maxBS != null && maxBS.size() > 0){
				Object[] arrMax = maxBS.toArray();
				Object[] arrMaxTime = maxTime.toArray();
				Arrays.sort(arrMax);
				Arrays.sort(arrMaxTime);
				int size = arrMax.length;
				maxAvg = (Double)arrMax[size-1];
				maxAvgTime = (String)arrMaxTime[size-1];
				Map<String,Object> mapNew = new HashMap<String, Object>();
				mapNew.put("testTime", maxAvgTime);
				mapNew.put("sugerValue", maxAvg);
				mapNew.put("testName", "最大血糖值");
				mapList.add(mapNew);
			}
			/* 所有测量时间段最大血糖值和时间  end */
		}
		return mapList;
	}
	
	
	
	/**
	 * @Description: 获取各个时间段血糖最小值
	 * @author:      liuxiaoqin
	 * @version      V1.0  
	 * @Createdate:  2016年9月6日 
	 */
	public List<Map<String,Object>> getMinSugerData(List<Obsr> list)throws Exception{
		List<Map<String,Object>> mapList = new ArrayList<Map<String,Object>>();
		if(list != null && list.size() > 0){
			Double minAvg = 0d;
			String minAvgTime = "";
			List<Double> suger0 = new ArrayList<Double>();
			List<Double> suger1 = new ArrayList<Double>();
			List<Double> suger2 = new ArrayList<Double>();
			List<Double> suger3 = new ArrayList<Double>();
			List<Double> suger4 = new ArrayList<Double>();
			List<Double> suger5 = new ArrayList<Double>();
			List<Double> suger6 = new ArrayList<Double>();
			List<Double> suger7 = new ArrayList<Double>();
			List<Double> suger8 = new ArrayList<Double>();
			List<Double> minBS = new ArrayList<Double>();
			List<Date> time0 = new ArrayList<Date>();
			List<Date> time1 = new ArrayList<Date>();
			List<Date> time2 = new ArrayList<Date>();
			List<Date> time3 = new ArrayList<Date>();
			List<Date> time4 = new ArrayList<Date>();
			List<Date> time5 = new ArrayList<Date>();
			List<Date> time6 = new ArrayList<Date>();
			List<Date> time7 = new ArrayList<Date>();
			List<Date> time8 = new ArrayList<Date>();
			List<String> minTime = new ArrayList<String>();
			for(Obsr obsr : list){
				String timePeriod = obsr.getTimeperiod();
				Double bsValue = obsr.getBsvalue();
				Date testTime = obsr.getTesttime();
				if(timePeriod.equals("0")){
					suger0.add(bsValue);
					time0.add(testTime);
				}else if(timePeriod.equals("1")){
					suger1.add(bsValue);
					time1.add(testTime);
				}else if(timePeriod.equals("2")){
					suger2.add(bsValue);
					time2.add(testTime);
				}else if(timePeriod.equals("3")){
					suger3.add(bsValue);
					time3.add(testTime);
				}else if(timePeriod.equals("4")){
					suger4.add(bsValue);
					time4.add(testTime);
				}else if(timePeriod.equals("5")){
					suger5.add(bsValue);
					time5.add(testTime);
				}else if(timePeriod.equals("6")){
					suger6.add(bsValue);
					time6.add(testTime);
				}else if(timePeriod.equals("7")){
					suger7.add(bsValue);
					time7.add(testTime);
				}else if(timePeriod.equals("8")){
					suger8.add(bsValue);
					time8.add(testTime);
				}
			}
			if(suger0 != null && suger0.size() > 0){
				Map<String,Object> map = new HashMap<String, Object>();
				Map<String,Object> mapNew = getBloodSugerMaxOrMinOrAvgData(suger0,time0);
				Double value = (Double)mapNew.get("minValue");
				String testTime = (String)mapNew.get("testTime");
				map.put("testTime", testTime);
				map.put("sugerValue", value);
				map.put("testPeriod", 0);
				map.put("testName", "随机");
				mapList.add(map);
				minBS.add(value);
				minTime.add(testTime);
			}
			if(suger1 != null && suger1.size() > 0){
				Map<String,Object> map = new HashMap<String, Object>();
				Map<String,Object> mapNew = getBloodSugerMaxOrMinOrAvgData(suger1,time1);
				Double value = (Double)mapNew.get("minValue");
				String testTime = (String)mapNew.get("testTime");
				map.put("testTime", testTime);
				map.put("sugerValue", value);
				map.put("testPeriod", 1);
				map.put("testName", "早晨空腹");
				mapList.add(map);
				minBS.add(value);
				minTime.add(testTime);
			}
			if(suger2 != null && suger2.size() > 0){
				Map<String,Object> map = new HashMap<String, Object>();
				Map<String,Object> mapNew = getBloodSugerMaxOrMinOrAvgData(suger2,time2);
				Double value = (Double)mapNew.get("minValue");
				String testTime = (String)mapNew.get("testTime");
				map.put("testTime", testTime);
				map.put("sugerValue", value);
				map.put("testPeriod", 2);
				map.put("testName", "早餐后2小时");
				mapList.add(map);
				minBS.add(value);
				minTime.add(testTime);
			}
			if(suger3 != null && suger3.size() > 0){
				Map<String,Object> map = new HashMap<String, Object>();
				Map<String,Object> mapNew = getBloodSugerMaxOrMinOrAvgData(suger3,time3);
				Double value = (Double)mapNew.get("minValue");
				String testTime = (String)mapNew.get("testTime");
				map.put("testTime", testTime);
				map.put("sugerValue", value);
				map.put("testPeriod", 3);
				map.put("testName", "午餐前");
				mapList.add(map);
				minBS.add(value);
				minTime.add(testTime);
			}
			if(suger4 != null && suger4.size() > 0){
				Map<String,Object> map = new HashMap<String, Object>();
				Map<String,Object> mapNew = getBloodSugerMaxOrMinOrAvgData(suger4,time4);
				Double value = (Double)mapNew.get("minValue");
				String testTime = (String)mapNew.get("testTime");
				map.put("testTime", testTime);
				map.put("sugerValue", value);
				map.put("testPeriod", 4);
				map.put("testName", "午餐后2小时");
				mapList.add(map);
				minBS.add(value);
				minTime.add(testTime);
			}
			if(suger5 != null && suger5.size() > 0){
				Map<String,Object> map = new HashMap<String, Object>();
				Map<String,Object> mapNew = getBloodSugerMaxOrMinOrAvgData(suger5,time5);
				Double value = (Double)mapNew.get("minValue");
				String testTime = (String)mapNew.get("testTime");
				map.put("testTime", testTime);
				map.put("sugerValue", value);
				map.put("testPeriod", 5);
				map.put("testName", "晚餐前");
				mapList.add(map);
				minBS.add(value);
				minTime.add(testTime);
			}
			if(suger6 != null && suger6.size() > 0){
				Map<String,Object> map = new HashMap<String, Object>();
				Map<String,Object> mapNew = getBloodSugerMaxOrMinOrAvgData(suger6,time6);
				Double value = (Double)mapNew.get("minValue");
				String testTime = (String)mapNew.get("testTime");
				map.put("testTime", testTime);
				map.put("sugerValue", value);
				map.put("testPeriod", 6);
				map.put("testName", "晚餐后2小时");
				mapList.add(map);
				minBS.add(value);
				minTime.add(testTime);
			}
			if(suger7 != null && suger7.size() > 0){
				Map<String,Object> map = new HashMap<String, Object>();
				Map<String,Object> mapNew = getBloodSugerMaxOrMinOrAvgData(suger7,time7);
				Double value = (Double)mapNew.get("minValue");
				String testTime = (String)mapNew.get("testTime");
				map.put("testTime", testTime);
				map.put("sugerValue", value);
				map.put("testPeriod", 7);
				map.put("testName", "睡觉前");
				mapList.add(map);
				minBS.add(value);
				minTime.add(testTime);
			}
			if(suger8 != null && suger8.size() > 0){
				Map<String,Object> map = new HashMap<String, Object>();
				Map<String,Object> mapNew = getBloodSugerMaxOrMinOrAvgData(suger8,time8);
				Double value = (Double)mapNew.get("minValue");
				String testTime = (String)mapNew.get("testTime");
				map.put("testTime", testTime);
				map.put("sugerValue", value);
				map.put("testPeriod", 8);
				map.put("testName", "夜间");
				mapList.add(map);
				minBS.add(value);
				minTime.add(testTime);
			}
			
			/* 所有测量时间段最小血糖值和时间  begin */
			if(minBS != null && minBS.size() > 0){
				Object[] arrMin = minBS.toArray();
				Object[] arrMinTime = minTime.toArray();
				Arrays.sort(arrMin);
				Arrays.sort(arrMinTime);
				int size = arrMin.length;
				minAvg = (Double)arrMin[0];
				minAvgTime = (String)arrMinTime[size-1];
				Map<String,Object> mapNew = new HashMap<String, Object>();
				mapNew.put("testTime", minAvgTime);
				mapNew.put("sugerValue", minAvg);
				mapNew.put("testName", "最小血糖值");
				mapList.add(mapNew);
			}
			/* 所有测量时间段最小血糖值和时间  end */
		}
		return mapList;
	}
	
	/**
	 * @Description: 获取各个时间段血糖平均值
	 * @author:      liuxiaoqin
	 * @version      V1.0  
	 * @Createdate:  2016年9月6日 
	 */
	public List<Map<String,Object>> getAvgSugerData(List<Obsr> list)throws Exception{
		List<Map<String,Object>> mapList = new ArrayList<Map<String,Object>>();
		if(list != null && list.size() > 0){
			List<Double> suger0 = new ArrayList<Double>();
			List<Double> suger1 = new ArrayList<Double>();
			List<Double> suger2 = new ArrayList<Double>();
			List<Double> suger3 = new ArrayList<Double>();
			List<Double> suger4 = new ArrayList<Double>();
			List<Double> suger5 = new ArrayList<Double>();
			List<Double> suger6 = new ArrayList<Double>();
			List<Double> suger7 = new ArrayList<Double>();
			List<Double> suger8 = new ArrayList<Double>();
			List<BigDecimal> avgBS = new ArrayList<BigDecimal>();
			for(Obsr obsr : list){
				String timePeriod = obsr.getTimeperiod();
				Double bsValue = obsr.getBsvalue();
				if(timePeriod.equals("0")){
					suger0.add(bsValue);
				}else if(timePeriod.equals("1")){
					suger1.add(bsValue);
				}else if(timePeriod.equals("2")){
					suger2.add(bsValue);
				}else if(timePeriod.equals("3")){
					suger3.add(bsValue);
				}else if(timePeriod.equals("4")){
					suger4.add(bsValue);
				}else if(timePeriod.equals("5")){
					suger5.add(bsValue);
				}else if(timePeriod.equals("6")){
					suger6.add(bsValue);
				}else if(timePeriod.equals("7")){
					suger7.add(bsValue);
				}else if(timePeriod.equals("8")){
					suger8.add(bsValue);
				}
			}
			if(suger0 != null && suger0.size() > 0){
				Map<String,Object> map = new HashMap<String, Object>();
				Map<String,Object> mapNew = getBloodSugerMaxOrMinOrAvgData(suger0,null);
				BigDecimal value = (BigDecimal)mapNew.get("avgSugerValue");
				map.put("avgSugerValue", value);
				map.put("testPeriod", 0);
				map.put("testName", "随机");
				mapList.add(map);
				avgBS.add(value);
			}
			if(suger1 != null && suger1.size() > 0){
				Map<String,Object> map = new HashMap<String, Object>();
				Map<String,Object> mapNew = getBloodSugerMaxOrMinOrAvgData(suger1,null);
				BigDecimal value = (BigDecimal)mapNew.get("avgSugerValue");
				map.put("avgSugerValue", value);
				map.put("testPeriod", 1);
				map.put("testName", "早晨空腹");
				mapList.add(map);
				avgBS.add(value);
			}
			if(suger2 != null && suger2.size() > 0){
				Map<String,Object> map = new HashMap<String, Object>();
				Map<String,Object> mapNew = getBloodSugerMaxOrMinOrAvgData(suger2,null);
				BigDecimal value = (BigDecimal)mapNew.get("avgSugerValue");
				map.put("avgSugerValue", value);
				map.put("testPeriod", 2);
				map.put("testName", "早餐后2小时");
				mapList.add(map);
				avgBS.add(value);
			}
			if(suger3 != null && suger3.size() > 0){
				Map<String,Object> map = new HashMap<String, Object>();
				Map<String,Object> mapNew = getBloodSugerMaxOrMinOrAvgData(suger3,null);
				BigDecimal value = (BigDecimal)mapNew.get("avgSugerValue");
				map.put("avgSugerValue", value);
				map.put("testPeriod", 3);
				map.put("testName", "午餐前");
				mapList.add(map);
				avgBS.add(value);
			}
			if(suger4 != null && suger4.size() > 0){
				Map<String,Object> map = new HashMap<String, Object>();
				Map<String,Object> mapNew = getBloodSugerMaxOrMinOrAvgData(suger4,null);
				BigDecimal value = (BigDecimal)mapNew.get("avgSugerValue");
				map.put("avgSugerValue", value);
				map.put("testPeriod", 4);
				map.put("testName", "午餐后2小时");
				mapList.add(map);
				avgBS.add(value);
			}
			if(suger5 != null && suger5.size() > 0){
				Map<String,Object> map = new HashMap<String, Object>();
				Map<String,Object> mapNew = getBloodSugerMaxOrMinOrAvgData(suger5,null);
				BigDecimal value = (BigDecimal)mapNew.get("avgSugerValue");
				map.put("avgSugerValue", value);
				map.put("testPeriod", 5);
				map.put("testName", "晚餐前");
				mapList.add(map);
				avgBS.add(value);
			}
			if(suger6 != null && suger6.size() > 0){
				Map<String,Object> map = new HashMap<String, Object>();
				Map<String,Object> mapNew = getBloodSugerMaxOrMinOrAvgData(suger6,null);
				BigDecimal value = (BigDecimal)mapNew.get("avgSugerValue");
				map.put("avgSugerValue", value);
				map.put("testPeriod", 6);
				map.put("testName", "晚餐后2小时");
				mapList.add(map);
				avgBS.add(value);
			}
			if(suger7 != null && suger7.size() > 0){
				Map<String,Object> map = new HashMap<String, Object>();
				Map<String,Object> mapNew = getBloodSugerMaxOrMinOrAvgData(suger7,null);
				BigDecimal value = (BigDecimal)mapNew.get("avgSugerValue");
				map.put("avgSugerValue", value);
				map.put("testPeriod", 7);
				map.put("testName", "睡觉前");
				mapList.add(map);
				avgBS.add(value);
			}
			if(suger8 != null && suger8.size() > 0){
				Map<String,Object> map = new HashMap<String, Object>();
				Map<String,Object> mapNew = getBloodSugerMaxOrMinOrAvgData(suger8,null);
				BigDecimal value = (BigDecimal)mapNew.get("avgSugerValue");
				map.put("avgSugerValue", value);
				map.put("testPeriod", 8);
				map.put("testName", "夜间");
				mapList.add(map);
				avgBS.add(value);
			}
			
			/* 所有测量时间段平均血糖的平均值  begin */
			if(avgBS != null && avgBS.size() > 0){
				Object[] arrAvg = avgBS.toArray();
				Arrays.sort(arrAvg);
				int size = arrAvg.length;
				BigDecimal totalAvgSuger = BigDecimal.ZERO;
				if(arrAvg != null && arrAvg.length > 0){
					for(Object object : arrAvg){
						totalAvgSuger = totalAvgSuger.add((BigDecimal)object);
					}
				}
				double size1 = size;
				BigDecimal realSize = BigDecimal.valueOf(size1);
				BigDecimal avgSuger = totalAvgSuger.divide(realSize,1, BigDecimal.ROUND_HALF_UP);
				Map<String,Object> mapNew = new HashMap<String, Object>();
				mapNew.put("avgSuger", avgSuger);
				mapNew.put("testName", "血糖平均值");
				mapList.add(mapNew);
			}
			/* 所有测量时间段平均血糖的平均值  end */
		}
		return mapList;
	}
	
	/**
	 * @Description: 血糖异常统计
	 * @author:      liuxiaoqin
	 * @version      V1.0  
	 * @Createdate:  2016年9月6日 
	 */
	public List<Map<String,Object>> getAbnormalSugerData(List<Obsr> list)throws Exception{
		List<Map<String,Object>> mapList = new ArrayList<Map<String,Object>>();
		List<Obsr> list0 = new ArrayList<Obsr>();
		List<Obsr> list1 = new ArrayList<Obsr>();
		List<Obsr> list2 = new ArrayList<Obsr>();
		List<Obsr> list3 = new ArrayList<Obsr>();
		List<Obsr> list4 = new ArrayList<Obsr>();
		List<Obsr> list5 = new ArrayList<Obsr>();
		List<Obsr> list6 = new ArrayList<Obsr>();
		List<Obsr> list7 = new ArrayList<Obsr>();
		List<Obsr> list8 = new ArrayList<Obsr>();
		int lowTimes0 = 0;
		int highTimes0 = 0;
		int lowTimes1 = 0;
		int highTimes1 = 0;
		int lowTimes2 = 0;
		int highTimes2 = 0;
		int lowTimes3 = 0;
		int highTimes3 = 0;
		int lowTimes4 = 0;
		int highTimes4 = 0;
		int lowTimes5 = 0;
		int highTimes5 = 0;
		int lowTimes6 = 0;
		int highTimes6 = 0;
		int lowTimes7 = 0;
		int highTimes7 = 0;
		int lowTimes8 = 0;
		int highTimes8 = 0;
		if(list != null && list.size() > 0){
			for(Obsr obsr : list){
				String timePeriod = obsr.getTimeperiod();
				String analysisResult = obsr.getAnalysisresult();
				if(timePeriod.equals("0")){
					list0.add(obsr);
					if(analysisResult.equals("1")){
						lowTimes0 += 1;
					}else if(analysisResult.equals("2")){
						highTimes0 += 1;
					}
				}else if(timePeriod.equals("1")){
					list1.add(obsr);
					if(analysisResult.equals("1")){
						lowTimes1 += 1;
					}else if(analysisResult.equals("2")){
						highTimes1 += 1;
					}
				}else if(timePeriod.equals("2")){
					list2.add(obsr);
					if(analysisResult.equals("1")){
						lowTimes2 += 1;
					}else if(analysisResult.equals("2")){
						highTimes2 += 1;
					}
				}else if(timePeriod.equals("3")){
					list3.add(obsr);
					if(analysisResult.equals("1")){
						lowTimes3 += 1;
					}else if(analysisResult.equals("2")){
						highTimes3 += 1;
					}
				}else if(timePeriod.equals("4")){
					list4.add(obsr);
					if(analysisResult.equals("1")){
						lowTimes4 += 1;
					}else if(analysisResult.equals("2")){
						highTimes4 += 1;
					}
				}else if(timePeriod.equals("5")){
					list5.add(obsr);
					if(analysisResult.equals("1")){
						lowTimes5 += 1;
					}else if(analysisResult.equals("2")){
						highTimes5 += 1;
					}
				}else if(timePeriod.equals("6")){
					list6.add(obsr);
					if(analysisResult.equals("1")){
						lowTimes6 += 1;
					}else if(analysisResult.equals("2")){
						highTimes6 += 1;
					}
				}else if(timePeriod.equals("7")){
					list7.add(obsr);
					if(analysisResult.equals("1")){
						lowTimes7 += 1;
					}else if(analysisResult.equals("2")){
						highTimes7 += 1;
					}
				}else if(timePeriod.equals("8")){
					list8.add(obsr);
					if(analysisResult.equals("1")){
						lowTimes8 += 1;
					}else if(analysisResult.equals("2")){
						highTimes8 += 1;
					}
				}
			}
		}
		if(list0 != null && list0.size() > 0){
			Map<String,Object> map = new HashMap<String, Object>();
			Double highPercent = (double)highTimes0/(list0.size())*100;
			Double lowPercent = (double)lowTimes0/(list0.size())*100;
			map.put("lowTimes", lowTimes0);
			map.put("highTimes", highTimes0);
			map.put("highPercent", highPercent);
			map.put("lowPercent", lowPercent);
			map.put("testName", "随机");
			mapList.add(map);
		}
		if(list1 != null && list1.size() > 0){
			Map<String,Object> map = new HashMap<String, Object>();
			Double highPercent = (double)highTimes1/(list1.size())*100;
			Double lowPercent = (double)lowTimes1/(list1.size())*100;
			map.put("lowTimes", lowTimes1);
			map.put("highTimes", highTimes1);
			map.put("highPercent", highPercent);
			map.put("lowPercent", lowPercent);
			map.put("testName", "早晨空腹");
			mapList.add(map);
		}
		if(list2 != null && list2.size() > 0){
			Map<String,Object> map = new HashMap<String, Object>();
			Double highPercent = (double)highTimes2/(list2.size())*100;
			Double lowPercent = (double)lowTimes2/(list2.size())*100;
			map.put("lowTimes", lowTimes2);
			map.put("highTimes", highTimes2);
			map.put("highPercent", highPercent);
			map.put("lowPercent", lowPercent);
			map.put("testName", "早餐后2小时");
			mapList.add(map);
		}
		if(list3 != null && list3.size() > 0){
			Map<String,Object> map = new HashMap<String, Object>();
			Double highPercent = (double)highTimes3/(list3.size())*100;
			Double lowPercent = (double)lowTimes3/(list3.size())*100;
			map.put("lowTimes", lowTimes3);
			map.put("highTimes", highTimes3);
			map.put("highPercent", highPercent);
			map.put("lowPercent", lowPercent);
			map.put("testName", "午餐前");
			mapList.add(map);
		}
		if(list4 != null && list4.size() > 0){
			Map<String,Object> map = new HashMap<String, Object>();
			Double highPercent = (double)highTimes4/(list4.size())*100;
			Double lowPercent = (double)lowTimes4/(list4.size())*100;
			map.put("lowTimes", lowTimes4);
			map.put("highTimes", highTimes4);
			map.put("highPercent", highPercent);
			map.put("lowPercent", lowPercent);
			map.put("testName", "午餐后2小时");
			mapList.add(map);
		}
		if(list5 != null && list5.size() > 0){
			Map<String,Object> map = new HashMap<String, Object>();
			Double highPercent = (double)highTimes5/(list5.size())*100;
			Double lowPercent = (double)lowTimes5/(list5.size())*100;
			map.put("lowTimes", lowTimes5);
			map.put("highTimes", highTimes5);
			map.put("highPercent", highPercent);
			map.put("lowPercent", lowPercent);
			map.put("testName", "晚餐前");
			mapList.add(map);
		}
		if(list6 != null && list6.size() > 0){
			Map<String,Object> map = new HashMap<String, Object>();
			Double highPercent = (double)highTimes6/(list6.size())*100;
			Double lowPercent = (double)lowTimes6/(list6.size())*100;
			map.put("lowTimes", lowTimes6);
			map.put("highTimes", highTimes6);
			map.put("highPercent", highPercent);
			map.put("lowPercent", lowPercent);
			map.put("testName", "晚餐后2小时");
			mapList.add(map);
		}
		if(list7 != null && list7.size() > 0){
			Map<String,Object> map = new HashMap<String, Object>();
			Double highPercent = (double)highTimes7/(list7.size())*100;
			Double lowPercent = (double)lowTimes7/(list7.size())*100;
			map.put("lowTimes", lowTimes7);
			map.put("highTimes", highTimes7);
			map.put("highPercent", highPercent);
			map.put("lowPercent", lowPercent);
			map.put("testName", "睡觉前");
			mapList.add(map);
		}
		if(list8 != null && list8.size() > 0){
			Map<String,Object> map = new HashMap<String, Object>();
			Double highPercent = (double)highTimes8/(list8.size())*100;
			Double lowPercent = (double)lowTimes8/(list8.size())*100;
			map.put("lowTimes", lowTimes8);
			map.put("highTimes", highTimes8);
			map.put("highPercent", highPercent);
			map.put("lowPercent", lowPercent);
			map.put("testName", "夜间");
			mapList.add(map);
		}
		return mapList;
	}
	
	/**
	 * @Description: 获取血糖各个时间段的最大值，最小值,时间
	 * @author:      liuxiaoqin
	 * @version      V1.0  
	 * @Createdate:  2016年9月6日 
	 */
	public Map<String,Object> getBloodSugerMaxOrMinOrAvgData(List<Double> suger,List<Date> date)throws Exception{
		Map<String,Object> map = new HashMap<String, Object>();
		if(date != null){
			Object[] arr = suger.toArray();
			Object[] arrTime = date.toArray();
			Arrays.sort(arr);
			Arrays.sort(arrTime);
			int size = arr.length;
			Double max = (Double)arr[size-1];
			Double min = (Double)arr[size-1];
			String newTime =  TimeUtil.formatDatetime2((Date)arrTime[size-1]);
			map.put("testTime", newTime);
			map.put("maxValue", max);
			map.put("minValue", min);
		}else{
			Object[] arr = suger.toArray();
			Arrays.sort(arr);
			int size = arr.length;
			Double totalAvgSugerValue = 0D;
			if(arr != null && arr.length > 0){
				for(Object object : arr){
					totalAvgSugerValue += (Double)object;
				}
			}
			BigDecimal realAvgSugerValue = BigDecimal.valueOf(totalAvgSugerValue);
			BigDecimal realSize= BigDecimal.valueOf(size);
			BigDecimal avgSugerValue = realAvgSugerValue.divide(realSize,1, BigDecimal.ROUND_HALF_UP);
			map.put("avgSugerValue", avgSugerValue);
		}
		return map;
	}
	
	/**
	 * @Description: 获取血糖所有记录值 
	 * @author:      liuxiaoqin
	 * @version      V1.0  
	 * @Createdate:  2016年9月10日 
	 */
	public List<Map<String,Object>> getBloodSugerRecordList(List<Obsr> list)throws Exception{
		List<Map<String,Object>> mapList = new ArrayList<Map<String,Object>>();
		for(Obsr obsr : list){
			Map<String,Object> map = new HashMap<String, Object>();
			String timePeriod = obsr.getTimeperiod();
			String timePeriodStr = MeasureController.convertTimePeriod(Integer.valueOf(timePeriod),2);
			Double sugerValue = obsr.getBsvalue();
			Date date = obsr.getTesttime();
			if(date != null){
				map.put("testTime", TimeUtil.formatDatetime2(date));
			}
			String abnormal = obsr.getAnalysisresult();
			//是否偏高2，偏低1，正常0
			Integer isHighOrLow = 0;
			if(!StringUtils.isEmpty(abnormal)){
				//分析结果值(1:血糖偏低;2:血糖偏高;0：正常)
				if(Integer.valueOf(abnormal)== 0){
					isHighOrLow = 0;
				}else if(Integer.valueOf(abnormal)== 1){
					isHighOrLow = 1;
				}else{
					isHighOrLow = 2;
				}
			}
			map.put("timePeriodStr",timePeriodStr);
			map.put("sugerValue",sugerValue);
			map.put("isHighOrLow",isHighOrLow);
			mapList.add(map);
		}
		return mapList;
	}
	
	/**
	 * @Description: 获取mini心电详情值 
	 * @author:      liuxiaoqin
	 * @version      V1.0  
	 * @Createdate:  2016年8月19日 
	 */
	public Map<String,Object> getMiniReportData(List<Oecg> list)throws Exception{
		Map<String,Object> map = new HashMap<String, Object>();
		if(list != null && list.size() > 0){
			map.put("miniRecordList", getMiniAllData(list,1));
			map.put("totalRecord", list.size());
			map.put("abnEcgChartList", getMiniAllData(list,2));
			map.put("abnEcglist", getMiniAllData(list,3));
		}
		return map;
	}
	
	/**
	 * @Description: 所有心电主数据
	 * @author:      liuxiaoqin
	 * @version      V1.0  
	 * @Createdate:  2016年9月6日 
	 */
	public List<Map<String,Object>> getMiniAllData(List<Oecg> list,Integer dataType)throws Exception{
		List<Map<String,Object>> miniRecordList = new ArrayList<Map<String,Object>>();
		List<Map<String,Object>> abnEcgChartList = new ArrayList<Map<String,Object>>();
		List<Map<String,Object>> abnEcglist = new ArrayList<Map<String,Object>>();
		for(Oecg oecg : list){
			Map<String,Object> miniRecord = new HashMap<String, Object>();
			Date date = oecg.getMeastime();
			String testTime = "";
			String testDate = "";
			String testMinute = "";
			if(date != null){
				testTime = TimeUtil.formatDatetime2(date);
				testDate = TimeUtil.formatDate(date);
				testMinute = TimeUtil.formatTime(date);
				miniRecord.put("testTime", testTime);
			}
			miniRecord.put("avgHeartRate", oecg.getAverageheart());
			long id = oecg.getDocentry();
			List<String> abnNames = new ArrayList<String>();
			int abnCount = 0;
			List<Ecg2> ecg2List = ecg2Service.selectEcg2ListByDocentry(id);
			if(ecg2List != null && ecg2List.size() > 0){
				for(Ecg2 ecg2 :ecg2List ){
					Map<String,Object> abnEcgChart = new HashMap<String, Object>();
					Map<String,Object> abnEcg = new HashMap<String, Object>();
					String abnormalName = ecg2.getAbnname();
					String realCNName = MessageUtil.getValue("abnEcgTypeName."+abnormalName);
					/*ecg1 detail begin*/
					List<Ecg1> ecg1List = findAnomalyEcgbyId(id,abnormalName);
					List<Map<String,Object>> mapAbnDetailList = new ArrayList<Map<String,Object>>();
					if(ecg1List != null && ecg1List.size() > 0){
						for(Ecg1 ecg1 : ecg1List){
							Map<String,Object> mapAbnDetail = new HashMap<String, Object>();
							mapAbnDetail.put("abnormalDocentry", ecg1.getDocentry());
							mapAbnDetail.put("abnormalFileId", ecg1.getObjectid());
							mapAbnDetail.put("abnormalAppearTime", ecg1.getAbecgtime());
							mapAbnDetail.put("abnormalType", realCNName);
							mapAbnDetailList.add(mapAbnDetail);
						}
					}
					/*ecg1 detail end*/
					abnNames.add(realCNName);
					String chartAbnName = realCNName + "异常心电图" + Constants.LEFT_BRACKET + ecg1List.size() + Constants.RIGHT_BRACKET;
					abnEcgChart.put("chartAbnName", chartAbnName);
					abnEcgChart.put("chartAbnData", mapAbnDetailList);
					abnEcgChart.put("chartAbnCount", ecg1List.size());
					abnEcgChartList.add(abnEcgChart);
					abnEcg.put("date", testDate);
					abnEcg.put("time", testMinute);
					abnEcg.put("name", realCNName);
					abnEcg.put("analysisResult", "0%");
					abnEcg.put("abnCount", ecg1List.size());
					abnEcglist.add(abnEcg);
				}
				abnCount = ecg2List.size();
			}
			String abnNameStr = StringUtils.collectionToDelimitedString(abnNames, " ");
			if(abnCount > 0){
				String abnNameDesc =  ":" + abnNameStr;
				miniRecord.put("abnSituation", abnNameDesc);
			}else{
				miniRecord.put("abnSituation", abnNameStr);
			}
			miniRecord.put("abnCount", abnCount);
			miniRecordList.add(miniRecord);
		}
		/* 1miniRecord;2abnEcgChart;3abnEcg */
		if(dataType == 1){
			return miniRecordList;
		}else if(dataType == 2){
			return abnEcgChartList;
		}else{
			return abnEcglist;
		}
	}
	
	/**
	 * @Description: 获取心电异常数据
	 * @author:      liuxiaoqin
	 * @param        
	 * @version      V1.0  
	 * @Createdate:  2016年8月29日 
	 */
	public List<Ecg1> findAnomalyEcgbyId(long docentry, String name)throws Exception {
		List<Ecg1> ecg1List = new ArrayList<Ecg1>();
		String abnTypeName = getAbnTypeName(name);
		Ecg1Example example = new Ecg1Example();
		com.bithealth.measureCore.electrocardio.model.Ecg1Example.Criteria criteria = example.createCriteria();
		criteria.andDocentryEqualTo(docentry);
		criteria.andAbecgtypeLike("%"+abnTypeName+"%");
		ecg1List = ecg1Service.selectByExample(example);
		return ecg1List;
	}
	
	/**
	 * @Description: 获取心电异常类型名
	 * @author:      liuxiaoqin
	 * @param        
	 * @version      V1.0  
	 * @Createdate:  2016年8月29日 
	 */
	private String getAbnTypeName(String name)throws Exception{
		if ("Polycardia".equals(name)) {
			name = "ST";
		} else if ("Bradycardia".equals(name)) {
			name = "SB";
		} else if ("Arrest".equals(name)) {
			name = "SA";
		} else if ("Missed".equals(name)) {
			name = "MB";
		} else if ("Wide".equals(name)) {
			name = "WS";
		} else if ("PVB".equals(name)) {
			name = "VPB";
		} else if ("PAB".equals(name)) {
			name = "APB";
		} else if ("Insert_PVB".equals(name)) {
			name = "IVBP";
		} else if ("VT".equals(name)) {
			name = "VT";
		} else if ("Bigeminy".equals(name)) {
			name = "BG";
		} else if ("Trigeminy".equals(name)) {
			name = "TRG";
		} else if ("Arrhythmia".equals(name)) {
			name = "AR";
		}
		return name;
	}
	
	/**
	 * @Description: 获取三合一详情值 
	 * @author:      liuxiaoqin
	 * @version      V1.0  
	 * @Createdate:  2016年8月19日 
	 */
	public Map<String,Object> getThreeInOneReportData(List<Oecg> OecgList)throws Exception{
		Map<String,Object> map = new HashMap<String, Object>();
		if(OecgList != null && OecgList.size() > 0 ){
			map.put("ThreeInOneRecordList", getThreeInOneAllData(OecgList));
			map.put("totalRecord", OecgList.size());
			map.put("abnEcgChartList", getMiniAllData(OecgList,2));
			map.put("abnEcglist", getMiniAllData(OecgList,3));
			map.put("abnOppglist", getAbnOppgData(OecgList));
		}
		return map;
	}
	
	/**
	 * @Description: 所有三合一数据
	 * @author:      liuxiaoqin
	 * @version      V1.0  
	 * @Createdate:  2016年9月6日 
	 */
	public List<Map<String,Object>> getThreeInOneAllData(List<Oecg> OecgList)throws Exception{
		List<Map<String,Object>> threeInOneList = new ArrayList<Map<String,Object>>();
		for(Oecg oecg : OecgList){
			Map<String,Object> map = new HashMap<String, Object>();
			Date date = oecg.getMeastime();
			String testTime = "";
			if(date != null){
				testTime = TimeUtil.formatDatetime2(date);
				map.put("testTime", testTime);
			}
			map.put("avgHeartRate", oecg.getAverageheart());
			long eventId = oecg.getEventid();
			Oppg oppg = pulseService.selectElectrocardioPulseByEventId(eventId);
			if(oppg != null){
				map.put("avgPluseRate",oppg.getPulserate());
				map.put("spo", oppg.getSpo());
			}
			threeInOneList.add(map);
		}
		return threeInOneList;
	}
	
	/**
	 * @Description: 所有异常脉搏数据
	 * @author:      liuxiaoqin
	 * @version      V1.0  
	 * @Createdate:  2016年9月6日 
	 */
	public List<Map<String,Object>> getAbnOppgData(List<Oecg> OecgList)throws Exception{
		List<Map<String,Object>> oppgList = new ArrayList<Map<String,Object>>();
		for(Oecg oecg : OecgList){
			Date date = oecg.getMeastime();
			String testTime = "";
			String testDate = "";
			String testMinute = "";
			if(date != null){
				testTime = TimeUtil.formatDatetime2(date);
				testDate = TimeUtil.formatDate(date);
				testMinute = TimeUtil.formatTime(date);
			}
			long eventId = oecg.getEventid();
			Oppg oppg = pulseService.selectElectrocardioPulseByEventId(eventId);
			if(oppg != null){
				List<Map<String,Object>> mapList = MeasureController.getAbnormalOppgDataList(oppg);
				if(mapList != null && mapList.size() >0){
					for(Map<String,Object> map : mapList){
						Map<String,Object> mapNew = new HashMap<String, Object>();
						mapNew.put("testTime", testTime);
						mapNew.put("testDate", testDate);
						mapNew.put("testMinute", testMinute);
						String abnormalName = (String)map.get("abnormalName");
						String abnName = transformOppgAbnName(abnormalName);
						mapNew.put("abnName", abnName);
						mapNew.put("mesaValue",  map.get("abnormalValue"));
						String abnormalDesc = String.valueOf(map.get("abnormalDesc"));
						String result = transformOppgResult(abnormalDesc);
						mapNew.put("result", result);
						oppgList.add(mapNew);
					}
				}
			}
		}
		return oppgList;
	}
	
	/**
	 * @Description: 转换脉搏异常名为中文
	 * @author:      liuxiaoqin
	 * @version      V1.0  
	 * @Createdate:  2016年9月6日 
	 */
	public String transformOppgAbnName(String name)throws Exception{
		String realName = "";
		if(name.equals("pulserate")){
			realName = "平均脉率";
		}else if(name.equals("co")){
			realName = "射血量";
		}else if(name.equals("sv")){
			realName = "心脏每搏射血量";
		}else if(name.equals("spo")){
			realName = "血氧饱和度";
		}else if(name.equals("ci")){
			realName = "心指数";
		}else if(name.equals("spi")){
			realName = "心搏指数";
		}else if(name.equals("k")){
			realName = "波形特征量";
		}else if(name.equals("v")){
			realName = "血液黏度";
		}else if(name.equals("tpr")){
			realName = "外周阻力";
		}else if(name.equals("ac")){
			realName = "血管顺应度";
		}else if(name.equals("pm")){
			realName = "平均动脉压";
		}else if(name.equals("si")){
			realName = "血管硬化指数";
		}
		return realName;
	}
	
	/**
	 * @Description: 转换脉搏异常结果为中文
	 * @author:      liuxiaoqin
	 * @version      V1.0  
	 * @Createdate:  2016年9月6日 
	 */
	public String transformOppgResult(String name)throws Exception{
		/* 偏低1；偏高2 ；0正常*/
		String realName = "";
		if(name.equals("1")){
			realName = "偏低";
		}else if(name.equals("2")){
			realName = "偏高";
		}else{
			realName = "正常";
		}
		return realName;
	}
	
}
