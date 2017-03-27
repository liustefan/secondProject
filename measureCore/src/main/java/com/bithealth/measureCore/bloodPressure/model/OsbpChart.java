 
/**
 * @PackageName:      com.bithealth.measureCore.bloodPressure.model
 * @FileName:     OsbpChart.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      陈哲 
 * @version      V1.0  
 * @Createdate:  2016年7月6日 下午2:18:26  
 * 
 */

package com.bithealth.measureCore.bloodPressure.model;


/**
 * 类名称: OsbpChart  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年7月6日 下午2:18:26 
 * 
 * @author 陈哲
 * @version  
 */
public class OsbpChart extends Osbp{
	private int num;		//附加计算用途
	private String TimeQ;	//时间区域
	private String XY;		//血压  正常、偏高、偏低
	private String TestTimes;
	
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
	/**
	 * timeQ.
	 *
	 * @return  the timeQ 
	 */
	public String getTimeQ() {
		return TimeQ;
	}
	/**
	 * timeQ.
	 *
	 * @param   timeQ    the timeQ to set 
	 */
	public void setTimeQ(String timeQ) {
		TimeQ = timeQ;
	}
	/**
	 * xY.
	 *
	 * @return  the xY 
	 */
	public String getXY() {
		return XY;
	}
	/**
	 * xY.
	 *
	 * @param   xY    the xY to set 
	 */
	public void setXY(String xY) {
		XY = xY;
	}
	/**
	 * testTimes.
	 *
	 * @return  the testTimes 
	 */
	public String getTestTimes() {
		return TestTimes;
	}
	/**
	 * testTimes.
	 *
	 * @param   testTimes    the testTimes to set 
	 */
	public void setTestTimes(String testTimes) {
		TestTimes = testTimes;
	}
}

