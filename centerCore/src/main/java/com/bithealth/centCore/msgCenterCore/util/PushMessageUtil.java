package com.bithealth.centCore.msgCenterCore.util;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSON;
import com.bithealth.centCore.msgCenterCore.model.MessageCenter;



public class PushMessageUtil {
	private static Logger logger = Logger.getLogger(PushMessageUtil.class);

	//消息推送接口
    public static final String PUSH_URL="http://192.168.10.27:9082/Push/pushByMemberIds";
    //消息发送次数
    public static final int PUSH_COUNT = 3;
    //编码
    public static final String  PUSH_CHARSET="UTF-8";
	/**
	 * 发送推送消息
	 * 
	 * @param message
	 * @throws Exception
	 */
	// ?data=#& roleIds=#& deviceType=#& platform=#&sign=#
	public static void sendMessage(MessageCenter data, String notifier)
			throws Exception {
		if (notifier != null && !"".equals(notifier)) {
			String[] notifiers = notifier.split(",");
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("data", JSON.toJSONString(data));
			map.put("sender", data.getSender());
			map.put("memberId", JSON.toJSONString(notifiers));
			map.put("deviceType", 0);
			map.put("platfrom", "baidu");
			map.put("sign", getSign(map));
			// 重复发送3
			for (int i = 0; i < PUSH_COUNT; i++) {
				try {
//					String reslut = HttpTookit.doPost(PUSH_URL, map,PUSH_CHARSET);
//					JSONObject json = JSONObject.parseObject(reslut);
//					if (json.getIntValue("code") == 0) {
//						logger.info("消息推送成功");
//						break;
//					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	// sign=MD5(Base64(http://10.2.2.130:8081/push/MessengerSend)+
	// userId+Base64(123456)+ roleId+ Base64(1111)+ channeled+ Base64(0001)+
	// platform+Base64(baidu)+data+Base64(sendTxt))

	// MD5后 sign的值为：9D6CD7690A4762A903857FCF1A6CE68E
	/**
	 * 获取数字签名
	 * 
	 * @param paramMap
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public static String getSign(Map<String, Object> paramMap) throws Exception {
		StringBuffer buffer = new StringBuffer("");
		buffer.append(PushUtils.encode(PUSH_URL.getBytes(PUSH_CHARSET)));
		// 循环请求参数
		for (Object key : paramMap.keySet()) {
			buffer.append(key);
			String value = (String) (paramMap.get(key) + "");
			// System.out.println(value);
			buffer.append(PushUtils.encode(value
					.getBytes(PUSH_CHARSET)));

		}
		// System.out.println(PushUtils.MD5(buffer.toString().getBytes(Constants.PUSH_CHARSET)));
		return PushUtils.MD5(buffer.toString().getBytes(PUSH_CHARSET));
	}

	public static void main(String[] args) throws Exception {
		PushMessageUtil.sendMessage(new MessageCenter(), "123,234,245");
	}
}