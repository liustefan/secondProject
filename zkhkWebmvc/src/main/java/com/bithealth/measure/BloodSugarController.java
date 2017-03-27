 
/**
 * @PackageName:      com.bithealth.measure
 * @FileName:     BloodSugarController.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      陈哲 
 * @version      V1.0  
 * @Createdate:  2016年7月20日 上午9:44:40  
 * 
 */

package com.bithealth.measure;

import java.io.IOException;
import java.net.URLDecoder;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bithealth.measureCore.bloodSugar.model.Obsr;
import com.bithealth.measureCore.bloodSugar.model.ObsrOmemVO;
import com.bithealth.measureCore.bloodSugar.service.BloodSugarService;
import com.bithealth.measureCore.common.model.Omds;
import com.bithealth.measureCore.enmu.BloodSugarExcType;
import com.bithealth.measureCore.enmu.BloodSugarTimeQType;
import com.bithealth.measureCore.facade.Facade;
import com.bithealth.memberCore.member.model.Member;
import com.bithealth.memberCore.member.model.MemberExt;
import com.bithealth.memberCore.member.service.MemberService;
import com.bithealth.printCore.service.ExportWordService;
import com.bithealth.reportCore.facade.service.ReportIFService;
import com.bithealth.sdk.common.utils.TimeUtil;
import com.bithealth.sdk.core.feature.orm.mybatis.Page;
import com.bithealth.sdk.web.controller.BaseSpringController;


/**
 * 类名称: BloodSugarController  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年7月20日 上午9:44:40 
 * 
 * @author 陈哲
 * @version  
 */
@Controller
@RequestMapping("/bloodSugar")
public class BloodSugarController extends BaseSpringController{
	@Autowired
	private BloodSugarService bloodSugarService;
	
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private Facade chartService;
	
	@Autowired
	private ReportIFService reportIFService;
	
