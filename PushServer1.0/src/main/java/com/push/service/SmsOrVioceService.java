package com.push.service;

import java.util.List;

import com.push.model.SmsConfig;
import com.push.model.SmsRequestBean;


/**
 * 短信语音发送服务
 * @author 谢美团
 * @version v1.0
 *
 */
public interface SmsOrVioceService {

    
    /**
     * 短信和语音发送
     * @param pushInfo
     * @throws Exception
     */
    public void smsOrVoiceSend(SmsRequestBean smsParam) throws Exception;
    
     /** 
     * @Title: initConfig 
     * @Description: 初始化短信语音推送配置信息 
     * @return
     * @throws Exception    
     * @retrun List<SmsConfig>
     */
    public List<SmsConfig> initConfig() throws Exception;
 
    
}