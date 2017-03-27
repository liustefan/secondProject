/**
 * @PackageName:      test
 * @FileName:     MyTestUtil.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      柴仕富
 * @version      V1.0  
 * @Createdate:  2016年6月17日 上午10:24:26  
 * 
 */

package com.bithealth.doctorCore;


/**
 * 类名称: TestUser  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年6月17日 上午10:13:16 
 * 
 * @author "jason chai"
 * @version  
 */

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bithealth.doctorCore.docGroup.dao.DoctorGroupMapper;
import com.bithealth.doctorCore.docGroup.model.DoctorGroupExt;
/**
 * 类名称: MyTestUtil  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年6月17日 上午10:24:26 
 * 
 * @author "jason chai"
 * @version  
 */

 @RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath*:application*.xml"})
public class MyTestUtil {

 

    @Autowired
    private DoctorGroupMapper doctorService;
  
 @Test
 public void test(){
	 DoctorGroupExt group = doctorService.selectGrpWithMemGrpById(233);
	 System.out.println("父节点：" + group.getParentGroup().getOdgpname() + "/父节点2：" + group.getParentGroup().getParentGroup().getOdgpname());
	 System.out.println("子节点数量：" + group.getChildren().size());
	 System.out.println("会员数量：" + group.getMemGrpList().size());
	 System.out.println("医生数量：" + group.getDoctorList().size());
 } 
}

