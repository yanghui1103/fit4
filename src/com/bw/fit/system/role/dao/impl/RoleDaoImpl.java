package com.bw.fit.system.role.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bw.fit.system.authority.entity.TAuthority;
import com.bw.fit.system.common.dao.DaoTemplete;
import com.bw.fit.system.menu.model.Menu;
import com.bw.fit.system.role.dao.RoleDao;
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

}
