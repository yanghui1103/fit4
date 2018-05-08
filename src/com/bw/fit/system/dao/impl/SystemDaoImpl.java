package com.bw.fit.system.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bw.fit.common.dao.DaoTemplete;
import com.bw.fit.common.entity.BaseEntity;
import com.bw.fit.common.model.RbackException;
import com.bw.fit.common.util.PubFun;
import com.bw.fit.system.dao.SystemDao;
import com.bw.fit.system.entity.TAttachment;
import com.bw.fit.system.entity.Tcompany;
import com.bw.fit.system.entity.TdataDict;
import com.bw.fit.system.entity.TelementLevel;
import com.bw.fit.system.entity.Toperation;
import com.bw.fit.system.entity.TpageElement;
import com.bw.fit.system.entity.Tpostion;
import com.bw.fit.system.entity.Trole;
import com.bw.fit.system.entity.TtoDo;
import com.bw.fit.system.entity.TtoRead;
import com.bw.fit.system.entity.Tuser;
import com.bw.fit.system.model.Attachment;
import com.bw.fit.system.model.ElementLevel;
import com.bw.fit.system.model.Menu;
import com.bw.fit.system.model.RoleAllot;
@Repository
public class SystemDaoImpl implements SystemDao {
	@Autowired
	private DaoTemplete daoTemplete;
	@Override
	public TdataDict getDictByValue(String dict_value) {
		return (TdataDict)daoTemplete.getOneData("systemSql.getDictByValue", dict_value);
	}
	@Override
	public List<TdataDict> getDataDictList(String parent_id) {
		return daoTemplete.getListData("systemSql.getDataDictList", parent_id);
	}
	@Override
	public TdataDict getThisDataDictInfo(String fdid) {
		return (TdataDict)daoTemplete.getOneData("systemSql.getThisDataDictInfo", fdid);
	}
	@Override
	public void deleteDict(String fdid) throws RbackException {
		daoTemplete.delete("systemSql.deleteDict", fdid);	
	}
	@Override
	public List<TdataDict> getChildrenDictList(String parent_id) {
		return daoTemplete.getListData("systemSql.getChildrenDictList", parent_id);
	}


