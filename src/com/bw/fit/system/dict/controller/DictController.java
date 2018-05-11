package com.bw.fit.system.dict.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.bw.fit.system.common.controller.BaseController;
import com.bw.fit.system.common.util.PubFun;
import com.bw.fit.system.dict.dao.DictDao;
import com.bw.fit.system.dict.model.Dict;
/****
 * 数据字典Controller
 * @author yangh
 *
 */
@RequestMapping("dict")
@Controller
public class DictController extends BaseController {

	@Autowired
	private   DictDao dictDao;	
	
	/*****
	 * 根据值获取数据字典名称
	 * @param value
	 * @return
	 */
	@RequestMapping("getDictNameByValue/{value}")
	@ResponseBody
	public JSONObject getDictNameByValue(@PathVariable String value){
		JSONObject json = new JSONObject();
		Dict dict = dictDao.getDictByValue(value);
		if(dict==null){
			json = new JSONObject();
			PubFun.returnFailJson(json, "不存在该数据字典");
			json.put("dictName", "");
			return json ;
		}
		json = new JSONObject();
		PubFun.returnSuccessJson(json);
		json.put("dictName", dict.getDictName());
		return json ;
	}
}
