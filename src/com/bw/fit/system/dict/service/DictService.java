package com.bw.fit.system.dict.service;

import com.bw.fit.system.dict.model.DataDict;
import com.bw.fit.system.dict.model.Dict;

public interface DictService {

	/****
	 * 根据一个数据字典值，获取到他下
	 * 所有的子孙节点
	 * @param value
	 * @return
	 */
	public DataDict getDictsByParentValue(String value);
	/*****
	 * 获取这个节点（parnet_id）下所有数据字典信息
	 * @param parent_id
	 * @return
	 */
	public DataDict getAllDataDict(String parent_id) ;
}
