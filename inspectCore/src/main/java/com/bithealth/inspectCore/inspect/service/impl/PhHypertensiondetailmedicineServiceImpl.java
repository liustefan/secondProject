 
/**
 * @PackageName:      com.bithealth.inspectCore.inspect.service.impl
 * @FileName:     PhHypertensiondetailmedicineServiceImpl.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      名字  * 
 * @version      V1.0  
 * @Createdate:  2016年6月28日 上午11:10:33  
 * 
 */

package com.bithealth.inspectCore.inspect.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bithealth.inspectCore.inspect.dao.PhHypertensiondetailmedicineMapper;
import com.bithealth.inspectCore.inspect.model.PhHypertensiondetailmedicine;
import com.bithealth.inspectCore.inspect.model.PhHypertensiondetailmedicineExample;
import com.bithealth.inspectCore.inspect.service.PhHypertensiondetailmedicineService;
import com.bithealth.sdk.core.generic.GenericBaseDao;
import com.bithealth.sdk.core.generic.GenericBaseServiceImpl;


/**
 * 类名称: PhHypertensiondetailmedicineServiceImpl  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年6月28日 上午11:10:33 
 * 
 * @author baozj
 * @version  
 */
@Component
public class PhHypertensiondetailmedicineServiceImpl extends
		GenericBaseServiceImpl<PhHypertensiondetailmedicine, PhHypertensiondetailmedicineExample, Long> implements
		PhHypertensiondetailmedicineService {

	@Autowired
	private PhHypertensiondetailmedicineMapper dao;
	
	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.sdk.core.generic.GenericBaseServiceImpl#getDao()
	 */
	@Override
	public GenericBaseDao<PhHypertensiondetailmedicine, PhHypertensiondetailmedicineExample, Long> getDao() {
		
		return dao;
	}
	
	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.inspectCore.inspect.service.PhHypertensiondetailmedicineService#selectByMasterId(java.lang.Long)
	 */
	public List<PhHypertensiondetailmedicine> selectByMasterId(Long masterId) {
		
		PhHypertensiondetailmedicineExample example = new PhHypertensiondetailmedicineExample();
		example.createCriteria().andHypertensionIDEqualTo(masterId);
		return selectByExample(example);
	}

	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.inspectCore.inspect.service.PhHypertensiondetailmedicineService#deleteByMasterId(java.util.List)
	 */
	public int deleteByMasterId(List<Long> masterIds) {
		
		PhHypertensiondetailmedicineExample example = new PhHypertensiondetailmedicineExample();
		example.createCriteria().andHypertensionIDIn(masterIds);
		return deleteByExample(example);
	}
	
	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.inspectCore.inspect.service.PhHypertensiondetailmedicineService#inserts(java.util.List, java.lang.Long)
	 */
	public int inserts(List<PhHypertensiondetailmedicine> pojos, Long masterId) {
		
		int n = 0;
		if(pojos != null){
			for(Iterator<PhHypertensiondetailmedicine> it = pojos.iterator(); it.hasNext();){
				PhHypertensiondetailmedicine pojo = it.next();
				pojo.setLogID(null);
				pojo.setHypertensionID(masterId);
				n += insert(pojo);
			}
		}
		return n;
	}
	
	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.inspectCore.inspect.service.PhHypertensiondetailmedicineService#updateByMasterId(java.util.List, java.lang.Long)
	 */
	public int updateByMasterId(List<PhHypertensiondetailmedicine> pojos,
			Long masterId) {
		
		int n = 0;
		if(pojos != null){
			List<Long> ids = new ArrayList<Long>();
			for(Iterator<PhHypertensiondetailmedicine> it = pojos.iterator(); it.hasNext();){
				PhHypertensiondetailmedicine pojo = it.next();
				if(StringUtils.isNotEmpty(pojo.getDrugName())){
					pojo.setHypertensionID(masterId);;
					if(pojo.getLogID() == null)
						n += insert(pojo);
					else
						n += updateByPrimaryKey(pojo);
					
					ids.add(pojo.getLogID());
				}
			}
			PhHypertensiondetailmedicineExample example = new PhHypertensiondetailmedicineExample();
			example.createCriteria().andHypertensionIDEqualTo(masterId).andLogIDNotIn(ids);
			n += deleteByExample(example);
		}
		return n;
	}
}

