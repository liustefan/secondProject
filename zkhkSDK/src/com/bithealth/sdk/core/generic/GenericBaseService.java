package com.bithealth.sdk.core.generic;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bithealth.sdk.core.feature.orm.mybatis.Page;

/**
 * 所有自定义Service的顶级接口,封装常用的增删查改操作
 * <p/>
 * Model : 代表数据库中的表 映射的Java对象类型
 * PK :代表对象的主键类型
 *
 * @author Jason Chai
 * @since 2014年6月9日 下午6:14:06
 */
public interface GenericBaseService<Model,ModelExample, PK> {  

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
    int update(Model model);

    
    
    /**
     * 更新对象
     *
     * @param model 对象
     */
     
      int updateByPrimaryKey(Model model) ;
    
    
    /**
     * 更新对象
     *
     * @param model 对象
     */
      int updateByExampleSelective(Model model,ModelExample example);
    
    
    /**
     * 更新对象
     *
     * @param model 对象
     */
      int updateByExample(Model model,ModelExample example);
    
    
    /**
     * 通过主键, 删除对象
     *
     * @param id 主键
     */
    int delete(PK id);

    /**
     * 通过主键, 查询对象
     *
     * @param id 主键
     * @return model 对象
     */
    Model selectById(PK id);


//    /**
//     * 查询单个对象
//     *
//     * @return 对象
//     */
//    Model selectOne();
//
//
//    /**
//     * 查询多个对象
//     *
//     * @return 对象集合
//     */
//    List<Model> selectList();
    
      
//
//    /**
//     * 分页条件查询
//     * 
//     * @param page
//     * @param model
//     * @return
//     */
//    List<Model> selectByAndPage(Page<Model> page, Model model);
     
    /**
     * 分页条件查询
     * 
     * @param page
     * @param model
     * @return
     */
    List<Model> selectByExampleAndPage(Page<Model> page, ModelExample  example);

      
    

    int countByExample(ModelExample example);

    int deleteByExample(ModelExample example);
//
//    int insert(Model record);

    List<Model> selectByExample(ModelExample example);
 
     
}
