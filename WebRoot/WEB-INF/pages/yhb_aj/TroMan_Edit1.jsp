﻿<%@page language="java" pageEncoding="UTF-8" isELIgnored="false"%>
<%@include file="/common/header.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title><s:if test="flag=='add'">新增</s:if><s:else>修改</s:else>记录</title>
	<%@include file="/common/jsLib.jsp"%>
	<script>
		function saveSelText(i,text){
			$("#"+i).val(text);
		}
		function queryQy()
		{
			var szzid = document.getElementById('areaId').value;
			popupCenter("${ctx}/jsp/qyjbxx/queryCompanyList.action?flag=idmcqy&entBaseInfo.enterprisePossession="+szzid, "setCompany", "800", "600", "no", "no", "no", "no", "no","no");
		}
		function clearCompany(){
        	document.getElementById("companyName").value="";
        	document.getElementById("companyId").value="";
        }
        
        $(document).ready(function() {
		  uploadPic("uploadify","${troMan.linkId}","troMan","troManfj","fileQueue");
		  //ifNeedAjChange();
		});
		
		
		function ifNeedAjChange(){
			var result=$("#ifNeedAj").val();
			if("0"==result){
				document.getElementById("bmtd").style.display="";
				document.getElementById("bmth").style.display="";
			}else{
				document.getElementById("bmtd").style.display="none";
				document.getElementById("bmth").style.display="none";
			}
		
		}
		
		function bmtdChange(){
			var bmId=$("#dealDeptId").val();
			if(bmId=='002001'){
				$("#ifNeedAj").val(1);
			}else{
				$("#ifNeedAj").val(0);
			}
		}
	</script>
</head>

