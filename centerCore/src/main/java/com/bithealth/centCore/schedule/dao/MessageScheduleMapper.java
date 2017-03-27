/*
 * MessageScheduleMapper.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2017-02-06 Created
 */
package com.bithealth.centCore.schedule.dao;

import com.bithealth.centCore.schedule.model.MessageSchedule;
import com.bithealth.centCore.schedule.model.MessageScheduleExample;
import com.bithealth.sdk.core.generic.GenericBaseDao;

public interface MessageScheduleMapper extends GenericBaseDao<MessageSchedule, MessageScheduleExample, Long> {
}