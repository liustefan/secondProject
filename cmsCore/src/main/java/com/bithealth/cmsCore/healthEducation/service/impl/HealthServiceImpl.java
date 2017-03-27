package com.bithealth.cmsCore.healthEducation.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bithealth.cmsCore.healthEducation.dao.HealthEducationMapper;
import com.bithealth.cmsCore.healthEducation.model.HealthEducation;
import com.bithealth.cmsCore.healthEducation.model.HealthEducationExample;
import com.bithealth.cmsCore.healthEducation.service.HealthEducationDiseaseService;
import com.bithealth.cmsCore.healthEducation.service.HealthEducationService;
import com.bithealth.cmsCore.healthEducation.service.HealthService;
import com.bithealth.sdk.core.feature.orm.mybatis.Page;
/**
 * 类名：HealthServiceImpl
 * 描述：健教库管理
 * @author 作者:周玉飞
 * @version 创建时间：2016年12月2日 
 * 类说明
 */
@Service
public class HealthServiceImpl implements HealthService {

	@Autowired
	private HealthEducationService healthEducationService;
	@Autowired
	private HealthEducationMapper healthEducationMapper;
	@Autowired
	private HealthEducationDiseaseService healthEducationDiseaseService;
	
	    @Override
		public int insertHealthEducation(HealthEducation pojo) {
			int n=0;
			if (pojo!=null) {
				pojo.setCreatetime(new Date());
				n+=healthEducationService.insert(pojo);
				n+=healthEducationDiseaseService.inserts(pojo.getHeducationid(), pojo.getDiseases());
			}
			return n;
		}

		@Override
		public int updateHealthEducation(HealthEducation pojo) {
			int n=0;
			if (pojo.getHeducationid()!=null && pojo!=null) {
				n+=healthEducationService.update(pojo);
				n+=healthEducationDiseaseService.updates(pojo.getHeducationid(), pojo.getDiseases());
			}
			return n;
		}


		@Override
		public HealthEducation selectHealthById(Integer id) {
			HealthEducation pojo = healthEducationService.selectById(id);
			if (pojo!=null) {
				pojo.setDiseases(healthEducationDiseaseService.selectList(pojo.getHeducationid()));
			}
			return pojo;
		}  

		@Override
		public int deleteHealthById(Integer id) {
			int n = 0;
			if(id != null ){
				n+=healthEducationService.delete(id);
			}
			return n;
		}

		@Override
		public Page<HealthEducation> selectByPage(Page<HealthEducation> page,
				HealthEducationExample pojo) {
			healthEducationService.selectByExampleAndPage(page, pojo);
			return page;
		}

		@Override
		public HealthEducation selectDiseaseName(HealthEducation pojo) {
			return healthEducationMapper.selectDiseaseName(pojo);
		}

		@Override
		public boolean selectHealthEducation(String title, Integer id,
				Integer docId) {
			HealthEducationExample example  = new HealthEducationExample();
			example.createCriteria()
			.andTitleEqualTo(title)
			.andCreateidEqualTo(docId)
			.andHeducationidNotEqualTo(id);
			return healthEducationService.selectByExample(example).size()>0;
		}

		@Override
		public HealthEducation selectHealthEducation(Integer roleId,
				String title, Integer id, Integer docId, String allSharedOrg) {
			return healthEducationService.selectHealthEducation(roleId, title, id, docId, allSharedOrg);
		}

		@Override
		public Page<HealthEducation> selectHealthEducationPage(
				Page<HealthEducation> page, HealthEducation model) {
			healthEducationMapper.selectHealthEducationPage(page, model);
			return page;
		}

}
