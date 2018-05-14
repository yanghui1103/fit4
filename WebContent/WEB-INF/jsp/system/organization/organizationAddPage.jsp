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
<script type="text/javascript" src="<%=basePath%>common/js/system/organization/organizationAddPage.js"></script>
</head>
<body>
	<div style="float: right;margin-right:30px;margin-top:5px" >
		<button class="easyui-linkbutton" type=button iconCls="icon-add" data-options="selected:true"
			onclick="addOrg();" style="width: 150px">保存</button>
	</div>
	
	<div style="margin:30px 0px;"></div>
	<form id="orgAddFm"  class="easyui-form" method="post"
		data-options="novalidate:false">
		
		<div style="margin-bottom: 20px;margin-left: 90px">  
			<div>组织编码</div>
			<input class="easyui-textbox"  name="code" style="width: 80%;paddding-right:2px"  
				data-options="required:true,validType:['length[0,20]']">
		</div>
		<div style="margin-bottom: 20px;margin-left: 90px">  
			<div>组织名称</div>
			<input class="easyui-textbox" name="name" style="width: 80%;paddding-right:2px"  
				data-options="required:true,validType:['length[0,30]']">
		</div>
		<div style="margin-bottom: 20px;margin-left: 90px">  
			<div>组织简称</div>
			<input class="easyui-textbox" name="simpleName" style="width: 80%;paddding-right:2px"  
				data-options="required:true,validType:['length[0,20]']">
		</div>
		<div style="margin-bottom: 20px;margin-left: 90px">  
			<div>类型</div>
			<input class="easyui-textbox" name="type" style="width: 80%;paddding-right:2px"  
				data-options="required:true">
		</div>
		<div style="margin-bottom: 20px;margin-left: 90px">  
			<div>父组织</div>
			<input class="easyui-textbox" name="parentId" style="width: 80%;paddding-right:2px"  
				data-options="required:true">
		</div>
		<div style="margin-bottom: 20px;margin-left: 90px">  
			<div>地址薄显示与否</div>
			<select id="cc" class="easyui-combobox" name="isVisible"
				style="width: 80%;paddding-right:2px"  >
				<option value="1">是</option>
				<option value="0">否</option>
			</select>
		</div>
		
		<div style="margin-bottom: 20px;margin-left: 90px">  
			<div>法人/负责人</div>
			<input class="easyui-textbox" name="adminer" style="width: 80%;paddding-right:2px"  
				data-options="required:true">
		</div>
		
		<div style="margin-bottom: 20px;margin-left: 90px">  
			<div>联系电话</div>
			<input class="easyui-textbox" name="phone" style="width: 80%;paddding-right:2px"  
				data-options="required:true">
		</div>
		
		<div style="margin-bottom: 20px;margin-left: 90px">  
			<div>地址</div>
			<input class="easyui-textbox" name="address" style="width: 80%;paddding-right:2px"  
				data-options="">
		</div>
		
		<div style="margin-bottom: 20px;margin-left: 90px">  
			<div>邮编</div>
			<input class="easyui-textbox" name="postCode" style="width: 80%;paddding-right:2px"  
				data-options="">
		</div>
		
		<div style="margin-bottom: 20px;margin-left: 90px">  
			<div>组织简介</div>
			<input class="easyui-textbox" name="summary" style="width: 80%;paddding-right:2px"  
				data-options="multiline:true">
		</div>
		
		
	</form>	
	
	
</body>
</html>