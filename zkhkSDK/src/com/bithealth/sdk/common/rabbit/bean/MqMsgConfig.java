package com.bithealth.sdk.common.rabbit.bean;

/**
 * @ClassName:     RabbitMqMsg.java 
 * @Description:   rabbitmq消息发送实体
 * @author         谢美团  
 * @version        V1.0   
 * @Date           2015年12月19日 下午5:16:10
*****/
public class MqMsgConfig { 
	//消息队列名称
	private  String queueName ;
	//mq host地址
	private  String host ;
	//连接密码
	private  String password ;
	//连接账号
	private  String username ;
	//连接端口
	private  int port ;
	//虚拟主机名称
	private  String virtualHostName;
	//交换机名称
	private  String exchangeName;
	//路由规则
	private String routingKey;
	//路由类型，direct fanout topic
	private String routingType ="direct";
	//发送的消息内容
	private String msg;
	
	
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getQueueName() {
		return queueName;
	}
	public void setQueueName(String queueName) {
		this.queueName = queueName;
	}
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	public String getVirtualHostName() {
		return virtualHostName;
	}
	public void setVirtualHostName(String virtualHostName) {
		this.virtualHostName = virtualHostName;
	}
	public String getExchangeName() {
		return exchangeName;
	}
	public void setExchangeName(String exchangeName) {
		this.exchangeName = exchangeName;
	}
	public String getRoutingKey() {
		return routingKey;
	}
	public void setRoutingKey(String routingKey) {
		this.routingKey = routingKey;
	}
	public String getRoutingType() {
		return routingType;
	}
	public void setRoutingType(String routingType) {
		this.routingType = routingType;
	}
	
	
	
	
}
