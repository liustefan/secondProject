package com.bithealth.dataConversionServer.dao;

import com.bithealth.dataConversionServer.model.DataCenterAreaConfig;
import com.bithealth.dataConversionServer.model.DataCenterAreaConfigExample;
import com.bithealth.sdk.core.generic.GenericBaseDao;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DataCenterAreaConfigMapper extends GenericBaseDao {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table data_center_area_config
     *
     * @mbggenerated Thu Jul 21 10:29:28 CST 2016
     */
    int countByExample(DataCenterAreaConfigExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table data_center_area_config
     *
     * @mbggenerated Thu Jul 21 10:29:28 CST 2016
     */
    int deleteByExample(DataCenterAreaConfigExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table data_center_area_config
     *
     * @mbggenerated Thu Jul 21 10:29:28 CST 2016
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table data_center_area_config
     *
     * @mbggenerated Thu Jul 21 10:29:28 CST 2016
     */
    int insert(DataCenterAreaConfig record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table data_center_area_config
     *
     * @mbggenerated Thu Jul 21 10:29:28 CST 2016
     */
    int insertSelective(DataCenterAreaConfig record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table data_center_area_config
     *
     * @mbggenerated Thu Jul 21 10:29:28 CST 2016
     */
    List<DataCenterAreaConfig> selectByExample(DataCenterAreaConfigExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table data_center_area_config
     *
     * @mbggenerated Thu Jul 21 10:29:28 CST 2016
     */
    DataCenterAreaConfig selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table data_center_area_config
     *
     * @mbggenerated Thu Jul 21 10:29:28 CST 2016
     */
    int updateByExampleSelective(@Param("record") DataCenterAreaConfig record, @Param("example") DataCenterAreaConfigExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table data_center_area_config
     *
     * @mbggenerated Thu Jul 21 10:29:28 CST 2016
     */
    int updateByExample(@Param("record") DataCenterAreaConfig record, @Param("example") DataCenterAreaConfigExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table data_center_area_config
     *
     * @mbggenerated Thu Jul 21 10:29:28 CST 2016
     */
    int updateByPrimaryKeySelective(DataCenterAreaConfig record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table data_center_area_config
     *
     * @mbggenerated Thu Jul 21 10:29:28 CST 2016
     */
    int updateByPrimaryKey(DataCenterAreaConfig record);
    
    
    
    /** 
     * @Title: queryAreaConfigByParam 
     * @Description: 查询开放权限的区域 
     * @return
     * @throws Exception    
     * @retrun List<DataCenterAreaConfig>
     */
    List<DataCenterAreaConfig> queryAreaConfigByParam(int source) throws Exception;
    
    
    /** 
     * @Title: updateLastSendTime 
     * @Description: 更新上次发送时间 
     * @param areaConfig
     * @return
     * @throws Exception    
     * @retrun int
     */
    int updateLastSendTime(DataCenterAreaConfig areaConfig)throws Exception;
    
}