package com.bithealth.sdk.common.rabbit;




import java.io.IOException;

import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSONObject;
import com.bithealth.sdk.common.Env;
import com.bithealth.sdk.common.rabbit.bean.MqMsgBean;
import com.bithealth.sdk.common.rabbit.bean.MqMsgConfig;




import com.bithealth.sdk.config.KDConfig;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.MessageProperties;

/**
 * @ClassName:     RabbitMqHelper.java 
 * @Description:   rabbitMq消息队列帮助类
 * @author         谢美团  
 * @version        V1.0   
 * @Date           2015年12月18日 下午3:13:27
*****/
public final class RabbitMqHelper {
    /** rabbitMq 主机IP*/
    private static String HOST ;
    /** 账号密码*/
    private static String PASSWORD ;
    /** 账号*/
    private static String USERNAME ;
    /** 端口*/
    private static int PORT ;
    /** 虚拟主机*/
    private static String VIRTUAL_HOST;
    //消息持久化
    private static boolean durable = true;
    
    private static String exchangeName;
    private static String routingKey;
    private static String queueName;
    
    
    static {
//        HOST = SystemUtils.getValue(Constants.MQ_HOST);
//        PASSWORD = SystemUtils.getValue(Constants.MQ_PASSWORD);
//        USERNAME = SystemUtils.getValue(Constants.MQ_USERNAME);
//        PORT = Integer.parseInt(SystemUtils.getValue(Constants.MQ_PORT));
//        VIRTUAL_HOST = SystemUtils.getValue(Constants.MQ_VIRTUAL_HOST);
        
        KDConfig kdConfig = Env.getBean("rdConfig");
        
        HOST =  kdConfig.getProperty("rabbit.host") ;
        PASSWORD =  kdConfig.getProperty("rabbit.password") ;
        USERNAME =  kdConfig.getProperty("rabbit.username") ;
        PORT =     Integer.valueOf(kdConfig.getProperty("rabbit.port")) ;
        VIRTUAL_HOST =  kdConfig.getProperty("rabbit.virtualHost") ;
        
        exchangeName =  kdConfig.getProperty("rabbit.exchangeName") ;
        routingKey =  kdConfig.getProperty("rabbit.routingKey") ;
        queueName =  kdConfig.getProperty("rabbit.queueName") ;


        
    }
            

  
    private static Logger logger=Logger.getLogger(RabbitMqHelper.class);

     /** 
     * @Title: send 
     * @Description: 创建rabbitMq 服务器的连接，打开通道，发送消息 
     * @param msg
     * @throws IOException    
     * @retrun void
     */
    private static void send(MqMsgConfig msg) throws IOException {  
        //创建连接
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(msg.getHost()==null?HOST:msg.getHost());
        factory.setPort(msg.getPort()==0?PORT:msg.getPort());
        factory.setPassword(msg.getPassword()==null?PASSWORD:msg.getPassword());
        factory.setUsername(msg.getUsername()==null?USERNAME:msg.getUsername());
        factory.setVirtualHost(msg.getVirtualHostName()==null?VIRTUAL_HOST:msg.getVirtualHostName());
        factory.setConnectionTimeout(5000);
        Connection connection = factory.newConnection();
        //打开通道
        Channel channel = connection.createChannel();
        channel.exchangeDeclare(msg.getExchangeName(), msg.getRoutingType()); //direct fanout topic  
        channel.queueDeclare(msg.getQueueName(), durable, false, false, null); 
        channel.queueBind(msg.getQueueName(),msg.getExchangeName(),msg.getRoutingKey());  
        channel.basicPublish(msg.getExchangeName(),msg.getRoutingKey(), MessageProperties.PERSISTENT_TEXT_PLAIN, msg.getMsg().getBytes()); //需要绑定路由键   
        if(channel!=null){
            channel.close();
        }
        if(connection != null){
            connection.close();
        }
        logger.info("发送数据成功"+msg.getMsg());
    }
    
    
    
     /** 
     * @Title: sendMsgToReciveQueue 
     * @Description: 发送消息到   ReciveQueue 消息队列
     * @param msgBean    
     * @retrun void
     */
    public static void sendMsgToReciveQueue(MqMsgBean msgBean){
        MqMsgConfig msg = new MqMsgConfig();
        msg.setExchangeName(exchangeName);
        msg.setRoutingKey(routingKey);
        msg.setQueueName(queueName);
        msg.setMsg(JSONObject.toJSON(msgBean).toString());
        try {
            send(msg);
        } catch (IOException e) {
            logger.error("发型消息到MQ ReciveQueue 失败。"+e);
        }
    }
    

    
     /** 
     * @Title: sendMsgToSendQueue 
     * @Description: 发送消息到  SendQueue 消息队列
     * @param msgBean    
     * @retrun void
     */
    public static void sendMsgToSendQueue(MqMsgBean msgBean){
        MqMsgConfig msg = new MqMsgConfig();
//        msg.setExchangeName(SystemUtils.getValue(Constants.MQ_EXCHANGE_NAME));
//        msg.setRoutingKey(SystemUtils.getValue(Constants.MQ_SEND_ROUTING_KEY));
//        msg.setQueueName(SystemUtils.getValue(Constants.MQ_QUEUE_SEND));
        
        msg.setExchangeName(exchangeName);
        msg.setRoutingKey(routingKey);
        msg.setQueueName(queueName);
        msg.setMsg(JSONObject.toJSON(msgBean).toString());
        try {
            send(msg);
        } catch (IOException e) {
            logger.error("发型消息到MQ SendQueue失败。"+e);
        }
    }
    
    public static Channel createChannel() throws IOException{
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(HOST);
        factory.setPort(PORT);
        factory.setPassword(PASSWORD);
        factory.setUsername(USERNAME);
        factory.setVirtualHost(VIRTUAL_HOST);
        factory.setConnectionTimeout(5000);
        Connection connection = factory.newConnection();
        return connection.createChannel();
    }
    
    public static void main(String[] args) throws IOException {
        MqMsgConfig msg = new MqMsgConfig();
//        msg.setExchangeName(SystemUtils.getValue(Constants.MQ_EXCHANGE_NAME));
//        msg.setRoutingKey(SystemUtils.getValue(Constants.MQ_RECIVE_ROUTING_KEY));
//        msg.setQueueName(SystemUtils.getValue(Constants.MQ_QUEUE_RECIVE));
        msg.setExchangeName(exchangeName);
        msg.setRoutingKey(routingKey);
        msg.setQueueName(queueName);
        
        MqMsgBean msgBean = new MqMsgBean();
        msgBean.setCompanyCode(0001);
        msgBean.setDataId("sdfsdfsdfsdf54sd5f4s5d4f5sd4564e877");
        msgBean.setOperation("test");
        msgBean.setTimestamp("20151221143400");
        msg.setMsg(JSONObject.toJSON(msgBean).toString());
        send(msg);
    }
    
    
}
