/**
 * 
 */
package com.bithealth.intef.bean;

import java.io.Serializable;
/**
 * @author lhm
 *
 */
public class MemRegPkg implements Serializable {

	private static final long serialVersionUID = 5892841073473095417L;
	
	private String token;  //
	
	
	private MemRegBean fields;


	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public MemRegBean getFields() {
		return fields;
	}

	public void setFields(MemRegBean fields) {
		this.fields = fields;
	}

	@Override
	public String toString() {
		return "MemRegPkg [token=" + token + ", fields=" + fields + "]";
	}
	public static void main(String[] args) {
		String grpIds = "3";
		System.out.println("==" + grpIds.substring(0,grpIds.length()-1).split(",")[0]);
	}

}
