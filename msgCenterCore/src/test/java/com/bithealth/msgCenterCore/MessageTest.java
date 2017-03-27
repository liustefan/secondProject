/**
 * @PackageName:      com.bithealth.msgCenterCore
 * @FileName:     MessageTest.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      胡翔  * 
 * @version      V1.0  
 * @Createdate:  2016年8月3日 下午3:00:54  
 * 
 */
package com.bithealth.msgCenterCore;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.bithealth.msgCenterCore.constants.MessageTypeEnum;
import com.bithealth.msgCenterCore.constants.UserTypeEnum;
import com.bithealth.msgCenterCore.facade.service.MessageCenterFacadeService;
import com.bithealth.msgCenterCore.model.MessageCenter;
import com.bithealth.msgCenterCore.model.MessageCenterExample;
import com.bithealth.sdk.core.feature.orm.mybatis.Page;

/**
 * 类名称: MessageTest  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年8月3日 下午3:00:54 
 * 
 * @author 胡翔
 * @version  
 */
public class MessageTest extends BaseTest{
	
	@Autowired
	private MessageCenterFacadeService messageCenterFacadeService;
	

}
