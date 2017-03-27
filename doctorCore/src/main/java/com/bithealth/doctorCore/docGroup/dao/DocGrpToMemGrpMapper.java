/*
 * DocGrpToMemGrpMapper.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-06-23 Created
 */
package com.bithealth.doctorCore.docGroup.dao;

import java.util.List;

import com.bithealth.doctorCore.docGroup.model.DocGrpToMemGrpExample;
import com.bithealth.doctorCore.docGroup.model.DocGrpToMemGrpKey;
import com.bithealth.sdk.core.generic.GenericBaseDao;

public interface DocGrpToMemGrpMapper extends GenericBaseDao<DocGrpToMemGrpKey, DocGrpToMemGrpExample, DocGrpToMemGrpKey> {
	
	int insertBatch(List<DocGrpToMemGrpKey> list);
}