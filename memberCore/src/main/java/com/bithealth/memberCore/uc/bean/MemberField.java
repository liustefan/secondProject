/**
 * @PackageName:      com.bithealth.memberCore.uc.bean
 * @FileName:     MemberField.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      liuhm
 * @version      V1.0  
 * @Createdate:  2016年9月2日 上午10:37:43  
 * 
 */
package com.bithealth.memberCore.uc.bean;

import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.PropertyUtils;

import com.bithealth.memberCore.member.model.Member;
import com.bithealth.sdk.common.utils.StringUtil;
import com.bithealth.sdk.web.beanutils.BeanUtils;

/**
 * 类名称: MemberField  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年9月2日 上午10:37:43 
 * 
 * @author liuhm
 * @version  
 */
public class MemberField {
	
	private final static Map<String, String> field;
	private final static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	static {
		field = new HashMap<String, String>();
		field.put("memberName", "memname");
		field.put("memberSex", "gender");
		field.put("birthday", "birthdate");
		field.put("mobile", "tel");
		field.put("IDCard", "idcard");
		field.put("memberID", "memberGUID");
		field.put("headAddress", "headaddress");
	}
	
	public static boolean isEdit(Member info, Member member) {
		for(String key : field.values()) {
			try {
				Object obj1 = PropertyUtils.getProperty(info, key);
				Object obj2 = PropertyUtils.getProperty(member, key);
				if(obj1 instanceof Date) {
					if(!sdf.format(obj1).equals(sdf.format(obj2))) {
						return true;
					}
				}
				if(StringUtil.isEmpty(obj2) && StringUtil.isEmpty(obj1)) {
					continue;
				}
				if(!String.valueOf(obj1).equals(String.valueOf(obj2))) {
					return true;
				}
			} catch (IllegalAccessException | InvocationTargetException
					| NoSuchMethodException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
	
	public static MemberInfo getInfo(Member member)  {
		MemberInfo info = new MemberInfo();
		for(String key : field.keySet()) {
			Object obj;
			String val = "";
			try {
				obj = PropertyUtils.getProperty(member, field.get(key));
				if(obj == null) {
					continue;
				}
				if(obj instanceof Date) {
					val = sdf.format((Date)obj);
				} else {
					val = String.valueOf(obj);
				}
			} catch (IllegalAccessException | InvocationTargetException
					| NoSuchMethodException e) {
				e.printStackTrace();
			}
			BeanUtils.setProperty(info, key, val);
		}
		return info;
	}
}
