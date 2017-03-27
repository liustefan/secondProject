 
/**
 * @PackageName:      com.bithealth.inspectCore.facede
 * @FileName:     InspectFacedeService.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      名字  * 
 * @version      V1.0  
 * @Createdate:  2016年7月1日 上午9:41:41  
 * 
 */

package com.bithealth.inspectCore.facede.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.bithealth.inspectCore.inspect.model.PhDiabetes;
import com.bithealth.inspectCore.inspect.model.PhDiabetesExample;
import com.bithealth.inspectCore.inspect.model.PhHypertension;
import com.bithealth.inspectCore.inspect.model.PhHypertensionExample;
import com.bithealth.inspectCore.model.Inspect;
import com.bithealth.memberCore.member.vo.MemberVo;
import com.bithealth.sdk.core.feature.orm.mybatis.Page;


/**
 * 类名称: InspectFacedeService  
 * 功能描述: TODO 公卫随访  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年7月1日 上午9:41:41 
 * 
 * @author baozj
 * @version  
 */
public interface InspectFacedeService {

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
	@Deprecated
	boolean insertPhDiabetes(PhDiabetes pojo);
	
	/**
	 * 
	 * @Title:batchSavePhDiabetes 
	 * @Description:批量保存糖尿病随访
	 * TODO  
	 * @author baozj
	 * @param pojos
	 * @return 
	 * @throws
	 * @retrun int
	 */
//	int batchSavePhDiabetes(List<PhDiabetes> pojos);
	
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
	@Deprecated
	boolean updatePhDiabetes(PhDiabetes pojo);
	
	/**
	 * 
	 * @Title:insertOrUpdateDiabetes 
	 * @Description:保存糖尿病随访 
	 * TODO  
	 * @author baozj
	 * @param pojo
	 * @return 
	 * @throws
	 * @retrun boolean
	 */
	boolean insertOrUpdateDiabetes(PhDiabetes pojo);
	
	/**
	 * 
	 * @Title:deletePhDiabetes 
	 * @Description:删除糖尿病随访 (物理删除)
	 * TODO
	 * @author baozj
	 * @param ids
	 * @return 
	 * @throws
	 * @retrun boolean
	 */
	boolean deletePhDiabetes(Long...ids);
	
	/**
	 * 
	 * @Title:deletePhDiabetes 
	 * @Description:删除糖尿病随访 (软删除)
	 * TODO
	 * @author baozj 
	 * @param ids
	 * @return 
	 * @throws
	 * @retrun boolean
	 */
	boolean deleteSoftPhDiabetes(Long...ids);
	
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
	
	/**
	 * 
	 * @Title:selectPhDiabetesByRefDataPK 
	 * @Description:通过合作公司的业务数据主键查询糖尿病随访详情 
	 * TODO  
	 * @author baozj
	 * @param refDataPK
	 * @return 
	 * @throws
	 * @retrun PhDiabetes
	 */
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
	@Deprecated
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
	@Deprecated
	boolean insertPhHypertension(PhHypertension pojo);
	
	/**
	 * 
	 * @Title:updatePhHypertension 
	 * @Description:修改
	 * TODO  
	 * @author baozj
	 * @param pojo
	 * @return 
	 * @throws
	 * @retrun boolean
	 */
	@Deprecated
	boolean updatePhHypertension(PhHypertension pojo);
	
	/**
	 * 
	 * @Title:insertOrUpdateHypertension 
	 * @Description:保存高血压随访 
	 * TODO  
	 * @author baozj
	 * @param pojo
	 * @return 
	 * @throws
	 * @retrun boolean
	 */
	boolean insertOrUpdateHypertension(PhHypertension pojo);
	/**
	 * 
	 * @Title:batchSavePhHypertension 
	 * @Description: 
	 * TODO  
	 * @author baozj
	 * @param pojo
	 * @return 
	 * @throws
	 * @retrun List<PhHypertension>
	 */
//	List<PhHypertension> batchSavePhHypertension(PhHypertension pojo);
	
	/**
	 * 
	 * @Title:deletePhHypertension 
	 * @Description:删除高血压随访  (物理删除)
	 * TODO  
	 * @author baozj
	 * @param ids
	 * @return 
	 * @throws
	 * @retrun boolean
	 */
	boolean deletePhHypertension(Long...ids);
	
	/**
	 * 
	 * @Title:deletePhHypertension 
	 * @Description:删除高血压随访  (软删除)
	 * TODO  
	 * @author baozj
	 * @param ids
	 * @return 
	 * @throws
	 * @retrun boolean
	 */
	boolean deleteSoftPhHypertension(Long...ids);
	
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
	
	/**
	 * 
	 * @Title:selectPhDiabetesByRefDataPK 
	 * @Description:通过合作公司的业务数据主键查询高血压随访详情 
	 * TODO  
	 * @author baozj
	 * @param refDataPK
	 * @return 
	 * @throws
	 * @retrun PhHypertension
	 */
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
	@Deprecated
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
	 * @Title:selectPhDiabetesTotalByCountExample 
	 * @Description:通过参数查询糖尿病随访记录数(系统录入数据不计算在内)
	 * TODO  
	 * @author baozj
	 * @param example
	 * @return 
	 * @throws
	 * @retrun int
	 */
	List<PhDiabetes> selectPhDiabetesByNum(Integer num);
	
