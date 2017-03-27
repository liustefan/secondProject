package com.bithealth.dataConversionServer.model;



/**
 * @ClassName:     OrgidBean.java 
 * @Description:   中科汇康 组织id 和  中联佳裕行政区域 关联实体
 * @author         谢美团  
 * @version        V1.0   
 * @Date           2016年1月4日 上午11:42:54
*****/
public class OrgidBean {

    /** 组织代码*/
    private Integer orgid;
    
	/** 所属机构 */
	private String PRgid;
	
	private String memGrpIds;
	

	public Integer getOrgid() {
		return orgid;
	}

	public void setOrgid(Integer orgid) {
		this.orgid = orgid;
	}

	public String getPRgid() {
		return PRgid;
	}

	public void setPRgid(String pRgid) {
		PRgid = pRgid;
	}

	public String getMemGrpIds() {
		return memGrpIds;
	}

	public void setMemGrpIds(String memGrpIds) {
		this.memGrpIds = memGrpIds;
	}
	
	
	
	
}