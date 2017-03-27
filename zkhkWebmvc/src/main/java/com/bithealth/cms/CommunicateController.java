package com.bithealth.cms;

import java.io.File;
import java.io.FileInputStream;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.time.DateUtils;
import org.apache.ibatis.annotations.Param;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bithealth.BaseWebController;
import com.bithealth.Message;
import com.bithealth.SuccessMessage;
import com.bithealth.chatCore.facade.service.ChatMessageFacadeService;
import com.bithealth.chatCore.model.ChatMessage;
import com.bithealth.chatCore.model.ChatMessageExample;
import com.bithealth.chatCore.service.ChatMessageService;
import com.bithealth.doctorCore.doctor.service.DoctorService;
import com.bithealth.fileCore.util.FileOperateUtil;
import com.bithealth.memberCore.member.service.MemberService;
import com.bithealth.reportCore.report.model.MemberChat;
import com.bithealth.reportCore.report.model.MemberChatExample;
import com.bithealth.reportCore.report.service.MemberChatService;
import com.bithealth.sdk.common.Env;
import com.bithealth.sdk.config.KDConfig;
import com.bithealth.sdk.core.feature.orm.mybatis.Page;
import com.bithealth.sdk.web.controller.BaseSpringController;
import com.bithealth.sdk.web.vo.ShiroUser;

/**
 * 类名：CommunicateController
 * 描述：互动交流
 * 
 * @author 作者:周玉飞
 * @version 创建时间：2016年9月6日 下午2:18:40 
 */

@Controller
@RequestMapping(value = "/communicate")
public class CommunicateController extends BaseWebController{
	@Autowired
	MemberChatService memberChatService;
	@Autowired
	ChatMessageService chatMessageService;

	@RequestMapping("/listCommunicate")
	public String listCommunicate(Page<MemberChat> page,MemberChatExample memChat, Model model,MemberChat pojo){
		page.setPageNo(page.getPageNo());
		model.addAttribute("memChat", memChat);
		model.addAttribute("pojo", pojo);
		ShiroUser user = getCurentUser();
		memChat.setSender(user.getId());
		memChat.setReceiver(user.getId());
		if (memChat.getDateTo()!=null) {
			memChat.setEndDate(DateUtils.addDays(memChat.getDateTo(),1));
		}
		memberChatService.selectByExampleAndPage(page, memChat);
		model.addAttribute("page", page);
		
		return "/msgCenter/communicate";
		
	}
	
	@RequestMapping("/viewDetailJsonPage")
	public @ResponseBody Message viewDetailJsonPage(Integer sId, Integer rId,Page<ChatMessage> page){
		chatMessageService.selectByChatCode(page, sId, rId);
		page.setPageNo(page.getPageNo());
		return new SuccessMessage(page);
	}
		
	//将amr转换成mp3
	@RequestMapping("/getaudio")
	public void amrToMP3(String uniqueId, HttpServletResponse response){
		if (ObjectId.isValid(uniqueId) /*&& uniqueId.endsWith(".amr")*/) { 
	 
			KDConfig kdConfig = Env.getBean("rdConfig"); 
	    	String filepath =kdConfig.getProperty("www.attached.root") + uniqueId ;  
	    	
	    	 String amrfile  =   uniqueId +".amr" ; 
	    	 String  mp3file =   uniqueId+".mp3";

	    	 //检查目录
	    	File uploadDir = new File(filepath);
	    	if(!uploadDir.exists())
	    		uploadDir.mkdirs();
	    	
	    	File source  = null;
			 
			 try {
				 byte[] amrfilebyte = super.getMongodbfile(uniqueId);
 				   source  =FileOperateUtil.getFile(amrfilebyte, filepath,amrfile);
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				 File targeFile = new File(filepath+"/"+mp3file);
				 FileOperateUtil.convertVoice(source, targeFile);
				
				FileInputStream fileInput = new FileInputStream(filepath+"/"+mp3file);
				int i = fileInput.available();
				byte[] content = new byte[i];
				fileInput.read(content);
  
				response.setHeader("Content-Type","Mime-type");
				ServletOutputStream outputStream = response.getOutputStream();
				 
				outputStream.write(content);
				outputStream.flush();
				fileInput.close();
				outputStream.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
	}
	
}
