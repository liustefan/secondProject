/**
 * @PackageName:      com.bithealth.member
 * @FileName:     MemberController.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      liuhm
 * @version      V1.0  
 * @Createdate:  2016年7月22日 上午11:11:51  
 * 
 */
package com.bithealth.member;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSON;
import com.bithealth.Message;
import com.bithealth.doctorCore.doctor.service.DoctorService;
import com.bithealth.fileCore.constant.FileTypeEnum;
import com.bithealth.fileCore.facade.service.FileManagerServiceFacade;
import com.bithealth.fileCore.model.FileConfigModel;
import com.bithealth.memberCore.enmu.EducationStatus;
import com.bithealth.memberCore.enmu.FamilyRoleEnmu;
import com.bithealth.memberCore.enmu.MarryStatusEnum;
import com.bithealth.memberCore.enmu.MemberSource;
import com.bithealth.memberCore.enmu.OccupationEnmu;
import com.bithealth.memberCore.enmu.RelationEnmu;
import com.bithealth.memberCore.enmu.TimeSegEnmu;
import com.bithealth.memberCore.enmu.UseTag;
import com.bithealth.memberCore.facede.service.MemberInterfService;
import com.bithealth.memberCore.group.model.MemberGroup;
import com.bithealth.memberCore.group.service.MemberGroupService;
import com.bithealth.memberCore.member.model.FamilyHistory;
import com.bithealth.memberCore.member.model.MemFamilyCard;
import com.bithealth.memberCore.member.model.Member;
import com.bithealth.memberCore.member.model.MemberExample;
import com.bithealth.memberCore.member.model.MemberExt;
import com.bithealth.memberCore.member.model.SearchCondition;
import com.bithealth.memberCore.member.service.DiseaseService;
import com.bithealth.memberCore.member.service.MemFamilyCardService;
import com.bithealth.memberCore.member.service.MemberAccountService;
import com.bithealth.memberCore.member.service.MemberService;
import com.bithealth.memberCore.member.service.MemberTypeService;
import com.bithealth.memberCore.member.vo.MemberVo;
import com.bithealth.memberCore.memberLabel.enmu.LabelStatus;
import com.bithealth.memberCore.memberLabel.model.LabelItem;
import com.bithealth.memberCore.memberLabel.model.MemberLabelItem;
import com.bithealth.memberCore.memberLabel.service.LabelService;
import com.bithealth.memberCore.memberLabel.service.MemberLabelItemService;
import com.bithealth.memberCore.uc.bean.MemberRet;
import com.bithealth.orgainCore.model.OrgConfig;
import com.bithealth.orgainCore.service.OrgConfigService;
import com.bithealth.orgainCore.service.OrgService;
import com.bithealth.sdk.common.utils.PinYinUtil;
import com.bithealth.sdk.common.utils.StringUtil;
import com.bithealth.sdk.common.utils.TimeUtil;
import com.bithealth.sdk.core.feature.orm.mybatis.Page;
import com.bithealth.sdk.web.controller.BaseSpringController;
import com.bithealth.sdk.web.vo.ShiroUser;
import com.bithealth.util.MemMustItemUtil;

/**
 * 类名称: MemberController  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年7月22日 上午11:11:51 
 * 
 * @author liuhm
 * @version  
 */
@Controller
@RequestMapping(value="/member")
public class MemberController extends BaseSpringController {
	
	@Resource(name="memberService")
	private MemberService memberService;
	
	@Resource(name="memberTypeService")
	private MemberTypeService memberTypeService;
	
	@Resource(name="memberGroupService")
	private MemberGroupService groupService;
	
	@Resource(name="diseaseService")
	private DiseaseService diseaseService;
	
	@Resource(name="memberAccountService")
	private MemberAccountService memberAccountService;
	
	@Resource(name="memberInterfService")
	private MemberInterfService memberInterfService;
	
	@Autowired
	private FileManagerServiceFacade fileManagerServiceFacade;
	
