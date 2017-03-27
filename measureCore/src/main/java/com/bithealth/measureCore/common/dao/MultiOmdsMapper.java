 
/**
 * @PackageName:      com.bithealth.measureCore.dao
 * @FileName:     MultiOmds.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      陈哲 
 * @version      V1.0  
 * @Createdate:  2016年7月20日 上午11:28:21  
 * 
 */

package com.bithealth.measureCore.common.dao;

import java.util.List;
import java.util.Map;

import com.bithealth.measureCore.common.model.MeasureRecord;
import com.bithealth.measureCore.common.model.Omds;
import com.bithealth.sdk.core.feature.orm.mybatis.Page;



/**
 * 类名称: MultiOmds  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年7月20日 上午11:28:21 
 * 
 * @author 陈哲
 * @version  
 */
public interface MultiOmdsMapper {
	/*int insertOmds_eventid();*/
	
	Long selectMaxEventid();
	
	void insertOmds(Omds omds);
	
	Omds selectOmdsByEventId(Map<String, Object> param);
	
	void updateOmdsByEventid(Map<String, Object> param);
	
	List<MeasureRecord> findAllMeasureRecordByParam(Page<MeasureRecord> page, Map<String, Object> param);

}

