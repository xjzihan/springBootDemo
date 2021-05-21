package com.xj.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xj.entity.Dept;

/**
 * @Valid + BindingResult 校验demo
 */
@RestController
@RequestMapping("/dept")
public class DeptController {

	@RequestMapping("/test")
	public Map<String,Object> test(@Valid Dept dept, BindingResult result) {
		Map<String,Object> map = new HashMap<String,Object>();
		boolean flag = true;
		List<ObjectError> list = new ArrayList<ObjectError> ();
		if(result.hasErrors()) {
			flag = false;
			list = result.getAllErrors();
			StringBuffer errorInfo = new StringBuffer();
			for(int i = 0; i < list.size(); i++){
				errorInfo.append(list.get(i).getDefaultMessage() + ",");
			}
			map.put("message", errorInfo);
		}
		map.put("flag", flag);
		if(flag) {
			map.put("data", dept);
		}
		return map;
	}
	
	@RequestMapping("/testGlobalParamValidateException")
	public Map<String,Object> testGlobalParamValidateException(@Valid Dept dept) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("data", dept);
		return map;
	}
}
