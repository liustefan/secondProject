package com.bithealth.sdk.core.generic;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bithealth.sdk.core.feature.orm.mybatis.Page;   

/**
 * 所有自定义Dao的顶级接口, 封装常用的增删查改操作,
 * 可以通过Mybatis Generator Maven 插件自动生成Dao,
 * 也可以手动编码,然后继承GenericDao 即可.
 * <p/>
 * Model : 代表数据库中的表 映射的Java对象类型
 * PK :代表对象的主键类型
 *
 * @author Jason Chai
 * @since 2014年6月9日 下午6:14:06
 */
public interface GenericBaseDao<Model,ModelExample, PK> {

    /**
     * 插入对象
     *
     * @param model 对象
     */
    int insertSelective(Model model);
    
    

    /**
     * 插入对象
     *
     * @param model 对象
     */

    int insert(Model model);

    /**
     * 更新对象
     *
     * @param model 对象
     */
    int updateByPrimaryKeySelective(Model model);
    
    
    /**
     * 更新对象
     *
     * @param model 对象
     */
    
    int updateByPrimaryKey(Model model);
    
    

    /**
     * 通过主键, 删除对象
     *
     * @param id 主键
     */
    int deleteByPrimaryKey(PK id);

    /**
     * 通过主键, 查询对象
     *
     * @param id 主键
     * @return
     */
    Model selectByPrimaryKey(PK id);

    

    int countByExample(ModelExample example);

    int deleteByExample(ModelExample example);
//
//    int insert(Model record);

    List<Model> selectByExample(ModelExample example);

    int updateByExampleSelective(@Param("record") Model record, @Param("example") ModelExample example);

    int updateByExample(@Param("record") Model record, @Param("example") ModelExample example);

//    int updateByPrimaryKey(Model record);
  
//    
//    /**
//     * 分页条件查询
//     * 
//     * @param page
//     * @param model
//     * @return
//     */
//    List<Model> selectByModelAndPage(Page<Model> page, Model model); 
     
   

    /**
     * 分页条件查询
     * 
     * @param page
     * @param example
     * @return
     */
    List<Model> selectByExampleAndPage(Page<Model> page, ModelExample example);
     
}
