package com.bithealth.packag;


import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bithealth.memberCore.member.model.Member;
import com.bithealth.memberCore.member.service.MemberService;
import com.bithealth.packagCore.facade.constants.PackageConstants;
import com.bithealth.packagCore.facade.service.PackagIFService;
import com.bithealth.packagCore.packag.model.MemBerPackagTemplate;
import com.bithealth.packagCore.packag.model.MemberPackag;
import com.bithealth.packagCore.packag.model.MemberPackagExample;
import com.bithealth.packagCore.packag.model.Packag;
import com.bithealth.packagCore.packag.model.PackagExample;
import com.bithealth.packagCore.packag.service.MemBerPackagTemplateService;
import com.bithealth.packagCore.packag.service.MemberPackagService;
import com.bithealth.packagCore.packag.service.PackagService;
import com.bithealth.reportCore.facade.service.ReportIFService;
import com.bithealth.reportCore.template.model.SummaryTemplate;
import com.bithealth.reportCore.template.model.SummaryTemplateExample;
import com.bithealth.reportCore.template.service.SummaryTemplateService;
import com.bithealth.sdk.core.feature.orm.mybatis.Page;
import com.bithealth.sdk.web.controller.BaseSpringController;
import com.bithealth.sdk.web.vo.ShiroUser;


@Controller
@RequestMapping(value = "/package")
public class PackageController extends BaseSpringController {

    @Resource
    private ReportIFService reportIFService;
    
    @Resource
    PackagService packagService;
    
    @Resource
    PackagIFService  packagIFService;
    @Resource
    SummaryTemplateService summaryTemplateService;
    @Resource
    MemBerPackagTemplateService memPackageDetailService;
    @Resource
    MemberPackagService memberPackagService;
    @Resource
    MemberService memberService;
    
    
    
    private static Logger logger=Logger.getLogger(PackageController.class);

   
    /**
     * @Title:getPackageList 
     * @Description:获取组织下个的所有套餐
     * @author 谢美团
     * @param model
     * @param request
     * @return 
     * @throws
     * @retrun String
     */ 
    @RequestMapping(value = "/getPackageList")
    public String getPackageList(ModelMap model,HttpServletRequest request,String msg) {
    	ShiroUser shiroUser =(ShiroUser)request.getSession().getAttribute("userInfo");
    	PackagExample example = new PackagExample();
    	example.createCriteria().andUseTagEqualTo("T").andOrgIdEqualTo(shiroUser.getDept_id());
    	List<Packag>  packagList = packagService.selectByExample(example);
    	model.put("packagList", packagList);
    	if(msg != null){
    		model.put("msg", "服务套餐已发布，不能删除");
    	}
        return "/package/packageList";
    }
   
    /**
     * @Title:toPackageEditPage 
     * @Description:跳转到套餐新增或编辑页面
     * @author 谢美团
     * @param model
     * @param request
     * @param page
     * @param packageCode
     * @return 
     * @throws
     * @retrun String
     */ 
    @RequestMapping(value = "/toPackageEditPage")
    public String toPackageEditPage(ModelMap model,HttpServletRequest request,Page<Packag> page,String packageCode,String msg) {
    	ShiroUser shiroUser =(ShiroUser)request.getSession().getAttribute("userInfo");
    	Packag packag = new Packag();
    	if(packageCode != null && !"".equals(packageCode)){ //修改套餐
        	Packag packagParams = new Packag();
        	packagParams.setPackageCode(Integer.parseInt(packageCode));
        	//获取套餐信息及其关联的明细
        	List<Packag>  packagList = packagIFService.selectPackagListByParams(page, packagParams, true);
        	if(packagList.size() > 0 ){
        		packag = packagList.get(0);
        	}
        	model.put("flag", "update");
    	}else{//新增套餐
    		packag.setCreateName(shiroUser.getRealName());
    		model.put("flag", "add");
    	}
    	//获取组织下的汇总模板列表
    	SummaryTemplateExample example = new SummaryTemplateExample();
    	example.createCriteria().andValiTagEqualTo("T").andOrgIdEqualTo(shiroUser.getDept_id());
    	List<SummaryTemplate> templateList = summaryTemplateService.selectByExample(example);
    	//组装模板的下拉选项字符串
    	StringBuffer optionBuf = new StringBuffer();
    	optionBuf.append("<option value='0'>请选择</option>");
    	for(SummaryTemplate temp:templateList){
    		optionBuf.append("<option value='"+temp.getSumRepTempCode()+"'>"+temp.getTempName()+"</option>");
    	}
    	model.put("packag", packag);
    	model.put("templateList", templateList);
    	model.put("option", optionBuf.toString());
    	if(msg != null){
    		model.put("msg", "服务套餐已发布，禁止修改");	
    	}
        return "/package/packageAddOrEdit";
    }
    
