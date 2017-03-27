/**
 * @PackageName:      com.bithealth.memberCore.member.service
 * @FileName:     DeseaseService.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      liuhm
 * @version      V1.0  
 * @Createdate:  2016年7月26日 下午5:21:36  
 * 
 */
package com.bithealth.memberCore.member.service;

import java.util.List;

import com.bithealth.memberCore.member.model.Disease;
import com.bithealth.memberCore.member.model.DiseaseExample;
import com.bithealth.sdk.core.generic.GenericBaseService;

/**
 * 类名称: DeseaseService  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年7月26日 下午5:21:36 
 * 
 * @author liuhm
 * @version  
 */
public interface DiseaseService extends GenericBaseService<Disease, DiseaseExample, Integer> {
	
	List<Disease> selectAll_cache();
	
	Integer selectDiseaseId_cache(String diseaseName);
	
	String selectDiseaseName_cache(Integer id);

}
