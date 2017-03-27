package com.bithealth.memberCore.member.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import com.bithealth.memberCore.member.dao.TransferTreatmentMapper;
import com.bithealth.memberCore.member.model.TransferTreatSearchCondtion;
import com.bithealth.memberCore.member.model.TransferTreatment;
import com.bithealth.memberCore.member.model.TransferTreatmentExample;
import com.bithealth.memberCore.member.service.TransferTreatmentService;
import com.bithealth.memberCore.member.vo.TransferTreatAndMemVo;
import com.bithealth.sdk.core.feature.orm.mybatis.Page;
import com.bithealth.sdk.core.generic.GenericBaseDao;
import com.bithealth.sdk.core.generic.GenericBaseServiceImpl;

@Service("transfertreatmentService") 
public class TransferTreatmentServiceImpl extends GenericBaseServiceImpl<TransferTreatment,TransferTreatmentExample,
      Integer> implements TransferTreatmentService {
          
    @Resource TransferTreatmentMapper transfertreatmentMapper;
        
    @Override
    public GenericBaseDao<TransferTreatment,TransferTreatmentExample, Integer > getDao() {
        return transfertreatmentMapper;
    }

	@Override
	public Page<TransferTreatAndMemVo> selectTransferTreatmentList(TransferTreatSearchCondtion condition, Page<TransferTreatAndMemVo> page) {
		Map<String, Object> param = new HashMap<String, Object>();
		if(condition.getMemName() != null && !"".equals(condition.getMemName().trim())){
			param.put("memName", condition.getMemName());
		}
		if(condition.getDiseasName() != null && !"".equals(condition.getDiseasName().trim())){
			param.put("diseasName", condition.getDiseasName());
		}
		
		param.put("docId", condition.getDocid());
		param.put("treatStatus", condition.getTreatStatus());
		param.put("updateStartTime", condition.getUpdateStartTime());
		param.put("updateEndTime", condition.getUpdateEndTime());
		transfertreatmentMapper.selectTransferTreatmentAndMember(page, param);
		return page;
	}

	@Override
	public TransferTreatAndMemVo selectTransferTreatmentAndMember(
			Integer id,Integer docId) {
		return transfertreatmentMapper.selectTransferTreatmentAndDise(id,docId);
	}
	
	@Override
	public Page<TransferTreatAndMemVo> exProcTreatmentMemberList(TransferTreatSearchCondtion condition, Page<TransferTreatAndMemVo> page) {
		condition.setPageNo(page.getPageNo());
		condition.setPageSize(page.getPageSize());
		List<TransferTreatAndMemVo> list = transfertreatmentMapper.exeProTreatmentMember(condition);
		int total = condition.getiCount();
		page.setResult(list);
		page.setTotalCount(total);
		return page;
		
	}

	@Override
	public Page<TransferTreatment> selectByPage(Page<TransferTreatment> page,
			TransferTreatment example, List<Integer> odgpIds) {
		transfertreatmentMapper.selectByPage(page, example, odgpIds);
		return page;
	}

	@Override
	public List<TransferTreatment> selectTransferTreatmentBymemberId(
			Integer memberid) {
		return transfertreatmentMapper.selectTransferTreatmentBymemberId(memberid);
	}

	@Override
	public TransferTreatAndMemVo selectOmemLabel(Integer memberId,Integer docId,Integer orgId) {
		return transfertreatmentMapper.selectOmemLabel(memberId,docId,orgId);
	}

	@Override
	public List<String> selectMemberLabels(Integer memberid) {
		return transfertreatmentMapper.selectMemberLabels(memberid);
	}

}
