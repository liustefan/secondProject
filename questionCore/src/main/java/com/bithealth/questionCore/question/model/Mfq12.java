/*
 * Mfq12.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-07-12 Created
 */
package com.bithealth.questionCore.question.model;

/**
 * 比较值取分表（MFQ12)
 * 
 * @author ${user}
 * @version 1.0 2016-07-12
 */
public class Mfq12 extends Mfq12Key {

    /**
	 * serialVersionUID:TODO(用一句话描述这个变量表示什么). 
	 */
	private static final long serialVersionUID = -4355165027893774089L;
	/**
     * 最小值
     */
    private Integer minNum;
    /**
     * 最大值
     */
    private Integer maxNum;
    /**
     * 得分数
     */
    private Double score;

    public Integer getMinNum() {
        return minNum;
    }
    public void setMinNum(Integer minNum) {
        this.minNum = minNum;
    }
    public Integer getMaxNum() {
        return maxNum;
    }
    public void setMaxNum(Integer maxNum) {
        this.maxNum = maxNum;
    }
    public Double getScore() {
        return score;
    }
    public void setScore(Double score) {
        this.score = score;
    }
}