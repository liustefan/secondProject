/*
 * HabitMapper.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-06-23 Created
 */
package com.bithealth.memberCore.member.dao;

import com.bithealth.memberCore.member.model.Habit;
import com.bithealth.memberCore.member.model.HabitExample;
import com.bithealth.sdk.core.generic.GenericBaseDao;

public interface HabitMapper extends GenericBaseDao<Habit, HabitExample, Integer> {
}