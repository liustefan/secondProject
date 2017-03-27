package com.bithealth.questionCore.question.service;

import java.util.List;

import com.bithealth.questionCore.question.model.Mfq1;
import com.bithealth.questionCore.question.model.Mfq1Example;
import com.bithealth.questionCore.question.model.Mfq1Key;
import com.bithealth.sdk.core.generic.GenericBaseService;

public interface Mfq1Service extends GenericBaseService<Mfq1,Mfq1Example,
   Mfq1Key > {    
	
	int deleteByMasterId(Integer masterId);
	
	int deleteByMasterId(List<Integer> ids);
	
	List<Mfq1> selectByMasterId(Integer masterId);
}
