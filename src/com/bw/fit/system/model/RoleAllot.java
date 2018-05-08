package com.bw.fit.system.model;

import java.io.Serializable;

import org.hibernate.validator.constraints.NotEmpty;

import com.bw.fit.common.model.BaseModel;

public class RoleAllot extends BaseModel   implements Serializable{

	private static final long serialVersionUID = 744598881L;

	@NotEmpty(message="请选择角色")
	private String role_id ;
	private String[] operation_ids;
	@NotEmpty(message="请选择菜单")
	private String menu_id;
	private String[] element_ids ;
	private String operation_id ;
	private String element_id ;
	
	
	public String getOperation_id() {
		return operation_id;
	}
	public void setOperation_id(String operation_id) {
		this.operation_id = operation_id;
	}
	public String getElement_id() {
		return element_id;
	}
	public void setElement_id(String element_id) {
		this.element_id = element_id;
	}
	public String getRole_id() {
		return role_id;
	}
	public void setRole_id(String role_id) {
		this.role_id = role_id;
	}
	public String getMenu_id() {
		return menu_id;
	}
	public void setMenu_id(String menu_id) {
		this.menu_id = menu_id;
	}
	public String[] getOperation_ids() {
		return operation_ids;
	}
	public void setOperation_ids(String[] operation_ids) {
		this.operation_ids = operation_ids;
	}
	public String[] getElement_ids() {
		return element_ids;
	}
	public void setElement_ids(String[] element_ids) {
		this.element_ids = element_ids;
	}
	
}
