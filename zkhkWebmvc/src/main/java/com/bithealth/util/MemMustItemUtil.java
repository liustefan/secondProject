/**
 * @PackageName:      com.bithealth.util
 * @FileName:     MemMustItemUtil.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      liuhm
 * @version      V1.0  
 * @Createdate:  2016年9月9日 上午9:15:35  
 * 
 */
package com.bithealth.util;

import com.bithealth.memberCore.member.model.Member;
import com.bithealth.orgainCore.enmu.MemMustItemEnum;
import com.bithealth.sdk.common.utils.StringUtil;
import com.bithealth.sdk.web.beanutils.BeanUtils;

/**
 * 类名称: MemMustItemUtil  
 * 功能描述:校验会员必填配置项  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年9月9日 上午9:15:35 
 * 
 * @author liuhm
 * @version  
 */
public class MemMustItemUtil {
	
	/**
	 * 
	 * @Title:must 
	 * @Description:返回不能为空的提示信息. 
	 * @author liuhm
	 * @param enums
	 * @param member
	 * @return 
	 * @param 
	 * @throws
	 * @retrun String
	 */
	public static String must(MemMustItemEnum[] enums, Member member) {
		if(enums == null || enums.length == 0 || member == null) {
			return null;
		}
		StringBuilder msg = new StringBuilder();
		for(MemMustItemEnum item : enums) {
			String value = BeanUtils.getProperty(member, item.getField());
			if(StringUtil.isEmpty(value)) {
				msg.insert(0, item.getText() + "不能为空;");
			}
		}
		return msg.toString();
	}

}
