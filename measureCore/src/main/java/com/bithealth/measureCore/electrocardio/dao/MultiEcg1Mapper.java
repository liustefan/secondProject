 
/**
 * @PackageName:      com.bithealth.measureCore.electrocardio.dao
 * @FileName:     MultiEcg1Mapper.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      陈哲 
 * @version      V1.0  
 * @Createdate:  2016年8月10日 下午2:06:28  
 * 
 */

package com.bithealth.measureCore.electrocardio.dao;

import java.util.Map;

import com.bithealth.measureCore.electrocardio.model.Ecg1;


/**
 * 类名称: MultiEcg1Mapper  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年8月10日 下午2:06:28 
 * 
 * @author 陈哲
 * @version  
 */
public interface MultiEcg1Mapper {
	void updateEcg1BydocentryAndObjectid(Map<String, Object> param);
	
	int insertSubEcg1(Ecg1 ecg1);
}

