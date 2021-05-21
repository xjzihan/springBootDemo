package com.xj.exception;

/**
 * 自定义全局异常处理类
 */
public class GlobalException extends AbstractGlobalException{
	private static final long serialVersionUID = 1L;
	
	/**
	 * 异常编码
	 */
	private Integer code;
	

	public GlobalException(String message, Throwable cause, Integer code) {
		super(message, cause);
		this.code = code;
	}

	public GlobalException(String message, Integer code) {
		super(message);
		this.code = code;
	}

	public GlobalException(Throwable cause, Integer code) {
		super(cause);
		this.code = code;
	}

	@Override
	public int getCode() {
		return this.code;
	}

}
