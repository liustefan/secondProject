 
/**
 * @PackageName:      com.bithealth.inspectCore.physical.service.impl
 * @FileName:     PhHealthexamServiceImpl.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      名字  * 
 * @version      V1.0  
 * @Createdate:  2016年6月24日 上午10:29:35  
 * 
 */

package com.bithealth.inspectCore.physical.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bithealth.inspectCore.physical.dao.PhHealthexamMapper;
import com.bithealth.inspectCore.physical.model.PhHealthexam;
import com.bithealth.inspectCore.physical.model.PhHealthexamExample;
import com.bithealth.inspectCore.physical.service.PhHealthexamService;
import com.bithealth.sdk.core.feature.orm.mybatis.Page;
import com.bithealth.sdk.core.generic.GenericBaseDao;
import com.bithealth.sdk.core.generic.GenericBaseServiceImpl;


/**
 * 类名称: PhHealthexamServiceImpl  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年6月24日 上午10:29:35 
 * 
 * @author baozj
 * @version  
 */
@Component
public class PhHealthexamServiceImpl extends
		GenericBaseServiceImpl<PhHealthexam, PhHealthexamExample, Long> implements
		PhHealthexamService {

	@Autowired
	private PhHealthexamMapper dao;
	
	/** 
     * @Title: send 
     * @Description: TODO 简单描述该方法的实现功能（可选）.
     * @param  
     * @throws      
     * @retrun  
     *  @see com.bithealth.sdk.core.generic.GenericBaseServiceImpl#getDao()
     */
	@Override
	public GenericBaseDao<PhHealthexam, PhHealthexamExample, Long> getDao() {
		return dao;
	}
	
	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.inspectCore.physical.service.PhHealthexamService#deleteByMasterId(java.util.List)
	 */
	public int deleteByMasterId(List<Long> HExamIDs) {
		
		PhHealthexamExample example = new PhHealthexamExample();
		example.createCriteria().andHExamIDIn(HExamIDs);
		return deleteByExample(example);
	}
	
	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.inspectCore.physical.service.PhHealthexamService#selectLatestPhHealthexamByMemberId(java.lang.Integer)
	 */
	public PhHealthexam selectLatestPhHealthexamByMemberId(Integer memberId) {
		return dao.selectLatestPhHealthexamByMemberId(memberId);
	}
	
	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.inspectCore.physical.service.PhHealthexamService#selectPhHealthexamList(com.bithealth.inspectCore.physical.model.PhHealthexam)
	 */
	public List<PhHealthexam> selectPhHealthexamList(PhHealthexam pojo) {
		
		return dao.selectPhHealthexamList(pojo);
	}
	
	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.inspectCore.physical.service.PhHealthexamService#selectPage(com.bithealth.sdk.core.feature.orm.mybatis.Page, com.bithealth.inspectCore.physical.model.PhHealthexam, java.util.List)
	 */
	public Page<PhHealthexam> selectPage(Page<PhHealthexam> page,
			PhHealthexam model, List<Integer> odgpIds) {
		
		dao.selectPage(page, model, odgpIds);
		return page;
	}
	
	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.inspectCore.physical.service.PhHealthexamService#updateByPrimaryKeySelective(com.bithealth.inspectCore.physical.model.PhHealthexam)
	 */
	public int updateByPrimaryKeySelective(PhHealthexam pojo) {
		
		return dao.updateByPrimaryKeySelective(pojo);
	}
}

