package com.bithealth.packagCore.facade.service;

import java.util.List;

import com.bithealth.packagCore.packag.model.MemBerPackagTemplate;
import com.bithealth.packagCore.packag.model.MemberPackag;
import com.bithealth.packagCore.packag.model.Packag;
import com.bithealth.packagCore.packag.model.PackagDetail;
import com.bithealth.sdk.core.feature.orm.mybatis.Page;


/**
 * 类名称: PackagService  
 * 功能描述: 套餐模块对外服务接口类 
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年7月5日 下午2:09:29 
 * 
 * @author 谢美团
 * @version  
 */
public interface PackagIFService{

	/**
	 * @Title:selectPackagListByParams 
	 * @Description:根据参数如组织ID，套餐名称，套餐代码等查询套餐列表 ,分页查询. 
	 * isSelectPackagDetail 参数可控制是否关联获取套餐对应的明细列表.  
	 * @author 谢美团
	 * @param page 分页
	 * @param packag 套餐
	 * @param isSelectPackagDetail 是否关联查询套餐对应的明细列表 
	 * @return 
	 * @throws
	 * @retrun List<Packag>
	 */ 
	public List<Packag> selectPackagListByParams(Page<Packag> page,Packag packag,boolean isSelectPackagDetail);
	
	/**
	 * @Title:selectPackagDetailListByPackageCode 
	 * @Description:根据套餐代码查询套餐关联的模板套餐明细. 
	 * TODO(这里描述这个方法适用条件  执行流程  使用方法 注意事项– 可选).  
	 * @author 谢美团
	 * @param packageCode
	 * @return 
	 * @throws
	 * @retrun List<PackagDetail>
	 */ 
	public List<PackagDetail> selectPackagDetailListByPackageCode(Integer packageCode);
	
	/**
	 * @Title:insertPackag 
	 * @Description:新增套餐. 
	 * TODO(这里描述这个方法适用条件  执行流程  使用方法 注意事项– 可选).  
	 * @author 谢美团
	 * @param packag
	 * @return 
	 * @throws
	 * @retrun int
	 */ 
	public int insertPackagAndDetail(Packag packag);
	
	/**
	 * @Title:updatePackag 
	 * @Description:修改套餐. 
	 * TODO(这里描述这个方法适用条件  执行流程  使用方法 注意事项– 可选).  
	 * @author 谢美团
	 * @param packag
	 * @return 
	 * @throws
	 * @retrun int
	 */ 
	public int updatePackag(Packag packag);
	
	/**
	 * @Title:deletePackag 
	 * @Description:根据套餐代码删除套餐. 
	 * TODO(这里描述这个方法适用条件  执行流程  使用方法 注意事项– 可选).  
	 * @author 谢美团
	 * @param packag
	 * @return 
	 * @throws
	 * @retrun int
	 */ 
	public int deletePackag(Packag packag);

	
	/**
	 * @Title:selectMemberPackagListByParams 
	 * @Description:根据参数查询会员订购的套餐信息，分页查询. 
	 * TODO(这里描述这个方法适用条件  执行流程  使用方法 注意事项– 可选).  
	 * @author 谢美团
	 * @param memberPackag
	 * @return 
	 * @throws
	 * @retrun List<MemberPackag>
	 */ 
	public List<MemberPackag> selectMemberPackagListByParams(Page<MemberPackag> page,MemberPackag memberPackag);
	
	
	/**
	 * @Title:deleteMemberPackag 
	 * @Description:删除会员订购的套餐. 
	 * 前置逻辑：删除的套餐在有效期内的不给于删除.  
	 * @author 谢美团
	 * @param memberPackag
	 * @return 
	 * @throws
	 * @retrun String
	 */ 
	public String deleteMemberPackag(MemberPackag memberPackag); 
	
	/**
	 * @Title:updateMemberPackag 
	 * @Description:修改会员订购的套餐. 
	 *  前置逻辑：修改的套餐在有效期内的不给于修改。.  
	 * @author 谢美团
	 * @param memberPackag
	 * @return 
	 * @throws
	 * @retrun String
	 */ 
	public String updateMemberPackag(MemberPackag memberPackag); 
	
	
	
	/**
	 * @Title:insertMemberPackag 
	 * @Description:给会员添加分配套餐. 
	 *  约束逻辑：添加分配的套餐已经分配过且套餐在有效期内的不予于添加.  
	 * @author 谢美团
	 * @param memberPackag
	 * @return 
	 * @throws
	 * @retrun String
	 */ 
	public String insertMemberPackag(MemberPackag memberPackag); 
	
	
	/**
	 * @Title:selectMemBerPackagTemplateByParams 
	 * @Description:查询会员订购套餐的模板使用情况 ，分页查询. 
	 * TODO(这里描述这个方法适用条件  执行流程  使用方法 注意事项– 可选).  
	 * @author 谢美团
	 * @param page
	 * @param memBerPackagTemplate
	 * @return 
	 * @throws
	 * @retrun List<MemBerPackagTemplate>
	 */ 
	public List<MemBerPackagTemplate> selectMemBerPackagTemplateByParams(Page<MemBerPackagTemplate> page,MemBerPackagTemplate memBerPackagTemplate);
	
	

    
}



