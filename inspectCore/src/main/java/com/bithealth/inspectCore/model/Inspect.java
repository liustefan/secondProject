 
/**
 * @PackageName:      com.bithealth.inspectCore.model
 * @FileName:     Inspect.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      名字  * 
 * @version      V1.0  
 * @Createdate:  2016年8月1日 上午10:33:56  
 * 
 */

package com.bithealth.inspectCore.model;

import java.util.Date;
import java.util.List;


/**
 * 类名称: Inspect  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年8月1日 上午10:33:56 
 * 
 * @author baozj
 * @version  
 */
public class Inspect extends DictEntity {

	/**
	 * serialVersionUID:TODO(用一句话描述这个变量表示什么). 
	 */
	private static final long serialVersionUID = 5169614515595065733L;
	
	/**
	 * 数据来源表主键
	 */
	private Long id;
	/**
	 * 数据来源 1、健康体检; 2、高血压随访; 3、糖尿病随访
	 */
	private Integer type;
	
	/**
     * 会员ID，引用omem
     */
    private Integer memberID;
    
    /**
     * 操作时间
     */
    private Date phDate;
    
    /**
     * 结论代码
     */
    private Byte conclusionCode;
    
    /**
     * 结论描述
     */
    private String conclusionDesc;

    private String json;
    
    private List<Inspect> data;
    
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getMemberID() {
		return memberID;
	}

	public void setMemberID(Integer memberID) {
		this.memberID = memberID;
	}

	public Date getPhDate() {
		return phDate;
	}

	public void setPhDate(Date phDate) {
		this.phDate = phDate;
	}

	public Byte getConclusionCode() {
		return conclusionCode;
	}

	public void setConclusionCode(Byte conclusionCode) {
		this.conclusionCode = conclusionCode;
	}

	public String getConclusionDesc() {
		if(this.type != null){
			if(this.type == 2)
				return convertStr("此次随访分类", "高血压随访", this.conclusionCode);
			else if(this.type == 3)
				return convertStr("此次随访分类", "2型糖尿病随访", this.conclusionCode);
		}
		return this.conclusionDesc;
	}

	public void setConclusionDesc(String conclusionDesc) {
		this.conclusionDesc = conclusionDesc;
	}

	public String getJson() {
		return json;
	}

	public void setJson(String json) {
		this.json = json;
	}

	public List<Inspect> getData() {
		return data;
	}

	public void setData(List<Inspect> data) {
		this.data = data;
	}

}

