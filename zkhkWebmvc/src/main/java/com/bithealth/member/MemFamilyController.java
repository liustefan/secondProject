package com.bithealth.member;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bithealth.Message;
import com.bithealth.memberCore.member.model.MemFamilyCard;
import com.bithealth.memberCore.member.service.MemFamilyCardService;
import com.bithealth.sdk.common.utils.StringUtil;
import com.bithealth.sdk.web.controller.BaseSpringController;

/**
 * 
 * 类名称: MemFamilyController  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年8月15日 下午2:48:31 
 * 
 * @author liuhm
 * @version
 */
@Controller
@RequestMapping("/family")
public class MemFamilyController extends BaseSpringController {
	
	@Resource(name="memFamilyCardService")
	private MemFamilyCardService cardService;
	
	@RequestMapping("/checkCardNoExist")
	@ResponseBody
	public Message checkCardNoExist(Integer memberid, String cardNos) {
		List<MemFamilyCard> list = cardService.selectExistsCard(memberid, StringUtil.getList(cardNos, ","));
		return new Message(null, true, list);
	}

}
