package com.push.model;

import java.io.Serializable;


/**
 * The persistent class for the hk_push_memeber_tag database table.
 * 
 */
public class HkPushMemberTag implements Serializable {
	private static final long serialVersionUID = 1L;

	private int id;

	private String memberId;

	private String tag;

	public HkPushMemberTag() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMemberId() {
		return this.memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getTag() {
		return this.tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

}