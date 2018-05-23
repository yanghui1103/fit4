package com.bw.fit.system.address.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bw.fit.system.organization.dao.OrganizationDao;
import com.bw.fit.system.position.dao.PositionDao;
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
		return "system/address/addressPage" ;
	}
}
