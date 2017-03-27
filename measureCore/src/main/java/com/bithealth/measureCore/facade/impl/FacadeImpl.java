 
/**
 * @PackageName:      com.bithealth.measureCore.facade.impl
 * @FileName:     FacadeImpl.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      陈哲 
 * @version      V1.0  
 * @Createdate:  2016年7月6日 下午5:23:14  
 * 
 */

package com.bithealth.measureCore.facade.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bithealth.careCore.facade.model.MsgCenter;
import com.bithealth.careCore.facade.service.CareIFService;
import com.bithealth.measureCore.bloodPressure.model.Osbp;
import com.bithealth.measureCore.bloodPressure.model.OsbpChart;
import com.bithealth.measureCore.bloodPressure.service.BloodPressureService;
import com.bithealth.measureCore.bloodSugar.model.Obsr;
import com.bithealth.measureCore.bloodSugar.model.ObsrChart;
import com.bithealth.measureCore.bloodSugar.service.BloodSugarService;
import com.bithealth.measureCore.common.model.Omds;
import com.bithealth.measureCore.common.service.OmdsService;
import com.bithealth.measureCore.constant.Constant;
import com.bithealth.measureCore.electrocardio.model.Ecg2;
import com.bithealth.measureCore.electrocardio.model.Ecg2Chart;
import com.bithealth.measureCore.electrocardio.model.Oecg;
import com.bithealth.measureCore.electrocardio.model.OecgExample;
import com.bithealth.measureCore.electrocardio.service.Ecg2Service;
import com.bithealth.measureCore.electrocardio.service.ElectrocardioService;
import com.bithealth.measureCore.electrocardioPulse.model.Oppg;
import com.bithealth.measureCore.electrocardioPulse.model.OppgChart;
import com.bithealth.measureCore.electrocardioPulse.service.PulseService;
import com.bithealth.measureCore.enmu.BloodPresExcType;
import com.bithealth.measureCore.enmu.BloodSugarTimePType;
import com.bithealth.measureCore.enmu.BloodSugarTimeQExcType;
import com.bithealth.measureCore.enmu.BloodSugarTimeQType;
import com.bithealth.measureCore.enmu.ElectrocardioType;
import com.bithealth.measureCore.enmu.EventType;
import com.bithealth.measureCore.enmu.PulseType;
import com.bithealth.measureCore.facade.Facade;
import com.bithealth.memberCore.member.model.Member;
import com.bithealth.memberCore.member.service.MemberService;
import com.bithealth.msgCenterCore.constants.MessageTypeEnum;
import com.bithealth.msgCenterCore.constants.UserTypeEnum;


/**
 * 类名称: FacadeImpl  
 * 功能描述: 外部接口实现
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年7月6日 下午5:23:14 
 * 
 * @author 陈哲
 * @version  
 */
@Service
public class FacadeImpl implements Facade{
	
	private final static Logger logger = Logger.getLogger(FacadeImpl.class);
	
	@Autowired
	private BloodPressureService bloodPressureService;
	
	@Autowired
	private BloodSugarService bloodSugarService;
	
	@Autowired
	private ElectrocardioService electrocardioService;
	
	@Autowired
	private PulseService pulseService;
	
	
	@Autowired
	private OmdsService omdsService;
	
	@Autowired
	private Ecg2Service ecg2Service;
	
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private CareIFService careIFService;
	
	/** 
	     * @Title: send 
	     * @Description: 血压异常饼状图Json数据（大饼状图）
	     * @param  
	     * @throws      
	     * @retrun  
	     *  @see com.bithealth.measureCore.facade.Facade#selectBloodSugarPieChartJson()
	     */
	public JSONArray selectBloodPresPieChartJson(Integer memberId, int reportNo) {
		List<OsbpChart> list = bloodPressureService.selectBloodPresPieChartData(memberId, reportNo);
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int sum = 0;
		
		JSONArray pie = new JSONArray();

		if(list != null && list.size() > 0){
			//血压测量表中异常状态 0:正常	1:低血压	2:高度高血压	3:中度高血压	4:轻度高血压	5:单纯收缩高血压  6:正常高
			for(int i = 0; i < 7; i++){
				int num = 0;
				boolean flag = false;
				for(OsbpChart os : list){
					if((String.valueOf(i)).equals(os.getAbnormal())){
						flag = true;
						num = os.getNum();
						sum += num;
						map.put(i, num);
						break;
					}
				}
				if(!flag){
					map.put(i, 0);
				}
			}
			
			if(sum > 0){
				Iterator<Integer> iter = map.keySet().iterator();
				while(iter.hasNext()){
					Integer k = iter.next();
					if(k != null){
						double per = map.get(k) / Double.valueOf(sum);
						JSONObject pie1 = new JSONObject();
						pie1.put(BloodPresExcType.getExcTypeName(k), per);
						pie.add(pie1);
					}
				}
			}else{
				for(int i = 0; i < 7; i++){
					JSONObject pie1 = new JSONObject();
					pie1.put(BloodPresExcType.getExcTypeName(i), 0.00);
					pie.add(pie1);
				}
			}
		}else{
			for(int i = 0; i < 7; i++){
				JSONObject pie1 = new JSONObject();
				pie1.put(BloodPresExcType.getExcTypeName(i), 0d);
				pie.add(pie1);
			}
		}
		return pie;
	}
	
	public JSONArray selectBloodPresPieChartJson(List<Osbp> osbps){
		List<OsbpChart> list = bloodPressureService.selectBloodPresPieChartData(osbps);
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int sum = 0;
		
		JSONArray pie = new JSONArray();

		if(list != null && list.size() > 0){
			//血压测量表中异常状态 0:正常	1:低血压	2:高度高血压	3:中度高血压	4:轻度高血压	5:单纯收缩高血压  6:正常高
			for(int i = 0; i < 7; i++){
				int num = 0;
				boolean flag = false;
				for(OsbpChart os : list){
					if((String.valueOf(i)).equals(os.getAbnormal())){
						flag = true;
						num = os.getNum();
						sum += num;
						map.put(i, num);
						break;
					}
				}
				if(!flag){
					map.put(i, 0);
				}
			}
			
			if(sum > 0){
				Iterator<Integer> iter = map.keySet().iterator();
				while(iter.hasNext()){
					Integer k = iter.next();
					if(k != null){
						double per = map.get(k) / Double.valueOf(sum);
						JSONObject pie1 = new JSONObject();
						pie1.put(BloodPresExcType.getExcTypeName(k), per);
						pie.add(pie1);
					}
				}
			}else{
				for(int i = 0; i < 7; i++){
					JSONObject pie1 = new JSONObject();
					pie1.put(BloodPresExcType.getExcTypeName(i), 0.00);
					pie.add(pie1);
				}
			}
		}else{
			for(int i = 0; i < 7; i++){
				JSONObject pie1 = new JSONObject();
				pie1.put(BloodPresExcType.getExcTypeName(i), 0d);
				pie.add(pie1);
			}
		}
		return pie;
	}
	
	
	/**
	 * 
	 * @Title:selectBloodPresBarChartJson 
	 * @Description:血压柱状图Json数据(各级血压次数)
	 * @author 陈哲
	 * @param memberId
	 * @param reportNo
	 * @return 
	 * @throws
	 * @retrun JSONArray
	 */
	public JSONArray selectBloodPresBarChartJson(Integer memberId, int reportNo){
		List<OsbpChart> list = bloodPressureService.selectBloodPresPieChartData(memberId, reportNo);
		JSONArray bar = new JSONArray();

		if(list != null && list.size() > 0){
			//血压测量表中异常状态 ，0:正常	1:低血压	2:高度高血压	3:中度高血压	4:轻度高血压	5:单纯收缩高血压   6:正常高
			for(int i = 0; i < 7; i++){
				int num = 0;
				boolean flag = false;
				JSONObject obj = new JSONObject();
				for(OsbpChart os : list){
					if((String.valueOf(i)).equals(os.getAbnormal())){
						flag = true;
						num = os.getNum();
						obj.put(BloodPresExcType.getExcTypeName(i), num);
						bar.add(obj);
						break;
					}
				}
				if(!flag){
					obj.put(BloodPresExcType.getExcTypeName(i), 0);
					bar.add(obj);
				}
			}
		}else{
			for(int i = 0; i < 7; i++){
				JSONObject obj = new JSONObject();
				obj.put(BloodPresExcType.getExcTypeName(i), 0);
				bar.add(obj);
			}
		}
		return bar;
	}
	
	public JSONArray selectBloodPresBarChartJson(List<Osbp> osbps){
		List<OsbpChart> list = bloodPressureService.selectBloodPresPieChartData(osbps);
		JSONArray bar = new JSONArray();

		if(list != null && list.size() > 0){
			//血压测量表中异常状态 ，0:正常	1:低血压	2:高度高血压	3:中度高血压	4:轻度高血压	5:单纯收缩高血压  6:正常高
			for(int i = 0; i < 7; i++){
				int num = 0;
				boolean flag = false;
				JSONObject obj = new JSONObject();
				for(OsbpChart os : list){
					if((String.valueOf(i)).equals(os.getAbnormal())){
						flag = true;
						num = os.getNum();
						obj.put(BloodPresExcType.getExcTypeName(i), num);
						bar.add(obj);
						break;
					}
				}
				if(!flag){
					obj.put(BloodPresExcType.getExcTypeName(i), 0);
					bar.add(obj);
				}
			}
		}else{
			for(int i = 0; i < 7; i++){
				JSONObject obj = new JSONObject();
				obj.put(BloodPresExcType.getExcTypeName(i), 0);
				bar.add(obj);
			}
		}
		return bar;
	}
	/**
	 * 
	 * @Title:selectBloodPresSubPieChartJson 
	 * @Description:四个时间段（8点前、 8-12点、12-18点、18点以后）的血压异常JSON数据 （4个小饼状图）
	 * @author 陈哲
	 * @param memberId
	 * @param reportNo
	 * @return 
	 * @throws
	 * @retrun JSONArray
	 */
	public JSONArray selectBloodPresSubPieChartJson(Integer memberId, int reportNo){
		List<OsbpChart> list = bloodPressureService.selectBloodPresSubPieChartData(memberId, reportNo);
		
		int sum = 0;
		JSONArray timeQ = new JSONArray();	//四个小图
		if(list != null && list.size() > 0){
			//0: 8点前、1: 8-12点、2: 12-18点、3: 18点以后
			for(int i = 0; i < 4; i++){				
				boolean flag = false;
				Map<String, Integer> xyMap = new HashMap<String, Integer>();
				for(OsbpChart os : list){
					if((String.valueOf(i)).equals(os.getTimeQ())){
						flag = true;
						sum += os.getNum();
						xyMap.put(os.getXY(), os.getNum());
					}
				}
				
				//判断是否有对应子图的数据
				if(flag){
					JSONObject subtime = new JSONObject();
					for(int x = 0; x < 3; x++){
						int n = xyMap.get(String.valueOf(x)) == null ? 0 : xyMap.get(String.valueOf(x));
						if(n != 0){
							subtime.put(BloodSugarTimeQExcType.getTypeName(x), Double.valueOf(n)/sum);
						}else{
							subtime.put(BloodSugarTimeQExcType.getTypeName(x), 0d);
						}
					}
					JSONObject subPie = new JSONObject();
					subPie.put(BloodSugarTimePType.getTypeName(i), subtime);
					
					timeQ.add(subPie);
					
					flag = false;
				}else{
					//0偏高、1正常、2偏低
					JSONObject subtime = new JSONObject();
					subtime.put("偏低", 0d);
					subtime.put("正常", 0d);
					subtime.put("偏高", 0d);
					JSONObject subChart = new JSONObject();
					subChart.put(BloodSugarTimePType.getTypeName(i), subtime);
					
					timeQ.add(subChart);
				}
				sum=0;	//清空累加器
			}
		}else{
			for(int i = 0; i < 4; i++){
				JSONArray subTimeArr = new JSONArray();
				JSONObject subtime = new JSONObject();
				
				subtime.put("偏低", 0d);
				subtime.put("正常", 0d);
				subtime.put("偏高", 0d);
				subTimeArr.add(subtime);
				
				JSONObject subPie = new JSONObject();
				subPie.put(BloodSugarTimePType.getTypeName(i), subTimeArr);
				
				timeQ.add(subPie);
			}
		}
		return timeQ;
	}
	
