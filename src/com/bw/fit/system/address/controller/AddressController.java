package com.bw.fit.system.address.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bw.fit.system.address.dao.AddressDao;
import com.bw.fit.system.address.entity.VAddress;
import com.bw.fit.system.common.model.BaseModel;
import com.bw.fit.system.organization.dao.OrganizationDao;
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
	@RequestMapping("openAddressPage/{orgId}/{o}/{p}/{a}")
	public String openAddressPage(Model model,@PathVariable String orgId,@PathVariable String o,@PathVariable String p,@PathVariable String a){
		
		Map<String,String> map = new HashMap<>();
		if(!"-1".equals(o)) {
			List<VAddress> orgList = addressDao.getAddress("organization", orgId);
			for(VAddress p1 : orgList) {
				map.put(p1.getId(), p1.getName());
			}
		}
		if(!"-1".equals(p)) {
			List<VAddress> positionList = addressDao.getAddress("position", orgId);
			for(VAddress p1 : positionList) {
				map.put(p1.getId(), p1.getName());
			}
		}
		if(!"-1".equals(a)) {
			List<VAddress> accountList = addressDao.getAddress("account", orgId);
			for(VAddress p1 : accountList) {
				map.put(p1.getId(), p1.getName());
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
}
