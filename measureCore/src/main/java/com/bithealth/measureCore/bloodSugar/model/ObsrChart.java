 
/**
 * @PackageName:      com.bithealth.measureCore.bloodSugar.model
 * @FileName:     ObsrChart.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      陈哲 
 * @version      V1.0  
 * @Createdate:  2016年7月11日 上午9:58:10  
 * 
 */

package com.bithealth.measureCore.bloodSugar.model;


/**
 * 类名称: ObsrChart  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年7月11日 上午9:58:10 
 * 
 * @author 陈哲
 * @version  
 */
public class ObsrChart extends Obsr{
	private String TestTimes;
	private String days;
	private double max;
	private double min;
	private double last;
	private String NE;
	private int num;
	
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
	/**
	 * days.
	 *
	 * @return  the days 
	 */
	public String getDays() {
		return days;
	}
	/**
	 * days.
	 *
	 * @param   days    the days to set 
	 */
	public void setDays(String days) {
		this.days = days;
	}
	/**
	 * max.
	 *
	 * @return  the max 
	 */
	public double getMax() {
		return max;
	}
	/**
	 * max.
	 *
	 * @param   max    the max to set 
	 */
	public void setMax(double max) {
		this.max = max;
	}
	/**
	 * min.
	 *
	 * @return  the min 
	 */
	public double getMin() {
		return min;
	}
	/**
	 * min.
	 *
	 * @param   min    the min to set 
	 */
	public void setMin(double min) {
		this.min = min;
	}
	/**
	 * last.
	 *
	 * @return  the last 
	 */
	public double getLast() {
		return last;
	}
	/**
	 * last.
	 *
	 * @param   last    the last to set 
	 */
	public void setLast(double last) {
		this.last = last;
	}
	/**
	 * nE.
	 *
	 * @return  the nE 
	 */
	public String getNE() {
		return NE;
	}
	/**
	 * nE.
	 *
	 * @param   nE    the nE to set 
	 */
	public void setNE(String nE) {
		NE = nE;
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

