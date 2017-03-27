package com.bithealth.memberCore.memberLabel.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bithealth.memberCore.memberLabel.dao.LabelItemMapper;
import com.bithealth.memberCore.memberLabel.dao.LabelTagMapper;
import com.bithealth.memberCore.memberLabel.model.LabelItem;
import com.bithealth.memberCore.memberLabel.model.LabelItemExample;
import com.bithealth.memberCore.memberLabel.model.LabelTag;
import com.bithealth.memberCore.memberLabel.model.LabelTagExample;
import com.bithealth.memberCore.memberLabel.model.LabelTagExample.Criteria;
import com.bithealth.memberCore.memberLabel.service.LabelItemService;
import com.bithealth.memberCore.memberLabel.service.LabelService;
import com.bithealth.memberCore.memberLabel.service.LabelTagService;
import com.bithealth.sdk.core.feature.orm.mybatis.Page;
/**
 * 类名称: LabelServiceImpl  
 * 功能描述: 标签服务接口实现类
 * 日期: 2016年12月05日 
 * 
 * @author 周玉飞
 * @version  
 */
@Service
public class LabelServiceImpl implements LabelService{

	@Autowired
	private LabelTagService labelTagService;
	@Autowired
	private LabelItemService labelItemService;
	@Autowired
	private LabelItemMapper labelItemMapper;
	@Autowired
	private LabelTagMapper labelTagMapper;
	
	@Override
	public int insertLabelClass(LabelTag pojo) {
		int n =0;
		if (pojo!=null) {
			n+=labelTagService.insert(pojo);
		}
		return n;
	}

	@Override
	public int updateLabelClass(LabelTag pojo) {
		int n =0;
		if (pojo!=null && pojo.getLclassid()!=null) {
			n+=labelTagService.update(pojo);
		}
		return n;
	}
	@Override
	public int deleteLabelClass(Integer id) {
		int n =0;
		if (id!=null) {
			n+=labelTagService.delete(id);
		}
		return n;
	}
	
	@Override
	public LabelTag selectById(Integer id) {
		return labelTagService.selectById(id);
	}

	
	@Override
	public List<LabelTag> selectAllLabelClass(LabelTag pojo) {
		return labelTagMapper.selectAllLabelClass(pojo);
	}
	
	@Override
	public List<LabelTag> selectAllLabelClassUserEdit(LabelTag pojo) {
		return labelTagMapper.selectAllLabelClassUserEdit(pojo);
	}
	
	@Override
	public List<LabelTag> selectIsHasLabel(Integer id) {
		return labelTagMapper.selectIsHasLabel(id);
	}


	@Override
	public Page<LabelTag> selectLabelClassPage(Page<LabelTag> page,
			LabelTagExample example) {
		labelTagService.selectByExampleAndPage(page, example);
		return page;
	}

	@Override
	public int insertLabel(LabelItem pojo) {
		int n =0;
		if (pojo!=null) {
			n+= labelItemService.insert(pojo);
		}
		return n;
	}

	@Override
	public int updateLabel(LabelItem pojo) {
		int n =0;
		if (pojo!=null && pojo.getLitemid()!=null) {
			n+= labelItemService.update(pojo);
		}
		return n;
	}

	@Override
	public int updateItemStatus(LabelItem pojo) {
		int n=0;
		if (pojo.getLitemid()!=null && pojo!=null) {
			n+=labelItemMapper.updateItemStatus(pojo);
		}
		return n;
	}

	@Override
	public LabelItem selectLabelById(Integer id) {
		
		return labelItemService.selectById(id);
	}

	@Override
	public Page<LabelItem> selectLabelPage(Page<LabelItem> page,
			LabelItemExample example) {
		labelItemService.selectByExampleAndPage(page, example);
		return page;
	}

	@Override
	public LabelTag selectExistLabelClassName(String name,Integer id) {
		LabelTagExample example = new LabelTagExample();
		Criteria criteria = example.createCriteria();
		criteria.andClassnameEqualTo(name);
		criteria.andLclassidNotEqualTo(id);
		List<LabelTag> list = labelTagMapper.selectByExample(example);
		return (list == null || list.isEmpty()) ? null : list.get(0);
		
	}

	@Override
	public List<LabelItem> selectSysLabel(Integer id) {
		return labelItemMapper.selectSysLabel(id);
	}

	@Override
	public List<LabelItem> selectDefinedLabel(Integer id) {
		return labelItemMapper.selectDefinedLabel(id);
	}
	
	@Override
	public List<LabelItem> selectByDoc(int docId, String orgIds) {
		return labelItemMapper.selectByDocAndOrgs(docId, orgIds);
	}	

	@Override
	public LabelItem selectLabelItemIsExist(Integer roleId, String itemname,
			Integer id, Integer docId, String allSharedOrg) {
		return labelItemService.selectLabelItem(roleId, itemname, id, docId, allSharedOrg);
	}

	@Override
	public Page<LabelItem> selectLabelByPage(Page<LabelItem> page, LabelItem model) {
		labelItemMapper.selectLabelByPage(page, model);
		return page;
	}

	@Override
	public Page<LabelTag> selectByLabelTagPage(Page<LabelTag> page,
			LabelTag pojo) {
		labelTagMapper.selectByLabelTagPage(page, pojo);
		return page;
	}

}
