package com.bithealth.healthCore.templet.service;

import com.bithealth.healthCore.templet.model.ManageschemeTemplet;
import com.bithealth.healthCore.templet.model.ManageschemeTempletExample;
import com.bithealth.sdk.core.feature.orm.mybatis.Page;
import com.bithealth.sdk.core.generic.GenericBaseService;

public interface ManageschemeTempletService extends GenericBaseService<ManageschemeTemplet,ManageschemeTempletExample,
   Integer > {    
	
	Page<ManageschemeTemplet> selectTempletPage(Page<ManageschemeTemplet> page, ManageschemeTemplet model);
	
	boolean updateUsedNumber(Integer id);
	
	ManageschemeTemplet selectTemplet(Integer roleId, String schemeTitle, Integer id, Integer docId, String allSharedOrg);
}
