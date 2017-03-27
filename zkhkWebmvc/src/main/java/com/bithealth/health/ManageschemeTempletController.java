 
/**
 * @PackageName:      com.bithealth.health
 * @FileName:     ManageschemeTempletController.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      名字  * 
 * @version      V1.0  
 * @Createdate:  2016年11月30日 下午3:49:00  
 * 
 */

package com.bithealth.health;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.bithealth.FailMessage;
import com.bithealth.Message;
import com.bithealth.SuccessMessage;
import com.bithealth.fileCore.facade.service.FileManagerServiceFacade;
import com.bithealth.healthCore.enmu.ExecuteWayEnum;
import com.bithealth.healthCore.enmu.PlanTimeTypeEnum;
import com.bithealth.healthCore.enmu.TaskTypeEnum;
import com.bithealth.healthCore.enmu.TempletStatusEnum;
import com.bithealth.healthCore.enmu.UseRangeEnum;
import com.bithealth.healthCore.facede.service.TempletFacedeService;
import com.bithealth.healthCore.templet.model.ManageschemeTemplet;
import com.bithealth.healthCore.templet.model.ManageschemeTempletTask;
import com.bithealth.orgainCore.service.OrgService;
import com.bithealth.sdk.common.Env;
import com.bithealth.sdk.config.KDConfig;
import com.bithealth.sdk.core.feature.orm.mybatis.Page;
import com.bithealth.sdk.web.controller.BaseSpringController;
import com.bithealth.sdk.web.vo.ShiroUser;


/**
 * 类名称: ManageschemeTempletController  
 * 功能描述: TODO ADD FUNCTION.  方案模板管理
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年11月30日 下午3:49:00 
 * 
 * @author baozj
 * @version  
 */
@Controller
@RequestMapping(value = "/health/templet")
public class ManageschemeTempletController extends BaseSpringController {

	@Autowired
	private TempletFacedeService templetService;
	@Autowired
	private FileManagerServiceFacade fileManagerServiceFacade;
	
	@Resource(name="orgService")
	private OrgService orgService;
	
	/**
	 * 
	 * @Title:deleteTemplet 
	 * @Description: 删除方案模板
	 * TODO  
	 * @author baozj
	 * @param ids
	 * @return 
	 * @throws
	 * @retrun Message
	 */
	@RequestMapping(value = "/delete")
	public @ResponseBody Message deleteTemplet(Integer...ids){
		return new SuccessMessage(templetService.deleteTemplet(ids));
	}
	
	/**
	 * 
	 * @Title:deleteTempletTask 
	 * @Description: 删除方案模板任务
	 * TODO  
	 * @author baozj
	 * @param id
	 * @return 
	 * @throws
	 * @retrun Message
	 */
	@RequestMapping(value = "/deleteTask")
	public @ResponseBody Message deleteTempletTask(Integer id){
		return new SuccessMessage(templetService.deleteTempletTask(id));
	}
	
	/**
	 * 
	 * @Title:insertOrUpdateTemplet 
	 * @Description: 保存方案模板
	 * TODO  
	 * @author baozj
	 * @param pojo
	 * @param response 
	 * @throws
	 * @retrun void
	 */
	@RequestMapping(value = "/save", method =RequestMethod.POST)
	public void insertOrUpdateTemplet(ManageschemeTemplet pojo, HttpServletResponse response){
		ShiroUser user = getCurentUser();
		if(user.getRoleid() == 6){
			pojo.setOrgID(0);
			pojo.setUseRange(UseRangeEnum.GLOBAL.getCode());
		}else{
			pojo.setOrgID(user.getDept_id());
			if(user.getRoleid() == 1)
				pojo.setUseRange(UseRangeEnum.INORG.getCode());
			else
				pojo.setUseRange(UseRangeEnum.OWNED.getCode());
		}
		pojo.setCreateID(user.getId());
		pojo.setUpdateID(user.getId());
		try {
			if(!pojo.getFile().isEmpty()){
				pojo.setFileName(pojo.getFile().getOriginalFilename());
				pojo.setFilePath(uploadFile(pojo.getFile()));
			}
			if(templetService.insertOrUpdateTemplet(pojo)){
				writeJS(response, "parent.callback(true, " + pojo.getMSTempletID() + ", '"+(pojo.getFileName() == null ? "" : pojo.getFileName())+"', '"+(pojo.getFilePath()==null ? "" : pojo.getFilePath())+"')");
			}else{
				writeJS(response, "parent.callback(false)");
			}
		} catch (Exception e) {
			e.printStackTrace();
			writeJS(response, "parent.callback(false)");
		}
	}
	
