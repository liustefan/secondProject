package com.bithealth.dataConversionServer.assemble;

import com.bithealth.dataConversionServer.util.Constants;
import com.bithealth.inspectCore.inspect.model.PhHypertensiondetail;
import com.bithealth.inspectCore.inspect.model.PhHypertensiondetailmedicine;
import com.bithealth.memberCore.member.model.Member;



public class PhHypertensionAssem {
	
	public Object assemSymptom(Object obj) {
		PhHypertensiondetail detail = (PhHypertensiondetail)obj;
		return detail.getSymptom().replaceAll(Constants.CONTACT_SEPARATOR, ",");
	}
	
	public Object getDrugUage(Object obj) {
		PhHypertensiondetailmedicine detail = (PhHypertensiondetailmedicine)obj;
		return detail.getDrugDosage() + "  " + detail.getDrugFreq();
	}
	
	public Object gender(Object obj) {
		Member mem = (Member)obj;
		if("F".equalsIgnoreCase(mem.getGender())) {
			return "2";
		} else if("M".equalsIgnoreCase(mem.getGender())) {
			return "1";
		}
		return "99";
	}

}
