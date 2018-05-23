package com.bw.fit.system.address.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bw.fit.system.organization.dao.OrganizationDao;
import com.bw.fit.system.position.dao.PositionDao;
import com.bw.fit.system.position.model.Position;
import com.bw.fit.system.position.service.PositionService;

@RequestMapping("address")
@Controller
public class AddressController {
	
	@Autowired
	private PositionDao positionDao ;
	@Autowired
	private PositionService positionService ;
	@Autowired
	private OrganizationDao organizationDao;
	
	/***
	 * 打开地址本
	 * @param orgIds
	 * @param orgNames
	 * @param model
	 * @return
	 */
	@RequestMapping("openAddressPage")
	public String openAddressPage(Model model){
		List<Position> positionList = positionDao.getPositionByOrgId("105001001");
		Map<String,String> map = new HashMap<>();
		for(Position p1 : positionList) {
			map.put(p1.getId(), p1.getName());
		}
		model.addAttribute("selectMap", map);
		return "system/address/addressPage" ;
	}
}
