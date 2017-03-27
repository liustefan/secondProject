/**
 * @PackageName:      com.bithealth.vo
 * @FileName:     ZTree.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      liuhm
 * @version      V1.0  
 * @Createdate:  2016年7月23日 下午2:35:19  
 * 
 */
package com.bithealth.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 类名称: ZTree  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年7月23日 下午2:35:19 
 * 
 * @author liuhm
 * @version  
 */
public class ZTree implements Serializable {
	
   private static final long serialVersionUID = 9050817676138070821L;
	
	//ZTree自带属性
	private String id;
	private String name;
	private String pId;
	private boolean open  = true;
	private boolean nocheck = false;
	private boolean isHidden = false;
	private boolean checked = false;
	private String url;
	private String target;
	private String icon;
	private String iconClose;
	private String iconOpen;
	private List<ZTree> children = new ArrayList<ZTree>();
	
	//自定义属性
	private boolean hasAuth = true;
	private ZTree parent;
	
	private String endTag;
	
	private Short maxLevel;
	
	private Short auditLevel;
	
	public Short getMaxLevel() {
		return maxLevel;
	}

	public void setMaxLevel(Short maxLevel) {
		this.maxLevel = maxLevel;
	}

	public Short getAuditLevel() {
		return auditLevel;
	}

	public void setAuditLevel(Short auditLevel) {
		this.auditLevel = auditLevel;
	}

	public ZTree(String id, String name, String pId) {
		this.id = id;
		this.name = name;
		this.pId = pId;
	}
	
	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}

	public boolean isHasAuth() {
		return hasAuth;
	}

	public void setHasAuth(boolean hasAuth) {
		this.hasAuth = hasAuth;
	}

	public List<ZTree> getChildren() {
		return children;
	}

	public void setChildren(List<ZTree> children) {
		this.children = children;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isOpen() {
		return open;
	}

	public void setOpen(boolean open) {
		this.open = open;
	}

	public boolean isNocheck() {
		return nocheck;
	}

	public void setNocheck(boolean nocheck) {
		this.nocheck = nocheck;
	}

	public boolean isHidden() {
		return isHidden;
	}

	public void setHidden(boolean isHidden) {
		this.isHidden = isHidden;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getIconClose() {
		return iconClose;
	}

	public void setIconClose(String iconClose) {
		this.iconClose = iconClose;
	}

	public String getIconOpen() {
		return iconOpen;
	}

	public void setIconOpen(String iconOpen) {
		this.iconOpen = iconOpen;
	}

	public String getpId() {
		return pId;
	}

	public String getEndTag() {
		return endTag;
	}

	public void setEndTag(String endTag) {
		this.endTag = endTag;
	}

	@Override
	public String toString() {
		return "ZTree [id=" + id + ", name=" + name + ", open=" + open
				+ ", nocheck=" + nocheck + ", checked=" + checked + ", pId=" + pId + "]";
	}

	public void setpId(String pId) {
		this.pId = pId;
	}

	public ZTree getParent() {
		return parent;
	}

	public void setParent(ZTree parent) {
		this.parent = parent;
	}
}
