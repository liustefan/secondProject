/*
 * SmsSendMapper.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-11-28 Created
 */
package com.bithealth.centCore.sms.dao;

import com.bithealth.centCore.sms.model.SmsSend;
import com.bithealth.centCore.sms.model.SmsSendExample;
import com.bithealth.sdk.core.generic.GenericBaseDao;

public interface SmsSendMapper extends GenericBaseDao<SmsSend, SmsSendExample, Integer> {
}