	public JSONArray selectBloodPresSubPieChartJson(List<Osbp> osbps){
		List<OsbpChart> list = bloodPressureService.selectBloodPresSubPieChartData(osbps);
		
		int sum = 0;
		JSONArray timeQ = new JSONArray();	//四个小图
		if(list != null && list.size() > 0){
			//0: 8点前、1: 8-12点、2: 12-18点、3: 18点以后
			for(int i = 0; i < 4; i++){				
				boolean flag = false;
				Map<String, Integer> xyMap = new HashMap<String, Integer>();
				for(OsbpChart os : list){
					if((String.valueOf(i)).equals(os.getTimeQ())){
						flag = true;
						sum += os.getNum();
						xyMap.put(os.getXY(), os.getNum());
					}
				}
				
				//判断是否有对应子图的数据
				if(flag){
					JSONObject subtime = new JSONObject();
					for(int x = 0; x < 3; x++){
						int n = xyMap.get(String.valueOf(x)) == null ? 0 : xyMap.get(String.valueOf(x));
						if(n != 0){
							subtime.put(BloodSugarTimeQExcType.getTypeName(x), Double.valueOf(n)/sum);
						}else{
							subtime.put(BloodSugarTimeQExcType.getTypeName(x), 0d);
						}
					}
					JSONObject subPie = new JSONObject();
					subPie.put(BloodSugarTimePType.getTypeName(i), subtime);
					
					timeQ.add(subPie);
					
					flag = false;
				}else{
					//0偏高、1正常、2偏低
					JSONObject subtime = new JSONObject();
					subtime.put("偏低", 0d);
					subtime.put("正常", 0d);
					subtime.put("偏高", 0d);
					JSONObject subChart = new JSONObject();
					subChart.put(BloodSugarTimePType.getTypeName(i), subtime);
					
					timeQ.add(subChart);
				}
				sum=0;	//清空累加器
			}
		}else{
			for(int i = 0; i < 4; i++){
				JSONArray subTimeArr = new JSONArray();
				JSONObject subtime = new JSONObject();
				
				subtime.put("偏低", 0d);
				subtime.put("正常", 0d);
				subtime.put("偏高", 0d);
				subTimeArr.add(subtime);
				
				JSONObject subPie = new JSONObject();
				subPie.put(BloodSugarTimePType.getTypeName(i), subTimeArr);
				
				timeQ.add(subPie);
			}
		}
		return timeQ;
	}
	
	
	/**
	 * 
	 * @Title:selectBloodPresDistriChartJson 
	 * @Description:24小时血压分布图Json数据 （24小时血压分布图）
	 * @author 陈哲
	 * @param memberId
	 * @param reportNo
	 * @return 
	 * @throws
	 * @retrun JSONObject
	 */
	public JSONObject selectBloodPresDistriChartJson(Integer memberId, int reportNo){
		List<OsbpChart> list = bloodPressureService.selectBloodPresScaChartData(memberId, reportNo);
		JSONObject scat = new JSONObject();
		if(list != null && list.size() > 0){
			JSONArray scatSArr = new JSONArray();	//收缩压
			JSONArray scatDArr = new JSONArray();	//舒张压
			
			for(OsbpChart os : list){
				if(os.getTestTimes() != null && !"".equals(os.getTestTimes().trim())){
					JSONObject sbp = new JSONObject();
					JSONObject dbp = new JSONObject();
					
					sbp.put(os.getTestTimes().replace(":", "."), os.getSbp()==null ? 0 : os.getSbp());
					scatSArr.add(sbp);
					
					dbp.put(os.getTestTimes().replace(":", "."), os.getDbp()==null ? 0 : os.getDbp());
					scatDArr.add(dbp);
				}
			}
			scat.put("scotS", scatSArr);	//收缩压
			scat.put("scotD", scatDArr);	//舒张压
		}else{
			JSONArray scatSArr = new JSONArray();
			JSONArray scatDArr = new JSONArray();
			scat.put("scotS", scatSArr);	//收缩压
			scat.put("scotD", scatDArr);	//舒张压
		}
		return scat;
	}
	
	public JSONObject selectBloodPresDistriChartJson(List<Osbp> osbps){
		List<OsbpChart> list = bloodPressureService.selectBloodPresScaChartData(osbps);
		JSONObject scat = new JSONObject();
		if(list != null && list.size() > 0){
			JSONArray scatSArr = new JSONArray();	//收缩压
			JSONArray scatDArr = new JSONArray();	//舒张压
			
			for(OsbpChart os : list){
				if(os.getTestTimes() != null && !"".equals(os.getTestTimes().trim())){
					JSONObject sbp = new JSONObject();
					JSONObject dbp = new JSONObject();
					
					sbp.put(os.getTestTimes().replace(":", "."), os.getSbp()==null ? 0 : os.getSbp());
					scatSArr.add(sbp);
					
					dbp.put(os.getTestTimes().replace(":", "."), os.getDbp()==null ? 0 : os.getDbp());
					scatDArr.add(dbp);
				}
			}
			scat.put("scotS", scatSArr);	//收缩压
			scat.put("scotD", scatDArr);	//舒张压
		}else{
			JSONArray scatSArr = new JSONArray();
			JSONArray scatDArr = new JSONArray();
			scat.put("scotS", scatSArr);	//收缩压
			scat.put("scotD", scatDArr);	//舒张压
		}
		return scat;
	}
	/**
	 * 
	     * @Title: send 
	     * @Description: 所有血压趋势图Json数据（所有血压趋势图）
	     * @param  
	     * @throws      
	     * @retrun  
	     *  @see com.bithealth.measureCore.facade.Facade#selectBloodPresMeasTrendChartJson(java.lang.Integer, int)
	 */
	public JSONObject selectBloodPresMeasTrendChartJson(Integer memberId, int reportNo){
		List<OsbpChart> list = bloodPressureService.selectBloodPresTrendMeasChartData(memberId, reportNo);
		JSONObject trend = new JSONObject();
		
		if(list != null && list.size() > 0){
			JSONArray time = new JSONArray();
			JSONArray sbp = new JSONArray();
			JSONArray dbp = new JSONArray();
			
			for(OsbpChart os : list){
				if(os.getTestTimes() != null && !"".equals(os.getTestTimes().trim())){
					time.add(os.getTestTimes());
					sbp.add(os.getSbp());
					dbp.add(os.getDbp());
				}
			}
			trend.put("time", time);
			trend.put("sbp", sbp);
			trend.put("dbp", dbp);
		}
		return trend;
	}
	//所有血压趋势图
	public JSONObject selectBloodPresMeasTrendChartJson(List<Osbp> osbps){
		List<OsbpChart> list = bloodPressureService.selectBloodPresTrendMeasChartData(osbps);
		JSONObject trend = new JSONObject();
		
		if(list != null && list.size() > 0){
			JSONArray time = new JSONArray();
			JSONArray sbp = new JSONArray();
			JSONArray dbp = new JSONArray();
			
			for(OsbpChart os : list){
				if(os.getTestTimes() != null && !"".equals(os.getTestTimes().trim())){
					time.add(os.getTestTimes());
					sbp.add(os.getSbp());
					dbp.add(os.getDbp());
				}
			}
			trend.put("time", time);
			trend.put("sbp", sbp);
			trend.put("dbp", dbp);
		}
		return trend;
	}
	
	
	//所有脉搏趋势图
	public JSONObject selectPulseRateMeasTrendChartJson(List<Osbp> osbps){
		List<OsbpChart> list = bloodPressureService.selectBloodPresTrendMeasChartData(osbps);
		JSONObject trend = new JSONObject();
		
		if(list != null && list.size() > 0){
			JSONArray time = new JSONArray();
//			JSONArray sbp = new JSONArray();
//			JSONArray dbp = new JSONArray();

			JSONArray pulseRate = new JSONArray();
			
			
			for(OsbpChart os : list){
				if(os.getTestTimes() != null && !"".equals(os.getTestTimes().trim())){
					time.add(os.getTestTimes());
//					sbp.add(os.getSbp());
//					dbp.add(os.getDbp());
					pulseRate.add(os.getPulserate());//脉率
					
					
				}
			}
			trend.put("time", time);
			trend.put("pulseRate", pulseRate);
//			trend.put("sbp", sbp);
//			trend.put("dbp", dbp);
		}
		return trend;
	}
	
	
	/**
	 * 
	     * @Title: send 
	     * @Description: 睡觉前血压趋势图Json数据（睡觉前血压趋势图）
	     * @param  
	     * @throws      
	     * @retrun  
	     *  @see com.bithealth.measureCore.facade.Facade#selectBloodPresMeasBeforebedTrendChartJson(java.lang.Integer, int)
	 */
	public JSONObject selectBloodPresMeasBeforebedTrendChartJson(Integer memberId, int reportNo){
		List<OsbpChart> list = bloodPressureService.selectBloodPresTrendBeforebedChartData(memberId, reportNo);
		JSONObject trend = new JSONObject();
		
		if(list != null && list.size() > 0){
			JSONArray time = new JSONArray();
			JSONArray sbp = new JSONArray();
			JSONArray dbp = new JSONArray();
			
			for(OsbpChart os : list){
				if(os.getTestTimes() != null && !"".equals(os.getTestTimes().trim())){
					time.add(os.getTestTimes());
					sbp.add(os.getSbp());
					dbp.add(os.getDbp());
				}
			}
			trend.put("time", time);
			trend.put("sbp", sbp);
			trend.put("dbp", dbp);
		}
		return trend;
	}
	
	
	/**
	 * 
	     * @Title: send 
	     * @Description: 睡觉前血压趋势图Json数据（睡觉前血压趋势图）
	     * @param  
	     * @throws      
	     * @retrun  
	     *  @see com.bithealth.measureCore.facade.Facade#selectBloodPresMeasBeforebedTrendChartJson(java.lang.Integer, int)
	 */
	
	public JSONObject selectBloodPresMeasBeforebedTrendChartJson(List<Osbp> osbps){
		List<OsbpChart> list = bloodPressureService.selectBloodPresTrendBeforebedChartData(osbps);
		JSONObject trend = new JSONObject();
		
		if(list != null && list.size() > 0){
			JSONArray time = new JSONArray();
			JSONArray sbp = new JSONArray();
			JSONArray dbp = new JSONArray();
			
			for(OsbpChart os : list){
				if(os.getTestTimes() != null && !"".equals(os.getTestTimes().trim())){
					time.add(os.getTestTimes());
					sbp.add(os.getSbp());
					dbp.add(os.getDbp());
				}
			}
			trend.put("time", time);
			trend.put("sbp", sbp);
			trend.put("dbp", dbp);
		}
		return trend;
	}
	
	
	/**
	 * 
	     * @Title: send 
	     * @Description: 起床后血压趋势图Json数据（起床后血压趋势图）
	     * @param  
	     * @throws      
	     * @retrun  
	     *  @see com.bithealth.measureCore.facade.Facade#selectBloodPresMeasAfterbedTrendChartJson(java.lang.Integer, int)
	 */
	public JSONObject selectBloodPresMeasAfterbedTrendChartJson(Integer memberId, int reportNo){
		List<OsbpChart> list = bloodPressureService.selectBloodPresAfterbedTrendChartData(memberId, reportNo);
		JSONObject trend = new JSONObject();
		
		if(list != null && list.size() > 0){
			JSONArray time = new JSONArray();
			JSONArray sbp = new JSONArray();
			JSONArray dbp = new JSONArray();
			
			for(OsbpChart os : list){
				if(os.getTestTimes() != null && !"".equals(os.getTestTimes().trim())){
					time.add(os.getTestTimes());
					sbp.add(os.getSbp());
					dbp.add(os.getDbp());
				}
			}
			trend.put("time", time);
			trend.put("sbp", sbp);
			trend.put("dbp", dbp);
		}
		return trend;
	}
	//起床后血压趋势图
	public JSONObject selectBloodPresMeasAfterbedTrendChartJson(List<Osbp> osbps){
		List<OsbpChart> list = bloodPressureService.selectBloodPresAfterbedTrendChartData(osbps);
		JSONObject trend = new JSONObject();
		
		if(list != null && list.size() > 0){
			JSONArray time = new JSONArray();
			JSONArray sbp = new JSONArray();
			JSONArray dbp = new JSONArray();
			
			for(OsbpChart os : list){
				if(os.getTestTimes() != null && !"".equals(os.getTestTimes().trim())){
					time.add(os.getTestTimes());
					sbp.add(os.getSbp());
					dbp.add(os.getDbp());
				}
			}
			trend.put("time", time);
			trend.put("sbp", sbp);
			trend.put("dbp", dbp);
		}
		return trend;
	}


