package com.bithealth.dataConversionServer.qiangHua.dao;


import java.util.List;

import com.bithealth.dataConversionServer.qiangHua.bean.ThealthExam;
import com.bithealth.dataConversionServer.qiangHua.bean.ThealthExamDrug;
import com.bithealth.sdk.core.generic.GenericBaseDao;



public interface ThealthExamDrugMapper extends GenericBaseDao{
    int deleteByPrimaryKey(String exdGid);

    int insert(ThealthExamDrug record);

    int insertSelective(ThealthExamDrug record);

    ThealthExamDrug selectByPrimaryKey(String exdGid);

    int updateByPrimaryKeySelective(ThealthExamDrug record);

    int updateByPrimaryKey(ThealthExamDrug record);
    
    
    
     /** 
     * @Title: queryHealthExamDrug 
     * @Description: 查询体检用药情况 
     * @param exams
     * @return
     * @throws Exception    
     * @retrun List<ThealthExamDrug>
     */
    List<ThealthExamDrug> queryHealthExamDrug(List<ThealthExam> exams) throws Exception;
    
    
    
}