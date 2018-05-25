package com.bw.fit.system.role.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.apache.shiro.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bw.fit.system.authority.dao.AuthorityDao;
import com.bw.fit.system.authority.entity.TAuthority;
import com.bw.fit.system.authority.entity.TRole2dataauth;
import com.bw.fit.system.common.controller.BaseController;
import com.bw.fit.system.common.model.BaseModel;
import com.bw.fit.system.common.model.RbackException;
import com.bw.fit.system.common.util.PubFun;
import com.bw.fit.system.dict.dao.DictDao;
import com.bw.fit.system.dict.entity.TdataDict;
import com.bw.fit.system.dict.model.DataDict;
import com.bw.fit.system.dict.model.Dict;
import com.bw.fit.system.dict.service.DictService;
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
	private DictService dictService ;
	@Autowired
	private RoleDao roleDao;
	@Autowired
	private RoleService roleService;
	@Autowired
	private AuthorityDao authorityDao;
	@Autowired
	private DictDao dictDao;
	
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
	
	@RequestMapping(value="role",method=RequestMethod.POST,produces="application/json;charset=UTF-8")
	@ResponseBody
	public JSONObject add(@Valid @ModelAttribute Role role){
		JSONObject json = new JSONObject();		
		try {
			Session session = PubFun.getCurrentSession();
			PubFun.fillCommonProptities(role, true, session);
			json = roleService.insert(role);
		} catch (RbackException e) {
			e.printStackTrace();
			json = new JSONObject();
			PubFun.returnFailJson(json, e.getMsg());
		}finally{
			return json ;
		}
	}
	
	
	@RequestMapping("openAddRole/{id}/{name}")
	public String openAddRole(@PathVariable(value="id") String id,@PathVariable(value="name") String name,Model model){
		model.addAttribute("roleName", name);
		
		return null ;
	}
	
	
	@RequestMapping("authsOfRole/{roleId}")
	public String authsOfRole(@PathVariable String roleId,Model model){
		model.addAttribute("role", roleDao.get(roleId));
		TAuthority ta = new TAuthority();
		List<TAuthority> all = authorityDao.authoritys(ta);
		List<TAuthority> my = roleDao.getAuthoritysByRole(roleId);
		for(TAuthority t:all){
			if(my!=null){
				Optional<TAuthority> ops = my.parallelStream().filter(x->x.getCode().equals(t.getCode())).findAny();
				t.setDesp(ops.isPresent()?"checked":"false");
			}
		}
		model.addAttribute("all", all);
		return "system/role/role2AuthPage";
	}

	/*****
	 * 分配功能权限
	 * @param temp_str1
	 * @param id
	 * @return
	 * @throws RbackException
	 */
	@RequestMapping(value="authsOfRole",method=RequestMethod.PUT,produces="application/json;charset=UTF-8")
	@ResponseBody
	public JSONObject update(@RequestParam(value="temp_str1") String temp_str1,
			@RequestParam(value="id") String[] id) throws RbackException{
		JSONObject json = new JSONObject();		
		json = roleService.updateAuthsOfRole(temp_str1,id);
		return json ;	
	}
	

	@RequestMapping("dataAuthsOfRole/{roleId}")
	public String dataAuthsOfRole(@PathVariable String roleId,Model model){
		model.addAttribute("role", roleDao.get(roleId));
		Dict dd = dictService.getDictsByParentValue("dataAuth");
		List<TdataDict> tds =  dictDao.getDictsByPid(dd.getId());
		List<TRole2dataauth> my = roleDao.getDataAuthoritysByRole(roleId);
		for(TdataDict t:tds){
			if(my!=null){
				Optional ops = my.parallelStream().filter(x->x.getAuthId().equals(t.getDict_value())).findAny();
				if(ops.isPresent()){
					t.setLogId("checked");
				}
			}
		}
		model.addAttribute("all", tds);
		return "system/role/role2DataAuthPage";
	}

	
	@RequestMapping(value="saveDataAuthsOfRole",method=RequestMethod.PUT,produces="application/json;charset=UTF-8")
	@ResponseBody
	public JSONObject saveAuthsOfRole(@RequestParam(value="temp_str1") String temp_str1,
			@RequestParam(value="id") String id) throws RbackException{
		JSONObject json = new JSONObject();		
		json = roleService.saveDataAuthsOfRole(temp_str1,id);
		return json ;	
	}
	
}