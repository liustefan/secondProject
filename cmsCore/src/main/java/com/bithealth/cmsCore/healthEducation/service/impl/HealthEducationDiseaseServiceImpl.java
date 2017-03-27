package com.bithealth.cmsCore.healthEducation.service.impl;

import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource; 
import org.springframework.stereotype.Service; 

import com.bithealth.sdk.common.utils.TimeUtil;
import com.bithealth.sdk.core.generic.GenericBaseDao;
import com.bithealth.sdk.core.generic.GenericBaseServiceImpl; 
import com.bithealth.cmsCore.healthEducation.dao.HealthEducationDiseaseMapper;
import com.bithealth.cmsCore.healthEducation.model.HealthEducationDisease; 
import com.bithealth.cmsCore.healthEducation.model.HealthEducationDiseaseExample;
import com.bithealth.cmsCore.healthEducation.service.HealthEducationDiseaseService;
/**
 * 类名称: HealthEducationDiseaseServiceImpl  
 * 功能描述: 健教疾病关系接口实现类
 * 日期: 2016年11月29日 
 * 
 * @author 周玉飞
 * @version  
 */
@Service("healtheducationdiseaseService") 
public class HealthEducationDiseaseServiceImpl extends GenericBaseServiceImpl<HealthEducationDisease,HealthEducationDiseaseExample,
      Integer> implements HealthEducationDiseaseService {
          
    @Resource HealthEducationDiseaseMapper healtheducationdiseaseMapper;
        
    @Override
    public GenericBaseDao<HealthEducationDisease,HealthEducationDiseaseExample,  Integer > getDao() {
        return healtheducationdiseaseMapper;
    }

	@Override
	public List<HealthEducationDisease> selectList(Integer id) {
		return healtheducationdiseaseMapper.selectList(id);
	}

	@Override
	public int inserts(Integer masterId, List<HealthEducationDisease> models) {
		int n =0;
		if(models != null && models.size() > 0){
			for (Iterator<HealthEducationDisease> it = models.iterator(); it.hasNext();) {
				HealthEducationDisease model =it.next();
				if (model!=null) {
					model.setHeducationid(masterId);
					model.setUpdatetime(TimeUtil.now());
					n+=insert(model);
				}
			}
		}
		return n;
	}

	@Override
	public int updates(Integer masterId, List<HealthEducationDisease> models) {
		int n=0;		
		HealthEducationDiseaseExample example = new HealthEducationDiseaseExample();
		example.createCriteria().andHeducationidEqualTo(masterId);
		n += deleteByExample(example);
    	n += inserts(masterId, models);
		return n;
	}  
}
