/*
 * Logics.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-07-12 Created
 */
package com.bithealth.questionCore.question.model;

import org.apache.commons.lang.StringUtils;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 单份问卷中问题作答逻辑（logics）
 * 
 * @author ${user}
 * @version 1.0 2016-07-12
 */
public class Logics extends LogicsKey {

    /**
	 * serialVersionUID:TODO(用一句话描述这个变量表示什么). 
	 */
	private static final long serialVersionUID = -7309648053751859865L;
	/**
     * 选择的答案编号后，不做答的题号
     */
	private String problemIdsStr;
	
    private Integer[] problemIds;

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