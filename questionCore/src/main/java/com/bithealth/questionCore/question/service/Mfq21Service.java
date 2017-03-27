package com.bithealth.questionCore.question.service;

import java.util.List;

import com.bithealth.questionCore.question.model.Mfq21;
import com.bithealth.questionCore.question.model.Mfq21Example;
import com.bithealth.questionCore.question.model.Mfq21Key;
import com.bithealth.sdk.core.generic.GenericBaseService;

public interface Mfq21Service extends GenericBaseService<Mfq21,Mfq21Example,
   Mfq21Key > {    
	
	int deleteByMasterId(Integer masterId);
	int deleteByMasterId(List<Integer> ids);
	int inserts(Integer masterId, List<Mfq21> list);
	List<Mfq21> selectByMasterId(Integer masterId);
}
