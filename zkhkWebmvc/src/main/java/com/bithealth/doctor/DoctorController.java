 
/**
 * @PackageName:      com.bithealth.doctor.doctor
 * @FileName:     DoctorAction.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      柴仕富
 * @version      V1.0  
 * @Createdate:  2016年7月8日 上午10:08:54  
 * 
 */

package com.bithealth.doctor;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bithealth.Message;
import com.bithealth.doctorCore.docGroup.model.DocToGroup;
import com.bithealth.doctorCore.docGroup.model.DocToGroupExample;
import com.bithealth.doctorCore.docGroup.service.DoctorToGroupService;
import com.bithealth.doctorCore.doctor.model.Doctor;
import com.bithealth.doctorCore.doctor.model.DoctorAccount;
import com.bithealth.doctorCore.doctor.model.DoctorExample;
import com.bithealth.doctorCore.doctor.model.Orol;
import com.bithealth.doctorCore.doctor.model.OrolExample;
import com.bithealth.doctorCore.doctor.service.DoctorAccountService;
import com.bithealth.doctorCore.doctor.service.DoctorService;
import com.bithealth.doctorCore.doctor.service.OrolService;
import com.bithealth.doctorCore.enmu.CertiType;
import com.bithealth.doctorCore.enmu.TagStatus;
import com.bithealth.doctorCore.exception.AuthorizedException;
import com.bithealth.doctorCore.facede.service.DoctorInterfService;
import com.bithealth.fileCore.constant.FileTypeEnum;
import com.bithealth.fileCore.facade.service.FileManagerServiceFacade;
import com.bithealth.fileCore.model.FileConfigModel;
import com.bithealth.sdk.common.email.MailToGetNewLoginPassword;
import com.bithealth.sdk.common.utils.Md5Utils;
import com.bithealth.sdk.common.utils.StringUtil;
import com.bithealth.sdk.common.utils.ValidateUtil;
import com.bithealth.sdk.core.feature.orm.mybatis.Page;
import com.bithealth.sdk.web.controller.BaseSpringController;
import com.bithealth.sdk.web.vo.ShiroUser;


/**
 * 类名称: DoctorAction  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年7月8日 上午10:08:54 
 * 
 * @author "jason chai"
 * @version  
 */

@Controller
@RequestMapping(value = "/doctor")
public class DoctorController extends BaseSpringController {
	
	@Resource(name="doctorService")
	private DoctorService doctorService;
	
	@Resource(name="orolService")
	private OrolService roleService;
	
	@Autowired
	private FileManagerServiceFacade fileManagerServiceFacade;
	
	@Resource(name="doctorInterfService")
	private DoctorInterfService doctorInterfService;
	
	@Resource(name="doctorToGroupService")
	private DoctorToGroupService docToGrpService;
	
	@Resource(name="doctorAccountServiceImpl")
	private DoctorAccountService accountService;
	
    /**
     * 首页
     * 
     * @param request
     * @return
     */
 
    @RequestMapping(value = "/index", method = RequestMethod.POST)
    public String index(HttpServletRequest request) {
        return "index";
    }
    
    @RequestMapping(value="updateSelfInfo")
    public String updateSelfInfo(Doctor doctor, HttpSession session, MultipartRequest request, RedirectAttributes attr) {
    	ShiroUser user = getCurentUser();
    	
    	if(user.getId().intValue() != doctor.getDocid().intValue()) {
    		attr.addFlashAttribute("msg", "修改资料失败：不是当前登陆用户");
    		return "redirect:/user/myInfoDetail";
    	}
    	
    	String url = uploadFile(request.getFile("fieldName"));
		if(StringUtil.isNotEmpty(url)) {
			doctor.setHeadaddress(url);
		}
    	
		url = uploadFile(request.getFile("field2Name"));
		if(StringUtil.isNotEmpty(url)) {
			doctor.setSignaddress(url);
		}
		
    	doctor.setOrgid(user.getDept_id());
    	doctor.setTag(user.getState());
    	int count = doctorService.updateByPrimaryKey(doctor);
    	
    	if(count > 0) {
    		Doctor doc = doctorService.selectById(doctor.getDocid());
    		session.setAttribute("userInfo", ShiroConver.getUser(doc, user));
    		attr.addFlashAttribute("success", true);
    		return "redirect:/user/myInfoDetail";
    	}
    	attr.addFlashAttribute("msg", "修改资料失败");
    	return "redirect:/user/myInfoDetail";
    }
    