    /**
     * @Title:verifyPackageName 
     * @Description:验证套餐名称是否可用 
     * @author 谢美团
     * @param request
     * @param packageName
     * @return 
     * @throws
     * @retrun String
     */ 
    @ResponseBody
    @RequestMapping(value = "/verifyPackageName")
    public String verifyPackageName(HttpServletRequest request,String packageName) {
    	ShiroUser shiroUser =(ShiroUser)request.getSession().getAttribute("userInfo");
    	PackagExample example = new PackagExample();
    	example.createCriteria().andUseTagEqualTo("T").andOrgIdEqualTo(shiroUser.getDept_id()).andPackageNameEqualTo(packageName);
    	List<Packag>  packageLsit = packagService.selectByExample(example);
    	if(packageLsit != null &&  packageLsit.size() == 0){
    		return "OK";
    	}else{
    		return null;
    	}
    }
    
    /**
     * @Title:saveOrUpdatePackage 
     * @Description:保存套餐信息
     * @author 谢美团
     * @param model
     * @param packag
     * @return 
     * @throws
     * @retrun String
     */ 
    @RequestMapping(value = "/saveOrUpdatePackage")
    public String saveOrUpdatePackage(HttpServletRequest request,Packag packag) {
    	ShiroUser shiroUser =(ShiroUser)request.getSession().getAttribute("userInfo");
    	packag.setCreateid(shiroUser.getId());
    	packag.setCreateTime(new Date());
    	packag.setOrgId(shiroUser.getDept_id());
    	if(packag.getPackageCode() == null || packag.getPackageCode() == 0){ //新增套餐及其明细
    		 packagIFService.insertPackagAndDetail(packag);
    	}else{//修改套餐及其明细
    		int result = packagIFService.updatePackag(packag);
    		if(result == -1){
    			return "redirect:/package/toPackageEditPage?packageCode="+packag.getPackageCode()+"&msg=canNotModigy";
    		}
    	}
    	return "redirect:/package/getPackageList?";
    }
    
    
    /**
     * @Title:deletePackage 
     * @Description:删除套餐
     * @author 谢美团
     * @param model
     * @param packag
     * @return 
     * @throws
     * @retrun String
     */ 
    @RequestMapping(value = "/deletePackage")
    public String deletePackage(ModelMap model,Packag packag) {
    	int result = packagIFService.deletePackag(packag);
		if(result == -1){ //套餐已发布不能删除
			return "redirect:/package/getPackageList?msg=canNotdelete";
		}else{
			return "redirect:/package/getPackageList?";
		}
		
    }
    
    
    /**
     * @Title:getMemberPackageList 
     * @Description:获取会员的套餐订购列表
     * @author 谢美团
     * @param model
     * @param memberPackag
     * @return 
     * @throws
     * @retrun String
     */ 
    @RequestMapping(value = "/getMemberPackageList")
    public String getMemberPackageList(ModelMap model,MemberPackag memberPackag, Integer memberid) {
    	Page<MemberPackag> page = new Page<MemberPackag>();
    	List<MemberPackag>  memPackageList = packagIFService.selectMemberPackagListByParams(page, memberPackag);
    	Member member = memberService.selectById(memberid);
    	model.put("memPackageList", memPackageList);
    	model.put("memberPackag", memberPackag);
    	model.put("member", member);
    	return "/package/memberPackageList";
		
    }
    
