<%@page language="java" pageEncoding="UTF-8"%>
<%@include file="/common/header.jsp"%>
<%@taglib prefix="cus" uri="/WEB-INF/tld/customized-tags.tld"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<title>查看</title>
	<%@include file="/common/jsLib.jsp"%>
	<script>
		function savepic(i){
        	window.location.href="${ctx}/jsp/zywsxzxk/zywsxzxkSaveFile.action?picName="+i;
		}
		
		
		function init1()
        {
	        if($('#isCaiLiao').val()==1)
			{
			    document.getElementById("showCaiLiao").innerHTML="是";
			}else if($('#isCaiLiao').val()==0)
			{
			    document.getElementById("showCaiLiao").innerHTML="否";
			}
			
	        if($('#isCunChu').val()==1)
			{
			    document.getElementById("showCunChu").innerHTML="是";
			}else if($('#isCunChu').val()==0)
			{
			    document.getElementById("showCunChu").innerHTML="否";
			}
		}
	</script>
</head>
<body>
<%@include file="/WEB-INF/template/content_title.jsp"%>
	<form name="myform" method="post">
	
	<input type="hidden" id="isCaiLiao" name="zywsxzxk.isCaiLiao" value="${zywsxzxk.isCaiLiao}">
	<input type="hidden" id="isCunChu" name="zywsxzxk.isCunChu" value="${zywsxzxk.isCunChu}">
	
		<div class="submitdata">
			<table width="100%">
				<tr>
					<th width="15%">所在镇</th>
					<td width="35%">${zywsxzxk.szzname}</td>
					<th width="15%">企业名称</th>
					<td width="35%">${zywsxzxk.qymc}</td>
				</tr>
				
				<!-- lj 2014-06-30  start-->
				
				<tr>
					<th width="15%">
						<s:if test="zywsxzxk.type == 3">
							评价单位
						</s:if>	
						<s:if test="zywsxzxk.type == 2">
							设计单位
						</s:if>	
						<s:else>
							评价机构
						</s:else>	
					</th>
					<td width="35%">
						${zywsxzxk.pjjg}
					</td>
				</tr>
				<tr>	
					<th width="15%" >材料接收人员</th>
					<td width="35%" colspan="3">
					 ${zywsxzxk.cljsry} 
					</td>
				</tr>
				
				<tr>	
					<th width="15%" >材料审查人员</th>
					<td width="35%" colspan="3">
					 ${zywsxzxk.clscry} 
					</td>
				</tr>
				<s:if test="zywsxzxk.type == 4 || zywsxzxk.type == 2 || zywsxzxk.type == 1">
				<tr>	
					<th width="15%" >档案编号</th>
					<td width="35%" colspan="3">
					 ${zywsxzxk.fileId} 
					</td>
				</tr>
				</s:if>
				
				<s:if test="zywsxzxk.type == 3 || zywsxzxk.type == 2 || zywsxzxk.type == 1">
				<tr>
					<th width="15%">行业类别</th>
					<td width="35%">
						<cus:hxlabel codeName="企业行业分类" itemValue="${zywsxzxk.hyfl}" />	
					</td>
					<th width="15%">项目性质</th>
					<td width="35%">
						<s:if test="zywsxzxk.xmxz == 3">
							扩建
						</s:if>	
						<s:if test="zywsxzxk.xmxz == 2">
							改建
						</s:if>	
						<s:if test="zywsxzxk.xmxz == 1">
							新建
						</s:if>
					</td>	
					
				</tr>
				
				<tr>
					<th width="15%">项目内容</th>
					<td  colspan="3">
					
					${zywsxzxk.projectContent}
								
					</td>
				</tr>
				<s:if test="zywsxzxk.type == 3 || zywsxzxk.type == 2 || zywsxzxk.type == 1">
				<tr>
					<th width="15%">职业病危害风险分类</th>
					<td  colspan="3">
						<s:if test="zywsxzxk.fxfl == 1">
							一般
						</s:if>	
						<s:if test="zywsxzxk.fxfl == 2">
							较重
						</s:if>	
						<s:if test="zywsxzxk.fxfl == 3">
							严重
						</s:if>
					</td>
				</tr>
				</s:if>
				<s:if test="zywsxzxk.fxfl != 1">
				<tr>
					<th width="15%">
						<s:if test="zywsxzxk.type == 3">
							验收专家
						</s:if>	
						<s:if test="zywsxzxk.type == 2">
							审查专家
						</s:if>	
						<s:if test="zywsxzxk.type == 1">
							审查专家
						</s:if>	
					</th>
					<td width="35%">
						${zywsxzxk.yszj}
					</td>
					<th width="15%">
						<s:if test="zywsxzxk.type == 3">
							验收日期
						</s:if>	
						<s:if test="zywsxzxk.type == 2">
							审查日期
						</s:if>	
						<s:if test="zywsxzxk.type == 1">
							审查日期
						</s:if>	
					</th>
					<td width="35%">
						${zywsxzxk.ysrq}
					</td>
				</tr>
				<s:if test="zywsxzxk.type == 1">
				<tr>
					<th width="15%">审查结果</th>
					<td  colspan="3">
					
					${zywsxzxk.scjg}
								
					</td>
				</tr>
				</s:if>
				</s:if>	
				
				<tr>
					<th width="15%">审批编号</th>
					<td width="35%">
						${zywsxzxk.spbh}
					</td>
					<th width="15%">审批日期</th>
					<td width="35%">
						${zywsxzxk.sprq}
					</td>
				</tr>
				</s:if>
				<s:else>
					<tr>
					<th width="15%">材料接收日期</th>
					<td width="35%">
						${zywsxzxk.jsrq}
					</td>
					<th width="15%">材料上报市局日期</th>
					<td width="35%">
						${zywsxzxk.sjrq}
					</td>
				</tr>
				</s:else>
				
				<tr>
					<th width="15%">本次领证情况</th>
					<td  colspan="3">
					 ${zywsxzxk.bclzqk} 
					</td>
				 
				</tr>
				
				<!-- end -->
				<!-- start  lj 2014-07-07 
				<tr>
					<th width="15%">申请材料是否齐全</th>
					<td width="35%" id="showCaiLiao">
					
                     	
					</td>
					<th width="15%">签字领导</th>
					<td width="35%">
					${zywsxzxk.qzld}
					</td>
				</tr>
				
				<tr>
					<th width="15%">乡镇预审意见</th>
					<td  colspan="3">
					 ${zywsxzxk.xzysyj} 
								
					</td>
				 
				</tr>
				<tr>
					<th width="15%">现场核查部门</th>
					<td  colspan="3">
					${zywsxzxk.xchcbm}
				
					</td>
				 
				</tr>
				
				<tr>
					<th width="15%">核查结论</th>
					<td  colspan="3">
					 ${zywsxzxk.hcjl} 
					</td>
				 
				</tr>
				
				<tr>
					<th width="15%">是否储存涉及</th>
					<td  colspan="3" id="showCunChu">
					
					</td>
				 
				</tr>
				
				<tr>
					<th width="15%">材料审查情况</th>
					<td  colspan="3">
					 ${zywsxzxk.clscqk} 
					</td>
				 
				</tr>
				
				<tr>
					<th width="15%">行政许可建议</th>
					<td  colspan="3">
					 ${zywsxzxk.xzxkjy} 
					</td>
				 
				</tr>
				
				
				<tr>
					<th width="15%">局会审记录</th>
					<td  colspan="3">
				 ${zywsxzxk.jhsjl} 
					</td>
				 
				</tr>
				
				-->
				<tr>
					<th width="15%">
						<s:if test="zywsxzxk.type == 1">
							职业病危害预评价报告
						</s:if>
						<s:elseif test="zywsxzxk.type == 2">
							职业病防护设施设计专篇
						</s:elseif>
						<s:elseif test="zywsxzxk.type == 3">
							职业病防护设施竣工验收报告
						</s:elseif>
						<s:else>
							职业病危害控制效果评价报告
						</s:else>
					</th>
					<td width="85%" colspan="3">
					  	<div style="color:green;overflow:auto; height:200px;">
						    <table width="100%">
							    <tr>
									<s:iterator id="taskPic" value="%{picList1}" status="sta">
										<s:if test="#sta.index%4 eq 0">
											</tr>
										</s:if>
										<td>
											<a href="javascript:savepic('<s:property value="#taskPic.id"/>')" title="点击下载">
												<s:property value="#taskPic.fileName" />
											</a>
										</td>
										<s:if test="#sta.last"><br/></tr></s:if>
									</s:iterator>
							    </tr>
							</table>
						</div>
					</td>
				</tr>
				
				<tr>
					<th width="15%">
						<s:if test="zywsxzxk.type == 1">
							职业病危害预评价报告专家审查意见及审查会签到表
						</s:if>
						<s:elseif test="zywsxzxk.type == 2">
							职业病防护设施设计专家审查意见及审查会签到表
						</s:elseif>
						<s:elseif test="zywsxzxk.type == 3">
							职业病防护设施竣工验收报告专家审查意见及审查会签到表
						</s:elseif>
						<s:else>
							其它申报材料
						</s:else>
					</th>
					<td width="85%" colspan="3">
					  	<div style="color:green;overflow:auto; height:200px;">
						    <table width="100%">
							    <tr>
									<s:iterator id="taskPic" value="%{picList2}" status="sta">
										<s:if test="#sta.index%4 eq 0">
											</tr>
										</s:if>
										<td>
											<a href="javascript:savepic('<s:property value="#taskPic.id"/>')" title="点击下载">
												<s:property value="#taskPic.fileName" />
											</a>
										</td>
										<s:if test="#sta.last"><br/></tr></s:if>
									</s:iterator>
							    </tr>
							</table>
						</div>
					</td>
				</tr>
				
				<tr>
					<th width="15%">
						<s:if test="zywsxzxk.type == 1">
							建设项目职业病危害预评价报告备案通知书或审批文件
						</s:if>
						<s:elseif test="zywsxzxk.type == 2">
							建设项目职业病防护设施安监部门的审批文件
						</s:elseif>
						<s:elseif test="zywsxzxk.type == 3">
							建设项目职业病防护设施竣工验收报告备案通知书或审批文件
						</s:elseif>
						<s:else>
							区安监局行政许可审查表
						</s:else>
					</th>
					<td width="85%" colspan="3">
					  	<div style="color:green;overflow:auto; height:200px;">
						    <table width="100%">
							    <tr>
									<s:iterator id="taskPic" value="%{picList3}" status="sta">
										<s:if test="#sta.index%4 eq 0">
											</tr>
										</s:if>
										<td>
											<a href="javascript:savepic('<s:property value="#taskPic.id"/>')" title="点击下载">
												<s:property value="#taskPic.fileName" />
											</a>
										</td>
										<s:if test="#sta.last"><br/></tr></s:if>
									</s:iterator>
							    </tr>
							</table>
						</div>
					</td>
				</tr>
				<!-- 
				<tr>
					<th width="15%">审核记录</th>
					<td width="85%" colspan=3>
						<table>
							<s:iterator  value="shenheList" status="sta">
		    					<tr>
		    	 					<th> ${sta.index+1}</th>
		    	 					<td><s:property  /></td>
		    					</tr>
							</s:iterator>
						</table>
					</td>
				</tr>
				<tr>
					<th width="15%">审核人</th>
					<td width="35%">${zywsxzxk.shusername}</td>
					<th width="15%">审核结果</th>
					<td width="35%">
						<s:if test="zywsxzxk.state == 1">
							待审核
						</s:if>
						<s:elseif test="zywsxzxk.state == 2">
							审核不通过
						</s:elseif>
						<s:else>
							审核通过
						</s:else>
					</td>
				</tr>
				<tr>
					<th width="15%">审核备注</th>
					<td width="85%" colspan=3>
						<textarea id="remark" name="zywsxzxk.remark" rows="5" style="width: 80%" readonly="readonly">${zywsxzxk.remark}</textarea>
					</td>
				</tr>
				 -->
				 <c:if test="${ifzsqy==0}">
					<tr>
						<th width="15%" style="color:red"></th>
						<td width="100%" colspan="4">
							<font style="color:red">县级审核:</font>
							<c:if test="${xjshState==1}">
								&nbsp;&nbsp;&nbsp;通过
							</c:if>
							<c:if test="${xjshState==2}">
								&nbsp;&nbsp;&nbsp;未通过
							</c:if>
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<font style="color:red">备注:</font>&nbsp;&nbsp;&nbsp;${xjBack}
						</td>
					</tr>
					</c:if>
					<tr>
						<th width="15%" style="color:red"></th>
						<td width="100%" colspan="4">
							<font style="color:red">市级审核:</font>
							<c:if test="${sjshState==1}">
								&nbsp;&nbsp;&nbsp;通过
							</c:if>
							<c:if test="${sjshState==2}">
								&nbsp;&nbsp;&nbsp;未通过
							</c:if>
							&nbsp;&nbsp;&nbsp;&nbsp;
							<font style="color:red">备注:</font>&nbsp;&nbsp;&nbsp;${sjBack}
						</td>
					</tr>
				<tr>
					<td colspan="4" height="100px" style="text-align:center">
					    <a href="#" class="easyui-linkbutton" iconCls="icon-cancel" onclick="window.close();">关闭</a>
					</td>
				</tr>
			</table>
		</div>
	</form>
<%@include file="/WEB-INF/template/pagefoot.jsp"%>
</body>
</html>
