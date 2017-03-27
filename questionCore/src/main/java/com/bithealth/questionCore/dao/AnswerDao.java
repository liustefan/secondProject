 
/**
 * @PackageName:      com.bithealth.questionCore.dao
 * @FileName:     AnswerDao.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      名字  * 
 * @version      V1.0  
 * @Createdate:  2016年8月16日 上午11:13:33  
 * 
 */

package com.bithealth.questionCore.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bithealth.questionCore.model.Answer;
import com.bithealth.sdk.core.feature.orm.mybatis.Page;



/**
 * 类名称: AnswerDao  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年8月16日 上午11:13:33 
 * 
 * @author baozj
 * @version  
 */
public interface AnswerDao {
	
	List<Answer> selectAnswerPage(Page<Answer> page, @Param("memberId")Integer memberId, @Param("finish")boolean finish);
}

