/*
 * TransferTreatmentMapper.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-11-28 Created
 */
package com.bithealth.memberCore.member.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.bithealth.memberCore.member.model.TransferTreatSearchCondtion;
import com.bithealth.memberCore.member.model.TransferTreatment;
import com.bithealth.memberCore.member.model.TransferTreatmentExample;
import com.bithealth.memberCore.member.vo.TransferTreatAndMemVo;
import com.bithealth.sdk.core.feature.orm.mybatis.Page;
import com.bithealth.sdk.core.generic.GenericBaseDao;

public interface TransferTreatmentMapper extends GenericBaseDao<TransferTreatment, TransferTreatmentExample, Integer> {
	
	public List<TransferTreatAndMemVo> selectTransferTreatmentAndMember(Page<TransferTreatAndMemVo> page, Map<String, Object> param);
	
	//新增转诊时查询会员标签关系
	public TransferTreatAndMemVo selectOmemLabel( @Param("memberId")Integer memberId,@Param("createID")Integer createid,Integer orgId);
	
	public TransferTreatAndMemVo selectTransferTreatmentAndDise(@Param("ttreatmentid")Integer id, @Param("createID")Integer docID);
	
	public List<TransferTreatAndMemVo> exeProTreatmentMember(TransferTreatSearchCondtion condition);
	
	TransferTreatment selectTransfertreatmentById(Integer id);
	
	List<TransferTreatment> selectByPage(Page<TransferTreatment> page,@Param("model")TransferTreatment example,@Param("odgpIds")List<Integer> odgpIds);
	
	List<Integer> selectOdgpIdsByDocId(Integer docId);
	
	List<TransferTreatment> selectTransferTreatmentBymemberId(Integer memberid);
	
	List<String> selectMemberLabels(Integer memberid);
}