<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%><jsp:include page="/common.jsp" />
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
		</div>
	
	<script type="text/javascript" src="<%=basePath%>common/js/system/organization/organizationListPage.js"></script>
	<script type="text/javascript" src="<%=basePath%>common/js/system/address/addressPage.js"></script>
</body>
</html>