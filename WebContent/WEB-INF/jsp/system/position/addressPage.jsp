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
	<link rel="stylesheet" href="<%=basePath%>common/ztree/css/zTreeStyle/zTreeStyle.css" type="text/css">
	<script type="text/javascript" src="<%=basePath%>common/ztree/js/jquery.ztree.core.js"></script>
<script type="text/javascript">
var setting = {
		data: {
			simpleData: {
				enable: true
			}
		}
	};

	var zNodes =[
		{ id:1, pId:0, name:"父节点1 - 展开", open:true},
		{ id:11, pId:1, name:"父节点11 - 折叠"},
		{ id:111, pId:11, name:"叶子节点111"},
		{ id:112, pId:11, name:"叶子节点112"},
		{ id:113, pId:11, name:"叶子节点113"},
		{ id:114, pId:11, name:"叶子节点114"},
		{ id:12, pId:1, name:"父节点12 - 折叠"},
		{ id:121, pId:12, name:"叶子节点121"},
		{ id:122, pId:12, name:"叶子节点122"},
		{ id:123, pId:12, name:"叶子节点123"},
		{ id:124, pId:12, name:"叶子节点124"},
		{ id:13, pId:1, name:"父节点13 - 没有子节点", isParent:true},
		{ id:2, pId:0, name:"父节点2 - 折叠"},
		{ id:21, pId:2, name:"父节点21 - 展开", open:true},
		{ id:211, pId:21, name:"叶子节点211"},
		{ id:212, pId:21, name:"叶子节点212"},
		{ id:213, pId:21, name:"叶子节点213"},
		{ id:214, pId:21, name:"叶子节点214"},
		{ id:22, pId:2, name:"父节点22 - 折叠"},
		{ id:221, pId:22, name:"叶子节点221"},
		{ id:222, pId:22, name:"叶子节点222"},
		{ id:223, pId:22, name:"叶子节点223"},
		{ id:224, pId:22, name:"叶子节点224"},
		{ id:23, pId:2, name:"父节点23 - 折叠"},
		{ id:231, pId:23, name:"叶子节点231"},
		{ id:232, pId:23, name:"叶子节点232"},
		{ id:233, pId:23, name:"叶子节点233"},
		{ id:234, pId:23, name:"叶子节点234"},
		{ id:3, pId:0, name:"父节点3 - 没有子节点", isParent:true}
	];

	$(document).ready(function(){
		alert("2222");
	});
</script>
</head>
<body>
	<div class="container">
		<div class="left-tree">
		<label class="kv-label">组织名称:</label><input type="text" id="key" value="" class="empty" />
			<div style="display:none">
 			<input type="radio" id="name" name="keyType" class="radio first" checked />
				<input type="radio" id="getNodesByParamFuzzy" name="funType" class="radio" style="margin-left:36px;" checked />
			</div>
			<div class="zTreeDemoBackground left">
				<ul id="treeDemo" class="ztree"></ul>
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
	
</body>

</html>