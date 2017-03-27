package com.bithealth.questionCore.question.service;

import java.util.List;

import com.bithealth.questionCore.question.model.Mfq2;
import com.bithealth.questionCore.question.model.Mfq2Example;
import com.bithealth.questionCore.question.model.Mfq2Key;
import com.bithealth.sdk.core.generic.GenericBaseService;

public interface Mfq2Service extends GenericBaseService<Mfq2,Mfq2Example,
   Mfq2Key > {    
	
	int deleteByMasterId(Integer masterId);
	int deleteByMasterId(List<Integer> ids);
	int insert(Integer masterId, Mfq2 model);
	int inserts(Integer masterId, List<Mfq2> list);
	List<Mfq2> selectByMasterId(Integer masterId);
}
