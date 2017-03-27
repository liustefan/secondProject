/*
 * Cqt1.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-07-12 Created
 */
package com.bithealth.questionCore.question.model;

/**
 * 组合问卷关联单份明细（CQT1）
 * 
 * @author ${user}
 * @version 1.0 2016-07-12
 */
public class Cqt1 extends Cqt1Key {

    /**
	 * serialVersionUID:TODO(用一句话描述这个变量表示什么). 
	 */
	private static final long serialVersionUID = 3814725466401429600L;
	/**
     * 问卷编号
     */
    private String qustCode;
    /**
     * 选项代码
     */
    private Short optId;
    /**
     * 功能代码
     */
    private Short funId;
    /**
     * 问卷名称
     */
    private String qustname;
    /**
     * 问卷版本号
     */
    private String qustVer;

    public String getQustCode() {
        return qustCode;
    }
    public void setQustCode(String qustCode) {
        this.qustCode = qustCode;
    }
    public Short getOptId() {
        return optId;
    }
    public void setOptId(Short optId) {
        this.optId = optId;
    }
    public Short getFunId() {
        return funId;
    }
    public void setFunId(Short funId) {
        this.funId = funId;
    }
    public String getQustname() {
        return qustname;
    }
    public void setQustname(String qustname) {
        this.qustname = qustname;
    }
    public String getQustVer() {
        return qustVer;
    }
    public void setQustVer(String qustVer) {
        this.qustVer = qustVer;
    }
}