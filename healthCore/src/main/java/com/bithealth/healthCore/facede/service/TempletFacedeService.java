 
/**
 * @PackageName:      com.bithealth.healthCore.facede.service
 * @FileName:     TempletFacedeService.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      名字  * 
 * @version      V1.0  
 * @Createdate:  2016年11月29日 上午10:31:03  
 * 
 */

package com.bithealth.healthCore.facede.service;

import com.bithealth.healthCore.enmu.TempletStatusEnum;
import com.bithealth.healthCore.templet.model.ManageschemeTemplet;
import com.bithealth.healthCore.templet.model.ManageschemeTempletTask;
import com.bithealth.sdk.core.feature.orm.mybatis.Page;


/**
 * 类名称: TempletFacedeService  
 * 功能描述: TODO 方案模版管理
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年11月29日 上午10:31:03 
 * 
 * @author baozj
 * @version  
 */
public interface TempletFacedeService {

	/**
	 * 
	 * @Title:selectTempletById
	 * @Description:根据管理方案模板ID，查询详细信息 
	 * TODO
	 * @author baozj
	 * @param id
	 * @return 
	 * @throws
	 * @retrun ManageschemeTemplet
	 */
	ManageschemeTemplet selectTempletById(Integer id);
	
	/**
	 * 
	 * @Title:deleteTemplet 
	 * @Description: 
	 * TODO  
	 * @author baozj
	 * @param ids
	 * @return 
	 * @throws
	 * @retrun boolean
	 */
	boolean deleteTemplet(Integer...ids);
	
	/**
	 * 
	 * @Title:insertOrUpdateTemplet 
	 * @Description: 保存方案模板基本信息
	 * TODO  
	 * @author baozj
	 * @param model
	 * @return 
	 * @throws
	 * @retrun boolean
	 */
	boolean insertOrUpdateTemplet(ManageschemeTemplet model);
	
	/**
	 * 
	 * @Title:updateTempletStatus 
	 * @Description: 更新方案模板状态
	 * TODO  
	 * @author baozj
	 * @param id
	 * @param newStatus 
	 * @param oldStatus 可以为空
	 * @return 
	 * @throws
	 * @retrun boolean
	 */
	boolean updateTempletStatus(Integer id, TempletStatusEnum newStatus, TempletStatusEnum oldStatus);
	
	/**
	 * 
	 * @Title:insertOrUpdateTempletTask 
	 * @Description: 保存方案模板任务信息
	 * TODO  
	 * @author baozj
	 * @param model
	 * @return 
	 * @throws
	 * @retrun boolean
	 */
	boolean insertOrUpdateTempletTask(ManageschemeTempletTask model);
	
	/**
	 * 
	 * @Title:deleteTempletTask 
	 * @Description: 删除方案模板任务信息
	 * TODO  
	 * @author baozj
	 * @param id
	 * @return 
	 * @throws
	 * @retrun boolean
	 */
	boolean deleteTempletTask(Integer id);
	
	/**
	 * 
	 * @Title:selectTempletPage 
	 * @Description: 分页查询方案模板
	 * TODO  
	 * @author baozj
	 * @param page
	 * @param model
	 * @return 
	 * @throws
	 * @retrun Page<ManageschemeTemplet>
	 */
	Page<ManageschemeTemplet> selectTempletPage(Page<ManageschemeTemplet> page, ManageschemeTemplet model);
	
	/**
	 * 
	 * @Title:selectTempletIsExist 
	 * @Description:判断方案模板标题是否已被此医生账号使用 
	 * TODO  
	 * @author baozj
	 * @param schemeTitle
	 * @param docId
	 * @return 
	 * @throws
	 * @retrun boolean
	 */
	boolean selectTempletIsExist(String schemeTitle, Integer id, Integer docId);
	
	/**
	 * 
	 * @Title:deleteAttached 
	 * @Description: 删除附件
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
	 * @Title:updateUsedNumber 
	 * @Description:模板被使用次数加1 
	 * TODO  
	 * @author baozj
	 * @param id
	 * @return 
	 * @throws
	 * @retrun boolean
	 */
	boolean updateUsedNumber(Integer id);
	
	/**
	 * 
	 * @Title:selectTempletIsExist 
	 * @Description:验证方案模板标题在可见域中是否唯一 
	 * TODO  
	 * @author baozj
	 * @param roleId
	 * @param schemeTitle
	 * @param id
	 * @param docId
	 * @param allSharedOrg
	 * @return 
	 * @throws
	 * @retrun boolean
	 */
	ManageschemeTemplet selectTempletIsExist(Integer roleId,String schemeTitle, Integer id, Integer docId, String allSharedOrg);
}

