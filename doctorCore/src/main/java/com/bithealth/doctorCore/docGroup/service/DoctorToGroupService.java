/**
 * @PackageName:      com.bithealth.doctorCore.docGroup.service
 * @FileName:     DoctorToGroupService.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      liuhm
 * @version      V1.0  
 * @Createdate:  2016年6月24日 下午3:27:36  
 * 
 */
package com.bithealth.doctorCore.docGroup.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bithealth.doctorCore.docGroup.model.DocToGroup;
import com.bithealth.doctorCore.docGroup.model.DocToGroupExample;
import com.bithealth.doctorCore.docGroup.model.DocToGroupKey;
import com.bithealth.doctorCore.doctor.model.Doctor;
import com.bithealth.sdk.core.generic.GenericBaseService;

/**
 * 类名称: DoctorToGroupService  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年6月24日 下午3:27:36 
 * 
 * @author liuhm
 * @version  
 */
public interface DoctorToGroupService extends GenericBaseService<DocToGroup, DocToGroupExample, DocToGroupKey> {
	
	/**
	 * 
	 * @Title:deleteByDoctor 
	 * @Description:依据医生删除医生和分组关系. 
	 * @author liuhm
	 * @param docId
	 * @return 
	 * @param 
	 * @throws
	 * @retrun boolean
	 */
	public boolean deleteByDoctor(Integer docId);
	
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
	 * @Description:获取医生对应的功能选项权限集合. 
	 * TODO(这里描述这个方法适用条件  执行流程  使用方法 注意事项– 可选).  
	 * @author liuhm
	 * @param doctorId
	 * @param funIdList
	 * @param optId
	 * @return 
	 * @param 
	 * @throws
	 * @retrun List<DocToGroup>
	 */
	List<DocToGroup> selectByDocIdAndFunId(Integer doctorId, List<Integer> funIdList, Integer optId);
	
	/**
	 * 
	 * @Title:insertBatchByDoctor 
	 * @Description:将医生分组批量分配给医生. 
	 * @author liuhm
	 * @param list
	 * @param doctor
	 * @return 
	 * @param 
	 * @throws
	 * @retrun int
	 */
	int insertBatchByDoctor(List<DocToGroup> list, Doctor doctor);
	
	List<DocToGroup> selectByOptAndLevel(Integer docId, Integer optId, Integer auditLevel, Integer orgId);
	
	int deleteByDoctorGroup(Integer doctorGroupId);
	
	int countByDoctorAndGrop(Integer doctorId, Integer grpId);
}
