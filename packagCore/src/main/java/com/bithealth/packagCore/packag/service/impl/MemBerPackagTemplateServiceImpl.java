package com.bithealth.packagCore.packag.service.impl;

import java.util.List;

import javax.annotation.Resource; 

import org.springframework.stereotype.Service; 

import com.bithealth.sdk.core.generic.GenericBaseDao;
import com.bithealth.sdk.core.generic.GenericBaseServiceImpl; 
import com.bithealth.packagCore.packag.dao.MemBerPackagTemplateMapper;
import com.bithealth.packagCore.packag.model.MemBerPackagTemplate; 
import com.bithealth.packagCore.packag.model.MemBerPackagTemplateExample;
import com.bithealth.packagCore.packag.service.MemBerPackagTemplateService;
import com.bithealth.packagCore.packag.model. MemBerPackagTemplateKey; 

@Service("memberpackagtemplateService") 
public class MemBerPackagTemplateServiceImpl extends GenericBaseServiceImpl<MemBerPackagTemplate,MemBerPackagTemplateExample,
      MemBerPackagTemplateKey> implements MemBerPackagTemplateService {
          
    @Resource MemBerPackagTemplateMapper memberpackagtemplateMapper;
        
    @Override
    public GenericBaseDao<MemBerPackagTemplate,MemBerPackagTemplateExample,  MemBerPackagTemplateKey > getDao() {
        return memberpackagtemplateMapper;
    }

	@Override
	public List<MemBerPackagTemplate> selectByEndDayAndKey(MemBerPackagTemplate memBerPackagTemplate) {
		return memberpackagtemplateMapper.selectByEndDayAndKey(memBerPackagTemplate);
	}

	@Override
	public List<MemBerPackagTemplate> selectByNumTimesAndKey(MemBerPackagTemplate memBerPackagTemplate) {
		return memberpackagtemplateMapper.selectByNumTimesAndKey(memBerPackagTemplate);
	}

	@Override
	public int insertByBatch(List<MemBerPackagTemplate> list) {
		
		memberpackagtemplateMapper.insertByBatch(list);
		return 0;
	}

	@Override
	public List<MemBerPackagTemplate> selectMemPackageDetailList(MemBerPackagTemplate memBerPackagTemplate) {
		return memberpackagtemplateMapper.selectMemPackageDetailList(memBerPackagTemplate);
	}  
}
