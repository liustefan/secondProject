package com.bithealth.healthCore.templet.service;

import java.util.List;

import com.bithealth.healthCore.templet.model.ManageschemeTempletTask;
import com.bithealth.healthCore.templet.model.ManageschemeTempletTaskExample;
import com.bithealth.sdk.core.generic.GenericBaseService;

public interface ManageschemeTempletTaskService extends GenericBaseService<ManageschemeTempletTask,ManageschemeTempletTaskExample,
   Integer > {
	
	int inserts(Integer masterId, List<ManageschemeTempletTask> models);
	
	List<ManageschemeTempletTask> selectList(Integer masterId);
	
	int deleteByMasterId(Integer... ids);
}
