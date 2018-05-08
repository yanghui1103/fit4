package com.bw.fit.system.model;

import java.io.Serializable;

import com.bw.fit.common.model.BaseModel;

public class Role extends BaseModel  implements Serializable{

	private static final long serialVersionUID = 43344598881L;

	private String role_name;
	private String parent_id; 
	private int user_count;
	private String parent_role_name;
	
	public String getParent_role_name() {
		return parent_role_name;
	}
	public void setParent_role_name(String parent_role_name) {
		this.parent_role_name = parent_role_name;
	}
	public int getUser_count() {
		return user_count;
	}
	public void setUser_count(int user_count) {
		this.user_count = user_count;
	}
	public String getRole_name() {
		return role_name;
	}
	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}
	public String getParent_id() {
		return parent_id;
	}
	public void setParent_id(String parent_id) {
		this.parent_id = parent_id;
	}		
}
