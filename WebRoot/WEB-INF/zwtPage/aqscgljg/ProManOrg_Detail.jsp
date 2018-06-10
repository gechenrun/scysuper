<%@page language="java" pageEncoding="UTF-8" isELIgnored="false"%>
<%@include file="/common/header.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>查看</title>
	<%@include file="/common/jsLib.jsp"%><link href="${ctx}/webResources/zwt/css/sipac.css" rel="stylesheet">
</head>
<body>
	<form name="myform" method="post">
		<div class="page_dialog">
		<div class="inner6px">
			<div class="cell" style="width: ${tableWidth}">
			<table width="100%">
				<tr>
					<th width="15%">所在区域</th>
					<td width="35%" ><cus:hxlabel codeName="企业属地" itemValue="${proManOrg.areaId}" /></td>
					<th width="15%">企业名称</th>
					<td width="35%" >${proManOrg.companyName}</td>
				</tr>
				<tr>
					<th width="15%">机构名称</th>
					<td width="35%" >${proManOrg.orgenizationName}</td>
					<th width="15%">成员数量</th>
					<td width="35%" >${proManOrg.orgenizationMenberCount}</td>
				</tr>
				<tr>
					<th width="15%">负责人</th>
					<td width="35%" >${proManOrg.orgenizationCharge}</td>
					<th width="15%">负责人邮箱</th>
					<td width="35%" >${proManOrg.orgenizationChargeEmail}</td>
				</tr>
				<tr>
					<th width="15%">负责人联系方式1</th>
					<td width="35%" >${proManOrg.orgenizationChargePhone}</td>
					<th width="15%">负责人联系方式2</th>
					<td width="35%" >${proManOrg.orgenizationChargePhone2}</td>
				</tr>
				<tr>
					<th width="15%">机构职责</th>
					<td width="85%" colspan="3"><textarea readOnly name="proManOrg.orgenizationResponsibility" style="width:96%;height:60px">${proManOrg.orgenizationResponsibility}</textarea></td>
				</tr>
				<tr>
					<th width="15%">备注</th>
					<td width="96%" colspan="3"><textarea readOnly name="proManOrg.orgenizationRemark" style="width:96%;height:60px">${proManOrg.orgenizationRemark}</textarea></td>
				</tr>
				 
			</table>
		</div></div></div>
	</form>
</body>
</html>
