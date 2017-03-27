/**
 * 
 */
package com.bithealth.web;


import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * @author jason chai
 *
 */
@SuppressWarnings("serial")
public class UserExt implements Serializable{
	public final static int GUEST = 1;
	public final static int MEMBER = 2;
	public final static int ACTOR = 3;
	public final static int ADMIN = 4;
	
	public Set<String> myVips = new HashSet<String>();
	
	private String id;
	private String uid;
	private String nickName;
	private String realName;
	private int userType;
	
	/**
	 * 最新在线的更新时间,针对guest
	 */
	private Date lastUpdateTime;
	
	public UserExt(String id, String uid,String nickName, String realName, int userType, Set<String> myVips) {
		this.id = id;
		this.uid= uid;
		this.nickName = nickName;
		this.realName = realName;
		this.userType = userType;
		this.myVips = myVips;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public int getUserType() {
		return userType;
	}
	public void setUserType(int userType) {
		this.userType = userType;
	}
	
	

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public boolean isVip(String levelId){
		
		if(myVips == null) return false;
		
		return myVips.contains(levelId);
	}
	
	public boolean isGuest(){
		
		return userType == GUEST;
	}
	
	public boolean isMember(){
		
		return userType == MEMBER  || isActor();
	}
	
	public boolean isActor(){
		
		return userType == ACTOR;
	}
	
	public boolean isAdmin(){
		
		return userType == ADMIN;
	}

	public Date getLastUpdateTime() {
		return lastUpdateTime;
	}

	public void setLastUpdateTime(Date lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}
	
	
}
