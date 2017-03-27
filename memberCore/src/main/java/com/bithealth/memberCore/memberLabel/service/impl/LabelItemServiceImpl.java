package com.bithealth.memberCore.memberLabel.service.impl;

import javax.annotation.Resource; 

import org.springframework.stereotype.Service; 

import com.bithealth.sdk.core.generic.GenericBaseDao;
import com.bithealth.sdk.core.generic.GenericBaseServiceImpl; 
import com.bithealth.memberCore.memberLabel.dao.LabelItemMapper;
import com.bithealth.memberCore.memberLabel.model.LabelItem; 
import com.bithealth.memberCore.memberLabel.model.LabelItemExample;
import com.bithealth.memberCore.memberLabel.service.LabelItemService;

@Service("labelitemService") 
public class LabelItemServiceImpl extends GenericBaseServiceImpl<LabelItem,LabelItemExample,
      Integer> implements LabelItemService {
          
    @Resource LabelItemMapper labelitemMapper;
        
    @Override
    public GenericBaseDao<LabelItem,LabelItemExample,  Integer > getDao() {
        return labelitemMapper;
    }

	@Override
	public LabelItem selectLabelItem(Integer roleId, String itemname,
			Integer id, Integer docId, String allSharedOrg) {
		return labelitemMapper.selectLabelItem(roleId, itemname, id, docId, allSharedOrg);
	}

}
