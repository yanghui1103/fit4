package com.bw.fit.system.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.*;
import java.util.stream.Collectors;

import static com.bw.fit.common.util.PubFun.*;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.shiro.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bw.fit.common.dao.DaoTemplete;
import com.bw.fit.common.entity.BaseEntity;
import com.bw.fit.common.model.RbackException;
import com.bw.fit.common.util.Node;
import com.bw.fit.common.util.PropertiesUtil;
import com.bw.fit.common.util.PubFun;
import com.bw.fit.common.util.treeHandler.JsonTreeHandler;
import com.bw.fit.system.dao.SystemDao;
import com.bw.fit.system.dao.UserDao;
import com.bw.fit.system.entity.TAttachment;
import com.bw.fit.system.entity.Tcompany;
import com.bw.fit.system.entity.TdataDict;
import com.bw.fit.system.entity.Toperation;
import com.bw.fit.system.entity.TpageElement;
import com.bw.fit.system.entity.Tpostion;
import com.bw.fit.system.entity.Trole;
import com.bw.fit.system.entity.Tuser;
import com.bw.fit.system.model.Attachment;
import com.bw.fit.system.model.DataDict;
import com.bw.fit.system.model.ElementLevel;
import com.bw.fit.system.model.LogUser;
import com.bw.fit.system.model.Menu;
import com.bw.fit.system.model.Postion;
import com.bw.fit.system.model.Role;
import com.bw.fit.system.model.RoleAllot;
import com.bw.fit.system.model.User;
import com.bw.fit.system.service.SystemService;

@Service
public class SystemServiceImpl implements SystemService {
	@Autowired
	private SystemDao systemDao;
	@Autowired
	private DaoTemplete daoTemplete;
	@Autowired
	private UserDao userDao;

	@Override
	public JSONObject getOnLineSituation(Session session, LogUser user,
			ServletContext servletContext) {
		List<LogUser> showList = (ArrayList) (servletContext
				.getAttribute("onLineUserList"));
		JSONObject json = new JSONObject();
		if (showList == null || showList.size() < 1) {
			json.put("res", "2");
			json.put("msg", "此帐号此IP可以登录使用");
			return json;
		}
		int LogUserMaxCnt = Integer.valueOf(PropertiesUtil
				.getValueByKey("user.login.maxcnt"));
		if (showList != null && (showList.size() >= LogUserMaxCnt)) {
			json.put("res", "1");
			json.put("msg", "在线人数已经超出上限数目:" + LogUserMaxCnt);
			return json;
		}
		List<LogUser> afterList = showList
				.parallelStream()
				.filter((n) -> n.getUser_cd().equalsIgnoreCase(
						user.getUser_cd())
						&& n.getIp().equalsIgnoreCase(user.getIp()))
				.collect(Collectors.toList());
		if (afterList != null || afterList.size() > 0) {
			json.put("res", "1");
			json.put("msg", "此帐号已经在别的地方登录");
			return json;
		}
		json.put("res", "2");
		json.put("msg", "此帐号此IP可以登录使用");
		return json;
	}

	@Override
	public User getCurrentUserInfo(String user_cd) {
		User user = new User();
		String user_id = userDao.getUserIdByCd(user_cd);
		Tuser t = userDao.getUserById(user_id);
		copyProperties(user, t);
		List<Role> roles = new ArrayList<>();
		List<Trole> rls = userDao.getUserRoleInfo(user_id);
		for (Trole r : rls) {
			Role r1 = new Role();
			copyProperties(r1, r);
			roles.add(r1);
		}
		if (roles != null) {
			user.setRole_list(roles);
		}
		List<Postion> postions1 = new ArrayList<>();
		List<Tpostion> Postions = userDao.getUserPostionInfo(user_id);
		for (Tpostion p : Postions) {
			Postion r1 = new Postion();
			copyProperties(r1, p);
			postions1.add(r1);
		}
		if (postions1 != null) {
			user.setPostion_list(postions1);
		}
		return user;
	}

	@Override
	public JSONArray getMenuTreeJsonByUserId(String user_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JSONArray getMenuAuthTreeJsonByRoleId(String role_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JSONObject getOperationsByMenuId(String user_id, String menuId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataDict getAllDataDict(String parent_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DataDict> getChildrenDictList(String parent_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ElementLevel> getElementLevelList(ElementLevel e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Postion> getPostionList(Postion e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void allotOrUpdateRole(RoleAllot roleAllot) throws RbackException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void createUser(User user) throws RbackException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public JSONObject createPostion(Postion p) throws RbackException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JSONObject createNewAttachment(Attachment a) throws RbackException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JSONObject deleteAttachment(Attachment a) throws RbackException {
		// TODO Auto-generated method stub
		return null;
	}
 

}
