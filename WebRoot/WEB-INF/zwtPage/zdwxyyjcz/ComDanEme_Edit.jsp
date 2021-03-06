<%@page language="java" pageEncoding="UTF-8" isELIgnored="false"%>
<%@include file="/common/header.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title><s:if test="flag=='add'">新增</s:if><s:else>修改</s:else>记录</title>
	<%@include file="/common/jsLib.jsp"%><link href="${ctx}/webResources/zwt/css/sipac.css" rel="stylesheet">
		<script>
	$(document).ready(function() {
		  uploadPic("uploadify","${comDanEme.linkId}","zdwxyyjcz","zdwxyyjczfj","fileQueue");
		});
		
	function queryQy()
		{
			popupCenter("${ctx}/jsp/yjya/emePlaListss.action", "setCompany", "800", "600", "no", "no", "no", "no", "no","no");
		}
		
</script>
</head>

<body validform="true" style="overflow: auto;">
   <div class="box_01 boxBmargin12 submitdata" style="overflow-y: auto;overflow-x: hidden;padding: 0;top: 0px;left: 0px;right: 0px;bottom: 0;position: absolute; ">
		<div class="inner6px">
			<div class="cell" style="width: 100%">
	<form name="myform1" method="post" enctype="multipart/form-data" action="comDanEmeSave.action">
		<s:token />
		<input type="hidden" name="flag" value="${flag}">
		<input type="hidden" name="comDanEme.id" value="${comDanEme.id}">
		<input type="hidden" name="comDanEme.createTime" value="<fmt:formatDate type="both" value="${comDanEme.createTime}" />">
		<input type="hidden" name="comDanEme.updateTime" value="${comDanEme.updateTime}">
		<input type="hidden" name="comDanEme.createUserID" value="${comDanEme.createUserID}">
		<input type="hidden" name="comDanEme.updateUserID" value="${comDanEme.updateUserID}">
		<input type="hidden" name="comDanEme.deptId" value="${comDanEme.deptId}">
		<input type="hidden" name="comDanEme.delFlag" value="${comDanEme.delFlag}">
		<input type="hidden" name="comDanEme.linkId" value="${comDanEme.linkId}">
			<table width="100%" border="0">
				<tr>
					<th width="15%">应急处置名称</th>
					<td width="35%">
						<input id="yjname" name="comDanEme.emergencyName" style="width:60%" value="${comDanEme.emergencyName}" type="text" datatype="*1-127" errormsg='应急处置名称必须是1到127位字符！' nullmsg='应急处置名称不能为空！' sucmsg='应急处置名称填写正确！'  maxlength="127" onclick="queryQy()"><font style='color:red'>*</font>
						<input type="hidden" id="yjid" name="emePla.id" value="${emePla.id}"/>
					</td>
					<th width="15%">重点危险源名称</th>
					<td width="35%"><input id="dangerName" style="width:60%" name="comDanEme.dangerName" value="${comDanEme.dangerName}" type="text" datatype="*1-127" errormsg='重点危险源必须是1到127位字符！' nullmsg='重点危险源不能为空！' sucmsg='重点危险源填写正确！'  maxlength="127"><font style='color:red'>*</font></td>
				</tr>
				<tr>
					<th width="15%">重点危险源类别</th>
					<td width="35%"><input name="comDanEme.dangerType" style="width:60%" value="${comDanEme.dangerType}" type="text"  maxlength="127"></td>
					<th width="15%">重点危险源级别</th>
					<td width="35%"><input name="comDanEme.dangerLevel" style="width:60%" value="${comDanEme.dangerLevel}" type="text"  maxlength="127"></td>
				</tr>
				<tr>
				   <th width="15%">应急处置内容</th>
					<td width="35%" colspan="3"><textarea name="comDanEme.emergencyContent" style="width:96%;height:60px" onKeyDown="if(this.value.length > 2000) this.value=this.value.substr(0,2000)">${comDanEme.emergencyContent}</textarea></td>
				</tr>
				<tr>
					<th width="15%">备注</th>
					<td width="35%" colspan="3"><textarea onKeyDown="if(this.value.length > 2000) this.value=this.value.substr(0,2000)" name="comDanEme.remark" style="width:96%;height:60px">${comDanEme.remark}</textarea></td>
				</tr>
				<tr>
					<th width="15%">附件上传</th>
					<td width="85%" colspan="3">
				   		<div id="fileQueue"/>
				    	<input type="file" name="uploadify" id="uploadify"/>
			    		<a href="javascript:jQuery('#uploadify').uploadifyUpload()">开始上传</a>&nbsp;
						<a href="javascript:jQuery('#uploadify').uploadifyClearQueue()">取消所有上传</a>
						<font style='color:red'>上传附件最大上限为50M</font>
				    </td>
				</tr>
				<tr>
					<th width="15%">已添加附件</th>
					<td width="85%" colspan="3 style="padding:0 0 0 0;">
						<div style="color:green;overflow:auto;height:175px;">
						<table id="zdwxyyjczfj">
							  <c:forEach var="item" items="${picList}">
								<tr id='${item.id}' style="text-align: center">
								   <td width="70%">
								   		<c:choose>
											<c:when test="${fn:endsWith(fn:toLowerCase(item.picName),'.jpg')
											||fn:endsWith(fn:toLowerCase(item.picName),'.bmp')
											||fn:endsWith(fn:toLowerCase(item.picName),'.png')
											||fn:endsWith(fn:toLowerCase(item.picName),'.jpeg')
											||fn:endsWith(fn:toLowerCase(item.picName),'.gif')}"> 
												<img src="${item.httpUrl}/upload/photo/${item.picName}"
												border='0' width='220' height='150'/><br>&nbsp;&nbsp;&nbsp;${item.fileName}
											</c:when> 
											<c:otherwise> 
												&nbsp;&nbsp;&nbsp;${item.fileName}
											</c:otherwise>
										</c:choose>
								   </td>
								   <td width="30%"><a href="javascript:downloadFile('${item.id}');">下载</a>&nbsp;&nbsp;
								   <a href="javascript:del('${item.id}');">删除</a></td>
								</tr>
							  </c:forEach>
						</table>
						</div>
					</td>
				</tr>
				<tr>
					<td colspan="4" height="100px" style="text-align:center">
						<s:if test="flag=='add'">
							<a href="#" class="btn_01" type="submit" >添加<b></b></a>&nbsp;
						</s:if>
						<s:else>
							<a href="#" class="btn_01" type="submit" >更新<b></b></a>&nbsp;
						</s:else>						
 					</td>
				</tr>
			</table>
	</form>
	</div></div></div>
</body>
</html>
