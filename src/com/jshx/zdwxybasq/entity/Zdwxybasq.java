package com.jshx.zdwxybasq.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.jshx.core.base.entity.BaseModel;


/**
 * 实体类模板（目前仅适配MS-SQLServer数据库）
 * @author
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name="ZDWXYBASQ")
public class Zdwxybasq extends BaseModel
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
	 * 所在镇id
	 */
	private String szzid;
	/**
	 * 所在镇
	 */
	private String szzname;
	/**
	 * 企业id
	 */
	private String qyid;
	/**
	 * 法人单位名称
	 */
	private String frdwmc;
	/**
	 * 填报单位名称
	 */
	private String qymc;
	/**
	 * 企业类型
	 */
	private String qylx;
	/**
	 * 行业分类
	 */
	private String hyfl;
	/**
	 * 企业规模
	 */
	private String qygm;
	/**
	 * 企业注册类型
	 */
	private String qyzclx;
	/**
	 * 填报单位地址
	 */
	private String tbdwdz;
	/**
	 * 邮政编码
	 */
	private String yzbm;
	/**
	 * 重大危险源名称
	 */
	private String zdwxymc;
	/**
	 * 重大危险源所在地址
	 */
	private String zdwxyszdz;
	/**
	 * 填报单位负责人姓名
	 */
	private String fzrxm;
	/**
	 * 电话
	 */
	private String fzrdh;
	/**
	 * 填报人姓名
	 */
	private String tbrxm;
	/**
	 * 电话
	 */
	private String tbrdh;
	/**
	 * 电子邮箱
	 */
	private String dzyx;
	/**
	 * 传真
	 */
	private String cz;
	/**
	 * 单位从业人员数量
	 */
	private String dwcyrysl;
	/**
	 * 占地面积
	 */
	private String zdmj;
	/**
	 * 备案申请类型
	 */
	private String basqlx;
	/**
	 * 危险化学品单位类型
	 */
	private String dwlx;
	/**
	 * 所在行业
	 */
	private String szhy;
	/**
	 * 重大危险源级别
	 */
	private String zdwxyjb;
	/**
	 * 附件关联id
	 */
	private String linkid;
	/**
	 * 备案材料清单
	 */
	private String baclqd;
	/**
	 * 是否危化品企业类型
	 */
	private String ifwhpqylx;
	/**
	 * 是否职业危害企业类型
	 */
	private String ifzywhqylx;
	/**
	 * 是否烟花爆竹经营企业
	 */
	private String ifyhbzjyqy;
	
	private String szc;
	
	private String szcname;
	
	//heyc 20141210 修改 start
	/**
	 * 是否非煤矿山企业
	 */
	private String iffmksjyqy;

	@Column(name="IFFMKSJYQY")
	public String getIffmksjyqy() {
		return iffmksjyqy;
	}

	public void setIffmksjyqy(String iffmksjyqy) {
		this.iffmksjyqy = iffmksjyqy;
	}
	//heyc 20141210 修改 end

	
	@Column
	public String getSzc() {
		return szc;
	}

	public void setSzc(String szc) {
		this.szc = szc;
	}
	@Column
	public String getSzcname() {
		return szcname;
	}

	public void setSzcname(String szcname) {
		this.szcname = szcname;
	}
	
	@Column(name="IFWHPQYLX")
	public String getIfwhpqylx() {
		return ifwhpqylx;
	}

	public void setIfwhpqylx(String ifwhpqylx) {
		this.ifwhpqylx = ifwhpqylx;
	}
	@Column(name="IFZYWHQYLX")
	public String getIfzywhqylx() {
		return ifzywhqylx;
	}

	public void setIfzywhqylx(String ifzywhqylx) {
		this.ifzywhqylx = ifzywhqylx;
	}
	@Column(name="IFYHBZJYQY")
	public String getIfyhbzjyqy() {
		return ifyhbzjyqy;
	}

	public void setIfyhbzjyqy(String ifyhbzjyqy) {
		this.ifyhbzjyqy = ifyhbzjyqy;
	}

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

	
	@Column(name="SZZID")
	public String getSzzid()
	{
		return this.szzid;
	}

	public void setSzzid(String szzid)
	{
		this.szzid = szzid;
	}

	@Column(name="SZZNAME")
	public String getSzzname()
	{
		return this.szzname;
	}

	public void setSzzname(String szzname)
	{
		this.szzname = szzname;
	}

	@Column(name="QYID")
	public String getQyid()
	{
		return this.qyid;
	}

	public void setQyid(String qyid)
	{
		this.qyid = qyid;
	}

	@Column(name="FRDWMC")
	public String getFrdwmc()
	{
		return this.frdwmc;
	}

	public void setFrdwmc(String frdwmc)
	{
		this.frdwmc = frdwmc;
	}

	@Column(name="QYMC")
	public String getQymc()
	{
		return this.qymc;
	}

	public void setQymc(String qymc)
	{
		this.qymc = qymc;
	}

	@Column(name="QYLX")
	public String getQylx()
	{
		return this.qylx;
	}

	public void setQylx(String qylx)
	{
		this.qylx = qylx;
	}

	@Column(name="HYFL")
	public String getHyfl()
	{
		return this.hyfl;
	}

	public void setHyfl(String hyfl)
	{
		this.hyfl = hyfl;
	}

	@Column(name="QYGM")
	public String getQygm()
	{
		return this.qygm;
	}

	public void setQygm(String qygm)
	{
		this.qygm = qygm;
	}

	@Column(name="QYZCLX")
	public String getQyzclx()
	{
		return this.qyzclx;
	}

	public void setQyzclx(String qyzclx)
	{
		this.qyzclx = qyzclx;
	}

	@Column(name="TBDWDZ")
	public String getTbdwdz()
	{
		return this.tbdwdz;
	}

	public void setTbdwdz(String tbdwdz)
	{
		this.tbdwdz = tbdwdz;
	}

	@Column(name="YZBM")
	public String getYzbm()
	{
		return this.yzbm;
	}

	public void setYzbm(String yzbm)
	{
		this.yzbm = yzbm;
	}

	@Column(name="ZDWXYMC")
	public String getZdwxymc()
	{
		return this.zdwxymc;
	}

	public void setZdwxymc(String zdwxymc)
	{
		this.zdwxymc = zdwxymc;
	}

	@Column(name="ZDWXYSZDZ")
	public String getZdwxyszdz()
	{
		return this.zdwxyszdz;
	}

	public void setZdwxyszdz(String zdwxyszdz)
	{
		this.zdwxyszdz = zdwxyszdz;
	}

	@Column(name="FZRXM")
	public String getFzrxm()
	{
		return this.fzrxm;
	}

	public void setFzrxm(String fzrxm)
	{
		this.fzrxm = fzrxm;
	}

	@Column(name="FZRDH")
	public String getFzrdh()
	{
		return this.fzrdh;
	}

	public void setFzrdh(String fzrdh)
	{
		this.fzrdh = fzrdh;
	}

	@Column(name="TBRXM")
	public String getTbrxm()
	{
		return this.tbrxm;
	}

	public void setTbrxm(String tbrxm)
	{
		this.tbrxm = tbrxm;
	}

	@Column(name="TBRDH")
	public String getTbrdh()
	{
		return this.tbrdh;
	}

	public void setTbrdh(String tbrdh)
	{
		this.tbrdh = tbrdh;
	}

	@Column(name="DZYX")
	public String getDzyx()
	{
		return this.dzyx;
	}

	public void setDzyx(String dzyx)
	{
		this.dzyx = dzyx;
	}

	@Column(name="CZ")
	public String getCz()
	{
		return this.cz;
	}

	public void setCz(String cz)
	{
		this.cz = cz;
	}

	@Column(name="DWCYRYSL")
	public String getDwcyrysl()
	{
		return this.dwcyrysl;
	}

	public void setDwcyrysl(String dwcyrysl)
	{
		this.dwcyrysl = dwcyrysl;
	}

	@Column(name="ZDMJ")
	public String getZdmj()
	{
		return this.zdmj;
	}

	public void setZdmj(String zdmj)
	{
		this.zdmj = zdmj;
	}

	@Column(name="BASQLX")
	public String getBasqlx()
	{
		return this.basqlx;
	}

	public void setBasqlx(String basqlx)
	{
		this.basqlx = basqlx;
	}

	@Column(name="DWLX")
	public String getDwlx()
	{
		return this.dwlx;
	}

	public void setDwlx(String dwlx)
	{
		this.dwlx = dwlx;
	}

	@Column(name="SZHY")
	public String getSzhy()
	{
		return this.szhy;
	}

	public void setSzhy(String szhy)
	{
		this.szhy = szhy;
	}

	@Column(name="ZDWXYJB")
	public String getZdwxyjb()
	{
		return this.zdwxyjb;
	}

	public void setZdwxyjb(String zdwxyjb)
	{
		this.zdwxyjb = zdwxyjb;
	}

	@Column(name="BACLQD")
	public String getBaclqd()
	{
		return this.baclqd;
	}

	public void setBaclqd(String baclqd)
	{
		this.baclqd = baclqd;
	}

	public String getLinkid() {
		return linkid;
	}

	public void setLinkid(String linkid) {
		this.linkid = linkid;
	}

	/**
	 * 是否直属企业
	 */
	private String ifzsqy;
	/**
	 * 企业所属监管类型
	 */
	private String companyType;
	
	public String getCompanyType() {
		return companyType;
	}

	public void setCompanyType(String companyType) {
		this.companyType = companyType;
	}

	@Column(name="ifzsqy")
	public String getIfzsqy() {
		return ifzsqy;
	}

	public void setIfzsqy(String ifzsqy) {
		this.ifzsqy = ifzsqy;
	}
}