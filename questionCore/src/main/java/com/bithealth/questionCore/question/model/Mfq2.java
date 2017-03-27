/*
 * Mfq2.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-07-12 Created
 */
package com.bithealth.questionCore.question.model;

import java.util.Date;

import org.apache.commons.lang.StringUtils;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 问卷总分信息表（MFQ2）
 * 
 * @author ${user}
 * @version 1.0 2016-07-12
 */
public class Mfq2 extends Mfq2Key {

    /**
	 * serialVersionUID:TODO(用一句话描述这个变量表示什么). 
	 */
	private static final long serialVersionUID = -7234336013502558309L;
	/**
     * 总分描述
     */
    private String description;
    /**
     * 开始题号
     */
    private Integer startid;
    /**
     * 结束题号
     */
    private Integer endid;
    /**
     * 计分方法
     */
    private String countmethod;
    /**
     * 总分
     */
    private Double totalScore;
    /**
     * 创建日期
     */
    private Date createDate;
    /**
     * 有效问题编号（统计总分使用）
     */
    private String problemIdsStr;
    
    private Integer[] problemIds;

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public Integer getStartid() {
        return startid;
    }
    public void setStartid(Integer startid) {
        this.startid = startid;
    }
    public Integer getEndid() {
        return endid;
    }
    public void setEndid(Integer endid) {
        this.endid = endid;
    }
    public String getCountmethod() {
        return countmethod;
    }
    public void setCountmethod(String countmethod) {
        this.countmethod = countmethod;
    }
    public Double getTotalScore() {
        return totalScore;
    }
    public void setTotalScore(Double totalScore) {
        this.totalScore = totalScore;
    }
    public Date getCreateDate() {
        return createDate;
    }
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
    @JSONField(serialize = false)
    public String getProblemIdsStr() {
    	if(StringUtils.isEmpty(problemIdsStr) && problemIds != null)
    		problemIdsStr = StringUtils.join(problemIds, ",");
		return problemIdsStr;
	}
	public void setProblemIdsStr(String problemIdsStr) {
		this.problemIdsStr = problemIdsStr;
	}
	public Integer[] getProblemIds() {
		if(problemIds == null && StringUtils.isNotEmpty(problemIdsStr)){
			String[] strs = problemIdsStr.split(",");
			problemIds = new Integer[strs.length];
			for(int i = 0; i < strs.length; i++){
				problemIds[i] = Integer.parseInt(strs[i]);
			}
		}
        return problemIds;
    }
    public void setProblemIds(Integer[] problemIds) {
        this.problemIds = problemIds;
    }
}