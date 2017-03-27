/*
 * ChatMessageMapper.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-06-28 Created
 */
package com.bithealth.chatCore.dao;

import com.bithealth.chatCore.model.ChatMessage;
import com.bithealth.chatCore.model.ChatMessageExample;
import com.bithealth.chatCore.model.ChatMessageVo;
import com.bithealth.sdk.core.feature.orm.mybatis.Page;
import com.bithealth.sdk.core.generic.GenericBaseDao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface ChatMessageMapper extends GenericBaseDao<ChatMessage,ChatMessageExample, Integer> {
    int countByExample(ChatMessageExample example);

    int deleteByExample(ChatMessageExample example);

    int deleteByPrimaryKey(Integer logid);

    int insert(ChatMessage record);

    int insertSelective(ChatMessage record);

    List<ChatMessage> selectByExample(ChatMessageExample example);
    
    List<ChatMessage> selectByChat(Page<ChatMessage> page,@Param("id")Integer id);
    
    List<ChatMessage> selectByChatCode(Page<ChatMessage> page,@Param("sender")Integer sender,@Param("receiver")Integer receiver); 


    ChatMessage selectByPrimaryKey(Integer logid);

    int updateByExampleSelective(@Param("record") ChatMessage record, @Param("example") ChatMessageExample example);

    int updateByExample(@Param("record") ChatMessage record, @Param("example") ChatMessageExample example);

    int updateByPrimaryKeySelective(ChatMessage record);

    int updateByPrimaryKey(ChatMessage record);
    
    List<ChatMessage> selectSendersNewMsgToReceiverPage(Page<ChatMessage> page,Map<String, Object> param);
    
    List<ChatMessageVo> selectMemberToDoctorsgsPage(Map<String, Object> param);
    
    List<ChatMessageVo> selectDoctorToMemberMsgsPage(Map<String, Object> param);
}