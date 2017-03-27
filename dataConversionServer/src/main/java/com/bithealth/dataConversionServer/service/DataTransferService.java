package com.bithealth.dataConversionServer.service;

import java.util.List;

import com.bithealth.dataConversionServer.bean.ReturnBean;
import com.bithealth.dataConversionServer.bean.ZUserInfo;
import com.bithealth.dataConversionServer.enmu.CompanyConfigEnmu;
import com.bithealth.dataConversionServer.model.*;


public interface DataTransferService {
  

     /** 
     * @Title: selectUserData 
     * @Description: 获取备份的用户信息
     * @param dataId
     * @throws Exception    
     * @retrun List<DataFileRelation>
     */
    public List<DataFileRelation> queryUserData(DataFileRelation dataFileRelation);
    
    
    /** 
   	 * @Title: updataFileRelation 
   	 * @Description:更新 文件关联表 
   	 * @param relation
   	 * @return    
   	 * @retrun int
   	 */
   	public int updataFileRelation(DataFileRelation relation);
   	
   	/** 
   	 * @Title: save 
   	 * @Description:用户入库保存 
   	 * @param relation
   	 * @return    
   	 * @retrun 
   	 */
   	public void saveMember(List<ZUserInfo> userList,List<OrgidBean> orgidList,String DataId,CompanyConfigEnmu compayEnmu);
   	
 
		
	public List<OrgidBean> getOrgidList(List<ZUserInfo> userlist);

}