	/** 
	     * @Title: send 
	     * @Description: 24小时血糖分布图Json数据(24小时血糖分布图)
	     * @param  
	     * @throws      
	     * @retrun  
	     *  @see com.bithealth.measureCore.facade.Facade#getBloodSugarDistriChartJson(java.lang.Integer, int)
	     */
	public Map<String, Object> selectBloodSugarDistriChartJson(Integer memberId,
			int reportNo) {
		List<ObsrChart> list = bloodSugarService.selectBloodSugarDistriChartData(memberId, reportNo);
		
		Map<String, Object> chart = new LinkedHashMap<String, Object>();
		JSONArray c0 = new JSONArray();
		JSONArray c1 = new JSONArray();
		JSONArray c2 = new JSONArray();
		JSONArray c3 = new JSONArray();
		JSONArray c4 = new JSONArray();
		JSONArray c5 = new JSONArray();
		JSONArray c6 = new JSONArray();
		JSONArray c7 = new JSONArray();
		JSONArray c8 = new JSONArray();
		if(list != null && list.size() > 0){
			for(ObsrChart ob : list){
				JSONObject json = new JSONObject();
				String time = ob.getTestTimes() == null ? "00:00" : ob.getTestTimes().replace(":", ".");
				
				json.put(time, ob.getBsvalue());
				
				if("0".equals(ob.getTimeperiod())){
					c0.add(json);
				}else if("1".equals(ob.getTimeperiod())){
					c1.add(json);
				}else if("2".equals(ob.getTimeperiod())){
					c2.add(json);
				}else if("3".equals(ob.getTimeperiod())){
					c3.add(json);
				}else if("4".equals(ob.getTimeperiod())){
					c4.add(json);
				}else if("5".equals(ob.getTimeperiod())){
					c5.add(json);
				}else if("6".equals(ob.getTimeperiod())){
					c6.add(json);
				}else if("7".equals(ob.getTimeperiod())){
					c7.add(json);
				}else if("8".equals(ob.getTimeperiod())){
					c8.add(json);
				}
			}
		}
		chart.put(BloodSugarTimeQType.getTimeQTypeName(0), c0);
		chart.put(BloodSugarTimeQType.getTimeQTypeName(1), c1);
		chart.put(BloodSugarTimeQType.getTimeQTypeName(2), c2);
		chart.put(BloodSugarTimeQType.getTimeQTypeName(3), c3);
		chart.put(BloodSugarTimeQType.getTimeQTypeName(4), c4);
		chart.put(BloodSugarTimeQType.getTimeQTypeName(5), c5);
		chart.put(BloodSugarTimeQType.getTimeQTypeName(6), c6);
		chart.put(BloodSugarTimeQType.getTimeQTypeName(7), c7);
		chart.put(BloodSugarTimeQType.getTimeQTypeName(8), c8);

		return chart;
	}
	
	public Map<String, Object> selectBloodSugarDistriChartJson(List<Obsr> obsrs) {
		List<ObsrChart> list = bloodSugarService.selectBloodSugarDistriChartData(obsrs);
		
		Map<String, Object> chart = new LinkedHashMap<String, Object>();
		JSONArray c0 = new JSONArray();
		JSONArray c1 = new JSONArray();
		JSONArray c2 = new JSONArray();
		JSONArray c3 = new JSONArray();
		JSONArray c4 = new JSONArray();
		JSONArray c5 = new JSONArray();
		JSONArray c6 = new JSONArray();
		JSONArray c7 = new JSONArray();
		JSONArray c8 = new JSONArray();
		if(list != null && list.size() > 0){
			for(ObsrChart ob : list){
				JSONObject json = new JSONObject();
				String time = ob.getTestTimes() == null ? "00:00" : ob.getTestTimes().replace(":", ".");
				
				json.put(time, ob.getBsvalue());
				
				if("0".equals(ob.getTimeperiod())){
					c0.add(json);
				}else if("1".equals(ob.getTimeperiod())){
					c1.add(json);
				}else if("2".equals(ob.getTimeperiod())){
					c2.add(json);
				}else if("3".equals(ob.getTimeperiod())){
					c3.add(json);
				}else if("4".equals(ob.getTimeperiod())){
					c4.add(json);
				}else if("5".equals(ob.getTimeperiod())){
					c5.add(json);
				}else if("6".equals(ob.getTimeperiod())){
					c6.add(json);
				}else if("7".equals(ob.getTimeperiod())){
					c7.add(json);
				}else if("8".equals(ob.getTimeperiod())){
					c8.add(json);
				}
			}
		}
		chart.put(BloodSugarTimeQType.getTimeQTypeName(0), c0);
		chart.put(BloodSugarTimeQType.getTimeQTypeName(1), c1);
		chart.put(BloodSugarTimeQType.getTimeQTypeName(2), c2);
		chart.put(BloodSugarTimeQType.getTimeQTypeName(3), c3);
		chart.put(BloodSugarTimeQType.getTimeQTypeName(4), c4);
		chart.put(BloodSugarTimeQType.getTimeQTypeName(5), c5);
		chart.put(BloodSugarTimeQType.getTimeQTypeName(6), c6);
		chart.put(BloodSugarTimeQType.getTimeQTypeName(7), c7);
		chart.put(BloodSugarTimeQType.getTimeQTypeName(8), c8);

		return chart;
	}

	/** 
	     * @Title: send 
	     * @Description: 血糖分布盒图Json数据（血糖分布盒图）
	     * @param  
	     * @throws      
	     * @retrun  
	     *  @see com.bithealth.measureCore.facade.Facade#getBloodSugarDistriBoxChartJson(java.lang.Integer, int)
	     */
	public Map<String, Object> selectBloodSugarDistriBoxChartJson(Integer memberId,
			int reportNo) {
		List<ObsrChart> list = bloodSugarService.selectBloodSugarDistriBoxChartData(memberId, reportNo);
		
		Map<String, Object> chart = new LinkedHashMap<String, Object>();
		if(list != null && list.size() > 0){
			//时间段(9种，此处为硬编码)
			for(int i = 0; i <= 8; i++){
				int count = 0;
				double max = 0;
				double upper = 0;
				double median = 0;
				double lower = 0;
				double min = 0;
				String iStr = String.valueOf(i);
				
				List<Double> ls = new ArrayList<Double>();
				for(ObsrChart ob : list){
					if(iStr.equals(ob.getTimeperiod())){
						ls.add(ob.getBsvalue());
						max = max < ob.getBsvalue() ? ob.getBsvalue() : max;
						if(min == 0){
							min = max;
						}
						min = min > ob.getBsvalue() ? ob.getBsvalue() : min;
						count++;
					}
				}
				
				if(count == 1){
					upper = max;
					median = max;
					lower = max;
					min = max;
				}else if(count == 2){
					upper = max;
					median = (max + min) / 2;
					lower = min;
				}else if(count == 3){
					//ls集合从小到达排序
					Collections.sort(ls);
					//中位数取集合排序后的中间值
					median = ls.get(1);
					upper = ls.get(2);
					lower = ls.get(0);
				}else if(count >= 4){
					//ls集合从小到达排序
					Collections.sort(ls);
					
					//上四分位计算
					if((3*count)%4 == 0){
						upper = (ls.get(((3*count)/4)-1) + ls.get((3*count)/4)) / 2d;
					}else{
						upper = ls.get((3*count)/4);
					}
					
					//中位数
					if(count%2 == 0){
						median = (ls.get((count/2)-1) + ls.get(count/2)) / 2d;
					}else{
						median = ls.get(count/2);
					}
					
					//下四分位
					if(count%4 == 0){
						lower = (ls.get((count/4)-1) + ls.get(count/4)) / 2d;
					}else{
						lower = ls.get(count/4);
					}
				}
				
				JSONArray sub = new JSONArray();
				JSONObject json = new JSONObject();
				json.put("max", max);
				json.put("upper", upper);
				json.put("median", median);
				json.put("lower", lower);
				json.put("min", min);
				sub.add(json);
				chart.put(BloodSugarTimeQType.getTimeQTypeName(i), sub);
			}
		}else{
			//时间段(9种，此处为硬编码)
			for(int i = 0; i <= 8; i++){
				JSONArray sub = new JSONArray();
				JSONObject json = new JSONObject();
				json.put("max", 0d);
				json.put("upper", 0d);
				json.put("median", 0d);
				json.put("lower", 0d);
				json.put("min", 0d);
				
				sub.add(json);
				chart.put(BloodSugarTimeQType.getTimeQTypeName(i), sub);
			}
		}
		return chart;
	}

	
	public Map<String, Object> selectBloodSugarDistriBoxChartJson(List<Obsr> obsrs) {
		List<ObsrChart> list = bloodSugarService.selectBloodSugarDistriBoxChartData(obsrs);
		
		Map<String, Object> chart = new LinkedHashMap<String, Object>();
		if(list != null && list.size() > 0){
			//时间段(9种，此处为硬编码)
			for(int i = 0; i <= 8; i++){
				int count = 0;
				double max = 0;
				double upper = 0;
				double median = 0;
				double lower = 0;
				double min = 0;
				String iStr = String.valueOf(i);
				
				List<Double> ls = new ArrayList<Double>();
				for(ObsrChart ob : list){
					if(iStr.equals(ob.getTimeperiod())){
						ls.add(ob.getBsvalue());
						max = max < ob.getBsvalue() ? ob.getBsvalue() : max;
						if(min == 0){
							min = max;
						}
						min = min > ob.getBsvalue() ? ob.getBsvalue() : min;
						count++;
					}
				}
				
				if(count == 1){
					upper = max;
					median = max;
					lower = max;
					min = max;
				}else if(count == 2){
					upper = max;
					median = (max + min) / 2;
					lower = min;
				}else if(count == 3){
					//ls集合从小到达排序
					Collections.sort(ls);
					//中位数取集合排序后的中间值
					median = ls.get(1);
					upper = ls.get(2);
					lower = ls.get(0);
				}else if(count >= 4){
					//ls集合从小到达排序
					Collections.sort(ls);
					
					//上四分位计算
					if((3*count)%4 == 0){
						upper = (ls.get(((3*count)/4)-1) + ls.get((3*count)/4)) / 2d;
					}else{
						upper = ls.get((3*count)/4);
					}
					
					//中位数
					if(count%2 == 0){
						median = (ls.get((count/2)-1) + ls.get(count/2)) / 2d;
					}else{
						median = ls.get(count/2);
					}
					
					//下四分位
					if(count%4 == 0){
						lower = (ls.get((count/4)-1) + ls.get(count/4)) / 2d;
					}else{
						lower = ls.get(count/4);
					}
				}
				
				JSONArray sub = new JSONArray();
				JSONObject json = new JSONObject();
				json.put("max", max);
				json.put("upper", upper);
				json.put("median", median);
				json.put("lower", lower);
				json.put("min", min);
				sub.add(json);
				chart.put(BloodSugarTimeQType.getTimeQTypeName(i), sub);
			}
		}else{
			//时间段(9种，此处为硬编码)
			for(int i = 0; i <= 8; i++){
				JSONArray sub = new JSONArray();
				JSONObject json = new JSONObject();
				json.put("max", 0d);
				json.put("upper", 0d);
				json.put("median", 0d);
				json.put("lower", 0d);
				json.put("min", 0d);
				
				sub.add(json);
				chart.put(BloodSugarTimeQType.getTimeQTypeName(i), sub);
			}
		}
		return chart;
	}
	
	
	/** 
	     * @Title: send 
	     * @Description: 血糖最值趋势图Json数据（血糖最值趋势图）
	     * @param  
	     * @throws      
	     * @retrun  
	     *  @see com.bithealth.measureCore.facade.Facade#getBloodSugarMaxAndMinTrendChartJson(java.lang.Integer, int)
	     */
	public JSONObject selectBloodSugarMaxAndMinTrendChartJson(Integer memberId,
			int reportNo) {
		List<ObsrChart> list = bloodSugarService.selectBloodSugarMaxAndMinTrendChartData(memberId, reportNo);
		
		JSONObject chart = new JSONObject();
		JSONArray max = new JSONArray();
		JSONArray min = new JSONArray();
		if(list != null && list.size() > 0){
			for(ObsrChart ob : list){
				JSONObject jsonMax = new JSONObject();
				jsonMax.put(ob.getDays(), ob.getMax());
				max.add(jsonMax);
				
				JSONObject jsonMin = new JSONObject();
				jsonMin.put(ob.getDays(), ob.getMin());
				min.add(jsonMin);
			}
		}
		chart.put("最高值", max);
		chart.put("最低值", min);
		
		return chart;
	}
	
	public JSONObject selectBloodSugarMaxAndMinTrendChartJson(List<Obsr> obsrs) {
		List<ObsrChart> list = bloodSugarService.selectBloodSugarMaxAndMinTrendChartData(obsrs);
		
		JSONObject chart = new JSONObject();
		JSONArray max = new JSONArray();
		JSONArray min = new JSONArray();
		if(list != null && list.size() > 0){
			for(ObsrChart ob : list){
				JSONObject jsonMax = new JSONObject();
				jsonMax.put(ob.getDays(), ob.getMax());
				max.add(jsonMax);
				
				JSONObject jsonMin = new JSONObject();
				jsonMin.put(ob.getDays(), ob.getMin());
				min.add(jsonMin);
			}
		}
		chart.put("最高值", max);
		chart.put("最低值", min);
		
		return chart;
	}


