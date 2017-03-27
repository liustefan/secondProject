package com.bithealth.memberCore.memberLabel.service.impl;

import javax.annotation.Resource; 

import org.springframework.stereotype.Service; 

import com.bithealth.sdk.core.generic.GenericBaseDao;
import com.bithealth.sdk.core.generic.GenericBaseServiceImpl; 
import com.bithealth.memberCore.memberLabel.dao.LabelTagMapper;
import com.bithealth.memberCore.memberLabel.model.LabelTag; 
import com.bithealth.memberCore.memberLabel.model.LabelTagExample;
import com.bithealth.memberCore.memberLabel.service.LabelTagService;

@Service("labeltagService") 
public class LabelTagServiceImpl extends GenericBaseServiceImpl<LabelTag,LabelTagExample,
      Integer> implements LabelTagService {
          
    @Resource LabelTagMapper labeltagMapper;
        
    @Override
    public GenericBaseDao<LabelTag,LabelTagExample,  Integer > getDao() {
        return labeltagMapper;
    }

}
