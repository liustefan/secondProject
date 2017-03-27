
package com.bithealth.measureCore.common.model;

import java.util.List;

import com.bithealth.measureCore.electrocardio.model.Ecg1;
import com.bithealth.measureCore.electrocardio.model.Ecg2;
import com.bithealth.measureCore.electrocardio.model.Ecg3;
import com.bithealth.measureCore.electrocardio.model.Oecg;



/**
 * 类名称: MiniData  
 * 功能描述: mini心电数据 
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年12月27日 下午4:28:49 
 * 
 * @author 谢美团
 * @version  
 */
public class MiniData {

	private Oecg oecg;
	
	private List<Ecg1> ecg1List;
	
	private List<Ecg2> ecg2List;
	
	private List<Ecg3> ecg3List;

	public Oecg getOecg() {
		return oecg;
	}

	public void setOecg(Oecg oecg) {
		this.oecg = oecg;
	}

	public List<Ecg1> getEcg1List() {
		return ecg1List;
	}

	public void setEcg1List(List<Ecg1> ecg1List) {
		this.ecg1List = ecg1List;
	}

	public List<Ecg2> getEcg2List() {
		return ecg2List;
	}

	public void setEcg2List(List<Ecg2> ecg2List) {
		this.ecg2List = ecg2List;
	}

	public List<Ecg3> getEcg3List() {
		return ecg3List;
	}

	public void setEcg3List(List<Ecg3> ecg3List) {
		this.ecg3List = ecg3List;
	}
	
}