 
/**
 * @PackageName:      com.bithealth.inspectCore.service
 * @FileName:     InspectService.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      名字  * 
 * @version      V1.0  
 * @Createdate:  2016年6月28日 上午11:28:14  
 * 
 */

package com.bithealth.inspectCore.inspect.service;

import java.util.List;
import java.util.Map;

import com.bithealth.inspectCore.inspect.model.PhDiabetes;
import com.bithealth.inspectCore.inspect.model.PhDiabetesExample;
import com.bithealth.inspectCore.inspect.model.PhHypertension;
import com.bithealth.inspectCore.inspect.model.PhHypertensionExample;
import com.bithealth.memberCore.member.vo.MemberVo;
import com.bithealth.sdk.core.feature.orm.mybatis.Page;


/**
 * 类名称: InspectService  
 * 功能描述: TODO 公卫随访  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年6月28日 上午11:28:14 
 * 
 * @author baozj
 * @version  
 */
public interface InspectService {

	/**
	 * 
	 * @Title:insertPhDiabetes 
	 * @Description:添加糖尿病随访
	 * TODO
	 * @author baozj
	 * @param pojo
	 * @return 
	 * @throws
	 * @retrun boolean
	 */
	int insertPhDiabetes(PhDiabetes pojo);
	
	/**
	 * 
	 * @Title:updatePhDiabetes 
	 * @Description:修改糖尿病随访 
	 * TODO  
	 * @author baozj
	 * @param pojo
	 * @return 
	 * @throws
	 * @retrun boolean
	 */
	int updatePhDiabetes(PhDiabetes pojo);
	
	/**
	 * 
	 * @Title:deletePhDiabetes 
	 * @Description:删除糖尿病随访
	 * TODO
	 * @author baozj
	 * @param ids
	 * @return 
	 * @throws
	 * @retrun boolean
	 */
	int deletePhDiabetes(Long...ids);
	
	int deleteSoftPhDiabetes(Long... ids);
	/**
	 * 
	 * @Title:selectPhDiabetesById 
	 * @Description:通过主键查询糖尿病随访详情
	 * TODO  
	 * @author baozj
	 * @param id
	 * @return 
	 * @throws
	 * @retrun PhDiabetes
	 */
	PhDiabetes selectPhDiabetesById(Long id);
	
	PhDiabetes selectPhDiabetesByRefDataPK(String refDataPK);
	
	/**
	 * 
	 * @Title:selectPhDiabetesByExampleAndPage 
	 * @Description:分页查询糖尿病随访数据
	 * TODO  
	 * @author baozj
	 * @param page
	 * @param example
	 * @return 
	 * @throws
	 * @retrun Page<PhDiabetes>
	 */
	Page<PhDiabetes> selectPhDiabetesByExampleAndPage(Page<PhDiabetes> page, PhDiabetesExample  example);
	
	/**
	 * 
	 * @Title:insertPhHypertension 
	 * @Description:添加高血压随访 
	 * TODO  
	 * @author baozj
	 * @param pojo
	 * @return 
	 * @throws
	 * @retrun boolean
	 */
	int insertPhHypertension(PhHypertension pojo);
	
	/**
	 * 
	 * @Title:updatePhHypertension 
	 * @Description:修改高血压随访 
	 * TODO  
	 * @author baozj
	 * @param pojo
	 * @return 
	 * @throws
	 * @retrun boolean
	 */
	int updatePhHypertension(PhHypertension pojo);
	
	/**
	 * 
	 * @Title:deletePhHypertension 
	 * @Description:删除高血压随访 
	 * TODO  
	 * @author baozj
	 * @param ids
	 * @return 
	 * @throws
	 * @retrun boolean
	 */
	int deletePhHypertension(Long...ids);
	
	int deleteSoftPhHypertension(Long...ids);
	
	/**
	 * 
	 * @Title:selectPhHypertensionById 
	 * @Description:通过主键查询高血压随访详情 
	 * TODO  
	 * @author baozj
	 * @param id
	 * @return 
	 * @throws
	 * @retrun PhHypertension
	 */
	PhHypertension selectPhHypertensionById(Long id);
	
	PhHypertension selectPhHypertensionByRefDataPK(String refDataPK);
	
