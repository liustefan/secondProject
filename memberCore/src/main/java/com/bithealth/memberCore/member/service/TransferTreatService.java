package com.bithealth.memberCore.member.service;

import java.util.List;

import com.bithealth.memberCore.member.model.TransferTreatment;
import com.bithealth.memberCore.member.model.TransferTreatmentExample;
import com.bithealth.sdk.core.feature.orm.mybatis.Page;

public interface TransferTreatService {
	
    Page<TransferTreatment>  selectByTransferTreatmentPage(Page<TransferTreatment> page,TransferTreatment example, List<Integer> odgpIds);
	
	int insertTransferTreatment(TransferTreatment pojo);
  
	int updateTransferTreatment(TransferTreatment pojo);
	
	TransferTreatment selectTransferTreatmentById(Integer id);
}
