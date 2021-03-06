package com.jshx.aqscxzcfglb.dao.impl;

import java.util.List;
import java.sql.Blob;
import java.util.Map;

import org.hibernate.Hibernate;
import org.hibernate.LockMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Component;

import com.jshx.core.base.dao.impl.BaseDaoImpl;
import com.jshx.core.base.vo.Pagination;
import com.jshx.ibatis.IctSqlMapClientDaoSupport;
import com.jshx.aqscxzcfglb.entity.Aqscxzcfglb;
import com.jshx.aqscxzcfglb.dao.AqscxzcfglbDao;

@Component("aqscxzcfglbDao")
public class AqscxzcfglbDaoImpl extends BaseDaoImpl implements AqscxzcfglbDao
{
	@Autowired
	@Qualifier("sqlMapClientTemplate") 
	private SqlMapClientTemplate sqlMapClientTemplate;
	/**
	 * 分页查询
	 * @param page 分页信息
	 * @param paraMap 查询条件信息
	 * @return 分页信息
	 */
	public Pagination findByPage(Pagination page, Map<String, Object> paraMap)
	{
		return this.findPageByHqlId("findAqscxzcfglbByMap", paraMap, page);
	}
	
	/**
	 * 查询所有记录
	 * @param page 分页信息
	 * @param paraMap 查询条件信息
	 * @return 分页信息
	 */
	public List<Aqscxzcfglb> findAqscxzcfglb(Map<String, Object> paraMap){
		return this.findListByHqlId("findAqscxzcfglbByMap", paraMap);
	}

	/**
	 * 根据主键ID查询信息
	 * @param id 主键ID
	 * @return 主键ID对应的信息
	 */
	public Aqscxzcfglb getById(String id)
	{
		return (Aqscxzcfglb)this.getObjectById(Aqscxzcfglb.class, id);
	}

	/**
	 * 保存信息
	 * @param model 信息
	 */
	public void save(Aqscxzcfglb aqscxzcfglb)
	{
		aqscxzcfglb.setId(null);
		//此处处理Blob对象（Blob对象不能直接insert）
		this.saveOrUpdateObject(aqscxzcfglb);
	}

	/**
	 * 修改信息
	 * @param model 信息
	 */
	public void update(Aqscxzcfglb aqscxzcfglb)
	{
		this.saveOrUpdateObject(aqscxzcfglb);
	}

	/**
	 * 物理删除信息
	 * @param ids 主键ID
	 */
	public void delete(String id)
	{
		this.removeObjectById(Aqscxzcfglb.class, id);
	}

	/**
	 * 逻辑删除信息
	 * @param ids 主键ID
	 */
	public void deleteWithFlag(String id)
	{
		Aqscxzcfglb aqscxzcfglb = (Aqscxzcfglb)this.getObjectById(Aqscxzcfglb.class, id);
		aqscxzcfglb.setDelFlag(1);
		this.saveObject(aqscxzcfglb);
	}

	@Override
	public Aqscxzcfglb getAqscxzcfglbByMap(Map map) {
		// TODO Auto-generated method stub
		return (Aqscxzcfglb) sqlMapClientTemplate.queryForObject("getAqscxzcfglbByMap",map);
	}
}
