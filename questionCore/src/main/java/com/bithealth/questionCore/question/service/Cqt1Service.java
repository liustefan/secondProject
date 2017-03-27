package com.bithealth.questionCore.question.service;

import java.util.List;

import com.bithealth.questionCore.question.model.Cqt1;
import com.bithealth.questionCore.question.model.Cqt1Example;
import com.bithealth.questionCore.question.model.Cqt1Key;
import com.bithealth.sdk.core.generic.GenericBaseService;

public interface Cqt1Service extends GenericBaseService<Cqt1,Cqt1Example,
   Cqt1Key > {    
	
	List<Cqt1> selectByMasterId(Integer masterId);
	
	int deleteByMasterId(List<Integer> values);
	
	int inserts(Integer masterId, List<Cqt1> list);
	
	int updates(Integer masterId, List<Cqt1> list);
}
