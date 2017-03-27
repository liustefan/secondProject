/*
 * LabelTagMapper.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-11-29 Created
 */
package com.bithealth.memberCore.memberLabel.dao;

import java.util.List;

import com.bithealth.memberCore.memberLabel.model.LabelTag;
import com.bithealth.memberCore.memberLabel.model.LabelTagExample;
import com.bithealth.sdk.core.feature.orm.mybatis.Page;
import com.bithealth.sdk.core.generic.GenericBaseDao;
/**
 * 类名称: LabelTagMapper  
 * 功能描述: 标签分类接口
 * 日期: 2016年12月1日 
 * 
 * @author 周玉飞
 * @version  
 */
public interface LabelTagMapper extends GenericBaseDao<LabelTag, LabelTagExample, Integer> {
	
	List<LabelTag> selectAllLabelClass(LabelTag pojo);
	
	List<LabelTag> selectAllLabelClassUserEdit(LabelTag pojo);
	
	/*List<LabelTag> selectLableClassById(Integer id);*/
	
	List<LabelTag> selectIsHasLabel(Integer id);
	
	List<LabelTag> selectByLabelTagPage(Page<LabelTag> page,LabelTag pojo);
	
}