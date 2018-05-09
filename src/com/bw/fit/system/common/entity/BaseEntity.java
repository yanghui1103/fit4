package com.bw.fit.system.common.entity;
import static com.bw.fit.system.common.util.PubFun.*;

import java.util.Date;
/*****
 * 父实体类
 * @author yangh
 *
 */
public class BaseEntity {


	private String id  ; 
	private String keyWords ;
	private String creator;
	private String creator_name;
	private String create_time ;
	private String version_time ;
	private String operator_id;
	private String creator_id; 
	private String isdeleted ="0" ; // 默认未删除

	/***
	 * 翻页使用
	 */
	private Integer page =1;
	private Integer rows =20;
	private Integer start_num;
	private Integer end_num;
	private String paginationEnable;
	private String status ;
	
	
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCreator() {
		return creator;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}
	public String getCreator_name() {
		return creator_name;
	}
	public void setCreator_name(String creator_name) {
		this.creator_name = creator_name;
	}
	public String getPaginationEnable() {
		return paginationEnable;
	}
	public void setPaginationEnable(String paginationEnable) {
		this.paginationEnable = paginationEnable;
	}
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getRows() {
		return rows;
	}
	public void setRows(Integer rows) {
		this.rows = rows;
	}
	public Integer getStart_num() {
		return (page-1)*rows;
	} 
	public Integer getEnd_num() {
		return (page-1)*rows + rows;
	} 
	
	
	public String getKeyWords() {
		return keyWords;
	}
	public void setKeyWords(String keyWords) {
		this.keyWords = keyWords;
	}
	public String getIsdeleted() {
		return isdeleted;
	}
	public void setIsdeleted(String isdeleted) {
		this.isdeleted = isdeleted;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCreate_time() {
		return create_time;
	}
	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}
	public String getVersion_time() {
		return version_time;
	}
	public void setVersion_time(String version_time) {
		this.version_time = version_time;
	}
	public String getOperator_id() {
		return operator_id;
	}
	public void setOperator_id(String operator_id) {
		this.operator_id = operator_id;
	}
	public String getCreator_id() {
		return creator_id;
	}
	public void setCreator_id(String creator_id) {
		this.creator_id = creator_id;
	}
	
	
	
	
}
