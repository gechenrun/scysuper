package com.jshx.areacodeRelation.entity;

import java.sql.Blob;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.jshx.core.base.entity.BaseModel;


/**
 * 实体类模板（目前仅适配MS-SQLServer数据库）
 * @author
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name="AREACODE_RELATION")
public class AreacodeRelation extends BaseModel
{
	/**
	 * 部门代码
	 */
	private String deptId;

	/**
	 * 删除标记
	 */
	private Integer delFlag;

	
	/**
	 * 原区域编码
	 */
	private String oldAreacode;

	/**
	 * 新区域编码
	 */
	private String newAreacode;

	/**
	 * 新区域名称
	 */
	private String newAreaname;


	@Column
	public String getDeptId()
	{
		return deptId;
	}

	public void setDeptId(String deptId)
	{
		this.deptId = deptId;
	}

	@Column
	public Integer getDelFlag()
	{
		return delFlag;
	}

	public void setDelFlag(Integer delFlag)
	{
		this.delFlag = delFlag;
	}

	
	@Column(name="OLD_AREACODE")
	public String getOldAreacode()
	{
		return this.oldAreacode;
	}

	public void setOldAreacode(String oldAreacode)
	{
		this.oldAreacode = oldAreacode;
	}

	@Column(name="NEW_AREACODE")
	public String getNewAreacode()
	{
		return this.newAreacode;
	}

	public void setNewAreacode(String newAreacode)
	{
		this.newAreacode = newAreacode;
	}

	@Column(name="NEW_AREANAME")
	public String getNewAreaname()
	{
		return this.newAreaname;
	}

	public void setNewAreaname(String newAreaname)
	{
		this.newAreaname = newAreaname;
	}

}
