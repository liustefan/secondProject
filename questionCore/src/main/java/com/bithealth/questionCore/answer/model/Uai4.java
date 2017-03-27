/*
 * Uai4.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-07-18 Created
 */
package com.bithealth.questionCore.answer.model;

import org.apache.commons.lang.StringUtils;

/**
 * 
 * 
 * @author ${user}
 * @version 1.0 2016-07-18
 */
public class Uai4 extends Uai4Key {

    /**
	 * serialVersionUID:TODO(用一句话描述这个变量表示什么). 
	 */
	private static final long serialVersionUID = -6850968468523824285L;
	/**
     * 对应分值
     */
    private Double score;
    /**
     * 结论
     */
    private String conclusion;

    public Double getScore() {
        return score;
    }
    public void setScore(Double score) {
        this.score = score;
    }
    public String getConclusion() {
        return conclusion;
    }
    public void setConclusion(String conclusion) {
        this.conclusion = conclusion;
    }
    
    public void appendConclusion(String conclusion) {
    	if(StringUtils.isEmpty(this.conclusion))
    		this.conclusion = conclusion;
    	else
    		this.conclusion = this.conclusion + ";" + conclusion;
    }
}