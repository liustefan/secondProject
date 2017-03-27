/**
 * @PackageName:      com.bithealth.member
 * @FileName:     DataImportController.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      liuhm
 * @version      V1.0  
 * @Createdate:  2016年8月10日 下午4:18:46  
 * 
 */
package com.bithealth.member;

import java.io.File;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.bithealth.Constrants;
import com.bithealth.excel.ExcelUtil;
import com.bithealth.excel.ImportUtil;
import com.bithealth.fileCore.facade.service.FileManagerServiceFacade;
import com.bithealth.member.view.ExcelView;
import com.bithealth.memberCore.enmu.EducationStatus;
import com.bithealth.memberCore.enmu.MarryStatusEnum;
import com.bithealth.memberCore.enmu.OccupationEnmu;
import com.bithealth.memberCore.enmu.UseTag;
import com.bithealth.memberCore.facede.service.MemberImportService;
import com.bithealth.memberCore.facede.service.MemberInterfService;
import com.bithealth.memberCore.member.model.Member;
import com.bithealth.memberCore.member.model.MemberExt;
import com.bithealth.memberCore.member.service.DiseaseService;
import com.bithealth.memberCore.member.service.MemImportLogService;
import com.bithealth.memberCore.member.service.MemberService;
import com.bithealth.orgainCore.model.OrgConfig;
import com.bithealth.orgainCore.service.OrgConfigService;
import com.bithealth.sdk.common.utils.PinYinUtil;
import com.bithealth.sdk.common.utils.StringUtil;
import com.bithealth.sdk.core.feature.orm.mybatis.Page;
import com.bithealth.sdk.web.controller.BaseSpringController;
import com.bithealth.task.DeleteFileTask;
import com.bithealth.task.UpdateMemberTask;
import com.bithealth.util.MemMustItemUtil;

/**
 * 类名称: DataImportController  
 * 功能描述: 数据导入controller  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年8月10日 下午4:18:46 
 * 
 * @author liuhm
 * @version  
 */
@Controller
@RequestMapping("/data")
public class DataImportController extends BaseSpringController {
	
	@Resource(name="diseaseService")
	private DiseaseService diseaseService;
	
	@Resource(name="memberInterfService")
	private MemberInterfService memberInterfService;
	
	@Autowired
	private MemberImportService memberImportService;
	
	@Resource(name="memberService")
	private MemberService memberService;
	
	@Autowired
	private FileManagerServiceFacade fileManagerServiceFacade;
	
	@Autowired
	private DeleteFileTask deleteFileTask;
	
	@Autowired
	private MemImportLogService logService;
	
	@Autowired
	private OrgConfigService configService;
	
	@Autowired
	private UpdateMemberTask task;
	
	@RequestMapping("/memberImport")
	public String importMember(HttpServletRequest request, MultipartFile fieldName) throws Exception {
		String grpIds = request.getParameter("grpIds");
		File file = null;
		if(fieldName != null) {
			String sufix = fieldName.getOriginalFilename().substring(fieldName.getOriginalFilename().lastIndexOf("."));
			file = new File(UUID.randomUUID().toString() + sufix);
			fieldName.transferTo(file);
		}
		
		List<LinkedHashMap<String, String>> dataList = null;
		dataList = ExcelUtil.readExcel(file);
//		try{
//			
//		}finally {
//			if(file != null && file.exists()) {
//				file.delete();
//			}
//		}
		
		if(dataList == null || dataList.size() == 0) {
			request.setAttribute("msg", "文件解析失败");
			return "/member/importResult";
		}
		
		String[] headers = Constrants.HEADER;
		String[] header = new String[]{};
		header = (String[])dataList.get(0).keySet().toArray(header);
		if(!ImportUtil.arrayIsEqual(headers, header)) {
			request.setAttribute("msg", "模板格式不对");
			return "/member/importResult";
		}
		task.readFile(file, grpIds, getCurentUser());
		return "/member/importResult";
	}
	