	/** 
	     * @Title: send 
	     * @Description: 血糖最值趋势图Json数据（血糖最值趋势图--五个小饼图）
	     * @param  
	     * @throws      
	     * @retrun  
	     *  @see com.bithealth.measureCore.facade.Facade#getBloodSugarTimeQPieChartJson(java.lang.Integer, int)
	     */
	public Map<String, Object> selectBloodSugarTimeQPieChartJson(Integer memberId,
			int reportNo) {
		List<ObsrChart> list = bloodSugarService.selectBloodSugarTimeQPieChartData(memberId, reportNo);
		
		Map<String, Object> chart = new LinkedHashMap<String, Object>();
		if(list != null && list.size() > 0){
			//时间段(9种，此处为硬编码)
			for(int i = 0; i <= 8; i++){
				short count = 0;
				int nNum = 0;
				int hNum = 0;
				int lNum = 0;
				String iStr = String.valueOf(i);
				
				for(ObsrChart ob : list){
					if(iStr.equals(ob.getTimeperiod())){
						if("H".equals(ob.getNE())){
							hNum = ob.getNum();
							count++;
						}else if("L".equals(ob.getNE())){
							lNum = ob.getNum();
							count++;
						}else if("N".equals(ob.getNE())){
							nNum = ob.getNum();
							count++;
						}
						if(count >= 2){
							break;
						}
					}
				}
				double sum = 0d;
				sum += nNum + hNum + lNum;	//小数
				
				JSONObject n = new JSONObject();
				JSONObject h = new JSONObject();
				JSONObject l = new JSONObject();
				if(sum > 0){
					n.put("正常", nNum / sum);
					h.put("偏高", hNum / sum);
					l.put("偏低", lNum / sum);
				}else{
					n.put("正常", 0);
					h.put("偏高", 0);
					l.put("偏低", 0);
				}
				JSONArray sub = new JSONArray();
				sub.add(n);
				sub.add(h);
				sub.add(l);
				chart.put(BloodSugarTimeQType.getTimeQTypeName(i), sub);
			}
		}else{
			//时间段(9种，此处为硬编码)
			for(int i = 0; i <= 8; i++){
				JSONObject n = new JSONObject();
				JSONObject h = new JSONObject();
				JSONObject l = new JSONObject();
				n.put("正常", 0);
				h.put("偏高", 0);
				l.put("偏低", 0);
				
				JSONArray sub = new JSONArray();
				sub.add(n);
				sub.add(h);
				sub.add(l);
				chart.put(BloodSugarTimeQType.getTimeQTypeName(i), sub);
			}
		}
		return chart;
	}
	
	public Map<String, Object> selectBloodSugarTimeQPieChartJson(List<Obsr> obsrs) {
		List<ObsrChart> list = bloodSugarService.selectBloodSugarTimeQPieChartData(obsrs);
		
		Map<String, Object> chart = new LinkedHashMap<String, Object>();
		if(list != null && list.size() > 0){
			//时间段(9种，此处为硬编码)
			for(int i = 0; i <= 8; i++){
				short count = 0;
				int nNum = 0;
				int hNum = 0;
				int lNum = 0;
				String iStr = String.valueOf(i);
				
				for(ObsrChart ob : list){
					if(iStr.equals(ob.getTimeperiod())){
						if("H".equals(ob.getNE())){
							hNum = ob.getNum();
							count++;
						}else if("L".equals(ob.getNE())){
							lNum = ob.getNum();
							count++;
						}else if("N".equals(ob.getNE())){
							nNum = ob.getNum();
							count++;
						}
						if(count >= 2){
							break;
						}
					}
				}
				double sum = 0d;
				sum += nNum + hNum + lNum;	//小数
				
				JSONObject n = new JSONObject();
				JSONObject h = new JSONObject();
				JSONObject l = new JSONObject();
				if(sum > 0){
					n.put("正常", nNum / sum);
					h.put("偏高", hNum / sum);
					l.put("偏低", lNum / sum);
				}else{
					n.put("正常", 0);
					h.put("偏高", 0);
					l.put("偏低", 0);
				}
				JSONArray sub = new JSONArray();
				sub.add(n);
				sub.add(h);
				sub.add(l);
				chart.put(BloodSugarTimeQType.getTimeQTypeName(i), sub);
			}
		}else{
			//时间段(9种，此处为硬编码)
			for(int i = 0; i <= 8; i++){
				JSONObject n = new JSONObject();
				JSONObject h = new JSONObject();
				JSONObject l = new JSONObject();
				n.put("正常", 0);
				h.put("偏高", 0);
				l.put("偏低", 0);
				
				JSONArray sub = new JSONArray();
				sub.add(n);
				sub.add(h);
				sub.add(l);
				chart.put(BloodSugarTimeQType.getTimeQTypeName(i), sub);
			}
		}
		return chart;
	}


	/** 
	     * @Title: send 
	     * @Description: TODO 血糖趋势图Json数据（血糖趋势图）
	     * @param  
	     * @throws      
	     * @retrun  
	     *  @see com.bithealth.measureCore.facade.Facade#getBloodSugarMeasTrendsChartJson(java.lang.Integer, int)
	     */
	public JSONObject selectBloodSugarMeasTrendsChartJson(Integer memberId,
			int reportNo) {
		List<ObsrChart> list = bloodSugarService.selectBloodSugarMeasTrendsChartData(memberId, reportNo);
		
		JSONArray other = new JSONArray();		// 其他时间段
		JSONArray kongfu = new JSONArray();		// 早晨空腹血糖
		JSONArray afterBr = new JSONArray();	// 早餐后2小时
		JSONArray bfLunch = new JSONArray();	// 午餐前
		JSONArray afLunch = new JSONArray();	// 午餐后2小时
		JSONArray bfAf = new JSONArray();		// 晚餐前
		JSONArray afAf = new JSONArray();		// 晚餐后2小时
		JSONArray bfSleep = new JSONArray();	// 睡觉前
		JSONArray midNight = new JSONArray();	// 夜间
		
		JSONObject object = new JSONObject();
		if(list != null && list.size() > 0){
			for(ObsrChart obsr : list){
				JSONArray json = new JSONArray();
				json.add(obsr.getTesttime().getTime());
				json.add(obsr.getBsvalue());
				
				if ("0".equals(obsr.getTimeperiod())) { // 其他时间段
					other.add(json);
				}else if("1".equals(obsr.getTimeperiod())) { // 早晨空腹血糖
					kongfu.add(json);
				} else if("2".equals(obsr.getTimeperiod())) { // 早餐后2小时
					afterBr.add(json);
				}else if("3".equals(obsr.getTimeperiod())) { // 午餐前
					bfLunch.add(json);
				}else if("4".equals(obsr.getTimeperiod())) { // 午餐后2小时
					afLunch.add(json);
				}else if("5".equals(obsr.getTimeperiod())) { //  晚餐前
					bfAf.add(json);
				}else if("6".equals(obsr.getTimeperiod())) { // 晚餐后2小时
					afAf.add(json);
				}else if("7".equals(obsr.getTimeperiod())) { // 睡觉前
					bfSleep.add(json);
				}else if("8".equals(obsr.getTimeperiod())) { // 夜间
					midNight.add(json);
				}
			}
			object.put("other", other);
			object.put("kongfu", kongfu);
			object.put("afterBr", afterBr);
			object.put("bfLunch", bfLunch);
			object.put("afLunch", afLunch);
			object.put("bfAf", bfAf);
			object.put("afAf", afAf);
			object.put("bfSleep", bfSleep);
			object.put("midNight", midNight);
		}
		return object;
	}
	
	public JSONObject selectBloodSugarMeasTrendsChartJson(List<Obsr> obsrs) {
		List<ObsrChart> list = bloodSugarService.selectBloodSugarMeasTrendsChartData(obsrs);
		
		JSONArray other = new JSONArray();		// 其他时间段
		JSONArray kongfu = new JSONArray();		// 早晨空腹血糖
		JSONArray afterBr = new JSONArray();	// 早餐后2小时
		JSONArray bfLunch = new JSONArray();	// 午餐前
		JSONArray afLunch = new JSONArray();	// 午餐后2小时
		JSONArray bfAf = new JSONArray();		// 晚餐前
		JSONArray afAf = new JSONArray();		// 晚餐后2小时
		JSONArray bfSleep = new JSONArray();	// 睡觉前
		JSONArray midNight = new JSONArray();	// 夜间
		
		JSONObject object = new JSONObject();
		if(list != null && list.size() > 0){
			for(ObsrChart obsr : list){
				JSONArray json = new JSONArray();
				json.add(obsr.getTesttime().getTime());
				json.add(obsr.getBsvalue());
				
				if ("0".equals(obsr.getTimeperiod())) { // 其他时间段
					other.add(json);
				}else if("1".equals(obsr.getTimeperiod())) { // 早晨空腹血糖
					kongfu.add(json);
				} else if("2".equals(obsr.getTimeperiod())) { // 早餐后2小时
					afterBr.add(json);
				}else if("3".equals(obsr.getTimeperiod())) { // 午餐前
					bfLunch.add(json);
				}else if("4".equals(obsr.getTimeperiod())) { // 午餐后2小时
					afLunch.add(json);
				}else if("5".equals(obsr.getTimeperiod())) { //  晚餐前
					bfAf.add(json);
				}else if("6".equals(obsr.getTimeperiod())) { // 晚餐后2小时
					afAf.add(json);
				}else if("7".equals(obsr.getTimeperiod())) { // 睡觉前
					bfSleep.add(json);
				}else if("8".equals(obsr.getTimeperiod())) { // 夜间
					midNight.add(json);
				}
			}
			object.put("other", other);
			object.put("kongfu", kongfu);
			object.put("afterBr", afterBr);
			object.put("bfLunch", bfLunch);
			object.put("afLunch", afLunch);
			object.put("bfAf", bfAf);
			object.put("afAf", afAf);
			object.put("bfSleep", bfSleep);
			object.put("midNight", midNight);
		}
		return object;
	}


	/** 
	     * @Title: send 
	     * @Description: 动态心电的24小时异常心电分布图Json数据(24小时异常心电分布图--动态心电)
	     * @param  
	     * @throws      
	     * @retrun  
	     *  @see com.bithealth.measureCore.facade.Facade#selectElectrocardioExcTrendChartJson(java.lang.Integer, int)
	     */
	public Map<String, Object> selectElectrocardioExcTrendChartJson(Integer memberId,
			int reportNo) {
		List<Ecg2Chart> list = electrocardioService.selectElectrocardioExcTrendChartData(memberId, reportNo);
		
		Map<String, Object> chart = new LinkedHashMap<String, Object>();
		JSONArray Polycardia = new JSONArray();
		JSONArray Bradycardia = new JSONArray();
		JSONArray Arrest = new JSONArray();
		JSONArray Missed = new JSONArray();
		JSONArray Wide = new JSONArray();
		JSONArray PVB = new JSONArray();
		JSONArray APB = new JSONArray();
		JSONArray Insert_PVB = new JSONArray();
		JSONArray VT = new JSONArray();
		JSONArray Bigeminy = new JSONArray();
		JSONArray Trigeminy = new JSONArray();
		JSONArray Arrhythmia = new JSONArray();
		if(list != null && list.size() > 0){
			for(Ecg2Chart e2 : list){
				JSONObject jsonObj = new JSONObject();
				String time = e2.getMeasTimes() == null ? "0:00" : e2.getMeasTimes().replace(":", ".");
				jsonObj.put(time, e2.getAbnnum());
				
				if("Polycardia".equals(e2.getAbnname())){
					Polycardia.add(jsonObj);
				}else if("Bradycardia".equals(e2.getAbnname())){
					Bradycardia.add(jsonObj);
				}else if("Arrest".equals(e2.getAbnname())){
					Arrest.add(jsonObj);
				}else if("Missed".equals(e2.getAbnname())){
					Missed.add(jsonObj);
				}else if("Wide".equals(e2.getAbnname())){
					Wide.add(jsonObj);
				}else if("PVB".equals(e2.getAbnname())){
					PVB.add(jsonObj);
				}else if("PAB".equals(e2.getAbnname())){
					APB.add(jsonObj);
				}else if("Insert_PVB".equals(e2.getAbnname())){
					Insert_PVB.add(jsonObj);
				}else if("VT".equals(e2.getAbnname())){
					VT.add(jsonObj);
				}else if("Bigeminy".equals(e2.getAbnname())){
					Bigeminy.add(jsonObj);
				}else if("Trigeminy".equals(e2.getAbnname())){
					Trigeminy.add(jsonObj);
				}else if("Arrhythmia".equals(e2.getAbnname())){
					Arrhythmia.add(jsonObj);
				}else{
					continue;
				}
			}
		}
		chart.put(ElectrocardioType.getTypeChinaName("Polycardia"), Polycardia);		//心动过速
		chart.put(ElectrocardioType.getTypeChinaName("Bradycardia"), Bradycardia);		//心动过缓
		chart.put(ElectrocardioType.getTypeChinaName("Arrest"), Arrest);				//停搏
		chart.put(ElectrocardioType.getTypeChinaName("Missed"), Missed);				//漏搏
		chart.put(ElectrocardioType.getTypeChinaName("Wide"), Wide);					//宽搏
		chart.put(ElectrocardioType.getTypeChinaName("PVB"), PVB);						//室性早搏
		chart.put(ElectrocardioType.getTypeChinaName("PAB"), APB);						//房性早搏
		chart.put(ElectrocardioType.getTypeChinaName("Insert_PVB"), Insert_PVB);		//插入性室早搏
		chart.put(ElectrocardioType.getTypeChinaName("VT"), VT);						//阵发性心动过速
		chart.put(ElectrocardioType.getTypeChinaName("Bigeminy"), Bigeminy);			//二联律
		chart.put(ElectrocardioType.getTypeChinaName("Trigeminy"), Trigeminy);			//三联律
		chart.put(ElectrocardioType.getTypeChinaName("Arrhythmia"), Arrhythmia);		//心律不齐
		
		return chart;
	}
	
