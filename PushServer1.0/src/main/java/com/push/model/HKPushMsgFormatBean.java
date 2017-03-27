package com.push.model;

import net.sf.json.JSONObject;


/**
 * @author xiemt
 *
 */
public class HKPushMsgFormatBean {
	
	private String title;
	private String description;
	private String notification_builder_id;
	private String notification_basic_style;
	private String open_type;
	private String net_support;
	private String user_confirm;
	private String url;
	private String pkg_content;
	private String pkg_name;
	private String pkg_version;
	private Object custom_content;
	private JSONObject aps;
	
	private String receiverId;
	private String senderId;
	private String msgId;
	private Long timestamp;
	private String data;
	
	public Long getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}
	public String getReceiverId() {
		return receiverId;
	}
	public void setReceiverId(String receiverId) {
		this.receiverId = receiverId;
	}
	public String getSenderId() {
		return senderId;
	}
	public void setSenderId(String senderId) {
		this.senderId = senderId;
	}
	public String getMsgId() {
		return msgId;
	}
	public void setMsgId(String msgId) {
		this.msgId = msgId;
	}

	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getNotification_builder_id() {
		return notification_builder_id;
	}
	public void setNotification_builder_id(String notification_builder_id) {
		this.notification_builder_id = notification_builder_id;
	}
	public String getNotification_basic_style() {
		return notification_basic_style;
	}
	public void setNotification_basic_style(String notification_basic_style) {
		this.notification_basic_style = notification_basic_style;
	}
	public String getOpen_type() {
		return open_type;
	}
	public void setOpen_type(String open_type) {
		this.open_type = open_type;
	}
	public String getNet_support() {
		return net_support;
	}
	public void setNet_support(String net_support) {
		this.net_support = net_support;
	}
	public String getUser_confirm() {
		return user_confirm;
	}
	public void setUser_confirm(String user_confirm) {
		this.user_confirm = user_confirm;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getPkg_content() {
		return pkg_content;
	}
	public void setPkg_content(String pkg_content) {
		this.pkg_content = pkg_content;
	}
	public String getPkg_name() {
		return pkg_name;
	}
	public void setPkg_name(String pkg_name) {
		this.pkg_name = pkg_name;
	}
	public String getPkg_version() {
		return pkg_version;
	}
	public void setPkg_version(String pkg_version) {
		this.pkg_version = pkg_version;
	}

	public Object getCustom_content() {
		return custom_content;
	}
	public void setCustom_content(Object custom_content) {
		this.custom_content = custom_content;
	}
	public JSONObject getAps() {
		return aps;
	}
	public void setAps(JSONObject aps) {
		this.aps = aps;
	}
}