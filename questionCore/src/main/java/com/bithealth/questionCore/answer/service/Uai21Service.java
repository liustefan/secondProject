package com.bithealth.questionCore.answer.service;

import java.util.List;

import com.bithealth.questionCore.answer.model.Uai21;
import com.bithealth.questionCore.answer.model.Uai21Example;
import com.bithealth.questionCore.answer.model.Uai21Key;
import com.bithealth.sdk.core.generic.GenericBaseService;

public interface Uai21Service extends GenericBaseService<Uai21,Uai21Example,
   Uai21Key > {    
	
	List<Uai21> selectByMasterId(Integer masterId);
	
	int deleteByMasterId(Integer masterId);
}
