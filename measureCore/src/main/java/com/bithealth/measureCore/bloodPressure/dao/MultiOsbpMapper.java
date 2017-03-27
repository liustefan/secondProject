 
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

package com.bithealth.measureCore.bloodPressure.dao;

import java.util.List;
import java.util.Map;

import com.bithealth.measureCore.bloodPressure.model.Osbp;
import com.bithealth.measureCore.bloodPressure.model.OsbpChart;
import com.bithealth.measureCore.bloodPressure.model.OsbpOmemVO;
import com.bithealth.measureCore.common.model.Omds;
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
public interface MultiOsbpMapper {
	List<OsbpOmemVO> selectOsbpListAndPage(Page page, Map<String, Object> param);
	
	List<OsbpChart> selectOsbpPieChart(Map<String, Object> param);
	
	List<OsbpChart> selectOsbpPieChart1(List<Long> list);
	
	List<OsbpChart> selectOsbpSubPieChart(Map<String, Object> param);
	
	List<OsbpChart> selectOsbpSubPieChart1(List<Long> list);
	
	List<OsbpChart> selectOsbpScachart(Map<String, Object> param);
	
	List<OsbpChart> selectOsbpScachart1(List<Long> list);
	
	List<OsbpChart> selectOsbpTrendChart(Map<String, Object> param);
	
	List<OsbpChart> selectOsbpTrendChart1(Map<String, Object> param);
	
	List<Omds> selectOmdsByOsbp(Map<String, Object> param);
	
	/*int insertOsbp_docentry();
	
	Long selectMaxDocentry();*/
	
	void insertOsbp(Osbp osbp);
}

