package com.bithealth.questionCore.audit.service;

import com.bithealth.questionCore.audit.model.Uai3;
import com.bithealth.questionCore.audit.model.Uai3Example;
import com.bithealth.questionCore.audit.model.Uai3Key;
import com.bithealth.sdk.core.generic.GenericBaseService;

public interface Uai3Service extends GenericBaseService<Uai3,Uai3Example,
   Uai3Key > {
	
	Uai3 selectByMasterId(Integer masterId);
	
	public Uai3 selectLatestAudit(Integer memberId);
}
