package com.bithealth.statistiCore.statistic.service.impl;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bithealth.sdk.core.feature.orm.mybatis.Page;
import com.bithealth.statistiCore.statistic.dao.StatisticMapper;
import com.bithealth.statistiCore.statistic.service.StatisticService;
/**
 * 类名称: StatistiCoreServiceImpl  
 * 功能描述: 统计报表查询实现类 
 * 日期: 2016年6月30日 下午15:6:30 
 * 
 * @author 周玉飞
 * @version  
 */
@Service
public class StatisticServiceImpl implements StatisticService {
	
	@Autowired
	private StatisticMapper statisticMapper;
	/**
	 * 测量状况统计
	 */
	public Page<Map<String, Object>> exProcSelectMeasurementStatics(Page<Map<String, Object>> page, Map<String, Object> params){
		params.put("iCurrentPageIndex", page.getPageNo() - 1);
		params.put("iPageSize", page.getPageSize());
		page.setResult(statisticMapper.exProcSelectMeasurementStatics(params));
		page.setTotalCount(Integer.parseInt(String.valueOf(params.get("iCount"))));
		return page;
	}
	
	/**
	 * 人口基本状况
	 */
	public List<Map<String, Object>> exProcSelectPopulation(Map<String, Object> params){
		return statisticMapper.exProcSelectPopulation(params);
		
	}
	/**
	 * 统计老年人接受健康管理状况
	 */
	public List<Map<String, Object>> exProcSelectElderlyHealthManagement(Map<String, Object> params){
		return statisticMapper.exProcSelectElderlyHealthManagement(params);
	}
	/**
	 * 统计老年人年度体检信息
	 */
	public List<Map<String, Object>> exProcSelectElderlyHealthByYear(Map<String, Object> params){
		return statisticMapper.exProcSelectElderlyHealthByYear(params);
	}
	/**
	 * 统计高血压随访
	 */
	public List<Map<String, Object>> exProcSelectHypertensionVisit(Map<String, Object> params){
		return statisticMapper.exProcSelectHypertensionVisit(params);
	}
	/**
	 * 统计糖尿病随访
	 */
	public List<Map<String, Object>> exProcSelectDiabetesVisit(Map<String, Object> params){
		return statisticMapper.exProcSelectDiabetesVisit(params);
	}

}
