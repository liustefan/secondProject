/**
 * @PackageName:      com.bithealth.memberCore.facede.service
 * @FileName:     MemberInterfService.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      liuhm
 * @version      V1.0  
 * @Createdate:  2016年6月30日 上午10:20:33  
 * 
 */
package com.bithealth.memberCore.facede.service;

import java.util.List;

import com.bithealth.memberCore.enmu.DeviceEnum;
import com.bithealth.memberCore.enmu.MemberSource;
import com.bithealth.memberCore.exception.LoginException;
import com.bithealth.memberCore.member.model.MemAccount;
import com.bithealth.memberCore.member.model.Member;
import com.bithealth.memberCore.member.model.MemberExt;
import com.bithealth.memberCore.member.model.MemberMovment;
import com.bithealth.memberCore.member.model.MemberRegReponse;
import com.bithealth.memberCore.uc.bean.MemberRet;
import com.bithealth.memberCore.uc.bean.MergeResult;

/**
 * 类名称: MemberInterfService  
 * 功能描述: 会员对外接口.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年6月30日 上午10:20:33 
 * 
 * @author liuhm
 * @version  
 */
public interface MemberInterfService {
	
	/**
	 * 
	 * @Title:login 
	 * @Description:会员登录. 
	 * TODO(这里描述这个方法适用条件  执行流程  使用方法 注意事项– 可选).  
	 * @author liuhm
	 * @param member
	 * @return
	 * @throws LoginException 
	 * @param 
	 * @throws
	 * @retrun MemAccount
	 */
	MemAccount login(String account, String password, DeviceEnum device) throws LoginException;
	
	/**
	 * 
	 * @Title:logout 
	 * @Description:注销登录. 
	 * @author liuhm
	 * @param member 
	 * @param 
	 * @throws
	 * @retrun void
	 */
	void logout(MemAccount member); 
	
	/**
	 * 
	 * @Title:insertMember 
	 * @Description:批量会员注册. 注册会员，首先在业务端保存会员信息，初始UseTag为R,注册中。
	 * 异步注册数据，需要保存异步日志表memimportLog,注册时，UC异步返回错误，需要更新UseTag为E,同步是，删除该记录
	 * @author liuhm
	 * @param memberList
	 * @param async true为异步，false为同步。
	 * @return 
	 * @param 
	 * @throws
	 * @retrun MemberRegReponse
	 */
	MemberRegReponse insertMember(List<MemberExt> memberList, boolean async) throws Exception;
	
	/**
	 * 
	 * @Title:insertMember 
	 * @Description:同步新增单个会员. 
	 * @author liuhm
	 * @param member
	 * @return 
	 * @param 
	 * @throws
	 * @retrun MemberRet
	 */
	MemberRet regist(MemberExt member);
	
	/**
	 * 
	 * @Title:AppRegist
	 * @Description:(这里用一句话描述这个方法的作用). 
	 * @author liuhm
	 * @param member
	 * @param password
	 * @return 
	 * @param 
	 * @throws
	 * @retrun MemberRet
	 */
	MemberRet AppRegist(MemberExt member, String password);
	/**
	 * 
	 * @Title:updateMember 
	 * @Description:更新会员. 
	 * @author liuhm
	 * @param member
	 * @return 
	 * @param 
	 * @throws
	 * @retrun String
	 */
	String updateMember(MemberExt member);
	
	/**
	 *
	 * @Title:delete 
	 * @Description: 会员删除. 
	 * @author liuhm
	 * @param memberList
	 * @return 
	 * @param 
	 * @throws
	 * @retrun boolean
	 */
	boolean delete(List<Member> memberList) throws Exception ;
	
	
	/**
	 * 
	 * @Title:syncMember 
	 * @Description:会员从第三方同步过来. 
	 * @author liuhm
	 * @param memberList
	 * @return 
	 * @param 
	 * @throws
	 * @retrun MemberRegReponse
	 */
	MemberRegReponse syncMember(List<MemberExt> memberList, MemberSource source);
	
	/**
	 * 
	 * @Title:updatePassword 
	 * @Description:会员密码修改. 
	 * TODO(这里描述这个方法适用条件  执行流程  使用方法 注意事项– 可选).  
	 * @author liuhm
	 * @param memberId 会员Id
	 * @param newPwd 会员新密码 -- 密文
	 * @param oldPwd 会员旧密码 -- 密文
	 * @throws
	 * @retrun boolean
	 */
	public boolean updatePassword(Integer memberId, String newPwd, String oldPwd);
	
	/**
	 * 
	 * @Title:updatePasswordByTel 
	 * @Description:App端忘记密码，依据账号修改密码. 
	 * @author liuhm
	 * @param account
	 * @param pwd
	 * @return 
	 * @param 
	 * @throws
	 * @retrun boolean
	 */
	public boolean updatePasswordByTel(String tel, String pwd);
	
	/**
	 * 
	 * @Title:confirmMoveMember 
	 * @Description:确定转移会员. 
	 * @author liuhm
	 * @param movement
	 * @return 
	 * @param 
	 * @throws
	 * @retrun String
	 */
	public String updateMoveConfirm(MemberMovment movement, boolean hasConfirmByDoc);
	
	/**
	 * 
	 * @Title:merge 
	 * @Description:合并完善资料. 
	 * @author liuhm
	 * @param sourceGuid
	 * @param sourSrvId
	 * @param pwd源密码
	 * @param targetMember 包含身份证/姓名/手机号/GUID
	 * @return 
	 * @param 
	 * @throws
	 * @retrun MergeResult
	 */
	MergeResult merge(String sourceGuid, int sourSrvId, String sourceSessionID, String pwd,  Member targetMember);
	
	/**
	 * 
	 * @Title:perfectMember 
	 * @Description:后台注册会员在App端完善或者修改个人资料（姓名，身份证 )
	 * @author liuhm
	 * @param account
	 * @param memberName
	 * @param idcard
	 * @return 
	 * @param 
	 * @throws
	 * @retrun String
	 */
	public String perfectMember(String account, String memberName, String idcard);
	
	/**
	 * 
	 * @Title:isFromWeb 
	 * @Description:是否后台会员 
	 * @author liuhm
	 * @param memberGUID
	 * @return 
	 * @param 
	 * @throws
	 * @retrun boolean
	 */
	public boolean isFromWeb(String memberGUID);
	
}
