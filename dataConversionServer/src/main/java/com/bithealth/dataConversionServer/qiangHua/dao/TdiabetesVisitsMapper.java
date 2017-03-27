package com.bithealth.dataConversionServer.qiangHua.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bithealth.dataConversionServer.qiangHua.bean.TdiabetesVisits;
import com.bithealth.sdk.core.generic.GenericBaseDao;


/**
 * 		
 * @ClassName:     TdiabetesVisitsMapper.java 
 * @Description:   TODO 查询强华中间库
 * @author         zengxuhua
 * @version        V1.0   
 * @Date           2016年3月7日 上午10:55:22
****
 */
public interface TdiabetesVisitsMapper extends GenericBaseDao{

    long selectByCount();
    
    List<TdiabetesVisits> select(@Param("num")int num);
    
    void updateByPrimaryKeySelective(TdiabetesVisits tdiabetesVisits);
    
    
}