package com.bithealth.memberCore.member.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bithealth.memberCore.member.dao.TransferTreatmentMapper;
import com.bithealth.memberCore.member.model.TransferTreatment;
import com.bithealth.memberCore.member.model.TransferTreatmentExample;
import com.bithealth.memberCore.member.service.TransferTreatService;
import com.bithealth.memberCore.member.service.TransferTreatmentService;
import com.bithealth.sdk.core.feature.orm.mybatis.Page;
@Service
public class TransferTreatServiceImpl implements TransferTreatService {

	@Autowired
	private TransferTreatmentService transferTreatmentService;
	@Autowired
	private TransferTreatmentMapper transferTreatmentMapper;
	
	@Override
	public Page<TransferTreatment> selectByTransferTreatmentPage(
			Page<TransferTreatment> page, TransferTreatment example,List<Integer> odgpIds) {

		return 	transferTreatmentService.selectByPage(page, example,odgpIds);
	}

	@Override
	public int insertTransferTreatment(TransferTreatment pojo) {
		int n=0;
		if (pojo!=null) {
			n+=transferTreatmentService.insert(pojo);
		}
		return n;
	}

	@Override
	public int updateTransferTreatment(TransferTreatment pojo) {
		int n=0;
		if (pojo!=null && pojo.getTtreatmentid()!=null) {
			n+=transferTreatmentService.update(pojo);
		}
		return n;
	}

	@Override
	public TransferTreatment selectTransferTreatmentById(Integer id) {
		
		return transferTreatmentMapper.selectTransfertreatmentById(id);
	}

}
