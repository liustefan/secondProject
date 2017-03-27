package com.bithealth.member;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bithealth.Message;
import com.bithealth.doctorCore.doctor.service.DoctorService;
import com.bithealth.memberCore.enmu.TransferTreatStatus;
import com.bithealth.memberCore.enmu.UseTag;
import com.bithealth.memberCore.facede.service.TransferTreatFacedeService;
import com.bithealth.memberCore.member.model.DiseasesHistoryExample;
import com.bithealth.memberCore.member.model.Member;
import com.bithealth.memberCore.member.model.MemberType;
import com.bithealth.memberCore.member.model.TransferTreatSearchCondtion;
import com.bithealth.memberCore.member.model.TransferTreatment;
import com.bithealth.memberCore.member.model.TransferTreatmentExample;
import com.bithealth.memberCore.member.model.TransferTreatmentExample.Criteria;
import com.bithealth.memberCore.member.service.DiseaseService;
import com.bithealth.memberCore.member.service.DiseasesHistoryService;
import com.bithealth.memberCore.member.service.MemberService;
import com.bithealth.memberCore.member.service.MemberTypeService;
import com.bithealth.memberCore.member.service.TransferTreatmentService;
import com.bithealth.memberCore.member.vo.TransferTreatAndMemVo;
import com.bithealth.memberCore.memberLabel.enmu.LabelStatus;
import com.bithealth.memberCore.memberLabel.faced.service.LabelFacedService;
import com.bithealth.memberCore.memberLabel.model.LabelItem;
import com.bithealth.memberCore.memberLabel.service.LabelService;
import com.bithealth.memberCore.memberLabel.service.MemberLabelItemService;
import com.bithealth.orgainCore.service.OrgService;
import com.bithealth.sdk.common.utils.TimeUtil;
import com.bithealth.sdk.core.feature.orm.mybatis.Page;
import com.bithealth.sdk.web.controller.BaseSpringController;
import com.bithealth.sdk.web.vo.ShiroUser;
/**
 * 类名：TransferTreatmentController 
 * 描述：转诊控控制层
 * 
 * @author 作者:周玉飞
 * @version 创建时间：2016年11月30日 下午2:24:40 类说明
 */
@Controller
@RequestMapping("/transferTreatment")
public class TransferTreatmentController extends BaseSpringController{
	@Resource
	private TransferTreatmentService transferTreatmentService;
	
	@Resource
	private DiseaseService diseaseService;
	
	@Resource
	private DoctorService doctorService;
	
	@Resource
	private MemberTypeService memberTypeService;
	
	@Resource
	private LabelFacedService labelFacedService;
	
	@Autowired
	private TransferTreatFacedeService transferTreatFacedeService;
	
	@Autowired
	private MemberService memberService;
	
	@Resource(name="diseasesHistoryService")
	protected DiseasesHistoryService diseasesHistoryService;
	
	@Autowired
	private LabelService labelService;
	
	@Autowired
	private MemberLabelItemService memberLabelService;
	
	@Resource(name="orgService")
	private OrgService orgService;
	