	@Resource(name="orgConfigService")
	private OrgConfigService configService;
	
	@Resource(name="memFamilyCardService")
	private MemFamilyCardService memFamilyCardService;
	
	@Resource(name="doctorService")
	private DoctorService doctorService;
	
	@Autowired
	private MemberLabelItemService memberLabelService;
	
	@Autowired
	private LabelService labelService;
	
	@Resource(name="orgService")
	private OrgService orgService;
	
	@RequestMapping(value="/memberList")
	public String memberList(HttpServletRequest request, SearchCondition<MemberVo> condition, String flag, Page<MemberVo> page) {
        ShiroUser user = getCurentUser();
        condition.setDocId(user.getId());
        condition.setPage(page);
		if("my".equals(flag)) {
			page = memberService.listMyMemberByPage(condition);
		} else if("other".equals(flag)) {
			page = memberService.listOtherMemberByPage(condition);
		} else {
			page = memberService.listAllMemberByPage(condition);
		}
		
		request.setAttribute("page", page);
		request.setAttribute("flag", flag);
		request.setAttribute("condition", condition);
		request.setAttribute("diseases", diseaseService.selectAll_cache());  //疾病
		if("my".equals(flag)) {
			return "/member/myMemberList";
		}
		request.setAttribute("typeList", memberTypeService.selectListByOrg(user.getDept_id(), UseTag.T));
		return "/member/memberList";
	}
	
	@RequestMapping("/selMemFamily")
	public String selMemFamily(HttpServletRequest request, @ModelAttribute("condition")SearchCondition<Member> condition, Page<Member> page) {
		MemberExample example = new MemberExample();
		example.setOrderByClause(" CreateTime DESC");
		MemberExample.Criteria criteria = example.createCriteria();
		criteria.andUsetagEqualTo(UseTag.T.name());
		boolean hasCondition = false;
		if(StringUtil.isNotEmpty(condition.getIdcard())) {
			hasCondition = true;
			criteria.andIdcardLike(condition.getIdcard() + "%");
		}
		if(StringUtil.isNotEmpty(condition.getMemName())) {
			hasCondition = true;
			criteria.andMemnameLike(condition.getMemName() + "%");
		}
		if(StringUtil.isNotEmpty(condition.getTel())) {
			hasCondition = true;
			criteria.andTelLike(condition.getTel() + "%");
		}
		if(StringUtil.isNotEmpty(condition.getCreTimeStart())) {
			try {
				hasCondition = true;
				criteria.andCreatetimeGreaterThanOrEqualTo(TimeUtil.parseDatetime(condition.getCreTimeStart() + " 00:00:00", "yyyy-MM-dd HH:mm:ss"));
			} catch (ParseException e) {}
		}
		if(StringUtil.isNotEmpty(condition.getCreTimeEnd())) {
			try {
				hasCondition = true;
				criteria.andCreatetimeLessThanOrEqualTo(TimeUtil.parseDatetime(condition.getCreTimeEnd() + " 23:59:59", "yyyy-MM-dd HH:mm:ss"));
			} catch (ParseException e) {}
		}
		if(hasCondition) {
			List<Member> list = memberService.selectByExampleAndPage(page, example);
			page.setResult(list);
		} else {
			request.setAttribute("message", "请选择查询条件");
		}
		
		request.setAttribute("page", page);
		return "/member/selMemFamily";
	}
	
	@RequestMapping("/{id}/delete")
	@ResponseBody
	public Message deleteMember(String flag, @PathVariable int id) {
		MemberExt member = memberService.selectMemberExtById(id);
		if(member == null) {
			return new Message("会员不存在", true);
		}
		if(!getOperatorAuth(member)) {
			return new Message("会员不被当前医生管理，无权删除", false); 
		}
		List<Member> memberList = new ArrayList<>();
		memberList.add(member);
		try {
			if(memberInterfService.delete(memberList)) {
				return new Message("删除成功", true);
			}
		} catch (Exception e) {
			return new Message(e.getLocalizedMessage(), false);
		}
		return new Message("删除失败", false);
	}
	
