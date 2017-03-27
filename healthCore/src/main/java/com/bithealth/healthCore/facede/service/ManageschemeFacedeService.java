 
/**
 * @PackageName:      com.bithealth.healthCore.facede.service
 * @FileName:     ManageschemeFacedeService.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      名字  * 
 * @version      V1.0  
 * @Createdate:  2016年12月8日 上午11:06:37  
 * 
 */

package com.bithealth.healthCore.facede.service;

import java.util.Date;
import java.util.Map;

import com.bithealth.healthCore.enmu.GroupManageschemeEnum;
import com.bithealth.healthCore.enmu.SchemeTypeEnum;
import com.bithealth.healthCore.managescheme.model.ManageschemeDesign;
import com.bithealth.healthCore.managescheme.model.ManageschemeDesignTask;
import com.bithealth.healthCore.managescheme.model.ManageschemeExec;
import com.bithealth.sdk.core.feature.orm.mybatis.Page;


/**
 * 类名称: ManageschemeFacedeService  
 * 功能描述: TODO 个人方案、群体方案管理 
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年12月8日 上午11:06:37 
 * 
 * @author baozj
 * @version  
 */
public interface ManageschemeFacedeService {

	/**
	 * 
	 * @Title:selectPersonManageschemePage 
	 * @Description: 分页查询个人管理方案（支持查询单个群体管理方案中会员的执行方案）
	 * TODO  
	 * @author baozj
	 * @param page
	 * @param model
	 * @return 
	 * @throws
	 * @retrun Page<ManageschemeExec>
	 */
	Page<ManageschemeExec> selectPersonManageschemePage(Page<ManageschemeExec> page, ManageschemeExec model);
	
	/**
	 * 
	 * @Title:selectGroupManageschemePage 
	 * @Description: 分页查询群体管理方案
	 * TODO  
	 * @author baozj
	 * @param page
	 * @param model
	 * @return 
	 * @throws
	 * @retrun Page<ManageschemeDesign>
	 */
	Page<ManageschemeDesign> selectGroupManageschemePage(Page<ManageschemeDesign> page, ManageschemeDesign model); 
	
	/**
	 * 
	 * @Title:selectManageschemeById 
	 * @Description: 查看方案详情【web端使用】
	 * TODO  
	 * @author baozj
	 * @param MSDesignID
	 * @return 
	 * @throws
	 * @retrun ManageschemeDesign
	 */
	ManageschemeDesign selectManageschemeById(Integer MSDesignID);
	
	/**
	 * 
	 * @Title:deleteManagescheme 
	 * @Description: 删除方案
	 * TODO  
	 * @author baozj
	 * @param MSDesignID
	 * @return 
	 * @throws
	 * @retrun boolean
	 */
	boolean deleteManagescheme(Integer MSDesignID);
	
	/**
	 * 
	 * @Title:deleteManageschemeTask 
	 * @Description: 删除方案任务
	 * TODO  
	 * @author baozj
	 * @param MSDTaskID
	 * @param st
	 * @return 
	 * @throws
	 * @retrun boolean
	 */
	boolean deleteManageschemeTask(Integer MSDTaskID, SchemeTypeEnum st);
	
	/**
	 * 
	 * @Title:updateManagescheme 
	 * @Description: 修改方案状态（只支持修改为终止状态）
	 * TODO  
	 * @author baozj
	 * @param MSDesignID
	 * @param newStatus
	 * @param oldStatus
	 * @param massOffReason
	 * @return 
	 * @throws
	 * @retrun boolean
	 */
	boolean updateManagescheme(Integer docId, Integer MSDesignID, GroupManageschemeEnum newStatus, GroupManageschemeEnum oldStatus, String massOffReason);
	
	
	/**
	 * 
	 * @Title:insertOrUpdateManagescheme 
	 * @Description: 保存个人、群建方案
	 * TODO  
	 * @author baozj
	 * @param model
	 * @return 
	 * @throws
	 * @retrun boolean
	 */
	boolean insertOrUpdateManagescheme(ManageschemeDesign model);
	
	/**
	 * 
	 * @Title:insertOrUpdateManageschemeTask 
	 * @Description: 保存个人、群体方案任务
	 * TODO 
	 * @author baozj
	 * @param model
	 * @param sType //1-个人，2-群体（只有新增时需要）
	 * @param MSExecID （只有新增个人方案任务时需要）
	 * @return 
	 * @throws 
	 * @retrun boolean
	 */
	boolean insertOrUpdateManageschemeTask(ManageschemeDesignTask model, SchemeTypeEnum sType, Long MSExecID);
	
	/**
	 * 
	 * @Title:selectManageschemePageByMemberId 
	 * @Description: 分页查询会员的方案
	 * TODO  
	 * @author baozj
	 * @param page
	 * @param memberId
	 * @return 
	 * @throws
	 * @retrun Page<ManageschemeExec>
	 */
	Page<ManageschemeExec> selectManageschemePageByMemberId(Page<ManageschemeExec> page, Integer memberId);
	
	/**
	 * 
	 * @Title:selectManageschemeById 
	 * @Description: 查看方案详情
	 * TODO  
	 * @author baozj
	 * @param MSExecID
	 * @return 
	 * @throws
	 * @retrun ManageschemeExec
	 */
	ManageschemeExec selectManageschemeById(Long MSExecID);
	
	/**
	 * 
	 * @Title:selectManageschemePage 
	 * @Description: 分页查询方案
	 * TODO  
	 * @author baozj
	 * @param page
	 * @param model
	 * @return 
	 * @throws
	 * @retrun Page<ManageschemeExec>
	 */
	Page<ManageschemeExec> selectManageschemePage(Page<ManageschemeExec> page, ManageschemeExec model);
	
