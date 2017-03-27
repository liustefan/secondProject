package com.bithealth.dataConversionServer.qiangHua.dao;

import java.util.List;
import java.util.Map;

import com.bithealth.dataConversionServer.qiangHua.bean.ThypertensionVisits;
import com.bithealth.sdk.core.generic.GenericBaseDao;



public interface ThypertensionVisitsMapper extends GenericBaseDao{
    int deleteByPrimaryKey(String hypeGid);

    int insert(ThypertensionVisits record);

    int insertSelective(ThypertensionVisits record);

    ThypertensionVisits selectByPrimaryKey(String hypeGid);

    int updateByPrimaryKeySelective(ThypertensionVisits record);

    int updateByPrimaryKey(ThypertensionVisits record);
    
    /**
     * 获取未上传的随访记录
     * @param param
     * @return
     */
    List<ThypertensionVisits> queryThypertensionVisits(Map<String, Object> param);
    
    int queryHypertensionVisitsCount(Map<String, Object> param);
    
    int updateDataFlag(Map<String, Object> param);
}