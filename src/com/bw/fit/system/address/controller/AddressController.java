package com.bw.fit.system.address.controller;

import static com.bw.fit.system.common.util.PubFun.getCurrentSession;
import static com.bw.fit.system.common.util.PubFun.returnFailJson;
import static com.bw.fit.system.common.util.PubFun.returnSuccessJson;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.shiro.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.bw.fit.system.account.model.Account;
import com.bw.fit.system.address.dao.AddressDao;
import com.bw.fit.system.address.entity.VAddress;
import com.bw.fit.system.common.model.BaseModel;
import com.bw.fit.system.organization.dao.OrganizationDao;
import com.bw.fit.system.organization.model.Organization;
import com.bw.fit.system.position.dao.PositionDao;
import com.bw.fit.system.position.model.Position;
import com.bw.fit.system.position.service.PositionService;

@RequestMapping("address")
@Controller
public class AddressController {
	
	@Autowired
	private AddressDao addressDao ;
	
	@Autowired
	private OrganizationDao organizationDao ;
	/***
	 * 打开地址本
	 * @param orgIds
	 * @param orgNames
	 * @param model
	 * @return
	 */
	@RequestMapping("openAddressPage/{o}/{p}/{a}/{idsObj}")
	public String openAddressPage(Model model,@PathVariable boolean o,@PathVariable boolean p,@PathVariable boolean a,@PathVariable String idsObj){
		Session session = getCurrentSession();
		Account account = (Account)session.getAttribute("CurrentUser");
		String orgId = account.getCurrentOrgId();
		//待选列表
		Map<String,String> map = new HashMap<>();
		List<VAddress> orgList = new ArrayList<>();
		List<VAddress> positionList = new ArrayList<>();
		List<VAddress> accountList = new ArrayList<>();
		
		orgList = o?addressDao.getAddressByOrgId("organization", orgId):null;
		positionList = p?addressDao.getAddressByOrgId("position", orgId):null;
		accountList = a?addressDao.getAddressByOrgId("account", orgId):null;
		
		if(orgList!=null&&orgList.size()>0) {
			for(VAddress p1 : orgList) {
				map.put(p1.getId(), p1.getName());
			}
		}
		if(positionList!=null&&positionList.size()>0) {
			for(VAddress p1 : positionList) {
				map.put(p1.getId(), p1.getName());
			}
		}
		if(accountList!=null&&accountList.size()>0) {
			for(VAddress p1 : accountList) {
				map.put(p1.getId(), p1.getName());
			}
		}
		//已选列表
		Map<String,String> map2 = new HashMap<>();
		String ids[] = idsObj.split(",");
		if(ids.length>0) {
			for(String id : ids) {
				VAddress addr = addressDao.get(id);
				map2.put(addr.getId(), addr.getName());
			}
		}
		model.addAttribute("selectMap", map);
		model.addAttribute("selectedMap", map2);
		model.addAttribute("ifshow_org", o);
		model.addAttribute("ifshow_position", p);
		model.addAttribute("ifshow_account", a);
		return "system/address/addressPage" ;
	}
	
	/*****
	 * 地址本中点击左侧组织树，响应右侧待选
	 * @param orgId 组织id
	 * @param o是否查询组织
	 * @param p是否查询岗位
	 * @param a是否查询账号
	 * @param type查询类型：true:搜索框查询false：点击左侧组织树查询
	 * @return
	 */
	@RequestMapping(value="address/{keyWords}/{o}/{p}/{a}/{type}",method=RequestMethod.GET,produces="application/json;charset=UTF8")
	@ResponseBody
	public JSONObject get(@PathVariable String keyWords,@PathVariable boolean o,@PathVariable boolean p,@PathVariable boolean a,@PathVariable boolean type){
		JSONObject json = new JSONObject();
		Map<String,String> map = new HashMap<>();
		List<VAddress> orgList = new ArrayList<>();
		List<VAddress> positionList = new ArrayList<>();
		List<VAddress> accountList = new ArrayList<>();
		try {
			keyWords = (URLDecoder.decode(keyWords, "UTF-8"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(type) {
			orgList = o?addressDao.getAddressByKey("organization", keyWords):null;
			positionList = p?addressDao.getAddressByKey("position", keyWords):null;
			accountList = a?addressDao.getAddressByKey("account", keyWords):null;
		}else {
			orgList = o?addressDao.getAddressByOrgId("organization", keyWords):null;
			positionList = p?addressDao.getAddressByOrgId("position", keyWords):null;
			accountList = a?addressDao.getAddressByOrgId("account", keyWords):null;
		}
		
		if(orgList!=null&&orgList.size()>0) {
			for(VAddress p1 : orgList) {
				map.put(p1.getId(), p1.getName());
			}
		}
		if(positionList!=null&&positionList.size()>0) {
			for(VAddress p1 : positionList) {
				map.put(p1.getId(), p1.getName());
			}
		}
		if(accountList!=null&&accountList.size()>0) {
			for(VAddress p1 : accountList) {
				map.put(p1.getId(), p1.getName());
			}
		}
		
		json = new JSONObject();
		returnSuccessJson(json);
		json.put("addressMap", (JSONObject)JSONObject.toJSON(map) );
		return json ;
	}
	
	@RequestMapping(value="addressDetail/{id}",method=RequestMethod.GET,produces="application/json;charset=UTF8")
	@ResponseBody
	public JSONObject addressDetail(@PathVariable String id){
		Map<String,String> map = new HashMap<>();
		map.put("105001", "信息公司");
		map.put("105001001", "信息公司下的软件开发部门");
		map.put("1e9d68a118514792bc6523182c1c3b55", "软件开发部门的软件开发岗位");
		map.put("481908ea568444729707ed459b2d8497", "软件开发部门的软件运维岗位");
		JSONObject json  = new JSONObject();
		returnSuccessJson(json);
		json.put("detali",map.get(id));
		return json;
	}
}
