package com.bithealth.dataConversionServer.serviceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bithealth.dataConversionServer.bean.ZUserInfo;
import com.bithealth.dataConversionServer.dao.DataFileRelationMapper;
import com.bithealth.dataConversionServer.dao.RelationFailDataMapper;
import com.bithealth.dataConversionServer.enmu.CompanyConfigEnmu;
import com.bithealth.dataConversionServer.enmu.EducationStatusEnmu;
import com.bithealth.dataConversionServer.enmu.MarrayStatusEnmu;
import com.bithealth.dataConversionServer.model.DataFileRelation;
import com.bithealth.dataConversionServer.model.DataFileRelationExample;
import com.bithealth.dataConversionServer.model.OrgidBean;
import com.bithealth.dataConversionServer.model.RelationFailData;
import com.bithealth.dataConversionServer.service.DataTransferService;
import com.bithealth.dataConversionServer.util.Constants;
import com.bithealth.dataConversionServer.util.RandomUtil;
import com.bithealth.dataConversionServer.util.StringUtil;
import com.bithealth.dataConversionServer.util.SystemUtils;
import com.bithealth.dataConversionServer.util.TimeUtil;
import com.bithealth.memberCore.enmu.MemberSource;
import com.bithealth.memberCore.facede.service.MemberInterfService;
import com.bithealth.memberCore.group.model.MemberGroup;
import com.bithealth.memberCore.member.model.DiseasesHistory;
import com.bithealth.memberCore.member.model.LinkMan;
import com.bithealth.memberCore.member.model.MemAccount;
import com.bithealth.memberCore.member.model.MemRelation;
import com.bithealth.memberCore.member.model.MemberExt;
import com.bithealth.memberCore.member.model.MemberRegReponse;
import com.bithealth.memberCore.uc.bean.MemberRet;
import com.bithealth.sdk.core.generic.GenericBaseDao;
import com.bithealth.sdk.core.generic.GenericBaseServiceImpl;






@Service("dataTransferService")
public class DataTransferServiceImpl  extends GenericBaseServiceImpl<DataFileRelation,DataFileRelationExample, Long> implements DataTransferService {
	
	private static Logger logger=Logger.getLogger(DataTransferServiceImpl.class);
    @Autowired
    DataFileRelationMapper  dataFileRelationMapper;
    @Autowired
    RelationFailDataMapper relationFailDataMapper;
    @Autowired
    MemberInterfService memberInterfService;



    /** 
     * @Title: selectUserData 
     * @Description: 获取备份的用户信息
     * @param dataId
     * @throws Exception    
     * @retrun List<DataFileRelation>
     */
	public List<DataFileRelation> queryUserData(DataFileRelation dataFileRelation) {
		return dataFileRelationMapper.queryUserData(dataFileRelation);
	}


