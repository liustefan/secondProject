package com.bithealth.questionCore.answer.service;

import com.bithealth.questionCore.answer.model.Uai4;
import com.bithealth.questionCore.answer.model.Uai4Example;
import com.bithealth.questionCore.answer.model.Uai4Key;
import com.bithealth.sdk.core.generic.GenericBaseService;

public interface Uai4Service extends GenericBaseService<Uai4,Uai4Example,
   Uai4Key > {
	
	Uai4 selectByMasterId(Integer masterId);
}
