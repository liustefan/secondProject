 

package com.bithealth.centCore.facade.service;

import java.util.List;

import com.bithealth.centCore.care.model.CareInfo;
import com.bithealth.centCore.care.model.FamilyNews;
import com.bithealth.centCore.care.model.KindlyReminder;
import com.bithealth.centCore.care.model.KindlyReminderResult;
import com.bithealth.centCore.facade.model.MsgCenter;
import com.bithealth.centCore.facade.model.RelateAcount;
import com.bithealth.sdk.core.feature.orm.mybatis.Page;



/**
 * 类名称: CareIFService  
 * 功能描述: 关注模块对外接口
 * 日期: 2016年8月23日 下午3:20:01 
 * 
 * @author 谢美团
 * @version  
 */
public interface CareIFService  {
	
	/**
	 * @Title:selectMyCareList 
	 * @Description:获取我关注的人员列表 ,分页查询
	 * @author 谢美团
	 * @param memberId 会员id
	 * @param page 分页对象
	 * @return 
	 * @throws
	 * @retrun List<Care>
	 */ 
	public List<CareInfo> selectMyCareList(String memberGUID,int isGetNews,boolean isHttpsRequest) throws Exception;
	
	/**
	 * @Title:selectCareMeList 
	 * @Description:获取关注我的人列表   ,分页查询
	 * @author 谢美团
	 * @param memberId 会员id
	 * @param page 分页对象
	 * @return 
	 * @throws
	 * @retrun List<Care>
	 */ 
	public List<CareInfo> selectCareMeList(String memberGUID,boolean isHttpsRequest) throws Exception;
	

	
	/**
	 * @Title:selectMemberByParams 
	 * @Description:根据查询条件查询会员 
	 * @author 谢美团
	 * @param searchParam
	 * @param page
	 * @return 
	 * @throws
	 * @retrun List<Care>
	 */ 
	public List<CareInfo> selectMemberByParams(String searchParam,String memberGUID,boolean isHttpsRequest) throws Exception;

	
	
	/**
	 * @Title:addCare_trans 
	 * @Description:添加好友关注
	 * @author 谢美团
	 * @param CareInfo
	 * @return 
	 * @throws
	 * @retrun int
	 */ 
	public int addCare_trans(CareInfo careInfo);
	
	
	/**
	 * @Title:relateAcount_trans 
	 * @Description:通过关联账号来添加关注
	 * @author 谢美团
	 * @param relateAcount
	 * @return 
	 * @throws
	 * @retrun int
	 */ 
	public int relateAcount_trans(RelateAcount relateAcount) throws Exception;
	
	/**
	 * @Title:updateCare 
	 * @Description:修改关注信息，如取消关注修改关系等
	 * @author 谢美团
	 * @param careInfo
	 * @return 
	 * @throws
	 * @retrun int
	 */ 
	public int updateCare(CareInfo careInfo);
	
	
	
	/**
	 * @Title:getMyCareMessage 
	 * @Description:获取我发送的亲友关怀消息
	 * @author 谢美团
	 * @param kindlyReminders
	 * @return 
	 * @throws
	 * @retrun List<KindlyReminder>
	 */ 
	public List<KindlyReminder> getMyCareMessage(KindlyReminder kindlyReminders,Page<KindlyReminder> page) throws Exception;
	
	
	/**
	 * @Title:sendMsgToMyCare 
	 * @Description:发送测量数据消息或者公卫服务消息给关注我的人 
	 *	体检和随访的摘要格式中使用 (??) 代表发送者和接收者的关系。 
	 * @author 谢美团 
	 * @throws
	 * @retrun void
	 */ 
	public void sendMsgToCareMeMember(MsgCenter msgCenter) throws Exception;
	
	
	/**
	 * @Title:sendKindlyReminder 
	 * @Description:发送温馨提示
	 * @author 谢美团
	 * @param kindlyReminder 
	 * @throws
	 * @retrun void
	 */ 
	public void sendKindlyReminder_trans(KindlyReminder kindlyReminder) throws Exception;
	
	/**
	 * @Title:getmemberByGUID 
	 * @Description:根据GUID回去用户的服务地址等信息
	 * @author 谢美团
	 * @param memberGUID
	 * @return
	 * @throws Exception 
	 * @throws
	 * @retrun Care
	 */ 
	public CareInfo getmemberByGUID(String  memberGUID,boolean isHttpsRequest) throws Exception;
	
	/**
	 * @Title:batchDeleteKindlyReminder_trans 
	 * @Description:根据数据主键删除温馨提示
	 * @author 谢美团
	 * @param idList
	 * @return
	 * @throws Exception 
	 * @throws
	 * @retrun int
	 */ 
	public int batchDeleteKindlyReminder_trans(List<Integer> idList)throws Exception;
	
	
	/**
	 * @Title:getMyCareMemberNews 
	 * @Description:获取我关注的人的亲友动态列表
	 * @author 谢美团
	 * @param page
	 * @param memberGUID
	 * @return 
	 * @throws
	 * @retrun List<MessageCenter>
	 */ 
	List<FamilyNews> getMyCareMemberNews(Page<FamilyNews> page,String memberGUID,boolean isHttpsRequest);
	
	
	
	/**
	 * @Title:getMyKindlyReminder 
	 * @Description:获取我的温馨提示
	 * @author 谢美团
	 * @param page
	 * @param memberGUID
	 * @return 
	 * @throws
	 * @retrun List<KindlyReminder>
	 */ 
	List<KindlyReminderResult> toGetMyKindlyReminder_trans(Page<KindlyReminder> page,String memberGUID);
	
	
	/**
	 * @Title:MergeCareData 
	 * @Description:合并关注数据
	 * @author 谢美团
	 * @param sourceGUID
	 * @param targetGUID
	 * @return 
	 * @throws
	 * @retrun boolean
	 */ 
	public boolean MergeCareData(String sourceGUID ,String targetGUID);
	

}