	@RequestMapping("/{id}/memberPage")
	public String memberPage(@PathVariable int id, HttpServletRequest request) {
		MemberExt member = memberService.selectMemberExtById(id);
		request.setAttribute("omem", member);
		try {
			request.setAttribute("age", TimeUtil.getAge(member.getBirthdate()));
		} catch (Exception e) {
			logger.info("获取会员年龄出错：" + e.getMessage());
		}
		if(getOperatorAuth(member)) {
			request.setAttribute("flags", "my");
		}
		return "/member/memberPage";
	}
	
	/**
	 * 
	 * @Title:detail 
	 * @Description:会员详细信息. 
	 * @author liuhm
	 * @param id
	 * @param request
	 * @return 
	 * @param 
	 * @throws
	 * @retrun String
	 */
	@RequestMapping("/detail/{id}")
	public String detail(@PathVariable int id, HttpServletRequest request) {
		String url = this.edit(id, request, request.getParameter("flag"));
		MemberExt member = (MemberExt)request.getAttribute("omem");
		List<String> groupNames = new ArrayList<String>();
		List<MemberGroup> groupList = member.getMemberGroupList();
		if(member != null && groupList != null && groupList.size() > 0) {
			for(MemberGroup group : groupList) {
				StringBuilder path = new StringBuilder();
				getGrpPathName(group, path);
				path.insert(0, StringUtil.isEmpty(member.getOrg().getOrgName()) ? "" : member.getOrg().getOrgName());
				groupNames.add(path.toString());
			}
		}
		request.setAttribute("groupNames", groupNames);
		request.setAttribute("isEdit", false);
		if(StringUtil.isNotEmpty(request.getParameter("resource"))) {
			request.setAttribute("resource", request.getParameter("resource"));
		}
		return url;
	}
	
	/**
	 * 
	 * @Title:edit 
	 * @Description:会员修改页面. 
	 * @author liuhm
	 * @param id
	 * @param request
	 * @return 
	 * @param 
	 * @throws
	 * @retrun String
	 */
	@RequestMapping("/edit/{id}")
	public String edit(@PathVariable int id, HttpServletRequest request, String flag) {
		MemberExt member = null;
		if(id == 0) {
			member = new MemberExt();
			member.setCreatetime(new Date());
			member.setDocid(getCurentUser().getId());
			member.setDocname(getCurentUser().getRealName());
			member.setFamilyHistoryList(new ArrayList<FamilyHistory>());
		} else {
			member = memberService.selectMemberExtById(id);
			List<MemFamilyCard> cardList = memFamilyCardService.selectByMemberAndRole(member.getMemberid(), FamilyRoleEnmu.Self);
			member.setOmemCardNos(cardList);
			member.setOmemFamilyCards(memFamilyCardService.selectMemCardExtNotMy(id));
			setLabelItem(member);
		}
		return toEdit(request, flag, member);
	}
	
