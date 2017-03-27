package com.bithealth.cmsCore.healthEducation.facede.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bithealth.cmsCore.healthEducation.dao.HealthEducationMapper;
import com.bithealth.cmsCore.healthEducation.facede.HealthFacedeService;
import com.bithealth.cmsCore.healthEducation.model.HealthEducation;
import com.bithealth.cmsCore.healthEducation.model.HealthEducationDisease;
import com.bithealth.cmsCore.healthEducation.model.HealthEducationExample;
import com.bithealth.cmsCore.healthEducation.model.HealthEducationExample.Criteria;
import com.bithealth.cmsCore.healthEducation.service.HealthService;
import com.bithealth.sdk.core.feature.orm.mybatis.Page;

/**
 * 类名称: HealthFacedeServiceImpl  
 * 功能描述: 健教疾病关系对外接口实现类
 * 日期: 2016年11月29日 
 * 
 * @author 周玉飞
 * @version  
 */
@Service
public class HealthFacedeServiceImpl implements HealthFacedeService {

	
	@Autowired
	HealthService healthService;
	@Autowired
	HealthEducationMapper  healthEducationMapper;
	
	@Override
	public boolean insertOrUpdateEducation(HealthEducation pojo) {
		pojo.setCreatetime(new Date());
		pojo.setUpdatetime(new Date());
		if (pojo.getDiseases()==null) {
			pojo.setDiseases(new ArrayList<HealthEducationDisease>());
			if(StringUtils.isNotEmpty(pojo.getMSDiseaseIDs())){
				String[] ids = pojo.getMSDiseaseIDs().split(",");
				for(String id : ids){
					pojo.getDiseases().add(new HealthEducationDisease(Integer.parseInt(id)));
				}
		}
	}
		if (pojo.getHeducationid()==null) {
			return healthService.insertHealthEducation(pojo)>0;
		}else {
			return healthService.updateHealthEducation(pojo)>0;
		}
	}

	@Override
	public HealthEducation selectHealthById(Integer id) {
		if (id==null) {
			return null;
		}
		return healthService.selectHealthById(id);
	}
	
	@Override
	public Page<HealthEducation> selectByPage(Page<HealthEducation> page,
			HealthEducationExample pojo) {
		
		return healthService.selectByPage(page, pojo);
	}

	@Override
	public boolean deleteHealthByID(Integer id) {
		
		return healthService.deleteHealthById(id)>0;
	}

	@Override
	public HealthEducation selectDiseaseName(HealthEducation pojo) {
		return healthService.selectDiseaseName(pojo);
	}

	@Override
	public boolean selectHealthEducation(String title, Integer id, Integer docId) {
		return healthService.selectHealthEducation(title, id, docId);
	}

	@Override
	public HealthEducation selectHealthEducation(Integer roleId, String title,
			Integer id, Integer docId, String allSharedOrg) {
		return healthService.selectHealthEducation(roleId, title, id, docId, allSharedOrg);
	}

	@Override
	public Page<HealthEducation> selectHealthEducationPage(
			Page<HealthEducation> page, HealthEducation model) {
		return healthService.selectHealthEducationPage(page, model);
	}

}
