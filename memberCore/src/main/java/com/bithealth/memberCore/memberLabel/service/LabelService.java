package com.bithealth.memberCore.memberLabel.service;

import java.util.List;

import com.bithealth.memberCore.memberLabel.model.LabelItem;
import com.bithealth.memberCore.memberLabel.model.LabelItemExample;
import com.bithealth.memberCore.memberLabel.model.LabelTag;
import com.bithealth.memberCore.memberLabel.model.LabelTagExample;
import com.bithealth.sdk.core.feature.orm.mybatis.Page;

/**
 * 类名称: LabelService  
 * 功能描述: 标签服务接口
 * 日期: 2016年12月05日 
 * 
 * @author 周玉飞
 * @version  
 */
public interface LabelService {
	
	//标签分类
	int insertLabelClass(LabelTag pojo);
	
	int updateLabelClass(LabelTag pojo);
	
	int deleteLabelClass(Integer id);
	
	LabelTag selectById(Integer id);
	
	List<LabelTag> selectAllLabelClass(LabelTag pojo);
	
	List<LabelTag> selectAllLabelClassUserEdit(LabelTag pojo);
	
	LabelTag selectExistLabelClassName(String name,Integer id);
	
	List<LabelTag> selectIsHasLabel(Integer id);//查询标签分类是否有标签
	
	Page<LabelTag> selectLabelClassPage(Page<LabelTag> page,LabelTagExample example);
	
	Page<LabelTag> selectByLabelTagPage(Page<LabelTag> page,LabelTag pojo);

	
	//标签
	int insertLabel(LabelItem pojo);
	
	int updateLabel(LabelItem pojo);
	
	int updateItemStatus(LabelItem pojo);
	
	LabelItem selectLabelById(Integer id);
	
	//可见域内是否重复
	LabelItem selectLabelItemIsExist(Integer roleId, String itemname,Integer id, Integer docId, String allSharedOrg);
	
	Page<LabelItem> selectLabelPage(Page<LabelItem> page,LabelItemExample example);
	
	Page<LabelItem> selectLabelByPage(Page<LabelItem> page, LabelItem model);
	
	//对外接口
	List<LabelItem> selectSysLabel(Integer id);
	
	List<LabelItem> selectDefinedLabel(Integer id);
	
	/**
	 * 
	 * @Title:selectByDoc 
	 * @Description:依据医生和组织获取有权限的标签. 
	 * @author liuhm
	 * @param docId
	 * @param orgIds
	 * @return 
	 * @param 
	 * @throws
	 * @retrun List<LabelItem>
	 */
	List<LabelItem> selectByDoc(int docId, String orgIds);
}
