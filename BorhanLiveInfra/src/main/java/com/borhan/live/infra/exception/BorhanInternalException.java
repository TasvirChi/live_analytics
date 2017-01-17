package com.borhan.live.infra.exception;

public class BorhanInternalException extends RuntimeException {

	private static final long serialVersionUID = -4923449413551219154L;
	
	public BorhanInternalException() { super(); }
	public BorhanInternalException(String message) { super(message); }
	public BorhanInternalException(String message, Throwable cause) { super(message, cause); }
	public BorhanInternalException(Throwable cause) { super(cause); }
	
}