	public Map<String, Object> selectElectrocardioExcTrendChartJson(List<Oecg> oecgs) {
		List<Ecg2Chart> list = electrocardioService.selectElectrocardioExcTrendChartData(oecgs);
		
		Map<String, Object> chart = new LinkedHashMap<String, Object>();
		JSONArray Polycardia = new JSONArray();
		JSONArray Bradycardia = new JSONArray();
		JSONArray Arrest = new JSONArray();
		JSONArray Missed = new JSONArray();
		JSONArray Wide = new JSONArray();
		JSONArray PVB = new JSONArray();
		JSONArray APB = new JSONArray();
		JSONArray Insert_PVB = new JSONArray();
		JSONArray VT = new JSONArray();
		JSONArray Bigeminy = new JSONArray();
		JSONArray Trigeminy = new JSONArray();
		JSONArray Arrhythmia = new JSONArray();
		if(list != null && list.size() > 0){
			for(Ecg2Chart e2 : list){
				JSONObject jsonObj = new JSONObject();
				String time = e2.getMeasTimes() == null ? "0:00" : e2.getMeasTimes().replace(":", ".");
				jsonObj.put(time, e2.getAbnnum());
				
				if("Polycardia".equals(e2.getAbnname())){
					Polycardia.add(jsonObj);
				}else if("Bradycardia".equals(e2.getAbnname())){
					Bradycardia.add(jsonObj);
				}else if("Arrest".equals(e2.getAbnname())){
					Arrest.add(jsonObj);
				}else if("Missed".equals(e2.getAbnname())){
					Missed.add(jsonObj);
				}else if("Wide".equals(e2.getAbnname())){
					Wide.add(jsonObj);
				}else if("PVB".equals(e2.getAbnname())){
					PVB.add(jsonObj);
				}else if("PAB".equals(e2.getAbnname())){
					APB.add(jsonObj);
				}else if("Insert_PVB".equals(e2.getAbnname())){
					Insert_PVB.add(jsonObj);
				}else if("VT".equals(e2.getAbnname())){
					VT.add(jsonObj);
				}else if("Bigeminy".equals(e2.getAbnname())){
					Bigeminy.add(jsonObj);
				}else if("Trigeminy".equals(e2.getAbnname())){
					Trigeminy.add(jsonObj);
				}else if("Arrhythmia".equals(e2.getAbnname())){
					Arrhythmia.add(jsonObj);
				}else{
					continue;
				}
			}
		}
		chart.put(ElectrocardioType.getTypeChinaName("Polycardia"), Polycardia);		//心动过速
		chart.put(ElectrocardioType.getTypeChinaName("Bradycardia"), Bradycardia);		//心动过缓
		chart.put(ElectrocardioType.getTypeChinaName("Arrest"), Arrest);				//停搏
		chart.put(ElectrocardioType.getTypeChinaName("Missed"), Missed);				//漏搏
		chart.put(ElectrocardioType.getTypeChinaName("Wide"), Wide);					//宽搏
		chart.put(ElectrocardioType.getTypeChinaName("PVB"), PVB);						//室性早搏
		chart.put(ElectrocardioType.getTypeChinaName("PAB"), APB);						//房性早搏
		chart.put(ElectrocardioType.getTypeChinaName("Insert_PVB"), Insert_PVB);		//插入性室早搏
		chart.put(ElectrocardioType.getTypeChinaName("VT"), VT);						//阵发性心动过速
		chart.put(ElectrocardioType.getTypeChinaName("Bigeminy"), Bigeminy);			//二联律
		chart.put(ElectrocardioType.getTypeChinaName("Trigeminy"), Trigeminy);			//三联律
		chart.put(ElectrocardioType.getTypeChinaName("Arrhythmia"), Arrhythmia);		//心律不齐
		
		return chart;
	}



	/** 
	     * @Title: send 
	     * @Description: 动态心电的异常心电柱状图Json数据（异常心电柱状图--动态心电）
	     * @param  
	     * @throws      
	     * @retrun  
	     *  @see com.bithealth.measureCore.facade.Facade#selectElectrocardioExcBarChartJson(java.lang.Integer, int)
	     */
	public Map<String, Object> selectElectrocardioExcBarChartJson(Integer memberId,
			int reportNo) {
		List<Ecg2Chart> list = electrocardioService.selectElectrocardioExcBarChartData(memberId, reportNo);
		
		Map<String, Object> chart = new LinkedHashMap<String, Object>();
		chart.put(ElectrocardioType.getTypeChinaName("Polycardia"), 0);		//心动过速
		chart.put(ElectrocardioType.getTypeChinaName("Bradycardia"), 0);		//心动过缓
		chart.put(ElectrocardioType.getTypeChinaName("Arrest"), 0);			//停搏
		chart.put(ElectrocardioType.getTypeChinaName("Missed"), 0);			//漏搏
		chart.put(ElectrocardioType.getTypeChinaName("Wide"), 0);				//宽搏
		chart.put(ElectrocardioType.getTypeChinaName("PVB"), 0);				//室性早搏
		chart.put(ElectrocardioType.getTypeChinaName("PAB"), 0);				//房性早搏
		chart.put(ElectrocardioType.getTypeChinaName("Insert_PVB"), 0);		//插入性室早搏
		chart.put(ElectrocardioType.getTypeChinaName("VT"), 0);				//阵发性心动过速
		chart.put(ElectrocardioType.getTypeChinaName("Bigeminy"), 0);			//二联律
		chart.put(ElectrocardioType.getTypeChinaName("Trigeminy"), 0);			//三联律
		chart.put(ElectrocardioType.getTypeChinaName("Arrhythmia"), 0);		//心律不齐
		if(list != null && list.size() > 0){
			for(Ecg2Chart e2 : list){
				if(ElectrocardioType.getTypeChinaName(e2.getAbnname()) != null){
					chart.put(ElectrocardioType.getTypeChinaName(e2.getAbnname()), e2.getNum());	//覆盖操作
				}
			}
		}

		return chart;
	}
	
	public Map<String, Object> selectElectrocardioExcBarChartJson(List<Oecg> oecgs) {
		List<Ecg2Chart> list = electrocardioService.selectElectrocardioExcBarChartData(oecgs);
		
		Map<String, Object> chart = new LinkedHashMap<String, Object>();
		chart.put(ElectrocardioType.getTypeChinaName("Polycardia"), 0);		//心动过速
		chart.put(ElectrocardioType.getTypeChinaName("Bradycardia"), 0);		//心动过缓
		chart.put(ElectrocardioType.getTypeChinaName("Arrest"), 0);			//停搏
		chart.put(ElectrocardioType.getTypeChinaName("Missed"), 0);			//漏搏
		chart.put(ElectrocardioType.getTypeChinaName("Wide"), 0);				//宽搏
		chart.put(ElectrocardioType.getTypeChinaName("PVB"), 0);				//室性早搏
		chart.put(ElectrocardioType.getTypeChinaName("PAB"), 0);				//房性早搏
		chart.put(ElectrocardioType.getTypeChinaName("Insert_PVB"), 0);		//插入性室早搏
		chart.put(ElectrocardioType.getTypeChinaName("VT"), 0);				//阵发性心动过速
		chart.put(ElectrocardioType.getTypeChinaName("Bigeminy"), 0);			//二联律
		chart.put(ElectrocardioType.getTypeChinaName("Trigeminy"), 0);			//三联律
		chart.put(ElectrocardioType.getTypeChinaName("Arrhythmia"), 0);		//心律不齐
		if(list != null && list.size() > 0){
			for(Ecg2Chart e2 : list){
				if(ElectrocardioType.getTypeChinaName(e2.getAbnname()) != null){
					chart.put(ElectrocardioType.getTypeChinaName(e2.getAbnname()), e2.getNum());	//覆盖操作
				}
			}
		}

		return chart;
	}

	
	/** 
	     * @Title: send 
	     * @Description: 三合一的24小时异常心电分布图Json数据（24小时异常心电分布图--三合一）
	     * @param  
	     * @throws      
	     * @retrun  
	     *  @see com.bithealth.measureCore.facade.Facade#selectElectrocardioPulseExcTrendChartJson(java.lang.Integer, int)
	     */
	public Map<String, Object> selectElectrocardioPulseExcTrendChartJson(
			Integer memberId, int reportNo) {
		List<Ecg2Chart> list = pulseService.selectElectrocardioPulseExcTrendChartData(memberId, reportNo);
		
		Map<String, Object> chart = new LinkedHashMap<String, Object>();
		JSONArray Polycardia = new JSONArray();
		JSONArray Bradycardia = new JSONArray();
		JSONArray Arrest = new JSONArray();
		JSONArray Missed = new JSONArray();
		JSONArray Wide = new JSONArray();
		JSONArray PVB = new JSONArray();
		JSONArray APB = new JSONArray();
		JSONArray Insert_PVB = new JSONArray();
		JSONArray VT = new JSONArray();
		JSONArray Bigeminy = new JSONArray();
		JSONArray Trigeminy = new JSONArray();
		JSONArray Arrhythmia = new JSONArray();
		if(list != null && list.size() > 0){
			for(Ecg2Chart e2 : list){
				JSONObject jsonObj = new JSONObject();
				String time = e2.getMeasTimes() == null ? "0:00" : e2.getMeasTimes().replace(":", ".");
				jsonObj.put(time, e2.getAbnnum());
				
				if("Polycardia".equals(e2.getAbnname())){
					Polycardia.add(jsonObj);
				}else if("Bradycardia".equals(e2.getAbnname())){
					Bradycardia.add(jsonObj);
				}else if("Arrest".equals(e2.getAbnname())){
					Arrest.add(jsonObj);
				}else if("Missed".equals(e2.getAbnname())){
					Missed.add(jsonObj);
				}else if("Wide".equals(e2.getAbnname())){
					Wide.add(jsonObj);
				}else if("PVB".equals(e2.getAbnname())){
					PVB.add(jsonObj);
				}else if("PAB".equals(e2.getAbnname())){
					APB.add(jsonObj);
				}else if("Insert_PVB".equals(e2.getAbnname())){
					Insert_PVB.add(jsonObj);
				}else if("VT".equals(e2.getAbnname())){
					VT.add(jsonObj);
				}else if("Bigeminy".equals(e2.getAbnname())){
					Bigeminy.add(jsonObj);
				}else if("Trigeminy".equals(e2.getAbnname())){
					Trigeminy.add(jsonObj);
				}else if("Arrhythmia".equals(e2.getAbnname())){
					Arrhythmia.add(jsonObj);
				}else{
					continue;
				}
			}
		}
		chart.put(ElectrocardioType.getTypeChinaName("Polycardia"), Polycardia);		//心动过速
		chart.put(ElectrocardioType.getTypeChinaName("Bradycardia"), Bradycardia);		//心动过缓
		chart.put(ElectrocardioType.getTypeChinaName("Arrest"), Arrest);				//停搏
		chart.put(ElectrocardioType.getTypeChinaName("Missed"), Missed);				//漏搏
		chart.put(ElectrocardioType.getTypeChinaName("Wide"), Wide);					//宽搏
		chart.put(ElectrocardioType.getTypeChinaName("PVB"), PVB);						//室性早搏
		chart.put(ElectrocardioType.getTypeChinaName("PAB"), APB);						//房性早搏
		chart.put(ElectrocardioType.getTypeChinaName("Insert_PVB"), Insert_PVB);		//插入性室早搏
		chart.put(ElectrocardioType.getTypeChinaName("VT"), VT);						//阵发性心动过速
		chart.put(ElectrocardioType.getTypeChinaName("Bigeminy"), Bigeminy);			//二联律
		chart.put(ElectrocardioType.getTypeChinaName("Trigeminy"), Trigeminy);			//三联律
		chart.put(ElectrocardioType.getTypeChinaName("Arrhythmia"), Arrhythmia);		//心律不齐
		
		return chart;
	}

