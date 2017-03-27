package com.bithealth.statistiCore.statistic.dao;

import java.util.List;
import java.util.Map;
/**
 * 类名称: ReportMapper  
 * 功能描述: 统计报表 查询接口
 * 日期: 2016年6月24日 下午3:49:26 
 * 
 * @author 周玉飞
 * @version  
 */
public interface StatisticMapper {
	
	/**
	 * 测量状况统计
	 * @param orgId 组织代码
	 * @param year  时间
	 * @return 统计全部数据
	 * @throws Exception 
	 */
	public List<Map<String, Object>> exProcSelectMeasurementStatics(Map<String, Object> params);
	
	/**
	 * 人口基本状况
	 * @param orgId 组织代码
	 * @param year  时间
	 * @return 统计数据
	 * @throws Exception 
	 */
	public List<Map<String, Object>> exProcSelectPopulation(Map<String, Object> params);
	
	/**
	 * 统计老年人接受健康管理状况
	 * @param orgId 组织代码
	 * @param year  时间
	 * @return 统计数据
	 * @throws Exception 
	 */
	public List<Map<String, Object>> exProcSelectElderlyHealthManagement(Map<String, Object> params);
	
	/**
	 * 统计老年人年度体检信息
	 * @param orgId 组织代码
	 * @param year  时间
	 * @return 统计数据
	 * @throws Exception 
	 */
	public List<Map<String, Object>> exProcSelectElderlyHealthByYear(Map<String, Object> params);
	
	/**
	 * 统计高血压随访
	 * @param orgId 组织代码
	 * @param year  时间
	 * @return 统计数据
	 * @throws Exception 
	 */
	public List<Map<String, Object>> exProcSelectHypertensionVisit(Map<String, Object> params);
	/**
	 * 统计糖尿病随访
	 * @param orgId 组织代码
	 * @param year  时间
	 * @return 统计数据
	 * @throws Exception 
	 */
	public List<Map<String, Object>> exProcSelectDiabetesVisit(Map<String, Object> params);
	
}

