/*
 * Member.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-06-23 Created
 */
package com.bithealth.memberCore.member.model;

import java.util.Arrays;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.bithealth.memberCore.enmu.EducationStatus;
import com.bithealth.memberCore.enmu.MarryStatusEnum;
import com.bithealth.memberCore.enmu.OccupationEnmu;
import com.bithealth.memberCore.enmu.UseTag;
import com.bithealth.sdk.common.utils.StringUtil;
import com.bithealth.sdk.core.generic.GenericModel;

/**
 * 会员档案（OMEM）
 * 
 * @author ${user}
 * @version 1.0 2016-06-23
 */
public class Member extends GenericModel {

	private static final long serialVersionUID = 3782785777920082394L;
	/**
     * 会员代码
     */
    private Integer memberid;
    /**
     * 会员帐号
     */
    private String logname;
    /**
     * 组织代码
     */
    private Integer orgid;
    /**
     * 会员类型
     */
    private Short memid;
    /**
     * 会员姓名
     */
    private String memname;
    
    /**
     * 姓名简码
     */
    private String memNameCode;
    /**
     * 性别：1男；2女；3未知
     */
    private String gender = "3";
    /**
     * 出生年月
     */
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date birthdate;
    /**
     * 手机号码
     */
    private String tel;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 身份证号
     */
    private String idcard;
    /**
     * 籍贯
     */
    private String nativeaddr;
    /**
     * 地址
     */
    private String address;
    /**
     * 婚姻状况：1未婚；2已婚；3初婚；4再婚；5复婚；6丧偶；7离异；8未说明的婚姻状况
     */
    private String marrystatus = MarryStatusEnum.UNKNOW.getVal();
    /**
     * 教育状况：1研究生及以上；2大学本科；3大学专科和专科学校；4中等专业学校；5技工学校；6高中；7初中；8小学；9文盲或半文盲；10学历不详；11无
     */
    private String educationstatus = EducationStatus.UNKNOW.getValue();
    /**
     * 职业：1.农林牧渔水利业生产人员；2.生产运输设备操作人员及有关人员；3.专业技术人员；4.办事人员和有关人员；5.商业、服务业人员；6.国家机关、党群组织、企事业单位负责人；7.在校学生；8.家务；9.待业；10.离退休人员；11.婴幼、学龄前儿童；12.军人；13.其他劳动者
     */
    private String occupation = OccupationEnmu.OTHER.getValue();
    /**
     * 医生代码
     */
    private Integer docid;
    /**
     * 医生姓名
     */
    private String docname;
    /**
     * 使用标记
     */
    private String usetag = UseTag.T.name();
    /**
     * 创建时间
     */
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date createtime;
    private byte[] headimg;
    private String headaddress;
    /**
     * 会员状态
     */
    private String status;
    /**
     * 档案来源，0：web医生端注册，1：中联佳裕导入，2：其他
     */
    private Integer source;
    /**
     * 合作方数据标识（如：健康档案号）
     */
    private String uniqueId;
    
    private String memberGUID;
    
    /**
     * 会员类型对象
     */
    private MemberType memberType;
    
    /**
     * 所属组织
     */
    private Org org;
    /**
     * [3.0]认证类型(位运算)：0-无，1-手机认证
     */
    private Byte verifyType = 0;
    /**
     * [3.0]是否资料完善：0-否，1-是
     */
    private Byte isInfoPerfect = 0;
    
    /**
     * 来源App注册或者App登录过
     */
    private boolean fromApp = false;
    
