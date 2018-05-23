package com.bw.fit.system.position.dao;

import java.util.List;

import com.bw.fit.system.common.model.RbackException;
import com.bw.fit.system.position.entity.TOrganization2Position;
import com.bw.fit.system.position.model.Position;

public interface PositionDao {
	/*****
	 * 根据岗位字段条件获取岗位
	 * @param position 岗位
	 * @return
	 */
	public List<Position> getPositions(Position position,String orgId);
	/****
	 * 新增岗位
	 * @param position
	 * @throws RbackException
	 */
	public void insert(Position position ) throws RbackException ;
	
	/****
	 * 新增岗位和组织得关系
	 * @param organization2Position
	 * @throws RbackException
	 */
	public void insertOrg2Position(TOrganization2Position organization2Position) throws RbackException ;
	/****
	 * 修改岗位
	 * @param position
	 * @throws RbackException
	 */
	public void update(Position position ) throws RbackException ;
	/****
	 * 删除岗位
	 * @param id
	 * @throws RbackException
	 */
	public void delete(String id) throws RbackException ;
	
	/****
	 * 删除岗位和组织关联信息
	 * @param id
	 * @throws RbackException
	 */
	public void deleteO2P(String id,String orgId) throws RbackException ;
	
	/****
	 * 根据岗位Id获取所属组织列表
	 * @param positionId
	 */
	public List<String> getOrgByPositionId(String positionId) ;
	
	/****
	 * 根据组织Id获岗位列表
	 * @param posiorgIdtionId
	 */
	public List<Position> getPositionByOrgId(String orgId) ;
}
