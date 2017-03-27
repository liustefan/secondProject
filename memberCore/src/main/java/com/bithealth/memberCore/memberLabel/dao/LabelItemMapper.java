/*
 * LabelItemMapper.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-11-29 Created
 */
package com.bithealth.memberCore.memberLabel.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bithealth.memberCore.memberLabel.model.LabelItem;
import com.bithealth.memberCore.memberLabel.model.LabelItemExample;
import com.bithealth.sdk.core.feature.orm.mybatis.Page;
import com.bithealth.sdk.core.generic.GenericBaseDao;
/**
 * 类名称: LabelItemMapper  
 * 功能描述: 标签接口
 * 日期: 2016年12月1日 
 * 
 * @author 周玉飞
 * @version  
 */
public interface LabelItemMapper extends GenericBaseDao<LabelItem, LabelItemExample, Integer> {

	List<LabelItem> selectSysLabel(Integer id);
	
	List<LabelItem> selectDefinedLabel(Integer id);
	
	List<LabelItem> selectLabelByPage(Page<LabelItem> page, LabelItem model);
	
	int updateItemStatus(LabelItem pojo);
	
	/**
	 * 
	 * @Title:selectByDocAndOrgs 
	 * @Description:依据医生ID和组织查询权限标签 
	 * @author liuhm
	 * @return 
	 * @param 
	 * @throws
	 * @retrun List<LabelItem>
	 */
	List<LabelItem> selectByDocAndOrgs(@Param("docId")Integer docId, @Param("orgIds")String orgIds);

	
	LabelItem selectLabelItem(@Param("roleId")Integer roleId, @Param("itemname")String itemname, @Param("id")Integer id, @Param("createID")Integer docId, @Param("superOrgIds")String allSharedOrg);

	LabelItem selectRoleLabelItem(@Param("roleId")Integer roleId, @Param("itemname")String itemname, @Param("id")Integer id);
	
}