package com.bithealth.cms;

import org.apache.commons.lang.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bithealth.Message;
import com.bithealth.cmsCore.facede.CmsFacedeService;
import com.bithealth.cmsCore.model.HealthnewsInfo;
import com.bithealth.cmsCore.model.HealthnewsInfoExample;
import com.bithealth.cmsCore.model.HealthnewsInfoExample.Criteria;
import com.bithealth.cmsCore.model.HealthnewsLable;
import com.bithealth.cmsCore.service.HealthnewsLableService;
import com.bithealth.fileCore.constant.FileTypeEnum;
import com.bithealth.fileCore.facade.service.FileManagerServiceFacade;
import com.bithealth.fileCore.model.FileConfigModel;
import com.bithealth.sdk.common.utils.TimeUtil;
import com.bithealth.sdk.core.feature.orm.mybatis.Page;
import com.bithealth.sdk.web.controller.BaseSpringController;
import com.bithealth.sdk.web.vo.ShiroUser;

/**
 * 类名：HealthnewsInfoController
 * 描述：
 * @author 作者:周玉飞
 * @version 创建时间：2016年8月3日 下午2:26:48
 * 类说明
 */
@Controller
@RequestMapping(value = "/msgCenter")
public class HealthnewsInfoController extends BaseSpringController {
	
	@Autowired 
	private CmsFacedeService cmsFacedeService;
	@Autowired 
	private HealthnewsLableService healthnewsLableService;
	@Autowired
	private FileManagerServiceFacade fileManagerServiceFacade;
	

	@RequestMapping(value="/listNewsInfo")
	public String listNewsInfo(Page<HealthnewsInfo> page,HealthnewsInfo pojo,Model model,HealthnewsLable healthnewsLable){
		page.setPageNo(page.getPageNo());
		model.addAttribute("pojo",pojo);
		model.addAttribute("healthnewsLable",healthnewsLable);
		HealthnewsInfoExample example = new HealthnewsInfoExample();
		Criteria criteria =  example.createCriteria();
		
		criteria.andTitleLike(pojo.getTitle())
		.andStatustypeEqualTo(pojo.getStatustype())
		.andHNLabelIDEqualTo(healthnewsLable.getHnlabelid())
		.andIsstickypostEqualTo(pojo.getIsstickypost())
		.andReleasetimeEqualTo(pojo.getReleasetime())
		.andCreatetimeEqualTo(pojo.getCreatetime())
		.andUpdatetimeGreaterThanOrEqualTo(pojo.getStartUpdatetime());
		if (pojo.getEndUpdatetime()!=null) {
			criteria.andUpdatetimeLessThanOrEqualTo(DateUtils.addDays(pojo.getEndUpdatetime(),1));
		}
		criteria.andReleasetimeGreaterThanOrEqualTo(pojo.getStartReleasetime());
		if (pojo.getEndReleasetime()!=null) {
			criteria.andReleasetimeLessThanOrEqualTo(DateUtils.addDays(pojo.getEndReleasetime(),1));
		}
		example.setOrderByClause("UpdateTime desc");
		model.addAttribute("page",cmsFacedeService.selectNewsInfoPage(page, example));
		model.addAttribute("lableList", healthnewsLableService.selectAllLable(healthnewsLable));
		return "/msgCenter/healthInfo";
		
	}
	
	//编辑
		@RequestMapping(value="editNewsInfo")
		public String editNewsInfo(Integer id, Model model,HealthnewsLable healthnewsLable){
			HealthnewsInfo pojo =cmsFacedeService.selectNewsIngfoById(id);
			if (pojo==null) {
				pojo=new HealthnewsInfo();
				pojo.setAuthor("中科汇康");
			}
			model.addAttribute("pojo", pojo);
			model.addAttribute("lableList", healthnewsLableService.selectAllLable(healthnewsLable));
			return "/msgCenter/editHealthInfo";
		}
	
	@RequestMapping(value="/publishNewsInfo")
	public String publishNewsInfo(Integer id,Model model,HealthnewsInfo pojo, RedirectAttributes redirectAttributes){
		pojo =cmsFacedeService.selectNewsIngfoById(id);
		model.addAttribute("pojo", pojo);
		pojo.setStatustype((byte) 2);
		pojo.setReleasetime(TimeUtil.now());
		pojo.setUpdatetime(TimeUtil.now());
		if (cmsFacedeService.publishNewsInfo(pojo)) {
			redirectAttributes.addFlashAttribute("message", "发布成功！");
		}else{
			redirectAttributes.addFlashAttribute("message", "发布失败！");
		}
		return "redirect:listNewsInfo";
		
	}
	
	//支持批量删除
	@RequestMapping(value="/deleteHealthnewsInfos")
	public @ResponseBody  Message deleteHealthnewsInfos(Integer... ids){
		if (cmsFacedeService.deleteNewsIngfos(ids)) {
			return new Message("删除成功！", true);
		}else
			return new Message("删除失败！", false);
	
	}	
	
	@RequestMapping(value="/deleteHealthnewsInfo")
	public @ResponseBody  Message deleteHealthnewsInfo(Integer id){
		if (cmsFacedeService.deleteNewsIngfo(id)) {
			cmsFacedeService.deleteBookmark(id);
			return new Message("删除成功！", true);
		}else
			return new Message("删除失败！", false);
		
		}	

	@RequestMapping(value="/saveNewsInfo")
	public String saveNewsInfo(HealthnewsInfo pojo, RedirectAttributes redirectAttributes, Integer...hnlabelids) {
		if(!pojo.getThumbnailFile().isEmpty()){
	        pojo.setThumbnail(uploadFile(pojo.getThumbnailFile()));
	    }
		if(!pojo.getCoverimageFile().isEmpty()){
			pojo.setCoverimage(uploadFile(pojo.getCoverimageFile()));
	    }
		if (pojo.getThumbnailFile().getSize()>1024*200) {
			redirectAttributes.addFlashAttribute("message", "保存失败,缩略图超过200k");
		}
		if (pojo.getCoverimageFile().getSize()>1024*1024) {
			redirectAttributes.addFlashAttribute("message", "保存失败,封面图超过1兆");
		}
		
		ShiroUser user = getCurentUser();
		pojo.setCreateid(user.getId());
		pojo.setUpdateid(user.getId());
		if (cmsFacedeService.insertOrUpdateNewsInfo(pojo,hnlabelids)) {
			redirectAttributes.addFlashAttribute("message", "保存成功！");
		}else
			redirectAttributes.addFlashAttribute("message", "保存失败！");
			return "redirect:listNewsInfo";
	}

	private String uploadFile(MultipartFile file) {
		String originalFilename = file.getOriginalFilename();
		String fileFormat = /*originalFilename.split("\\.")[1];*/ originalFilename.substring(originalFilename.length()-3);
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
