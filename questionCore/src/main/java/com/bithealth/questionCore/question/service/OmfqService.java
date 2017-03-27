package com.bithealth.questionCore.question.service;

import java.util.List;

import com.bithealth.questionCore.question.model.Omfq;
import com.bithealth.questionCore.question.model.OmfqExample;
import com.bithealth.sdk.core.generic.GenericBaseService;

public interface OmfqService extends GenericBaseService<Omfq,OmfqExample,
   Integer > {    
	
	int deleteByMasterId(List<Integer> ids);
	
	String selectSingleQuestionMaxQustCode(Integer orgId, String excTag);
	
	String selectSingleQuestionMaxQustVerByName(Integer orgId, String name, String excTag);
	
}
