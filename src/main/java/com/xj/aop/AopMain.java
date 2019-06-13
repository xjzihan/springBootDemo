package com.xj.aop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.xj.aop.service.SPAService;

@SpringBootApplication
public class AopMain {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(AopMain.class, args);
		SPAService spa = context.getBean(SPAService.class);
		spa.aromaOilMassage("张三");
		spa.aromaOilMassage("李四");
		spa.aromaOilMassage("王五");
	}
}
