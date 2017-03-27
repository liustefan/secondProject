package com.bithealth.dataConversionServer.bean;

import java.util.List;

public class ReturnContent implements java.io.Serializable {

	/**
	* TODO
	*/
	
	private static final long serialVersionUID = 1L;
	
	public List<ReturnData> error;
	
	public List<ReturnData> success;
	

	public List<ReturnData> getError() {
		return error;
	}

	public void setError(List<ReturnData> error) {
		this.error = error;
	}

	public List<ReturnData> getSuccess() {
		return success;
	}

	public void setSuccess(List<ReturnData> success) {
		this.success = success;
	}


	
	
}