	public boolean isFromApp() {
		return fromApp;
	}
	public void setFromApp(boolean fromApp) {
		this.fromApp = fromApp;
	}
	public Byte getVerifyType() {
		return verifyType;
	}
	public void setVerifyType(Byte verifyType) {
		this.verifyType = verifyType;
	}
	public Byte getIsInfoPerfect() {
		return isInfoPerfect;
	}
	public void setIsInfoPerfect(Byte isInfoPerfect) {
		this.isInfoPerfect = isInfoPerfect;
	}
	public Org getOrg() {
		return org;
	}
	public void setOrg(Org org) {
		this.org = org;
	}
	public MemberType getMemberType() {
		return memberType;
	}
	public void setMemberType(MemberType memberType) {
		this.memberType = memberType;
	}
	public Integer getMemberid() {
        return memberid;
    }
    public void setMemberid(Integer memberid) {
        this.memberid = memberid;
    }
    public String getLogname() {
        return logname;
    }
    public void setLogname(String logname) {
        this.logname = logname;
    }
    public Integer getOrgid() {
        return orgid;
    }
    public void setOrgid(Integer orgid) {
        this.orgid = orgid;
    }
    public Short getMemid() {
        return memid;
    }
    public void setMemid(Short memid) {
        this.memid = memid;
    }
    public String getMemname() {
        return memname;
    }
    public void setMemname(String memname) {
        this.memname = memname;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public Date getBirthdate() {
        return birthdate;
    }
    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }
    public String getTel() {
        return tel;
    }
    public void setTel(String tel) {
        this.tel = tel;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getIdcard() {
        return idcard;
    }
    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }
    public String getNativeaddr() {
        return nativeaddr;
    }
    public void setNativeaddr(String nativeaddr) {
        this.nativeaddr = nativeaddr;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getMarrystatus() {
        return marrystatus;
    }
    public void setMarrystatus(String marrystatus) {
        this.marrystatus = marrystatus;
    }
    public String getEducationstatus() {
        return educationstatus;
    }
    public void setEducationstatus(String educationstatus) {
        this.educationstatus = educationstatus;
    }
    public String getOccupation() {
        return occupation;
    }
    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }
    public Integer getDocid() {
        return docid;
    }
    public void setDocid(Integer docid) {
        this.docid = docid;
    }
    public String getDocname() {
        return docname;
    }
    public void setDocname(String docname) {
        this.docname = docname;
    }
    public String getUsetag() {
        return usetag;
    }
    public void setUsetag(String usetag) {
        this.usetag = usetag;
    }
    public Date getCreatetime() {
        return createtime;
    }
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
    public byte[] getHeadimg() {
        return headimg;
    }
    public void setHeadimg(byte[] headimg) {
        this.headimg = headimg;
    }
    public String getHeadaddress() {
        return headaddress;
    }
    public void setHeadaddress(String headaddress) {
        this.headaddress = headaddress;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public Integer getSource() {
        return source;
    }
    public void setSource(Integer source) {
        this.source = source;
    }
    public String getUniqueId() {
        return uniqueId;
    }
    public void setUniqueId(String uniqueId) {
        this.uniqueId = uniqueId;
    }
    
	public String getMemberGUID() {
		return memberGUID;
	}
	public void setMemberGUID(String memberGUID) {
		this.memberGUID = memberGUID;
	}
	
	public String getMemNameCode() {
		return memNameCode;
	}
	public void setMemNameCode(String memNameCode) {
		this.memNameCode = memNameCode;
	}
	@Override
	public String toString() {
		return "Member [memberid=" + memberid + ", logname=" + logname
				+ ", orgid=" + orgid + ", memid=" + memid + ", memname="
				+ memname + ", memNameCode=" + memNameCode + ", gender="
				+ gender + ", birthdate=" + birthdate + ", tel=" + tel
				+ ", email=" + email + ", idcard=" + idcard + ", nativeaddr="
				+ nativeaddr + ", address=" + address + ", marrystatus="
				+ marrystatus + ", educationstatus=" + educationstatus
				+ ", occupation=" + occupation + ", docid=" + docid
				+ ", docname=" + docname + ", usetag=" + usetag
				+ ", createtime=" + createtime + ", headimg="
				+ Arrays.toString(headimg) + ", headaddress=" + headaddress
				+ ", status=" + status + ", source=" + source + ", uniqueId="
				+ uniqueId + ", memberGUID=" + memberGUID + ", memberType="
				+ memberType + ", org=" + org + "]";
	}
	
	
	/**
     * 
     * @Title:compeleted 
     * @Description:是否已经完善. 
     * @author liuhm
     * @return 
     * @param 
     * @throws
     * @retrun boolean
     */
    public boolean compeleted() {
    	if(this.isInfoPerfect.byteValue() == 1) {
    		return true;
    	}
    	
    	if(StringUtil.isEmpty(this.idcard) || StringUtil.isEmpty(this.memname)) {
    		return false;
    	}
    	return true;
    }
}