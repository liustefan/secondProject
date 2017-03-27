package com.bithealth.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DiseaseTree implements Serializable {

	private static final long serialVersionUID = -193449229755382317L;
	
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
		private DiseaseTree parent;
		
		private String diseasename;
		
		private String description;
		
		private Integer sortno;
		
		private Integer updateid;
		
		private Date updatetime;
		
		private Integer level;

		public Integer getUpdateid() {
			return updateid;
		}

		public void setUpdateid(Integer updateid) {
			this.updateid = updateid;
		}

		public Date getUpdatetime() {
			return updatetime;
		}

		public void setUpdatetime(Date updatetime) {
			this.updatetime = updatetime;
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

		public String getpId() {
			return pId;
		}

		public void setpId(String pId) {
			this.pId = pId;
		}
		
		public DiseaseTree(String id, String name, String pId) {
			this.id = id;
			this.name = name;
			this.pId = pId;
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

		public boolean isChecked() {
			return checked;
		}

		public void setChecked(boolean checked) {
			this.checked = checked;
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

		public List<ZTree> getChildren() {
			return children;
		}

		public void setChildren(List<ZTree> children) {
			this.children = children;
		}

		public DiseaseTree getParent() {
			return parent;
		}

		public void setParent(DiseaseTree parent) {
			this.parent = parent;
		}

		public String getDiseasename() {
			return diseasename;
		}

		public void setDiseasename(String diseasename) {
			this.diseasename = diseasename;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public Integer getSortno() {
			return sortno;
		}

		public void setSortno(Integer sortno) {
			this.sortno = sortno;
		}
		
		public Integer getLevel() {
			return level;
		}

		public void setLevel(Integer level) {
			this.level = level;
		}

		@Override
		public String toString() {
			return "ZTree [id=" + id + ", name=" + name + ", open=" + open
					+ ", nocheck=" + nocheck + ", checked=" + checked + ", pId=" + pId + ", level=" + level + "]";
		}
}
