package com.bithealth.healthCore.managescheme.service;

import java.util.List;

import com.bithealth.healthCore.managescheme.model.ManageschemeExecTask;
import com.bithealth.healthCore.managescheme.model.ManageschemeExecTaskExample;
import com.bithealth.sdk.core.feature.orm.mybatis.Page;
import com.bithealth.sdk.core.generic.GenericBaseService;

public interface ManageschemeExecTaskService extends GenericBaseService<ManageschemeExecTask,ManageschemeExecTaskExample,
   Long > {    
	
	List<ManageschemeExecTask> selectManageschemeTaskPage(Page<ManageschemeExecTask> page, ManageschemeExecTask model);
	
	List<ManageschemeExecTask> selectByMasterId(Long masterId);
	
	boolean deleteByMSDesignID(Integer MSDesignID);
}
