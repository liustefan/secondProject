package com.bithealth.ucCore.facade.service;

import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.bithealth.ucCore.uc.model.AppServer;
import com.bithealth.ucCore.uc.model.MemberAccount;
import com.bithealth.ucCore.uc.model.MemberBasicInfo;
import com.bithealth.ucCore.uc.model.RegisterResult;
import com.bithealth.ucCore.uc.model.ReturnObject;
import com.bithealth.ucCore.uc.result.MemberBase;



/**
 * 类名称: UCService  
 * 功能描述: UC对外接口
 * 日期: 2016年8月18日 上午11:39:21 
 * 
 * @author 谢美团
 * @version  
 */
public interface UCService{
	
	/**
	 * @Title:memberRegisterSync 
	 * @Description:基本资料和账号注册，同步处理
	 * @author 谢美团
	 * @param memberInfo
	 * @return
	 * @throws Exception 
	 * @throws
	 * @retrun List<RegisterResult>
	 */ 
	public List<RegisterResult> memberRegisterSync(List<MemberBasicInfo> memberInfoList,int serverId) throws Exception;
	
	/**
	 * @Title:memberRegisterAsyn 
	 * @Description:基本资料和账号注册，异步处理 
	 * @author 谢美团
	 * @param memberInfoList
	 * @throws Exception 
	 * @throws
	 * @retrun void
	 */ 
	public void memberRegisterAsyn(List<MemberBasicInfo> memberInfoList,int serverId) throws Exception;
	
	/**
	 * @Title:memberDelete 
	 * @Description:删除会员的基本资料和账号
	 * @author 谢美团
	 * @param memberInfoList
	 * @return
	 * @throws Exception 
	 * @throws
	 * @retrun List<RegisterResult>
	 */ 
	public List<RegisterResult> memberDelete(List<String> memberInfoList,int serverId) throws Exception;
	
	/**
	 * @Title:getRegisterResult 
	 * @Description:获取基本资料和账号注册结果
	 * @author 谢美团
	 * @param memberInfoList
	 * @return
	 * @throws Exception 
	 * @throws
	 * @retrun List<RegisterResult>
	 */ 
	public List<RegisterResult> getRegisterResult(List<String> guidList)throws Exception;
	
	
	/**
	 * @Title:getAddress 
	 * @Description:根据账号获取该账号所属的的确服务地址
	 * @author 谢美团
	 * @param account
	 * @param isHttps true返回https地址，默认http地址
	 * @return
	 * @throws Exception 
	 * @throws
	 * @retrun Return
	 */ 
	public ReturnObject getAddressByAccount(String account, boolean isHttps) throws Exception;
	
	/**
	 * @Title:getAddressByMemberID 
	 * @Description:根据会员ID获取该会员所属的的确的服务地址
	 * @author 谢美团
	 * @param memberID
	 * @return
	 * @throws Exception 
	 * @throws
	 * @retrun Return
	 */ 
	public ReturnObject getAddressByMemberIDs(List<String> memberIDList) throws Exception;
	
	
	/**
	 * @Title:verifyMemberBasicInfo 
	 * @Description:验证会员唯一性
	 *  1.通过身份证号确定唯一性，2通过手机号和姓名确定唯一性。
	 * @author 谢美团
	 * @param memberBasicInfo
	 * @return
	 * @throws Exception 
	 * @throws
	 * @retrun boolean
	 */ 
	public MemberBasicInfo verifyMemberBasicInfo(MemberBasicInfo memberBasicInfo)throws Exception;
	
	/**
	 * @Title:verifyMemberAccount 
	 * @Description:验证账号唯一性
	 * @author 谢美团
	 * @param account
	 * @return
	 * @throws Exception 
	 * @throws
	 * @retrun boolean
	 */ 
	public int verifyMemberAccount(MemberAccount memberAccount)throws Exception;
	
	
	
	/**
	 * @Title:getMemberBySearchParam 
	 * @Description:根据参数查询会员
	 * @author 谢美团
	 * @param searchParam
	 * @return
	 * @throws Exception 
	 * @throws
	 * @retrun ReturnObject
	 */ 
	public ReturnObject getMemberBySearchParam(String searchParam)throws Exception;
	
	

	/**
	 * @Title:updatePwd 
	 * @Description:密码更新 
	 * @author 谢美团
	 * @param objList
	 * @return 
	 * @throws
	 * @retrun List<JSONObject>
	 */ 
	public List<JSONObject> updatePwd(List<JSONObject> objList);
	
	
	/**
	 * @Title:getMemberByParamAccount 
	 * @Description:根据账号和密码获取会员的基本信息
	 * @author 谢美团
	 * @param account
	 * @param pwd
	 * @return
	 * @throws Exception 
	 * @throws
	 * @retrun ReturnObject
	 */ 
	public ReturnObject getMemberByAccountAndPwd(String account,String pwd)throws Exception;
	
	/**
	 * 
	 * @Title:selectMemberByDetail 
	 * @Description:根据姓名，身份证，手机号查找会员. 
	 * @author liuhm
	 * @param map
	 * @return 
	 * @param 
	 * @throws
	 * @retrun List<MemberBase>
	 */
	public List<MemberBase> selectMemberByDetail(String memberName, String idcard, String tel);
	
	/**
	 * 
	 * @Title:checkAccount 
	 * @Description:校验账号是否存在. 存在返回对应的AppServer
	 * @author liuhm
	 * @param account
	 * @return 
	 * @param 
	 * @throws
	 * @retrun AppServer
	 */
	public AppServer checkAccount(String account);
	
	/**
	 * @Title:appRegist 
	 * @Description:App会员注册. 
	 * @author liuhm
	 * @param list
	 * @param serverId
	 * @return 
	 * @param 
	 * @throws
	 * @retrun List<RegisterResult>
	 */
	public List<RegisterResult> registAppMember(List<MemberBasicInfo> list, int serverId);
	/**
	 * 
	 * @Title:changeTelByPwd 
	 * @Description:依据会员GUID和密码修改手机号. 如果该手机号已经被其他会员注册，那其他会员手机号账号清除，并且修改会员认证标识为未认证
	 * @author liuhm
	 * @param tel
	 * @param guid
	 * @param password
	 * @return 
	 * @param 
	 * @throws
	 * @retrun ReturnObject
	 */
	ReturnObject changeTelByPwd(String tel, String guid, String password);
	
	/**
	 * 
	 * @Title:getAppServer 
	 * @Description:依据ServerID获取AppServer. 
	 * @author liuhm
	 * @param serverId
	 * @return 
	 * @param 
	 * @throws
	 * @retrun List<AppServer>
	 */
	public List<AppServer> getAppServer(String serverIds);
}



