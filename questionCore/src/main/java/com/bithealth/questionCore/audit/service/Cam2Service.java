package com.bithealth.questionCore.audit.service;

import com.bithealth.sdk.core.generic.GenericBaseService;
import com.bithealth.questionCore.audit.model.Cam2;
import com.bithealth.questionCore.audit.model.Cam2Example; 
import com.bithealth.questionCore.audit.model. Cam2Key; 

public interface Cam2Service extends GenericBaseService<Cam2,Cam2Example,
   Cam2Key > {    

	public Cam2 selectLatestAudit(Integer memberId);

}
