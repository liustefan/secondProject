/*
 * DocToGroupMapper.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-06-23 Created
 */
package com.bithealth.doctorCore.docGroup.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bithealth.doctorCore.docGroup.model.DocToGroup;
import com.bithealth.doctorCore.docGroup.model.DocToGroupExample;
import com.bithealth.doctorCore.docGroup.model.DocToGroupKey;
import com.bithealth.sdk.core.generic.GenericBaseDao;

public interface DocToGroupMapper extends GenericBaseDao<DocToGroup, DocToGroupExample, DocToGroupKey> {
	
	/**
	 * 
	 * @Title:insertBatch 
	 * @Description:批量保存医生和医生分组. 
	 * @author liuhm
	 * @param list
	 * @return 
	 * @param 
	 * @throws
	 * @retrun int
	 */
	int insertBatch(List<DocToGroup> list);
	
	/**
	 * 
	 * @Title:selectByDocIdAndFunId 
	 * @Description:获取医生对应的功能选项权限集合
	 * TODO(这里描述这个方法适用条件  执行流程  使用方法 注意事项– 可选).  
	 * @author liuhm
	 * @param docId
	 * @param funIds
	 * @param optId //选项ID
	 * @return 
	 * @param 
	 * @throws
	 * @retrun List<DocToGroup>
	 */
	List<DocToGroup> selectByDocIdAndFunId(@Param("docId")Integer docId, @Param("funIds")List<Integer> funIds, @Param("optId")Integer optId);
	
	List<DocToGroup> selectByOptAndLevel(@Param("docId")Integer docId, @Param("optId")Integer optId, @Param("auditLevel")Integer auditLevel, @Param("orgId")Integer orgId);
}