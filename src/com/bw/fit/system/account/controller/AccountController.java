package com.bw.fit.system.account.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bw.fit.system.account.model.Account;
import com.bw.fit.system.account.service.AccountService;
import com.bw.fit.system.common.controller.BaseController;
import com.bw.fit.system.common.util.PubFun;
import com.bw.fit.system.menu.model.Menu;
import com.bw.fit.system.menu.service.MenuService;

@RequestMapping("account")
@Controller
public class AccountController extends BaseController {

	@Autowired
	private AccountService accountService ;
	@Autowired
	private MenuService menuService ;
	
	/****
	 * 获取当前用户左侧菜单树
	 * menu.js 调用
	 * @return
	 */
	@RequestMapping(value="menus",method=RequestMethod.GET)
	@ResponseBody
	public JSONArray getMenus(){
		Account account = PubFun.getCurrentAccount();
		List<Menu> menus = accountService.getMenusOfThisAccount(account.getLogName());
		return menuService.getMenuTreeJson(menus);		
	}
}
