package com.bw.fit.system.address.controller;

import static com.bw.fit.system.common.util.PubFun.getCurrentSession;
import static com.bw.fit.system.common.util.PubFun.returnFailJson;
import static com.bw.fit.system.common.util.PubFun.returnSuccessJson;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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
		if(o) {
			List<VAddress> orgList = addressDao.getAddress("organization", orgId);
			if(orgList!=null&&orgList.size()>0) {
				for(VAddress p1 : orgList) {
					map.put(p1.getId(), p1.getName());
				}
			}
			
		}
		if(p) {
			List<VAddress> positionList = addressDao.getAddress("position", orgId);
			if(positionList!=null&&positionList.size()>0) {
				for(VAddress p1 : positionList) {
					map.put(p1.getId(), p1.getName());
				}
			}
			
		}
		if(a) {
			List<VAddress> accountList = addressDao.getAddress("account", orgId);
			if(accountList!=null&&accountList.size()>0) {
				for(VAddress p1 : accountList) {
					map.put(p1.getId(), p1.getName());
				}
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
	 * @return
	 */
	@RequestMapping(value="address/{orgId}/{o}/{p}/{a}",method=RequestMethod.GET,produces="application/json;charset=UTF8")
	@ResponseBody
	public JSONObject get(@PathVariable String orgId,@PathVariable boolean o,@PathVariable boolean p,@PathVariable boolean a){
		JSONObject json = new JSONObject();
		Map<String,String> map = new HashMap<>();
		if(o) {
			List<VAddress> orgList = addressDao.getAddress("organization", orgId);
			if(orgList!=null&&orgList.size()>0) {
				for(VAddress p1 : orgList) {
					map.put(p1.getId(), p1.getName());
				}
			}
		}
		if(p) {
			List<VAddress> positionList = addressDao.getAddress("position", orgId);
			if(positionList!=null&&positionList.size()>0) {
				for(VAddress p1 : positionList) {
					map.put(p1.getId(), p1.getName());
				}
			}
		}
		if(a) {
			List<VAddress> accountList = addressDao.getAddress("account", orgId);
			if(accountList!=null&&accountList.size()>0) {
				for(VAddress p1 : accountList) {
					map.put(p1.getId(), p1.getName());
				}
			}
		}
		json = new JSONObject();
		returnSuccessJson(json);
		json.put("addressMap", (JSONObject)JSONObject.toJSON(map) );
		return json ;
	}
}
