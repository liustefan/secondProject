package com.bithealth.cmsCore.healthEducation.service;

import com.bithealth.sdk.core.generic.GenericBaseService;
import com.bithealth.cmsCore.healthEducation.model.HealthEducation;
import com.bithealth.cmsCore.healthEducation.model.HealthEducationExample; 
/**
 * 类名称: HealthEducationService  
 * 功能描述: 健教服务接口
 * 日期: 2016年11月29日 
 * 
 * @author 周玉飞
 * @version  
 */
public interface HealthEducationService extends GenericBaseService<HealthEducation,HealthEducationExample,
   Integer > {   
	
	HealthEducation selectHealthEducation(Integer roleId, String title, Integer id,Integer docId,String allSharedOrg);
	
}
