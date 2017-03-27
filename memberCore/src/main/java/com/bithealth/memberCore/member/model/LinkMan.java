/*
 * LinkMan.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-06-23 Created
 */
package com.bithealth.memberCore.member.model;

/**
 * 紧急联系人(MEM1)
 * 
 * @author ${user}
 * @version 1.0 2016-06-23
 */
public class LinkMan extends LinkManKey {

	private static final long serialVersionUID = 8431262256742907908L;
	/**
     * 联系人手机
     */
    private String contactmobphone;
    /**
     * 关系
     */
    private String relation;
    /**
     * 是否接收消息  Y: 是,N : 否
     */
    private String messagetag;
    /**
     * 是否接收回复  Y：是，N：否
     */
    private String receivetag;

    public String getContactmobphone() {
        return contactmobphone;
    }
    public void setContactmobphone(String contactmobphone) {
        this.contactmobphone = contactmobphone;
    }
    public String getRelation() {
        return relation;
    }
    public void setRelation(String relation) {
        this.relation = relation;
    }
    public String getMessagetag() {
        return messagetag;
    }
    public void setMessagetag(String messagetag) {
        this.messagetag = messagetag;
    }
    public String getReceivetag() {
        return receivetag;
    }
    public void setReceivetag(String receivetag) {
        this.receivetag = receivetag;
    }
}