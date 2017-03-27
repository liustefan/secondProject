
package com.bithealth.measureCore.common.model;

import com.bithealth.measureCore.electrocardioPulse.model.Oppg;



/**
 * 类名称: ThreeOneData  
 * 功能描述: 三合一测量数据  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年12月27日 下午4:26:49 
 * 
 * @author 谢美团
 * @version  
 */
public class ThreeOneData extends MiniData {
	
	
	private Oppg oppg;

	public Oppg getOppg() {
		return oppg;
	}

	public void setOppg(Oppg oppg) {
		this.oppg = oppg;
	}
	
	
	
}