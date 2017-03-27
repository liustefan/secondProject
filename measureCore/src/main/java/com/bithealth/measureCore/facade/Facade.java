 
/**
 * @PackageName:      com.bithealth.measureCore.facade
 * @FileName:     facade.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      陈哲 
 * @version      V1.0  
 * @Createdate:  2016年7月6日 下午5:19:35  
 * 
 */

package com.bithealth.measureCore.facade;

import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bithealth.measureCore.bloodPressure.model.Osbp;
import com.bithealth.measureCore.bloodPressure.model.OsbpChart;
import com.bithealth.measureCore.bloodSugar.model.Obsr;
import com.bithealth.measureCore.electrocardio.model.Oecg;


/**
 * 类名称: facade  
 * 功能描述: TODO 外部接口 
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年7月6日 下午5:19:35 
 * 
 * @author 陈哲
 * @version  
 */
public interface Facade {
	JSONArray selectBloodPresPieChartJson(Integer memberId, int reportNo);
	
	JSONArray selectBloodPresPieChartJson(List<Osbp> osbps);
	
	JSONArray selectBloodPresBarChartJson(Integer memberId, int reportNo);
	
	JSONArray selectBloodPresBarChartJson(List<Osbp> osbps);

	JSONArray selectBloodPresSubPieChartJson(Integer memberId, int reportNo);
	
	JSONArray selectBloodPresSubPieChartJson(List<Osbp> osbps);
	
	JSONObject selectBloodPresDistriChartJson(Integer memberId, int reportNo);
	
	JSONObject selectBloodPresDistriChartJson(List<Osbp> osbps);
	
	JSONObject selectBloodPresMeasTrendChartJson(Integer memberId, int reportNo);
	
	JSONObject selectBloodPresMeasTrendChartJson(List<Osbp> osbps);
	
	JSONObject selectBloodPresMeasBeforebedTrendChartJson(Integer memberId, int reportNo);
	
	JSONObject selectBloodPresMeasBeforebedTrendChartJson(List<Osbp> osbps);
	
	JSONObject selectBloodPresMeasAfterbedTrendChartJson(Integer memberId, int reportNo);
	
	JSONObject selectBloodPresMeasAfterbedTrendChartJson(List<Osbp> osbps);
	
	Map<String, Object> selectBloodSugarDistriChartJson(Integer memberId, int reportNo);
	
	Map<String, Object> selectBloodSugarDistriChartJson(List<Obsr> obsrs);
	
	Map<String, Object> selectBloodSugarDistriBoxChartJson(Integer memberId, int reportNo);
	
	Map<String, Object> selectBloodSugarDistriBoxChartJson(List<Obsr> obsrs);
	
	JSONObject selectBloodSugarMaxAndMinTrendChartJson(Integer memberId, int reportNo);
	
	JSONObject selectBloodSugarMaxAndMinTrendChartJson(List<Obsr> obsrs);
	
	Map<String, Object> selectBloodSugarTimeQPieChartJson(Integer memberId, int reportNo);
	
	Map<String, Object> selectBloodSugarTimeQPieChartJson(List<Obsr> obsrs);
	
	JSONObject selectBloodSugarMeasTrendsChartJson(Integer memberId, int reportNo);
	
	JSONObject selectBloodSugarMeasTrendsChartJson(List<Obsr> obsrs);
	
	Map<String, Object> selectElectrocardioExcTrendChartJson(Integer memberId, int reportNo);
	
	Map<String, Object> selectElectrocardioExcTrendChartJson(List<Oecg> oecgs);
	
	Map<String, Object> selectElectrocardioExcBarChartJson(Integer memberId, int reportNo);
	
	Map<String, Object> selectElectrocardioExcBarChartJson(List<Oecg> oecgs);
	
	Map<String, Object> selectElectrocardioPulseExcTrendChartJson(Integer memberId, int reportNo);
	
	Map<String, Object> selectElectrocardioPulseExcTrendChartJson(List<Oecg> oecgs);
	
	Map<String, Object> selectElectrocardioPulseExcBarChartJson(Integer memberId, int reportNo);
	
	Map<String, Object> selectElectrocardioPulseExcBarChartJson(List<Oecg> oecgs);
	
	Map<String, Object> selectPulseIndicatorsTrendChartJson(Integer memberId, int reportNo);
	
	Map<String, Object> selectPulseIndicatorsTrendChartJson(List<Oecg> oecgs);
	
	Map<String, Object> selectPulseAllTrends(Integer memberId, int reportNo);
	
	Map<String, Object> selectPulseAllTrends(List<Oecg> oecgs);
	
	Map<String, Object> selectPulseIndicatorsExcBarChartJson(Integer memberId, int reportNo);
	
	Map<String, Object> selectPulseIndicatorsExcBarChartJson(List<Oecg> oecgs);
	
	String getBloodPressCnType(int dbp, int sbp);
	
	String getBloodSugarCnType(int timePeriod, float value);
	
	Map<String, Object> calculOsbpDataByAllDay(List<Osbp> osbps);
	
	Map<String, Object> calculOsbpDataByBrightDay(List<Osbp> osbps);
	
	Map<String, Object> calculOsbpDataByEvening(List<Osbp> osbps);
	
	/**
	 * @Title:measureResultMsgSend 
	 * @Description:三合一及动态心电测量数据分析结果消息发送
	 * @author 谢美团 
	 * @throws
	 * @retrun void
	 */ 
	public void measureResultMsgSend(Integer eventId);

	//所有脉搏趋势图
	JSONObject selectPulseRateMeasTrendChartJson(List<Osbp> osbps);
}

