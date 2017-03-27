/*
 * OptionMapper.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-07-14 Created
 */
package com.bithealth.reportCore.template.dao;

import com.bithealth.reportCore.template.model.Option;
import com.bithealth.reportCore.template.model.OptionExample;
import com.bithealth.reportCore.template.model.OptionKey;
import com.bithealth.sdk.core.generic.GenericBaseDao;

public interface OptionMapper extends GenericBaseDao<Option, OptionExample, OptionKey> {
}