/**
 * @PackageName:      com.bithealth.memberCore.member.service.impl
 * @FileName:     MemFamilyCardServiceImpl.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      liuhm
 * @version      V1.0  
 * @Createdate:  2016年8月12日 下午4:00:51  
 * 
 */
package com.bithealth.memberCore.member.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bithealth.memberCore.enmu.FamilyRoleEnmu;
import com.bithealth.memberCore.member.dao.MemFamilyCardMapper;
import com.bithealth.memberCore.member.model.MemFamilyCard;
import com.bithealth.memberCore.member.model.MemFamilyCardExample;
import com.bithealth.memberCore.member.model.MemFamilyCardExt;
import com.bithealth.memberCore.member.service.MemFamilyCardService;
import com.bithealth.sdk.common.utils.StringUtil;
import com.bithealth.sdk.core.generic.GenericBaseDao;
import com.bithealth.sdk.core.generic.GenericBaseServiceImpl;
import com.bithealth.sdk.web.beanutils.BeanUtils;

/**
 * 类名称: MemFamilyCardServiceImpl  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年8月12日 下午4:00:51 
 * 
 * @author liuhm
 * @version  
 */
@Service("memFamilyCardService")
public class MemFamilyCardServiceImpl extends GenericBaseServiceImpl<MemFamilyCard, MemFamilyCardExample, Integer> implements MemFamilyCardService {

	@Autowired
	private MemFamilyCardMapper mapper;
	
	@Override
	public GenericBaseDao<MemFamilyCard, MemFamilyCardExample, Integer> getDao() {
		return mapper;
	}

	@Override
	public List<MemFamilyCard> selectByMemberAndRole(Integer memberId, FamilyRoleEnmu role) {
		MemFamilyCardExample example = new MemFamilyCardExample();
		MemFamilyCardExample.Criteria criteria = example.createCriteria();
		criteria.andMemberidEqualTo(memberId);
		if(role != null) {
			criteria.andRoleEqualTo(role.getRole().byteValue());
		}
		return mapper.selectByExample(example);
	}

	@Override
	public List<MemFamilyCardExt> selectMemCardExtNotMy(Integer memberId) {
		MemFamilyCardExample example = new MemFamilyCardExample();
		example.createCriteria().andRoleNotEqualTo(FamilyRoleEnmu.Self.getRole().byteValue()).andMemberidEqualTo(memberId);
		return mapper.selectMemCardExtByExample(example);
	}

	@Override
	public List<MemFamilyCard> selectExistsCard(Integer memberId, List<String> cardNos) {
		MemFamilyCardExample example = new MemFamilyCardExample();
		MemFamilyCardExample.Criteria c = example.createCriteria();
		if(memberId != null && memberId > 0) {
			c.andMemberidNotEqualTo(memberId);
		}
		c.andCardNoIn(cardNos);
		return mapper.selectByExample(example);
	}
	
	/**
	 * 
	 * @Title:deleteByMember 
	 * @Description:删除会员智能卡号. 
	 * @author liuhm
	 * @param memberId
	 * @param dbList
	 * @return 
	 * @param 
	 * @throws
	 * @retrun int
	 */
	private int deleteByMember(Integer memberId, List<MemFamilyCard> dbList, boolean self) {
		MemFamilyCardExample example = new MemFamilyCardExample();
		MemFamilyCardExample.Criteria c = example.createCriteria().andMemberidEqualTo(memberId);
		if(self) {
			c.andRoleEqualTo(FamilyRoleEnmu.Self.getRole().byteValue());
		} else {
			c.andRoleNotEqualTo(FamilyRoleEnmu.Self.getRole().byteValue());
		}
		
		if(dbList != null && dbList.size() > 0) {
			List<String> cardList = new ArrayList<String>();
			for(MemFamilyCard card : dbList) {
				cardList.add(card.getCardNo());
			}
			c.andCardNoIn(cardList);
		}
		return mapper.deleteByExample(example);
	}
	
	@Override
	public int insertMemberCard(List<MemFamilyCard> cardList, Integer memberId) {
		List<MemFamilyCard> dbList = this.selectFamilyCard(memberId, true);
		if(cardList == null || cardList.size() == 0) {
			return deleteByMember(memberId, null, true);
		}
		
		for(MemFamilyCard card : cardList) {
			card.setFamilyMemberid(memberId);
			card.setMemberid(memberId);
			card.setRole(FamilyRoleEnmu.Self.getRole().byteValue());
		}
		
		if(dbList == null || dbList.isEmpty()) {
			return mapper.insertBatch(cardList);
		}
		
		memFamilyCard(dbList, cardList, true);
		
		//需要删除的智能卡号集合
		if(dbList.size() > 0) {
			this.deleteByMember(memberId, dbList, true);
		}
		
		if(!cardList.isEmpty()) {
			mapper.insertBatch(cardList);
		}
		return 1;
	}
	
