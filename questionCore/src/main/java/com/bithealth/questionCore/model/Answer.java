 
/**
 * @PackageName:      com.bithealth.questionCore.model
 * @FileName:     Answer.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      名字  * 
 * @version      V1.0  
 * @Createdate:  2016年8月16日 上午11:10:33  
 * 
 */

package com.bithealth.questionCore.model;

import java.io.Serializable;
import java.util.Date;


/**
 * 类名称: Answer  
 * 功能描述: TODO 答卷信息  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年8月16日 上午11:10:33 
 * 
 * @author baozj
 * @version  
 */
public class Answer implements Serializable {

	/**
	 * serialVersionUID:TODO(用一句话描述这个变量表示什么). 
	 */
	private static final long serialVersionUID = -6061601117212887719L;
	/**
	 * 答卷编号
	 */
	private Integer id;
	/**
	 * 会员编号
	 */
	private Integer memberId;
	/**
	 * 答卷来源 1、单份答卷; 2、组合答卷
	 */
	private Byte type;
	
	/**
	 * 问卷状态
	 */
	private String tag;
	/**
	 * 问卷名称
	 */
	private String questionName;
	
	 /**
     * 发放时间
     */
    private Date publisherTime;
    
    /**
     * 会员是否已读已审核的答卷：已读：0;未读：1;
     */
    private Integer readStatus;
    
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getMemberId() {
		return memberId;
	}
	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}
	public Byte getType() {
		return type;
	}
	public void setType(Byte type) {
		this.type = type;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public String getQuestionName() {
		return questionName;
	}
	public void setQuestionName(String questionName) {
		this.questionName = questionName;
	}
	public Date getPublisherTime() {
		return publisherTime;
	}
	public void setPublisherTime(Date publisherTime) {
		this.publisherTime = publisherTime;
	}
	public Integer getReadStatus() {
		return readStatus;
	}
	public void setReadStatus(Integer readStatus) {
		this.readStatus = readStatus;
	}
	
    
    
}

