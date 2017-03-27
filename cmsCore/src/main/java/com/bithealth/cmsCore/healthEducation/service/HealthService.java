package com.bithealth.cmsCore.healthEducation.service;

import java.util.List;

import com.bithealth.cmsCore.healthEducation.model.HealthEducation;
import com.bithealth.cmsCore.healthEducation.model.HealthEducationExample;
import com.bithealth.sdk.core.feature.orm.mybatis.Page;
/**
 * 类名：HealthService
 * 描述：健教库管理
 * @author 作者:周玉飞
 * @version 创建时间：2016年12月2日 
 * 类说明
 */
public interface HealthService {
	
	int insertHealthEducation(HealthEducation pojo);
	
	int updateHealthEducation(HealthEducation pojo);
	
	HealthEducation selectHealthById(Integer id); 
	
	int deleteHealthById(Integer id);
	
	HealthEducation selectDiseaseName(HealthEducation pojo);
	
	//验证当前医生下健教标题是否重复
	boolean selectHealthEducation(String title, Integer id,Integer docId);
	
	//验证可见域范围健教标题是否重复
	HealthEducation selectHealthEducation(Integer roleId, String title, Integer id,Integer docId,String allSharedOrg);
	
	Page<HealthEducation> selectByPage(Page<HealthEducation> page, HealthEducationExample pojo); 

	Page<HealthEducation> selectHealthEducationPage(Page<HealthEducation> page,HealthEducation model);
}
