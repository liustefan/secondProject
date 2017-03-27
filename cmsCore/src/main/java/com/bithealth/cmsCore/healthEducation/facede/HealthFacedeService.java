package com.bithealth.cmsCore.healthEducation.facede;

import java.util.List;

import com.bithealth.cmsCore.healthEducation.model.HealthEducation;
import com.bithealth.cmsCore.healthEducation.model.HealthEducationDisease;
import com.bithealth.cmsCore.healthEducation.model.HealthEducationExample;
import com.bithealth.sdk.core.feature.orm.mybatis.Page;

/**
 * 类名称: HealthFacedeService  
 * 功能描述: 健教疾病关系对外接口
 * 日期: 2016年11月29日 
 * 
 * @author 周玉飞
 * @version  
 */
public interface HealthFacedeService {
	
	boolean insertOrUpdateEducation(HealthEducation pojo);
	
	HealthEducation selectHealthById(Integer id);
	
	boolean deleteHealthByID(Integer id);
	
	HealthEducation selectDiseaseName(HealthEducation pojo);
	
	/*HealthEducation selectExistHealthName(String name,Integer id);*/
	
	//验证当前医生下健教标题是否重复
	boolean selectHealthEducation(String title, Integer id,Integer docId);
		
	//验证可见域范围健教标题是否重复
	HealthEducation selectHealthEducation(Integer roleId, String title, Integer id,Integer docId,String allSharedOrg);
	
	Page<HealthEducation> selectByPage(Page<HealthEducation> page, HealthEducationExample pojo); 

	
	Page<HealthEducation> selectHealthEducationPage(Page<HealthEducation> page,HealthEducation model);
}
