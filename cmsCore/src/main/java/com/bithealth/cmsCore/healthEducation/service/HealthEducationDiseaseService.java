package com.bithealth.cmsCore.healthEducation.service;

import java.util.List;

import com.bithealth.sdk.core.generic.GenericBaseService;
import com.bithealth.cmsCore.healthEducation.model.HealthEducationDisease;
import com.bithealth.cmsCore.healthEducation.model.HealthEducationDiseaseExample; 
/**
 * 类名称: HealthEducationDiseaseService  
 * 功能描述: 健教疾病关系
 * 日期: 2016年11月29日 
 * 
 * @author 周玉飞
 * @version  
 */
public interface HealthEducationDiseaseService extends GenericBaseService<HealthEducationDisease,HealthEducationDiseaseExample,
   Integer > {   
	
	int inserts(Integer masterId, List<HealthEducationDisease> models);
	
	int updates(Integer masterId, List<HealthEducationDisease> models);
	
	List<HealthEducationDisease> selectList(Integer id);
	
}
