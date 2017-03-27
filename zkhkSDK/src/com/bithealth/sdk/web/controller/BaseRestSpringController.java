 
/**
 * @PackageName:      com.bithealth.sdk.web.controller
 * @FileName:     BaseRestSpringController.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      柴仕富
 * @version      V1.0  
 * @Createdate:  2016年7月8日 上午11:34:56  
 * 
 */

package com.bithealth.sdk.web.controller;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * 类名称: BaseRestSpringController  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年7月8日 上午11:34:56 
 * 
 * @author "jason chai"
 * @version  
 */
 


/**
 * 标准的rest方法列表
 * <pre>
 * /userinfo                => index()  
 * /userinfo/new            => _new()  注意: 不使用/userinfo/add => add()的原因是ad会被一些浏览器当做广告URL拦截
 * /userinfo/{id}           => show()  
 * /userinfo/{id}/edit      => edit()  
 * /userinfo        POST    => create()  
 * /userinfo/{id}   PUT     => update()  
 * /userinfo/{id}   DELETE  => delete()  
 * /userinfo        DELETE  => batchDelete()  
 * </pre>
 * 
 * @author badqiu
 */
public class BaseRestSpringController<Entity, PK> extends BaseSpringController {

    @RequestMapping
    public ModelAndView index(HttpServletRequest request,HttpServletResponse response,Entity model) {
        throw new UnsupportedOperationException("not yet implement");
    }
    
    /** 进入新增 */
    @RequestMapping(value="/new")
    public ModelAndView _new(HttpServletRequest request,HttpServletResponse response,Entity model) throws Exception {
        throw new UnsupportedOperationException("not yet implement");
    }
    
    /** 显示 */
    @RequestMapping(value="/{id}")
    public ModelAndView show(@PathVariable PK id) throws Exception {
        throw new UnsupportedOperationException("not yet implement");
    }
    
    /** 编辑 */
    @RequestMapping(value="/{id}/edit")
    public ModelAndView edit(@PathVariable PK id) throws Exception {
        throw new UnsupportedOperationException("not yet implement");
    }
    
    /** 保存新增 */
    @RequestMapping(method=RequestMethod.POST)
    public ModelAndView create(HttpServletRequest request,HttpServletResponse response,Entity model) throws Exception {
        throw new UnsupportedOperationException("not yet implement");
    }
    
    /** 保存更新 */
    @RequestMapping(value="/{id}",method=RequestMethod.PUT)
    public ModelAndView update(@PathVariable PK id,HttpServletRequest request,HttpServletResponse response) throws Exception {
        throw new UnsupportedOperationException("not yet implement");
    }
    
    /** 删除 */
    @RequestMapping(value="/{id}",method=RequestMethod.DELETE)
    public ModelAndView delete(@PathVariable PK id) {
        throw new UnsupportedOperationException("not yet implement");
    }

    /** 批量删除 */
    @RequestMapping(method=RequestMethod.DELETE)
    public ModelAndView batchDelete(@RequestParam("items") PK[] items) {
        throw new UnsupportedOperationException("not yet implement");
    }
}
