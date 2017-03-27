package com.bithealth.dataConversionServer.assemble;


import com.bithealth.dataConversionServer.qiangHua.bean.ThypertensionVisits;
import com.bithealth.dataConversionServer.util.Constants;
import com.bithealth.dataConversionServer.util.StringUtil;



public class HypertensionAssembly {
	
	
	public Object symptomAssem(Object obj) {
		ThypertensionVisits visit = (ThypertensionVisits)obj;
		StringBuilder symptom = new StringBuilder();
		if(!StringUtil.isEmpty(visit.getSymptom())) {
			symptom.append(visit.getSymptom()).append(Constants.CONTACT_SEPARATOR);
		}
		if(!StringUtil.isEmpty(visit.getSymptom2())) {
			symptom.append(visit.getSymptom2()).append(Constants.CONTACT_SEPARATOR);
		}
		if(!StringUtil.isEmpty(visit.getSymptom3())) {
			symptom.append(visit.getSymptom3()).append(Constants.CONTACT_SEPARATOR);
		}
		if(!StringUtil.isEmpty(visit.getSymptom4())) {
			symptom.append(visit.getSymptom4()).append(Constants.CONTACT_SEPARATOR);
		}
		if(!StringUtil.isEmpty(visit.getSymptom5())) {
			symptom.append(visit.getSymptom5()).append(Constants.CONTACT_SEPARATOR);
		}
		if(!StringUtil.isEmpty(visit.getSymptom6())) {
			symptom.append(visit.getSymptom6()).append(Constants.CONTACT_SEPARATOR);
		}
		if(!StringUtil.isEmpty(visit.getSymptom7())) {
			symptom.append(visit.getSymptom7()).append(Constants.CONTACT_SEPARATOR);
		}
		if(!StringUtil.isEmpty(visit.getSymptom8())) {
			symptom.append(visit.getSymptom8()).append(Constants.CONTACT_SEPARATOR);
		}
		if(symptom.length() == 0) {
			return "";
		}
		return symptom.substring(0, symptom.lastIndexOf(Constants.CONTACT_SEPARATOR));
	}

}
