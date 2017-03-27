package com.bithealth.taskMgrCore.appServerUtil;

import com.bithealth.sdk.core.generic.GenericModel;

public class RequestHead extends GenericModel{

	/* */
	private static final long serialVersionUID = -1906582737864837521L;
	
	/* 用户id */
	private Integer userId;
	
	/* 用户名字 */
	private String userName;
	
	/* 用户账户 */
	private String userAccount;
	
	/* 用户密码*/
	private String userPassword;
	
	/* 用户类型："1":"会员";"2":"医生" */
	private Integer userType;

	/* 用户登录令牌  */
	private String session;

	/* 当前版本号   */
	private String version;
	
	/* 记录登录时间 2016-06-07 08:20:20*/
	private String logTime;
	
	/* 设备驱动类型：Android,PC,IOS,Other; */
	private String deviceType;
	
	/* 用户唯一标识码 */
	private String userGUID;

	
	public RequestHead(Integer userType, String deviceType) {
		super();
		this.userType = userType;
		this.deviceType = deviceType;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserAccount() {
		return userAccount;
	}

	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public Integer getUserType() {
		return userType;
	}

	public void setUserType(Integer userType) {
		this.userType = userType;
	}

	public String getSession() {
		return session;
	}

	public void setSession(String session) {
		this.session = session;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getLogTime() {
		return logTime;
	}

	public void setLogTime(String logTime) {
		this.logTime = logTime;
	}

	public String getDeviceType() {
		return deviceType;
	}

	public void setDeviceType(String deviceType) {
		this.deviceType = deviceType;
	}

	public String getUserGUID() {
		return userGUID;
	}

	public void setUserGUID(String userGUID) {
		this.userGUID = userGUID;
	}
	
}
