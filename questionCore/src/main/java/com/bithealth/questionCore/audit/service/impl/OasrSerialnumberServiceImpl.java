package com.bithealth.questionCore.audit.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bithealth.sdk.core.generic.GenericBaseDao;
import com.bithealth.sdk.core.generic.GenericBaseServiceImpl; 
import com.bithealth.questionCore.audit.dao.OasrSerialnumberMapper;
import com.bithealth.questionCore.audit.model.OasrSerialnumber; 
import com.bithealth.questionCore.audit.model.OasrSerialnumberExample;
import com.bithealth.questionCore.audit.service.OasrSerialnumberService;

@Component
public class OasrSerialnumberServiceImpl extends GenericBaseServiceImpl<OasrSerialnumber,OasrSerialnumberExample,
      Long> implements OasrSerialnumberService {
          
    @Autowired
	private OasrSerialnumberMapper dao;
        
    @Override
    public GenericBaseDao<OasrSerialnumber, OasrSerialnumberExample,  Long> getDao() {
        return dao;
    }  
}
