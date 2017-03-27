
package com.bithealth.reportCore.facade.model;



/**
 * 类名称: AuditProgressParam  
 * 功能描述: 审核进度相关请求参数
 * 日期: 2016年7月29日 下午3:31:25 
 * 
 * @author 谢美团
 * @version  
 */
public class AuditProgressParam {
	
    /**
     * 进度流水号
     */
    private Long serialNumber;
    /**
     * 报告单号
     */
    private Integer reportNo;
    /**
     * 审核方式
     */
    private String auditMode;
    /**
     * 审核医生
     */
    private Integer docid;
    /**
     * 审核意见
     */
    private String myAdvice;

    /**
     * 多个 进度流水号serialNumber，两个之间以逗号隔开
     */
    private String ids;
    
	public String getIds() {
		return ids;
	}
	public void setIds(String ids) {
		this.ids = ids;
	}
	public Long getSerialNumber() {
		return serialNumber;
	}
	public void setSerialNumber(Long serialNumber) {
		this.serialNumber = serialNumber;
	}
	public Integer getReportNo() {
		return reportNo;
	}
	public void setReportNo(Integer reportNo) {
		this.reportNo = reportNo;
	}
	public String getAuditMode() {
		return auditMode;
	}
	public void setAuditMode(String auditMode) {
		this.auditMode = auditMode;
	}
	public Integer getDocid() {
		return docid;
	}
	public void setDocid(Integer docid) {
		this.docid = docid;
	}
	public String getMyAdvice() {
		return myAdvice;
	}
	public void setMyAdvice(String myAdvice) {
		this.myAdvice = myAdvice;
	}

}