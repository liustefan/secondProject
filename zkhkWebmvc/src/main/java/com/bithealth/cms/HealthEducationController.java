package com.bithealth.cms;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bithealth.FailMessage;
import com.bithealth.Message;
import com.bithealth.SuccessMessage;
import com.bithealth.cmsCore.facede.CmsFacedeService;
import com.bithealth.cmsCore.healthEducation.dao.HealthEducationDiseaseMapper;
import com.bithealth.cmsCore.healthEducation.enmu.HealthEducationenum;
import com.bithealth.cmsCore.healthEducation.facede.HealthFacedeService;
import com.bithealth.cmsCore.healthEducation.model.HealthEducation;
import com.bithealth.cmsCore.model.HealthnewsInfo;
import com.bithealth.cmsCore.model.HealthnewsInfoExample;
import com.bithealth.cmsCore.model.HealthnewsLable;
import com.bithealth.cmsCore.service.HealthnewsInfoService;
import com.bithealth.cmsCore.service.HealthnewsLableService;
import com.bithealth.orgainCore.service.OrgService;
import com.bithealth.sdk.core.feature.orm.mybatis.Page;
import com.bithealth.sdk.web.controller.BaseSpringController;
import com.bithealth.sdk.web.vo.ShiroUser;

/**
 * 类名：HealthEducationController
 * 描述：健教库管理
 * 
 * @author 作者:周玉飞
 * @version 创建时间：2016年12月1日 
 */

@Controller
@RequestMapping(value = "/health")
public class HealthEducationController extends BaseSpringController{
	
	@Autowired
	private HealthFacedeService healthFacedeService;
	@Autowired
	HealthEducationDiseaseMapper healthEducationDiseaseMapper;
	@Autowired 
	private CmsFacedeService cmsFacedeService;
	@Autowired 
	private HealthnewsLableService healthnewsLableService;
	@Resource(name="orgService")
	private OrgService orgService;
	@Autowired
	private HealthnewsInfoService healthnewsInfoService;
	
	@RequestMapping("/listHealth")
	public String listHealth(Page<HealthEducation> page,HealthEducation pojo,Model model){
		
		page.setPageNo(page.getPageNo());
		model.addAttribute("pojo", pojo);
		ShiroUser user = getCurentUser();
		if(user.getDept_id() != null)
			pojo.setSuperOrgIds(orgService.selectAllSharedOrg(user.getDept_id(), true));
		pojo.setOrgid(user.getDept_id());
		pojo.setRoleId(user.getRoleid());
		pojo.setCreateid(user.getId());
		if(pojo.getUserange() == null){
			if(user.getRoleid() == 6){
				pojo.setUserange(HealthEducationenum.GLOBAL.getCode());
			}else if(user.getRoleid() == 1){
				pojo.setUserange(HealthEducationenum.INORG.getCode());
			}else{
				pojo.setUserange(HealthEducationenum.OWNED.getCode());
			}
		}
		if(pojo.getUserange() == 0)
			pojo.setUserange(null);
		model.addAttribute("page",healthFacedeService.selectHealthEducationPage(page, pojo));
		return "/msgCenter/HealthEducationLibrary/healthDemo";
		
	}
	
	@RequestMapping(value="/editHealth")
	public String editHealthEducation(Integer id, Model model){
		HealthEducation pojo = healthFacedeService.selectHealthById(id);
		if (pojo==null) {
			pojo=new HealthEducation();
		}
		model.addAttribute("pojo", pojo);
		return "/msgCenter/HealthEducationLibrary/editHealthDemo";
		
	}
	
	@RequestMapping(value="/checkHealth")
	public String checkHealthEducation(Integer id, Model model){
		HealthEducation pojo = healthFacedeService.selectHealthById(id);
		model.addAttribute("pojo", pojo);
		return "/msgCenter/HealthEducationLibrary/healthTempContent";
		
	}
	
	@RequestMapping(value="/deleteHealth")
	public @ResponseBody Message deleteHealth(Integer id){
		if (healthFacedeService.deleteHealthByID(id)) {
		healthEducationDiseaseMapper.deleteHealthEducationDisease(id);
			return new Message("删除成功！", true);
		}else
			return new Message("删除失败！", false);
		
		}	
	
	@RequestMapping(value="/selectHealthEducationIsExist")
	public @ResponseBody Message selectHealthEducationIsExist(Integer id,String title){
		ShiroUser user = getCurentUser();
		HealthEducation pojo = healthFacedeService.selectHealthEducation(user.getRoleid(), title, id, user.getId(), orgService.selectAllSharedOrg(user.getDept_id(), true));
		if (pojo!=null) {
			return new SuccessMessage(pojo.getHealthEducationenum());
		}
		return new FailMessage();
		
	}
	
	@RequestMapping(value="/saveHealthEducation")
	public String saveHealthEducation(HealthEducation pojo,RedirectAttributes redirectAttributes){
		ShiroUser user = getCurentUser();
		pojo.setCreateid(user.getId());
		pojo.setUpdateid(user.getId());
		pojo.setOrgid(user.getDept_id());
		if (healthFacedeService.insertOrUpdateEducation(pojo)) {
			redirectAttributes.addFlashAttribute("message", "保存成功！");
			/*//选择健康资讯后若编辑内容，同部健康资讯内容
			if (pojo.getSourceid()!=null) {
			int id =pojo.getSourceid();
			HealthnewsInfo healthnewsInfo =cmsFacedeService.selectNewsIngfoById(id);
			healthnewsInfo.setContent(pojo.getContent());
			healthnewsInfoService.updateByPrimaryKey(healthnewsInfo);
			}*/
		}else
			redirectAttributes.addFlashAttribute("message", "保存失败！");
			return "redirect:listHealth";
		}
	
	
	@RequestMapping("/chooseHealthInfo")
	public String chooseHealthInfo(Page<HealthnewsInfo> page,HealthnewsInfo pojo,Model model,HealthnewsLable healthnewsLable){
		page.setPageNo(page.getPageNo());
		page.setTotalCount(-1);
		model.addAttribute("pojo",pojo);
		model.addAttribute("healthnewsLable",healthnewsLable);
		if (healthnewsLable.getHnlabelid()!=null || StringUtils.isNotEmpty(pojo.getTitle())) {
		HealthnewsInfoExample example = new HealthnewsInfoExample();
		com.bithealth.cmsCore.model.HealthnewsInfoExample.Criteria criteria =example.createCriteria();
		criteria
		.andHNLabelIDEqualTo(healthnewsLable.getHnlabelid())
		.andTitleLike(pojo.getTitle());
		page = cmsFacedeService.selectNewsInfoPage(page, example);
		}
		model.addAttribute("page",page);
		model.addAttribute("lableList", healthnewsLableService.selectAllLable(healthnewsLable));
		return "/msgCenter/HealthEducationLibrary/chooseHealthInfo";
		
	}
	
		@RequestMapping(value="chooseNewsInfoContent")
		public @ResponseBody Object editNewsInfo(Integer id,Model model){
			HealthnewsInfo healthnews =cmsFacedeService.selectNewsIngfoById(id);
			return healthnews.getContent().getBytes();
		}
	
}
