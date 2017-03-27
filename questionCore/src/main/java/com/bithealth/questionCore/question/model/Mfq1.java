/*
 * Mfq1.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-07-12 Created
 */
package com.bithealth.questionCore.question.model;

import java.util.Date;
import java.util.List;

import com.bithealth.questionCore.answer.model.Uai21;

/**
 * 问卷信息明细表（MFQ1)
 * 
 * @author ${user}
 * @version 1.0 2016-07-12
 */
public class Mfq1 extends Mfq1Key {

    /**
	 * serialVersionUID:TODO(用一句话描述这个变量表示什么). 
	 */
	private static final long serialVersionUID = -5486254856397450955L;
	/**
     * 问卷类型ID
     */
    private Short qustTypeid;
    /**
     * 问题内容
     */
    private String proDesc;
    /**
     * 答案个数
     */
    private Short lineNum;
    /**
     * 答案类型
     */
    private String ansType;
    /**
     * 与上题关系：0不同时出现，1同时出现
     */
    private String relation;
    /**
     * 关联问题ID
     */
    private Integer uproblemid;
    /**
     * 关联答案
     */
    private Short uansid;
    /**
     * 创建日期
     */
    private Date createDate;
    
    /**
     * 问题选项
     */
    private List<Mfq11> mfq11s;
    
    /**
     * 问题作答逻辑
     */
    private List<Logics> logicses;
    
    /**
     * 已选择项
     */
    private List<Uai21> uai21s;

    public Short getQustTypeid() {
        return qustTypeid;
    }
    public void setQustTypeid(Short qustTypeid) {
        this.qustTypeid = qustTypeid;
    }
    public String getProDesc() {
        return proDesc;
    }
    public void setProDesc(String proDesc) {
        this.proDesc = proDesc;
    }
    public Short getLineNum() {
        return lineNum;
    }
    public void setLineNum(Short lineNum) {
        this.lineNum = lineNum;
    }
    public String getAnsType() {
        return ansType;
    }
    public void setAnsType(String ansType) {
        this.ansType = ansType;
    }
    public String getRelation() {
        return relation;
    }
    public void setRelation(String relation) {
        this.relation = relation;
    }
    public Integer getUproblemid() {
        return uproblemid;
    }
    public void setUproblemid(Integer uproblemid) {
        this.uproblemid = uproblemid;
    }
    public Short getUansid() {
        return uansid;
    }
    public void setUansid(Short uansid) {
        this.uansid = uansid;
    }
    public Date getCreateDate() {
        return createDate;
    }
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
	public List<Mfq11> getMfq11s() {
		return mfq11s;
	}
	public void setMfq11s(List<Mfq11> mfq11s) {
		this.mfq11s = mfq11s;
	}
	public List<Logics> getLogicses() {
		return logicses;
	}
	public void setLogicses(List<Logics> logicses) {
		this.logicses = logicses;
	}
	public List<Uai21> getUai21s() {
		return uai21s;
	}
	public void setUai21s(List<Uai21> uai21s) {
		this.uai21s = uai21s;
	}
	
}