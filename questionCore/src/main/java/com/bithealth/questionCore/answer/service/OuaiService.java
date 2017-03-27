package com.bithealth.questionCore.answer.service;

import com.bithealth.sdk.core.generic.GenericBaseService;
import com.bithealth.questionCore.answer.model.Ouai;
import com.bithealth.questionCore.answer.model.OuaiExample; 

public interface OuaiService extends GenericBaseService<Ouai,OuaiExample,
   Integer > {    
	
	int updateByPrimaryKeySelective(Ouai model);
}
