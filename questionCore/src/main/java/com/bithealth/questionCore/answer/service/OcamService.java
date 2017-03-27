package com.bithealth.questionCore.answer.service;

import com.bithealth.questionCore.answer.model.Ocam;
import com.bithealth.questionCore.answer.model.OcamExample;
import com.bithealth.sdk.core.generic.GenericBaseService;

public interface OcamService extends GenericBaseService<Ocam,OcamExample,
   Integer > {    
	
	int updateByPrimaryKeySelective(Ocam model);
}
