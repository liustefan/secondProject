 
/**
 * @PackageName:      com.bithealth.measureCore.electrocardio.dao
 * @FileName:     MultiEcg2Mapper.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      陈哲 
 * @version      V1.0  
 * @Createdate:  2016年8月10日 下午2:32:28  
 * 
 */

package com.bithealth.measureCore.electrocardio.dao;

import java.util.Map;

import com.bithealth.measureCore.electrocardio.model.Ecg2;


/**
 * 类名称: MultiEcg2Mapper  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年8月10日 下午2:32:28 
 * 
 * @author 陈哲
 * @version  
 */
public interface MultiEcg2Mapper {
	void deleteEcg2ByDocentryAndAbnname(Map<String, Object> param);
	
	void updateEcg2ByDocentryAndAbnname(Map<String, Object> param);
	
	void insertSubEcg2(Ecg2 ecg2);
}

