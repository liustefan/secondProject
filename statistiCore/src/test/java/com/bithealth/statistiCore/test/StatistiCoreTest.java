package com.bithealth.statistiCore.test;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.bithealth.sdk.core.feature.orm.mybatis.Page;
import com.bithealth.statistiCore.statistic.service.StatisticService;


/**
 * 类名：StatistiCoreTest 
 * 功能：统计报表测试类
 * 
 * 日期: 2016年6月30日 下午17:20:35
 * @author 周玉飞
 * @version
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath*:application*.xml"})
public class StatistiCoreTest {

	@Autowired
	StatisticService service;
	/**
	 * 测量状况统计测试
	 */
	@Test
	public void selectMeasurementStatics() {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("iOrgID", 93);
		System.out.println("======>"+JSON.toJSONString(service.exProcSelectMeasurementStatics(new Page<Map<String,Object>>(),params)));;
	}
	/**
	 * 人口基本状况测试
	 */
	@Test
	public void selectPopulation() {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("iOrgID", 93);
		System.out.println("======>"+JSON.toJSONString(service.exProcSelectPopulation(params)));;
	}
	/**
	 * 统计老年人接受健康管理状况测试
	 */
	@Test
	public void selectElderlyHealthManagement() {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("iOrgID", 93);
		params.put("iYear", 2015);
		System.out.println("======>"+JSON.toJSONString(service.exProcSelectElderlyHealthManagement(params)));;
	}
	/**
	 * 统计老年人年度体检信息测试
	 */
	@Test
	public void selectElderlyHealthByYear() {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("iOrgID", 93);
		params.put("iYear", 2015);
		System.out.println("======>"+JSON.toJSONString(service.exProcSelectElderlyHealthByYear(params)));;
	}
	/**
	 * 统计高血压随访测试
	 */
	@Test
	public void selectHypertensionVisit() {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("iOrgID", 93);
		params.put("iYear", 2015);
		System.out.println("======>"+JSON.toJSONString(service.exProcSelectHypertensionVisit(params)));;
	}
	/**
	 * 统计糖尿病随访测试
	 */
	@Test
	public void selectDiabetesVisit() {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("iOrgID", 93);
		params.put("iYear", 2015);
		System.out.println("======>"+JSON.toJSONString(service.exProcSelectDiabetesVisit(params)));;
	}

}