	/**
	 * 
	 * @Title:writeJS 
	 * @Description: 返回js脚本
	 * TODO  
	 * @author baozj
	 * @param response
	 * @param js 
	 * @throws
	 * @retrun void
	 */
	static void writeJS(HttpServletResponse response, String js){
		  PrintWriter pw = null;
		  try {
			  response.setCharacterEncoding("UTF-8");
			  response.setContentType("text/html; charset=utf-8");
			  pw = response.getWriter();
			  pw.print("<script>" + js + "</script>");
		  } catch (IOException e) {
			  e.printStackTrace();
		  } finally {
			  if(pw != null)
				  pw.close();
		  }		  
	}
	
	/**
	 * 
	 * @Title:insertOrUpdateTempletTask 
	 * @Description: 保存方案模板任务
	 * TODO  
	 * @author baozj
	 * @param pojo
	 * @return 
	 * @throws
	 * @retrun Message
	 */
	@RequestMapping(value = "/saveTask")
	public @ResponseBody Message insertOrUpdateTempletTask(ManageschemeTempletTask pojo){
		ShiroUser user = getCurentUser();
		pojo.setCreateID(user.getId());
		pojo.setUpdateID(user.getId());
		if(templetService.insertOrUpdateTempletTask(pojo))
			return new SuccessMessage(pojo);
		else
			return new FailMessage();
	}
	
	/**
	 * 
	 * @Title:toEdit 
	 * @Description: 跳方案模板新增、编辑页面
	 * TODO  
	 * @author baozj
	 * @param id
	 * @param model
	 * @return 
	 * @throws
	 * @retrun String
	 */
	@RequestMapping(value = "/toEdit")
	public String toEdit(Integer id, Model model){
		ManageschemeTemplet pojo = templetService.selectTempletById(id);
		if(pojo != null){
			model.addAttribute("tasks", JSON.toJSONString(pojo.getTasks(), SerializerFeature.BrowserCompatible));
		}else{
			pojo = new ManageschemeTemplet();
			pojo.setSrvLimitType((byte)3);
			model.addAttribute("tasks", JSON.toJSONString(new ArrayList<Object>()));
		}
		model.addAttribute("pojo", pojo);
		model.addAttribute("executeWay", JSON.toJSONString(ExecuteWayEnum.allValues(), SerializerFeature.BrowserCompatible));
		model.addAttribute("planTimeType", JSON.toJSONString(PlanTimeTypeEnum.allValues(), SerializerFeature.BrowserCompatible));
		model.addAttribute("taskType", JSON.toJSONString(TaskTypeEnum.allValues(), SerializerFeature.BrowserCompatible));
		return "health/templet/edit";
	}
	
	/**
	 * 
	 * @Title:copyToEdit 
	 * @Description: 拷贝方案模板并跳转到新方案模板编辑页面
	 * TODO  
	 * @author baozj
	 * @param referenceId
	 * @param newSchemeTitle
	 * @param model
	 * @param redirectAttributes
	 * @return 
	 * @throws
	 * @retrun String
	 */
	@RequestMapping(value = "/copyToEdit")
	public String copyToEdit(Integer referenceId, String newSchemeTitle, Model model, RedirectAttributes redirectAttributes){
		ShiroUser user = getCurentUser();
		ManageschemeTemplet pTemplet = templetService.selectTempletById(referenceId);
		ManageschemeTemplet templet = new ManageschemeTemplet();
		BeanUtils.copyProperties(pTemplet, templet, "MSTempletID", "updateID", "updateTime", "templetStatus");
		templet.setSchemeTitle(newSchemeTitle);
		templet.setOrgID(user.getDept_id());
		templet.setCreateID(user.getId());
		templet.setReferenceId(referenceId);
		if(user.getRoleid() == 6){
			templet.setOrgID(0);
			templet.setUseRange(UseRangeEnum.GLOBAL.getCode());
		}else if(user.getRoleid() == 1){
			templet.setUseRange(UseRangeEnum.INORG.getCode());
		}else{
			templet.setUseRange(UseRangeEnum.OWNED.getCode());
		}
		if(templetService.insertOrUpdateTemplet(templet)){
			return "redirect:toEdit?id=" + templet.getMSTempletID();
		}else{
			redirectAttributes.addFlashAttribute("message", "拷贝失败！");
			return "redirect:list";
		}
	}
	
	/**
	 * 
	 * @Title:selectTempletById 
	 * @Description: 查询单个方案模板详情
	 * TODO  
	 * @author baozj
	 * @param id
	 * @return 
	 * @throws
	 * @retrun Message
	 */
	@RequestMapping(value = "/selectById")
	public @ResponseBody Message selectTempletById(Integer id){
		return new SuccessMessage(templetService.selectTempletById(id));
	}
	
	/**
	 * 
	 * @Title:selectTempletIsExist 
	 * @Description: 判断方案模板标题在可见域是否存在
	 * TODO  
	 * @author baozj
	 * @param schemeTitle
	 * @param id
	 * @return 
	 * @throws
	 * @retrun Message
	 */
	@RequestMapping(value = "/selectIsExist")
	public @ResponseBody Message selectTempletIsExist(String schemeTitle, Integer id){
		ShiroUser user = getCurentUser();
		ManageschemeTemplet pojo = templetService.selectTempletIsExist(user.getRoleid(), schemeTitle, id, user.getId(), user.getRoleid() == 6 ? null : orgService.selectAllSharedOrg(user.getDept_id(), true));
		if(pojo != null) 
			return new SuccessMessage(pojo.getUseRangeName());
		else
			return new FailMessage();
	}
	
