package com.bithealth.memberCore.memberLabel.faced.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bithealth.memberCore.memberLabel.faced.service.LabelFacedService;
import com.bithealth.memberCore.memberLabel.model.LabelItem;
import com.bithealth.memberCore.memberLabel.model.LabelItemExample;
import com.bithealth.memberCore.memberLabel.model.LabelTag;
import com.bithealth.memberCore.memberLabel.model.LabelTagExample;
import com.bithealth.memberCore.memberLabel.service.LabelService;
import com.bithealth.sdk.core.feature.orm.mybatis.Page;
/**
 * 类名称: LabelFacedServiceImpl  
 * 功能描述: 标签对外接口实现类
 * 日期: 2016年12月5日
 * 
 * @author 周玉飞
 * @version  
 */
@Service
public class LabelFacedServiceImpl implements LabelFacedService {
	
	@Autowired
	private LabelService labelService;

	@Override
	public boolean insertOrUpdateLabelClass(LabelTag pojo) {
		pojo.setUpdatetime(new Date());
		pojo.setCreatetime(new Date());
		if (pojo.getLclassid()==null) {
			return labelService.insertLabelClass(pojo)>0;
		}else{
			return labelService.updateLabelClass(pojo)>0;
		}
	}
	@Override
	public boolean deleteLabelClass(Integer id) {
		return labelService.deleteLabelClass(id)>0;
	}

	@Override
	public LabelTag selectById(Integer id) {
		return labelService.selectById(id);
	}
	
	@Override
	public List<LabelTag> selectAllLabelClass(LabelTag pojo) {
		return labelService.selectAllLabelClass(pojo);
	}
	
	@Override
	public List<LabelTag> selectAllLabelClassUserEdit(LabelTag pojo) {
		return labelService.selectAllLabelClassUserEdit(pojo);
	}
	@Override
	public List<LabelTag> selectIsHasLabel(Integer id) {
		return labelService.selectIsHasLabel(id);
	}
	
	@Override
	public Page<LabelTag> selectLabelClassPage(Page<LabelTag> page,
			LabelTagExample example) {

		return labelService.selectLabelClassPage(page, example);
	}

	@Override
	public boolean insertOrUpdateLabel(LabelItem pojo) {
		if (pojo.getLitemid()==null) {
			pojo.setItemstatus((byte) 1);
			return labelService.insertLabel(pojo)>0;
		}else {
			return labelService.updateLabel(pojo)>0;
		}
	}

	@Override
	public boolean updateLabelByItemStatus(LabelItem pojo) {
		return labelService.updateItemStatus(pojo)>0;
	}

	@Override
	public LabelItem selectLabelById(Integer id) {
		return labelService.selectLabelById(id);
	}

	@Override
	public Page<LabelItem> selectLabelPage(Page<LabelItem> page,
			LabelItemExample example) {
		
		return labelService.selectLabelPage(page, example);
	}
	@Override
	public List<LabelItem> selectSysLabel(Integer id) {
		return labelService.selectSysLabel(id);
	}
	@Override
	public List<LabelItem> selectDefinedLabel(Integer id) {
		return labelService.selectDefinedLabel(id);
	}
	@Override
	public LabelItem selectLabelItemIsExist(Integer roleId, String itemname,
			Integer id, Integer docId, String allSharedOrg) {
		return labelService.selectLabelItemIsExist(roleId, itemname, id, docId, allSharedOrg);
	}
	
	@Override
	public Page<LabelItem> selectLabelByPage(Page<LabelItem> page,
			LabelItem model) {
		labelService.selectLabelByPage(page, model);
		return page;
	}
	@Override
	public Page<LabelTag> selectByLabelTagPage(Page<LabelTag> page,
			LabelTag pojo) {
		labelService.selectByLabelTagPage(page, pojo);
		return page;
	}

}
