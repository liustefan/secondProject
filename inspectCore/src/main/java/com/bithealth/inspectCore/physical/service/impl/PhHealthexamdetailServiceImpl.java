 
/**
 * @PackageName:      com.bithealth.inspectCore.physical.service.impl
 * @FileName:     PhHealthexamdetailServiceImpl.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      名字  * 
 * @version      V1.0  
 * @Createdate:  2016年6月24日 上午10:45:38  
 * 
 */

package com.bithealth.inspectCore.physical.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bithealth.inspectCore.physical.dao.PhHealthexamdetailMapper;
import com.bithealth.inspectCore.physical.model.PhHealthexamdetail;
import com.bithealth.inspectCore.physical.model.PhHealthexamdetailExample;
import com.bithealth.inspectCore.physical.service.PhHealthexamdetailService;
import com.bithealth.sdk.core.generic.GenericBaseDao;
import com.bithealth.sdk.core.generic.GenericBaseServiceImpl;


/**
 * 类名称: PhHealthexamdetailServiceImpl  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年6月24日 上午10:45:38 
 * 
 * @author baozj
 * @version  
 */
@Component
public class PhHealthexamdetailServiceImpl extends
		GenericBaseServiceImpl<PhHealthexamdetail, PhHealthexamdetailExample, Long> implements
		PhHealthexamdetailService {

	@Autowired
	private PhHealthexamdetailMapper dao;
	
	/** 
     * @Title: send 
     * @Description: TODO 简单描述该方法的实现功能（可选）.
     * @param  
     * @throws      
     * @retrun  
     *  @see com.bithealth.sdk.core.generic.GenericBaseServiceImpl#getDao()
     */
	@Override
	public GenericBaseDao<PhHealthexamdetail, PhHealthexamdetailExample, Long> getDao() {
		return dao;
	}
	
	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.inspectCore.physical.service.PhHealthexamdetailService#insert(com.bithealth.inspectCore.physical.model.PhHealthexamdetail, java.lang.Long)
	 */
	public int insert(PhHealthexamdetail pojo, Long HExamID) {
		
		if(pojo != null && HExamID != null){
			pojo.setHExamID(HExamID);
			return insert(pojo);
		}
		return 0;
	}
	
	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.inspectCore.physical.service.PhHealthexamdetailService#deleteByMasterId(java.util.List)
	 */
	public int deleteByMasterId(List<Long> HExamIDs) {
		
		PhHealthexamdetailExample example = new PhHealthexamdetailExample();
		example.createCriteria().andHExamIDIn(HExamIDs);
		return deleteByExample(example);
	}

	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.inspectCore.physical.service.PhHealthexamdetailService#updateByMasterId(com.bithealth.inspectCore.physical.model.PhHealthexamdetail, java.lang.Long)
	 */
	public int updateByMasterId(PhHealthexamdetail pojo, Long HExamID) {
		if(pojo != null){
			if(pojo.getHExamID() == null)
				return insert(pojo, HExamID);
			else
				return updateByPrimaryKey(pojo);
		}else{
			return 0;
		}
	}
}

