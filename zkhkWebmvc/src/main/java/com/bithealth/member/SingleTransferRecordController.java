package com.bithealth.member;

import java.util.Date;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bithealth.Message;
import com.bithealth.doctorCore.doctor.service.DoctorService;
import com.bithealth.memberCore.facede.service.TransferTreatFacedeService;
import com.bithealth.memberCore.member.model.TransferTreatment;
import com.bithealth.memberCore.member.service.TransferTreatmentService;
import com.bithealth.sdk.common.utils.TimeUtil;
import com.bithealth.sdk.core.feature.orm.mybatis.Page;
import com.bithealth.sdk.web.controller.BaseSpringController;

/**
 * 类名：SingleTransferRecordController
 * 描述：单一会员转诊记录
 * 
 * @author 作者:周玉飞
 * @version 创建时间：2016年12月20日 
 */
@Controller
@RequestMapping("/singleTransferTreatment")
public class SingleTransferRecordController extends BaseSpringController {
	
	@Resource
	private TransferTreatmentService transferTreatmentService;
	@Resource
	private DoctorService doctorService;
	@Autowired
	private TransferTreatFacedeService transferTreatFacedeService;
	
	@RequestMapping("/getTransferTreatRecord")
	public String getTransferTreatRecord(Page<TransferTreatment> page, TransferTreatment pojo, Model model){
		
		page.setPageNo(page.getPageNo());
		model.addAttribute("pojo", pojo);
		try {
			if (pojo.getEndUpdatetime()!=null  && !"".equals(pojo.getEndUpdatetime())) {
				String dateStr = TimeUtil.dateFormat.format(pojo.getEndUpdatetime()) + " 23:59:59";
					pojo.setEndUpdatetime(TimeUtil.parseDatetime2(dateStr));
			}
				} catch (Exception e) {
					e.printStackTrace();
			}
		if(pojo.getMemberid() != null)
			model.addAttribute("isMy", doctorService.isMyMember(getCurentUser().getId(), pojo.getMemberid(), getCurentUser().getDept_id()));
		else
			model.addAttribute("isMy", true);
		model.addAttribute("page", transferTreatFacedeService.selectByTransferTreatmentPage(page, pojo,getCurentUser().getId()));
		return "/member/singleTransferRecord/singleTransferTreatRecord";
	}
	
	//编辑转诊记录
	@RequestMapping("/editTransferTreat")
	public String editTransferTreat(Integer id,Integer memberid,Model model){
		TransferTreatment pojo= transferTreatFacedeService.selectTransferTreatmentById(id);
		if (pojo==null) {
			pojo=new TransferTreatment();
			if (pojo.getTreattime()==null) {
				pojo.setTreattime(new Date());
			}
			pojo.setMember(pojo.createMember());
			pojo.setMemberid(memberid);
			pojo.setUpdatetime(new Date());
			pojo.setCreateid(getCurentUser().getId());
			pojo.setCreateDrName(getCurentUser().getRealName());
		}
		pojo.setCreateDrName(doctorService.selectById(pojo.getCreateid()).getDocname());
		if (pojo.getUpdateid()!=null) {
			pojo.setUpdateDrName(doctorService.selectById(pojo.getUpdateid()).getDocname());
		}
		
		model.addAttribute("pojo", pojo);
		return "/member/singleTransferRecord/editSingleTransferTreat";
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

	//保存新增转诊记录
	@RequestMapping("/saveTransferTreat")
	public @ResponseBody Message saveTransferTreat(TransferTreatment pojo){
		TransferTreatment transferTreatment = transferTreatFacedeService.selectTransferTreatmentById(pojo.getTtreatmentid());
		pojo.setCreatetime(new Date());
		if (pojo.getTreattime()==null) {
			pojo.setTreattime(new Date());
		}
		if (transferTreatment!=null && transferTreatment.getCreateid()==null) {
			pojo.setCreateid(getCurentUser().getId());
			pojo.setCreateDrName(getCurentUser().getRealName());
			}
		if(transferTreatment!=null && transferTreatment.getCreateid()!=null){
			pojo.setCreateid(transferTreatment.getCreateid());
			pojo.setCreateDrName(doctorService.selectById(transferTreatment.getCreateid()).getDocname());
		}else{
			pojo.setCreateid(getCurentUser().getId());
			pojo.setCreateDrName(getCurentUser().getRealName());
		}
		pojo.setUpdatetime(new Date());
		if(transferTreatment!=null && transferTreatment.getUpdateid()!=null){
			pojo.setUpdateid(transferTreatment.getUpdateid());
			pojo.setUpdateDrName(doctorService.selectById(transferTreatment.getUpdateid()).getDocname());
		}
		pojo.setUpdateid(getCurentUser().getId());
		pojo.setUpdateDrName(getCurentUser().getRealName());
		
		if (transferTreatFacedeService.insertOrUpdateTransferTreatment(pojo)) {
			return new Message( "保存成功！",true);
		}else
			return new Message( "当前资料保存失败，请稍后重试！",false);
		
	}
	
}
