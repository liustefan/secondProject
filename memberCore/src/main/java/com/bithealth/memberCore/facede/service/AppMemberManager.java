/**
 * @PackageName:      com.bithealth.memberCore.facede.service
 * @FileName:     AppMemberManager.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      liuhm
 * @version      V1.0  
 * @Createdate:  2016年12月9日 上午10:34:51  
 * 
 */
package com.bithealth.memberCore.facede.service;

import com.bithealth.memberCore.uc.bean.AppServer;
import com.bithealth.memberCore.uc.bean.CheckResult;
import com.bithealth.sdk.core.exception.BusinessException;

/**
 * 类名称: AppMemberManager  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年12月9日 上午10:34:51 
 * 
 * @author liuhm
 * @version  
 */
public interface AppMemberManager {
	
	/**
	 * 
	 * @Title:checkMerge 
	 * @Description:校验是否存在合并的会员. 
	 * @author liuhm
	 * @param idcard
	 * @param tel
	 * @param name
	 * @return 
	 * @param 
	 * @throws
	 * @retrun CheckResult
	 */
	public CheckResult checkMerge(String idcard, String tel, String name);
	
	/**
	 * 
	 * @Title:checkAccount 
	 * @Description:调用UC校验账号是否存在
	 * @author liuhm
	 * @param account
	 * @return 
	 * @param 
	 * @throws
	 * @retrun AppServer null时，说明不存在
	 */
	public AppServer checkAccount(String account) throws Exception;
	
	/**
	 * 
	 * @Title:changeTelByPwd 
	 * @Description:更换已认证的手机. 
	 * @author liuhm
	 * @param tel
	 * @param account
	 * @param pwd
	 * @return 
	 * @param 
	 * @throws
	 * @retrun boolean
	 */
	public boolean changeTelByPwd(String tel, String account, String pwd) throws BusinessException;
	
	/**
	 * 
	 * @Title:verifyTel 
	 * @Description:未认证的会员首次登录需要认证手机号. 
	 * @author liuhm
	 * @param tel
	 * @param account
	 * @return 
	 * @param 
	 * @throws
	 * @retrun boolean
	 */
	public boolean verifyTel(String tel, String account);
	
	/**
	 * 
	 * @Title:deleteSourceMemberAfterMerge 
	 * @Description:合并成功后，删除原始的会员. 
	 * @author liuhm
	 * @param memberGUID
	 * @return 
	 * @param 
	 * @throws
	 * @retrun int
	 */
	public int deleteSourceMemberAfterMerge(String memberGUID);
}
