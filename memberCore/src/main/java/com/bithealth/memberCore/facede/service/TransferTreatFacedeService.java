package com.bithealth.memberCore.facede.service;

import com.bithealth.memberCore.member.model.TransferTreatment;
import com.bithealth.memberCore.member.model.TransferTreatmentExample;
import com.bithealth.sdk.core.feature.orm.mybatis.Page;

public interface TransferTreatFacedeService {
	
	 Page<TransferTreatment>  selectByTransferTreatmentPage(Page<TransferTreatment> page,TransferTreatment example,Integer docId);
		
	 boolean insertOrUpdateTransferTreatment(TransferTreatment pojo);
	 
	 TransferTreatment selectTransferTreatmentById(Integer id);
	   
}
