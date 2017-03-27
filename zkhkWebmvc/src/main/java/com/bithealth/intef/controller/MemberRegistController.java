/**
 * @PackageName:      com.bithealth.intef.controller
 * @FileName:     MemberRegistController.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      liuhm
 * @version      V1.0  
 * @Createdate:  2016年11月1日 下午3:19:23  
 * 
 */
package com.bithealth.intef.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TreeMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bithealth.intef.bean.MemRegBean;
import com.bithealth.intef.bean.MemRegPkg;
import com.bithealth.intef.bean.ResultMsg;
import com.bithealth.memberCore.enmu.EducationStatus;
import com.bithealth.memberCore.enmu.FamilyRoleEnmu;
import com.bithealth.memberCore.enmu.UseTag;
import com.bithealth.memberCore.facede.service.MemberInterfService;
import com.bithealth.memberCore.member.model.MemFamilyCard;
import com.bithealth.memberCore.member.model.Member;
import com.bithealth.memberCore.member.model.MemberExt;
import com.bithealth.memberCore.member.model.PhysicalExamination;
import com.bithealth.memberCore.member.service.MemFamilyCardService;
import com.bithealth.memberCore.member.service.MemberService;
import com.bithealth.memberCore.uc.bean.MemberRet;
import com.bithealth.sdk.common.utils.PinYinUtil;
import com.bithealth.sdk.common.utils.StringUtil;
import com.bithealth.sdk.common.utils.TimeUtil;
import com.bithealth.sdk.web.controller.BaseSpringController;
import com.bithealth.util.SignUtil;

/**
 * 类名称: MemberRegistController  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年11月1日 下午3:19:23 
 * 
 * @author liuhm
 * @version  
 */
@Controller
@RequestMapping(value = "/intef")
public class MemberRegistController extends BaseSpringController {
	
	private static final Logger log = Logger.getLogger(MemberRegistController.class);
	
	@Resource(name="memberInterfService")
	private MemberInterfService memberInterfService;
	
	@Resource(name="memberService")
	private MemberService memberService;
	
	@Resource(name="memFamilyCardService")
	private MemFamilyCardService memFamilyCardService;
	
	
	@RequestMapping(value = "/regist")
	public void regist(HttpServletRequest request, HttpServletResponse response) throws IOException {
		if(!"TV".equalsIgnoreCase(com.bithealth.Constrants.VERSION_TAG)) {
			return;
		}
		String memJson = request.getParameter("params");
		if(StringUtil.isEmpty(memJson)) {
			printOut(new ResultMsg(ResultMsg.FAIL, "注册信息为空"), response);
			return;
		}
		
		String server = request.getRequestURL().toString();
		
		log.info("会员注册参数：" + memJson);
		JSONObject json = (JSONObject) JSON.parse(memJson);
		TreeMap<String, String> tree = new TreeMap<String, String>();
		for(String key :json.keySet()) {
			if(key.equals("fields")) {
				JSONObject field = (JSONObject)json.getJSONObject(key);
				TreeMap<String, String> subMap = new TreeMap<String, String>();
				for(String name :field.keySet()) {
					if("diseasesList".equals(name)) {
						JSONArray arr = field.getJSONArray(name);
						Iterator<Object> it = arr.iterator();
						List<TreeMap<String, String>> list = new ArrayList<TreeMap<String, String>>();
						while(it.hasNext()) {
							TreeMap<String, String> diseas = new TreeMap<String, String>();
							JSONObject obj = (JSONObject)it.next();
							for(String obkKey : obj.keySet()) {
								diseas.put(obkKey, obj.getString(obkKey));
							}
							list.add(diseas);
						}
						subMap.put(name, JSON.toJSONString(list));
					} else {
						subMap.put(name, field.getString(name));
					}
				}
				tree.put(key, JSON.toJSONString(subMap));
			} else {
				tree.put(key, json.get(key).toString());
			}
		}
		log.info(tree);
		String sign = SignUtil.caculateSign(tree, server);
		MemRegPkg memPkg = null;
		try{
			memPkg = JSON.parseObject(memJson, MemRegPkg.class);
		}catch (Exception e) {
			printOut(new ResultMsg(ResultMsg.FAIL, "注册信息参数格式不合法"), response);
			return;
		}
		if(memPkg == null) {
			printOut(new ResultMsg(ResultMsg.FAIL, "注册信息参数格式不合法"), response);
			return;
		}
		
		if(!sign.equals(memPkg.getToken())) {
			printOut(new ResultMsg(ResultMsg.FAIL, "您无权访问"), response);
			return;
		}
		
		MemRegBean fields = memPkg.getFields();
		if(fields == null) {
			printOut(new ResultMsg(ResultMsg.FAIL, "注册会员参数格式不合法"), response);
			return;
		}
		MemberExt mem = new MemberExt();
		try {
			mem = generateOmem(fields);
		} catch (Exception e1) {
			printOut(new ResultMsg(ResultMsg.FAIL, e1.getLocalizedMessage()), response);
			return;
		}
		if(StringUtil.isEmpty(mem.getIdcard())) {
			printOut(new ResultMsg(ResultMsg.FAIL, "身份证号码不能为空"), response);
			return;
		}
		
		Member member = memberService.selectByIdcard(mem.getIdcard());
		if(member == null) {  //新增
			log.info("TV端会员注册");
			mem.setEducationstatus(EducationStatus.NULL.getValue());
			MemberRet reponse = memberInterfService.regist(mem);
			if(reponse != null && reponse.getCode() == MemberRet.SUCCESS) {
				printOut(new ResultMsg(ResultMsg.SUCCESS, "注册成功"), response);
				return;
			}
			String msg = "保存失败";
			if(reponse != null) {
				msg = reponse.getMessage();
		    }
			printOut(new ResultMsg(ResultMsg.FAIL, msg), response);
			return;
		}
		
		if(UseTag.R.name().equals(member.getUsetag())) {
			printOut(new ResultMsg(ResultMsg.FAIL, "会员正在注册审核中"), response);
			return;
		}
		
		//以下会员修改,TV端只修改姓名和手机号，需要同步UC
		log.info("TV端会员修改");
		MemberExt ext = memberService.selectMemberExtById(member.getMemberid());
		ext.setMemname(mem.getMemname());
		ext.setMemNameCode(mem.getMemNameCode());
		ext.setTel(mem.getTel());
		List<MemFamilyCard> cardList = memFamilyCardService.selectByMemberAndRole(member.getMemberid(), FamilyRoleEnmu.Self);
		ext.setOmemCardNos(cardList);
		ext.setOmemFamilyCards(memFamilyCardService.selectMemCardExtNotMy(member.getMemberid()));
		String msg = memberInterfService.updateMember(ext);
		if(StringUtil.isNotEmpty(msg)) {
			printOut(new ResultMsg(ResultMsg.FAIL, "修改失败：" + msg), response);
			return;
		}
		printOut(new ResultMsg(ResultMsg.SUCCESS, "修改成功"), response);
	}
	
