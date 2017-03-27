 
/**
 * @PackageName:      com.bithealth.inspectCore.service
 * @FileName:     PhysicalService.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      名字  * 
 * @version      V1.0  
 * @Createdate:  2016年6月24日 上午11:20:21  
 * 
 */

package com.bithealth.inspectCore.physical.service;

import java.util.List;

import com.bithealth.inspectCore.physical.model.PhHealthexam;
import com.bithealth.inspectCore.physical.model.PhHealthexamExample;
import com.bithealth.sdk.core.feature.orm.mybatis.Page;


/**
 * 类名称: PhysicalService  
 * 功能描述: TODO 公卫健康体检  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年6月24日 上午11:20:21 
 * 
 * @author baozj
 * @version  
 */
public interface PhysicalService {
	
	/**
	 * 
	 * @Title:insertPhHealthexam 
	 * @Description:添加健康体检信息
	 * TODO
	 * @author baozj
	 * @param pojo
	 * @return 
	 * @throws
	 * @retrun boolean
	 */
	int insertPhHealthexam(PhHealthexam pojo);
	
	/**
	 * 
	 * @Title:updatePhHealthexam 
	 * @Description:修改健康体检信息
	 * TODO  
	 * @author baozj
	 * @param pojo
	 * @return 
	 * @throws
	 * @retrun boolean
	 */
	int updatePhHealthexam(PhHealthexam pojo);
	
	/**
	 * 
	 * @Title:deletePhHealthexam 
	 * @Description:删除健康体检数据 
	 * TODO
	 * @author baozj
	 * @param ids
	 * @return 
	 * @throws
	 * @retrun boolean
	 */
	int deletePhHealthexam(Long...ids);
	
	int deleteSoftPhHealthexam(Long...ids);
	
	/**
	 * 
	 * @Title:selectPhHealthexamById  
	 * @author baozj
	 * @param id
	 * @return 
	 * @throws
	 * @retrun PhHealthexam
	 */
	PhHealthexam selectPhHealthexamById(Long id);
	
	PhHealthexam selectPhHealthexamByRefDataPK(String refDataPK);
	
	PhHealthexam selectPhHealthexamByParam(Byte refCompany, String unique_ID, String refDataPK);
	
	/**
	 * 
	 * @Title:selectByExampleAndPage 
	 * @Description:分页查询健康体检数据 
	 * TODO
	 * @author baozj
	 * @param page
	 * @param example
	 * @return 
	 * @throws
	 * @retrun Page<PhHealthexam>
	 */
	Page<PhHealthexam> selectPhHealthexamByExampleAndPage(Page<PhHealthexam> page, PhHealthexamExample  example);
	
	/**
	 * 
	 * @Title:selectLatestPhHealthexamByMemberId 
	 * @Description:查询会员最新体检信息 
	 * TODO  
	 * @author baozj
	 * @param memberId
	 * @return 
	 * @throws
	 * @retrun PhHealthexam
	 */
	PhHealthexam selectLatestPhHealthexamByMemberId(Integer memberId);
	
	boolean selectPhHealthexamExistByRefDataPK(PhHealthexam pojo);
	
	List<PhHealthexam> selectPhHealthexamList(PhHealthexam pojo);
	
	Page<PhHealthexam> selectPage(Page<PhHealthexam> page, PhHealthexam model, List<Integer> odgpIds);
}

