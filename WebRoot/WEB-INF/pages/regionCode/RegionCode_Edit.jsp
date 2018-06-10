<%@page language="java" pageEncoding="UTF-8"%>
<%@include file="/common/header.jsp"%>
<%@taglib prefix="cus" uri="/WEB-INF/tld/customized-tags.tld"%>
<%@taglib uri="http://java.fckeditor.net" prefix="FCK"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<title><s:if test="flag=='add'">新增</s:if><s:else>修改</s:else>记录</title>
	<%@include file="/common/jsLib.jsp"%>
	<script>
		function save(){
			if(Validator.Validate(document.myform1,3)){
				
				document.myform1.action="regionCodeSave.action";
				document.myform1.submit();
			}
		}
	</script>
	
</head>
<body>
<%@include file="/WEB-INF/template/content_title.jsp"%>
	<form name="myform1" method="post" enctype="multipart/form-data">
		<s:token />
		<input type="hidden" name="flag" value="${flag}">
		<input type="hidden" name="regionCode.id" value="${regionCode.id}">
		<input type="hidden" name="regionCode.createTime" value="<fmt:formatDate type="both" value="${regionCode.createTime}" />">
		<input type="hidden" name="regionCode.updateTime" value="${regionCode.updateTime}">
		<input type="hidden" name="regionCode.createUserID" value="${regionCode.createUserID}">
		<input type="hidden" name="regionCode.updateUserID" value="${regionCode.updateUserID}">
		<input type="hidden" name="regionCode.deptId" value="${regionCode.deptId}">
		<input type="hidden" name="regionCode.delFlag" value="${regionCode.delFlag}">
		
		<div class="submitdata">
			<table width="100%" border="0">
				<tr>
					<th width="15%">单位名称</th>
					<td width="35%" colspan="3"><input name="regionCode.regionName" value="${regionCode.regionName}" type="text" maxlength="255" style="width: 70%;"></td>
				</tr>
				<tr>
					<th width="15%">部门code</th>
					<td width="35%"><input name="regionCode.deptCode" value="${regionCode.deptCode}" type="text" maxlength="255"></td>
					<th width="15%">代码</th>
					<td width="35%"><input name="regionCode.regionCode" value="${regionCode.regionCode}" type="text" maxlength="255"></td>
				</tr>
				<tr>
					<td colspan="4" height="100px" align="center">
						<s:if test="flag=='add'">
							<a href="#" class="easyui-linkbutton" onclick="save()" iconCls="icon-save">添加</a>&nbsp;
						</s:if>
						<s:else>
							<a href="#" class="easyui-linkbutton" onclick="save()" iconCls="icon-save">更新</a>&nbsp;
						</s:else>						
						<a href="#" class="easyui-linkbutton" iconCls="icon-undo" onclick="document.myform1.reset()">重置</a>&nbsp;
						<a href="#" class="easyui-linkbutton" iconCls="icon-cancel" onclick="closeLayer();">关闭</a>
					</td>
				</tr>
			</table>
		<div class="submitdata">
	</form>
<%@include file="/WEB-INF/template/pagefoot.jsp"%>
</body>
</html>