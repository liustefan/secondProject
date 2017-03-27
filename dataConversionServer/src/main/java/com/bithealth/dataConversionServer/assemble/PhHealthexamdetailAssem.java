package com.bithealth.dataConversionServer.assemble;

import com.bithealth.dataConversionServer.util.Constants;
import com.bithealth.inspectCore.inspect.model.PhHypertensiondetailmedicine;
import com.bithealth.inspectCore.physical.model.PhHealthexamdetail;


public class PhHealthexamdetailAssem {
	
	public Object assemReplaceAll(Object obj) {
		PhHealthexamdetail detail = (PhHealthexamdetail)obj;
		return detail.getSymptom().replaceAll(Constants.CONTACT_SEPARATOR, ",");
	}
	
	public Object getDrugUage(Object obj) {
		PhHypertensiondetailmedicine detail = (PhHypertensiondetailmedicine)obj;
		return detail.getDrugDosage() + "  " + detail.getDrugFreq();
	}

}
