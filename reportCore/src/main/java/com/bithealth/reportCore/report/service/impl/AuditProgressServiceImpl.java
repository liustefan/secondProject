package com.bithealth.reportCore.report.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource; 

import org.springframework.stereotype.Service; 

import com.bithealth.sdk.core.feature.orm.mybatis.Page;
import com.bithealth.sdk.core.generic.GenericBaseDao;
import com.bithealth.sdk.core.generic.GenericBaseServiceImpl; 
import com.bithealth.reportCore.report.dao.AuditProgressMapper;
import com.bithealth.reportCore.report.model.AuditProgress; 
import com.bithealth.reportCore.report.model.AuditProgressExample;
import com.bithealth.reportCore.report.model.AuditProgressParams;
import com.bithealth.reportCore.report.service.AuditProgressService;

@Service("auditprogressService") 
public class AuditProgressServiceImpl extends GenericBaseServiceImpl<AuditProgress,AuditProgressExample,
      Long> implements AuditProgressService {
          
    @Resource 
    AuditProgressMapper auditprogressMapper;
        
    @Override
    public GenericBaseDao<AuditProgress,AuditProgressExample,  Long > getDao() {
        return auditprogressMapper;
    }

	public List<AuditProgress> selectByParamsAndPage(Page<AuditProgress> page,AuditProgressParams params) {
		Map<String,Object> paramMap = new HashMap<String,Object>();
		paramMap.put("doctorId", params.getDoctorId());
		paramMap.put("functionId", params.getFunctionId());
		paramMap.put("list", params.getGroupIdList());
		return auditprogressMapper.selectByParamsAndPage(page, paramMap);
	}

	public int selectMaxAuditLevel(AuditProgress auditProgress) {
		return auditprogressMapper.selectMaxAuditLevel(auditProgress);
	}

	public int updateByTableNameAndParam(AuditProgress auditProgress,String tableName) {
		Map<String,Object> parmaMap = new HashMap<String,Object>();
		parmaMap.put("auditProgress", auditProgress);
		parmaMap.put("tableName", tableName);
		return auditprogressMapper.updateByTableNameAndParam(parmaMap);
	}

	public void exProc_pro_updOASR(Integer reportNo) {
		auditprogressMapper.exProc_pro_updOASR(reportNo);
	}

	@Override
	public int updateByReportNoAndSerialNumber(String tableName, Integer docId,Integer reportNo, Long serialNumber,String AuditState,String YNTag) {
		Map<String,Object> parmaMap = new HashMap<String,Object>();
		parmaMap.put("tableName", tableName);
		parmaMap.put("docId", docId);
		parmaMap.put("reportNo", reportNo);
		parmaMap.put("serialNumber", serialNumber);
		parmaMap.put("AuditState", AuditState);
		parmaMap.put("YNTag", YNTag);
		return auditprogressMapper.updateByReportNoAndSerialNumber(parmaMap);
	}

	@Override
	public void exProc_pro_OtherinsOASR(AuditProgress oasr) {
		auditprogressMapper.exProc_pro_OtherinsOASR(oasr);
	}  
}
