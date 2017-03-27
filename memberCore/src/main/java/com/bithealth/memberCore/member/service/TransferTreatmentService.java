package com.bithealth.memberCore.member.service;

import java.util.List;

import com.bithealth.memberCore.member.model.TransferTreatSearchCondtion;
import com.bithealth.memberCore.member.model.TransferTreatment;
import com.bithealth.memberCore.member.model.TransferTreatmentExample;
import com.bithealth.memberCore.member.vo.TransferTreatAndMemVo;
import com.bithealth.sdk.core.feature.orm.mybatis.Page;
import com.bithealth.sdk.core.generic.GenericBaseService;

public interface TransferTreatmentService extends GenericBaseService<TransferTreatment,TransferTreatmentExample,
   Integer > {    
	
	public Page<TransferTreatAndMemVo> selectTransferTreatmentList(TransferTreatSearchCondtion condition, Page<TransferTreatAndMemVo> page);
	
	//新增转诊时查询会员标签关系
	public TransferTreatAndMemVo selectOmemLabel(Integer memberId, Integer docId , Integer orgId);
	
	public TransferTreatAndMemVo selectTransferTreatmentAndMember(Integer id,Integer docId);
	
	public Page<TransferTreatAndMemVo> exProcTreatmentMemberList(TransferTreatSearchCondtion condition, Page<TransferTreatAndMemVo> page);

	Page<TransferTreatment> selectByPage(Page<TransferTreatment> page, TransferTreatment example,List<Integer> odgpIds);

	List<TransferTreatment> selectTransferTreatmentBymemberId(Integer memberid);

	List<String> selectMemberLabels(Integer memberid);
	
}
