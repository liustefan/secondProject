package com.bithealth.fileCore.constant;

import org.apache.commons.lang.StringUtils;
 
import com.bithealth.sdk.common.utils.StringUtil;

public enum MimeTypeEnmu {
	NULL("file", "application/octet-stream"), 
	txt("txt","text/plain"), 
	gif("gif","image/gif"), 
	jpg("jpg","image/jpeg"), 
	jpeg("jpeg","image/jpeg"), 
	jpe("jpe","image/jpeg"), 
	zip("zip","application/zip"), 
	rar("rar","application/rar"), 
	html("html","text/html"), 
	htm("htm","text/html"),
    tif("tif","image/tiff"),
	tiff("tiff","image/tiff"),
	pdf("pdf","application/pdf"),
	
	doc("doc","application/msword"),
	dot("dot","application/msword"),
	docx("docx","application/vnd.openxmlformats-officedocument.wordprocessingml.document"),
	dotx("dotx","application/vnd.openxmlformats-officedocument.wordprocessingml.template"),
	docm("docm","application/vnd.ms-word.document.macroEnabled.12"),
	   
	dotm("dotm","application/vnd.ms-word.template.macroEnabled.12"),  
	xls("xls","application/vnd.ms-excel"), 
	xlt("xlt","application/vnd.ms-excel"),
//	.xlt
//	application/vnd.ms-excel

	xla("xla","application/vnd.ms-excel"),
//	.xla
//	application/vnd.ms-excel

	xlsx("xlsx","application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"),
//	.xlsx
//	application/vnd.openxmlformats-officedocument.spreadsheetml.sheet

	xltx("xltx","application/vnd.openxmlformats-officedocument.spreadsheetml.template"),
//	.xltx
//	application/vnd.openxmlformats-officedocument.spreadsheetml.template

	xlsm("xlsm","application/vnd.ms-excel.sheet.macroEnabled.12"),
//	.xlsm
//	application/vnd.ms-excel.sheet.macroEnabled.12

	xltm("xltm","application/vnd.ms-excel.template.macroEnabled.12"),
//	.xltm
//	application/vnd.ms-excel.template.macroEnabled.12

	xlam("xlam","application/vnd.ms-excel.addin.macroEnabled.12"),
//	.xlam
//	application/vnd.ms-excel.addin.macroEnabled.12

	xlsb("xlsb","application/vnd.ms-excel.sheet.binary.macroEnabled.12"),
//	.xlsb
//	application/vnd.ms-excel.sheet.binary.macroEnabled.12

	ppt("ppt","application/vnd.ms-powerpoint"),
//	.ppt
//	application/vnd.ms-powerpoint

	pot("pot","application/vnd.ms-powerpoint"),
//	.pot
//	application/vnd.ms-powerpoint

	pps("pps","application/vnd.ms-powerpoint"),
//	.pps
//	application/vnd.ms-powerpoint

	ppa("ppa","application/vnd.ms-powerpoint"),
//	.ppa
//	application/vnd.ms-powerpoint

	pptx("pptx","application/vnd.openxmlformats-officedocument.presentationml.presentation"),
//	.pptx
//	application/vnd.openxmlformats-officedocument.presentationml.presentation

	potx("potx","application/vnd.openxmlformats-officedocument.presentationml.template"),
//	.potx
//	application/vnd.openxmlformats-officedocument.presentationml.template

	ppsx("ppsx","application/vnd.openxmlformats-officedocument.presentationml.slideshow"),
//	.ppsx
//	application/vnd.openxmlformats-officedocument.presentationml.slideshow

	ppam("ppam","application/vnd.ms-powerpoint.addin.macroEnabled.12"),
//	.ppam
//	application/vnd.ms-powerpoint.addin.macroEnabled.12

	pptm("pptm","application/vnd.ms-powerpoint.presentation.macroEnabled.12"),
//	.pptm
//	application/vnd.ms-powerpoint.presentation.macroEnabled.12

	potm("potm","application/vnd.ms-powerpoint.template.macroEnabled.12"),
//	.potm
//	application/vnd.ms-powerpoint.template.macroEnabled.12

	ppsm("ppsm","application/vnd.ms-powerpoint.slideshow.macroEnabled.12"),
//	.ppsm
//	application/vnd.ms-powerpoint.slideshow.macroEnabled.12

	;
	/**
	 * 文件类型
	 */
	private String type;
	/**
	 * 文件格式
	 */
	private String format;
	MimeTypeEnmu(String type,String format){
		this.type = type;
		this.format = format;
	}
	
	public static String getMimeTypeEnmu(String value){
		if(StringUtil.isEmpty(value)){
			return NULL.format;
		}
		MimeTypeEnmu[] types = MimeTypeEnmu.values();
		for(MimeTypeEnmu stypes : types){
			if(stypes.getType().equals(value)){
				return stypes.getFormat();
			}
		}
		return NULL.getFormat();
	}

	
	 
	
	/**
	 * @Title:findEnumByType 
	 * @Description:TODO(通过文件格式查找指定的MimeTypeEnmu).  
	 * @author 胡翔
	 * @param type 类型值
	 * @return null或者对应的枚举对象
	 */ 
	public static MimeTypeEnmu findEnumByFormat(String format){
		if(StringUtils.isBlank(format)){
			return null;
		}
		format = format.toLowerCase();
		MimeTypeEnmu[] enums = MimeTypeEnmu.values();
		for(MimeTypeEnmu typeEnum : enums){
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
