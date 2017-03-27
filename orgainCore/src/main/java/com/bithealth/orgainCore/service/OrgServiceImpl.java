/**
 * @PackageName:      com.bithealth.orgainCore.service
 * @FileName:     OrgServiceImpl.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      liuhm
 * @version      V1.0  
 * @Createdate:  2016年7月12日 下午3:31:21  
 * 
 */
package com.bithealth.orgainCore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bithealth.orgainCore.dao.OrgMapper;
import com.bithealth.orgainCore.enmu.EndTag;
import com.bithealth.orgainCore.model.Org;
import com.bithealth.orgainCore.model.OrgExample;
import com.bithealth.sdk.common.utils.StringUtil;
import com.bithealth.sdk.core.exception.BusinessException;
import com.bithealth.sdk.core.generic.GenericBaseDao;
import com.bithealth.sdk.core.generic.GenericBaseServiceImpl;

/**
 * 类名称: OrgServiceImpl  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年7月12日 下午3:31:21 
 * 
 * @author liuhm
 * @version  
 */
@Service("orgService")
public class OrgServiceImpl extends GenericBaseServiceImpl<Org, OrgExample, Integer> implements OrgService {
	
	@Autowired
	private OrgMapper mapper;
	
	@Override
	public GenericBaseDao<Org, OrgExample, Integer> getDao() {
		return mapper;
	}

	@Override
	public int insert(Org model) throws BusinessException {
		Org org = selectByName(model.getOrgName(), model.getSuperior());
		if(org != null) {
			throw new BusinessException("同级组织下重名");
		}
		Org parent = mapper.selectByPrimaryKey(model.getSuperior());
		String path = ",0,";
		if(parent == null) {
			model.setSuperior(0);
		}
		/**
		 * 2.0.5版本后调整为可以任意设置对外服务机构
		 */
//		else if(EndTag.Y.name().equals(parent.getIsExternalService())){
//			throw new BusinessException("末节组织下禁止添加组织");
//		}
		else {
			path = parent.getPath();
		}
		model.setPath(path);
		int count = super.insert(model);
		if(count  > 0) {
			model.setPath(path + model.getOrgId() + ",");
			mapper.updateByPrimaryKey(model);
		}
		return count;
	}

	@Override
	public int update(Org model) throws BusinessException {
		Org org = selectByName(model.getOrgName(), model.getSuperior());
		if(org != null && org.getOrgId().intValue() != model.getOrgId().intValue()) {
			throw new BusinessException("同级组织下重名");
		}
		org = mapper.selectByPrimaryKey(model.getOrgId());
		if(org.getHasDoctor() && !EndTag.Y.name().equals(model.getIsExternalService())) {
			throw new BusinessException("组织下已存在医生，只能设置为对外服务");
		}
		return super.updateByPrimaryKey(model);
	}

	@Override
	public int delete(Integer id) throws BusinessException {
		Org org = mapper.selectByPrimaryKey(id);
		if(org == null) {
			return 1;
		}
		if(org.getChildren() != null && org.getChildren().size() > 0) {
			throw new BusinessException("存在子节点不允许删除");
		}
		if(org.getHasDoctor()) {
			throw new BusinessException("该组织下存在医生，无法删除");
		}
		return super.delete(id);
	}

	@Override
	@Deprecated
	public int deleteByExample(OrgExample example) {
		return 0;
	}
	
	
	@Override
	public int getMaxOrger(int parentId) {
		OrgExample example = new OrgExample();
		example.setOrderByClause(" `order` DESC");
		OrgExample.Criteria criteria = example.createCriteria();
		criteria.andSuperiorEqualTo(parentId);
		List<Org> list = mapper.selectByExample(example);
		if(list == null || list.size() == 0) {
			return 10;
		}
		Integer order = list.get(0).getOrder();
		return order == null ? 0 : order.intValue() + 10;
	}
	
	@Override
	public Org selectExistByName(String orgName, int parentId) {
		return selectByName(orgName, parentId);
	}

	@Override
	public Org selectExistByCode(String code) {
		OrgExample example = new OrgExample();
		example.createCriteria().andOrgCodeEqualTo(code);
		List<Org> list = mapper.selectByExample(example);
		return (list == null || list.isEmpty()) ? null : list.get(0);
	}

	@Override
	public String selectAllSharedOrg(int orgId, boolean isCurrent) {
		String path = mapper.selectPathById(orgId);
		path = path.substring(3, path.length()-1);
		StringBuilder sb = new StringBuilder();
		if(StringUtil.isNotEmpty(path)) {
			String[] parents = path.split(",");  //未过滤的父节点路径
			String sharePath = mapper.selectShareOrg(path);  //共享父节点路径，“,”分割降序排列
			if(StringUtil.isNotEmpty(sharePath)) {
				String[] shares = sharePath.split(",");
				int index = parents.length -1;
				for(int i = 0; i < shares.length; i++) {
					if(!shares[i].equals(parents[index])) {
						break;
					}
					if(sb.length() == 0) {
						sb.append(shares[i]);
					} else {
						sb.insert(0, shares[i] + ",");
					}
					index--;
				}
			}
		}
		if(sb.length() > 0) {  //共享节点链路中最上级节点的父节点
			String parentSub = path.substring(0, path.indexOf(sb.toString()));
			if(StringUtil.isNotEmpty(parentSub)) {
				parentSub = parentSub.substring(0, parentSub.length()-1);
				String[] subs = parentSub.split(",");
				sb.insert(0, subs[subs.length-1] + ",");
			}
		}
		
		if(isCurrent) {
			if(sb.length() == 0) {
				sb.append(String.valueOf(orgId));
			}
		}
		return sb.toString();
	}

	private Org selectByName(String name, Integer parentId) {
		OrgExample example = new OrgExample();
		OrgExample.Criteria criteria = example.createCriteria();
		criteria.andOrgNameEqualTo(name);
		criteria.andSuperiorEqualTo(parentId);
		List<Org> list = mapper.selectByExample(example);
		return (list == null || list.isEmpty()) ? null : list.get(0);
	}

}
