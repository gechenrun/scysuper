package com.jshx.aqscsgccglb.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jshx.core.base.service.impl.BaseServiceImpl;
import com.jshx.core.base.vo.Pagination;
import com.jshx.aqscsgccglb.dao.AqscsgccglbDao;
import com.jshx.aqscsgccglb.entity.Aqscsgccglb;
import com.jshx.aqscsgccglb.service.AqscsgccglbService;
import com.jshx.aqsczfwsglb.entity.Aqsczfwsglb;

@Service("aqscsgccglbService")
public class AqscsgccglbServiceImpl extends BaseServiceImpl implements AqscsgccglbService
{
	/**
	 * Dao类
	 */
	@Resource
	private AqscsgccglbDao aqscsgccglbDao;

	/**
	 * 分页查询
	 * @param page 分页信息
	 * @param paraMap 查询条件信息
	 * @return 分页信息
	 */
	public Pagination findByPage(Pagination page, Map<String, Object> paraMap)
	{
		return aqscsgccglbDao.findByPage(page, paraMap);
	}

	/**
	 * 根据主键ID查询信息
	 * @param id 主键ID
	 * @return 主键ID对应的信息
	 */
	public Aqscsgccglb getById(String id)
	{
		return aqscsgccglbDao.getById(id);
	}

	/**
	 * 保存信息
	 * @param model 信息
	 */
	@Transactional
	public void save(Aqscsgccglb aqscsgccglb)
	{
		aqscsgccglbDao.save(aqscsgccglb);
	}

	/**
	 * 修改信息
	 * @param model 信息
	 */
	@Transactional
	public void update(Aqscsgccglb aqscsgccglb)
	{
		aqscsgccglbDao.update(aqscsgccglb);
	}

	/**
	 * 物理删除信息
	 * @param ids 主键ID列表
	 */
	@Transactional
	public void delete(String[] ids)
	{
		List list=Arrays.asList(ids);
		
		Map<String, Object> paraMap = new HashMap<String, Object>();
		paraMap.put("ids", list);
		List objects=aqscsgccglbDao.findAqscsgccglb(paraMap);
		
		aqscsgccglbDao.removeAll(objects);
	}

	/**
	 * 逻辑删除信息
	 * @param ids 主键ID列表
	 */
	@Transactional
	public void deleteWithFlag(String ids)
	{
	    String[] idArray = ids.split("\\|");
		if(null != idArray)
		{
			for(String id : idArray)
			{
			    if(id!=null && !id.trim().equals(""))
				    aqscsgccglbDao.deleteWithFlag(id);
			}
		}
	}

	@Override
	public List<Aqscsgccglb> findAqscsgccglb(Map<String, Object> paraMap) {
		// TODO Auto-generated method stub
		return aqscsgccglbDao.findAqscsgccglb(paraMap);
	}

	@Override
	public Aqscsgccglb getAqscsgccglbByMap(Map map) {
		// TODO Auto-generated method stub
		return aqscsgccglbDao.getAqscsgccglbByMap(map);
	}
}
