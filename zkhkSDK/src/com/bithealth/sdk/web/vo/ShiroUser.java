 
/**
 * @PackageName:      com.bithealth.sdk.web.vo
 * @FileName:     ShiroUser.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      柴仕富
 * @version      V1.0  
 * @Createdate:  2016年7月12日 下午7:41:24  
 * 
 */

package com.bithealth.sdk.web.vo;

import java.io.Serializable;
import java.util.Date;
 
import com.google.common.base.Objects;


/**
 * 类名称: ShiroUser  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年7月12日 下午7:41:24 
 * 
 * @author "jason chai"
 * @version  
 */
/**
 * 自定义Authentication对象，使得Subject除了携带用户的登录名外还可以携带更多信息.
 */
public class ShiroUser implements Serializable {
    private static final long serialVersionUID = -1373760761780840081L;
    /**
     * 对象ID
     */
    private Integer id;
    
    /**
     * 登录账号
     */
    private String name;
    
    /**
     * 姓名
     */
    private String realName;
    
    private String email;
    
    /**
     * 组织
     */
    private Integer dept_id;
    
    /**
     * 状态
     */
    private String state;
    
    /**
     * 本次登录时间
     */
    private Date loginTime;

    /**
     * 角色ID
     */
    private Integer roleid; 
    
    /**
     * 上次登录IP
     */
    private String lastLoginAddr;
    
    /**
     * 上次登录时间
     */
    private Date lastLoginTime; 
    
    /**
     * 头像地址
     */
    private String headAddress;
    
    private String gender;
    
    /**
     * 签名地址
     */
    private String signAddress;
    
    private String orgName;
    
    public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ShiroUser() {

    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public Integer getDept_id() {
        return dept_id;
    }

    public void setDept_id(Integer dept_id) {
        this.dept_id = dept_id;
    }

    public Date getLoginTime() {
        return loginTime;
    }

    
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }
    
	public Integer getRoleid() {
		return roleid;
	}

	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}

	public String getLastLoginAddr() {
        return lastLoginAddr;
    }

    public void setLastLoginAddr(String lastLoginAddr) {
        this.lastLoginAddr = lastLoginAddr;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }
    
    public String getHeadAddress() {
		return headAddress;
	}

	public void setHeadAddress(String headAddress) {
		this.headAddress = headAddress;
	}

	public String getSignAddress() {
		return signAddress;
	}

	public void setSignAddress(String signAddress) {
		this.signAddress = signAddress;
	}

	/**
     * 本函数输出将作为默认的<shiro:principal/>输出.
     */
    @Override
    public String toString() {
        return name;
    }

    public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	/**
     * 重载hashCode,只计算name;
     */
    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }

    /**
     * 重载equals,只计算name;
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        ShiroUser other = (ShiroUser) obj;
        if (name == null) {
            if (other.name != null) {
                return false;
            }
        } else if (!name.equals(other.name)) {
            return false;
        }
        return true;
    }

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
    
}

