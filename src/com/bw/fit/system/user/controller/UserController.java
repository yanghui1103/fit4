package com.bw.fit.system.user.controller;

import static com.bw.fit.system.common.util.PubFun.returnFailJson;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bw.fit.system.common.controller.BaseController;
import com.bw.fit.system.common.util.PubFun;
import com.bw.fit.system.organization.model.Organization;
import com.bw.fit.system.user.dao.UserDao;
import com.bw.fit.system.user.entity.TUser;
import com.bw.fit.system.user.model.User;

/****
 * 用户层，controller
 * @author yangh
 *
 */
@RequestMapping("user")
@Controller
public class UserController  extends BaseController{

	@Autowired
	private UserDao userDao;
	
	@RequestMapping(value="users",method=RequestMethod.GET,produces="application/json;charset=UTF-8")
	@ResponseBody
	public JSONObject users(@ModelAttribute User user){
		JSONObject json = new JSONObject(); 
		TUser u = new TUser();
		PubFun.copyProperties(u, user);
		u.setPaginationEnable("1");
		List<TUser> list = userDao.getUsers(u);
		u.setPaginationEnable("0");
		List<TUser> listTotal = userDao.getUsers(u);
		if (listTotal != null && listTotal.size() > 0) {
			json.put("total", listTotal.size());
		} else {
			json.put("total", 0);
		}
		json.put("rows", JSONObject.toJSON(list));
		return json;
	}
	
	@RequestMapping("openUserDetail/{id}")
	public String openUserDetail(@PathVariable String id,Model model){
		User user = new User();
		TUser tu = userDao.get(id);
		PubFun.copyProperties(user, tu);
		model.addAttribute("user", user);
		return "system/user/userDetailPage";
	}
}
