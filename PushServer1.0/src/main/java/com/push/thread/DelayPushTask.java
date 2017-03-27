package com.push.thread;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.push.Utils.SystemUtils;
import com.push.Utils.TimeUtil;
import com.push.constants.Constants;
import com.push.dao.PushMemberMapper;
import com.push.dao.PushMsgMapper;
import com.push.model.HKDeplayPushBean;
import com.push.model.HKPushInfo;
import com.push.model.HkPushMember;
import com.push.service.PushMsgService;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

/**
 * @author xemt
 *
 */
@Service 
public class DelayPushTask{
	private static Logger logger = Logger.getLogger(DelayPushTask.class);
	
	private CacheManager cacheManager;
	
	@Autowired
	private PushMsgMapper pushMsgMapper;
	
	@Autowired
	private PushMemberMapper pushMemberMapper;
	
    @Autowired
    private PushMsgService pushMsgService;
    
    private Cache cache;
    
    private DelayPushTask(){
    	cacheManager = CacheManager.newInstance( this.getClass().getResource("/").getPath()+(SystemUtils.getValue(Constants.EHCACHE_PATH)));
    	cache =  (Cache) cacheManager.getCache(Constants.CACHE_NAME);
    }

    /**
     * 是否启动轮询
     */
    private boolean isStart = false;

	/**
	 * 定时从数据库中获取需要发送的推送消息，并写入缓存中。
	 */
	public void getDelayPushMsg(){
		
		long startTime = TimeUtil.addDate(new Date(), -3).getTime();//超过三天的消息将不在发送
		try{
			List<HKDeplayPushBean> deplayPushList = pushMsgMapper.queryDeplayMsg(startTime);
			
			Element element = null;
			List<String> msgIdList = new ArrayList<String>();
			for(HKDeplayPushBean deplayPush:deplayPushList){
				element = new Element(deplayPush.getMsgId(), deplayPush);
				cache.put(element);		
				pushMsgMapper.updateCacheStatusByMsgId(deplayPush.getMsgId());
				msgIdList.add(deplayPush.getMsgId());
			}
			
			/*//更新查询过的消息的缓存状态
			if(msgIdList.size() != 0){
				pushMsgMapper.updateCacheStatusByMsgId(msgIdList);
			}*/
			
			//若果循环任务没有启动或者已经中断，启动任务
			if(!isStart){
				new Thread(){
					@Override
					public void run() {
						sendDelayMsg();
					}
				}.start();
				
			}
			logger.info("延迟推送消息成功写入缓存。");
		}catch(Exception e){
			logger.error("延迟推送消息写入缓存异常。"+e);
		}
	}
	
	/**
	 * 推送延迟消息
	 */
	private synchronized void sendDelayMsg(){
		HKDeplayPushBean deplayPush = null;
		//如果任务已经启动过，则返回
		if(isStart == true ){
			return;
		}
		isStart = true;
		logger.info("开始循环任务发送延迟消息。");
		try{
			while(true){
				for (Object key : cache.getKeys()) {
					Element element = cache.get(key);
					deplayPush = (HKDeplayPushBean) element.getObjectValue();
					long currentTime  = System.currentTimeMillis();
					if(deplayPush != null && deplayPush.getSendTime() <= currentTime){
						HkPushMember memberInfo = pushMemberMapper.queryPushMemberByMemberId(deplayPush.getMemberId());
						//用户在线，推送消息
						if(null != memberInfo && memberInfo.getMemberId().equals(deplayPush.getMemberId()) && memberInfo.getLineStatus() == Constants.ON_LINE){
							HKPushInfo pushInfo = pushMsgMapper.queryPushInfoByMsgId(String.valueOf(key));
							pushMsgService.pushSingleMsg(pushInfo);
						}
						//清除缓存中的带推送对象
						cache.remove(key);
					}
				}
			}
		}catch(Exception e){
			isStart = false;	
			logger.error("延迟消息推送任务异常。"+e);
		}

	}
	
	
	
	
	
}
