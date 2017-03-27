package com.bithealth.dataConversionServer.service;

import java.util.Date;
import java.util.List;

import com.bithealth.dataConversionServer.model.DataFileRelation;



public interface DataSendService {
    
     /** 
     * @Title: getBloodGlucoseXmlStrs 
     * @Description: 获取要发送的血糖数据xml字符串list  
     * @param startTime
     * @return
     * @throws Exception    
     * @retrun List<SendDataBean>
     */
    public List<DataFileRelation> getBloodGlucoseXmlStrs(Date startTime,String prgid,int source) throws Exception;
    
     /** 
     * @Title: getBloodPressureXmlStrs 
     * @Description: 获取要发送血压的xml字符串list 
     * @param lastQueryTime
     * @return
     * @throws Exception    
     * @retrun List<SendDataBean>
     */
    public List<DataFileRelation> getBloodPressureXmlStrs(Date startTime,String prgid,int source) throws Exception;
    
    
     /** 
     * @Title: getDiabetesVisitsXmlStrs 
     * @Description: 获取要发送的糖尿病xml字符串list 
     * @param StartTime
     * @return
     * @throws Exception    
     * @retrun List<String>
     */
    public List<DataFileRelation> getDiabetesVisitsXmlStrs(Date StartTime,String prgid,int source) throws Exception;
    
    
     /** 
     * @Title: getHypertensionVisitsXmlStrs 
     * @Description: 获取要发送高血压的xml字符串list 
     * @param startTime
     * @return
     * @throws Exception    
     * @retrun List<String>
     */
    public List<DataFileRelation> getHypertensionVisitsXmlStrs(Date startTime,String prgid,int source) throws Exception;
    
     /** 
     * @Title: getHealthExamsXmlStrs 
     * @Description: 获取要发送健康体检的xml字符串list 
     * @param startTime
     * @return
     * @throws Exception    
     * @retrun List<String>
     */
    public List<DataFileRelation> getHealthExamsXmlStrs(Date startTime,String prgid,int source) throws Exception;
    
    
     /** 
     * @Title: sendMsgToMq 
     * @Description: 保存原始文件并发送消息到QM中 
     * @param relation
     * @param operation
     * @throws Exception    
     * @retrun void
     */
    public void saveRelationAndSendMsgToMq(List<DataFileRelation> sendDataBeanList,String operation,int companyCode)throws Exception;
    
    
    

}
