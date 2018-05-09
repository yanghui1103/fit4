package com.bw.fit.system.organization.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.bw.fit.common.controller.BaseController;
import com.bw.fit.system.organization.model.Organization;

/*****
 * 组织Controller
 * @author yangh
 *
 */
@RequestMapping("org")
@Controller
public class OrganizationController extends BaseController {

	
	
	@RequestMapping(value="organization",method=RequestMethod.POST,produces="application/json;charset=UTF-8")
	@ResponseBody
	public JSONObject add(@Valid @ModelAttribute Organization org,BindingResult result){
		
		return null ;
	}
	
	@RequestMapping(value="organization/{id}",method=RequestMethod.DELETE,produces="application/json;charset=UTF-8")
	@ResponseBody
	public JSONObject delete(@PathVariable String id){
		
		return null ;
	}
	

	@RequestMapping(value="organization",method=RequestMethod.PUT,produces="application/json;charset=UTF-8")
	@ResponseBody
	public JSONObject update(@Valid @ModelAttribute Organization org){
		
		return null ;
	}
}
