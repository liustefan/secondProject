package com.bithealth.memberCore.memberLabel.faced.service;

import java.util.List;

import com.bithealth.memberCore.memberLabel.model.LabelItem;
import com.bithealth.memberCore.memberLabel.model.LabelItemExample;
import com.bithealth.memberCore.memberLabel.model.LabelTag;
import com.bithealth.memberCore.memberLabel.model.LabelTagExample;
import com.bithealth.sdk.core.feature.orm.mybatis.Page;

/**
 * 类名称: LabelFacedService  
 * 功能描述: 标签对外接口
 * 日期: 2016年12月5日
 * 
 * @author 周玉飞
 * @version  
 */
public interface LabelFacedService {
	
	//标签分类
	boolean insertOrUpdateLabelClass(LabelTag pojo);
	
	boolean deleteLabelClass(Integer id);
	
	LabelTag selectById(Integer id);
	
	List<LabelTag> selectAllLabelClass(LabelTag pojo);
	
	List<LabelTag> selectAllLabelClassUserEdit(LabelTag pojo);
	
	List<LabelTag> selectIsHasLabel(Integer id);//查询标签分类是否有标签
	
	Page<LabelTag> selectLabelClassPage(Page<LabelTag> page,LabelTagExample example);
	
	Page<LabelTag> selectByLabelTagPage(Page<LabelTag> page,LabelTag pojo);

	//标签
	boolean insertOrUpdateLabel(LabelItem pojo);
	
	boolean updateLabelByItemStatus(LabelItem pojo);
	
	LabelItem selectLabelById(Integer id);
	
	Page<LabelItem> selectLabelPage(Page<LabelItem> page,LabelItemExample example);
	
	Page<LabelItem> selectLabelByPage(Page<LabelItem> page, LabelItem model);
	
	List<LabelItem> selectSysLabel(Integer id);
	
	List<LabelItem> selectDefinedLabel(Integer id);
	
	//验证标签在可见域内是否重复
	LabelItem selectLabelItemIsExist(Integer roleId,String itemname, Integer id, Integer docId,String allSharedOrg);
	
}

