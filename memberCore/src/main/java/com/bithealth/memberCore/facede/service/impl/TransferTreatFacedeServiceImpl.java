package com.bithealth.memberCore.facede.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bithealth.memberCore.facede.service.TransferTreatFacedeService;
import com.bithealth.memberCore.member.dao.TransferTreatmentMapper;
import com.bithealth.memberCore.member.model.TransferTreatment;
import com.bithealth.memberCore.member.service.TransferTreatService;
import com.bithealth.sdk.core.feature.orm.mybatis.Page;

@Service
public class TransferTreatFacedeServiceImpl implements TransferTreatFacedeService {

	@Autowired
	private TransferTreatService transferTreatService;
	@Autowired
	private TransferTreatmentMapper transferTreatmentMapper;
	
	@Override
	public Page<TransferTreatment> selectByTransferTreatmentPage(
			Page<TransferTreatment> page, TransferTreatment example,Integer currentDocId) {
			List<Integer> odgpIds = null;
			if(example.getMemberid() == null){
			odgpIds = transferTreatmentMapper.selectOdgpIdsByDocId(currentDocId);
			if(odgpIds == null || odgpIds.isEmpty())
				return page;
		}
		return transferTreatService.selectByTransferTreatmentPage(page, example,odgpIds);
	}

	@Override
	public boolean insertOrUpdateTransferTreatment(TransferTreatment pojo) {
		if (pojo.getTtreatmentid()==null) {
			pojo.setCreatetime(new Date());
			pojo.setUpdatetime(new Date());
			return transferTreatService.insertTransferTreatment(pojo)>0;
		}else 
			pojo.setUpdatetime(new Date());
			return transferTreatService.updateTransferTreatment(pojo)>0;
	}

	@Override
	public TransferTreatment selectTransferTreatmentById(Integer id) {
		return transferTreatService.selectTransferTreatmentById(id);
	}

}
