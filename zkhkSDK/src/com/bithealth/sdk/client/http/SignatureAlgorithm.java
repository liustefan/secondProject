package com.bithealth.sdk.client.http;


public enum SignatureAlgorithm {
	DSA_SHA1("dsa-sha1", "SHA1withDSA"), RSA_SHA1("rsa-sha1", "SHA1withRSA");

	SignatureAlgorithm(String authSubName, String jcaName) {
		this.authSubName = authSubName;
		this.jcaName = jcaName;
	}

	@Override
	public String toString() {
		return jcaName;
	}

	public String getAuthSubName() {
		return authSubName;
	}

	public String getJCAName() {
		return jcaName;
	}

	private final String authSubName;
	private final String jcaName;
}
