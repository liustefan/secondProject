 
/**
 * @PackageName:      com.bithealth.measureCore.bloodPressure.dao
 * @FileName:     MultiOsbpMapper.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      陈哲 
 * @version      V1.0  
 * @Createdate:  2016年6月23日 下午5:46:29  
 * 
 */

package com.bithealth.measureCore.electrocardio.dao;

import java.util.List;
import java.util.Map;

import com.bithealth.measureCore.common.model.Omds;
import com.bithealth.measureCore.electrocardio.model.Ecg2Chart;
import com.bithealth.measureCore.electrocardio.model.Oecg;
import com.bithealth.measureCore.electrocardio.model.OecgOmemVO;
import com.bithealth.sdk.core.feature.orm.mybatis.Page;


/**
 * 类名称: MultiOsbpMapper  
 * 功能描述: TODO 多表查询功能mapper接口  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年6月23日 下午5:46:29 
 * 
 * @author 陈哲
 * @version  
 */
public interface MultiOecgMapper {
	List<OecgOmemVO> selectOecgListAndPage(Page<OecgOmemVO> page, Map<String, Object> param);
	
	List<Oecg> selectOecgAndPage(Page<Oecg> page, Map<String, Object> param);
	
	List<Oecg> selectOecgOmdsList(Map<String, Object> param);
	
	List<Ecg2Chart> selectOecgExcTrendChart(Map<String, Object> param);
	
	List<Ecg2Chart> selectOecgExcTrendChart1(List<Long> list);
	
	List<Ecg2Chart> selectOecgExcBarChart(Map<String, Object> param);
	
	List<Ecg2Chart> selectOecgExcBarChart1(List<Long> list);
	
	List<Omds> selectOmdsByOecg(Map<String, Object> param);
	
	int insertOecg_docentry();
	
	Long selectMaxDocentry();
	
	void insertOecg(Oecg oecg);
	
	Integer selectOecgCount(Map<String, Object> param);
	
	Oecg selectOecgByRawEcg(Map<String, Object> param);
	
	void updateEcgResultOfOecg(Map<String, Object> param);
	
	void updateStatusTagOfOecg(Map<String, Object> param);
}

