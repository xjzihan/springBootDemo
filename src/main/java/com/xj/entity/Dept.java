package com.xj.entity;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import lombok.Data;

@Data
public class Dept implements Serializable{
	private static final long serialVersionUID = 1L;

	/**
	 * 部门ID
	 */
	@NotNull(message = "部门ID不能为空")
	private Integer deptId;
	
	/**
	 * 上级部门ID
	 */
	@NotNull(message = "上级部门ID不能为空")
	private Integer parentDeptId;
	
	/**
	 * 部门名称
	 */
	@NotBlank(message = "部门名称不能为空")
	@Length(max = 20, message = "部门名称长度不能超过20")
	private String deptName;
	
	/**
	 * 部门备注
	 */
	private String remark;
	
}
