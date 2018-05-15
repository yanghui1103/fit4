package com.bw.fit.system.position.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.bw.fit.system.position.dao.PositionDao;
import com.bw.fit.system.position.model.Position;

@RequestMapping("position")
@Controller
public class PositionController {
	@Autowired
	private PositionDao positionDao ;
	
	/*****
	 * 查询岗位管理列表
	 * 
	 * @param params
	 * @param model
	 *            UI-Model
	 * @param p
	 *            岗位
	 * @param request
	 *            请求
	 * @param session
	 *            会话
	 * @return
	 */
	@RequestMapping("positions")
	@ResponseBody
	public JSONObject companyList(@ModelAttribute Position p, HttpServletRequest request) {
		JSONObject json = new JSONObject();
		p.setPaginationEnable("1");
		List<Position> list = positionDao.getPositions(p);
		p.setPaginationEnable("0");
		List<Position> listTotal = positionDao.getPositions(p);
		json.put("total",(listTotal != null && listTotal.size() > 0)?listTotal.size() : 0);
		json.put("rows", JSONObject.toJSON(list));
		return json;
	}
}
