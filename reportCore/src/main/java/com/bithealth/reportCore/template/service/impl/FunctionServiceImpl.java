package com.bithealth.reportCore.template.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bithealth.reportCore.template.dao.FunctionMapper;
import com.bithealth.reportCore.template.model.Function;
import com.bithealth.reportCore.template.model.FunctionExample;
import com.bithealth.reportCore.template.service.FunctionService;
import com.bithealth.sdk.core.generic.GenericBaseDao;
import com.bithealth.sdk.core.generic.GenericBaseServiceImpl;

@Service("functionService") 
public class FunctionServiceImpl extends GenericBaseServiceImpl<Function,FunctionExample,
      Short> implements FunctionService {
          
    @Resource FunctionMapper functionMapper;
        
    @Override
    public GenericBaseDao<Function,FunctionExample,  Short > getDao() {
        return functionMapper;
    }  
}
