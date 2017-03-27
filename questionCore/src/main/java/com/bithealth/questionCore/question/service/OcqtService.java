package com.bithealth.questionCore.question.service;

import java.util.List;

import com.bithealth.sdk.core.generic.GenericBaseService;
import com.bithealth.questionCore.question.model.Ocqt;
import com.bithealth.questionCore.question.model.OcqtExample; 

public interface OcqtService extends GenericBaseService<Ocqt,OcqtExample,
   Integer > {    
	
	int deleteByMasterId(List<Integer> values);
	
	Integer selectComQuestionMaxQustCode(Integer orgId, String excTag);
	
	String selectComQuestionMaxQustVerByName(Integer orgId, String name, String excTag);
}
