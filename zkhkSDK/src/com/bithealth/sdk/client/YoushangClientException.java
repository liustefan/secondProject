package com.bithealth.sdk.client ;

public class YoushangClientException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public YoushangClientException() {
		super();
	}

	public YoushangClientException(String message) {
		super(message + ", client version " + Version.NAME);
	}

	public YoushangClientException(String message, Throwable cause) {
		super(message + ", client version " + Version.NAME, cause);
	}
}
