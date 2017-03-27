 
/**
 * @PackageName:      com.bithealth.measureCore.enmu
 * @FileName:     ElectrocardioType.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      陈哲 
 * @version      V1.0  
 * @Createdate:  2016年7月14日 上午10:28:26  
 * 
 */

package com.bithealth.measureCore.enmu;


/**
 * 类名称: ElectrocardioType  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年7月14日 上午10:28:26 
 * 
 * @author 陈哲
 * @version  
 */
public enum ElectrocardioType {
	ST("Polycardia","ST","心动过速"),		SB("Bradycardia","SB","心动过缓"),		SA("Arrest","SA","停博"),
	MB("Missed","MB","漏搏"),			WS("Wide","WS","宽搏"),					VPB("PVB","VPB","室性早搏"),
	APB("PAB","APB","房性早搏"),			IVBP("Insert_PVB","IVBP","插入性室性早搏"),	VT("VT","VT","阵发性心动过速"),
	BG("Bigeminy","BG","二联律"),			TRG("Trigeminy","TRG","三联律"),			AR("Arrhythmia","AR","心律不齐");
	
	String ecg1Name;
	String ecg2Name;
	String chinaName;
	
	private ElectrocardioType(String ecg2Name, String ecg1Name, String chinaName){
		this.ecg2Name = ecg2Name;
		this.ecg1Name = ecg1Name;
		this.chinaName = chinaName;
	}

	/**
	 * ecg1Name.
	 *
	 * @return  the ecg1Name 
	 */
	public String getEcg1Name() {
		return ecg1Name;
	}

	/**
	 * ecg1Name.
	 *
	 * @param   ecg1Name    the ecg1Name to set 
	 */
	public void setEcg1Name(String ecg1Name) {
		this.ecg1Name = ecg1Name;
	}

	/**
	 * ecg2Name.
	 *
	 * @return  the ecg2Name 
	 */
	public String getEcg2Name() {
		return ecg2Name;
	}

	/**
	 * ecg2Name.
	 *
	 * @param   ecg2Name    the ecg2Name to set 
	 */
	public void setEcg2Name(String ecg2Name) {
		this.ecg2Name = ecg2Name;
	}

	/**
	 * chinaName.
	 *
	 * @return  the chinaName 
	 */
	public String getChinaName() {
		return chinaName;
	}

	/**
	 * chinaName.
	 *
	 * @param   chinaName    the chinaName to set 
	 */
	public void setChinaName(String chinaName) {
		this.chinaName = chinaName;
	}
	
	/**
	 * 
	 * @Title:getTypeChinaName 
	 * @Description:通过ecg2Name编号来获取对应的中文
	 * @author 陈哲
	 * @param ecg2Name
	 * @return 
	 * @throws
	 * @retrun String
	 */
	public static String getTypeChinaName(String ecg2Name){
		for(ElectrocardioType type :  ElectrocardioType.values()){
			if(type.getEcg2Name().equals(ecg2Name)){
				return type.getChinaName();
			}
		}
		return null;
	}
	
	/**
	 * 
	 * @Title:getChinaNameType 
	 * @Description:通过ecg2Name和模糊条件ecg1Name查找chinaName  
	 * @author 陈哲
	 * @param abnName
	 * @param abEcgType
	 * @return 
	 * @throws
	 * @retrun String
	 */
	public static String getTypeChinaName(String ecg2Name, String ecg1Name){
		for(ElectrocardioType type :  ElectrocardioType.values()){
			if(type.getEcg2Name().equals(ecg2Name) && type.getEcg1Name().equals(ecg1Name)){
				return type.getChinaName();
			}
		}
		return null;
	}
	
	/**
	 *
	 * @Title:getEcg1NameType 
	 * @Description: 通过ecg2Name查找ecg1Name
	 * @author 陈哲
	 * @param ecg2Name
	 * @return 
	 * @throws
	 * @retrun String
	 */
	public static String getTypeEcg1Name(String ecg2Name){
		for(ElectrocardioType type : ElectrocardioType.values()){
			if(type.getEcg2Name().equals(ecg2Name)){
				return type.getEcg1Name();
			}
		}
		return null;
	}
	
	/**
	 * @Title:getChineseNameByEcg1 
	 * @Description:(这里用一句话描述这个方法的作用). 
	 * TODO(这里描述这个方法适用条件  执行流程  使用方法 注意事项– 可选).  
	 * @author 陈哲
	 * @param ecg1Name
	 * @return 
	 * @throws
	 * @retrun String
	 */
	public static String getChineseNameByEcg1(String ecg1Name){
		for(ElectrocardioType type : ElectrocardioType.values()){
			if(type.getEcg1Name().equals(ecg1Name)){
				return type.getChinaName();
			}
		}
		return null;
	}
	
	public static String getEcg2TypeByEcg1(String ecg1Name){
		for(ElectrocardioType type : ElectrocardioType.values()){
			if(type.getEcg1Name().equals(ecg1Name)){
				return type.getEcg2Name();
			}
		}
		return null;
	}
	
	public static String getEcg1TypeByChineseName(String chinaName){
		for(ElectrocardioType type : ElectrocardioType.values()){
			if(type.getChinaName().equals(chinaName)){
				return type.getEcg1Name();
			}
		}
		return null;
	}
	
	public static String getEcg2TypeByChineseName(String chinaName){
		for(ElectrocardioType type : ElectrocardioType.values()){
			if(type.getChinaName().equals(chinaName)){
				return type.getEcg2Name();
			}
		}
		return null;
	}
}

