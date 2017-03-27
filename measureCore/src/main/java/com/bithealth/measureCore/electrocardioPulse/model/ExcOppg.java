 

package com.bithealth.measureCore.electrocardioPulse.model;


public class ExcOppg {
	private String name; //异常中文名
	
	private double value;//异常值
	
	private String result;//异常结果

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
	
}

