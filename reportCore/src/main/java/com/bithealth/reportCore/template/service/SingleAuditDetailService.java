package com.bithealth.reportCore.template.service;

import java.util.List;

import com.bithealth.sdk.core.generic.GenericBaseService;
import com.bithealth.reportCore.template.model.SingleAuditDetail;
import com.bithealth.reportCore.template.model.SingleAuditDetailExample; 
import com.bithealth.reportCore.template.model. SingleAuditDetailKey; 

public interface SingleAuditDetailService extends GenericBaseService<SingleAuditDetail,SingleAuditDetailExample,
   SingleAuditDetailKey > {    
	
	/**
	 * @Title:insertBatch 
	 * @Description:批量插入. 
	 * TODO(这里描述这个方法适用条件  执行流程  使用方法 注意事项– 可选).  
	 * @author 谢美团
	 * @param list
	 * @return 
	 * @throws
	 * @retrun int
	 */ 
	public int insertBatch(List<SingleAuditDetail> list);
	
	
}