	public Map<String, Object> selectElectrocardioPulseExcTrendChartJson(List<Oecg> oecgs) {
		List<Ecg2Chart> list = pulseService.selectElectrocardioPulseExcTrendChartData(oecgs);
		
		Map<String, Object> chart = new LinkedHashMap<String, Object>();
		JSONArray Polycardia = new JSONArray();
		JSONArray Bradycardia = new JSONArray();
		JSONArray Arrest = new JSONArray();
		JSONArray Missed = new JSONArray();
		JSONArray Wide = new JSONArray();
		JSONArray PVB = new JSONArray();
		JSONArray APB = new JSONArray();
		JSONArray Insert_PVB = new JSONArray();
		JSONArray VT = new JSONArray();
		JSONArray Bigeminy = new JSONArray();
		JSONArray Trigeminy = new JSONArray();
		JSONArray Arrhythmia = new JSONArray();
		if(list != null && list.size() > 0){
			for(Ecg2Chart e2 : list){
				JSONObject jsonObj = new JSONObject();
				String time = e2.getMeasTimes() == null ? "0:00" : e2.getMeasTimes().replace(":", ".");
				jsonObj.put(time, e2.getAbnnum());
				
				if("Polycardia".equals(e2.getAbnname())){
					Polycardia.add(jsonObj);
				}else if("Bradycardia".equals(e2.getAbnname())){
					Bradycardia.add(jsonObj);
				}else if("Arrest".equals(e2.getAbnname())){
					Arrest.add(jsonObj);
				}else if("Missed".equals(e2.getAbnname())){
					Missed.add(jsonObj);
				}else if("Wide".equals(e2.getAbnname())){
					Wide.add(jsonObj);
				}else if("PVB".equals(e2.getAbnname())){
					PVB.add(jsonObj);
				}else if("PAB".equals(e2.getAbnname())){
					APB.add(jsonObj);
				}else if("Insert_PVB".equals(e2.getAbnname())){
					Insert_PVB.add(jsonObj);
				}else if("VT".equals(e2.getAbnname())){
					VT.add(jsonObj);
				}else if("Bigeminy".equals(e2.getAbnname())){
					Bigeminy.add(jsonObj);
				}else if("Trigeminy".equals(e2.getAbnname())){
					Trigeminy.add(jsonObj);
				}else if("Arrhythmia".equals(e2.getAbnname())){
					Arrhythmia.add(jsonObj);
				}else{
					continue;
				}
			}
		}
		chart.put(ElectrocardioType.getTypeChinaName("Polycardia"), Polycardia);		//心动过速
		chart.put(ElectrocardioType.getTypeChinaName("Bradycardia"), Bradycardia);		//心动过缓
		chart.put(ElectrocardioType.getTypeChinaName("Arrest"), Arrest);				//停搏
		chart.put(ElectrocardioType.getTypeChinaName("Missed"), Missed);				//漏搏
		chart.put(ElectrocardioType.getTypeChinaName("Wide"), Wide);					//宽搏
		chart.put(ElectrocardioType.getTypeChinaName("PVB"), PVB);						//室性早搏
		chart.put(ElectrocardioType.getTypeChinaName("PAB"), APB);						//房性早搏
		chart.put(ElectrocardioType.getTypeChinaName("Insert_PVB"), Insert_PVB);		//插入性室早搏
		chart.put(ElectrocardioType.getTypeChinaName("VT"), VT);						//阵发性心动过速
		chart.put(ElectrocardioType.getTypeChinaName("Bigeminy"), Bigeminy);			//二联律
		chart.put(ElectrocardioType.getTypeChinaName("Trigeminy"), Trigeminy);			//三联律
		chart.put(ElectrocardioType.getTypeChinaName("Arrhythmia"), Arrhythmia);		//心律不齐
		
		return chart;
	}


	/** 
	     * @Title: send 
	     * @Description: 三合一的异常心电柱状图Json数据(异常心电柱状图--三合一)
	     * @param  
	     * @throws      
	     * @retrun  
	     *  @see com.bithealth.measureCore.facade.Facade#selectElectrocardioPulseExcBarChartJson(java.lang.Integer, int)
	     */
	public Map<String, Object> selectElectrocardioPulseExcBarChartJson(Integer memberId,
			int reportNo) {
		List<Ecg2Chart> list = pulseService.selectElectrocardioPulseExcBarChartData(memberId, reportNo);
		
		Map<String, Object> chart = new LinkedHashMap<String, Object>();
		chart.put(ElectrocardioType.getTypeChinaName("Polycardia"), 0);		//心动过速
		chart.put(ElectrocardioType.getTypeChinaName("Bradycardia"), 0);		//心动过缓
		chart.put(ElectrocardioType.getTypeChinaName("Arrest"), 0);			//停搏
		chart.put(ElectrocardioType.getTypeChinaName("Missed"), 0);			//漏搏
		chart.put(ElectrocardioType.getTypeChinaName("Wide"), 0);				//宽搏
		chart.put(ElectrocardioType.getTypeChinaName("PVB"), 0);				//室性早搏
		chart.put(ElectrocardioType.getTypeChinaName("PAB"), 0);				//房性早搏
		chart.put(ElectrocardioType.getTypeChinaName("Insert_PVB"), 0);		//插入性室早搏
		chart.put(ElectrocardioType.getTypeChinaName("VT"), 0);				//阵发性心动过速
		chart.put(ElectrocardioType.getTypeChinaName("Bigeminy"), 0);			//二联律
		chart.put(ElectrocardioType.getTypeChinaName("Trigeminy"), 0);			//三联律
		chart.put(ElectrocardioType.getTypeChinaName("Arrhythmia"), 0);		//心律不齐
		if(list != null && list.size() > 0){
			for(Ecg2Chart e2 : list){
				if(ElectrocardioType.getTypeChinaName(e2.getAbnname()) != null){
					chart.put(ElectrocardioType.getTypeChinaName(e2.getAbnname()), e2.getNum());	//覆盖操作
				}
			}
		}

		return chart;
	}
	
	public Map<String, Object> selectElectrocardioPulseExcBarChartJson(List<Oecg> oecgs) {
		List<Ecg2Chart> list = pulseService.selectElectrocardioPulseExcBarChartData(oecgs);
		
		Map<String, Object> chart = new LinkedHashMap<String, Object>();
		chart.put(ElectrocardioType.getTypeChinaName("Polycardia"), 0);		//心动过速
		chart.put(ElectrocardioType.getTypeChinaName("Bradycardia"), 0);		//心动过缓
		chart.put(ElectrocardioType.getTypeChinaName("Arrest"), 0);			//停搏
		chart.put(ElectrocardioType.getTypeChinaName("Missed"), 0);			//漏搏
		chart.put(ElectrocardioType.getTypeChinaName("Wide"), 0);				//宽搏
		chart.put(ElectrocardioType.getTypeChinaName("PVB"), 0);				//室性早搏
		chart.put(ElectrocardioType.getTypeChinaName("PAB"), 0);				//房性早搏
		chart.put(ElectrocardioType.getTypeChinaName("Insert_PVB"), 0);		//插入性室早搏
		chart.put(ElectrocardioType.getTypeChinaName("VT"), 0);				//阵发性心动过速
		chart.put(ElectrocardioType.getTypeChinaName("Bigeminy"), 0);			//二联律
		chart.put(ElectrocardioType.getTypeChinaName("Trigeminy"), 0);			//三联律
		chart.put(ElectrocardioType.getTypeChinaName("Arrhythmia"), 0);		//心律不齐
		if(list != null && list.size() > 0){
			for(Ecg2Chart e2 : list){
				if(ElectrocardioType.getTypeChinaName(e2.getAbnname()) != null){
					chart.put(ElectrocardioType.getTypeChinaName(e2.getAbnname()), e2.getNum());	//覆盖操作
				}
			}
		}

		return chart;
	}


	/** 
	     * @Title: send 
	     * @Description: 24小时脉搏指标分布图json数据(24小时脉搏指标分布图--三合一)
	     * @param  
	     * @throws      
	     * @retrun  
	     *  @see com.bithealth.measureCore.facade.Facade#selectPulseIndicatorsTrendChartJson(java.lang.Integer, int)
	     */
	public Map<String, Object> selectPulseIndicatorsTrendChartJson(Integer memberId,
			int reportNo) {
		List<OppgChart> list = pulseService.selectPulseIndicatorsTrendChartData(memberId, reportNo);
		
		Map<String, Object> chart = new LinkedHashMap<String, Object>();
		JSONArray pulseRate = new JSONArray();
		JSONArray Co = new JSONArray();
		JSONArray Sv = new JSONArray();
		JSONArray Spo = new JSONArray();
		
		JSONArray K = new JSONArray();
		JSONArray Ac = new JSONArray();
		JSONArray Si = new JSONArray();
		JSONArray V = new JSONArray();
		JSONArray Tpr = new JSONArray();
		JSONArray Ci = new JSONArray();
		JSONArray Spi = new JSONArray();
		JSONArray Pm = new JSONArray();
		
		SimpleDateFormat sdf = new SimpleDateFormat("H:m");
		
		if(list != null && list.size() > 0){
			for(OppgChart op : list){
				String key = op.getMeasuretime() == null ? "0:00" : sdf.format(op.getMeasuretime()).replace(":", ".");
				
				JSONObject p = new JSONObject();
				p.put(key, op.getPulserate());
				pulseRate.add(p);
				
				JSONObject c = new JSONObject();
				c.put(key, op.getCo());
				Co.add(c);
				
				JSONObject sv = new JSONObject();
				sv.put(key, op.getSv());
				Sv.add(sv);
				
				JSONObject sp = new JSONObject();
				sp.put(key, op.getSpo());
				Spo.add(sp);
				
				JSONObject k = new JSONObject();
				k.put(key, op.getK());
				K.add(k);
				
				JSONObject ac = new JSONObject();
				ac.put(key, op.getAc());
				Ac.add(ac);
				
				JSONObject si = new JSONObject();
				si.put(key, op.getSi());
				Si.add(si);
				
				JSONObject v = new JSONObject();
				v.put(key, op.getV());
				V.add(v);
				
				JSONObject tpr = new JSONObject();
				tpr.put(key, op.getTpr());
				Tpr.add(tpr);
				
				JSONObject ci = new JSONObject();
				ci.put(key, op.getCi());
				Ci.add(ci);
				
				JSONObject spi = new JSONObject();
				spi.put(key, op.getSpi());
				Spi.add(spi);
				
				JSONObject pm = new JSONObject();
				pm.put(key, op.getPm());
				Pm.add(pm);
			}
		}
		chart.put(PulseType.getPulseTypeName("PR"), pulseRate);
		chart.put(PulseType.getPulseTypeName("CO"), Co);
		chart.put(PulseType.getPulseTypeName("SV"), Sv);
		chart.put(PulseType.getPulseTypeName("SPO"), Spo);
		
		chart.put(PulseType.getPulseTypeName("K"), K);
		chart.put(PulseType.getPulseTypeName("AC"), Ac);
		chart.put(PulseType.getPulseTypeName("SI"), Si);
		chart.put(PulseType.getPulseTypeName("V"), V);
		chart.put(PulseType.getPulseTypeName("TPR"), Tpr);
		chart.put(PulseType.getPulseTypeName("CI"), Ci);
		chart.put(PulseType.getPulseTypeName("SPI"), Spi);
		chart.put(PulseType.getPulseTypeName("PM"), Pm);

		return chart;
	}
	
