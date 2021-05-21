package com.xj.exception.advice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.messaging.handler.annotation.support.MethodArgumentNotValidException;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 异常通知统一处理累
 */
@RestControllerAdvice
public class RestExceptionHandler {
	/**
     * 提取Validator产生的异常错误
     * @param bindingResult
     * @return
     */
	/*private Map<String,Object> parseBindingResult(BindingResult bindingResult){
	    Map<String,Object> errorMsgs = new HashMap<String,Object>();
	    for (FieldError error:bindingResult.getFieldErrors()){
	        errorMsgs.put(error.getField(),error.getDefaultMessage());
	    }
	    return errorMsgs;
	}*/
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String,Object> handleBindException(MethodArgumentNotValidException ex) {
        FieldError fieldError = ex.getBindingResult().getFieldError();
        //log.info("参数校验异常:{}({})", fieldError.getDefaultMessage(),fieldError.getField());
        Map<String,Object> result = new HashMap<String,Object>();
        result.put("respCode", "01002");
        result.put("respMsg", fieldError.getDefaultMessage());
        return result;
    }
	
	/**
	 * 捕获@Validate校验抛出的异常
	 * @param ex
	 * @return
	 */
	@ExceptionHandler(BindException.class)
    public Map<String,Object> handleBindException(BindException ex, HttpServletRequest request, HttpServletResponse response) {
        //校验 除了 requestbody 注解方式的参数校验 对应的 bindingresult 为 BeanPropertyBindingResult
        List<FieldError> errors = ex.getBindingResult().getFieldErrors();
        //log.info("必填校验异常:{}({})", fieldError.getDefaultMessage(),fieldError.getField());
        Map<String,Object> result = new HashMap<String,Object>();
        StringBuffer sb = new StringBuffer();
        for(FieldError error : errors) {
        	sb.append(error.getDefaultMessage() + ",");
        }
        result.put("respCode", "02002");
        result.put("respMsg", sb.toString());
        return result;
    }


	/*@ExceptionHandler(BindException.class)
	public Map<String,Object> handleBindException(BindException ex) {
	    //校验 除了 requestbody 注解方式的参数校验 对应的 bindingresult 为 BeanPropertyBindingResult
	    FieldError fieldError = ex.getBindingResult().getFieldError();
	    //log.info("必填校验异常:{}({})", fieldError.getDefaultMessage(),fieldError.getField());
	    Map<String,Object> result = new HashMap<String,Object>();
	    result.put("respCode", "02002");
	    result.put("respMsg", fieldError.getDefaultMessage());
	    return result;
	}*/
}
