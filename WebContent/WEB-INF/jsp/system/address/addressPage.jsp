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
				<form method="post" name="myform">
				<table width="100%" border="1" rules="all">
					<tr>
						<td width="45%" align="center">待选</td>
						<td width="10%"></td>
						<td width="45%" align="center">已选</td>
					</tr>
					<tr height="300px">
						<td width="45%" height="320px">
							<select style="WIDTH:100%;height: 100%" multiple name="list1" size="12" ondblclick="moveOption(document.myform.list1, document.myform.list2)"> 
	                            <option value="北京">北京</option> 
	                            <option value="上海">上海</option> 
	                            <option value="山东">山东</option> 
	                            <option value="安徽">安徽</option> 
	                            <option value="重庆">重庆</option> 
	                            <option value="福建">福建</option> 
	                            <option value="甘肃">甘肃</option> 
	                            <option value="广东">广东</option> 
	                            <option value="广西">广西</option> 
	                            <option value="贵州">贵州</option> 
	                            <option value="海南">海南</option> 
	                            <option value="河北">河北</option> 
	                            <option value="黑龙江">黑龙江</option> 
		                    </select>
						</td>
						<td width="10%">
							<input type="button" value="添加" onclick="moveOption(document.myform.list1, document.myform.list2)">
			                <br/> 
			                <br/> 
			                <input type="button" value="删除" onclick="moveOption(document.myform.list2, document.myform.list1)">
						</td>
						<td width="45%" height="320px">
							<select style="WIDTH:100%;height: 100%" multiple name="list2" size="12" ondblclick="moveOption(document.myform.list2, document.myform.list1)"> 
               				</select>
						</td>
					</tr>
					<tr>
						<td colspan="3">
							值：<input type="text" name="city" size="40">
							<button>确定</button>
							<button>取消</button>
						</td>
					</tr>
				</table>
				</form>
			</div>
		</div>
		</div>
	
	<script type="text/javascript" src="<%=basePath%>common/js/system/organization/organizationListPage.js"></script>
	<script type="text/javascript" src="<%=basePath%>common/js/system/address/addressPage.js"></script>
</body>
</html>