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
	
	/***
	 * 打开地址本
	 * @param orgIds
	 * @param orgNames
	 * @param model
	 * @return
	 */
	@RequestMapping("openAddressPage/{o}/{p}/{a}")
	public String openAddressPage(Model model,@PathVariable String o,@PathVariable String p,@PathVariable String a){
		Session session = getCurrentSession();
		Account account = (Account)session.getAttribute("CurrentUser");
		String orgId = account.getCurrentOrgId();
		Map<String,String> map = new HashMap<>();
		if(!"-1".equals(o)) {
			List<VAddress> orgList = addressDao.getAddress("organization", orgId);
			if(orgList!=null&&orgList.size()>0) {
				for(VAddress p1 : orgList) {
					map.put(p1.getId(), p1.getName());
				}
			}
			
		}
		if(!"-1".equals(p)) {
			List<VAddress> positionList = addressDao.getAddress("position", orgId);
			if(positionList!=null&&positionList.size()>0) {
				for(VAddress p1 : positionList) {
					map.put(p1.getId(), p1.getName());
				}
			}
			
		}
		if(!"-1".equals(a)) {
			List<VAddress> accountList = addressDao.getAddress("account", orgId);
			if(accountList!=null&&accountList.size()>0) {
				for(VAddress p1 : accountList) {
					map.put(p1.getId(), p1.getName());
				}
			}
			
		}
//		String[] ids =null;
//		List<VAddress> positionList = addressDao.getAddress("", "105");
		
//		for(String id:ids) {
//			Optional<BaseModel> o = positionList.parallelStream().filter(x->x.equals(id)).findAny();
//		}
		
		model.addAttribute("selectMap", map);
		return "system/address/addressPage" ;
	}
	
	
	@RequestMapping(value="address/{orgId}",method=RequestMethod.GET,produces="application/json;charset=UTF8")
	@ResponseBody
	public JSONObject get(@PathVariable String orgId){
		JSONObject json = new JSONObject();
		Map<String,String> map = new HashMap<>();
		List<VAddress> orgList = addressDao.getAddress("organization", orgId);
		if(orgList!=null&&orgList.size()>0) {
			for(VAddress p1 : orgList) {
				map.put(p1.getId(), p1.getName());
			}
		}
		
		List<VAddress> positionList = addressDao.getAddress("position", orgId);
		if(positionList!=null&&positionList.size()>0) {
			for(VAddress p1 : positionList) {
				map.put(p1.getId(), p1.getName());
			}
		}
		List<VAddress> accountList = addressDao.getAddress("account", orgId);
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
}
