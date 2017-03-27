package com.bithealth.fileCore.constant;

import org.apache.commons.lang.StringUtils;

/**
 * 
 * 类名称: FileTypeEnum  
 * 功能描述: 文件类型枚举  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年6月27日 下午5:08:24 
 * 
 * @author 胡翔
 * @version
 */
public enum FileTypeEnum {
	JPG("image","jpg"),
	JPEG("image","jpeg"),
	PNG("image","png"),
	GIF("image","gif"),
	BMP("image","bmp"),
	/**
	 * 缩略图
	 */
	CUT_IMAGE("image","cut_image"),
	AMR("audio","amr"),
	MP4("video","mp4"),
	AVI("video","avi"),
	/**
	 * 自定义type和format
	 */
	CUSTOM_FILE("custom","custom");
	/**
	 * 文件类型
	 */
	private String type;
	/**
	 * 文件格式
	 */
	private String format;
	FileTypeEnum(String type,String format){
		this.type = type;
		this.format = format;
	}
	/**
	 * @Title:findEnumByType 
	 * @Description:TODO(通过文件格式查找指定的FileTypeEnum).  
	 * @author 胡翔
	 * @param type 类型值
	 * @return null或者对应的枚举对象
	 */ 
	public static FileTypeEnum findEnumByFormat(String format){
		if(StringUtils.isBlank(format)){
			return null;
		}
		format = format.toLowerCase();
		FileTypeEnum[] enums = FileTypeEnum.values();
		for(FileTypeEnum typeEnum : enums){
			if(typeEnum.getFormat().equals(format)){
				return typeEnum;
			}
		}
		return null;
	}
	
	/**
	 * type.
	 *
	 * @return  the type 
	 */
	public String getType() {
		return type;
	}
	/**
	 * type.
	 *
	 * @param   type    the type to set 
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * format.
	 *
	 * @return  the format 
	 */
	public String getFormat() {
		return format;
	}
	/**
	 * format.
	 *
	 * @param   format    the format to set 
	 */
	public void setFormat(String format) {
		this.format = format;
	}
	
}
