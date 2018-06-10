package com.jshx.prebuslicense.entity;

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
@Table(name="PRE_BUS_LIC")
public class PreBusLic extends BaseModel
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
	 * 所在区域id
	 */
	private String areaId;

	/**
	 * 所在区域名称
	 */
	private String areaName;

	/**
	 * 企业id
	 */
	private String companyId;

	/**
	 * 企业名称
	 */
	private String companyName;

	/**
	 * 许可证编号
	 */
	private String licenseNumber;

	/**
	 * 许可内容
	 */
	private String licenseContent;

	/**
	 * 产品流向
	 */
	private String productFlow;

	/**
	 * 许可证有效期
	 */
	private Date licenseValid;

	/**
	 * 发证机关
	 */
	private String issuingAuthority;

	/**
	 * 发证日期
	 */
	private Date issuingDate;

	/**
	 * 材料接收日期
	 */
	private Date receptDate;
	
	/**
	 * 材料上报市局日期
	 */
	private Date reportCityDate;

	/**
	 * 材料接收人员
	 */
	private String receptName;

	/**
	 * 材料审查人员
	 */
	private String reviewName;

	/**
	 * 材料审查情况
	 */
	private String materialReview;

	/**
	 * 档案编号
	 */
	private String fileNo;

	/**
	 * 申请材料是否齐全
	 */
	private String isComplete;

	/**
	 * 签字领导
	 */
	private String signLeader;

	/**
	 * 本次备案情况
	 */
	private String filingCase;

	/**
	 * 行政许可建议
	 */
	private String busposal;

	/**
	 * 附件关联id
	 */
	private String linkId;

	
	public PreBusLic(){
	}
	public PreBusLic(String id, String areaId, String companyName, String licenseNumber, String productFlow, Date licenseValid, String issuingAuthority, Date issuingDate, Date receptDate, String receptName, String reviewName, String fileNo,String createUserID){
this.id = id;

this.areaId = areaId;

this.companyName = companyName;

this.licenseNumber = licenseNumber;

this.productFlow = productFlow;

this.licenseValid = licenseValid;

this.issuingAuthority = issuingAuthority;

this.issuingDate = issuingDate;

this.receptDate = receptDate;

this.receptName = receptName;

this.reviewName = reviewName;

this.fileNo = fileNo;
this.createUserID=createUserID;
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

	
	@Column(name="AREA_ID")
	public String getAreaId()
	{
		return this.areaId;
	}

	public void setAreaId(String areaId)
	{
		this.areaId = areaId;
	}

	@Column(name="AREA_NAME")
	public String getAreaName()
	{
		return this.areaName;
	}

	public void setAreaName(String areaName)
	{
		this.areaName = areaName;
	}

	@Column(name="COMPANY_ID")
	public String getCompanyId()
	{
		return this.companyId;
	}

	public void setCompanyId(String companyId)
	{
		this.companyId = companyId;
	}

	@Column(name="COMPANY_NAME")
	public String getCompanyName()
	{
		return this.companyName;
	}

	public void setCompanyName(String companyName)
	{
		this.companyName = companyName;
	}

	@Column(name="LICENSE_NUMBER")
	public String getLicenseNumber()
	{
		return this.licenseNumber;
	}

	public void setLicenseNumber(String licenseNumber)
	{
		this.licenseNumber = licenseNumber;
	}

	@Column(name="LICENSE_CONTENT")
	public String getLicenseContent()
	{
		return this.licenseContent;
	}

	public void setLicenseContent(String licenseContent)
	{
		this.licenseContent = licenseContent;
	}

	@Column(name="BUSDUCT_FLOW")
	public String getProductFlow()
	{
		return this.productFlow;
	}

	public void setProductFlow(String productFlow)
	{
		this.productFlow = productFlow;
	}

	@Column(name="LICENSE_VALID")
	public Date getLicenseValid()
	{
		return this.licenseValid;
	}

	public void setLicenseValid(Date licenseValid)
	{
		this.licenseValid = licenseValid;
	}

	@Column(name="ISSUING_AUTHORITY")
	public String getIssuingAuthority()
	{
		return this.issuingAuthority;
	}

	public void setIssuingAuthority(String issuingAuthority)
	{
		this.issuingAuthority = issuingAuthority;
	}

	@Column(name="ISSUING_DATE")
	public Date getIssuingDate()
	{
		return this.issuingDate;
	}

	public void setIssuingDate(Date issuingDate)
	{
		this.issuingDate = issuingDate;
	}

	@Column(name="RECEPT_DATE")
	public Date getReceptDate()
	{
		return this.receptDate;
	}

	public void setReceptDate(Date receptDate)
	{
		this.receptDate = receptDate;
	}

	@Column(name="RECEPT_NAME")
	public String getReceptName()
	{
		return this.receptName;
	}

	public void setReceptName(String receptName)
	{
		this.receptName = receptName;
	}

	@Column(name="REVIEW_NAME")
	public String getReviewName()
	{
		return this.reviewName;
	}

	public void setReviewName(String reviewName)
	{
		this.reviewName = reviewName;
	}

	@Column(name="MATERIAL_REVIEW")
	public String getMaterialReview()
	{
		return this.materialReview;
	}

	public void setMaterialReview(String materialReview)
	{
		this.materialReview = materialReview;
	}

	@Column(name="FILE_NO")
	public String getFileNo()
	{
		return this.fileNo;
	}

	public void setFileNo(String fileNo)
	{
		this.fileNo = fileNo;
	}

	@Column(name="IS_COMPLETE")
	public String getIsComplete()
	{
		return this.isComplete;
	}

	public void setIsComplete(String isComplete)
	{
		this.isComplete = isComplete;
	}

	@Column(name="SIGN_LEADER")
	public String getSignLeader()
	{
		return this.signLeader;
	}

	public void setSignLeader(String signLeader)
	{
		this.signLeader = signLeader;
	}

	@Column(name="FILING_CASE")
	public String getFilingCase()
	{
		return this.filingCase;
	}

	public void setFilingCase(String filingCase)
	{
		this.filingCase = filingCase;
	}

	@Column(name="BUSPOSAL")
	public String getBusposal()
	{
		return this.busposal;
	}

	public void setBusposal(String busposal)
	{
		this.busposal = busposal;
	}

	@Column(name="LINK_ID")
	public String getLinkId()
	{
		return this.linkId;
	}

	public void setLinkId(String linkId)
	{
		this.linkId = linkId;
	}
	@Column(name="REPORT_CITY_DATE")
	public Date getReportCityDate() {
		return reportCityDate;
	}

	public void setReportCityDate(Date reportCityDate) {
		this.reportCityDate = reportCityDate;
	}
	
	

}