	public Map<String, Object> selectPulseIndicatorsTrendChartJson(List<Oecg> oecgs) {
		List<OppgChart> list = pulseService.selectPulseIndicatorsTrendChartData(oecgs);
		
		Map<String, Object> chart = new LinkedHashMap<String, Object>();
		JSONArray pulseRate = new JSONArray();
		JSONArray Co = new JSONArray();
		JSONArray Sv = new JSONArray();
		JSONArray Spo = new JSONArray();
		
		JSONArray K = new JSONArray();
		JSONArray Ac = new JSONArray();
		JSONArray Si = new JSONArray();
		JSONArray V = new JSONArray();
		JSONArray Tpr = new JSONArray();
		JSONArray Ci = new JSONArray();
		JSONArray Spi = new JSONArray();
		JSONArray Pm = new JSONArray();
		
		SimpleDateFormat sdf = new SimpleDateFormat("H:m");
		
		if(list != null && list.size() > 0){
			for(OppgChart op : list){
				String key = op.getMeasuretime() == null ? "0:00" : sdf.format(op.getMeasuretime()).replace(":", ".");
				
				JSONObject p = new JSONObject();
				p.put(key, op.getPulserate());
				pulseRate.add(p);
				
				JSONObject c = new JSONObject();
				c.put(key, op.getCo());
				Co.add(c);
				
				JSONObject sv = new JSONObject();
				sv.put(key, op.getSv());
				Sv.add(sv);
				
				JSONObject sp = new JSONObject();
				sp.put(key, op.getSpo());
				Spo.add(sp);
				
				JSONObject k = new JSONObject();
				k.put(key, op.getK());
				K.add(k);
				
				JSONObject ac = new JSONObject();
				ac.put(key, op.getAc());
				Ac.add(ac);
				
				JSONObject si = new JSONObject();
				si.put(key, op.getSi());
				Si.add(si);
				
				JSONObject v = new JSONObject();
				v.put(key, op.getV());
				V.add(v);
				
				JSONObject tpr = new JSONObject();
				tpr.put(key, op.getTpr());
				Tpr.add(tpr);
				
				JSONObject ci = new JSONObject();
				ci.put(key, op.getCi());
				Ci.add(ci);
				
				JSONObject spi = new JSONObject();
				spi.put(key, op.getSpi());
				Spi.add(spi);
				
				JSONObject pm = new JSONObject();
				pm.put(key, op.getPm());
				Pm.add(pm);
			}
		}
		chart.put(PulseType.getPulseTypeName("PR"), pulseRate);
		chart.put(PulseType.getPulseTypeName("CO"), Co);
		chart.put(PulseType.getPulseTypeName("SV"), Sv);
		chart.put(PulseType.getPulseTypeName("SPO"), Spo);
		
		chart.put(PulseType.getPulseTypeName("K"), K);
		chart.put(PulseType.getPulseTypeName("AC"), Ac);
		chart.put(PulseType.getPulseTypeName("SI"), Si);
		chart.put(PulseType.getPulseTypeName("V"), V);
		chart.put(PulseType.getPulseTypeName("TPR"), Tpr);
		chart.put(PulseType.getPulseTypeName("CI"), Ci);
		chart.put(PulseType.getPulseTypeName("SPI"), Spi);
		chart.put(PulseType.getPulseTypeName("PM"), Pm);

		return chart;
	}

	
	public Map<String, Object> selectPulseAllTrends(Integer memberId,
			int reportNo){
		List<OppgChart> list = pulseService.selectPulseIndicatorsTrendChartData(memberId, reportNo);
		
		Map<String, Object> chart = new LinkedHashMap<String, Object>();
		JSONArray arr = new JSONArray();
		JSONArray pulseRate1 = new JSONArray();
		JSONArray Co1 = new JSONArray();
		JSONArray Sv1 = new JSONArray();
		JSONArray Spo1 = new JSONArray();
		
		JSONArray K1 = new JSONArray();
		JSONArray Ac1 = new JSONArray();
		JSONArray Si1 = new JSONArray();
		JSONArray V1 = new JSONArray();
		JSONArray Tpr1 = new JSONArray();
		JSONArray Ci1 = new JSONArray();
		JSONArray Spi1 = new JSONArray();
		JSONArray Pm1 = new JSONArray();
		
		if(list != null && list.size() > 0){
			for(OppgChart op : list){
				long key = 0;
				if(op.getMeasuretime() != null){
					key = op.getMeasuretime().getTime();
				}
				
				JSONArray p = new JSONArray();
				p.add(key);
				p.add(op.getPulserate());
				pulseRate1.add(p);
				
				JSONArray c = new JSONArray();
				c.add(key);
				c.add(op.getCo());
				Co1.add(c);
				
				JSONArray sv = new JSONArray();
				sv.add(key);
				sv.add(op.getSv());
				Sv1.add(sv);
				
				JSONArray sp = new JSONArray();
				sp.add(key);
				sp.add(op.getSpo());
				Spo1.add(sp);
				
				JSONArray k = new JSONArray();
				k.add(key);
				k.add(op.getK());
				K1.add(k);
				
				JSONArray ac = new JSONArray();
				ac.add(key);
				ac.add(op.getAc());
				Ac1.add(ac);
				
				JSONArray si = new JSONArray();
				si.add(key);
				si.add(op.getSi());
				Si1.add(si);
				
				JSONArray v = new JSONArray();
				v.add(key);
				v.add(op.getV());
				V1.add(v);
				
				JSONArray tpr = new JSONArray();
				tpr.add(key);
				tpr.add(op.getTpr());
				Tpr1.add(tpr);
				
				JSONArray ci = new JSONArray();
				ci.add(key);
				ci.add(op.getCi());
				Ci1.add(ci);
				
				JSONArray spi = new JSONArray();
				spi.add(key);
				spi.add(op.getSpi());
				Spi1.add(spi);
				
				JSONArray pm = new JSONArray();
				pm.add(key);
				pm.add(op.getPm());
				Pm1.add(pm);
			}
		}
		
		JSONObject json_1 = new JSONObject();
		json_1.put("shortName", "PR");
		json_1.put("name", PulseType.getPulseTypeName("PR"));
		json_1.put("data", pulseRate1);
		arr.add(json_1);
		
		JSONObject json_2 = new JSONObject();
		json_2.put("shortName", "CO");
		json_2.put("name", PulseType.getPulseTypeName("CO"));
		json_2.put("data", Co1);
		arr.add(json_2);
		
		JSONObject json_3 = new JSONObject();
		json_3.put("shortName", "SV");
		json_3.put("name",PulseType.getPulseTypeName("SV"));
		json_3.put("data", Sv1);
		arr.add(json_3);
		
		JSONObject json_4 = new JSONObject();
		json_4.put("shortName", "SPO");
		json_4.put("name", PulseType.getPulseTypeName("SPO"));
		json_4.put("data", Spo1);
		arr.add(json_4);
		
		JSONObject json_5 = new JSONObject();
		json_5.put("shortName", "K");
		json_5.put("name", PulseType.getPulseTypeName("K"));
		json_5.put("data", K1);
		arr.add(json_5);
		
		JSONObject json_6 = new JSONObject();
		json_6.put("shortName", "AC");
		json_6.put("name", PulseType.getPulseTypeName("AC"));
		json_6.put("data", Ac1);
		arr.add(json_6);
		
		JSONObject json_7 = new JSONObject();
		json_7.put("shortName", "SI");
		json_7.put("name", PulseType.getPulseTypeName("SI"));
		json_7.put("data", Si1);
		arr.add(json_7);
		
		JSONObject json_8 = new JSONObject();
		json_8.put("shortName", "V");
		json_8.put("name", PulseType.getPulseTypeName("V"));
		json_8.put("data", V1);
		arr.add(json_8);
		
		JSONObject json_9 = new JSONObject();
		json_9.put("shortName", "TPR");
		json_9.put("name", PulseType.getPulseTypeName("TPR"));
		json_9.put("data", Tpr1);
		arr.add(json_9);
		
		JSONObject json_10 = new JSONObject();
		json_10.put("shortName", "CI");
		json_10.put("name", PulseType.getPulseTypeName("CI"));
		json_10.put("data", Ci1);
		arr.add(json_10);
		
		JSONObject json_11 = new JSONObject();
		json_11.put("shortName", "SPI");
		json_11.put("name", PulseType.getPulseTypeName("SPI"));
		json_11.put("data", Spi1);
		arr.add(json_11);
		
		JSONObject json_12 = new JSONObject();
		json_12.put("shortName", "PM");
		json_12.put("name", PulseType.getPulseTypeName("PM"));
		json_12.put("data", Pm1);
		arr.add(json_12);
		
		chart.put("pulseTreChart", arr);
		return chart;
	}
	
	public Map<String, Object> selectPulseAllTrends(List<Oecg> oecgs){
		List<OppgChart> list = pulseService.selectPulseIndicatorsTrendChartData(oecgs);
		
		Map<String, Object> chart = new LinkedHashMap<String, Object>();
		JSONArray arr = new JSONArray();
		JSONArray pulseRate1 = new JSONArray();
		JSONArray Co1 = new JSONArray();
		JSONArray Sv1 = new JSONArray();
		JSONArray Spo1 = new JSONArray();
		
		JSONArray K1 = new JSONArray();
		JSONArray Ac1 = new JSONArray();
		JSONArray Si1 = new JSONArray();
		JSONArray V1 = new JSONArray();
		JSONArray Tpr1 = new JSONArray();
		JSONArray Ci1 = new JSONArray();
		JSONArray Spi1 = new JSONArray();
		JSONArray Pm1 = new JSONArray();
		
		if(list != null && list.size() > 0){
			for(OppgChart op : list){
				long key = 0;
				if(op.getMeasuretime() != null){
					key = op.getMeasuretime().getTime();
				}
				
				JSONArray p = new JSONArray();
				p.add(key);
				p.add(op.getPulserate());
				pulseRate1.add(p);
				
				JSONArray c = new JSONArray();
				c.add(key);
				c.add(op.getCo());
				Co1.add(c);
				
				JSONArray sv = new JSONArray();
				sv.add(key);
				sv.add(op.getSv());
				Sv1.add(sv);
				
				JSONArray sp = new JSONArray();
				sp.add(key);
				sp.add(op.getSpo());
				Spo1.add(sp);
				
				JSONArray k = new JSONArray();
				k.add(key);
				k.add(op.getK());
				K1.add(k);
				
				JSONArray ac = new JSONArray();
				ac.add(key);
				ac.add(op.getAc());
				Ac1.add(ac);
				
				JSONArray si = new JSONArray();
				si.add(key);
				si.add(op.getSi());
				Si1.add(si);
				
				JSONArray v = new JSONArray();
				v.add(key);
				v.add(op.getV());
				V1.add(v);
				
				JSONArray tpr = new JSONArray();
				tpr.add(key);
				tpr.add(op.getTpr());
				Tpr1.add(tpr);
				
				JSONArray ci = new JSONArray();
				ci.add(key);
				ci.add(op.getCi());
				Ci1.add(ci);
				
				JSONArray spi = new JSONArray();
				spi.add(key);
				spi.add(op.getSpi());
				Spi1.add(spi);
				
				JSONArray pm = new JSONArray();
				pm.add(key);
				pm.add(op.getPm());
				Pm1.add(pm);
			}
		}
		
		JSONObject json_1 = new JSONObject();
		json_1.put("shortName", "PR");
		json_1.put("name", PulseType.getPulseTypeName("PR"));
		json_1.put("data", pulseRate1);
		arr.add(json_1);
		
		JSONObject json_2 = new JSONObject();
		json_2.put("shortName", "CO");
		json_2.put("name", PulseType.getPulseTypeName("CO"));
		json_2.put("data", Co1);
		arr.add(json_2);
		
		JSONObject json_3 = new JSONObject();
		json_3.put("shortName", "SV");
		json_3.put("name",PulseType.getPulseTypeName("SV"));
		json_3.put("data", Sv1);
		arr.add(json_3);
		
		JSONObject json_4 = new JSONObject();
		json_4.put("shortName", "SPO");
		json_4.put("name", PulseType.getPulseTypeName("SPO"));
		json_4.put("data", Spo1);
		arr.add(json_4);
		
		JSONObject json_5 = new JSONObject();
		json_5.put("shortName", "K");
		json_5.put("name", PulseType.getPulseTypeName("K"));
		json_5.put("data", K1);
		arr.add(json_5);
		
		JSONObject json_6 = new JSONObject();
		json_6.put("shortName", "AC");
		json_6.put("name", PulseType.getPulseTypeName("AC"));
		json_6.put("data", Ac1);
		arr.add(json_6);
		
		JSONObject json_7 = new JSONObject();
		json_7.put("shortName", "SI");
		json_7.put("name", PulseType.getPulseTypeName("SI"));
		json_7.put("data", Si1);
		arr.add(json_7);
		
		JSONObject json_8 = new JSONObject();
		json_8.put("shortName", "V");
		json_8.put("name", PulseType.getPulseTypeName("V"));
		json_8.put("data", V1);
		arr.add(json_8);
		
		JSONObject json_9 = new JSONObject();
		json_9.put("shortName", "TPR");
		json_9.put("name", PulseType.getPulseTypeName("TPR"));
		json_9.put("data", Tpr1);
		arr.add(json_9);
		
		JSONObject json_10 = new JSONObject();
		json_10.put("shortName", "CI");
		json_10.put("name", PulseType.getPulseTypeName("CI"));
		json_10.put("data", Ci1);
		arr.add(json_10);
		
		JSONObject json_11 = new JSONObject();
		json_11.put("shortName", "SPI");
		json_11.put("name", PulseType.getPulseTypeName("SPI"));
		json_11.put("data", Spi1);
		arr.add(json_11);
		
		JSONObject json_12 = new JSONObject();
		json_12.put("shortName", "PM");
		json_12.put("name", PulseType.getPulseTypeName("PM"));
		json_12.put("data", Pm1);
		arr.add(json_12);
		
		chart.put("pulseTreChart", arr);
		return chart;
	}