	private void printOut(ResultMsg result, HttpServletResponse response) throws IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = null;
		try{
			out = response.getWriter();
			out.write(JSON.toJSONString(result));
			out.flush();
		} finally {
			if(out != null) {
				out.close();
			}
		}
	}
	
	private MemberExt generateOmem(MemRegBean bean) throws Exception {
		MemberExt member = new MemberExt();
		if(bean.getBirthDate() != null && !"".equals(bean.getBirthDate())) {
			try{
				member.setBirthdate(TimeUtil.parseDate(bean.getBirthDate()));
			}catch (Exception e) {
				throw new Exception("出生日期格式有问题：yyyy-MM-dd");
			}
		}
		member.setCreatetime(new Timestamp(System.currentTimeMillis()));
		member.setEmail(bean.getEmail());
		member.setGender("男".equals(bean.getGender()) ? "1" : "2");
		member.setIdcard(bean.getIdCard());
		member.setDiseasesHistoryList(bean.getDiseasesList());
		member.setMemname(bean.getMemName());
		if(StringUtil.isNotEmpty(bean.getMemName())) {
			member.setMemNameCode(PinYinUtil.getPinYinHeadChar(bean.getMemName()));
		}
		if(!StringUtil.isEmpty(bean.getMemId())) {
			member.setMemid(Short.parseShort(bean.getMemId()));
		}
		
		if(!StringUtil.isEmpty(bean.getOrgId())) {
			member.setOrgid(Integer.parseInt(bean.getOrgId()));
		}
		member.setTel(bean.getTel());
		PhysicalExamination mem2 = new PhysicalExamination();
		if(!StringUtil.isEmpty(bean.getBloodH())) {
			mem2.setBloodh(Short.parseShort(bean.getBloodH()));
		}
		
		if(!StringUtil.isEmpty(bean.getHeight())) {
			mem2.setHeight(Integer.parseInt(bean.getHeight()));
		}
		if(!StringUtil.isEmpty(bean.getWeight())) {
			mem2.setWeight(new BigDecimal(bean.getWeight()));
		}
		member.setPhysical(mem2);
		return member;
	}

}
