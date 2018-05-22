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
			<div class="content">
			<div style="width: 100%;">
				<div align="center">
					<label class="kv-label">关键词:</label>
					<input type="text" id="key" value="" class="empty" /><br>
					<input type="checkbox"><label class="kv-label">组织</label>
					<input type="checkbox"><label class="kv-label">岗位</label>
					<input type="checkbox"><label class="kv-label">账户</label>
				</div>
				<table width="100%" border="1" rules="rows">
					<tr>
						<td width="40%" align="center">待选</td>
						<td width="20%"></td>
						<td width="40%" align="center">已选</td>
					</tr>
					<tr height="300px">
						<td width="40%" align="center"></td>
						<td width="20%">
							<button>添加</button><br>
							<button>删除</button>
						</td>
						<td width="40%" align="center"></td>
					</tr>
					<tr>
						<td colspan="3">
							<button>确定</button>
							<button>取消</button>
						</td>
					</tr>
				</table>
			</div>
		</div>
		</div>
	
	<script type="text/javascript" src="<%=basePath%>common/js/system/organization/organizationListPage.js"></script>
	<script type="text/javascript" src="<%=basePath%>common/js/system/address/addressPage.js"></script>
</body>
</html>