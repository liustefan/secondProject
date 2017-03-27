package com.bithealth.questionCore.question.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bithealth.sdk.core.generic.GenericBaseDao;
import com.bithealth.sdk.core.generic.GenericBaseServiceImpl; 
import com.bithealth.questionCore.question.dao.Mfq12Mapper;
import com.bithealth.questionCore.question.model.Mfq12; 
import com.bithealth.questionCore.question.model.Mfq12Example;
import com.bithealth.questionCore.question.service.Mfq12Service;
import com.bithealth.questionCore.question.model. Mfq12Key; 

@Component
public class Mfq12ServiceImpl extends GenericBaseServiceImpl<Mfq12,Mfq12Example,
      Mfq12Key> implements Mfq12Service {
          
    @Autowired
	private Mfq12Mapper dao;
        
    @Override
    public GenericBaseDao<Mfq12, Mfq12Example,  Mfq12Key> getDao() {
        return dao;
    }  
}
