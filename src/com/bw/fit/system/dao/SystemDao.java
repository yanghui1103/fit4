package com.bw.fit.system.dao;

import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bw.fit.common.entity.BaseEntity;
import com.bw.fit.common.model.RbackException;
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
import com.bw.fit.system.model.Postion;
import com.bw.fit.system.model.RoleAllot;

/****
 * 系统基础持久层
 * @author yangh
 *
 */
public interface SystemDao {
	 
	/****
	 * 新建一个数据字典记录
	 * @param d 
	 */
	public void createDataDict(TdataDict d)  throws RbackException ;
	public void updateDataDict(TdataDict d)  throws RbackException ;

	/****
	 * 根据值获取数据字典对象
	 * @param dict_value
	 * @return
	 */
	public TdataDict getDictByValue(String dict_value);
	/****
	 * 获取父节点下所有子孙节点
	 * @param c
	 * @return
	 */
	public List<TdataDict> getDataDictList(String parent_id);
	public List<Tcompany> getCompanyTreeList(String parent_id);
	/****
	 * 此节点信息(数据字典)
	 * @param fdid
	 * @return
	 */
	public TdataDict getThisDataDictInfo(String fdid);
	/****
	 * 此节点信息(数据字典)
	 * @param dict_value 值
	 * @return
	 */
	public TdataDict getThisDataDictByValue(String dict_value);
	
	public void deleteDict(String fdid) throws RbackException;
	
	/****
	 * 根据父节点，查询所有子孙的节点
	 * @param parent_id
	 * @return
	 */
	public List<TdataDict> getChildrenDictList(String parent_id);
	
	/****
	 * 给角色对某个页面进行
	 * 数据权限分配
	 * @param role_id 角色
	 * @param menuId 菜单页面ID
	 * @param level_code 权限级别
	 * @throws RbackException
	 */
	public void createRoleElementLevel(String role_id,String menuId,String level_code) throws RbackException;
	/****
	 * 查询数据库功能权限级别列表
	 * @param e
	 * @return
	 */
	public List<ElementLevel> getElementLevelList(ElementLevel e);

	/***
	 * 获取岗位列表
	 * @param e
	 * @return
	 */
	public List<Tpostion> getPostionList(Tpostion e);
	
	public List<Trole> getRoleList(Trole t);
	public List<Tuser> getUserList(Tuser t);
	/****
	 * 保存岗位
	 * @param p
	 * @throws RbackException
	 */
	public void createPostion(Tpostion p) throws RbackException;
	/***
	 * 删除岗位
	 * @param fdid 岗位ID
	 * @throws RbackException
	 */
	public void deletePostion(String fdid) throws RbackException;
	/***
	 * 获取岗位
	 * @param fdid id
	 * @return
	 */
	public Tpostion getPostion(String fdid)  ;
	/***
	 * 保存新组织
	 * @param c
	 * @throws RbackException
	 */
	public void createCompany(Tcompany c)  throws RbackException;
	
	public Tcompany getCompany(String fdid);
	public void updateCompany(Tcompany p)  throws RbackException;
	public List<Menu> getMenuListByRoleId(String role_id);
	/****
	 * 查询这组数据字典
	 * 的所有值
	 * @param dict_remark
	 * @return
	 */
	public List<TdataDict> getALLPageAuths(String dict_remark);
	/****
	 * 保存页面权限
	 * @param t
	 * @throws RbackException
	 */
	public void createElementLevel(TelementLevel t)   throws RbackException;
	/****
	 * 删除页面权限 （真删）
	 * @param fdid
	 * @throws RbackException
	 */
	public void deleteELE(String fdid)  throws RbackException;
	/***
	 * 增加一个新角色
	 * @param role
	 * @throws RbackException
	 */
	public void createRole(Trole role) throws RbackException;
	public Trole getRole(String fdid) ;
	/****
	 * 删除角色
	 * @param fdid 记录id
	 * @throws RbackException
	 */
	public void deleteRole(String  fdid) throws RbackException;
	/***
	 * 根据角色id查询其菜单
	 * @param role_id
	 * @return
	 */
	public List<Menu> getMenuAuthTreeJsonByRoleId(String role_id);
	/****
	 * 根据角色，菜单获取拥有的功能
	 * @param menu_id
	 * @param role_id 
	 * @return
	 */
	public List<Toperation> getOperationsByMenuId(String menu_id,String role_id);
	/****
	 * 根据角色，菜单获取拥有的页面元素权限
	 * @param menu_id
	 * @param role_id
	 * @return
	 */
	public List<TpageElement> getElementsByMenuId(String menu_id,String role_id);
	/*****
	 * 根据角色id查询出所有子孙
	 * 的授权情况列表
	 * @return
	 */
	public List<RoleAllot> getChildRoleAllotsByRoleId(List item);
	/***
	 * 获取此角色id下所有子孙角色
	 * @param role_id
	 * @return
	 */
	public List<Trole> getChildrenRoles(String role_id);
	/****
	 * 删除用户
	 * @param fdid
	 * @throws RbackException
	 */
	public void deleteUser(String fdid) throws RbackException;
	/***
	 * 新建用户
	 * @param user
	 * @throws RbackException
	 */
	public void createUser(Tuser user) throws RbackException;
	public void createUser2Company(Tuser user) throws RbackException;
	public void createUser2Postion(Tuser user) throws RbackException;
	public void createUser2Role(Tuser user) throws RbackException;
	/****
	 * 分页获取待阅列表
	 * @param dog 查询条件
	 * @return
	 */
	public List<TtoRead> getToReadList(TtoRead dog);
	/****
	 * 分页获取待办列表
	 * @param dog 查询条件
	 * @return
	 */
	public List<TtoDo> getToDoList(TtoDo dog);
	/*****
	 * 查询这个节点下一层的数据字典
	 * @param parent_id
	 * @return
	 */
	public List<TdataDict> getDataDictOfPId(String parent_id);
	/*****
	 * 获取待办详情
	 * @param dog
	 * @return
	 */
	public TtoDo getToDoDetail(TtoDo dog);
	/*****
	 * 获取待阅详情
	 * @param dog
	 * @return
	 */
	public TtoRead getToReadDetail(TtoRead dog);
	/*****
	 * 删除角色下操作功能权限
	 * @param en
	 * @throws RbackException
	 */
	public void delAuthoryOperation(BaseEntity en) throws RbackException ;
	/****
	 * 删除角色下元素权限
	 * @param en
	 * @throws RbackException
	 */
	public void delAuthoryElement(BaseEntity en) throws RbackException ;
	public void createAuthoryElement(BaseEntity en) throws RbackException ;
	public void createAuthoryOperation(BaseEntity en) throws RbackException ;
	public void createAuthoritymenu(BaseEntity en) throws RbackException ;
	public int getAuthoritymenu(BaseEntity en);
	public void createNewAttachment(TAttachment a) throws RbackException ;
	public List<TAttachment> getAttachmentList(TAttachment c);

	public void deleteAttachment(TAttachment a) throws RbackException ;
	
	public TAttachment getAttachment(String fdid);
	
}
 