	/**
	 * 
	 * @Title:selectTempletPage 
	 * @Description: 分页查询方案模板
	 * TODO  
	 * @author baozj
	 * @param page
	 * @param pojo
	 * @param model
	 * @return 
	 * @throws
	 * @retrun String
	 */
	@RequestMapping(value = "/list")
	public String selectTempletPage(Page<ManageschemeTemplet> page, ManageschemeTemplet pojo, Model model){
		page.setPageNo(page.getPageNo());
		model.addAttribute("pojo", pojo);
		ShiroUser user = getCurentUser();
		if(user.getDept_id() != null)
			pojo.setSuperOrgIds(orgService.selectAllSharedOrg(user.getDept_id(), true));
		pojo.setOrgID(user.getDept_id());
		pojo.setRoleId(user.getRoleid());
		pojo.setCreateID(user.getId());
		if(pojo.getUseRange() == null){
			if(user.getRoleid() == 6){
				pojo.setUseRange(UseRangeEnum.GLOBAL.getCode());
			}else if(user.getRoleid() == 1){
				pojo.setUseRange(UseRangeEnum.INORG.getCode());
			}else{
				pojo.setUseRange(UseRangeEnum.OWNED.getCode());
			}
		}
		if(pojo.getUseRange() == 0)
			pojo.setUseRange(null);
		model.addAttribute("page", templetService.selectTempletPage(page, pojo));
		return "health/templet/list";
	}
	
	/**
	 * 
	 * @Title:updateTempletStatus 
	 * @Description: 更新方案模板状态
	 * TODO  
	 * @author baozj
	 * @param id
	 * @param newStatus
	 * @param oldStatus
	 * @return 
	 * @throws
	 * @retrun Message
	 */
	@RequestMapping(value = "/updateStatus")
	public @ResponseBody Message updateTempletStatus(Integer id, Byte newStatus, Byte oldStatus){
		return new SuccessMessage(templetService.updateTempletStatus(id, TempletStatusEnum.getEnumByCode(newStatus), TempletStatusEnum.getEnumByCode(oldStatus)));
	}
	
	/**
	 * 
	 * @Title:uploadFile 
	 * @Description: 上传附件
	 * TODO  
	 * @author baozj
	 * @param file
	 * @return
	 * @throws IOException 
	 * @throws
	 * @retrun String
	 */
	static String uploadFile(MultipartFile file) throws IOException{
		//String savePath = pageContext.getServletContext().getRealPath("/") + "upload/";
		String savePath ="";//"D:\\var\\kindeditor\\attached\\";
		KDConfig kdConfig = Env.getBean("rdConfig"); 
		savePath =kdConfig.getProperty("www.attached.root")  ;

		String saveUrl  =  "../../attachedurl?fileName=";

		//检查目录
		File uploadDir = new File(savePath);
		if(!uploadDir.exists())
			uploadDir.mkdirs();
		String dirName = "attachment";
		//创建文件夹
		savePath += dirName + "/";
		saveUrl += dirName + "/";
		File saveDirFile = new File(savePath);
		if (!saveDirFile.exists()) {
			saveDirFile.mkdirs();
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String ymd = sdf.format(new Date());
		savePath += ymd + "/";
		saveUrl += ymd + "/";
		File dirFile = new File(savePath);
		if (!dirFile.exists()) {
			dirFile.mkdirs();
		}
		//检查扩展名
		String fileExt = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1).toLowerCase();

		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
		String newFileName = df.format(new Date()) + "_" + new Random().nextInt(1000) + "." + fileExt;
		File uploadedFile = new File(savePath, newFileName);
		FileUtils.copyInputStreamToFile(file.getInputStream(), uploadedFile);
		return saveUrl + newFileName;
	}
	
	/**
	 * 
	 * @Title:deleteAttached 
	 * @Description: 清空附件记录
	 * TODO  
	 * @author baozj
	 * @param id
	 * @return 
	 * @throws
	 * @retrun Message
	 */
	@RequestMapping(value = "/deleteAttached")
	public @ResponseBody Message deleteAttached(Integer id){
		return new SuccessMessage(templetService.deleteAttached(id));
	}
	
	/**
	 * 
	 * @Title:main 
	 * @Description: 
	 * TODO  
	 * @author baozj
	 * @param args 
	 * @throws
	 * @retrun void
	 */
	public static void main(String[] args) {
		System.out.println(JSON.toJSONString(ExecuteWayEnum.values(), SerializerFeature.QuoteFieldNames));
		System.out.println(JSON.toJSONString(ExecuteWayEnum.allValues()));
	}
}