	private String toEdit(HttpServletRequest request, String flag, MemberExt member){
		request.setAttribute("isEdit", true);
		if(member.getMemberid() != null && member.getMemberid() > 0) {
			boolean isMy = doctorService.isMyMember(getCurentUser().getId(), member.getMemberid(), getCurentUser().getDept_id());
			request.setAttribute("isMy", isMy);
		}
		if(member.getOmemCardNos() != null && member.getOmemCardNos().size() > 0){
			request.setAttribute("cardNos", JSON.toJSONString(member.getOmemCardNos()));
		}
		if(member.getOmemFamilyCards() != null && member.getOmemFamilyCards().size() > 0) {
			request.setAttribute("familyMembers", JSON.toJSONString(member.getOmemFamilyCards()));
		}
		request.setAttribute("omem", member);
		request.setAttribute("contacts", JSON.toJSONString(member.getLinkmanList()));
		request.setAttribute("roles", JSON.toJSONString(FamilyRoleEnmu.allValues()));
		request.setAttribute("orgsConfig", JSON.toJSONString(configService.selectByOrgId(member.getOrgid() == null? getCurentUser().getDept_id() : member.getOrgid())));
		request.setAttribute("flag", flag);
		request.setAttribute("typeList", memberTypeService.selectListByOrg(getCurentUser().getDept_id(), UseTag.T));
		request.setAttribute("marryStatus", MarryStatusEnum.values()); //婚姻状况
		request.setAttribute("educationStatus", EducationStatus.values());  //教育程度
		request.setAttribute("accupations", OccupationEnmu.values());  //学历
		request.setAttribute("diseases", diseaseService.selectAll_cache());  //疾病
		request.setAttribute("segments", TimeSegEnmu.values());  //时段
		request.setAttribute("memGrpid", member.getMemberGroupIds());
		request.setAttribute("relationList", RelationEnmu.relations());
		if(request.getAttribute("msg") != null) {
			request.setAttribute("msg", request.getAttribute("msg"));
		}
		return "/member/edit";
	}
	
	/**
	 * 
	 * @Title:add 
	 * @Description:会员新增修改. 
	 * @author liuhm
	 * @param member
	 * @return 
	 * @param 
	 * @throws
	 * @retrun String
	 */
	@RequestMapping("/add")
	public String add(MemberExt member, HttpServletRequest request, MultipartFile fieldName) {
		String cards = memFamilyCardService.existMemberCard(member.getOmemCardNos(), member.getMemberid());
		if(StringUtil.isNotEmpty(cards)) {
			request.setAttribute("msg", "已经存在智能卡号：" + cards);
			return toEdit(request, request.getParameter("flag"), member);
		}
		List<FamilyHistory> familyHistroy = JSON.parseArray(request.getParameter("fmlHistories"), FamilyHistory.class);
		member.setFamilyHistoryList(familyHistroy);
		if(StringUtil.isEmpty(member.getGender())) {
			member.setGender("3");
		}
		ShiroUser user = getCurentUser();
		OrgConfig config = configService.selectByOrgId(user.getDept_id());
		String msg = "";
		if(config != null ) {
			msg = MemMustItemUtil.must(config.settings(), member);
			if(StringUtil.isNotEmpty(msg)) {
				request.setAttribute("msg", msg);
				return toEdit(request, request.getParameter("flag"), member);
			}
		}
		
		String fileId = this.uploadFile(fieldName);
		if(fileId != null) {
			member.setHeadaddress(fileId);
		}
		String memGrpid = request.getParameter("memGrpid");
		member.setMemberGroupList(getGroup(memGrpid));
		if(StringUtil.isNotEmpty(member.getMemname()) && StringUtil.isEmpty(member.getMemNameCode())) {
			member.setMemNameCode(PinYinUtil.getPinYinHeadChar(member.getMemname()));
		}
		
		memberLabelItems(member);  //设置会员标签
		
		if(member.getMemberid() != null && member.getMemberid() != 0) {
			msg = memberInterfService.updateMember(member);
		} else {
			member.setSource(MemberSource.WEB.getCode());
			member.setMemberGUID(StringUtil.UUID());
			member.setDocid(user.getId());
			member.setDocname(user.getRealName());
			member.setOrgid(user.getDept_id());
			MemberRet reponse = memberInterfService.regist(member);
			if(!(reponse != null && reponse.getCode() == MemberRet.SUCCESS)) {
				if(reponse == null) {
				 	   msg = "保存失败";
				    } else {
					   msg = reponse.getMessage();
				    }
					member.setMemberid(null);
					member.setAccountList(null);
					member.setHeadaddress(null);
			}
		}
		if("6".equals(request.getParameter("flag")) || StringUtil.isNotEmpty(msg)) {  //从会员详情进入修改，跳转至详情页面
			request.setAttribute("msg", msg);
			String flag = request.getParameter("flag");
			String url = null;
			if("6".equals(flag)) {
				if(StringUtil.isEmpty(msg)) {
					return "redirect:/member/detail/" + member.getMemberid() + "?flag=6";
				}
				url = toEdit(request, flag, member);
				request.setAttribute("isEdit", false);
				
			} else {
				url = toEdit(request, flag, member);
			}
			return url;
		}
		
		return "redirect:../member/memberList?flag=" + request.getParameter("flag");
	}
	
