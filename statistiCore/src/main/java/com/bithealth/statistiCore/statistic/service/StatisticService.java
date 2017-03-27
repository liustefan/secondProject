package com.bithealth.statistiCore.statistic.service;

import java.util.List;
import java.util.Map;

import com.bithealth.sdk.core.feature.orm.mybatis.Page;
/**
 * 类名称: StatisticService接口  
 * 功能描述: 统计报表查询
 * 日期: 2016年6月28日 下午15:20:30 
 * 
 * @author 周玉飞
 * @version  
 */

public interface StatisticService {
	
	/**
	 * 测量状况统计
	 * @param orgId 组织代码
	 * @param year  时间
	 * @return 统计全部数据
	 * @throws Exception 
	 */
	public Page<Map<String, Object>> exProcSelectMeasurementStatics(Page<Map<String, Object>> page, Map<String, Object> params);
	
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
	public List<Map<String, Object>> exProcSelectElderlyHealthManagement(Map<String, Object>params);
	
	/**
	 * 统计老年人年度体检信息
	 * @param orgId 组织代码
	 * @param year  时间
	 * @return 统计数据
	 * @throws Exception 
	 */
	public List<Map<String, Object>> exProcSelectElderlyHealthByYear(Map<String,Object>params);
	
	/**
	 * 统计高血压随访
	 * @param orgId 组织代码
	 * @param year  时间
	 * @return 统计数据
	 * @throws Exception 
	 */
	public List<Map<String, Object>> exProcSelectHypertensionVisit(Map<String,Object>params);
	
	/**
	 * 统计糖尿病随访
	 * @param orgId 组织代码
	 * @param year  时间
	 * @return 统计数据
	 * @throws Exception 
	 */
	public List<Map<String, Object>> exProcSelectDiabetesVisit(Map<String,Object> params);
	
}
