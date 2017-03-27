/**
 * @PackageName:      com.bithealth.doctorCore.docGroup.service.impl
 * @FileName:     DocGrpToMemGrpServiceImpl.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      liuhm
 * @version      V1.0  
 * @Createdate:  2016年6月28日 上午10:01:58  
 * 
 */
package com.bithealth.doctorCore.docGroup.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bithealth.doctorCore.docGroup.dao.DocGrpToMemGrpMapper;
import com.bithealth.doctorCore.docGroup.model.DocGrpToMemGrpExample;
import com.bithealth.doctorCore.docGroup.model.DocGrpToMemGrpKey;
import com.bithealth.doctorCore.docGroup.service.DocGrpToMemGrpService;
import com.bithealth.sdk.core.generic.GenericBaseDao;
import com.bithealth.sdk.core.generic.GenericBaseServiceImpl;

/**
 * 类名称: DocGrpToMemGrpServiceImpl  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年6月28日 上午10:01:58 
 * 
 * @author liuhm
 * @version  
 */
@Service("docGrpToMemGrpService")
public class DocGrpToMemGrpServiceImpl extends
		GenericBaseServiceImpl<DocGrpToMemGrpKey, DocGrpToMemGrpExample, DocGrpToMemGrpKey> implements
		DocGrpToMemGrpService {
	
	@Autowired
	private DocGrpToMemGrpMapper docGrpToMemGrpMapper;

	@Override
	public GenericBaseDao<DocGrpToMemGrpKey, DocGrpToMemGrpExample, DocGrpToMemGrpKey> getDao() {
		return docGrpToMemGrpMapper;
	}

	@Override
	public int insert(DocGrpToMemGrpKey model) {
		return super.insert(model);
	}

	@Override
	public int deleteByExample(DocGrpToMemGrpExample example) {
		return 0;
	}

	@Override
	public int insertBatchByMemGroup(List<DocGrpToMemGrpKey> list, int memberGroupId) {
		DocGrpToMemGrpExample example = new DocGrpToMemGrpExample();
		example.createCriteria().andMemgrpidEqualTo(memberGroupId);
		docGrpToMemGrpMapper.deleteByExample(example);
		if(list != null && list.size() > 0) {
			return docGrpToMemGrpMapper.insertBatch(list);
		}
		return 1;
	}

	@Override
	public int deleteByDoctorGroup(Integer doctorGrpId) {
		DocGrpToMemGrpExample example = new DocGrpToMemGrpExample();
		example.createCriteria().andOdgpidEqualTo(doctorGrpId);
		return docGrpToMemGrpMapper.deleteByExample(example);
	}

	@Override
	public int deleteByMemGroup(Integer memGroupId) {
		DocGrpToMemGrpExample example = new DocGrpToMemGrpExample();
		example.createCriteria().andMemgrpidEqualTo(memGroupId);
		return docGrpToMemGrpMapper.deleteByExample(example);
	}
	
}
