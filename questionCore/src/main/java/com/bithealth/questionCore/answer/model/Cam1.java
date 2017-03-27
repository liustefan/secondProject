/*
 * Cam1.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-07-18 Created
 */
package com.bithealth.questionCore.answer.model;

/**
 * 组合答卷关联单份答卷（CAM1）
 * 
 * @author ${user}
 * @version 1.0 2016-07-18
 */
public class Cam1 extends Cam1Key {

    /**
	 * serialVersionUID:TODO(用一句话描述这个变量表示什么). 
	 */
	private static final long serialVersionUID = 706727575335053807L;
	/**
     * 答卷状态   Y ：已审核，N ：未完成
     */
    private String ansTag;
    
    private Ouai ouai;

    public String getAnsTag() {
        return ansTag;
    }
    public void setAnsTag(String ansTag) {
        this.ansTag = ansTag;
    }
	public Ouai getOuai() {
		return ouai;
	}
	public void setOuai(Ouai ouai) {
		this.ouai = ouai;
	}
    
}