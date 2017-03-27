package com.bithealth.questionCore.question.service;

import java.util.List;

import com.bithealth.questionCore.question.model.Logics;
import com.bithealth.questionCore.question.model.LogicsExample;
import com.bithealth.questionCore.question.model.LogicsKey;
import com.bithealth.sdk.core.generic.GenericBaseService;

public interface LogicsService extends GenericBaseService<Logics,LogicsExample,
   LogicsKey > {    

	int deleteByMasterId(Integer masterId);
	
	int deleteByMasterId(List<Integer> ids);
	
	int inserts(Integer masterId, Integer masterId2, List<Logics> list);
	
	List<Logics> selectByMasterId(Integer masterId, Integer masterId2);
}
