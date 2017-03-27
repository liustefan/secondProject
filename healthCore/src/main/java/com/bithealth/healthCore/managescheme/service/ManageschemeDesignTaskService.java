package com.bithealth.healthCore.managescheme.service;

import java.util.List;

import com.bithealth.healthCore.enmu.SchemeTypeEnum;
import com.bithealth.healthCore.managescheme.model.ManageschemeDesignTask;
import com.bithealth.healthCore.managescheme.model.ManageschemeDesignTaskExample;
import com.bithealth.sdk.core.generic.GenericBaseService;

public interface ManageschemeDesignTaskService extends GenericBaseService<ManageschemeDesignTask,ManageschemeDesignTaskExample,
   Integer > {    
	
	List<ManageschemeDesignTask> selectByMasterId(Integer masterId, SchemeTypeEnum type);
	
	boolean deleteByMSDesignID(Integer MSDesignID);
	
}