	@Override
	public void createRoleElementLevel(String role_id, String menuId,
			String level_code) throws RbackException {
		TelementLevel e = new TelementLevel();
		e.setFdid(PubFun.getUUID());
		e.setRole_id(role_id);
		e.setMenu_id(menuId);
		e.setLevel_code(level_code);
		daoTemplete.insert("systemSql.createRoleElementLevel", e);
	}
	@Override
	public List<ElementLevel> getElementLevelList(ElementLevel e) {
		return daoTemplete.getListData("systemSql.getElementLevelList", e);
	}
	@Override
	public TdataDict getThisDataDictByValue(String dict_value) {
		return (TdataDict)daoTemplete.getOneData("systemSql.getThisDataDictByValue", dict_value);
	}
	@Override
	public void createDataDict(TdataDict d) throws RbackException {
		daoTemplete.insert("systemSql.createDataDict", d); 
	}
	@Override
	public void updateDataDict(TdataDict d) throws RbackException {
		daoTemplete.update("systemSql.updateDataDict", d);   
	}
	@Override
	public List<Tpostion> getPostionList(Tpostion e) {
		return daoTemplete.getListData("postionSql.getPostionList", e);
	}
	@Override
	public List<Trole> getRoleList(Trole t) {
		return daoTemplete.getListData("roleSql.getRoleList", t);
	}
	@Override
	public List<Tuser> getUserList(Tuser t) {
		return daoTemplete.getListData("userSql.getUserList", t);
	}
	@Override
	public void createPostion(Tpostion p) throws RbackException {
		daoTemplete.insert("postionSql.createPostion", p);
	}
	@Override
	public void deletePostion(String fdid) throws RbackException {
		daoTemplete.delete("postionSql.deletePostion", fdid);
	}
	@Override
	public Tpostion getPostion(String fdid) {
		return (Tpostion)daoTemplete.getOneData("postionSql.getPostion", fdid);
	}
	@Override
	public List<Tcompany> getCompanyTreeList(String parent_id) {
		return daoTemplete.getListData("companySql.getCompanyTreeList", parent_id);
	}
	@Override
	public void createCompany(Tcompany c) throws RbackException {
		daoTemplete.insert("companySql.createCompany", c);
	}
	@Override
	public Tcompany getCompany(String fdid) {
		return (Tcompany)daoTemplete.getOneData("companySql.getCompany", fdid);
	}
	@Override
	public void updateCompany(Tcompany p) throws RbackException {
		daoTemplete.update("companySql.updateCompany", p);
	}
	@Override
	public List<Menu> getMenuListByRoleId(String role_id) {
		return daoTemplete.getListData("systemSql.getMenuListByRoleId", role_id);
	}
	@Override
	public List<TdataDict> getALLPageAuths(String dict_remark) {
		return daoTemplete.getListData("systemSql.getALLPageAuths", dict_remark);
	}
	@Override
	public void createElementLevel(TelementLevel t) throws RbackException {
		daoTemplete.insert("systemSql.createElementLevel", t);
	}
	@Override
	public void deleteELE(String fdid) throws RbackException {
		daoTemplete.delete("systemSql.deleteELE", fdid);
	}
	@Override
	public void createRole(Trole role) throws RbackException {
		daoTemplete.insert("roleSql.createRole", role);
	}
	@Override
	public Trole getRole(String fdid) {
		Trole tp = new Trole();
		tp = (Trole)daoTemplete.getOneData("roleSql.getRole", fdid);
		if(tp!=null){
			Trole t = ((Trole)daoTemplete.getOneData("roleSql.getRole", tp.getParent_id()));
			tp.setParent_role_name(t!=null?t.getRole_name():"");
			return tp ;
		}else{
			return null;
		}
	}
	@Override
	public void deleteRole(String fdid) throws RbackException {
		daoTemplete.update("roleSql.deleteRole", fdid);
	}
	@Override
	public List<Menu> getMenuAuthTreeJsonByRoleId(String role_id) {
		return daoTemplete.getListData("roleSql.getMenuAuthTreeJsonByRoleId",role_id);
	}
	@Override
	public List<Toperation> getOperationsByMenuId(String menu_id, String role_id ) {
		Trole t = new Trole();
		t.setFdid(role_id);
		t.setKeyWords(menu_id);
		return daoTemplete.getListData("roleSql.getOperationsByMenuId", t);
	}
	@Override
	public List<TpageElement> getElementsByMenuId(String menu_id, String role_id ) {
		Trole t = new Trole();
		t.setFdid(role_id);
		t.setKeyWords(menu_id);
		return daoTemplete.getListData("roleSql.getElementsByMenuId", t);
	}
	@Override
	public List<RoleAllot> getChildRoleAllotsByRoleId(List item) {
		return daoTemplete.getListData("roleSql.getChildRoleAllotsByRoleId", item);
	}
	@Override
	public List<Trole> getChildrenRoles(String role_id) {
		return daoTemplete.getListData("roleSql.getChildrenRoles", role_id);
	}
	@Override
	public void deleteUser(String fdid) throws RbackException {
		daoTemplete.update("userSql.deleteUser", fdid);
	}
	@Override
	public void createUser(Tuser user) throws RbackException {
		daoTemplete.insert("userSql.createUser", user);
	}
	@Override
	public void createUser2Company(Tuser user) throws RbackException {
		daoTemplete.insert("userSql.createUser2Company", user);
	}
	@Override
	public void createUser2Postion(Tuser user) throws RbackException {
		daoTemplete.insert("userSql.createUser2Postion", user);
	}
	@Override
	public void createUser2Role(Tuser user) throws RbackException {
		daoTemplete.insert("userSql.createUser2Role", user);
	}
	@Override
	public List<TtoDo> getToDoList(TtoDo dog) {
		return daoTemplete.getListData("toDoSql.getToDoList", dog);
	}
	@Override
	public List<TtoRead> getToReadList(TtoRead dog) {
		return daoTemplete.getListData("toReadSql.getToReadList", dog);
	}
	@Override
	public List<TdataDict> getDataDictOfPId(String fdid) {
		return daoTemplete.getListData("systemSql.getDataDictOfPId", fdid);
	}
	@Override
	public TtoDo getToDoDetail(TtoDo dog) {
		return (TtoDo)daoTemplete.getOneData("toDoSql.getToDoDetail", dog);
	}
	@Override
	public TtoRead getToReadDetail(TtoRead dog) {
		return (TtoRead)daoTemplete.getOneData("toReadSql.getToDetailDetail", dog);
	}
	@Override
	public void delAuthoryOperation(BaseEntity en) throws RbackException {
		daoTemplete.delete("roleSql.delAuthoryOperation", en);
	}
	@Override
	public void delAuthoryElement(BaseEntity en) throws RbackException {
		daoTemplete.delete("roleSql.delAuthoryElement", en);
	}
	@Override
	public void createAuthoryElement(BaseEntity en) throws RbackException {
		daoTemplete.insert("roleSql.createAuthoryElement", en);
	}
	@Override
	public void createAuthoryOperation(BaseEntity en) throws RbackException {
		daoTemplete.insert("roleSql.createAuthoryOperation", en);
	}
	@Override
	public void createAuthoritymenu(BaseEntity en) throws RbackException {
		daoTemplete.insert("roleSql.createAuthoritymenu", en);
	}
	@Override
	public int getAuthoritymenu(BaseEntity en) {
		return (int)daoTemplete.getOneData("roleSql.getAuthoritymenu", en);
	}
	@Override
	public void createNewAttachment(TAttachment a) throws RbackException {
		daoTemplete.insert("systemSql.createNewAttachment", a);
	}
	@Override
	public List<TAttachment> getAttachmentList(TAttachment a) {
		return daoTemplete.getListData("systemSql.getAttachmentList", a);
	}
	@Override
	public void deleteAttachment(TAttachment a) throws RbackException {
		daoTemplete.update("systemSql.deleteAttachment", a);
	}
	@Override
	public TAttachment getAttachment(String fdid) {
		return (TAttachment)daoTemplete.getOneData("systemSql.getAttachment", fdid);
	}
	
	
	
}
