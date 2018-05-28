package com.bw.fit.system.common.util;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.shiro.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.bw.fit.system.common.util.PubFun.*;

import com.bw.fit.system.account.dao.AccountDao;
import com.bw.fit.system.authority.entity.TRole2dataauth;
import com.bw.fit.system.common.model.BaseModel;
import com.bw.fit.system.dict.dao.DictDao;
import com.bw.fit.system.dict.model.Dict;
import com.bw.fit.system.organization.dao.OrganizationDao;
import com.bw.fit.system.organization.model.Organization;
import com.bw.fit.system.role.dao.RoleDao;
import com.bw.fit.system.role.entity.TRole;

@Component
public class CommonUtil {

	@Autowired
	private AccountDao accountDao;
	@Autowired
	private RoleDao roleDao;
	@Autowired
	private DictDao dictDao;
	@Autowired
	private OrganizationDao organizationDao;
	
	/*****
	 * 填充公共字段
	 * @param b
	 * @param isFillFdid
	 * @param session
	 */
	public void fillCommonProptities(BaseModel b, boolean isFillFdid,Session session) {
		if(isFillFdid){
			b.setId(getUUID());
		}
		b.setCreator(getCurrentAccount().getId());
		b.setCreateOrgId(getCurrentAccount().getCurrentOrgId());
		
		List<TRole> trs = accountDao.getRolesByAccount(getCurrentAccount().getLogName());
		List<TRole2dataauth>  dataauths = new ArrayList<>();
		if(trs !=null){
			for(TRole tr:trs){
				List<TRole2dataauth>  dataauthst = new ArrayList<>();
				dataauthst = roleDao.getDataAuthoritysByRole(tr.getId());
				dataauths.addAll(dataauthst);
			}
		}
		if(dataauths!=null){
			List<Dict> dcs = new ArrayList<>();
			for(TRole2dataauth t :dataauths){
				Dict dc = dictDao.getDictByValue(t.getAuthId());
				dcs.add(dc);
			}
			List<Dict> dcss = dcs.stream().distinct().collect(Collectors.toList());
			int level = 0;
			Dict dd = new Dict();
			for(Dict d:dcss){
				if(d.getSortNumber()>level){
					level = d.getSortNumber();
					dd = d;
				}
			}
			b.setDataAuth(dd.getDictValue());
			
			/****
			 * 得到该账户的最高数据权限,然后根据当前组织id及组织类型，如果最高权限与当前组织类型一致或小于组织类型，那么就返回当前组织及其子孙组织
			 * 如果最高权限高于当前组织类型，那么就往父组织追溯，直至追溯到和此最高权限一致的组织为止,并将这个组织及其子孙组织
			 */
			String currentOrgId = PubFun.getCurrentAccount().getCurrentOrgId();
			Organization org = organizationDao.get(currentOrgId);
			Dict currentDict = dictDao.getDictByValue(org.getType());
			if(dd.getSortNumber()<=currentDict.getSortNumber()){ 
				b.setCreateOrgIds(organizationDao.getChildrenAndCurt(currentOrgId).stream().map(Organization::getId).collect(Collectors.toList()));
			}else{
				List<Organization> pts =organizationDao.getParentsAndCurt(currentOrgId);
				for(Organization og :pts){
					if(dd.getSortNumber() == dictDao.getDictByValue(og.getType()).getSortNumber()){
						//找到了那个最高权限的组织
						b.setCreateOrgIds(organizationDao.getChildrenAndCurt(og.getId()).stream().map(Organization::getId).collect(Collectors.toList()));					
					}
				}
			}
		}
	}
}
