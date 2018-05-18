package com.bw.fit.system.role.dao;

import java.util.List;

import com.bw.fit.system.authority.entity.TAuthority;
import com.bw.fit.system.menu.model.Menu;

public interface RoleDao {

	/****
	 * 根据角色id查询旗下所有权限 
	 * @param roleId
	 * @return
	 */
	public List<TAuthority> getAuthoritysByRole(String roleId);
	/****
	 * 角色下拥有的有效菜单
	 * @param roleId
	 * @return
	 */
	public List<Menu> getMenusByRole(String roleId);
}
