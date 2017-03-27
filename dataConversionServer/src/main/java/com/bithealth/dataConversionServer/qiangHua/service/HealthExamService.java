package com.bithealth.dataConversionServer.qiangHua.service;

import java.util.List;

import com.bithealth.dataConversionServer.qiangHua.bean.ThealthExam;
import com.bithealth.dataConversionServer.qiangHua.bean.ThealthExamDrug;
import com.bithealth.dataConversionServer.qiangHua.bean.ThealthExamParam;
import com.bithealth.sdk.core.generic.GenericBaseService;



/**
 * @ClassName:     HealthExamTask.java 
 * @Description:   体检数据服务接口类
 * @author         谢美团  
 * @version        V1.0   
 * @Date           2016年2月26日 上午10:43:16
*****/
public interface HealthExamService extends GenericBaseService{
	

	 /** 
	 * @Title: queryHealthExanByParam 
	 * @Description: 更具参数查询体检数据 
	 * @return
	 * @throws Exception    
	 * @retrun List<ThealthExam>
	 */
	List<ThealthExam> queryHealthExanByParam(ThealthExamParam param) throws Exception;
	
	
	 /** 
	 * @Title: getHealthExanCount 
	 * @Description:  获取未读取体检数据的总数
	 * @param param
	 * @return
	 * @throws Exception    
	 * @retrun long
	 */
	public long  getHealthExamCount(ThealthExamParam param) throws Exception;
	
	
	 /** 
	 * @Title: queryHealthExamDrug 
	 * @Description: 查询体检用药情况 
	 * @param exams
	 * @return
	 * @throws Exception    
	 * @retrun List<ThealthExam>
	 */
	List<ThealthExamDrug> queryHealthExamDrug(List<ThealthExam> exams) throws Exception;

	
	 /** 
	 * @Title: saveWholeHealthexam 
	 * @Description: TODO 
	 * @throws Exception    
	 * @retrun void
	 */
	public boolean saveWholeHealthexam(ThealthExam tHealthExam,List<ThealthExamDrug> drugList) throws Exception;
	
	
	
	 /** 
	 * @Title: updateDataStatus 
	 * @Description: 更新数据的状态 
	 * @param list
	 * @return
	 * @throws Exception    
	 * @retrun int
	 */
	public int updateDataStatus(List<String> list,boolean isSuccess) throws Exception;
	
	
	
	
	

}