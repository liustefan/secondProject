package com.bithealth.cmsCore.service.impl;

import javax.annotation.Resource; 
import org.springframework.stereotype.Service; 
import com.bithealth.sdk.core.generic.GenericBaseDao;
import com.bithealth.sdk.core.generic.GenericBaseServiceImpl; 
import com.bithealth.cmsCore.dao.MemberLabelMapper;
import com.bithealth.cmsCore.model.MemberLabel; 
import com.bithealth.cmsCore.model.MemberLabelExample;
import com.bithealth.cmsCore.service.MemberLabelService;

/**
 * 类名称: MemberLabelServiceImpl  
 * 功能描述: 会员标签关系接口实现
 * 日期: 2016年9月2日 下午1:35:26 
 * 
 * @author 周玉飞
 * @version  
 */
@Service("memberlabelService") 
public class MemberLabelServiceImpl extends GenericBaseServiceImpl<MemberLabel,MemberLabelExample,
      Long> implements MemberLabelService {
          
    @Resource MemberLabelMapper memberlabelMapper;
        
    @Override
    public GenericBaseDao<MemberLabel,MemberLabelExample,  Long > getDao() {
        return memberlabelMapper;
    }  
}
