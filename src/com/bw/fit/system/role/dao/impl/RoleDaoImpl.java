package com.bw.fit.system.role.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bw.fit.system.authority.entity.TAuthority;
import com.bw.fit.system.common.dao.DaoTemplete;
import com.bw.fit.system.common.model.RbackException;
import com.bw.fit.system.menu.model.Menu;
import com.bw.fit.system.role.dao.RoleDao;
import com.bw.fit.system.role.entity.TRole;
import com.bw.fit.system.role.entity.TRole2Authority;
@Repository
public class RoleDaoImpl implements RoleDao {

	@Autowired
	private DaoTemplete daoTemplete;
	
	@Override
	public List<TAuthority> getAuthoritysByRole(String roleId) {
		return daoTemplete.getListData("roleSql.getAuthoritysByRole", roleId);
	}

	@Override
	public List<Menu> getMenusByRole(String roleId) {
		return daoTemplete.getListData("roleSql.getMenusByRole", roleId);
	}

	@Override
	public List<TRole> getRoles(TRole role) {
		List<TRole> list = daoTemplete.getListData("roleSql.getRoles", role);
		for (TRole t:list){
			t.setTemp_str1(String.valueOf((Integer)daoTemplete.getOneData("roleSql.getAccountCntOfRole",t.getId())));
		}
		return list ;
	}

	@Override
	public void delete(String id) throws RbackException {
		daoTemplete.update("roleSql.delete", id);
	}

	@Override
	public void insert(TRole trole) throws RbackException {
		daoTemplete.insert("roleSql.insert", trole);
	}

	@Override
	public List<TAuthority> getAuthsOfThisRole(String roleId) {
		return daoTemplete.getListData("roleSql.getAuthsOfThisRole", roleId);
	}

	@Override
	public TRole get(String id) {
		return (TRole)daoTemplete.getOneData("roleSql.get", id);
	}

	@Override
	public void grantAuthority2Role(TRole2Authority ta) throws RbackException {
		daoTemplete.insert("roleSql.insertAuthority2Role",ta);
	}

	@Override
	public void deleteAuthority2Role(TRole2Authority ta) throws RbackException {
		// TODO Auto-generated method stub
		daoTemplete.delete("roleSql.deleteAuthority2Role", ta);
	}


}
