package com.bithealth.sdk.core.generic;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bithealth.sdk.core.feature.orm.mybatis.Page;

/**
 * GenericService的实现类, 其他的自定义 ServiceImpl, 继承自它,可以获得常用的增删查改操作,
 * 未实现的方法有 子类各自实现
 * <p/>
 * Model : 代表数据库中的表 映射的Java对象类型
 * PK :代表对象的主键类型
 *
 * @author Jason Chai
 * @since 2014年6月9日 下午6:14:06
 */
public abstract class GenericBaseServiceImpl<Model,ModelExample, PK> implements GenericBaseService<Model,ModelExample, PK> {

    /**
     * 定义成抽象方法,由子类实现,完成dao的注入
     *
     * @return GenericDao实现类
     */
    public abstract GenericBaseDao<Model,ModelExample, PK> getDao();

    /**
     * 插入对象
     *
     * @param model 对象
     */
    public int insert(Model model) {
        return getDao().insertSelective(model);
    }

    /**
     * 更新对象
     *
     * @param model 对象
     */
    public int update(Model model) {
        return getDao().updateByPrimaryKeySelective(model);
    }
     
    
    /**
     * 更新对象
     *
     * @param model 对象
     */
     
    public int updateByPrimaryKey(Model model) {
        return getDao().updateByPrimaryKey(model);
    }
    
    
    /**
     * 更新对象
     *
     * @param model 对象
     */
    public int updateByExampleSelective(Model model,ModelExample example) {
        return getDao().updateByExampleSelective(model,example);
    }
    
    
    /**
     * 更新对象
     *
     * @param model 对象
     */
    public int updateByExample(Model model,ModelExample example) {
        return getDao().updateByExample(model,example);
    }
    
 
    
    
    /**
     * 通过主键, 删除对象
     *
     * @param id 主键
     */
    public int delete(PK id) {
        return getDao().deleteByPrimaryKey(id);
    }

    /**
     * 通过主键, 查询对象
     *
     * @param id 主键
     * @return
     */
    public Model selectById(PK id) {
        return getDao().selectByPrimaryKey(id);
    }
//
//    /**
//     * 分页条件查询
//     * 
//     * @param page
//     * @param model
//     * @return
//     */
//    public List<Model> selectByModelAndPage(Page<Model> page, Model model){
//        return getDao().selectByModelAndPage(page,model);
//    } 

    
    /**
     * 分页条件查询
     * 
     * @param page
     * @param model
     * @return
     */
    public List<Model> selectByExampleAndPage(Page<Model> page, ModelExample  example){
        return getDao().selectByExampleAndPage(page,example);
    } 
 

    

    public  int countByExample(ModelExample example){
        return getDao().countByExample(example);
    };

    public   int deleteByExample(ModelExample example){
        return getDao().deleteByExample(example);
    };
//
//    int insert(Model record);

    public List<Model> selectByExample(ModelExample example){
        return getDao().selectByExample(example);
    };
    
//    @Override
//    public Model selectOne() {
//        return null;
//    }
//
//    @Override
//    public List<Model> selectList() {
//        return null;
//    }
}
