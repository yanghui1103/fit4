package com.bw.fit.system.dict.model;

import com.bw.fit.system.common.model.BaseModel;

public class Dict extends BaseModel {

	private String dictName;
	private String parentId;
	private String dictValue;
	private String sortNumber;
	private String canAdd;
	private String canEdit;
	private String canDel;
	private String DictRemark;
	public String getDictName() {
		return dictName;
	}
	public void setDictName(String dictName) {
		this.dictName = dictName;
	}
	public String getParentId() {
		return parentId;
	}
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	public String getDictValue() {
		return dictValue;
	}
	public void setDictValue(String dictValue) {
		this.dictValue = dictValue;
	}
	public String getSortNumber() {
		return sortNumber;
	}
	public void setSortNumber(String sortNumber) {
		this.sortNumber = sortNumber;
	}
	public String getCanAdd() {
		return canAdd;
	}
	public void setCanAdd(String canAdd) {
		this.canAdd = canAdd;
	}
	public String getCanEdit() {
		return canEdit;
	}
	public void setCanEdit(String canEdit) {
		this.canEdit = canEdit;
	}
	public String getCanDel() {
		return canDel;
	}
	public void setCanDel(String canDel) {
		this.canDel = canDel;
	}
	public String getDictRemark() {
		return DictRemark;
	}
	public void setDictRemark(String dictRemark) {
		DictRemark = dictRemark;
	}
	
	
}
