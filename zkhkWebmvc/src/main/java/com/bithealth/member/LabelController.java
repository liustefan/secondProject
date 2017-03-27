package com.bithealth.member;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bithealth.FailMessage;
import com.bithealth.Message;
import com.bithealth.SuccessMessage;
import com.bithealth.memberCore.memberLabel.enmu.LabelUserRange;
import com.bithealth.memberCore.memberLabel.faced.service.LabelFacedService;
import com.bithealth.memberCore.memberLabel.model.LabelItem;
import com.bithealth.memberCore.memberLabel.model.LabelTag;
import com.bithealth.memberCore.memberLabel.service.LabelService;
import com.bithealth.orgainCore.service.OrgService;
import com.bithealth.sdk.common.utils.StringUtil;
import com.bithealth.sdk.core.feature.orm.mybatis.Page;
import com.bithealth.sdk.web.controller.BaseSpringController;
import com.bithealth.sdk.web.vo.ShiroUser;

/**
 * 类名称: LabelController  
 * 功能描述: 标签控制层
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年12月06日 
 * 
 * @author 周玉飞
 * @version  
 */
@Controller
@RequestMapping("/label")
public class LabelController extends BaseSpringController{
	
	@Autowired
	private LabelFacedService  labelFacedService;
	@Autowired
	private LabelService labelService;
	@Resource(name="orgService")
	private OrgService orgService;
	
	@RequestMapping(value="/listLabel")
	public String listLabel(Page<LabelItem> page,LabelItem pojo,Model model,LabelTag labelTag){
		page.setPageNo(page.getPageNo());
		model.addAttribute("pojo", pojo);
		model.addAttribute("labelTag", labelTag);
		ShiroUser user = getCurentUser();
		if(user.getDept_id() != null)
			pojo.setSuperOrgIds(orgService.selectAllSharedOrg(user.getDept_id(), true));
		if(pojo.getUserange() == null){
			if (getCurentUser().getRoleid()==6) {
					pojo.setUserange((byte) 1);
			}
			if (getCurentUser().getRoleid()==1) {
				pojo.setUserange((byte) 2);
			}
			if (getCurentUser().getRoleid()!=1 && getCurentUser().getRoleid()!=6) {
				pojo.setUserange((byte) 3);
			}
		}
		if(pojo.getUserange() == 0)
			pojo.setUserange(null);
		pojo.setOrgID(user.getDept_id());
		pojo.setRoleId(user.getRoleid());
		pojo.setCreateid(user.getId());
		model.addAttribute("page", labelFacedService.selectLabelByPage(page, pojo));
		model.addAttribute("labelClassList", labelFacedService.selectAllLabelClass(labelTag));
		return "/member/LabelManage/memberLabelManage";
		
	}
	
	@RequestMapping(value="/editLabel")
	public String editLabel(Integer id, Model model,LabelTag labelTag){
		LabelItem pojo = labelFacedService.selectLabelById(id);
		if (pojo==null) {
			pojo = new LabelItem();
		}
		pojo.setOrgName(getCurentUser().getOrgName());
		model.addAttribute("pojo", pojo);
		model.addAttribute("labelClassListEdit", labelFacedService.selectAllLabelClassUserEdit(labelTag));
		return "/member/LabelManage/editLabel";
		
	}
	
	//启用
	@RequestMapping(value="/userLabel")
	public String userLabel(Integer id,RedirectAttributes redirectAttributes, Model model){
		LabelItem pojo =labelFacedService.selectLabelById(id);
		model.addAttribute("pojo", pojo);
		pojo.setItemstatus((byte) 2);
		labelFacedService.updateLabelByItemStatus(pojo);
		return "redirect:listLabel";
	}
	
	//禁用
	@RequestMapping(value="/banLabel")
	public String banLabel(Integer id,RedirectAttributes redirectAttributes, Model model){
		LabelItem pojo =labelFacedService.selectLabelById(id);
		model.addAttribute("pojo", pojo);
		pojo.setItemstatus((byte) 3);
		labelFacedService.updateLabelByItemStatus(pojo);
		return "redirect:listLabel";
	}
	
	/**
	 * 验证会员标签名称是否重复
	 * @param pojo
	 * @return
	 */
	@RequestMapping("/selectLabelItemIsExist")
	public @ResponseBody Message selectLabelItemIsExist(String itemname,Integer id){
		ShiroUser user = getCurentUser();
		if (user.getDept_id()==null){ 
			LabelItem labelItem = labelFacedService.selectLabelItemIsExist(user.getRoleid(),itemname, id,user.getId(),null);
			if(labelItem != null)
				return new SuccessMessage(labelItem.getLabelUserRange());
			else
				return new FailMessage();
		}else{
		LabelItem pojo = labelFacedService.selectLabelItemIsExist(user.getRoleid(), itemname, id, user.getId(), orgService.selectAllSharedOrg(user.getDept_id(), true));
		if(pojo != null)
			return new SuccessMessage(pojo.getLabelUserRange());
		else
			return new FailMessage();
	}
}
	
	@RequestMapping(value="/saveLabel")
	public  @ResponseBody Message saveLabel(LabelItem pojo){
		ShiroUser user = getCurentUser();
		if(user.getRoleid() == 6){
			pojo.setOrgid(0);
			pojo.setUserange(LabelUserRange.GLOBAL.getCode());
		}else{
			pojo.setOrgid(user.getDept_id());
			if(user.getRoleid() == 1){
				pojo.setUserange(LabelUserRange.INORG.getCode());
			}else{
				pojo.setCreateid(user.getId());
				pojo.setLclassid(2);
				pojo.setUserange(LabelUserRange.OWNED.getCode());
			}
		}
		pojo.setCreateid(user.getId());
		pojo.setCreatetime(new Date());
		pojo.setUpdateid(user.getId());
		pojo.setUpdatetime(new Date());
		if (labelFacedService.insertOrUpdateLabel(pojo)) {
			return new Message( "保存成功！",true);
		}else
			return new Message( "保存失败！",false);
		
	}
	
	/**
	 * 
	 * @Title:listLabelItemsByDoc 
	 * @Description:获取医生对应的会员标签. 
	 * @author liuhm
	 * @param request
	 * @return 
	 * @param 
	 * @throws
	 * @retrun String
	 */
	@RequestMapping("/listLabelItemsByDoc")
	public String listLabelItemsByDoc(HttpServletRequest request, String labelIds){
		Integer docId = getCurentUser().getId();
		Integer orgId = getCurentUser().getDept_id();
		String orgIds = orgService.selectAllSharedOrg(orgId, true);
		List<LabelItem> items = labelService.selectByDoc(docId, orgIds);
		if(StringUtil.isNotEmpty(labelIds) && items.size() > 0) {
			for(String id : labelIds.split(",")) {
				for(LabelItem item : items) {
					if(item.getLitemid().toString().equals(id)) {
						item.setChecked(true);
						break;
					}
				}
			}
		}
		request.setAttribute("items", items);
		request.setAttribute("labelIds", labelIds);
		request.setAttribute("flag", request.getParameter("flag"));
		return "/member/chooseLabel";
	}
	
}