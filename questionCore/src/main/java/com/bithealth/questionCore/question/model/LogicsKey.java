/*
 * LogicsKey.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-07-12 Created
 */
package com.bithealth.questionCore.question.model;

import com.bithealth.sdk.core.generic.GenericModel;

public class LogicsKey extends GenericModel {

    /**
	 * serialVersionUID:TODO(用一句话描述这个变量表示什么). 
	 */
	private static final long serialVersionUID = 8515224989311127992L;
	/**
     * 问卷编号
     */
    private Integer questId;
    /**
     * 问题编号
     */
    private Integer problemId;
    /**
     * 答案编号
     */
    private Integer answerId;

    public Integer getQuestId() {
        return questId;
    }
    public void setQuestId(Integer questId) {
        this.questId = questId;
    }
    public Integer getProblemId() {
        return problemId;
    }
    public void setProblemId(Integer problemId) {
        this.problemId = problemId;
    }
    public Integer getAnswerId() {
        return answerId;
    }
    public void setAnswerId(Integer answerId) {
        this.answerId = answerId;
    }
}