/*
 * Mfq21.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-07-12 Created
 */
package com.bithealth.questionCore.question.model;

/**
 * 总分比较值设置（MFQ21)
 * 
 * @author ${user}
 * @version 1.0 2016-07-12
 */
public class Mfq21 extends Mfq21Key {

    /**
	 * serialVersionUID:TODO(用一句话描述这个变量表示什么). 
	 */
	private static final long serialVersionUID = 3034689768770323340L;
	/**
     * 总分最小值
     */
    private Double minScore;
    /**
     * 总分最大值
     */
    private Double maxScore;
    /**
     * 结论
     */
    private String conclusion;

    public Double getMinScore() {
        return minScore;
    }
    public void setMinScore(Double minScore) {
        this.minScore = minScore;
    }
    public Double getMaxScore() {
        return maxScore;
    }
    public void setMaxScore(Double maxScore) {
        this.maxScore = maxScore;
    }
    public String getConclusion() {
        return conclusion;
    }
    public void setConclusion(String conclusion) {
        this.conclusion = conclusion;
    }
}