	@Autowired
	private ExportWordService exportWordService;
	
	
	/**
	 * @Title:showBloodPressPage 
	 * @Description:某医生下会员的血糖信息 
	 * @author 陈哲
	 * @param model
	 * @param wheAbnTag
	 * @param pageNo
	 * @param pageSize
	 * @param docid
	 * @param criteria
	 * @return
	 * @throws Exception 
	 * @throws
	 * @retrun String
	 */
	@RequestMapping(value="/queryBloodSugar",method=RequestMethod.GET)
	public String showBloodPressPage(Model model,String wheAbnTag, Integer pageNo, Integer pageSize, Integer docid, String criteria) {
		//解决中文乱码
		if(criteria != null){
			try {
				criteria = URLDecoder.decode(criteria,"UTF-8");
			} catch (Exception e) {
				e.printStackTrace();
				return "/measure/showMemberObsrMeasureInfoByDocid";
			}
		}
		
		if(pageNo == null){
			pageNo = 1;
		}
		
		if(pageSize == null){
			pageSize = 10;
		}
		Page<ObsrOmemVO> page = bloodSugarService.selectBloodSugarAndMemListPage(pageNo, pageSize, criteria, docid, wheAbnTag);
		model.addAttribute("page",page);
		model.addAttribute("criteria",criteria);
		model.addAttribute("wheAbnTag",wheAbnTag);
		
		return "/measure/showMemberObsrMeasureInfoByDocid";
	}
	
	
	/**
	 * @Title:deleteBloodSugarInfo 
	 * @Description:删除单个血糖信息（逻辑删除）
	 * @author 陈哲
	 * @param docentry
	 * @return 
	 * @throws
	 * @retrun String
	 */
	@RequestMapping(value="/deleteBloodSugarInfo")
	public String deleteBloodSugarInfo(Long docentry){
		bloodSugarService.deleteBloodSugarByDocentry(docentry);
		
		return "forward:queryBloodSugar";
	}
	
	
	/**
	 * @Title:deleteBatchBloodSugarInfo 
	 * @Description:批量删除血压信息（逻辑删除）  
	 * @author 陈哲
	 * @param parameter
	 * @return 
	 * @throws
	 * @retrun String
	 */
	@RequestMapping(value="/deleteBatchBloodSugarInfo")
	public String deleteBatchBloodSugarInfo(String parameter){
		List<Long> docentryList = new ArrayList<Long>();
		String[] strs = parameter.split(",");
		for(String str : strs){
			docentryList.add(Long.valueOf(str));
		}
		
		bloodSugarService.deleteBatchBloodSugarByDocentry(docentryList);
		
		return "forward:queryBloodSugar";
	}
	
	
	/**
	 * @Title:showSingleBloodSugar 
	 * @Description:单个血糖信息  
	 * @author 陈哲
	 * @param request
	 * @return 
	 * @throws
	 * @retrun String
	 * @throws Exception 
	 */
	@RequestMapping(value="/showSingleBloodSugar",method=RequestMethod.GET)
	public String showSingleBloodSugar(Model model, Integer memberId, Long eventId, Integer pageNo, Integer flag) {
		if(pageNo == null){
			pageNo = 0;
		}
		
		//血糖页面有两个入口，分别是会员管理和测量管理，flag用来标记是哪个入口，值为1标识会员管理
		model.addAttribute("flag", flag);
		
		Member member = memberService.selectById(memberId);
		model.addAttribute("omem", member);
		int age = 0;
		try {
			age = TimeUtil.getAge(member.getBirthdate());
			model.addAttribute("age", age);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		List<Omds> omdsList = bloodSugarService.selectMeasureRecordListByObsr(memberId);
		Omds omds = null;
		
		if(eventId != null){
			pageNo = -1;
			for(Omds om : omdsList){
				pageNo++;
				if(om.getEventid().equals(eventId)){
					omds = om;
					break;
				}
			}
		}else{
			if(omdsList == null || omdsList.isEmpty()){
				return "/measure/singleXueTang";
			}
			omds = omdsList.get(pageNo);
		}
		
		Obsr obsr = null;
		if(omds != null){
			obsr = bloodSugarService.selectBloodSugarByEventId(omds.getEventid());
		}
		
		model.addAttribute("pageNo", pageNo);
		model.addAttribute("total", omdsList.size());
		model.addAttribute("obsr", obsr);
		return "/measure/singleXueTang";
	}
	
	
	/**
	 * @Title:showAllBloodSugar 
	 * @Description:某医生下单个会员的所有血糖测量信息 
	 * @author 陈哲
	 * @param model
	 * @param memberId
	 * @param eventId
	 * @param pageNo
	 * @param pageSize
	 * @param timePeriod
	 * @param startTime
	 * @param endTime
	 * @return 
	 * @throws
	 * @retrun String
	 * @throws Exception 
	 */
	@RequestMapping(value="/showAllBloodSugar",method=RequestMethod.GET)
	public String showAllBloodSugar(Model model, Integer memberId,
			Long eventId, Integer pageNo, Integer pageSize, String timePeriod,
			Date startTime, Date endTime, Integer flag) {
		if(pageNo == null){
			pageNo = 1;
		}
		
		if(pageSize == null){
			pageSize = 10;
		}
		
		//血糖页面有两个入口，分别是会员管理和测量管理，flag用来标记是哪个入口，值为1标识会员管理
		model.addAttribute("flag", flag);
		
		//日期处理
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		if(startTime != null){
			//日期类型数据回显
			model.addAttribute("startTime", sdf.format(startTime));
		}
		
		Date endTime_ = null;
		if(endTime != null){
			//endTime加一天
			Calendar cal = Calendar.getInstance();
			cal.setTime(endTime);
			cal.add(Calendar.DATE, 1);
			endTime_ = cal.getTime();
			
			//日期类型数据回显
			model.addAttribute("endTime", sdf.format(endTime));
		}
		
		//获取会员信息
		Member member = memberService.selectById(memberId);
		int age = 0;
		try {
			age = TimeUtil.getAge(member.getBirthdate());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Page<Obsr> page = bloodSugarService.selectBloodSugarAndPage(memberId,pageNo,pageSize,startTime,endTime_, timePeriod);
		
		JSONObject object = getBloodSugarTrenJsonData(page.getResult());
		
		String jsonArr = JSONArray.toJSONString(page.getResult());
		
		List<Obsr> maxObsr = null;
		List<Obsr> minObsr = null;
		if(page.getResult() != null && !page.getResult().isEmpty()){
			maxObsr = bloodSugarService.selectBloodSugarMaxValue(memberId, startTime, endTime_, timePeriod);
			minObsr = bloodSugarService.selectBloodSugarMinValue(memberId, startTime, endTime_, timePeriod);
			
			model.addAttribute("maxObsr", maxObsr.get(0));
			model.addAttribute("minObsr", minObsr.get(0));
		}
		
		model.addAttribute("page", page);
		model.addAttribute("timePeriod",timePeriod);
		model.addAttribute("omem", member);
		model.addAttribute("age", age);
		model.addAttribute("eventId", eventId);
		model.addAttribute("json", object);
		model.addAttribute("jsonArr", jsonArr);
		
		return "/measure/allXueTang";
	}
	
	
	/**
	 * @Title:getBloodSugarTrenJsonData 
	 * @Description:某医生下会员血糖趋势图json数据 
	 * @author 陈哲
	 * @param obsrs
	 * @return 
	 * @throws
	 * @retrun JSONObject
	 */
	private JSONObject getBloodSugarTrenJsonData(List<Obsr> obsrs){
		JSONArray kongfu = new JSONArray();//空腹
		JSONArray beforeDinner = new JSONArray();//饭前
		JSONArray afterDinner = new JSONArray();//饭后
		JSONArray random = new JSONArray();//随机
		
		JSONObject object = new JSONObject();
		Obsr obsr = null;
		if (null != obsrs && !obsrs.isEmpty()) {
			for (int i = obsrs.size()-1; i >=0; i--) {
				obsr = obsrs.get(i);
				//time.add(format.format(obsr.getTestTime().getTime()));
				JSONObject json = new JSONObject();
				json.put("time",obsr.getTesttime().getTime());
				json.put("value",obsr.getBsvalue());
				
				if("1".equals(obsr.getTimeperiod())){
					kongfu.add(json);
				}else if("3".equals(obsr.getTimeperiod()) || "5".equals(obsr.getTimeperiod())){
					beforeDinner.add(json);
				}else if("2".equals(obsr.getTimeperiod()) || "4".equals(obsr.getTimeperiod()) || "6".equals(obsr.getTimeperiod())){
					afterDinner.add(json);
				}else if("0".equals(obsr.getTimeperiod()) || "7".equals(obsr.getTimeperiod()) || "8".equals(obsr.getTimeperiod())){
					random.add(json);
				}
			}
			
			object.put("kongfu", kongfu);
			object.put("beforeDinner", beforeDinner);
			object.put("afterDinner", afterDinner);
			object.put("random", random);
		}
		return object;
	}
	
	
	/**
	 * @Title:showSingleBloodSugarInfo 
	 * @Description:血糖弹出框信息
	 * @author 陈哲
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws
	 * @retrun void
	 */
	@ResponseBody
	@RequestMapping(value="/showSingleBloodSugarInfo", produces="plain/text;charset=UTF-8")
	public String showSingleBloodSugarInfo(Long docentry) {
		Obsr obsr = bloodSugarService.selectBloodSugarOneByDocentry(docentry);

		JSONObject jsonObject = new JSONObject();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		jsonObject.put("uploadTime", sdf.format(obsr.getUploadtime()));
		jsonObject.put("testTime", sdf.format(obsr.getTesttime()));
		jsonObject.put("bsValue", obsr.getBsvalue() + "");
		jsonObject.put("analysisResult", BloodSugarExcType.getExcTypeName(Integer.valueOf(obsr.getAnalysisresult())));
		jsonObject.put("timePeriod", BloodSugarTimeQType.getTimeQTypeName(Integer.valueOf(obsr.getTimeperiod())));
		
		return jsonObject.toString();
	}
	
	public void getReportData(ModelMap model, String obsrsJson,Integer memberid){
		List<Obsr> obsrs = JSONObject.parseArray(obsrsJson, Obsr.class);
		
		//计算血压测量数据测量时间段
		Date startMeasureTime = null;
		Date endMeasureTime = null;
		int recordDay = 0;
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(obsrs.get(0).getTesttime());
		int day_0 = calendar.get(Calendar.DAY_OF_YEAR);
		
		for(Obsr obsr : obsrs){
			if(startMeasureTime == null && endMeasureTime == null){
				startMeasureTime = obsr.getTesttime();
				endMeasureTime = obsr.getTesttime();
				continue;
			}
			
			if(startMeasureTime.after(obsr.getTesttime())){
				startMeasureTime = obsr.getTesttime();
			}else{
				endMeasureTime = obsr.getTesttime();
			}
			
			calendar.setTime(obsr.getTesttime());
			int day = calendar.get(Calendar.DAY_OF_YEAR);
			if(day_0 - day != 0){
				recordDay++;
				day_0 = day;
			}
		}
		
		model.addAttribute("startMeasTime",startMeasureTime);
		model.addAttribute("endMeasTime",endMeasureTime);
		model.addAttribute("recordDay",recordDay+1);
		
		//血压测量持续天数
		calendar.setTime(startMeasureTime);
		int s_day = calendar.get(Calendar.DAY_OF_YEAR);
		
		calendar.setTime(endMeasureTime);
		int e_day = calendar.get(Calendar.DAY_OF_YEAR);
		
		int day = e_day - s_day + 1;
		model.addAttribute("lastDay", day);
		model.addAttribute("generTime",new Date());
		
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
		
		model.addAttribute("osbrsCount", obsrs.size());
		
		MemberExt member = memberService.selectMemberExtById(memberid);
		int age = 0;
		try {
			age = TimeUtil.getAge(member.getBirthdate());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		model.put("obsrsJson", obsrsJson);
		model.put("obsrs", obsrs);
		model.put("omem", member);
		model.put("age", age);
	}
	
	
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
	
	public Map<String, Object> getReportExportData(List<Obsr> obsrs){
		Map<String, Object> dataMap = new HashMap<String, Object>();
		
		//计算血压测量数据测量时间段
		Date startMeasureTime = null;
		Date endMeasureTime = null;
		int recordDay = 0;
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(obsrs.get(0).getTesttime());
		int day_0 = calendar.get(Calendar.DAY_OF_YEAR);
		
		for(Obsr obsr : obsrs){
			if(startMeasureTime == null && endMeasureTime == null){
				startMeasureTime = obsr.getTesttime();
				endMeasureTime = obsr.getTesttime();
				continue;
			}
			
			if(startMeasureTime.after(obsr.getTesttime())){
				startMeasureTime = obsr.getTesttime();
			}else{
				endMeasureTime = obsr.getTesttime();
			}
			
			calendar.setTime(obsr.getTesttime());
			int day = calendar.get(Calendar.DAY_OF_YEAR);
			if(day_0 - day != 0){
				recordDay++;
				day_0 = day;
			}
		}
		
		dataMap.put("startMeasTime",startMeasureTime);
		dataMap.put("endMeasTime",endMeasureTime);
		dataMap.put("recordDay",recordDay+1);
		
		//血压测量持续天数
		calendar.setTime(startMeasureTime);
		int s_day = calendar.get(Calendar.DAY_OF_YEAR);
		
		calendar.setTime(endMeasureTime);
		int e_day = calendar.get(Calendar.DAY_OF_YEAR);
		
		int day = e_day - s_day + 1;
		dataMap.put("lastDay", day);
		
		Map<String, Object> data = reportIFService.consTableData(obsrs);
		dataMap.put("minData", data.get("minData"));
		dataMap.put("maxData", data.get("maxData"));
		dataMap.put("avgData", data.get("avgData"));
		dataMap.put("exData", data.get("exData"));
		dataMap.put("data", data.get("data"));
		
		dataMap.put("maxObsr",getObsr(data.get("maxData"), true));
		dataMap.put("minObsr",getObsr(data.get("minData"), false));
		dataMap.put("avgObsr",getAvgObsr(data.get("data")));
		dataMap.put("exObsr",getExData((List<Map<String,Object>>)data.get("exData"), (List<Obsr>)data.get("data")));
		
		dataMap.put("obsrs", obsrs);
		
		return dataMap;
	}
	
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
	
	@RequestMapping(value="/getReportXTDetail")
	public String getReportXTDetail(ModelMap model, String obsrsJson,Integer memberid) throws Exception{
		getReportData(model, obsrsJson, memberid);

		return "measure/xuetangRep";
	}
	
	@RequestMapping(value="/getReportXTPreview")
	public String getReportXTPreview(ModelMap model, String obsrsJson,Integer memberid, Date generTime) throws Exception{
		getReportData(model, obsrsJson, memberid);
		model.addAttribute("generTime", generTime);
		
		return "measure/exportPreviewXTRep";
	}
	
	@ResponseBody
	@RequestMapping(value="/getBloodSugarChart",produces = "plain/text; charset=UTF-8")
	public String getBloodSugarRepChart(String obsrsJson){
		List<Obsr> obsrs = JSONObject.parseArray(obsrsJson, Obsr.class);
		JSONArray jsonArr = new JSONArray();
		//24小时血糖分布图
		jsonArr.add(chartService.selectBloodSugarDistriChartJson(obsrs));
		//血糖分布盒图
		jsonArr.add(chartService.selectBloodSugarDistriBoxChartJson(obsrs));
		//血糖最值图
		jsonArr.add(chartService.selectBloodSugarMaxAndMinTrendChartJson(obsrs));
		//血糖饼图
		jsonArr.add(chartService.selectBloodSugarTimeQPieChartJson(obsrs));
		//血糖趋势图
		JSONObject trend = new JSONObject();
		trend.put("trend",chartService.selectBloodSugarMeasTrendsChartJson(obsrs));
		jsonArr.add(trend);
		
		return jsonArr.toString();
	}
	
	@ResponseBody
	@RequestMapping(value="/getReportSVGData")
	public String getReportSVGData(HttpServletRequest request){
		String jsonStr = request.getParameter("jsonStr");
		Object jsonObj = JSONObject.toJSON(jsonStr);

		request.getSession().setAttribute("jsonArr", jsonObj);
		
		return "1";
	}
	
    @RequestMapping(value="/exportReportWord")
	public void exportReportWord(HttpServletRequest request, HttpServletResponse response,String obsrsJson, Integer memberId, Date generTime) throws Exception{
    	List<Obsr> obsrs = JSONObject.parseArray(obsrsJson, Obsr.class);
    	
    	//从session中获取svg字符串
		JSONArray jsonArr = JSONArray.parseArray((String)request.getSession().getAttribute("jsonArr"));
		Map<String ,Object> dataMap = getReportExportData(obsrs);
		for(int i=0;i<jsonArr.size();i++){
			JSONObject jsonObj =jsonArr.getJSONObject(i);
			Set<String> keys = jsonObj.keySet(); 
			for(String key : keys){
				if("xt_tab1".equals(key)){
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
				}	
			}
		}
		
		MemberExt member = memberService.selectMemberExtById(memberId);
		int age = 0;
		try {
			age = TimeUtil.getAge(member.getBirthdate());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		dataMap.put("omem", member);
		dataMap.put("age", age);
		dataMap.put("generTime",generTime);
		dataMap.put("gender", "1".equals(member.getGender())?"男": "2".equals(member.getGender())?"女":"未知");
		
		String exportFileName = member.getMemname() + "的血糖测量报告" + new SimpleDateFormat("yyyyMMdd").format(new Date());
		exportWordService.ExportWord(request, response, dataMap, exportFileName, "xtRep.ftl");
	}

}

