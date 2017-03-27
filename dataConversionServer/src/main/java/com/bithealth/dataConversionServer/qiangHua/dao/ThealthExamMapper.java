package com.bithealth.dataConversionServer.qiangHua.dao;

import java.util.List;

import com.bithealth.dataConversionServer.qiangHua.bean.ThealthExam;
import com.bithealth.dataConversionServer.qiangHua.bean.ThealthExamParam;
import com.bithealth.sdk.core.generic.GenericBaseDao;


public interface ThealthExamMapper extends GenericBaseDao{
    int deleteByPrimaryKey(String exGid);

    int insert(ThealthExam record);

    int insertSelective(ThealthExam record);

    ThealthExam selectByPrimaryKey(String exGid);

    int updateByPrimaryKeySelective(ThealthExam record);

    int updateByPrimaryKey(ThealthExam record);
    
    
    
     /** 
     * @Title: findHealthExamList 
     * @Description: 查询健康体检数据 
     * @param param
     * @return    
     * @retrun List<ThealthExam>
     */
    List<ThealthExam> findHealthExamList(ThealthExamParam param);
    
     /** 
     * @Title: queryHealthExamCount 
     * @Description: 查询未读取体检数据的总数 
     * @return    
     * @retrun long
     */
    public long  queryHealthExamCount();
    
    
     /** 
     * @Title: updateDataStatus 
     * @Description: 更新数据状态 
     * @param list
     * @param isSuccess
     * @return    
     * @retrun int
     */
    public int   updateSuccessDataStatus(List<String> list);
    /** 
    * @Title: updateDataStatus 
    * @Description: 更新数据状态 
    * @param list
    * @param isSuccess
    * @return    
    * @retrun int
    */
   public int   updateFailDataStatus(List<String> list);
    
}