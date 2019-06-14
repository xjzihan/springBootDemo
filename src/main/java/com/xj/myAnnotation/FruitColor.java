package com.xj.myAnnotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义注解-水果颜色
 */
@Documented//一个简单的Annotations 标记注解，表示是否将注解信息添加在java 文档中
@Target(ElementType.FIELD)//表示注解用于什么地方(ElementType.FIELD:成员变量、对象、属性（包括enum实例）)
@Retention(RetentionPolicy.RUNTIME)//定义该注解的生命周期(RetentionPolicy.RUNTIME：始终不会丢弃，运行期也保留该注解，因此可以使用反射机制读取该注解的信息)
public @interface FruitColor {
	/**
	 * 自定义颜色枚举类型
	 */
	public enum Color{BLUE, RED, GREEN};

	/**
	 * 自定义注解属性-水果颜色
	 */
	Color fruitColor() default Color.GREEN;
}
