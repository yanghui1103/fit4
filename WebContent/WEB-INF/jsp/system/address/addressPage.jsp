<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%><jsp:include page="/common.jsp" />
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
		<div class="container">
			<div class="left-tree">
			<label class="kv-label">关键词:</label><input type="text" id="key" value="" class="empty" />
				<div style="display:none">
	 			<input type="radio" id="name" name="keyType" class="radio first" checked />
					<input type="radio" id="getNodesByParamFuzzy" name="funType" class="radio" style="margin-left:36px;" checked />
				</div>
				<div class="zTreeDemoBackground left">
					<ul id="orgTree" class="ztree"></ul>
				</div>
			</div>
			<div class="content">
			<div style="width: 100%;">
				<div align="center">
					<label class="kv-label">关键词:</label>
					<input type="text" id="key" value="" class="empty" /><br>
					<input type="checkbox"><label class="kv-label">组织</label>
					<input type="checkbox"><label class="kv-label">岗位</label>
					<input type="checkbox"><label class="kv-label">账户</label>
				</div>
				<form name="myform">
				<table width="100%" border="1" rules="all">
					<tr>
						<td width="45%" align="center">待选</td>
						<td width="10%"></td>
						<td width="45%" align="center">已选</td>
					</tr>
					<tr height="300px">
						<td width="45%" height="320px">
							<select style="WIDTH:100%;height: 100%" name="list1" size="12" ondblclick="moveOption(document.myform.list1, document.myform.list2)"> 
	                            <c:forEach items="${selectMap }" var="sm">
	                           		<option value="${sm.key }">${sm.value }</option> 
	                            </c:forEach>
		                    </select>
						</td>
						<td width="10%">
							<input type="button" value="添加" onclick="moveOption(document.myform.list1, document.myform.list2)">
			                <br/> 
			                <br/> 
			                <input type="button" value="删除" onclick="moveOption(document.myform.list2, document.myform.list1)">
						</td>
						<td width="45%" height="320px">
							<select style="WIDTH:100%;height: 100%" name="list2" size="12" ondblclick="moveOption(document.myform.list2, document.myform.list1)"> 
               					<option value="105000">信息公司</option>
               				</select>
						</td>
					</tr>
					<tr>
						<td colspan="3">
							<input id="selectids" type="hidden" name="selectids" size="40">
							<input id="selectnames" type="hidden" name="selectnames" size="40">
							<button type=button onclick="callBakcAddressValues();">确定</button>
							<button type=button>取消</button>
						</td>
					</tr>
				</table>
				</form>
			</div>
		</div>
		</div>
	
	<script type="text/javascript" src="<%=basePath%>common/js/system/organization/organizationListPage.js"></script>
</body>
</html>