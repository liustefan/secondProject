package com.bithealth.healthCore.managescheme.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bithealth.healthCore.enmu.PersonManageschemeEnum;
import com.bithealth.healthCore.managescheme.dao.ManageschemeExecMapper;
import com.bithealth.healthCore.managescheme.model.ManageschemeExec;
import com.bithealth.healthCore.managescheme.model.ManageschemeExecExample;
import com.bithealth.healthCore.managescheme.service.ManageschemeExecService;
import com.bithealth.sdk.common.utils.TimeUtil;
import com.bithealth.sdk.core.feature.orm.mybatis.Page;
import com.bithealth.sdk.core.generic.GenericBaseDao;
import com.bithealth.sdk.core.generic.GenericBaseServiceImpl;

@Component
public class ManageschemeExecServiceImpl extends GenericBaseServiceImpl<ManageschemeExec,ManageschemeExecExample,
      Long> implements ManageschemeExecService {
          
    @Autowired
	private ManageschemeExecMapper dao;
        
    @Override
    public GenericBaseDao<ManageschemeExec, ManageschemeExecExample,  Long> getDao() {
        return dao;
    }  
    
    /** 
     * @Title: send 
     * @Description: TODO 简单描述该方法的实现功能（可选）.
     * @param  
     * @throws      
     * @retrun  
     *  @see com.bithealth.healthCore.managescheme.service.ManageschemeExecService#selectPersonManageschemePage(com.bithealth.sdk.core.feature.orm.mybatis.Page, com.bithealth.healthCore.managescheme.model.ManageschemeExec)
     */
    @Override
    public List<ManageschemeExec> selectPersonManageschemePage(
    		Page<ManageschemeExec> page, ManageschemeExec model) {
    	
    	return dao.selectPersonManageschemePage(page, model);
    }
    
    /** 
     * @Title: send 
     * @Description: TODO 简单描述该方法的实现功能（可选）.
     * @param  
     * @throws      
     * @retrun  
     *  @see com.bithealth.healthCore.managescheme.service.ManageschemeExecService#deleteByMSDesignID(java.lang.Integer)
     */
    @Override
    public boolean deleteByMSDesignID(Integer MSDesignID) {
    	
    	ManageschemeExecExample example = new ManageschemeExecExample();
    	example.createCriteria().andMSDesignIDEqualTo(MSDesignID);
    	return deleteByExample(example) > 0;
    }
    
    /** 
     * @Title: send 
     * @Description: TODO 简单描述该方法的实现功能（可选）.
     * @param  
     * @throws      
     * @retrun  
     *  @see com.bithealth.healthCore.managescheme.service.ManageschemeExecService#insert(com.bithealth.healthCore.managescheme.model.ManageschemeExec, java.lang.Integer)
     */
    @Override
    public int insert(ManageschemeExec model, Integer masterId) {
    	
    	if(model != null){
    		model.setMSDesignID(masterId);
    		model.setCreateTime(TimeUtil.now());
    		return insert(model);
    	}
    	return 0;
    }
    
    /** 
     * @Title: send 
     * @Description: TODO 简单描述该方法的实现功能（可选）.
     * @param  
     * @throws      
     * @retrun  
     *  @see com.bithealth.healthCore.managescheme.service.ManageschemeExecService#update(com.bithealth.healthCore.managescheme.model.ManageschemeExec, java.lang.Integer)
     */
    @Override
    public int update(ManageschemeExec model, Integer MSDesignID) {
    	
    	if(model != null){
    		model.setUpdateTime(TimeUtil.now());
    		ManageschemeExecExample example = new ManageschemeExecExample();
    		example.createCriteria().andMSDesignIDEqualTo(MSDesignID);
    		return updateByExampleSelective(model, example);
    	}
    	return 0;
    }
    
    /** 
     * @Title: send 
     * @Description: TODO 简单描述该方法的实现功能（可选）.
     * @param  
     * @throws      
     * @retrun  
     *  @see com.bithealth.healthCore.managescheme.service.ManageschemeExecService#selectManageschemePage(com.bithealth.sdk.core.feature.orm.mybatis.Page, com.bithealth.healthCore.managescheme.model.ManageschemeExec)
     */
    @Override
    public List<ManageschemeExec> selectManageschemePage(
    		Page<ManageschemeExec> page, ManageschemeExec model) {
    	
    	return dao.selectManageschemePage(page, model);
    }
    
    /** 
     * @Title: send 
     * @Description: TODO 简单描述该方法的实现功能（可选）.
     * @param  
     * @throws      
     * @retrun  
     *  @see com.bithealth.healthCore.managescheme.service.ManageschemeExecService#updateManageschemeStatus(java.lang.Integer, com.bithealth.healthCore.enmu.PersonManageschemeEnum, com.bithealth.healthCore.enmu.PersonManageschemeEnum, java.lang.String)
     */
    @Override
    public int updateManageschemeStatus(Integer MSDesignID,
    		PersonManageschemeEnum newStatus, PersonManageschemeEnum oldStatus,
    		String execOffReason) {
    	ManageschemeExec exec = new ManageschemeExec();
		exec.setExecStatus(newStatus.getCode());
		if(PersonManageschemeEnum.TERMINATED.equals(newStatus)){
			exec.setExecOffTime(TimeUtil.now());
			exec.setExecOffReason(execOffReason);
		}
		ManageschemeExecExample execExample = new ManageschemeExecExample();
		execExample.createCriteria().andMSDesignIDEqualTo(MSDesignID).andExecStatusEqualTo(oldStatus);
		return updateByExampleSelective(exec, execExample);
    }
    
    /** 
     * @Title: send 
     * @Description: TODO 简单描述该方法的实现功能（可选）.
     * @param  
     * @throws      
     * @retrun  
     *  @see com.bithealth.healthCore.managescheme.service.ManageschemeExecService#inserts(java.util.List)
     */
    @Override
    public int inserts(List<ManageschemeExec> list) {
    	
    	return dao.inserts(list);
    }
    
    /** 
     * @Title: send 
     * @Description: TODO 简单描述该方法的实现功能（可选）.
     * @param  
     * @throws      
     * @retrun  
     *  @see com.bithealth.healthCore.managescheme.service.ManageschemeExecService#selectByMasterId(java.lang.Integer)
     */
    @Override
    public ManageschemeExec selectByMasterId(Integer masterId) {
    	List<ManageschemeExec> list = selectListByMasterId(masterId, null);
    	return list != null && list.size() > 0 ? list.get(0) : null;
    }
    
    /** 
     * @Title: send 
     * @Description: TODO 简单描述该方法的实现功能（可选）.
     * @param  
     * @throws      
     * @retrun  
     *  @see com.bithealth.healthCore.managescheme.service.ManageschemeExecService#selectListByMasterId(java.lang.Integer)
     */
    @Override
    public List<ManageschemeExec> selectListByMasterId(Integer masterId, PersonManageschemeEnum pm) {
    	
    	ManageschemeExecExample example = new ManageschemeExecExample();
    	example.createCriteria().andMSDesignIDEqualTo(masterId).andExecStatusEqualTo(pm);
    	return selectByExample(example);
    }
    
    /** 
     * @Title: send 
     * @Description: TODO 简单描述该方法的实现功能（可选）.
     * @param  
     * @throws      
     * @retrun  
     *  @see com.bithealth.healthCore.managescheme.service.ManageschemeExecService#terminatedManageschemeExec(java.lang.Integer)
     */
    @Override
    public int terminatedManageschemeExec(Integer docId, Integer MSDesignID, String massOffReason) {
    	
    	return dao.terminatedManageschemeExec(docId, MSDesignID, massOffReason);
    }
    
    /** 
     * @Title: send 
     * @Description: TODO 简单描述该方法的实现功能（可选）.
     * @param  
     * @throws      
     * @retrun  
     *  @see com.bithealth.healthCore.managescheme.service.ManageschemeExecService#updateSingleTerminatedManageschemeExec(java.lang.Integer, java.lang.Integer, java.lang.String)
     */
    @Override
    public int updateSingleTerminatedManageschemeExec(Integer docId, Long MSExecID, String massOffReason) {
    	
    	return dao.updateSingleTerminatedManageschemeExec(docId, MSExecID, massOffReason);
    }
    
//    /** 
//     * @Title: send 
//     * @Description: TODO 简单描述该方法的实现功能（可选）.
//     * @param  
//     * @throws      
//     * @retrun  
//     *  @see com.bithealth.healthCore.managescheme.service.ManageschemeExecService#selectMemberLabels(java.lang.Integer)
//     */
//    @Override
//    public List<String> selectMemberLabels(Integer memberID) {
//    	
//    	return dao.selectMemberLabels(memberID);
//    }
    
    /** 
     * @Title: send 
     * @Description: TODO 简单描述该方法的实现功能（可选）.
     * @param  
     * @throws      
     * @retrun  
     *  @see com.bithealth.healthCore.managescheme.service.ManageschemeExecService#selectHasManageschemeExec(java.lang.Integer)
     */
    @Override
    public ManageschemeExec selectHasManageschemeExec(Integer memberId) {
    	
    	return dao.selectHasPersonManageschemeExec(memberId);
    }
}
