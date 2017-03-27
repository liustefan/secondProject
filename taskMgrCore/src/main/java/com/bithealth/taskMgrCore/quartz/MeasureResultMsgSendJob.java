/**
 * @PackageName:      com.bithealth.taskMgrCore.quartz
 * @FileName:     MemberDeleteJob.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      liuhm
 * @version      V1.0  
 * @Createdate:  2016年9月6日 下午5:54:03  
 * 
 */
package com.bithealth.taskMgrCore.quartz;

import org.apache.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bithealth.measureCore.facade.Facade;
import com.bithealth.sdk.common.rabbit.RabbitMqHelper;
import com.bithealth.taskMgrCore.constants.Constants;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.QueueingConsumer;

/**
 * 类名称: MemberDeleteJob  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年9月6日 下午5:54:03 
 * 
 * @author liuhm
 * @version  
 */
@Service("measureResultMsgSendJob")
public class MeasureResultMsgSendJob implements Job {

    private static final Logger logger = Logger.getLogger(MeasureResultMsgSendJob.class);
    
    /**
     * isStart:定时消费 
     */
    public static boolean isStart = false;
    
	//消息持久化
	private static boolean durable = true;
	
	@Autowired
	private Facade facade;

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		if(isStart){
			return;
		}
		measureResultMsgSend();
	}
	
	
	public void measureResultMsgSend(){
		isStart = true;
		try{
			Channel channel = RabbitMqHelper.createChannel();
			channel.exchangeDeclare(Constants.MQ_EXCHANGE_NAME, "direct"); //direct fanout topic  
			//声明队列，防止消费线程先行启动而发送线程后启动导致队列还未创建导致找不队列报异常
			channel.queueDeclare(Constants.MQ_QUEUE_RECIVE, durable, false, false, null); 
			channel.queueBind(Constants.MQ_QUEUE_RECIVE,Constants.MQ_EXCHANGE_NAME,Constants.MQ_RECIVE_ROUTING_KEY);  
			QueueingConsumer consumer = new QueueingConsumer(channel);
			channel.basicConsume(Constants.MQ_QUEUE_RECIVE, true, consumer);
			logger.info("动态心电及三合一分析结果消息发送任务开始执行。");
			while(true){
				try{
					QueueingConsumer.Delivery delivery = consumer.nextDelivery();
					String message = new String(delivery.getBody());
					if(message != null && message.length()>0){
						logger.info("读取消费Mq消息："+message);
						String eventIdStr = message.substring(message.lastIndexOf(",")+1, message.length());
						if(eventIdStr != null){
							try{
								facade.measureResultMsgSend(Integer.parseInt(eventIdStr));
							}catch(Exception e){
								logger.error("三合一及动态心电测量数据分析结果消息发送异常，异常的enventId"+eventIdStr, e);
							}
						}
					}
				}catch(Exception e){
					logger.error("连接MQ异常，5分钟后将尝试再次连接", e);
					Thread.sleep(5*60*1000);
				}
			}
		}catch(Exception e){
			isStart = false;
			logger.error("发送三合一及动态心电分析结果消费线程任务执行异常。", e);
		}
	}
}