	@RequestMapping("/getTransferTreatRecord")
	public String getTransferTreatRecord(HttpServletRequest request,TransferTreatSearchCondtion condition, Page<TransferTreatAndMemVo> page){
		condition.setDocid(getCurentUser().getId());
		
		try {
			if(condition.getUpdateEndTime() != null && !"".equals(condition.getUpdateEndTime())){
				String dateStr = TimeUtil.dateFormat.format(condition.getUpdateEndTime()) + " 23:59:59";
				condition.setUpdateEndTime(TimeUtil.parseDatetime2(dateStr));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		page = transferTreatmentService.selectTransferTreatmentList(condition, page);
		
		List<TransferTreatAndMemVo> list = page.getResult();
		for(TransferTreatAndMemVo vo : list){
			vo.setTreatStatusName(TransferTreatStatus.getNameByCode(vo.getTreatstatus()));
			vo.setCreateDocName(doctorService.selectById(vo.getCreateid()).getDocname());
			if(vo.getUpdateid() != null){
				vo.setUpdateDocName(doctorService.selectById(vo.getUpdateid()).getDocname());
			}
		}
		
		request.setAttribute("disease", diseaseService.selectAll_cache());
		request.setAttribute("page", page);
		request.setAttribute("condition", condition);
		return "/member/transferTreatRecord";
	}
	
	@RequestMapping("/chooseMember")
	public String chooseMember(HttpServletRequest request, TransferTreatSearchCondtion condition, Page<TransferTreatAndMemVo> page){
		condition.setDocid(getCurentUser().getId());
		page.setPageNo(page.getPageNo());
		page.setTotalCount(-1);
		List<MemberType> memberType = memberTypeService.selectListByOrg(getCurentUser().getDept_id(), UseTag.T);
		if (StringUtils.isNotEmpty(condition.getMemName()) || StringUtils.isNotEmpty(condition.getTel()) || StringUtils.isNotEmpty(condition.getIdCard()) || 
		condition.getMemGrpId()>=0 || condition.getMemId()!=null && condition.getMemId()>=0  ||condition.getDisease_id()!=null&&condition.getDisease_id()>=0 || StringUtils.isNotEmpty(condition.getlItemID_list())) {
		page= transferTreatmentService.exProcTreatmentMemberList(condition, page);
		}
		request.setAttribute("page", page);
		request.setAttribute("memberType", memberType);
		request.setAttribute("disease", diseaseService.selectAll_cache());
		request.setAttribute("condition", condition);
		return "/member/chooseTransferTreatMember";
	}
	
	@RequestMapping("/chooseLabel")
	public String chooseLabel(HttpServletRequest request){
		List<LabelItem> sysLabel = labelFacedService.selectSysLabel(1);
		List<LabelItem> definedLabel = labelFacedService.selectDefinedLabel(getCurentUser().getId());

		request.setAttribute("sysLabel", sysLabel);
		request.setAttribute("definedLabel", definedLabel);
		return "/member/chooseLabel";
	}
	
	//选择会员将转诊信息带出
	@RequestMapping("/jumpTransferTreatPage/{memberid}")
	public String jumpEditTransferTreatPage(HttpServletRequest request, @PathVariable int memberid, String flag,Model model,TransferTreatAndMemVo transferTreatMemVo){
		ShiroUser user = getCurentUser();
		transferTreatMemVo = transferTreatmentService.selectOmemLabel(memberid,user.getId(),user.getDept_id());
			
		Member member = memberService.selectById(memberid);
		model.addAttribute("member", member);
		model.addAttribute("labels", transferTreatmentService.selectMemberLabels(memberid));
		DiseasesHistoryExample example = new DiseasesHistoryExample();
		example.createCriteria().andMemberidEqualTo(memberid);
		model.addAttribute("diseases", diseasesHistoryService.selectByExample(example));
		
		try {
			int age = 0;
			if(transferTreatMemVo.getBirthDate() != null){
				age = TimeUtil.getAge(transferTreatMemVo.getBirthDate());
			}
			request.setAttribute("age", age);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if("add".equals(flag)){
			
			String orgIds = orgService.selectAllSharedOrg(getCurentUser().getDept_id(), true);
			List<LabelItem> items = labelService.selectByDoc(getCurentUser().getId(), orgIds);
			List<LabelItem> itemList = memberLabelService.selectMemberLabelItems(LabelStatus.EFFECT, member.getMemberid(), items);
			request.setAttribute("labels", itemList);
			
			transferTreatMemVo.setMemberid(transferTreatMemVo.getMemberId());
			transferTreatMemVo.setCreateid(getCurentUser().getId());
			if (transferTreatMemVo.getTreattime()==null) {
				transferTreatMemVo.setTreattime(new Date());
			}
			transferTreatMemVo.setCreateDocName(doctorService.selectById(getCurentUser().getId()).getDocname());
			transferTreatMemVo.setUpdateDocName(doctorService.selectById(getCurentUser().getId()).getDocname());
			request.setAttribute("transferTreatMemVo", transferTreatMemVo);
			request.setAttribute("flag", flag);
			return "/member/addTransferTreat";
		}
		return flag;
	}
	
	@RequestMapping("/jumpTransferTreatPage")
	public String jumpEditTransferTreatPage(HttpServletRequest request, int memberId, int id, String flag){
		TransferTreatment pojo = transferTreatmentService.selectById(id);
		TransferTreatAndMemVo transferTreatMemVo = transferTreatmentService.selectTransferTreatmentAndMember(id,pojo.getCreateid());
		try {
			int age = 0;
			if(transferTreatMemVo.getBirthDate() != null){
				age = TimeUtil.getAge(transferTreatMemVo.getBirthDate());
			}
			request.setAttribute("age", age);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if("edit".equals(flag)){
			Member member = memberService.selectById(memberId);
			String orgIds = orgService.selectAllSharedOrg(getCurentUser().getDept_id(), true);
			List<LabelItem> items = labelService.selectByDoc(getCurentUser().getId(), orgIds);
			List<LabelItem> itemList = memberLabelService.selectMemberLabelItems(LabelStatus.EFFECT, member.getMemberid(), items);
			request.setAttribute("labels", itemList);
			
			
			transferTreatMemVo.setMemberid(transferTreatMemVo.getMemberId());
			transferTreatMemVo.setCreateDocName(doctorService.selectById(transferTreatMemVo.getCreateid()).getDocname());
			if(transferTreatMemVo.getUpdateid() != null){
				transferTreatMemVo.setUpdateDocName(doctorService.selectById(transferTreatMemVo.getUpdateid()).getDocname());
			}
			request.setAttribute("transferTreatMemVo", transferTreatMemVo);
			request.setAttribute("pojo", pojo);
			request.setAttribute("flag", flag);
			return "/member/editTransferTreat";
		}else if("scan".equals(flag)){
			
			Member member = memberService.selectById(memberId);
			String orgIds = orgService.selectAllSharedOrg(getCurentUser().getDept_id(), true);
			List<LabelItem> items = labelService.selectByDoc(getCurentUser().getId(), orgIds);
			List<LabelItem> itemList = memberLabelService.selectMemberLabelItems(LabelStatus.EFFECT, member.getMemberid(), items);
			request.setAttribute("labels", itemList);
			
			request.setAttribute("transferTreatMemVo", transferTreatMemVo);
			request.setAttribute("flag", flag);
			transferTreatMemVo.setCreateid(getCurentUser().getId());
			transferTreatMemVo.setCreateDocName(doctorService.selectById(getCurentUser().getId()).getDocname());
			transferTreatMemVo.setUpdateDocName(doctorService.selectById(getCurentUser().getId()).getDocname());
			return "/member/scanTransferTreat";
		}
		return flag;
	}
	
	@RequestMapping("/editTransferTreat")
	@ResponseBody
	public Message editTransferTreat(TransferTreatAndMemVo transferTreatAndMemVo){
		transferTreatAndMemVo.setUpdateid(getCurentUser().getId());
		transferTreatAndMemVo.setUpdatetime(new Date());
		try {
			TransferTreatmentExample example = new TransferTreatmentExample();
			Criteria criteria = example.createCriteria();
			criteria.andTtreatmentidEqualTo(transferTreatAndMemVo.getTtreatmentid());
			List<TransferTreatment> list = transferTreatmentService.selectTransferTreatmentBymemberId(transferTreatAndMemVo.getMemberid());
			int size = list.size();
			for(int i = 0; i < size; i ++) {
			  list.get(i); 
			if ((list.get(i).getTreatstatus()==1 && transferTreatAndMemVo.getTreatstatus()==1 && list.get(i).getTtreatmentid()!=transferTreatAndMemVo.getTtreatmentid())) {
				return new Message("此会员当前已开转诊单！",false);
				}
			}

			if(transferTreatmentService.updateByExampleSelective(transferTreatAndMemVo, example)>0){
				return new Message("保存成功！",true);
			}else{
				return new Message("当前资料保存失败，请稍后重试！", false);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new Message("当前资料保存失败，请稍后重试！", false);
		}
	}
	
	@RequestMapping("/addTransferTreat")
	@ResponseBody
	public Message addTransferTreat(TransferTreatAndMemVo transferTreatAndMemVo){
		transferTreatAndMemVo.setCreatetime(new Date());
		transferTreatAndMemVo.setUpdateid(getCurentUser().getId());
		transferTreatAndMemVo.setUpdatetime(new Date());
		if (transferTreatAndMemVo.getTreattime()==null) {
			transferTreatAndMemVo.setTreattime(new Date());
		}
		try {
			if(transferTreatmentService.insert(transferTreatAndMemVo)>0){
				return new Message("保存成功！",true);
			}else{
				return new Message("当前资料保存失败，请稍后重试！",false);
				}
			}catch (Exception e) {
			e.printStackTrace();
			return new Message("当前资料保存失败，请稍后重试！",false);
		}
		
	}
	
	@RequestMapping("/{ttreatmentid}/deleteTransferTreat")
	@ResponseBody
	public Message deleteTransferTreat(@PathVariable int ttreatmentid){
		try {
			if(transferTreatmentService.delete(ttreatmentid)>0){
				return new Message("删除成功！", true);
			}else{
				return new Message("删除失败！", false);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new Message("删除失败！", false);
		}
	}

	@RequestMapping("/checkMember")
	@ResponseBody
	public Message  checkMember(int memberid){
		
		ShiroUser user =getCurentUser();
		TransferTreatAndMemVo transferTreatMemVo = transferTreatmentService.selectOmemLabel(memberid,user.getId(),user.getDept_id());
		List<TransferTreatment> list = transferTreatmentService.selectTransferTreatmentBymemberId(transferTreatMemVo.getMemberId());
		int size = list.size();
		for(int i = 0; i < size; i ++) {
		  list.get(i);
		if (list.get(i).getTreatstatus()==1) {
			return new Message("此会员当前已开转诊单！",false);
			}
		}
		return null;
		}

}
	

