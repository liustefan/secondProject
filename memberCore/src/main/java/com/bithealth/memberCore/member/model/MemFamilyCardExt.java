package com.bithealth.memberCore.member.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bithealth.sdk.common.utils.StringUtil;

public class MemFamilyCardExt extends MemFamilyCard {

	private static final long serialVersionUID = 6440411975492792610L;
	
	private String cardNosStr;
	private List<Map<String, Object>> cardNos = new ArrayList<Map<String,Object>>();
    public List<Map<String, Object>> getCardNos() {
		if(cardNos.size() == 0 && StringUtil.isNotEmpty(this.cardNosStr)){
			String[] cns = this.cardNosStr.split("；");
			Map<String, Object> map;
			for(String cn : cns){
				if(StringUtil.isNotEmpty(cn)){
					map = new HashMap<String, Object>();
					map.put("cardNo", cn);
					map.put("checked", true);
					cardNos.add(map);
				}
			}
		}
		return cardNos;
	}

	public String getCardNosStr() {
		return cardNosStr;
	}

	public void setCardNosStr(String cardNosStr) {
		this.cardNosStr = cardNosStr;
	}
}
