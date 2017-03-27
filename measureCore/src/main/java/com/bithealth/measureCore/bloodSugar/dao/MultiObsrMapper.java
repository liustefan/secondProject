 
/**
 * @PackageName:      com.bithealth.measureCore.bloodSugar.dao
 * @FileName:     MultiObsrMapper.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      陈哲 
 * @version      V1.0  
 * @Createdate:  2016年7月5日 下午1:41:32  
 * 
 */

package com.bithealth.measureCore.bloodSugar.dao;

import java.util.List;
import java.util.Map;

import com.bithealth.measureCore.bloodSugar.model.Obsr;
import com.bithealth.measureCore.bloodSugar.model.ObsrChart;
import com.bithealth.measureCore.bloodSugar.model.ObsrOmemVO;
import com.bithealth.measureCore.common.model.Omds;
import com.bithealth.sdk.core.feature.orm.mybatis.Page;


/**
 * 类名称: MultiObsrMapper  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年7月5日 下午1:41:32 
 * 
 * @author 陈哲
 * @version  
 */
public interface MultiObsrMapper {
	List<Obsr> selectMaxObsrList(Map<String, Object> param);
	
	List<Obsr> selectMinObsrList(Map<String, Object> param);
	
	Omds selectOmdsLastOnebyObsr(Map<String, Object> param);
	
	List<Omds> selectOmdsListbyObsr(Map<String, Object> param);
	
	List<ObsrOmemVO> selectObsrListAndPage(Page page,Map<String, Object> param);
	
	List<ObsrChart> selectObsrDistriChart(Map<String, Object> param);
	
	List<ObsrChart> selectObsrDistriChart1(List<Long> list);
	
	List<ObsrChart> selectObsrDistriBoxChart(Map<String, Object> param);
	
	List<ObsrChart> selectObsrDistriBoxChart1(List<Long> list);
	
	List<ObsrChart> selectObsrMaxAndMinTrendChart(Map<String, Object> param);
	
	List<ObsrChart> selectObsrMaxAndMinTrendChart1(List<Long> list);
	
	List<ObsrChart> selectObsrTimeQPieChart(Map<String, Object> param);
	
	List<ObsrChart> selectObsrTimeQPieChart1(List<Long> list);
	
	List<ObsrChart> selectObsrMeasTrendsChart(Map<String, Object> param);
	
	List<ObsrChart> selectObsrMeasTrendsChart1(List<Long> list);
	
	/*int insertObsr_docentry();
	
	Long selectMaxDocentry();*/
	
	void insertObsr(Obsr obsr);
}

