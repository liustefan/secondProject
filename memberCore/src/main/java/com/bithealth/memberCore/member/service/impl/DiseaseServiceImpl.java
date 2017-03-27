/**
 * @PackageName:      com.bithealth.memberCore.member.service.impl
 * @FileName:     DiseaseServiceImpl.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      liuhm
 * @version      V1.0  
 * @Createdate:  2016年7月26日 下午5:28:38  
 * 
 */
package com.bithealth.memberCore.member.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bithealth.memberCore.member.dao.DiseaseMapper;
import com.bithealth.memberCore.member.model.Disease;
import com.bithealth.memberCore.member.model.DiseaseExample;
import com.bithealth.memberCore.member.service.DiseaseService;
import com.bithealth.sdk.core.generic.GenericBaseDao;
import com.bithealth.sdk.core.generic.GenericBaseServiceImpl;

/**
 * 类名称: DiseaseServiceImpl  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年7月26日 下午5:28:38 
 * 
 * @author liuhm
 * @version  
 */
@Service("diseaseService")
public class DiseaseServiceImpl extends GenericBaseServiceImpl<Disease, DiseaseExample, Integer> implements DiseaseService {
	
	@Autowired
	private DiseaseMapper mapper;

	@Override
	public GenericBaseDao<Disease, DiseaseExample, Integer> getDao() {
		return mapper;
	}

	@Override
	public List<Disease> selectAll_cache() {
		return mapper.selectByExample(null);
	}

	@Override
	public Integer selectDiseaseId_cache(String diseaseName) {
		DiseaseExample example = new DiseaseExample();
		example.createCriteria().andDisease_nameEqualTo(diseaseName);
		List<Disease> list = mapper.selectByExample(example);
		if(list ==null || list.size() == 0) {
			return null;
		}
		return list.get(0).getDisease_id();
	}

	@Override
	public String selectDiseaseName_cache(Integer id) {
		List<Disease> list = selectAll_cache();
		if(list ==null || list.size() == 0) {
			return null;
		}
		for(Disease dis : list) {
			if(id.intValue() == dis.getDisease_id().intValue()) {
				return dis.getDisease_name();
			}
		}
		return null;
	}
	
}