	/**
	 * 
	 * @Title:selectPhHypertensionByExampleAndPage 
	 * @Description:分页查询高血压随访数据 
	 * TODO  
	 * @author baozj
	 * @param page
	 * @param example
	 * @return 
	 * @throws
	 * @retrun Page<PhHypertension>
	 */
	Page<PhHypertension> selectPhHypertensionByExampleAndPage(Page<PhHypertension> page, PhHypertensionExample  example);
	
	/**
	 * 
	 * @Title:exProcGetDiabetesMemList 
	 * @Description:分页查询我的会员中可以添加糖尿病随访的会员 
	 * TODO  
	 * @author baozj
	 * @param page
	 * @param params
	 * @return 
	 * @throws
	 * @retrun Page<Member>
	 */
	Page<MemberVo> exProcGetDiabetesMemList(Page<MemberVo> page, Map<String, Object> params);
	
	/**
	 * 
	 * @Title:exProcGetHypertensionMemList 
	 * @Description:分页查询我的会员中可以添加高血压随访的会员 
	 * TODO  
	 * @author baozj
	 * @param page
	 * @param params
	 * @return 
	 * @throws
	 * @retrun Page<Member>
	 */
	Page<MemberVo> exProcGetHypertensionMemList(Page<MemberVo> page, Map<String, Object> params);
	
	/**
	 * 
	 * @Title:selectPhDiabetesByExample
	 * @Description:通过参数查询糖尿病随访记录数 
	 * TODO  
	 * @author baozj
	 * @param example
	 * @return 
	 * @throws
	 * @retrun int
	 */
	List<PhDiabetes> selectPhDiabetesByExample(PhDiabetesExample example);
	
	/**
	 * 
	 * @Title:selectPhHypertensionByExample
	 * @Description:通过参数查询高血压随访记录数
	 * TODO  
	 * @author baozj
	 * @param example
	 * @return 
	 * @throws
	 * @retrun int
	 */
	List<PhHypertension> selectPhHypertensionByExample(PhHypertensionExample example);
	
	int selectPhDiabetesTotalByExample(PhDiabetesExample example);
	
	int selectPhHypertensionTotalByExample(PhHypertensionExample example);
	
	/**
	 * 
	 * @Title:selectLatestPhDiabetesByMemberId 
	 * @Description:查询会员最新糖尿病随访
	 * TODO  
	 * @author baozj
	 * @param memberId
	 * @return 
	 * @throws
	 * @retrun PhDiabetes
	 */
	PhDiabetes selectLatestPhDiabetesByMemberId(Integer memberId);
	
	/**
	 * 
	 * @Title:selectLatestPhHypertensionByMemberId 
	 * @Description:查询会员最新高血压随访
	 * TODO  
	 * @author baozj
	 * @param memberId
	 * @return 
	 * @throws
	 * @retrun PhHypertension
	 */
	PhHypertension selectLatestPhHypertensionByMemberId(Integer memberId);
	
	boolean selectPhDiabetesExistByRefDataPK(PhDiabetes pojo);
	
	boolean selectPhHypertensionExistByRefDataPK(PhHypertension pojo);
	
	List<PhDiabetes> selectPhDiabetesList(PhDiabetes pojo);
	
	List<PhHypertension> selectPhHypertensionList(PhHypertension pojo);
	
	Page<PhDiabetes> selectPhDiabetesPage(Page<PhDiabetes> page, PhDiabetes pojo, List<Integer> odgpIds);
	
	Page<PhHypertension> selectPhHypertensionPage(Page<PhHypertension> page, PhHypertension pojo, List<Integer> odgpIds);
	
	/**
	 * 
	 * @Title:hasPendingDiabetes 
	 * @Description: 有待随访糖尿病
	 * TODO  
	 * @author baozj
	 * @param memberId
	 * @param id
	 * @return 
	 * @throws
	 * @retrun boolean
	 */
	boolean hasPendingDiabetes(Integer memberId, Long id);
	
	/**
	 * 
	 * @Title:hasPendingHypertension 
	 * @Description: 有待随访高血压
	 * TODO  
	 * @author baozj
	 * @param memberId
	 * @param id
	 * @return 
	 * @throws
	 * @retrun boolean
	 */
	boolean hasPendingHypertension(Integer memberId, Long id);
}

