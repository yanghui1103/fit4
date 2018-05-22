package com.bw.fit.system.role.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.bw.fit.system.common.controller.BaseController;
import com.bw.fit.system.common.model.RbackException;
import com.bw.fit.system.common.util.PubFun;
import com.bw.fit.system.role.dao.RoleDao;
import com.bw.fit.system.role.entity.TRole;
import com.bw.fit.system.role.model.Role;
import com.bw.fit.system.role.service.RoleService;
import com.bw.fit.system.user.entity.TUser;
/*****
 * 角色模块controller
 * @author yangh
 *
 */
@RequestMapping("role")
@Controller
public class RoleController extends BaseController {

	@Autowired
	private RoleDao roleDao;
	@Autowired
	private RoleService roleService;
	
	@RequestMapping(value="roles",method=RequestMethod.GET,produces="application/json;charset=UTF-8")
	@ResponseBody
	public JSONObject roles(@ModelAttribute Role role){
		JSONObject json = new JSONObject(); 
		TRole u = new TRole();
		PubFun.copyProperties(u, role);
		u.setPaginationEnable("1");
		List<TRole> list = roleDao.getRoles(u); 
		u.setPaginationEnable("0");
		List<TRole> listTotal = roleDao.getRoles(u); 
		if (listTotal != null && listTotal.size() > 0) {
			json.put("total", listTotal.size());
		} else {
			json.put("total", 0);
		}
		json.put("rows", JSONObject.toJSON(list));
		return json;
	}
	
	@RequestMapping(value="role/{id}",method=RequestMethod.DELETE,produces="application/json;charset=UTF-8")
	@ResponseBody
	public JSONObject delete(@PathVariable String id){
		JSONObject json = new JSONObject();		
		try {
			json = roleService.delete(id);
		} catch (RbackException e) {
			e.printStackTrace();
			json = new JSONObject();
			PubFun.returnFailJson(json, e.getMsg());
		}finally{
			return json ;
		}
	}
}
