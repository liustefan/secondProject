 
/**
 * @PackageName:      com.bithealth.measureCore.electrocardio.model
 * @FileName:     EcgcChart.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      陈哲 
 * @version      V1.0  
 * @Createdate:  2016年7月13日 上午9:44:46  
 * 
 */

package com.bithealth.measureCore.electrocardio.model;


/**
 * 类名称: EcgcChart  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年7月13日 上午9:44:46 
 * 
 * @author 陈哲
 * @version  
 */
public class Ecg2Chart extends Ecg2{
	private String aName;
	private String measTimes;
	private int num;
	
	/**
	 * aName.
	 *
	 * @return  the aName 
	 */
	public String getaName() {
		return aName;
	}
	/**
	 * aName.
	 *
	 * @param   aName    the aName to set 
	 */
	public void setaName(String aName) {
		this.aName = aName;
	}
	/**
	 * measTimes.
	 *
	 * @return  the measTimes 
	 */
	public String getMeasTimes() {
		return measTimes;
	}
	/**
	 * measTimes.
	 *
	 * @param   measTimes    the measTimes to set 
	 */
	public void setMeasTimes(String measTimes) {
		this.measTimes = measTimes;
	}
	/**
	 * num.
	 *
	 * @return  the num 
	 */
	public int getNum() {
		return num;
	}
	/**
	 * num.
	 *
	 * @param   num    the num to set 
	 */
	public void setNum(int num) {
		this.num = num;
	}
	

}

