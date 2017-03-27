package com.bithealth.healthCore.managescheme.service;

import com.bithealth.sdk.core.generic.GenericBaseService;
import com.bithealth.healthCore.managescheme.model.ManageschemeDesignDetail;
import com.bithealth.healthCore.managescheme.model.ManageschemeDesignDetailExample; 

public interface ManageschemeDesignDetailService extends GenericBaseService<ManageschemeDesignDetail,ManageschemeDesignDetailExample,
   Integer > {    
	
	boolean deleteByMSDesignID(Integer MSDesignID);
	
	int insert(ManageschemeDesignDetail model, Integer masterId);
	
	int update(ManageschemeDesignDetail model, Integer masterId);
}
