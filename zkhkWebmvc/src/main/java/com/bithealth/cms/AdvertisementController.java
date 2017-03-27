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
import com.bithealth.cmsCore.model.Advertisement;
import com.bithealth.cmsCore.model.AdvertisementExample;
import com.bithealth.cmsCore.model.AdvertisementExample.Criteria;
import com.bithealth.fileCore.constant.FileTypeEnum;
import com.bithealth.fileCore.facade.service.FileManagerServiceFacade;
import com.bithealth.fileCore.model.FileConfigModel;
import com.bithealth.sdk.common.utils.TimeUtil;
import com.bithealth.sdk.core.feature.orm.mybatis.Page;
import com.bithealth.sdk.web.controller.BaseSpringController;
import com.bithealth.sdk.web.vo.ShiroUser;

/**
 * 类名：AdvertisementController 描述：
 * 
 * @author 作者:周玉飞
 * @version 创建时间：2016年8月3日 下午2:24:40 类说明
 */
@Controller
@RequestMapping(value = "/msgCenter")
public class AdvertisementController extends BaseSpringController {

	@Autowired
	private CmsFacedeService cmsFacedeService;
	@Autowired
	private FileManagerServiceFacade fileManagerServiceFacade;

	@RequestMapping("/listAdvert")
	public String listAdvert(Page<Advertisement> page, Advertisement pojo,
			Model model) {
		page.setPageNo(page.getPageNo());
		model.addAttribute("pojo", pojo);
		AdvertisementExample example = new AdvertisementExample();
		Criteria criteria = example.createCriteria();
		criteria.andTitleLike(pojo.getTitle())
				.andStatustypeEqualTo(pojo.getStatustype())
				.andUsepageEqualTo(pojo.getUsepage())
				.andReleasetimeGreaterThanOrEqualTo(pojo.getStartReleasetime());
		if(pojo.getEndReleasetime() != null){
			criteria.andReleasetimeLessThanOrEqualTo(DateUtils.addDays(pojo.getEndReleasetime(), 1));
		}
		example.setOrderByClause("ReleaseTime desc");
		model.addAttribute("page",
				cmsFacedeService.slectAdvertPage(page, example));
		return "/msgCenter/advert";
	}

	@RequestMapping(value = "/editAdvert")
	public String editAdvert(Integer id, Model model) {
		Advertisement pojo = cmsFacedeService.selectAdvertById(id);
		if (pojo == null) {
			pojo = new Advertisement();
		}
		model.addAttribute("pojo", pojo);
		return "/msgCenter/editAdvert";

	}

	@RequestMapping(value = "/saveAdvert")
	public String saveAdvert(Advertisement pojo,RedirectAttributes redirectAttributes) {
		if(!pojo.getCoverimageFile().isEmpty()){
	        pojo.setCoverimage(uploadFile(pojo.getCoverimageFile()));
	    }
		if (pojo.getCoverimageFile().getSize()>1024*1024) {
			redirectAttributes.addFlashAttribute("message", "保存失败,封面图片大小超过1兆！");
		}
		ShiroUser user = getCurentUser();
		pojo.setCreateid(user.getId());
		pojo.setUpdateid(user.getId());
		if (cmsFacedeService.insertOrUpdateAdvert(pojo)) {
			redirectAttributes.addFlashAttribute("message", "保存成功！");
		} else
			redirectAttributes.addFlashAttribute("message", "保存失败！");
		return "redirect:listAdvert";
	}

	// 发放
	@RequestMapping(value = "/publishAdvert")
	public String publishAdvert(Integer id, Advertisement pojo,
			RedirectAttributes redirectAttributes, Model model) {
		pojo = cmsFacedeService.selectAdvertById(id);
		model.addAttribute("pojo", pojo);
		pojo.setReleasetime(TimeUtil.now());
		pojo.setStatustype((byte) 2);
		if (cmsFacedeService.publishAdvert(pojo)) {
			redirectAttributes.addFlashAttribute("message", "发布成功！");
		} else
			redirectAttributes.addFlashAttribute("message", "发布失败！");
		return "redirect:listAdvert";
	}

	@RequestMapping(value = "/deleteAdverts")
	public @ResponseBody Message deleteAdverts(Integer... ids) {
		if (cmsFacedeService.deleteAdverts(ids)) {
			return new Message("删除成功！", true);
		} else
			return new Message("删除失败！", false);

	}
	
	//上传图片
	private String uploadFile(MultipartFile file) {
		String originalFilename = file.getOriginalFilename();
		String fileFormat = /*originalFilename.split("\\.")[1];*/originalFilename.substring(originalFilename.length()-3);
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
