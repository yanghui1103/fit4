package com.bw.fit.system.role.dao;

import java.util.List;

import com.bw.fit.system.authority.entity.TAuthority;
import com.bw.fit.system.authority.entity.TRole2dataauth;
import com.bw.fit.system.common.model.BaseModel;
import com.bw.fit.system.common.model.RbackException;
import com.bw.fit.system.menu.model.Menu;
import com.bw.fit.system.role.entity.TRole;
import com.bw.fit.system.role.entity.TRole2Authority;
import com.bw.fit.system.role.model.Role;

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
	/****
	 * 查询角色翻页
	 * @param role
	 * @return
	 */
	public List<TRole> getRoles(TRole role);
	
	public void delete(String id) throws RbackException ;
	/****
	 * 增加
	 * @param trole
	 * @throws RbackException
	 */
	public void insert(TRole trole) throws RbackException ;
	/****
	 * 这个角色的功能权限
	 * @param roleId
	 * @return
	 */
	public List<TAuthority> getAuthsOfThisRole(String roleId);
	/****
	 * 获取角色实体
	 * @param id
	 * @return
	 */
	public TRole get(String id);
	/****
	 * 赋权
	 * @param ta
	 * @throws RbackException
	 */
	public void grantAuthority2Role(TRole2Authority ta)  throws RbackException ;
	/****
	 * delete赋权
	 * @param ta
	 * @throws RbackException
	 */
	public void deleteAuthority2Role(TRole2Authority ta)  throws RbackException ;
	/****
	 * 获取该角色下所有权限
	 * @param ta
	 * @return
	 */
	public List<TAuthority> getAuthority2Role(TRole2Authority ta);
	/*****
	 * 根据角色id查询拥有的数据权限
	 * @param roleId
	 * @return
	 */
	public List<TRole2dataauth> getDataAuthoritysByRole(String roleId);
	/*****
	 * 给角色赋数据权限 
	 * @param ta
	 * @throws RbackException
	 */
	public  void grantDataAuthority2Role(BaseModel ta)  throws RbackException ; 
	public  void deleteDataAuthority2Role(String roleId)  throws RbackException ; 
	
	/****
	 * 删除角色下菜单权限
	 */
	public void deleteRole2Menus(String roleId)  throws RbackException ; 
	/****
	 * 角色下所有菜单
	 * @param roleId
	 * @return
	 */
	public List<Menu> getMenusOfRole(String roleId);
	/****
	 * 给角色分配菜单
	 * @param ta
	 * @throws RbackException
	 */
	public void grantMenus2role(BaseModel ta)  throws RbackException ; 
	/****
	 * 查询所有符合的角色
	 * @return
	 */
	public List<TRole> getAllRoles(String keyWords);
}