    @RequestMapping(value="/viewDoctorDetail")
    public String viewDoctorDetail(HttpServletRequest request) {
    	Integer docId = Integer.parseInt(request.getParameter("docid"));
    	request.setAttribute("odoc", doctorService.selectById(docId));
    	return "/doctor/viewDoctorDetail";
    }
    
    @RequestMapping("/listDoctor")
    public String listDoctor(@ModelAttribute("criteria")String criteria, HttpServletRequest request, Page<Doctor> page) {
    	return getDoctors(criteria, getCurentUser().getDept_id(), page, request, TagStatus.E);
    }
    
    @RequestMapping("/listCommonAdmin")
    public String listCommonAdmin(@ModelAttribute("criteria")String criteria, HttpServletRequest request, Page<Doctor> page) {
    	return getDoctors(criteria, null, page, request, TagStatus.E);
    }
    
    @RequestMapping("/listSysAdmin")
    public String listSysAdmin(@ModelAttribute("criteria")String criteria, HttpServletRequest request, Page<Doctor> page) {
    	return getDoctors(criteria, null, page, request, null);
    }
    
    @RequestMapping("/listGoldKey")
    public String listGoldKey(HttpServletRequest request) {
    	if(getCurentUser().getRoleid().intValue() != 6) {
    		request.setAttribute("msg", "无权查看金钥匙账号");
    		return "/doctor/listGoldKey";
    	}
    	DoctorExample example = new DoctorExample();
    	DoctorExample.Criteria c = example.createCriteria();
    	c.andTagNotEqualTo(TagStatus.E.name());
    	c.andRoleidEqualTo(new Short("5"));
    	request.setAttribute("doctor", doctorService.selectByExample(example).get(0));
    	return "/doctor/listGoldKey";
    }
    
    @RequestMapping("/edit/{id}")
    public String edit(@PathVariable("id")int id, HttpServletRequest request, RedirectAttributes attr) throws UnsupportedEncodingException{
    	Doctor doctor = null;
    	if(id > 0) {
    		doctor = doctorService.selectById(id);
    	}
    	if(getCurentUser().getRoleid().intValue() == 1) {
    		request.setAttribute("roles", getRoles(1));
    	}
    	request.setAttribute("certiType", CertiType.values());
    	request.setAttribute("doctor", doctor);
    	if(StringUtil.isNotEmpty(attr.getFlashAttributes().get("msg"))) {
    		request.setAttribute("msg", attr.getFlashAttributes().get("msg"));
    	}
    	return "/doctor/edit";
    }
    
    @RequestMapping("/add")
    public String add(Doctor doctor, MultipartRequest request, RedirectAttributes attr) throws UnsupportedEncodingException {
    	String headAddress = uploadFile(request.getFile("fieldName"));
		if(StringUtil.isNotEmpty(headAddress)) {
			doctor.setHeadaddress(headAddress);
		}

		String signAddress = uploadFile(request.getFile("field2Name"));
		if(StringUtil.isNotEmpty(signAddress)) {
			doctor.setSignaddress(signAddress);
		}
    	
    	if(doctor.getDoctorAccount() != null && StringUtil.isNotEmpty(doctor.getDoctorAccount().getDocpass())) {
    		doctor.getDoctorAccount().setDocpass(Md5Utils.encript(doctor.getDoctorAccount().getDocpass()));
    	}
    	
    	ShiroUser user = getCurentUser();
    	Doctor loginDoctor = new Doctor();
    	loginDoctor.setDocid(user.getId());
    	String msg = "操作失败";
    	try {
			if(doctorInterfService.insertOrUpdateDoctor(loginDoctor, doctor)) {
				return "redirect:" + getUrlByRole(user.getRoleid());
			}
		} catch (AuthorizedException e) {
			msg = e.getLocalizedMessage();
		}
    	attr.addFlashAttribute("msg", msg);
    	return "redirect:/doctor/edit/" + (doctor.getDocid() == null ? 0 : doctor.getDocid());
    }
    
