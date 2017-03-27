package com.bithealth.sdk.client .utils;


public class ServiceConfigurationError extends Error {

	private static final long serialVersionUID = 74132770414881L;

	/**
	 * Constructs a new instance with the specified message.
	 * 
	 * @param msg The message, or <tt>null</tt> if there is no message
	 * 
	 */
	public ServiceConfigurationError(String msg) {
		super(msg);
	}

	/**
	 * Constructs a new instance with the specified message and cause.
	 * 
	 * @param msg The message, or <tt>null</tt> if there is no message
	 * 
	 * @param cause The cause, or <tt>null</tt> if the cause is nonexistent or unknown
	 */
	public ServiceConfigurationError(String msg, Throwable cause) {
		super(msg, cause);
	}

}
