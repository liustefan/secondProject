package com.bithealth.dataConversionServer.qiangHua.bean;


/**
 * @ClassName:     ThealthExam.java 
 * @Description:   强华健康体检参数类
 * @author         谢美团  
 * @version        V1.0   
 * @Date           2016年2月25日 下午4:34:45
*****/
public class ThealthExamParam {
	
	/**内部主键 */
    private String exGid;
    /**档案内部主键（健康档案号） */
    private String hrGid;
    /**体检编号*/
    private String exId;
    /**档案编号*/
    private String docId;
    /** 数据标识 */
    private String dataFlag;
    /** 每次获取的数据量 */
    private int num;
    
    
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getExGid() {
		return exGid;
	}
	public void setExGid(String exGid) {
		this.exGid = exGid;
	}
	public String getHrGid() {
		return hrGid;
	}
	public void setHrGid(String hrGid) {
		this.hrGid = hrGid;
	}
	public String getExId() {
		return exId;
	}
	public void setExId(String exId) {
		this.exId = exId;
	}
	public String getDocId() {
		return docId;
	}
	public void setDocId(String docId) {
		this.docId = docId;
	}
	public String getDataFlag() {
		return dataFlag;
	}
	public void setDataFlag(String dataFlag) {
		this.dataFlag = dataFlag;
	}

    
    

}