	/**
	 * 
	 * @Title:selectPhDiabetesTotal 
	 * @Description:查询糖尿病随访总记录数(系统录入数据不计算在内) 
	 * TODO  
	 * @author baozj
	 * @return 
	 * @throws
	 * @retrun int
	 */
	int selectPhDiabetesTotal();
	
	/**
	 * 
	 * @Title:selectPhHypertensionByExample 
	 * @Description:通过参数查询高血压随访记录数(系统录入数据不计算在内) 
	 * TODO  
	 * @author baozj
	 * @param example
	 * @return 
	 * @throws
	 * @retrun int
	 */
	List<PhHypertension> selectPhHypertensionByNum(Integer num);
	
	/**
	 * 
	 * @Title:selectPhHypertensionTotal 
	 * @Description:查询高血压随访总记录数(系统录入数据不计算在内)  
	 * TODO  
	 * @author baozj
	 * @return 
	 * @throws
	 * @retrun int
	 */
	int selectPhHypertensionTotal();
	
	/**
	 * 
	 * @Title:selectLatestPhDiabetesInfo 
	 * @Description:查询会员最新糖尿病随访相关数据  
	 * TODO  
	 * @author baozj
	 * @param memberId
	 * @return 
	 * @throws
	 * @retrun Map<String,Object>
	 */
	Map<String, Object> selectLatestPhDiabetesInfo(Integer memberId);
	
	/**
	 * 
	 * @Title:selectLatestPhHypertensionInfo 
	 * @Description:查询会员最新高血压随访相关数据 
	 * TODO  
	 * @author baozj
	 * @param memberId
	 * @return 
	 * @throws
	 * @retrun Map<String,Object>
	 */
	Map<String, Object> selectLatestPhHypertensionInfo(Integer memberId);

	/**
	 * 
	 * @Title:batchSavePhDiabetes 
	 * @Description: 批量保存糖尿病随访相关数据
	 * TODO  
	 * @author baozj
	 * @param pojos
	 * @return 
	 * @throws
	 * @retrun List<PhDiabetes>
	 */
	Map<String, List<PhDiabetes>> batchSavePhDiabetes(List<PhDiabetes> pojos);
	
	/**
	 * 
	 * @Title:batchSavePhHypertension 
	 * @Description:批量保存高血压随访相关数据 
	 * TODO  
	 * @author baozj
	 * @param pojos
	 * @return 
	 * @throws
	 * @retrun List<PhHypertension>
	 */
	Map<String, List<PhHypertension>> batchSavePhHypertension(List<PhHypertension> pojos);
	
	/**
	 * 
	 * @Title:selectPhDiabetesList 
	 * @Description:对接特殊查询 
	 * TODO  
	 * @author baozj
	 * @param getTime
	 * @param source
	 * @param prgid
	 * @return 
	 * @throws
	 * @retrun List<PhDiabetes>
	 */
	List<PhDiabetes> selectPhDiabetesList(Date getTime, Integer source, String prgid);
	
	/**
	 * 
	 * @Title:selectPhHypertensionList 
	 * @Description:对接特殊查询 
	 * TODO  
	 * @author baozj
	 * @param getTime
	 * @param source
	 * @param prgid
	 * @return 
	 * @throws
	 * @retrun List<PhHypertension>
	 */
	List<PhHypertension> selectPhHypertensionList(Date getTime, Integer source, String prgid);
	
	/**
	 * 
	 * @Title:selectPhDiabetesPage 
	 * @Description:分页查询糖尿病随访 
	 * TODO  
	 * @author baozj
	 * @param page
	 * @param pojo
	 * @param docId
	 * @return 
	 * @throws
	 * @retrun Page<PhDiabetes>
	 */
	Page<PhDiabetes> selectPhDiabetesPage(Page<PhDiabetes> page, PhDiabetes pojo, Integer docId);
	
	/**
	 * 
	 * @Title:selectPhHypertensionPage 
	 * @Description:分页查询高血压随访 
	 * TODO  
	 * @author baozj
	 * @param page
	 * @param pojo
	 * @param docId
	 * @return 
	 * @throws
	 * @retrun Page<PhHypertension>
	 */
	Page<PhHypertension> selectPhHypertensionPage(Page<PhHypertension> page, PhHypertension pojo, Integer docId);
	
	/**
	 * 
	 * @Title:selectInspectPage 
	 * @Description:分页查询会员公卫信息(移动会员端) 
	 * TODO  
	 * @author baozj
	 * @param page
	 * @param memberId
	 * @return 
	 * @throws
	 * @retrun Page<Inspect>
	 */
	Page<Inspect> selectInspectPage(Page<Inspect> page, Integer memberId);
	
	PhDiabetes selectDiabetesByMSETaskID(Long MSETaskID);
	
	PhHypertension selectHypertensionByMSETaskID(Long MSETaskID);
}

