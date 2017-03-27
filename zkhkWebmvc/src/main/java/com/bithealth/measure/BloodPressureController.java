 
/**
 * @PackageName:      com.bithealth.measure
 * @FileName:     BloodPressureController.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      陈哲 
 * @version      V1.0  
 * @Createdate:  2016年7月20日 上午9:44:13  
 * 
 */

package com.bithealth.measure;

import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
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

import sun.misc.BASE64Encoder;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bithealth.measureCore.bloodPressure.model.Osbp;
import com.bithealth.measureCore.bloodPressure.model.OsbpOmemVO;
import com.bithealth.measureCore.bloodPressure.service.BloodPressureService;
import com.bithealth.measureCore.common.model.Omds;
import com.bithealth.measureCore.electrocardio.service.ElectrocardioFileService;
import com.bithealth.measureCore.enmu.BloodPresExcType;
import com.bithealth.measureCore.enmu.BloodPresTimePType;
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
 * 类名称: BloodPressureController  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年7月20日 上午9:44:13 
 * 
 * @author 陈哲
 * @version  
 */
@Controller
@RequestMapping("/bloodPressure")
public class BloodPressureController extends BaseSpringController{
	@Autowired
	private BloodPressureService bloodPressureService;
	
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private ReportIFService reportIFService;
	
	@Autowired
	private Facade chartService;
	
	@Autowired
	private ExportWordService exportWordService;
	
