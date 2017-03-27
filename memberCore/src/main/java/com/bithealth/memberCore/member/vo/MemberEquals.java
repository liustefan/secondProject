/**
 * @PackageName:      com.bithealth.vo
 * @FileName:     MemberEquals.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      liuhm
 * @version      V1.0  
 * @Createdate:  2016年7月30日 下午2:39:43  
 * 
 */
package com.bithealth.memberCore.member.vo;

import com.bithealth.memberCore.member.model.MemberExt;
import com.bithealth.sdk.common.utils.StringUtil;

/**
 * 类名称: MemberEquals  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年7月30日 下午2:39:43 
 * 
 * @author liuhm
 * @version  
 */
public class MemberEquals<E> extends AbsObjectEquals<E> {

	@Override
	public boolean isEquals(E obj1, E obj2) {
		MemberExt member1 = (MemberExt)obj1;
		MemberExt member2 = (MemberExt)obj2;
		if(isEquals(member1.getIdcard(), member2.getIdcard())){
			return true;
		}
		if(StringUtil.isNotEmpty(member1.getMemname()) && StringUtil.isNotEmpty(member1.getTel())) {
			if(member1.getMemname().equals(member2.getMemname()) && member1.getTel().equals(member2.getTel())) {
				return true;
			}
		}
		return false;
	}
	
	private boolean isEquals(String arg1, String arg2){
		if(StringUtil.isEmpty(arg1) || StringUtil.isEmpty(arg2)){
			return false;
		}
		return arg1.trim().equals(arg2);
	}

}