	/**
	 * 
	 * @Title:selectHasManageschemeExec 
	 * @Description: 判断会员是否制定中及执行中的个人方案
	 * TODO  
	 * @author baozj
	 * @param memberId
	 * @return 
	 * @throws
	 * @retrun ManageschemeExec
	 */
	ManageschemeExec selectHasManageschemeExec(Integer memberId);
	
	/**
	 * 
	 * @Title:insertManageschemeExecs 
	 * @Description: 批量添加会员执行方案
	 * TODO  
	 * @author baozj
	 * @param execs
	 * @return 
	 * @throws
	 * @retrun boolean
	 */
	boolean insertManageschemeExecs(ManageschemeExec...execs);
	
	/**
	 * 
	 * @Title:exProcMschemeGetMemberByDocId 
	 * @Description: 分页查询可以制定个人方案的会员
	 * TODO  
	 * @author baozj
	 * @param page
	 * @param params
	 * @return 
	 * @throws
	 * @retrun Page<Map<String,Object>>
	 */
	Page<Map<String, Object>> exProcMschemeGetMemberByDocId(Page<Map<String, Object>> page, Map<String, Object> params);
	
	/**
	 * 
	 * @Title:exProcMschemeGetoraddMemberByDocId 
	 * @Description: 分页查询可以制定当前群体方案的会员
	 * TODO  
	 * @author baozj
	 * @param page
	 * @param params
	 * @return 
	 * @throws
	 * @retrun Page<Map<String,Object>>
	 */
	Page<Map<String, Object>> exProcMschemeGetoraddMemberByDocId(Page<Map<String, Object>> page, Map<String, Object> params);
	
	/**
	 * 
	 * @Title:exProcMschemeAddMemberByDocId 
	 * @Description: 群体方案批量添加会员
	 * TODO  
	 * @author baozj
	 * @param params
	 * @return 
	 * @throws
	 * @retrun boolean
	 */
	boolean exProcMschemeAddMemberByDocId(Map<String, Object> params);
	
	/**
	 * 
	 * @Title:updateCanGenerateMscheme 
	 * @Description: 处理可以执行生成任务的方案
	 * TODO  
	 * @author baozj
	 * @param MSDesignID
	 * @return 
	 * @throws
	 * @retrun int
	 */
	int updateCanGenerateMscheme(Integer MSDesignID);
	
	/**
	 * 
	 * @Title:exProcMschemeAddExecTaskByMSDesignID 
	 * @Description:群体方案生效及任务生成
	 * TODO  
	 * @author baozj
	 * @param params
	 * @return 0、失败	1、成功	2、方案已在生成中	3、方案无任务
	 * @throws
	 * @retrun int
	 */
	void exProcMschemeAddExecTaskByMSDesignID(Map<String, Object> params);
	
	/**
	 * 
	 * @Title:deleteAttached 
	 * @Description: 清空附件记录
	 * TODO  
	 * @author baozj
	 * @param id
	 * @return 
	 * @throws
	 * @retrun boolean
	 */
	boolean deleteAttached(Integer id);
	
	/**
	 * 
	 * @Title:updateTaskPlanTime 
	 * @Description: 修改任务执行时间
	 * TODO  
	 * @author baozj
	 * @param MSDTaskID
	 * @param planTimeValue
	 * @param planTimeType
	 * @param planTime
	 * @param docId
	 * @param type
	 * @return 
	 * @throws
	 * @retrun boolean
	 */
	boolean updateTaskPlanTime(Integer MSDTaskID, Short planTimeValue, Byte planTimeType, Date planTime, Integer docId, SchemeTypeEnum type);
	
	/**
	 * 
	 * @Title:updateTaskPlanTime 
	 * @Description: 修改任务执行时间
	 * TODO  
	 * @author baozj
	 * @param MSETaskID
	 * @param planTime
	 * @param docId
	 * @return 
	 * @throws
	 * @retrun boolean
	 */
	boolean updateTaskPlanTime(Long MSETaskID, Date planTime, Integer docId);
	
	/**
	 * 
	 * @Title:deleteGroupMember 
	 * @Description: 移除群体方案中的制定中及生成失败会员
	 * TODO  
	 * @author baozj
	 * @param MSExecID
	 * @return 
	 * @throws
	 * @retrun boolean
	 */
	boolean deleteGroupMember(Long MSExecID);
	
	/**
	 * 
	 * @Title:selectHasOtherExecutoryTask 
	 * @Description: 判断当前任务是否有其它待执行任务
	 * TODO  
	 * @author baozj
	 * @param MSExecID
	 * @param MSETaskID
	 * @return 
	 * @throws
	 * @retrun boolean
	 */
	boolean selectHasOtherExecutoryTask(Long MSExecID, Long MSETaskID);
	
	/**
	 * 
	 * @Title:updateSingleTerminatedManagescheme 
	 * @Description: 终止单个会员方案（包括群体中的）
	 * TODO  
	 * @author baozj
	 * @param docId
	 * @param MSDesignID
	 * @param MSExecID
	 * @param schemeType
	 * @param newStatus
	 * @param massOffReason
	 * @return 
	 * @throws
	 * @retrun boolean
	 */
	boolean updateSingleTerminatedManagescheme(Integer docId, Integer MSDesignID, Long MSExecID, SchemeTypeEnum schemeType, GroupManageschemeEnum newStatus, String massOffReason);
}

