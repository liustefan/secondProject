package com.bithealth.dataConversionServer.assemble;

public class FieldPairs {
	
	private String sourceField;
	
	private String targetField;
	
	private String assemCls;
	
	private String method;

	public String getSourceField() {
		return sourceField;
	}

	public void setSourceField(String sourceField) {
		this.sourceField = sourceField;
	}

	public String getTargetField() {
		return targetField;
	}

	public void setTargetField(String targetField) {
		this.targetField = targetField;
	}

	public String getAssemCls() {
		return assemCls;
	}

	public void setAssemCls(String assemCls) {
		this.assemCls = assemCls;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}
}
