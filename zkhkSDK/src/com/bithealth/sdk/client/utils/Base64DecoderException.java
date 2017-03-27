package com.bithealth.sdk.client.utils;

/**
 * Exception thrown when encountering an invalid Base64 input character.
 * 
 * <p>
 * This class may be used with the Google Web Toolkit (GWT).
 * 
 * 
 */
public class Base64DecoderException extends Exception {
	public Base64DecoderException() {
		super();
	}

	public Base64DecoderException(String s) {
		super(s);
	}

	private static final long serialVersionUID = 1L;
}
