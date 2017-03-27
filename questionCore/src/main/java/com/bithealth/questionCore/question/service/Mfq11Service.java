package com.bithealth.questionCore.question.service;

import java.util.List;

import com.bithealth.questionCore.question.model.Mfq11;
import com.bithealth.questionCore.question.model.Mfq11Example;
import com.bithealth.questionCore.question.model.Mfq11Key;
import com.bithealth.sdk.core.generic.GenericBaseService;

public interface Mfq11Service extends GenericBaseService<Mfq11,Mfq11Example,
   Mfq11Key > {    
	
	int deleteByMasterId(Integer masterId);
	
	int deleteByMasterId(List<Integer> ids);
	
	int inserts(Integer masterId, Integer masterId2, List<Mfq11> list);
	
	List<Mfq11> selectByMasterId(Integer masterId, Integer masterId2);
}
