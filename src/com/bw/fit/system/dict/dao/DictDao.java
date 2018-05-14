package com.bw.fit.system.dict.dao;

import java.util.List;

import com.bw.fit.system.dict.entity.TdataDict;
import com.bw.fit.system.dict.model.DataDict;
import com.bw.fit.system.dict.model.Dict;

public interface DictDao {

	public Dict getDictByValue(String value);
	/****
	 * 根据只获取id
	 * @param value
	 * @return
	 */
	public String getIdByDictValue(String value);
	
	/****
	 * 根据父节点id查询所有子孙节点（数据字典）
	 * @param parentId
	 * @return
	 */
	public List<DataDict> getDictsByParentId(String parentId);

	/****
	 * 获取父节点下所有子孙节点
	 * @param c
	 * @return
	 */
	public List<TdataDict> getDataDictList(String parent_id);
}
