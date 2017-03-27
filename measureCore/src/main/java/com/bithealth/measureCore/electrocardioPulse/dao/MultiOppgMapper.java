 
/**
 * @PackageName:      com.bithealth.measureCore.electrocardioPulse.dao
 * @FileName:     MultiOppgMapper.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      陈哲 
 * @version      V1.0  
 * @Createdate:  2016年7月12日 上午11:18:24  
 * 
 */

package com.bithealth.measureCore.electrocardioPulse.dao;

import java.util.List;
import java.util.Map;

import com.bithealth.measureCore.common.model.Omds;
import com.bithealth.measureCore.electrocardio.model.Ecg2Chart;
import com.bithealth.measureCore.electrocardio.model.Oecg;
import com.bithealth.measureCore.electrocardioPulse.model.Oppg;
import com.bithealth.measureCore.electrocardioPulse.model.OppgChart;
import com.bithealth.measureCore.electrocardioPulse.model.OppgOmemVO;
import com.bithealth.sdk.core.feature.orm.mybatis.Page;


/**
 * 类名称: MultiOppgMapper  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年7月12日 上午11:18:24 
 * 
 * @author 陈哲
 * @version  
 */
public interface MultiOppgMapper {
	List<OppgOmemVO> selectOppgListAndPage(Page<OppgOmemVO> page, Map<String, Object> param);
	
	List<Oecg> selectOecgPulseAndPage(Page<Oecg> page, Map<String, Object> param);
	
	List<Omds> selectOmdsByOppg(Map<String, Object> param);
	
	void updateOppgOecgByDocentry(Map<String, Object> param);
	
	void updateBatchOppgOecgByDocentry(Map<String, Object> param);
	
	List<Ecg2Chart> selectOecgOppgExcTrendChart(Map<String, Object> param);
	
	List<Ecg2Chart> selectOecgOppgExcTrendChart1(List<Long> list);
	
	List<Ecg2Chart> selectOecgOppgExcBarChart(Map<String, Object> param);
	
	List<Ecg2Chart> selectOecgOppgExcBarChart1(List<Long> list);
	
	List<OppgChart> selectOppgIndicatorsTrendChart(Map<String, Object> param);
	
	List<OppgChart> selectOppgIndicatorsTrendChart1(List<Long> list);
	
	OppgChart selectOppgIndicatorsExcBarChart(Map<String, Object> param);
	
	OppgChart selectOppgIndicatorsExcBarChart1(List<Long> list);
	
	/*int insertOppg_docentry();*/
	
	Long selectMaxOppgdocentry();
	
	void insertOppg(Oppg oppg);
	
	Oppg selectOppgByOecg(Map<String, Object> param);
	
	Integer selectOecgPulseCount(Map<String, Object> param);
	
	void updatePpgResultOfOppg(Map<String, Object> param);
	
	void updateStatusTagOfOppg(Map<String, Object> param);
	
}