	@ResponseBody
	@RequestMapping("/addMemFamily")
	public Message addMemFamily(MemberExt member, HttpServletRequest request) {
		OrgConfig config = configService.selectByOrgId(getCurentUser().getDept_id());
		if(config != null ) {
			String msg = MemMustItemUtil.must(config.settings(), member);
			if(StringUtil.isNotEmpty(msg)) {
				return new Message(msg, false);
			}
		}
		if(StringUtil.isNotEmpty(member.getMemname())) {
			member.setMemNameCode(PinYinUtil.getPinYinHeadChar(member.getMemname()));
		}
		this.add(member, request, null); //家庭成员注册
		Object msg = request.getAttribute("msg");
		if(msg != null && StringUtil.isNotEmpty(String.valueOf(msg))) {
			return new Message(msg.toString(), false);
		}
		return new Message(member.getMemberid()+"", true);
	}
	
	@RequestMapping("/checkUnique")
	@ResponseBody
	public Message checkUnique(Member member) {
		Member mem = memberService.selectByIdcard(member.getIdcard());
		if(mem == null) {
			return new Message("身份证不重复", true);
		}
		if(member.getMemberid() != null && member.getMemberid().intValue() != mem.getMemberid().intValue()) {
			return new Message(null, "身份证重复", false, "idcard");
		}
		return new Message("身份证不重复", true);
		
	}
	
