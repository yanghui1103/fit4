<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script type="text/javascript"
	src="<%=basePath%>common/fit/v4/common/common.js"></script>
<link href="<%=basePath%>common/fit/v4/static/lightblue/css/base.css"
	rel="stylesheet">
<link
	href="<%=basePath%>common/fit/v4/custom/lightblue/uimaker/easyui.css"
	rel="stylesheet">
<link href="<%=basePath%>common/fit/v4/static/lightblue/css/index.css"
	rel="stylesheet">
<link
	href="<%=basePath%>common/fit/v4/static/lightblue/css/basic_info.css"
	rel="stylesheet">
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>common/fit/v4/custom/lightblue/uimaker/icon.css">
<script type="text/javascript"
	src="<%=basePath%>common/fit/v4/js/jquery.min.js"></script>
<script type="text/javascript"
	src="<%=basePath%>common/fit/v4/js/jquery.easyui.min.js"></script>

</head>
<body>
	<div class="easyui-tabs1" style="width: 100%;">
		<div class="column">
			<span class="current">功能权限信息</span>
		</div>
		<div class="easyui-panel"
			style="width: 100%; max-width: 900px; padding: 30px 60px;">
			<div style="margin-bottom: 20px">
			<select class="easyui-combogrid"  name="type"  editable="false" style="width:80%"  data-options="limitToList:true,
					panelWidth: 500,
					idField: 'id',
					textField: 'name',
					url: '<%=basePath%>role/authsOfRole/${param }',
					method: 'get', 
					columns: [[
						{field:'id',title:'值',width:50},
						{field:'name',title:'名称',width:140} 
					]],
					fitColumns: true, 
					required:true
				">
			</select>	
			</div>
		</div>
	</div>
</body>
</html>