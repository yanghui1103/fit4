package com.bw.fit.system.organization.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bw.fit.system.common.controller.BaseController;
import com.bw.fit.system.common.util.PubFun;
import com.bw.fit.system.organization.dao.OrganizationDao;
import com.bw.fit.system.organization.model.Organization;

/*****
 * 组织Controller
 * @author yangh
 *
 */
@RequestMapping("org")
@Controller
public class OrganizationController extends BaseController {

	@Autowired
	private OrganizationDao organizationDao;
	/******
	 * 增加组织
	 * @param org
	 * @param result
	 * @return
	 */
	@RequestMapping(value="organization",method=RequestMethod.POST,produces="application/json;charset=UTF8")
	@ResponseBody
	public JSONObject add(@Valid @ModelAttribute Organization org,BindingResult result){
		
		return null ;
	}
	
	/****
	 * 删除组织
	 * @param id
	 * @return
	 */
	@RequestMapping(value="organization/{id}",method=RequestMethod.DELETE,produces="application/json;charset=UTF8")
	@ResponseBody
	public JSONObject delete(@PathVariable String id){
		
		return null ;
	}
	
	/*****
	 * 修改组织
	 * @param org
	 * @return
	 */
	@RequestMapping(value="organization",method=RequestMethod.PUT,produces="application/json;charset=UTF8")
	@ResponseBody
	public JSONObject update(@Valid @ModelAttribute Organization org){
		
		return null ;
	}
	/*****
		 * 可以翻页，获取组织列表
		 * @param org
		 * @return
		 */
		@RequestMapping(value="organizations",method=RequestMethod.GET,produces="application/json;charset=UTF8")
		@ResponseBody
		public JSONObject organizations(@Valid @ModelAttribute Organization org){
			JSONObject js = new JSONObject();
			JSONArray array = new JSONArray();
			List<Organization> list = organizationDao.getOrganizations(org);
			if(list==null||list.size()<1){
				PubFun.returnFailJson(js, "无数据");
				return js ;
			}
			for(Organization o:list){
				JSONObject j = new JSONObject();
				j.put("id", o.getId());
				j.put("pId", o.getParentId());
				j.put("name", o.getName());
				array.add(j);
			}
			js.put("res", "2");
			js.put("list", array);
			return js ;
		}
}