    /**
     * @Title:toAddMemberPackagePage 
     * @Description:跳转到会员新增套餐页面
     * @author 谢美团
     * @param model
     * @param memberPackag
     * @return 
     * @throws
     * @retrun String
     */ 
    @RequestMapping(value = "/toAddMemberPackagePage")
    public String toAddMemberPackagePage(ModelMap model,MemberPackag memberPackag) {
    	ShiroUser shiroUser =  getCurentUser();
    	PackagExample example = new PackagExample();
    	example.createCriteria().andUseTagEqualTo("T").andOrgIdEqualTo(shiroUser.getDept_id());
    	List<Packag>  packagList = packagService.selectByExample(example);
    	model.put("packagList", packagList);
    	model.put("pageType", "add");
    	model.put("memberPackag", memberPackag);
    	return "/package/memberPackageEidt";
    }
    
    /**
     * @Title:saveMemberPackagePage 
     * @Description:给会员新增套餐
     * @author 谢美团
     * @param model
     * @param memberPackag
     * @return 
     * @throws
     * @retrun String
     */ 
    @RequestMapping(value = "/saveOrUpdateMemberPackage")
    public String saveMemberPackage(ModelMap model,MemberPackag memberPackag,String type) {
    	String result = "";
    	if("add".equals(type)){
    		result= packagIFService.insertMemberPackag(memberPackag);
    	}else{
    		result = packagIFService.updateMemberPackag(memberPackag);
    	}
    	
    	if(PackageConstants.SUCCESS.equals(result)){
        	model.put("packagList", "");
        	return "redirect:/package/getMemberPackageList?memberid="+memberPackag.getMemberid();
    	}else{
			model.put("err_msg",result);
			return "/notice";
    	}
    }
    
    
    /**
     * @Title:deleteMemberPackagePage 
     * @Description:删除会员订购的套餐 
     * @author 谢美团
     * @param model
     * @param memberPackag
     * @return 
     * @throws
     * @retrun String
     */ 
    @RequestMapping(value = "/deleteMemberPackage")
    public String deleteMemberPackage(ModelMap model,MemberPackag memberPackag) {
    	String result = packagIFService.deleteMemberPackag(memberPackag);
    	if(PackageConstants.SUCCESS.equals(result)){
        	return "redirect:/package/getMemberPackageList?memberid="+memberPackag.getMemberid();
    	}else{
			model.put("err_msg",result);
			return "/notice";
    	}
    }
    
    
    
    @RequestMapping(value = "/toEidtMemberPackagePage")
    public String toEidtMemberPackagePage(ModelMap model,MemberPackag memberPackag) {
    	ShiroUser shiroUser =  getCurentUser();
    	PackagExample example = new PackagExample();
    	example.createCriteria().andUseTagEqualTo("T").andOrgIdEqualTo(shiroUser.getDept_id());
    	List<Packag>  packagList = packagService.selectByExample(example);
    	model.put("packagList", packagList);
    	model.put("pageType", "eidt");
    	//获取修改的套餐的相关数据
    	MemberPackagExample memberPackagExample = new MemberPackagExample();
    	memberPackagExample.createCriteria().andMemberidEqualTo(memberPackag.getMemberid()).andLineNumEqualTo(memberPackag.getLineNum());
    	List<MemberPackag> memberPackagList = memberPackagService.selectByExample(memberPackagExample);
    	if(memberPackagList != null && memberPackagList.size() > 0){
    		memberPackag = memberPackagList.get(0);
    	}
    	model.put("memberPackag", memberPackag);
    	return "/package/memberPackageEidt";
    }

    
    /**
     * @Title:getMemberPackageDetail 
     * @Description:获取会员订购套餐的明细
     * @author 谢美团
     * @param model
     * @param memBerPackagTemplate
     * @return 
     * @throws
     * @retrun String
     */ 
    @RequestMapping(value = "/getMemberPackageDetail")
    public String getMemberPackageDetail(ModelMap model,MemBerPackagTemplate memBerPackagTemplate) {
    	List<MemBerPackagTemplate> lsit = memPackageDetailService.selectMemPackageDetailList(memBerPackagTemplate);
    	model.put("detailList", lsit);
    	return "/package/memberPackageDetail";
    	
    }
    
    

    
}