<body validform="true" style="overflow: auto;">
   <div class="box_01 boxBmargin12 submitdata" style="overflow-y: auto;overflow-x: hidden;padding: 0;top: 0px;left: 0px;right: 0px;bottom: 0;position: absolute; ">
		<div class="inner6px">
			<div class="cell" style="width: 100%">
	<form name="myform1" method="post" enctype="multipart/form-data" action="troManSaveAJ.action">
		<s:token />
		<input type="hidden" name="flag" value="${flag}">
		<input type="hidden" name="troMan.taskId" value="${troMan.taskId}">
		<input type="hidden" name="troMan.id" value="${troMan.id}">
		<input type="hidden" name="troMan.createTime" value="<fmt:formatDate type="both" value="${troMan.createTime}" />">
		<input type="hidden" name="troMan.updateTime" value="${troMan.updateTime}">
		<input type="hidden" name="troMan.createUserID" value="${troMan.createUserID}">
		<input type="hidden" name="troMan.updateUserID" value="${troMan.updateUserID}">
		<input type="hidden" name="troMan.deptId" value="${troMan.deptId}">
		<input type="hidden" name="troMan.delFlag" value="${troMan.delFlag}">
		<input name="troMan.linkId" value="${troMan.linkId}" type="hidden" maxlength="127">
		<input id="deptName" name="troMan.dealDeptName" value="${troMan.dealDeptName}" type="hidden" maxlength="127">
		<input name="troMan.userId" value="${troMan.userId}" type="hidden" maxlength="127">
		<input name="troMan.userName" value="${troMan.userName}" type="hidden" maxlength="127">
		<input name="troMan.recfinishTime" value="<fmt:formatDate type='both'  pattern="yyyy-MM-dd" value='${troMan.recfinishTime}' />" type="hidden" class="Wdate" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})">	
		<input name="troMan.rectificationMoney" value="${troMan.rectificationMoney}" type="hidden" maxlength="127">	
		<input name="troMan.rectificationState" value="${troMan.rectificationState}" type="hidden" maxlength="127">
			
			<table width="100%" border="0">
				<tr>
					<th width="15%">隐患名称</th>
					<td width="35%">${troMan.troubleName}</td>
					<th width="15%">隐患来源</th>
					<td width="35%">${troMan.troubleSource}</td>
				</tr>
					<tr>
						<th width="15%">所在区域</th>
						<td width="35%"><cus:hxlabel codeName="企业属地" itemValue="${troMan.areaId}" /> </td>
						<th width="15%">企业名称</th>
						<td width="35%"> ${troMan.companyName} </td>
					</tr>
				
				<tr>
					<th width="15%">上报时间</th>
					<td width="35%"><fmt:formatDate  pattern="yyyy-MM-dd" type='both' value='${troMan.reportTime}' /></td>
					<th width="15%">隐患地点</th>
					<td width="35%">${troMan.troubleAdd}</td>
				</tr>
				<tr>
					<th width="15%">整改期限</th>
					<td width="35%"><fmt:formatDate  pattern="yyyy-MM-dd" type='both' value='${troMan.rectificationTerm}' /> </td>
					
					<th width="15%">检查项</th>
					<td width="35%"> <cus:hxlabel   codeSql="select t.row_id,PATROL_NAME from PAT_MAN t where t.delflag = 0"  itemValue="${troMan.checkItem}" /> </td>
				</tr>
				<tr>
					<th width="15%">隐患级别</th>
					<td width="35%"><cus:hxlabel codeName="隐患级别" itemValue="${troMan.troubleLevel}" />  </td>
					<th width="15%">隐患类别</th>
					<td width="35%"><cus:hxlabel codeName="隐患类别" itemValue="${troMan.troubleSort}" />  </td>
				</tr>
				<tr>
					<th width="15%">整改责任部门</th>
					<td width="35%">${troMan.rectDept}</td>
					<th width="15%">整改责任人</th>
					<td width="35%">${troMan.rectPerson}</td>
				</tr>
				<tr>
					<th width="15%">整改责任人联系方式</th>
					<td width="35%">${troMan.rectTel}</td>
				</tr>
				<tr>
					<th width="15%">隐患详情</th>
					<td width="35%" colspan="3">
						${troMan.introduce}
					</td>
				</tr>
				<tr>
					<th width="15%">整改前图片</th>
					<td width="85%" colspan="3" style="padding:0 0 0 0;">
						<div style="color:green;overflow:auto;height:175px;">
						<table>
							  <c:forEach var="item" items="${picList1}">
								<tr id='${item.id}' style="text-align: center">
								   <td width="70%">
								   		<c:choose>
											<c:when test="${fn:endsWith(fn:toLowerCase(item.picName),'.jpg')
											||fn:endsWith(fn:toLowerCase(item.picName),'.bmp')
											||fn:endsWith(fn:toLowerCase(item.picName),'.png')
											||fn:endsWith(fn:toLowerCase(item.picName),'.jpeg')
											||fn:endsWith(fn:toLowerCase(item.picName),'.gif')}"> 
											<a href="${item.httpUrl}/upload/photo/${item.picName}" rel="example_group">	
												<img src="${item.httpUrl}/upload/photo/${item.picName}"
												border='0' width='220' height='150'/>
											</a>
											</c:when> 
											<c:otherwise> 
												&nbsp;&nbsp;&nbsp;${item.fileName}
											</c:otherwise>
										</c:choose>
								   </td>
								   <td width="30%"><a href="javascript:downloadFile('${item.id}');">下载</a>&nbsp;&nbsp;</td>
								</tr>
							  </c:forEach>
						</table>
						</div>
					</td>
				</tr>
				
				<tr>
					<th   width="15%" id="bmth">处理职能部门</th>
					<td width="35%" id="bmtd">
						<cus:SelectOneTag style="width:60%" property="troMan.dealDeptId" dataType="*" defaultText='请选择' codeSql="select dept_code as id,dept_name as name  from department where del_flag = 0 and substring(DEPT_CODE,0,4)='002' and DEPT_CODE !='002'   and len(DEPT_CODE)=6 " value="${troMan.dealDeptId}"  onchange="bmtdChange()" />
						<font style="color:red">*</font><input type="hidden" id="ifNeedAj" name="troMan.ifNeedAj" value="0"/>
					</td>
				</tr>
				<tr>
					<td colspan="4" height="100px" style="text-align:center">
						<s:if test="flag=='add'">
							<a href="#" class="btn_01" type="submit" >添加<b></b></a>&nbsp;
						</s:if>
						<s:else>
							<a href="#" class="btn_01" type="submit" >提交<b></b></a>&nbsp;
						</s:else>						
						<a href="#" class="btn_01"  onclick="parent.close_win('win_troMan');">关闭<b></b></a>
					</td>
				</tr>
			</table>
	</form>
	</div></div></div>
</body>
</html>