	@Override
	public int insertMemFamily(List<MemFamilyCardExt> cardList, Integer memberId) {
		List<MemFamilyCard> dbList = selectFamilyCard(memberId, false);
		if(cardList == null || cardList.size() == 0) {
			return deleteByMember(memberId, null, false);
		}
		
		List<MemFamilyCard> ext = new ArrayList<MemFamilyCard>();
		for(Iterator<MemFamilyCardExt> it = cardList.iterator(); it.hasNext();) {
			MemFamilyCardExt card = it.next();
			card.setMemberid(memberId);
			if(StringUtil.isEmpty(card.getCardNosStr())) { //家庭成员没有关联智能卡号
				ext.add(card);
				continue;
			}
			String[] cards = card.getCardNosStr().split("；");
			for(String cardNo : cards) {
				MemFamilyCard family = (MemFamilyCardExt)BeanUtils.cloneBean(card);
				if(StringUtil.isNotEmpty(cardNo)) {
					family.setCardNo(cardNo);
				}
				ext.add(family);
			}
	   }
		
	  if(dbList == null || dbList.isEmpty()) {
		   return mapper.insertBatch(ext);
	   }
		
	  memFamilyCard(dbList, ext, false);  // dbList需要删除的， ext需要新增的
	  
	  deleteFamily(dbList);
	  
	  if(!ext.isEmpty()) {
		  mapper.insertBatch(ext);
	  }
	  return 0;
	}
	
	private void memFamilyCard(List<MemFamilyCard> dbList, List<MemFamilyCard> cardList, boolean self){
		for(Iterator<MemFamilyCard> it = cardList.iterator(); it.hasNext();) {
			MemFamilyCard card = it.next();
			for(Iterator<MemFamilyCard> dbIt = dbList.iterator(); dbIt.hasNext();) {
				MemFamilyCard db = dbIt.next();
				if(self) {
					if(StringUtil.isNotEmpty(card.getCardNo()) && card.getCardNo().equals(db.getCardNo())) {//智能卡号存在，不作操作，从集合中移除，dbList剩下的就是需要删除的，cardList剩下的就是需要新增的卡号
						dbIt.remove();
						it.remove();
					}
				} else {
					if(StringUtil.isNotEmpty(db.getCardNo()) && db.getCardNo().equals(card.getCardNo()) 
							&& db.getFamilyMemberid().intValue() == card.getFamilyMemberid().intValue()
							&& db.getRole().byteValue() == card.getRole().byteValue()) {
						if(db.getRole().intValue() == FamilyRoleEnmu.Other.getRole().intValue()){
							if(db.getRoleName().equals(card.getRoleName().trim())) {
								it.remove();
								dbIt.remove();
							}
						} else {
							it.remove();
							dbIt.remove();
						}
					}
				}
			}
		}
		
	}
	
	private void deleteFamily(List<MemFamilyCard> cardList) {
		if(cardList != null && cardList.size() > 0) {
			for(MemFamilyCard card : cardList) {
				MemFamilyCardExample example = new MemFamilyCardExample();
				MemFamilyCardExample.Criteria c = example.createCriteria();
				c.andMemberidEqualTo(card.getMemberid())
				.andFamilyMemberidEqualTo(card.getFamilyMemberid()).andRoleEqualTo(card.getRole());
				if(StringUtil.isNotEmpty(card.getCardNo())) {
					c.andCardNoEqualTo(card.getCardNo());
				}
				mapper.deleteByExample(example);
			}
		}
	}
	
	private List<MemFamilyCard> selectFamilyCard(Integer memberId, boolean self) {
		MemFamilyCardExample example = new MemFamilyCardExample();
		MemFamilyCardExample.Criteria c = example.createCriteria();
		if(self) {
			c.andRoleEqualTo(FamilyRoleEnmu.Self.getRole().byteValue());
			c.andFamilyMemberidEqualTo(memberId);
		} else {
			c.andRoleNotEqualTo(FamilyRoleEnmu.Self.getRole().byteValue());
			c.andFamilyMemberidNotEqualTo(memberId);
		}
		c.andMemberidEqualTo(memberId);
		return mapper.selectByExample(example);
	}

	@Override
	public String existMemberCard(List<MemFamilyCard> cardList, Integer memberId) {
		if(cardList == null || cardList.size() == 0) {
			return null;
		}
		List<String> list = new ArrayList<String>();
		for(MemFamilyCard card : cardList) {
			if(StringUtil.isEmpty(card.getCardNo())) {
				continue;
			}
			list.add(card.getCardNo());
		}
		MemFamilyCardExample example = new MemFamilyCardExample();
		MemFamilyCardExample.Criteria c = example.createCriteria();
		c.andRoleEqualTo(FamilyRoleEnmu.Self.getRole().byteValue());
		if(!list.isEmpty()) {
			c.andCardNoIn(list);
		}
		if(memberId != null) {
			c.andMemberidNotEqualTo(memberId);
		}
		List<MemFamilyCard> familyList = mapper.selectByExample(example);
		if(familyList == null || familyList.size() == 0) {
			return null;
		}
		String cards = "";
		for(MemFamilyCard card : familyList) {
			cards += card.getCardNo() + ";";
		}
		return cards;
	}

	@Override
	@Deprecated
	public int insert(MemFamilyCard model) {
		return 0;
	}

	@Override
	@Deprecated
	public int delete(Integer id) {
		return 0;
	}

	@Override
	@Deprecated
	public int deleteByExample(MemFamilyCardExample example) {
		return 0;
	}

}