	/** 
	     * @Title: send 
	     * @Description: 异常脉搏指标柱状图Json数据(异常脉搏指标柱状图--三合一)
	     * @param  
	     * @throws      
	     * @retrun  
	     *  @see com.bithealth.measureCore.facade.Facade#selectPulseIndicatorsExcBarChartJson(java.lang.Integer, int)
	     */
	public Map<String, Object> selectPulseIndicatorsExcBarChartJson(Integer memberId,
			int reportNo) {
		OppgChart op = pulseService.selectPulseIndicatorsExcBarChartData(memberId, reportNo);
		
		Map<String, Object> chart = new LinkedHashMap<String, Object>();
		if(op != null){
			chart.put(PulseType.getPulseTypeName("PR"), op.getPrNum());
			chart.put(PulseType.getPulseTypeName("SPO"), op.getSpoNum());
			chart.put(PulseType.getPulseTypeName("AC"), op.getAcNum());
			chart.put(PulseType.getPulseTypeName("V"), op.getvNum());
			
			chart.put(PulseType.getPulseTypeName("K"), op.getkNum());
			chart.put(PulseType.getPulseTypeName("SV"), op.getSvNum());
			chart.put(PulseType.getPulseTypeName("SI"), op.getSiNum());
			chart.put(PulseType.getPulseTypeName("TPR"), op.getTprnum());
			
			chart.put(PulseType.getPulseTypeName("CI"), op.getCiNum());
			chart.put(PulseType.getPulseTypeName("SPI"), op.getSpiNum());
			chart.put(PulseType.getPulseTypeName("PM"), op.getPmNum());
			chart.put(PulseType.getPulseTypeName("CO"), op.getCoNum());
		}else{
			chart.put(PulseType.getPulseTypeName("PR"), 0);
			chart.put(PulseType.getPulseTypeName("SPO"), 0);
			chart.put(PulseType.getPulseTypeName("AC"), 0);
			chart.put(PulseType.getPulseTypeName("V"), 0);
			
			chart.put(PulseType.getPulseTypeName("K"), 0);
			chart.put(PulseType.getPulseTypeName("SV"), 0);
			chart.put(PulseType.getPulseTypeName("SI"), 0);
			chart.put(PulseType.getPulseTypeName("TPR"), 0);
			
			chart.put(PulseType.getPulseTypeName("CI"), 0);
			chart.put(PulseType.getPulseTypeName("SPI"), 0);
			chart.put(PulseType.getPulseTypeName("PM"), 0);
			chart.put(PulseType.getPulseTypeName("CO"), 0);
		}
		return chart;
	}
	
	public Map<String, Object> selectPulseIndicatorsExcBarChartJson(List<Oecg> oecgs) {
		OppgChart op = pulseService.selectPulseIndicatorsExcBarChartData(oecgs);
		
		Map<String, Object> chart = new LinkedHashMap<String, Object>();
		if(op != null){
			chart.put(PulseType.getPulseTypeName("PR"), op.getPrNum());
			chart.put(PulseType.getPulseTypeName("SPO"), op.getSpoNum());
			chart.put(PulseType.getPulseTypeName("AC"), op.getAcNum());
			chart.put(PulseType.getPulseTypeName("V"), op.getvNum());
			
			chart.put(PulseType.getPulseTypeName("K"), op.getkNum());
			chart.put(PulseType.getPulseTypeName("SV"), op.getSvNum());
			chart.put(PulseType.getPulseTypeName("SI"), op.getSiNum());
			chart.put(PulseType.getPulseTypeName("TPR"), op.getTprnum());
			
			chart.put(PulseType.getPulseTypeName("CI"), op.getCiNum());
			chart.put(PulseType.getPulseTypeName("SPI"), op.getSpiNum());
			chart.put(PulseType.getPulseTypeName("PM"), op.getPmNum());
			chart.put(PulseType.getPulseTypeName("CO"), op.getCoNum());
		}else{
			chart.put(PulseType.getPulseTypeName("PR"), 0);
			chart.put(PulseType.getPulseTypeName("SPO"), 0);
			chart.put(PulseType.getPulseTypeName("AC"), 0);
			chart.put(PulseType.getPulseTypeName("V"), 0);
			
			chart.put(PulseType.getPulseTypeName("K"), 0);
			chart.put(PulseType.getPulseTypeName("SV"), 0);
			chart.put(PulseType.getPulseTypeName("SI"), 0);
			chart.put(PulseType.getPulseTypeName("TPR"), 0);
			
			chart.put(PulseType.getPulseTypeName("CI"), 0);
			chart.put(PulseType.getPulseTypeName("SPI"), 0);
			chart.put(PulseType.getPulseTypeName("PM"), 0);
			chart.put(PulseType.getPulseTypeName("CO"), 0);
		}
		return chart;
	}



	/**
	 * 
	     * @Title: send 
	     * @Description: 通过高血压值判断高血压异常
	     * @param  dbp:舒张压，sbp：收缩压
	     * @throws      
	     * @retrun  
	     *  @see com.bithealth.measureCore.facade.Facade#getBloodPressCnType(int, int)
	 */
	@Override
	public String getBloodPressCnType(int dbp, int sbp) {
		if (dbp < 60 || sbp < 90) {
			return Constant.BLOODPRES_EXC_LOW;

		} else if (dbp >= 60 && dbp <= 85 && (sbp >= 90 && sbp <= 130)) {
			return Constant.BLOODPRES_NORMAL;

		} else if ((dbp > 85 && dbp < 90) && (sbp > 130 && sbp < 140)) {
			return Constant.BLOODPRES_NORMAL_HIGH;

		} else if ((dbp >= 60 && dbp < 90) && (sbp >= 140 && sbp < 150)) {
			return Constant.BLOODPRES_EXC_ISOLATED;

		} else if ((dbp >= 90 && dbp < 100) || (sbp >= 140 && sbp < 160)) {
			return Constant.BLOODPRES_EXC_LIGHT;

		} else if ((dbp >= 100 && dbp < 110) || (sbp >= 160 && sbp < 180)) {
			return Constant.BLOODPRES_EXC_MIDDLE;

		} else if (dbp >= 110 || sbp >= 180) {
			return Constant.BLOODPRES_EXC_HIGH;

		}
			return Constant.BLOODPRES_NORMAL;
	}


	/** 
	     * @Title: send 
	     * @Description: 根据血糖值判断血糖异常情况  
	     * @param   早晨空腹(1),午餐前(3),晚餐前(5),睡前(7),夜间(8)  值为：3.9-6.1mmol/L(正常值：包括前者，不包括后者)
	     *			早餐后2小时(2),午餐后2小时(4),晚餐后2小时(6)  值为：3.9-7.8mmol/L(正常值：包括前者，不包括后者)
	     *			随机血糖(0) 值为：3.9-11.1mmol/L(正常值：包括前者，不包括后者)
	     * @throws      
	     * @retrun  
	     *  @see com.bithealth.measureCore.facade.Facade#getBloodSugarCnType(java.lang.String, int)
	     */
	@Override
	public String getBloodSugarCnType(int timePeriod, float value) {
		if (timePeriod == 1 || timePeriod == 3 || timePeriod == 5
				|| timePeriod == 7 || timePeriod == 8) {
			if (value < 3.9) {
				return Constant.BLOODSUG_EXC_LOW;
			} else if (value >= 6.1) {
				return Constant.BLOODSUG_EXC_HIGH;
			}
		} else if (timePeriod == 2 || timePeriod == 4 || timePeriod == 6) {
			if (value < 3.9) {
				return Constant.BLOODSUG_EXC_LOW;
			} else if (value >= 7.8) {
				return Constant.BLOODSUG_EXC_HIGH;
			}
		} else {
			if (value < 3.9) {
				return Constant.BLOODSUG_EXC_LOW;
			} else if (value >= 11.1) {
				return Constant.BLOODSUG_EXC_HIGH;
			}
		}
		return Constant.BLOODSUG_NORMAL;
	}
	
	
	/**
	 * @Title:calculOsbp 
	 * @Description:计算血压测量数据24小时 
	 * @author 陈哲
	 * @param osbps
	 * @return 
	 * @throws
	 * @retrun JSONObject
	 */
	public Map<String, Object> calculOsbpDataByAllDay(List<Osbp> osbps){
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
		map.put("data1", data1);
		map.put("dates", dates);

		return map;
	}
	
	
	/**
	 * @Title:calculOsbpDataByBrightDay 
	 * @Description:计算血压测量数据白天
	 * @author 陈哲
	 * @param osbps 
	 * @throws
	 * @retrun void
	 */
	public Map<String, Object> calculOsbpDataByBrightDay(List<Osbp> osbps){
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
			map.put("data2", data2);
			map.put("dates2", dates);
			
			return map;
	}
	
	
	/**
	 * @Title:calculOsbpEvening 
	 * @Description:计算血压测量数据晚上
	 * @author 陈哲
	 * @param osbps
	 * @return 
	 * @throws
	 * @retrun JSONObject
	 */
	public Map<String, Object> calculOsbpDataByEvening(List<Osbp> osbps){
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
		map.put("data3", data3);
		map.put("dates3", dates);
		
		return map;
	}


	@Override
	public void measureResultMsgSend(Integer eventId) {
		Omds omds = omdsService.selectById(eventId.longValue());
		OecgExample example = new OecgExample();
		example.createCriteria().andEventidEqualTo(eventId.longValue()).andStatustagEqualTo((short)2);//分析成功
		List<Oecg> oecgList = electrocardioService.selectByExample(example);
		
		if (oecgList != null && oecgList.size() > 0) {
			Oecg oecg = oecgList.get(0);
			Member member = memberService.selectById(oecg.getMemberid());

			// 获取日期月份和月份天数
			Calendar cal = Calendar.getInstance();
			cal.setTime(oecg.getMeastime());
			int month = cal.get(Calendar.MONTH) + 1;
			int day = cal.get(Calendar.DAY_OF_MONTH);

			StringBuilder content = new StringBuilder();
			content.append(member.getMemname() + "(??)" + month + "月" + day + "日");
			List<Ecg2> ecg2List = ecg2Service.selectEcg2ListByDocentry(oecg.getDocentry());

			if (omds.getEventtype() != null && (omds.getEventtype().equals(EventType.SAN_HE_YI.getCode()))) {
				Oppg oppg = pulseService.selectElectrocardioPulseByEventId(eventId.longValue());
				
				if(oppg.getStatustag() == 2){
					List<String> oppgResult = oppg.getMeasureResult();
					
					if(ecg2List.size() == 0 && oppgResult.size() == 0){
						content.append("三合一测量结果正常");
					}else if(ecg2List.size() == 0 && oppgResult.size() > 0){
						content.append("三合一测量：脉搏异常" + oppg.getMeasureResult().size() + "项");
					}else if(ecg2List.size() > 0 && oppgResult.size() == 0){
						content.append("三合一测量：心电异常" + ecg2List.size() + "项");
					}else{
						content.append("三合一测量：心电异常" + ecg2List.size() + "项、脉搏异常" + oppg.getMeasureResult().size() + "项");
					}
				}else{
					if(ecg2List.size() > 0){
						content.append("三合一测量：心电异常" + ecg2List.size() + "项");
					}else{
						content.append("三合一测量结果正常");
					}
				}

				MsgCenter mc = new MsgCenter();
				mc.setMsgtype(MessageTypeEnum.TRE_MEASURE.getType());
				mc.setSendtype(UserTypeEnum.DOCTOR.getType());
				mc.setSender(member.getMemberGUID());
				mc.setLastsourceid(eventId.longValue()); // 最新的消息来源ID
				mc.setLastcontent(content.toString());
				mc.setLastContentNotice(content.toString());

				try {
					careIFService.sendMsgToCareMeMember(mc);
				} catch (Exception e) {
					logger.error("上传三合一测量数据，消息推送失败！", e);
				}
			} else if (omds.getEventtype() != null && omds.getEventtype().equals(EventType.DONG_TAI_XIN_DIAN.getCode())) {
				if(ecg2List.size() == 0){
					content.append("微型动态心电测量结果正常");
				}else{
					content.append("微型动态心电测量：心电异常" + ecg2List.size() + "项");
				}
				
				MsgCenter mc = new MsgCenter();
				mc.setMsgtype(MessageTypeEnum.ECG_MEASURE.getType());
				mc.setSendtype(UserTypeEnum.DOCTOR.getType());
				mc.setSender(member.getMemberGUID());
				mc.setLastsourceid(eventId.longValue()); // 最新的消息来源ID
				mc.setLastcontent(content.toString());

				try {
					careIFService.sendMsgToCareMeMember(mc);
				} catch (Exception e) {
					logger.error("上传动态心电测量数据，消息推送失败！", e);
				}
			}
		}
	}
	
}