	 /** 
		 * @Title: updataFileRelation 
		 * @Description:更新 文件关联表 
		 * @param relation
		 * @return    
		 * @retrun int
		 */
		public int updataFileRelation(DataFileRelation relation){
			return dataFileRelationMapper.updataFileRelation(relation);
		}
		
		
		public void saveMember(List<ZUserInfo> userList,List<OrgidBean> orgidList,String DataId,CompanyConfigEnmu compayEnmu){
		
			int maxNum = Integer.parseInt(SystemUtils.getValue(Constants.HKEJ_REGISTER_MAX).trim());
			List<MemberExt> memberList = new ArrayList<MemberExt>();
			for(ZUserInfo zUserInfo:userList){
				if(null == zUserInfo.getDSfzh() || "".equals(zUserInfo.getDSfzh())){//身份证号为空，不进行入库
					continue;
				}
			
				MemberExt memberExt=convertToMemberExts(zUserInfo,compayEnmu);
				
				String idCard=memberExt.getIdcard();
				idCard=idCard.substring(0, idCard.length()-1)+"6";
				System.out.println("====2:idCard2:=="+idCard);
				memberExt.setIdcard(idCard);
			//TODO ,添加会员账号
			List<MemAccount> listAccount = new ArrayList<MemAccount>();
				MemAccount memAcount =new MemAccount();
				memAcount.setAccount(idCard);
				memAcount.setMemberid(memberExt.getMemberid());
				memAcount.setAccounttype(Byte.valueOf("3"));
				listAccount.add(memAcount);
			memberExt.setAccountList(listAccount);
			
			
				for(OrgidBean orgidBean:orgidList){
					if(orgidBean.getMemGrpIds() == null || orgidBean.getMemGrpIds().equals("")){
						logger.error("村级prgid未配置组织和会员分组，解析终止。");
						return;
					}
					if(isEquals(zUserInfo.getPRgid(),orgidBean.getPRgid())){
						memberExt.setOrgid(orgidBean.getOrgid());
						List<MemberGroup> listGroup = new ArrayList<MemberGroup>();
						String[] Strgripids=orgidBean.getMemGrpIds().split(",");
						for(String grpid:Strgripids){
							MemberGroup grop = new MemberGroup();
							grop.setMemgrpid(Integer.parseInt(grpid));
							listGroup.add(grop);
						}
						memberExt.setMemberGroupList(listGroup);
						break;
					}
				}
//				omems.add(tempMemBer);
//				if(omems.size() == (maxNum==0?100:maxNum)){
//					regiester(omems,dataId);
//					omems.removeAll(omems);
//				}
				memberList.add(memberExt);
			}
		
			MemberRegReponse repose=memberInterfService.syncMember(memberList,MemberSource.ZLJY);
			List<MemberRet> listFail=repose.getErrorList();//保存失败的用户
			List<MemberRet> listSuc=repose.getSuccessList();//保存成功的用户
			List<MemberRet> listExi=repose.getExistsList();//已经注册的用户
			List<RelationFailData> failDataList = new ArrayList<RelationFailData>();
			for(MemberRet memRet:listFail){
				RelationFailData failData = new RelationFailData();
				failData.setIdcard(memRet.getMember().getIdcard());
				failData.setUniqueid(memRet.getMember().getUniqueId());
				failData.setDataid(DataId);
				failData.setMsg(memRet.getMessage());
				failDataList.add(failData);
				
			}
			if(failDataList.size() > 0){
				relationFailDataMapper.insertBatch(failDataList);
			}
			
		} 
		
		/** 
		 * @Title: convertToOmemBean 
		 * @Description: 将中联佳裕字段数据转成我方字段数据 
		 * @param zUserInfo
		 * @return
		 * @retrun OmemBean
		 */
		
