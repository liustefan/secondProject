package com.bithealth.healthCore.templet.service;

import java.util.List;

import com.bithealth.healthCore.templet.model.ManageschemeTempletDisease;
import com.bithealth.healthCore.templet.model.ManageschemeTempletDiseaseExample;
import com.bithealth.sdk.core.generic.GenericBaseService;

public interface ManageschemeTempletDiseaseService extends GenericBaseService<ManageschemeTempletDisease,ManageschemeTempletDiseaseExample,
   Integer > {    
	
	int inserts(Integer masterId, List<ManageschemeTempletDisease> models);
	
	int updates(Integer masterId, List<ManageschemeTempletDisease> models);
	
	List<ManageschemeTempletDisease> selectList(Integer masterId);
	
	int deleteByMasterId(Integer... ids);
	
	int deleteByMSDiseaseID(Integer...MSDiseaseID);
}
