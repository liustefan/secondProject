package com.bithealth.centCore.care.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bithealth.centCore.care.dao.CareRemarkMapper;
import com.bithealth.centCore.care.model.CareRemark;
import com.bithealth.centCore.care.model.CareRemarkExample;
import com.bithealth.centCore.care.service.CareRemarkService;
import com.bithealth.sdk.core.generic.GenericBaseDao;
import com.bithealth.sdk.core.generic.GenericBaseServiceImpl;

@Service("careremarkService") 
public class CareRemarkServiceImpl extends GenericBaseServiceImpl<CareRemark,CareRemarkExample,
      Integer> implements CareRemarkService {
          
    @Resource CareRemarkMapper careremarkMapper;
        
    @Override
    public GenericBaseDao<CareRemark,CareRemarkExample,  Integer > getDao() {
        return careremarkMapper;
    }  
}