    @RequestMapping("/createSysAdmin")
    @ResponseBody
    public Message createSysAdmin(Doctor doctor, HttpServletRequest request){
    	if(getCurentUser().getRoleid().intValue() != 5) {
    		return new Message("无权限操作", false);
    	}
    	if (!ValidateUtil.isEmail(doctor.getEmail())) {
			return new Message("Email地址不合法", false);
		}
		if (!ValidateUtil.isMobileNo(doctor.getTel())) {
			return new Message("手机号码不合法", false);
		}
		doctor.setRoleid(new Short("6"));
		doctor.setTag(TagStatus.T.name());
		try {
			boolean ok = doctorInterfService.insertOrUpdateDoctor(ShiroConver.getDoctor(getCurentUser()), doctor);
			if(ok) {
				boolean res = MailToGetNewLoginPassword.sendMail(doctor.getDoctorAccount().getDocacc(), doctor.getEmail(), "healthcare99" );
				if(res) {
					return new Message("操作成功", true);
				} else {
					return new Message("新增成功，邮件发送失败", true);
				}
			}
		} catch (AuthorizedException e) {
			return new Message("操作失败:" + e.getMessage(), false);
		}		
		return new Message("操作失败", false);
    }
    
    @RequestMapping("/detail/{id}")
    public String detail(@PathVariable("id")int id, HttpServletRequest request) {
    	request.setAttribute("odoc", doctorService.selectById(id));
    	DocToGroupExample example = new DocToGroupExample();
    	DocToGroupExample.Criteria c = example.createCriteria();
    	c.andDocidEqualTo(id);
    	
    	if(StringUtil.isNotEmpty(request.getParameter("orgId"))) {
    		try{
    			int orgId = Integer.parseInt(request.getParameter("orgId"));
        		c.andOrgidEqualTo(orgId);
    		} catch (Exception e) { }
    	}
    	List<DocToGroup> list = docToGrpService.selectByExample(example);
    	request.setAttribute("groups", list);
    	return "/doctor/detail";
    }
    
    @RequestMapping("/reset")
    @ResponseBody
    public Message reset(Doctor doctor){
    	ShiroUser user = getCurentUser();
    	if(user.getRoleid().intValue() == 1) {
    		if(user.getDept_id() != null) {
        		if(doctor.getOrgid() == null || user.getDept_id().intValue() != doctor.getOrgid().intValue()) {
        			return new Message("不属于同一组织，无权操作", false);
        		}
        	}
    	}
    	doctor = doctorService.selectById(doctor.getDocid());
    	String pwd = ValidateUtil.getCharAndNum(6);
    	DoctorAccount newAccount = doctor.getDoctorAccount();
    	newAccount.setDocpass(Md5Utils.encript(pwd));
    	doctor.setDoctorAccount(newAccount);
    	boolean success = MailToGetNewLoginPassword.sendMail(doctor.getDoctorAccount().getDocacc(), doctor.getEmail(), pwd);
    	if (success) { // 邮件发送成功
			try {
				boolean ok = doctorInterfService.restPassword(ShiroConver.getDoctor(getCurentUser()), doctor);
				if(ok) {
					return new Message("新密码已发到邮箱，请查收", true);
				}
				return new Message("重置密码失败", false);
			} catch (Exception e) {
				return new Message("重置密码异常:" + e.getMessage(), false);
			}
		} 
    	return new Message("重置密码失败，原因-邮件发送失败", false);
    }
    
