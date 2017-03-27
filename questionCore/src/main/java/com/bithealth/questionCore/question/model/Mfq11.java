/*
 * Mfq11.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-07-12 Created
 */
package com.bithealth.questionCore.question.model;

/**
 * 问题回答项明细表（MFQ11）
 * 
 * @author ${user}
 * @version 1.0 2016-07-12
 */
public class Mfq11 extends Mfq11Key {

    /**
	 * serialVersionUID:TODO(用一句话描述这个变量表示什么). 
	 */
	private static final long serialVersionUID = 8621271805872427429L;
	/**
     * 答案内容描述
     */
    private String description;
    /**
     * 答案标号
     */
    private String mark;
    /**
     * 对应分值
     */
    private Double score;
    /**
     * 是否填空
     */
    private String fillTag;
    /**
     * 填空
     */
    private String fillblank;
    /**
     * 有效性
     */
    private Boolean isValidate;
    /**
     * 最小参考值
     */
    private Short minScore;
    /**
     * 最大参考值
     */
    private Short maxScore;
    /**
     * 比较值计分标记
     */
    private String comTag;
    /**
     * 创建医生ID
     */
    private Integer createid;
    /**
     * 医生姓名
     */
    private String docName;

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getMark() {
        return mark;
    }
    public void setMark(String mark) {
        this.mark = mark;
    }
    public Double getScore() {
        return score;
    }
    public void setScore(Double score) {
        this.score = score;
    }
    public String getFillTag() {
        return fillTag;
    }
    public void setFillTag(String fillTag) {
        this.fillTag = fillTag;
    }
    public String getFillblank() {
        return fillblank;
    }
    public void setFillblank(String fillblank) {
        this.fillblank = fillblank;
    }
    public Boolean getIsValidate() {
        return isValidate;
    }
    public void setIsValidate(Boolean isValidate) {
        this.isValidate = isValidate;
    }
    public Short getMinScore() {
        return minScore;
    }
    public void setMinScore(Short minScore) {
        this.minScore = minScore;
    }
    public Short getMaxScore() {
        return maxScore;
    }
    public void setMaxScore(Short maxScore) {
        this.maxScore = maxScore;
    }
    public String getComTag() {
        return comTag;
    }
    public void setComTag(String comTag) {
        this.comTag = comTag;
    }
    public Integer getCreateid() {
        return createid;
    }
    public void setCreateid(Integer createid) {
        this.createid = createid;
    }
    public String getDocName() {
        return docName;
    }
    public void setDocName(String docName) {
        this.docName = docName;
    }
}