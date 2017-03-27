package com.bithealth.dataConversionServer.qiangHua.dao;

import com.bithealth.dataConversionServer.qiangHua.bean.ThealthRecords;
import com.bithealth.sdk.core.generic.GenericBaseDao;



public interface ThealthRecordsMapper extends GenericBaseDao{
    int deleteByPrimaryKey(String hrGid);

    int insert(ThealthRecords record);

    int insertSelective(ThealthRecords record);

    ThealthRecords selectByPrimaryKey(String hrGid);

    int updateByPrimaryKeySelective(ThealthRecords record);

    int updateByPrimaryKey(ThealthRecords record);
}