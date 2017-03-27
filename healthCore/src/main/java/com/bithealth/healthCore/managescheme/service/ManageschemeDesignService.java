package com.bithealth.healthCore.managescheme.service;

import com.bithealth.healthCore.enmu.GroupManageschemeEnum;
import com.bithealth.healthCore.managescheme.model.ManageschemeDesign;
import com.bithealth.healthCore.managescheme.model.ManageschemeDesignExample;
import com.bithealth.sdk.core.generic.GenericBaseService;

public interface ManageschemeDesignService extends GenericBaseService<ManageschemeDesign,ManageschemeDesignExample,
   Integer > {    
	
//	Page<ManageschemeDesign> selectGroupManageschemePage(Page<ManageschemeDesign> page, ManageschemeDesign model);
	
	int updateManageschemeStatus(Integer docId, Integer MSDesignID, GroupManageschemeEnum newStatus, GroupManageschemeEnum oldStatus, String massOffReason);
}