	@RequestMapping("/registList")
	public String registList(HttpServletRequest request, Page<Map<String, Object>> page, @ModelAttribute("member")Member member) {
		if(member == null) {
			member = new Member();
		} else {
			if(member.getMemname() != null) {
				member.setMemname(member.getMemname().trim());
			}
			if(member.getTel() != null) {
				member.setTel(member.getTel().trim());
			}
			if(member.getIdcard() != null) {
				member.setIdcard(member.getIdcard().trim());
			}
		}
		member.setDocid(getCurentUser().getId());
		page = memberImportService.selectErrorMemberList(page, member);
		request.setAttribute("page", page);
		request.setAttribute("importCount", memberImportService.countMemberInporting(getCurentUser().getId(), UseTag.R));  //正在导入会员数
		return "/member/registList";
	}
	
	@RequestMapping("/delete")
	@ResponseBody
	public String delete(HttpServletRequest request) {
		String uids = request.getParameter("uuid");
		if(StringUtil.isEmpty(uids)) {
			return "未选择要删除的会员";
		}
		return memberImportService.deleteErrorMember(uids.split(","));
	}
	
	@RequestMapping("/deleteAll")
	@ResponseBody
	public String deleteAll() {
		Integer docId = getCurentUser().getId();
		try {
			memberImportService.deleteAll(docId);
		} catch (Exception e) {
			return "删除数据异常";
		}
		return "";
	}
	
	@RequestMapping("/registInfo")
	public String registInfo(Integer memberId, HttpServletRequest request) {
		MemberExt member = memberService.selectMemberExtById(memberId);
		return toEdit(member, request);
	}
	
	private String toEdit(MemberExt member, HttpServletRequest request) {
		request.setAttribute("member", member);
		request.setAttribute("marryStatus", MarryStatusEnum.values()); //婚姻状况
		request.setAttribute("educationStatus", EducationStatus.values());  //教育程度
		request.setAttribute("accupations", OccupationEnmu.values());  //学历
		request.setAttribute("diseases", diseaseService.selectAll_cache());  //疾病
		request.setAttribute("importLog", logService.selectByUUID(member.getMemberGUID(), UseTag.E));
		return "/member/registInfo";
	}
	
	@RequestMapping("/regist")
	public String regist(MemberExt member, HttpServletRequest request) {
		OrgConfig config = configService.selectByOrgId(getCurentUser().getDept_id());
		String msg = null;
		if(config != null) {
			msg = MemMustItemUtil.must(config.settings(), member);
			if(StringUtil.isNotEmpty(msg)) {
				request.setAttribute("msg", msg);
				return toEdit(member, request);
			}
			if(member.getMemid() == null || member.getMemid() == 0) {
				member.setMemid(config.getMemId());
			}
		}
		if(StringUtil.isNotEmpty(member.getMemname())) {
			member.setMemNameCode(PinYinUtil.getPinYinHeadChar(member.getMemname()));
		}
		msg = memberImportService.insert(member);
		if(StringUtil.isNotEmpty(msg)) {
			request.setAttribute("msg", msg);
			return toEdit(member, request);
		}
		return "redirect:/data/registList";
	}
	
	@RequestMapping("/exportData")
	public ModelAndView exportData(Member member, HttpServletRequest request, HttpServletResponse response) {
		if(member == null) {
			member = new Member();
		} else {
			if(member.getMemname() != null) {
				member.setMemname(member.getMemname().trim());
			}
			if(member.getTel() != null) {
				member.setTel(member.getTel().trim());
			}
			if(member.getIdcard() != null) {
				member.setIdcard(member.getIdcard().trim());
			}
		}
		member.setDocid(getCurentUser().getId());
		member.setUsetag(UseTag.E.name());
		List<MemberExt> list = memberService.selectMemberExt(member);
		Map<String, Object> model = new HashMap<String, Object>();  
        model.put("list", list);   
		return new ModelAndView(new ExcelView(), model);
	}
	
}
