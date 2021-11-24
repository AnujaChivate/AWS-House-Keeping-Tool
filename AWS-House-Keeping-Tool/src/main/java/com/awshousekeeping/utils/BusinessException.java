package com.awshousekeeping.utils;

public class BusinessException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4010780266516025899L;

	public BusinessException() {
		super();
	}

	public BusinessException(String message) {
		super(message);
	}

	public BusinessException(String messaString, Throwable t) {
		super(messaString, t);
	}
}
