package com.bithealth.statistiCore.statistic.model;
/**
 * 类名：MeasureStatics
 * 描述：测量状况统计实体
 * @author 周玉飞
 *
 */
public class MeasureStatics {
	private String area;//地区
	private int osbpNum;//血压测量总人数
	private int osbpFreq;//血压测量总次数
	private int obsrNum;//血糖测量总人数
	private int obsrFreq;//血糖测量总次数
	private int oppgNum;//三合一测量总人数
	private int oppgFreq;//三合一测量总次数
	private int oecgNum;//动态心电测量总人数
	private int oecgFreq;//动态心电测量总次数
	
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public int getOsbpNum() {
		return osbpNum;
	}
	public void setOsbpNum(int osbpNum) {
		this.osbpNum = osbpNum;
	}
	public int getOsbpFreq() {
		return osbpFreq;
	}
	public void setOsbpFreq(int osbpFreq) {
		this.osbpFreq = osbpFreq;
	}
	public int getObsrNum() {
		return obsrNum;
	}
	public void setObsrNum(int obsrNum) {
		this.obsrNum = obsrNum;
	}
	public int getObsrFreq() {
		return obsrFreq;
	}
	public void setObsrFreq(int obsrFreq) {
		this.obsrFreq = obsrFreq;
	}
	public int getOppgNum() {
		return oppgNum;
	}
	public void setOppgNum(int oppgNum) {
		this.oppgNum = oppgNum;
	}
	public int getOppgFreq() {
		return oppgFreq;
	}
	public void setOppgFreq(int oppgFreq) {
		this.oppgFreq = oppgFreq;
	}
	public int getOecgNum() {
		return oecgNum;
	}
	public void setOecgNum(int oecgNum) {
		this.oecgNum = oecgNum;
	}
	public int getOecgFreq() {
		return oecgFreq;
	}
	public void setOecgFreq(int oecgFreq) {
		this.oecgFreq = oecgFreq;
	}
}