	@Autowired
	private ElectrocardioFileService electrocardioFileService;
	
	
	/**
	 * @Title:showBloodPressPage 
	 * @Description:某医生下会员的血压测量信息
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
	@RequestMapping(value="/queryBloodPressure",method=RequestMethod.GET)
	public String showBloodPressPage(Model model,String wheAbnTag, Integer pageNo, Integer pageSize, Integer docid, String criteria) {
		//解决中文乱码
		if(criteria != null){
			try {
				criteria = URLDecoder.decode(criteria,"UTF-8");
			} catch (Exception e) {
				e.printStackTrace();
				return "/measure/showMemberMeasureInfoByDocid";
			}
		}
		
		if(pageNo == null){
			pageNo = 1;
		}
		
		if(pageSize == null){
			pageSize = 10;
		}
		Page<OsbpOmemVO> page = bloodPressureService.selectBloodPresAndMemListPage(pageNo, pageSize, criteria, docid, wheAbnTag);
		model.addAttribute("page",page);
		model.addAttribute("criteria",criteria);
		model.addAttribute("wheAbnTag",wheAbnTag);
		
		return "/measure/showMemberMeasureInfoByDocid";
	}
	
	
	/**
	 * @Title:deleteBloodPresInfo 
	 * @Description:删除单个血压信息
	 * @author 陈哲
	 * @param docentry
	 * @return 
	 * @throws
	 * @retrun String
	 */
	@RequestMapping(value="/deleteBloodPresInfo")
	public String deleteBloodPresInfo(Long docentry){
		bloodPressureService.deleteBloodPresByDocentry(docentry);
		
		return "forward:queryBloodPressure";
	}
	
	
	/**
	 * @Title:deleteBatchBloodPresInfo 
	 * @Description:批量删除指定的血压信息
	 * @author 陈哲
	 * @param parameter
	 * @return 
	 * @throws
	 * @retrun String
	 */
	@RequestMapping(value="/deleteBatchBloodPresInfo")
	public String deleteBatchBloodPresInfo(String parameter){
		List<Long> docentryList = new ArrayList<Long>();
		String[] strs = parameter.split(",");
		for(String str : strs){
			docentryList.add(Long.valueOf(str));
		}
		
		bloodPressureService.deleteBatchBloodPressByDocentry(docentryList);
		
		return "forward:queryBloodPressure";
	}
	
	
	/**
	 * @Title:showSingleBloodPress 
	 * @Description:单个血压详情信息
	 * @param request
	 * @return 
	 * @throws
	 * @retrun String
	 * @throws Exception 
	 */
	@RequestMapping(value="/showSingleBloodPress",method=RequestMethod.GET)
	public String showSingleBloodPress(Model model, Integer memberId, Long eventId, Integer pageNo, Integer flag) {
		if(pageNo == null){
			pageNo = 0;
		}

		//血压页面有两个入口，分别是会员管理和测量管理，flag用来标记是哪个入口，值为1标识会员管理
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
		
		List<Omds> omdsList = bloodPressureService.selectMeasureRecordByBloodPress(memberId);
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
				return "/measure/singleXueYa";
			}
			omds = omdsList.get(pageNo);
		}
		
		Osbp osbp = null;
		if(omds != null){
			osbp = bloodPressureService.selectBloodPressByEventId(omds.getEventid());
			model.addAttribute("osbp", osbp);
		}
		
		model.addAttribute("pageNo", pageNo);
		model.addAttribute("total", omdsList.size());
		return "/measure/singleXueYa";
	}
	
	
	/**
	 * @Title:showAllBloodPress 
	 * @Description:某医生下单个会员的所有血压测量信息
	 * @author 陈哲
	 * @param model
	 * @param memberId
	 * @param eventId
	 * @param pageNo
	 * @param pageSize
	 * @param startTime
	 * @param endTime
	 * @return 
	 * @throws
	 * @retrun String
	 * @throws Exception 
	 */
	@RequestMapping(value="/showAllBloodPress",method=RequestMethod.GET)
	public String showAllBloodPress(Model model, Integer memberId,
			Long eventId, Integer pageNo, Integer pageSize, Date startTime,
			Date endTime, Integer flag) {
		if(pageNo == null){
			pageNo = 1;
		}
		
		if(pageSize == null){
			pageSize = 10;
		}
		
		//血压页面有两个入口，分别是会员管理和测量管理，flag用来标记是哪个入口，值为1标识会员管理
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
		
		Page<Osbp> page = bloodPressureService.selectBloodPressAndPage(memberId,pageNo,pageSize,startTime,endTime_);
		
		//血压JSON
		JSONObject object = getBloodPressTrendJsonData(page.getResult());
		String jsonArr = JSONArray.toJSONString(page.getResult());
		
		model.addAttribute("json", object);
		model.addAttribute("jsonArr", jsonArr);
		model.addAttribute("page", page);
		model.addAttribute("omem", member);
		model.addAttribute("age", age);
		model.addAttribute("eventId", eventId);
		
		return "/measure/allXueYa";
	}
	
	
	/**
	 * @Title:getBloodPressTrendJsonData 
	 * @Description:某医生下单个会员所有血压测量趋势json数据
	 * @author 陈哲
	 * @param osbps
	 * @return 
	 * @throws
	 * @retrun JSONObject
	 */
	public JSONObject getBloodPressTrendJsonData(List<Osbp> osbps){
		List<String> time = new ArrayList<>(); // 时间
		List<Integer> sbps = new ArrayList<>(); // 收缩压
		List<Integer> dbps = new ArrayList<>(); // 舒张压
		List<Integer> pulseRate = new ArrayList<>(); // 舒张压

		JSONObject object = new JSONObject();

		SimpleDateFormat format = new SimpleDateFormat("MM-dd");
		Osbp osbp = null;
		if (null != osbps && !osbps.isEmpty()) {
			osbp = new Osbp();
			for (int i = osbps.size()-1; i >= 0; i--) {
				osbp = osbps.get(i);
				time.add(format.format(osbp.getTesttime().getTime()));
				sbps.add(osbp.getSbp()); // 收缩压
				dbps.add(osbp.getDbp()); // 舒张压
				pulseRate.add(osbp.getPulserate());//脉率
			}
			object.put("time", time);
			object.put("sbp", sbps);
			object.put("dbp", dbps);
			object.put("pulseRate", pulseRate);
		}

		return object;
	}
	
	
	/**
	 * @Title:showSingleBloodPressInfo 
	 * @Description:单个血压弹出框信息 
	 * @author 陈哲
	 * @param docentry
	 * @return 
	 * @throws
	 * @retrun String
	 */
	@ResponseBody
	@RequestMapping(value="/showSingleBloodPressInfo", produces = "plain/text; charset=UTF-8")
	public String showSingleBloodPressInfo(Long docentry) {
		Osbp osbp = bloodPressureService.selectBloodPresOneByDocentry(docentry);

		JSONObject jsonObject = new JSONObject();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		jsonObject.put("uploadTime", sdf.format(osbp.getUploadtime()));
		jsonObject.put("testTime", sdf.format(osbp.getTesttime()));
		jsonObject.put("abnormal", BloodPresExcType.getExcTypeName(Integer.valueOf(osbp.getAbnormal())));
		jsonObject.put("timePeriod", BloodPresTimePType.getTimeTypeName(Integer.valueOf(osbp.getTimeperiod())));
		jsonObject.put("sbp", osbp.getSbp() + "");
		jsonObject.put("dbp", osbp.getDbp() + "");
		jsonObject.put("pulseRate", osbp.getPulserate() + "");
		
		return jsonObject.toString();
	}
	
	public void getReportData(ModelMap model, String osbpsJson,Integer memberid) throws Exception{
		List<Osbp> osbps = JSONObject.parseArray(osbpsJson, Osbp.class);
		
		//计算血压测量数据测量时间段
		Date startMeasureTime = null;
		Date endMeasureTime = null;
		int recordDay = 0;
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(osbps.get(0).getTesttime());
		int day_0 = calendar.get(Calendar.DAY_OF_YEAR);
		
		for(Osbp osbp : osbps){
			if(startMeasureTime == null && endMeasureTime == null){
				startMeasureTime = osbp.getTesttime();
				endMeasureTime = osbp.getTesttime();
				continue;
			}
			
			if(startMeasureTime.after(osbp.getTesttime())){
				startMeasureTime = osbp.getTesttime();
			}else{
				endMeasureTime = osbp.getTesttime();
			}
			
			calendar.setTime(osbp.getTesttime());
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
		calendar.setTime(endMeasureTime);
		
		int day =  (int) ((endMeasureTime.getTime() - startMeasureTime.getTime()) / (1000*3600*24));
		model.addAttribute("lastDay", day);
		model.addAttribute("generTime",new Date());
		
		// 血压
		Map<?, ?> map1 = reportIFService.calculOsbp(osbps);
		model.put("data1", map1.get("data1"));
		model.put("dates", map1.get("dates"));
		Map<?, ?> map2 = reportIFService.calculOsbpDay(osbps);
		model.put("data2", map2.get("data2"));
		model.put("dates2", map2.get("dates2"));
		Map<?, ?> map3 = reportIFService.calculOsbpEvening(osbps);
		model.put("data3", map3.get("data3"));
		model.put("dates3", map3.get("dates3"));
		
		MemberExt member = memberService.selectMemberExtById(memberid);
		int age = 0;
		try {
			age = TimeUtil.getAge(member.getBirthdate());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		model.put("osbpsJson", osbpsJson);
		model.put("osbps", osbps);
		model.put("omem", member);
		model.put("age", age);
		
		
	}
	
	@RequestMapping(value="/getReportDetail")
	public String getReportDetail(ModelMap model, String osbpsJson,Integer memberid) throws Exception{
		getReportData(model, osbpsJson, memberid);

		return "measure/xueyaRep";
	}
	
	@RequestMapping(value="/getReportPreview")
	public String getReportPreview(ModelMap model, String osbpsJson,Integer memberid, Date generTime) throws Exception{
		getReportData(model, osbpsJson, memberid);
		model.addAttribute("generTime", generTime);
		
		return "measure/exportPreviewXYRep";
	}
	
	@ResponseBody
    @RequestMapping(value = "/getBloodPressChart",produces = "plain/text; charset=UTF-8")
	public String getBloodPressRepChart(String osbpsJson){
		List<Osbp> osbps = JSONObject.parseArray(osbpsJson, Osbp.class);
		JSONArray jsonArr = new JSONArray();
		//饼图
		JSONObject piechart = new JSONObject();
		piechart.put("pie1", chartService.selectBloodPresPieChartJson(osbps));
		jsonArr.add(piechart);
		//柱状图
		JSONObject barchart = new JSONObject();
		barchart.put("bar4", chartService.selectBloodPresBarChartJson(osbps));
		jsonArr.add(barchart);
		//4个小饼图
		JSONObject timeQChart = new JSONObject();
		timeQChart.put("timeQ", chartService.selectBloodPresSubPieChartJson(osbps));
		jsonArr.add(timeQChart);
		//24小时分布图
		jsonArr.add(chartService.selectBloodPresDistriChartJson(osbps));
		
		
		//所有血压趋势图
		JSONObject trend1 = new JSONObject();
		trend1.put("trend1", chartService.selectBloodPresMeasTrendChartJson(osbps));
		jsonArr.add(trend1);
		//起床后血压趋势图
		JSONObject trend2 = new JSONObject();
		trend2.put("trend2", chartService.selectBloodPresMeasAfterbedTrendChartJson(osbps));
		jsonArr.add(trend2);
		//  睡前血压趋势图----
		JSONObject trend3 = new JSONObject();
		trend3.put("trend3", chartService.selectBloodPresMeasBeforebedTrendChartJson(osbps));
		jsonArr.add(trend3);
		
	//  所有脉搏率趋势图----
		JSONObject pulseRate= new JSONObject();
		pulseRate.put("pulseRate", chartService.selectPulseRateMeasTrendChartJson(osbps));
		jsonArr.add(pulseRate);
		
 
		
		return jsonArr.toString();
	}
	
	 public Map<String, Object> getExportWordXYData(List<Osbp> osbps) throws Exception{
		Map<String, Object> dataMap = new HashMap<String, Object>();
		
		//计算血压测量数据测量时间段
		Date startMeasureTime = null;
		Date endMeasureTime = null;
		int recordDay = 0;
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(osbps.get(0).getTesttime());
		int day_0 = calendar.get(Calendar.DAY_OF_YEAR);
		
		for(Osbp osbp : osbps){
			if(startMeasureTime == null && endMeasureTime == null){
				startMeasureTime = osbp.getTesttime();
				endMeasureTime = osbp.getTesttime();
				continue;
			}
			
			if(startMeasureTime.after(osbp.getTesttime())){
				startMeasureTime = osbp.getTesttime();
			}else{
				endMeasureTime = osbp.getTesttime();
			}
			
			calendar.setTime(osbp.getTesttime());
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
		
		dataMap.putAll(reportIFService.wrapCalculOsbpData(osbps));
		dataMap.putAll(reportIFService.wrapCalculOsbpDayData(osbps));
		dataMap.putAll(reportIFService.wrapCalculOsbpEveningData(osbps));
		getMeasureOsbp(osbps, dataMap);
		dataMap.put("osbps", osbps);
		
		return dataMap;
	 }
	 
	 
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
	 
	 	@ResponseBody
		@RequestMapping(value="/getReportSVGData")
		public String getReportSVGData(HttpServletRequest request){
			String jsonStr = request.getParameter("jsonStr");
			Object jsonObj = JSONObject.toJSON(jsonStr);

			request.getSession().setAttribute("jsonArr", jsonObj);
			
			return "1";
		}
	
	
	 @RequestMapping(value="/exportReportWord")
	 public void exportReportWord(HttpServletRequest request, HttpServletResponse response,String osbpsJson, Integer memberId, Date generTime) throws Exception{
		 List<Osbp> osbps = JSONObject.parseArray(osbpsJson, Osbp.class);
		 
	 	 //从session中获取svg字符串
		JSONArray jsonArr = JSONArray.parseArray((String)request.getSession().getAttribute("jsonArr"));
		Map<String ,Object> dataMap = getExportWordXYData(osbps);
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
				} 
				else if("xy_chart1_1".equals(key)){
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
				}
				else if("xy_chart1_3".equals(key)){
					String value = jsonObj.getString(key);
					dataMap.put(key, value);
					
					JSONArray jsonArrSvg = jsonObj.getJSONArray("svg");
					String svgStr = jsonArrSvg.getString(0);
					dataMap.put("xy_chart1_3_svg", exportWordService.doImage(svgStr, request));
				}
				
				
				
				else if("xy_chart2".equals(key)){
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
			
			String exportFileName = member.getMemname() + "的血压测量报告" + new SimpleDateFormat("yyyyMMdd").format(new Date());
			exportWordService.ExportWord(request, response, dataMap, exportFileName, "xyRep.ftl");
	}
	
}

