package com.bw.fit.system.address.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bw.fit.system.address.dao.AddressDao;
import com.bw.fit.system.address.entity.VAddress;
import com.bw.fit.system.address.service.AddressService;
import com.bw.fit.system.position.service.PositionService;
@Service
public class AddressServcieImpl implements AddressService{
	@Autowired
	private PositionService positionService;
	@Autowired
	private AddressDao addressDao ;
	
	@Override
	public Map<String, String> getSelectedAddr(String ids) {
		Map<String,String> map2 = new HashMap<>();
		String ids2[] = ids.split(",");
		if(ids2.length>0) {
			for(String id : ids2) {
				List<VAddress> addrList = addressDao.get(id);
				for(VAddress addr : addrList) {
					map2.put(addr.getId()+"-"+addr.getUnderOrgId(), addr.getName());
				}
			}
		}
		return map2;
	}

	@Override
	public Map<String, String> getSelectAddr(boolean o,boolean p,boolean a,String keyWords,boolean type) {
		Map<String,String> map = new HashMap<>();
		List<VAddress> orgList = new ArrayList<>();
		List<VAddress> positionList = new ArrayList<>();
		List<VAddress> accountList = new ArrayList<>();
		
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
				map.put(p1.getId()+"-"+p1.getUnderOrgId(), p1.getName());
			}
		}
		if(positionList!=null&&positionList.size()>0) {
			for(VAddress p1 : positionList) {
				map.put(p1.getId()+"-"+p1.getUnderOrgId(), p1.getName());
			}
		}
		if(accountList!=null&&accountList.size()>0) {
			for(VAddress p1 : accountList) {
				map.put(p1.getId()+"-"+p1.getUnderOrgId(), p1.getName());
			}
		}
		return map;
	}

	@Override
	public String getDetali(String id, String underOrgId) {
		List<VAddress> addrList = addressDao.get(id);
		String detali =null;
		Optional<VAddress> address= addrList.stream()
				.filter(addr -> underOrgId.equals(addr.getUnderOrgId())) .findFirst();
		if (address.isPresent()) {
			VAddress addr = address.get();
			if("organization".equals(addr.getAddressType())) {//组织
				
			}
			if("position".equals(addr.getAddressType())){//岗位
				detali = positionService.get(id).getName()+"(岗位)";
				detali += "--XXX组织";
			}
			if("account".equals(addr.getAddressType())){//账户
				
			}
		}
		return detali;
	}

}