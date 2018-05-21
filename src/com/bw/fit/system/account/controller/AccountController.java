package com.bw.fit.system.account.controller;

import static com.bw.fit.system.common.util.PubFun.returnFailJson;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bw.fit.system.account.dao.AccountDao;
import com.bw.fit.system.account.model.Account;
import com.bw.fit.system.account.service.AccountService;
import com.bw.fit.system.common.controller.BaseController;
import com.bw.fit.system.common.model.RbackException;
import com.bw.fit.system.common.util.PubFun;
import com.bw.fit.system.menu.model.Menu;
import com.bw.fit.system.menu.service.MenuService;
import com.bw.fit.system.organization.model.Organization;

@RequestMapping("account")
@Controller
public class AccountController extends BaseController {

	@Autowired
	private AccountDao accountDao ;
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
	
	@RequestMapping(value="accounts",method=RequestMethod.GET,produces="application/json;charset=UTF-8")
	@ResponseBody
	public JSONObject accounts(@ModelAttribute Account account){
		JSONObject js = new JSONObject();
		account.setPaginationEnable("1");
		List<Account> list = accountDao.getAccounts(account);
		for(Account a:list){
			a.setIsdeleted("0".equals(a.getIsdeleted())?"正常":"已作废");
		}
		account.setPaginationEnable("0");
		List<Account> listTatol = accountDao.getAccounts(account);
		js.put("total", (listTatol!=null&& listTatol.size() > 0)?listTatol.size():0);
		js.put("rows",  JSONObject.toJSON(list));
		return js ;
	}
	
	@RequestMapping(value="account/{id}",method=RequestMethod.DELETE,produces="application/json;charset=UTF-8")
	@ResponseBody
	public JSONObject delete(@PathVariable String id){
		JSONObject json = new JSONObject();		
		try {
			json = accountService.delete(id);
		} catch (RbackException e) {
			e.printStackTrace();
			json = new JSONObject();		
			PubFun.returnFailJson(json, e.getMsg());
			throw e;
		}finally{
			return json ;
		}
	}
	
}