    @RequestMapping("/delete")
    @ResponseBody
    public Message delete(Doctor doctor) {
    	ShiroUser user = getCurentUser();
    	if(user.getRoleid() == 5) {
    		DoctorExample example = new DoctorExample();
        	example.setOrderByClause("Docid DESC");
        	DoctorExample.Criteria c = example.createCriteria();
        	c.andRoleidEqualTo(new Short("6"));
        	List<Doctor> doctorList = doctorService.selectByExampleAndPage(new Page<Doctor>(1, 2), example);
        	if(doctorList != null && doctorList.size() == 1 && doctorList.get(0).getDocid().intValue() == doctor.getDocid().intValue()) {
        		return new Message("至少保留一个系统管理员", false);
        	}
    	}
    	try {
    		boolean ok = doctorInterfService.delete(ShiroConver.getDoctor(getCurentUser()), doctor);
    		if(ok) {
    			return new Message("删除成功", true);
    		}
    	} catch(AuthorizedException e) {
    		return new Message(e.getMessage(), false);
    	}
    	return new Message("删除失败", false);
    }
    
    @RequestMapping("/disabled")
    public String disabled(Doctor doctor) {
    	String tag = doctor.getTag();
    	doctor = doctorService.selectById(doctor.getDocid());
    	doctor.setTag(tag);
    	doctorService.update(doctor);
    	return "redirect:/doctor/listSysAdmin";
    }
    
    private String getDoctors(String criteria, Integer orgId, Page<Doctor> page, HttpServletRequest request, TagStatus notEqualTag) {
    	ShiroUser user = getCurentUser();
    	int roleId = user.getRoleid().intValue();
    	DoctorExample example = new DoctorExample();
    	example.setOrderByClause("Docid DESC");
    	DoctorExample.Criteria c = example.createCriteria();
    	if(notEqualTag != null) {
    		c.andTagNotEqualTo(notEqualTag.name());
    	}
    	if(StringUtil.isNotEmpty(criteria)) {
    		c.andCustomQuery(criteria);
    	}
    	if(orgId != null) {
    		c.andOrgidEqualTo(user.getDept_id());
    	}
    	if(roleId == 1) { //当前登录用户为普通管理员，则查询医生列表
    		List<Short> roleList= new ArrayList<Short>();
    		roleList.add(new Short("2"));
    		roleList.add(new Short("3"));
    		roleList.add(new Short("4"));
    		roleList.add(new Short("7"));
    		c.andRoleidIn(roleList);
    	} else if(roleId == 6) { //当前登录为系统管理员，则查询普通管理员列表
    		c.andRoleidEqualTo(new Short("1"));
    	} else if(roleId == 5) {  //当前登录为金钥匙用户，则查询系统管理员
    		c.andRoleidEqualTo(new Short("6"));
    	}
    	List<Doctor> doctorList = doctorService.selectByExampleAndPage(page, example);
    	page.setResult(doctorList);
    	request.setAttribute("page", page);
    	return getUrlByRole(roleId);
    }
    
    private String getUrlByRole(int roleId) {
    	switch(roleId) {
    	case 1 :
    		return "/doctor/listDoctor";
    	case 5 :
    		return "/doctor/listSysAdmin";
    	case 6 :
    		return "/doctor/listCommonAdmin";
    	default :
    		return null;
    	}
    }
    
    private List<Orol> getRoles(int currentRole) {
    	OrolExample example = new OrolExample();
    	OrolExample.Criteria criteria = example.createCriteria();
    	criteria.andTagEqualTo(TagStatus.T.name());
    	if(currentRole == 1) {
    		List<Short> roleList= new ArrayList<Short>();
    		roleList.add(new Short("2"));
    		roleList.add(new Short("3"));
    		roleList.add(new Short("4"));
    		roleList.add(new Short("7"));
    		criteria.andRoleidIn(roleList);
    	}
    	return roleService.selectByExample(example);
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
		try {
			//文件上传
			return fileManagerServiceFacade.uploadFile(file.getInputStream(), model);
		} catch (Exception e) {
			return null;
		}
	}

}

