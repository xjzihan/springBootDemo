package com.xj.exception;

/**
 * 抽象自定义全局类
 */
public abstract class AbstractGlobalException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public AbstractGlobalException() {}
	
	public AbstractGlobalException(String message) {
		super(message);
	}
	
	public AbstractGlobalException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public AbstractGlobalException(Throwable cause) {
        super(cause);
    }
	
	public abstract int getCode();
}
