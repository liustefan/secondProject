package com.bithealth.questionCore.answer.service;

import java.util.List;

import com.bithealth.sdk.core.generic.GenericBaseService;
import com.bithealth.questionCore.answer.model.Cam1;
import com.bithealth.questionCore.answer.model.Cam1Example; 
import com.bithealth.questionCore.answer.model. Cam1Key; 

public interface Cam1Service extends GenericBaseService<Cam1,Cam1Example,
   Cam1Key > {    
	
	List<Cam1> selectByMasterId(Integer masterId);
}