		private MemberExt convertToMemberExts(ZUserInfo u,CompanyConfigEnmu compayEnmu){
			MemberExt  m  = new MemberExt();
			m.setMemberid(u.getMemberid());
			m.setLogname(String.valueOf(RandomUtil.getRandomPwd(5)));
			m.setMemname(u.getDXm());
			if(!u.getDXb().equals("1") && !u.getDXb().equals("2")){
			     m.setGender("3");
			}else{
			     m.setGender(u.getDXb());
			}
			m.setSource(compayEnmu.getSource());
			m.setBirthdate(TimeUtil.parseDate(u.getDCsrq()));
			m.setUsetag("T");
			m.setTel(u.getDLxdh());
			m.setEmail(u.getDEmail());
			m.setIdcard(u.getDSfzh());
			m.setAddress(u.getDXxdz());
			m.setMarrystatus(MarrayStatusEnmu.getValueByIndex(u.getDHyzk()));// 婚姻状况：1未婚；2已婚；3初婚；4再婚；5复婚；6丧偶；7离异；8未说明的婚姻状况
			m.setEducationstatus(EducationStatusEnmu.getValueByIndex(u.getDWhcd()));
			m.setOccupation(u.getDZy()); 
			m.setUniqueId(u.getDGrdabh());
			m.setCreatetime(new Date());
			m.setAddress(u.getDXxdz());
			
			MemRelation r = new MemRelation();
			r.setUniqueId(u.getDGrdabh());
			r.setLogogram(u.getDPyjm());
			r.setRelation(StringUtil.parseInt(u.getDYhzgx()));
			r.setCompany(u.getDGzdw());
			r.setProvince(u.getDSheng());
			r.setCity(u.getDShi());
			r.setArea(u.getDQu());
			r.setVillage(u.getDJd());
			r.setNeighborhoodCommittee(u.getDJwh());
			r.setLiveStatus(Integer.parseInt(u.getDJzzk()));
			r.setMedicalAccount(u.getDYlbxh());
			r.setPayType(StringUtil.parseInt(u.getDYlfzflx()));
			r.setAgroAccount(u.getDXnhh());		
			r.setSurveyTime(TimeUtil.parseDate(u.getHappentime()));
			r.setFetationStatus(StringUtil.parseInt(u.getLhyqk()));
			r.setCertificateType(StringUtil.parseInt(u.getDZjlx()));
			r.setFileType(StringUtil.parseInt(u.getDDalb()));
			r.setFileStatus(StringUtil.parseInt(u.getDDazt()));	
			r.setPrgid(u.getPRgid());
			r.setOtherPay(u.getDJtdabh());
			r.setBelongArea(u.getDSspq());
			r.setFamilyCode(u.getDYlfzflxqt());
			r.setFileStatusDesc(StringUtil.parseInt(u.getDDaztyy()));		
			r.setNation(u.getDMz());
			m.setRelation(r);
			
			if(!"".equals(u.getDLxrxm()) || !"无".equals(u.getDLxrxm()) ||!"没有".equals(u.getDLxrxm())){
				LinkMan linkMan = new LinkMan();
				List<LinkMan> listLinkMan = new ArrayList<LinkMan>();
				linkMan.setContactmobphone(u.getDLxrdh());
				linkMan.setContactname(u.getDLxrxm());
				listLinkMan.add(linkMan);
				m.setLinkmanList(listLinkMan);//联系人
			}
			// 病例史
			List<DiseasesHistory> diseaseList = new ArrayList<DiseasesHistory>();
			if("是".equals(u.getIsGxy())){//是否高血压
				DiseasesHistory d1  = new DiseasesHistory();
				d1.setDiseasename("高血压");
				d1.setDiseaseid(1);
				diseaseList.add(d1);
			}
			if("是".equals(u.getIsTnb())){//是否糖尿病
//				diseaseList.add(new DiseasesHistory(2,"糖尿病"));
				DiseasesHistory d2  = new DiseasesHistory();
				d2.setDiseasename("糖尿病");
				d2.setDiseaseid(2);
				diseaseList.add(d2);
			}
			if("是".equals(u.getIsGxb())){//是否冠心病
//				diseaseList.add(new DiseasesHistory(3,"冠心病"));
				DiseasesHistory d3  = new DiseasesHistory();
				d3.setDiseasename("冠心病");
				d3.setDiseaseid(3);
				diseaseList.add(d3);
			}
			if("是".equals(u.getIsNzz())){//是否脑卒中
//				diseaseList.add(new DiseasesHistory(4,"脑卒中"));
				DiseasesHistory d4  = new DiseasesHistory();
				d4.setDiseasename("脑卒中");
				d4.setDiseaseid(4);
				diseaseList.add(d4);
			}
			m.setDiseasesHistoryList(diseaseList);
			
			return m;
		}


		public List<OrgidBean> getOrgidList(List<ZUserInfo> userlist) {
			return dataFileRelationMapper.getOrgidList(userlist);
		}


		@Override
		public GenericBaseDao<DataFileRelation,DataFileRelationExample, Long> getDao() {
			return dataFileRelationMapper;
		}


		/**
		 * 比较是否为同一值，其中某个为空时，为不等
		 * @param arg1
		 * @param arg2
		 * @return
		 */
		private boolean isEquals(String arg1, String arg2){
			if(StringUtil.isEmpty(arg1) || StringUtil.isEmpty(arg2)){
				return false;
			}
			return arg1.trim().equals(arg2);
		}
		
		
		
		/** 
	   	 * @Title: saveFailFileRelation 
	   	 * @Description:用户入库保存 
	   	 * @param relation
	   	 * @return    
	   	 * @retrun 
	   	 
	   	public int saveRelationFailData(ReturnBean returnBean,String dataId){
			List<RelationFailData> failDataList = new ArrayList<RelationFailData>();
			for(ReturnData returnData:returnBean.getContent().getError()){
				RelationFailData failData = new RelationFailData();
				failData.setIdcard(returnData.getIdcard());
				failData.setUniqueid(returnData.getUniqueId());
				failData.setDataid(dataId);
				failData.setMsg(returnData.getMsg());
				failDataList.add(failData);
			}
			int rows = 0;
			if(failDataList.size() > 0){
				rows = relationFailDataMapper.batchInsert(failDataList);
			}
			return rows;
		}
	*/
		
		
}
