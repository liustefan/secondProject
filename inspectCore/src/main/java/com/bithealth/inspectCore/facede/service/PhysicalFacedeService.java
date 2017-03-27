 
/**
 * @PackageName:      com.bithealth.inspectCore.facede
 * @FileName:     PhysicalFacedeService.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      名字  * 
 * @version      V1.0  
 * @Createdate:  2016年7月1日 上午9:42:10  
 * 
 */

package com.bithealth.inspectCore.facede.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.bithealth.inspectCore.physical.model.PhHealthexam;
import com.bithealth.inspectCore.physical.model.PhHealthexamExample;
import com.bithealth.sdk.core.feature.orm.mybatis.Page;


/**
 * 类名称: PhysicalFacedeService  
 * 功能描述: TODO 公卫健康体检  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年7月1日 上午9:42:10 
 * 
 * @author baozj
 * @version  
 */
public interface PhysicalFacedeService {
	
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
	@Deprecated
	boolean insertPhHealthexam(PhHealthexam pojo);
	
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
	@Deprecated
	boolean updatePhHealthexam(PhHealthexam pojo);
	
	/**
	 * 
	 * @Title:insertOrUpdatePhHealthexam 
	 * @Description:保存健康体检 
	 * TODO  
	 * @author baozj
	 * @param pojo
	 * @return 
	 * @throws
	 * @retrun boolean
	 */
	boolean insertOrUpdatePhHealthexam(PhHealthexam pojo);
	/**
	 * 
	 * @Title:batchSavePhHealthexam 
	 * @Description:批量保存健康体检 
	 * TODO  
	 * @author baozj
	 * @param pojo
	 * @return 
	 * @throws
	 * @retrun List<PhHealthexam>
	 */
	Map<String, List<PhHealthexam>> batchSavePhHealthexam(List<PhHealthexam> pojo);
	
	/**
	 * 
	 * @Title:deletePhHealthexam 
	 * @Description:删除健康体检数据 (物理删除)
	 * TODO
	 * @author baozj
	 * @param ids
	 * @return 
	 * @throws
	 * @retrun boolean
	 */
	boolean deletePhHealthexam(Long...ids);
	

	/**
	 * 
	 * @Title:deletePhHealthexam 
	 * @Description:删除健康体检数据 (软删除)
	 * TODO
	 * @author baozj
	 * @param ids
	 * @return 
	 * @throws
	 * @retrun boolean
	 */
	boolean deleteSoftPhHealthexam(Long...ids);
	
	/**
	 * 
	 * @Title:selectPhHealthexamById 
	 * @Description:通过主键查询健康体检详情
	 * TODO
	 * @author baozj
	 * @param id
	 * @return 
	 * @throws
	 * @retrun PhHealthexam
	 */
	PhHealthexam selectPhHealthexamById(Long id);
	
	/**
	 * 
	 * @Title:selectPhHealthexamByRefDataPK 
	 * @Description:通过合作公司的业务数据主键查询健康体检详情 
	 * TODO  
	 * @author baozj
	 * @param refDataPK
	 * @return 
	 * @throws
	 * @retrun PhHealthexam
	 */
	PhHealthexam selectPhHealthexamByRefDataPK(String refDataPK);
	
	/**
	 * 
	 * @Title:selectPhHealthexamByParam 
	 * @Description:根据参数查询健康体检信息 
	 * TODO  
	 * @author baozj
	 * @param refCompany
	 * @param unique_ID
	 * @param refDataPK
	 * @return 
	 * @throws
	 * @retrun PhHealthexam
	 */
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
	@Deprecated
	Page<PhHealthexam> selectPhHealthexamByExampleAndPage(Page<PhHealthexam> page, PhHealthexamExample  example);
	
	Page<PhHealthexam> selectPage(Page<PhHealthexam> page, PhHealthexam pojo, Integer currentDocId);
	
	/**
	 * 
	 * @Title:selectPhHealthexamList 
	 * @Description:对接特殊查询 
	 * TODO  
	 * @author baozj
	 * @param getTime
	 * @param source
	 * @param prgid
	 * @return 
	 * @throws
	 * @retrun List<PhHealthexam>
	 */
	List<PhHealthexam> selectPhHealthexamList(Date getTime, Integer source, String prgid);
	
}