	@RequestMapping("/memberByIdcard")
	@ResponseBody
	public Message memberByIdcard(String idCard) {
		Member omem = memberService.selectByIdcard(idCard);
		if(omem == null) {
			return new Message(false);
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("idCard", omem.getIdcard());
		map.put("phone", omem.getTel());
		map.put("gender", omem.getGender());
		map.put("birthDate", TimeUtil.formatDate(omem.getBirthdate()));
		map.put("name", omem.getMemname());
		map.put("familyMemberId", omem.getMemberid());
		map.put("memId", omem.getMemid());
		map.put("memTypeName", omem.getMemberType().getMemname());
		return new Message(true, map);
	}
	
	private void getGrpPathName(MemberGroup group, StringBuilder path) {
		path.insert(0, "->>" + group.getMemgrpname());
		if(group.getParentGroup() != null) {
			getGrpPathName(group.getParentGroup(), path);
		}
	}
	
	private List<MemberGroup> getGroup(String ids) {
		if(StringUtil.isNotEmpty(ids)) {
			List<MemberGroup> list = new ArrayList<MemberGroup>();
			String[] arr = ids.split(",");
			for(String id : arr) {
				if(StringUtil.isNotEmpty(id)) {
					MemberGroup group = new MemberGroup();
					group.setMemgrpid(Integer.parseInt(id));
					list.add(group);
				}
			}
			return list;
		}
		return null;
	}
	
	private boolean getOperatorAuth(MemberExt member){
		ShiroUser user = getCurentUser();
		if(user.getDept_id().intValue() != member.getOrgid().intValue()) {
			return false;
		}
		List<MemberGroup> groupList = member.getMemberGroupList();
		if(groupList != null && groupList.size() > 0) {
			List<MemberGroup> docList = groupService.selectByDoctorAndOrg(user.getId(), user.getDept_id());
			if(docList == null || docList.size() == 0) {
				return false;
			}
			for(MemberGroup doc : docList) {
				for(MemberGroup mem : groupList) {
					if(doc.getMemgrpid().intValue() == mem.getMemgrpid().intValue()) {
						return true;
					}
				}
			}
		}
		return false;
	}
	
	private String uploadFile(MultipartFile file) {
		if(file == null || file.getSize() == 0) {
			return null;
		}
		String originalFilename = file.getOriginalFilename();
		String fileFormat = originalFilename.split("\\.")[1];
		FileTypeEnum typeEnum = FileTypeEnum.findEnumByFormat(fileFormat);
		if(typeEnum == null){ //校验是否为可上传的文件类型
			logger.info("文件类型不匹配！");
			return null;
		}
		
		FileConfigModel model = new FileConfigModel();
		model.setTypeEnum(typeEnum);
		model.setNeedCompress(false);
		InputStream ins = null;
		try {
			ins = file.getInputStream();
			//文件上传
			return fileManagerServiceFacade.uploadFile(ins, model);
		} catch (Exception e) {
			return null;
		} finally{
			if(ins != null) {
				try {
					ins.close();
				} catch (IOException e) {}
			}
		}
	}
	private List<MemberLabelItem> setLabelItem(MemberExt member) {
		String orgIds = orgService.selectAllSharedOrg(getCurentUser().getDept_id(), true);
		List<LabelItem> items = labelService.selectByDoc(getCurentUser().getId(), orgIds);
		List<LabelItem> itemList = memberLabelService.selectMemberLabelItems(LabelStatus.EFFECT, member.getMemberid(), items);
		if(itemList == null || itemList.size() == 0) {
			return null;
		}
		String labelItemIds = null;
		String labelItemNames = null;
		List<MemberLabelItem> memberItemList = new ArrayList<MemberLabelItem>();
		for(LabelItem item : itemList) {
			if(StringUtil.isEmpty(labelItemIds)) {
				labelItemIds = item.getLitemid() + "";
			} else {
				labelItemIds += "," + item.getLitemid();
			}
			if(StringUtil.isEmpty(labelItemNames)) {
				labelItemNames = item.getItemname();
			} else {
				labelItemNames += ";" + item.getItemname();
			}
			memberItemList.add(new MemberLabelItem(member.getMemberid(), item.getLitemid()));
		}
		member.setLabelItemIds(labelItemIds);
		member.setLabelItemNames(labelItemNames);
		return memberItemList;
	}
	
	private void memberLabelItems(MemberExt member) {
		List<MemberLabelItem> itemList = new ArrayList<MemberLabelItem>();
		if(member.getMemberid() == null) {
			if(StringUtil.isEmpty(member.getLabelItemIds())) {
				return;
			}
			String[] ids = member.getLabelItemIds().split(",");
			for(String id : ids) {
				itemList.add(new MemberLabelItem(null, Integer.parseInt(id)));
			}
		} else {
			if(StringUtil.isNotEmpty(member.getLabelItemIds())) {
				String[] ids = member.getLabelItemIds().split(",");
				for(String id : ids) {
					itemList.add(new MemberLabelItem(member.getMemberid(), Integer.parseInt(id)));
				}
			}
		}
		member.setAddLabelItems(itemList);
		getLableInDB(member);
	}
	
	private void getLableInDB(MemberExt member) {
		List<MemberLabelItem> addList = member.getAddLabelItems();
		String ids = member.getLabelItemIds();
		String names = member.getLabelItemNames();
		List<MemberLabelItem> items = setLabelItem(member);
		if(addList == null || addList.size() == 0) {
			member.setRemoveLabelItems(items);
			return;
		}
		
		if(items == null || items.isEmpty()) {
			return;
		}
		for(Iterator<MemberLabelItem> it = items.iterator(); it.hasNext();) {
			MemberLabelItem remItem = it.next();
			for(Iterator<MemberLabelItem> add = addList.iterator(); add.hasNext();) {
				MemberLabelItem addItem = add.next();
				if(remItem.getLItemID().intValue() == addItem.getLItemID().intValue()) {
					add.remove();
					it.remove();
				}
			}
		}
		member.setRemoveLabelItems(items);
		member.setLabelItemIds(ids);
		member.setLabelItemNames(names);
	}
}
