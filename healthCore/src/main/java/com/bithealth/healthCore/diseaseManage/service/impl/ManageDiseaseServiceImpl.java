package com.bithealth.healthCore.diseaseManage.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource; 

import org.springframework.stereotype.Service; 

import com.bithealth.sdk.core.exception.BusinessException;
import com.bithealth.sdk.core.generic.GenericBaseDao;
import com.bithealth.sdk.core.generic.GenericBaseServiceImpl; 
import com.bithealth.healthCore.diseaseManage.dao.ManageDiseaseMapper;
import com.bithealth.healthCore.diseaseManage.model.ManageDisease; 
import com.bithealth.healthCore.diseaseManage.model.ManageDiseaseExample;
import com.bithealth.healthCore.diseaseManage.service.ManageDiseaseService;
/**
 * 类名称: ManageDiseaseServiceImpl  
 * 功能描述: 疾病管理服务接口实现
 * 日期: 2016年11月29日 
 * 
 * @author 周玉飞
 * @version  
 */
@Service
public class ManageDiseaseServiceImpl extends GenericBaseServiceImpl<ManageDisease,ManageDiseaseExample,
      Integer> implements ManageDiseaseService {
          
    @Resource 
    ManageDiseaseMapper managediseaseMapper;
        
    @Override
    public GenericBaseDao<ManageDisease,ManageDiseaseExample,  Integer > getDao() {
        return managediseaseMapper;
    }

	@Override
	public int insert(ManageDisease pojo) throws BusinessException {
		ManageDisease manageDisease=selectByName(pojo.getDiseasename());
		if (manageDisease!=null) {
			throw new BusinessException("疾病分类名称不可重复");
		}
		ManageDisease parent=managediseaseMapper.selectByPrimaryKey(pojo.getParentid());
		String path = ",0,";
		if (parent==null) {
			pojo.setParentid(0);
		}else {
			path=parent.getPath();
		}
		pojo.setPath(path);
		int count = super.insert(pojo);
		if (count>0) {
			pojo.setPath(path +pojo.getMsdiseaseid()+ ",");
			managediseaseMapper.updateByPrimaryKey(pojo);
		}
		return count;
	}

	@Override
	public int update(ManageDisease pojo) throws BusinessException {
		ManageDisease manageDisease=selectByName(pojo.getDiseasename());
		if (manageDisease !=null && manageDisease.getMsdiseaseid().intValue()!=pojo.getMsdiseaseid().intValue()) {
			throw new BusinessException("疾病分类名称不可重复");
		}
		pojo.setUpdatetime(new Date());
		return super.updateByPrimaryKey(pojo);
		
	}

	@Override
	public int delete(Integer id) throws BusinessException {
		ManageDisease pojo =managediseaseMapper.selectByPrimaryKey(id);
		if (pojo==null) {
			return 1;
		}
		if (pojo.getHasDiseaseModel()) {
			throw new BusinessException("删除当前疾病分类后，此疾病分类与管理方案模板的关联关系会被删除，您确定要删除吗？");
		}
		return  super.delete(id);
		
	}

	@Override
	public ManageDisease selectExistByName(String diseasename) {
		return selectByName(diseasename);
	}

	@Override
	public int getMaxParentId(int parentId) {
		ManageDiseaseExample example = new ManageDiseaseExample();
		example.setOrderByClause(" `SortNo` desc");
		ManageDiseaseExample.Criteria criteria = example.createCriteria();
		criteria.andParentidEqualTo(parentId);
		List<ManageDisease> list = managediseaseMapper.selectByExample(example);
		if(list == null || list.size() == 0) {
			return 10;
		}
		Integer sortNo = list.get(0).getSortno();
		return sortNo == null ? 0 : sortNo.intValue() + 10;

	}

	
	private ManageDisease selectByName(String diseasename){
		ManageDiseaseExample example= new ManageDiseaseExample();
		ManageDiseaseExample.Criteria criteria= example.createCriteria();
		criteria.andDiseasenameEqualTo(diseasename);
		List<ManageDisease> list = managediseaseMapper.selectByExample(example);
		
		return (list == null || list.isEmpty()) ? null : list.get(0);
		
	}

	@Override
	public boolean deleteChildren(Integer id) {
		return managediseaseMapper.deleteChildren(id)>0;
		
	}

}