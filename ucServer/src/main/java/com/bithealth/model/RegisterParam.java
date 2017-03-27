 

package com.bithealth.model;



public class RegisterParam {
	
	public String params;
	
	public String serverID;
	
	public String getServerID() {
		return serverID;
	}

	public void setServerID(String serverID) {
		this.serverID = serverID;
	}

	public String getParams() {
		return params;
	}

	public void setParams(String params) {
		this.params = params;
	}

	@Override
	public String toString() {
		return "RegisterParam [params=" + params + ", serverID=" + serverID
				+ "]";
	}
}

