package com.bithealth.dataConversionServer.qiangHua.service;

import com.bithealth.dataConversionServer.qiangHua.bean.ThypertensionVisits;
import com.bithealth.sdk.core.generic.GenericBaseService;



public interface HypertensionService extends GenericBaseService{
	public final String SUCC_KEY = "succList";
	
	public final String ERROR_KEY = "errList";
	
	public int saveHypertension(ThypertensionVisits visit);

}
