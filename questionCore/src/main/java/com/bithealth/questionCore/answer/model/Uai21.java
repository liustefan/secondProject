/*
 * Uai21.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-07-18 Created
 */
package com.bithealth.questionCore.answer.model;

/**
 * 会员答卷答案明细（UAI21）
 * 
 * @author ${user}
 * @version 1.0 2016-07-18
 */
public class Uai21 extends Uai21Key {

    /**
	 * serialVersionUID:TODO(用一句话描述这个变量表示什么). 
	 */
	private static final long serialVersionUID = 5973149979168991131L;
	/**
     * 对应分值
     */
    private Double score;
    /**
     * 填空
     */
    private String fillblank;

    public Double getScore() {
        return score;
    }
    public void setScore(Double score) {
        this.score = score;
    }
    public String getFillblank() {
        return fillblank;
    }
    public void setFillblank(String fillblank) {
        this.fillblank = fillblank;
    }
}