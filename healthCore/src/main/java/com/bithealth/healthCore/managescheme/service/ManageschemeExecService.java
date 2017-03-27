package com.bithealth.healthCore.managescheme.service;

import java.util.List;

import com.bithealth.healthCore.enmu.PersonManageschemeEnum;
import com.bithealth.healthCore.managescheme.model.ManageschemeExec;
import com.bithealth.healthCore.managescheme.model.ManageschemeExecExample;
import com.bithealth.sdk.core.feature.orm.mybatis.Page;
import com.bithealth.sdk.core.generic.GenericBaseService;

public interface ManageschemeExecService extends GenericBaseService<ManageschemeExec,ManageschemeExecExample,
   Long > {    
	
	List<ManageschemeExec> selectPersonManageschemePage(Page<ManageschemeExec> page, ManageschemeExec model);
	
	boolean deleteByMSDesignID(Integer MSDesignID);
	
	int insert(ManageschemeExec model, Integer masterId);
	
	int update(ManageschemeExec model, Integer MSDesignID);
	
	List<ManageschemeExec> selectManageschemePage(Page<ManageschemeExec> page, ManageschemeExec model);
	
	int updateManageschemeStatus(Integer MSDesignID, PersonManageschemeEnum newStatus, PersonManageschemeEnum oldStatus, String execOffReason);
	
	int inserts(List<ManageschemeExec> list);
	
	ManageschemeExec selectByMasterId(Integer masterId);
	
	List<ManageschemeExec> selectListByMasterId(Integer masterId, PersonManageschemeEnum pm);
	
	int terminatedManageschemeExec(Integer docId, Integer MSDesignID, String massOffReason);
	
	int updateSingleTerminatedManageschemeExec(Integer docId, Long MSExecID, String massOffReason);
	
//	List<String> selectMemberLabels(Integer memberID);
	
	ManageschemeExec selectHasManageschemeExec(Integer memberId);
}
