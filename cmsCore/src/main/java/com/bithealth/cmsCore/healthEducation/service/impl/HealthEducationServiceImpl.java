package com.bithealth.cmsCore.healthEducation.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service; 

import com.bithealth.sdk.core.generic.GenericBaseDao;
import com.bithealth.sdk.core.generic.GenericBaseServiceImpl; 
import com.bithealth.cmsCore.healthEducation.dao.HealthEducationMapper;
import com.bithealth.cmsCore.healthEducation.model.HealthEducation; 
import com.bithealth.cmsCore.healthEducation.model.HealthEducationExample;
import com.bithealth.cmsCore.healthEducation.service.HealthEducationService;
/**
 * 类名称: HealthEducationServiceImpl  
 * 功能描述: 健教服务接口实现
 * 日期: 2016年11月29日 
 * 
 * @author 周玉飞
 * @version  
 */
@Service("healtheducationService") 
public class HealthEducationServiceImpl extends GenericBaseServiceImpl<HealthEducation,HealthEducationExample,
      Integer> implements HealthEducationService {
          
	@Autowired 
	HealthEducationMapper healtheducationMapper;
    
    @Override
    public GenericBaseDao<HealthEducation,HealthEducationExample,  Integer > getDao() {
        return healtheducationMapper;
    }

	@Override
	public HealthEducation selectHealthEducation(Integer roleId, String title,
			Integer id, Integer docId, String allSharedOrg) {
		return healtheducationMapper.selectHealthEducation(roleId, title, id, docId, allSharedOrg);
	}

}
