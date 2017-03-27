 
/**
 * @PackageName:      com.bithealth.measureCore.enmu
 * @FileName:     BloodSugarTimeQExcType.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      陈哲 
 * @version      V1.0  
 * @Createdate:  2016年7月14日 下午6:03:33  
 * 
 */

package com.bithealth.measureCore.enmu;


/**
 * 类名称: BloodPresResultTips  
 * 功能描述: 血压测量结果提示语       
 * 增加/修改原 因:   
 * 日期: 2016年7月14日 下午6:03:33 
 * 
 * @author liuxiaoqin
 * @version  
 */
public enum BloodPresResultTips {
	
	//分析血压数据异常状态  0 正常 1 低血压 2 高度高血压 3 中度高血压 4 轻度高血压 5 单纯收缩高血压
	/** V3.0版本:   0.正常(正常) 1.偏低(低血压) 2. 重高(高度高血压) 3.中高(中度高血压) 4.轻高(轻度高血压) 5.轻高(单纯收缩高血压) 6. 正常高(偏高) */
	
	NORMAL(0,"您的血压值在控制目标范围之内！请继续保持！祝您健康！"),
	LOW(1,"您此次测量提示血压偏低，如出现头晕、恶心、肢体麻木等身体不适，建议您及时到医院就诊。平时注意休息，避免在气温较高的环境中长时间站立、改变体位应缓慢、加强身体锻炼、多补充水分、注意补充营养。"),
	HIGH_HYPERTENSION(2,"您此次测量提示血压明显偏高。建议您在安静放松10分钟后再进行测量。如多次测量血压持续偏高或伴随头晕、头痛、肢体活动不利等不适，请及时到医院就诊。平时注意低盐饮食、戒烟限酒、适度运动，尽量避免剧烈运动及情绪激动。"),
	MIDDLE_HYPERTENSION(3,"您此次测量提示血压明显偏高。建议您在安静放松10分钟后再进行测量。如多次测量血压持续偏高或伴随头晕、头痛、肢体活动不利等不适，请及时到医院就诊。平时注意低盐饮食、戒烟限酒、适度运动，尽量避免剧烈运动及情绪激动。"),
	LOW_HYPERTENSION(4,"您此次测量提示血压偏高，建议您休息10分钟后，在安静放松的状态下再进行测量，如经多次测量后结论相同，请到医院就诊。平时注意低盐饮食、戒烟限酒、适度运动、避免急躁情绪。"),
	PURE_HYPERTENSION(5,"您此次测量提示血压偏高，建议您休息10分钟后，在安静放松的状态下再进行测量，如经多次测量后结论相同，请到医院就诊。平时注意低盐饮食、戒烟限酒、适度运动、避免急躁情绪。"),
	NORMAL_HYPERTENSION(6,"您的血压值在控制目标范围之内！请继续保持！祝您健康！");
	
	int code;
	String name;
	
	private BloodPresResultTips(int code, String name){
		this.code = code;
		this.name = name;
	}
	
	public int getCode() {
		return code;
	}
	
	public void setCode(int code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * 
	 * @Title: getTipsName 
	 * @Description:通过编码获取中文名称
	 * @author liuxiaoqin
	 * @param code
	 * @return 
	 * @throws
	 * @retrun String
	 */
	public static String getTipsName(int code){
		for(BloodPresResultTips type : BloodPresResultTips.values()){
			if(code == type.getCode()){
				return type.getName();
			}
		}
		return null;
	} 
	
}

